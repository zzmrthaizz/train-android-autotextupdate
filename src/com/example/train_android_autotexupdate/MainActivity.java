package com.example.train_android_autotexupdate;

import java.util.ArrayList;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	ListView ls;
	AutoCompleteTextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list.add("test");
		list.add("hot");
		list.add("thai");
		list.add("Ha noi");
		list.add("sai gon");
		list.add("hue");


		text = (AutoCompleteTextView) findViewById(R.id.autotext);
		Button nhap = (Button) findViewById(R.id.btnnhap);
		ls = (ListView) findViewById(R.id.listview);

		nhap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String textinput = String.valueOf(text.getText());
				input(textinput);
				text.setText("");

			}
		});

	}
	public void input(String textt) {
		list.add(textt);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		ls.setAdapter(adapter);
		text.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
