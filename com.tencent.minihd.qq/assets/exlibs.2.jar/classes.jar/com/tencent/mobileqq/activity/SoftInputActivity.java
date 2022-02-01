package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.widget.BackKeyEditText;
import fav;
import faw;
import fax;
import fay;
import faz;

public class SoftInputActivity
  extends Activity
{
  public static final String a = "clear_text";
  public static final String b = "hide_soft_panel";
  public static final String c = "action_edit_text_soft_input";
  private float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.jdField_a_of_type_Float + 0.5F);
  }
  
  private void a()
  {
    Log.i("app2", "hideSoftInputAndFinish");
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new fay(this), 20L);
  }
  
  private void a(Intent paramIntent)
  {
    int i = SizeMeasure.b(this) - a(144) - a(49);
    int j = a(40);
    int k = SizeMeasure.a(this) + a(72);
    int m = a(16);
    Log.i("app2", "width=" + i + " height=" + j + " x=" + k + " y=" + m);
    paramIntent = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramIntent.getAttributes();
    localLayoutParams.gravity = 51;
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    localLayoutParams.x = k;
    localLayoutParams.y = m;
    localLayoutParams.flags = 32;
    localLayoutParams.windowAnimations = 0;
    paramIntent.setAttributes(localLayoutParams);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new faz(this);
      IntentFilter localIntentFilter = new IntentFilter("clear_text");
      localIntentFilter.addAction("hide_soft_panel");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904435);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    b();
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new fav(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new faw(this));
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof BackKeyEditText)) {
      ((BackKeyEditText)this.jdField_a_of_type_AndroidWidgetEditText).setEditCallBack(new fax(this));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    paramBundle = getIntent().getStringExtra("text");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramBundle.length());
    }
    a(getIntent());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c();
  }
  
  protected void onStop()
  {
    super.onStop();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoftInputActivity
 * JD-Core Version:    0.7.0.1
 */