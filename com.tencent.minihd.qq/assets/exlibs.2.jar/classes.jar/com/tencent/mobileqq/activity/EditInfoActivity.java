package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import dwr;
import dws;
import dwt;
import dwu;
import dwx;
import java.io.UnsupportedEncodingException;

public class EditInfoActivity
  extends IphoneTitleBarActivity
{
  public int a;
  protected Drawable a;
  public Handler a;
  public EditText a;
  public TextView a;
  TroopObserver a;
  public QQProgressNotifier a;
  public String a;
  public boolean a;
  public int b;
  protected Drawable b;
  public String b;
  public int c;
  public String c;
  public String d;
  private String e = null;
  
  public EditInfoActivity()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = "0/0";
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new dwr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dwx(this);
  }
  
  private void a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297565));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    paramEditText.addTextChangedListener(new dwu(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131297348));
    }
    if (paramBoolean)
    {
      enableRightHighlight(false);
      if ((this.e != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838130);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    do
    {
      return;
      enableRightHighlight(true);
    } while ((this.e == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null));
    ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  private void e()
  {
    setContentView(2130903287);
    g();
  }
  
  private void f()
  {
    setContentView(2130903286);
    g();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297564));
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
      Selection.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), i);
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().getBytes("utf-8");
        this.jdField_b_of_type_JavaLangString = (arrayOfByte.length + "/" + this.jdField_c_of_type_Int);
        a(this.jdField_a_of_type_AndroidWidgetEditText);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      this.jdField_b_of_type_JavaLangString = ("0/" + this.jdField_c_of_type_Int);
    }
  }
  
  public void a()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
  }
  
  public void b()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  void c()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      setTitle(this.e);
      setRightHighlightButton(2131367064, new dwt(this));
      enableRightHighlight(true);
      return;
      e();
      continue;
      f();
    }
  }
  
  void d()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("type", -1);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("subtype", -1);
    this.e = localIntent.getStringExtra("title");
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("default");
    this.jdField_c_of_type_Int = localIntent.getIntExtra("num", 0);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("isTroopNick", false);
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("troopUin");
    this.d = localIntent.getStringExtra("uin");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    d();
    c();
    setContentBackgroundResource(2130837687);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dws(this), 500L);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    return true;
  }
  
  protected boolean onBackEvent()
  {
    b();
    return super.onBackEvent();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void onPause()
  {
    b();
    super.onPause();
  }
  
  protected void onResume()
  {
    a();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity
 * JD-Core Version:    0.7.0.1
 */