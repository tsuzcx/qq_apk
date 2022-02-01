package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import gpj;
import gpk;
import gpl;

public class BindNumberActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  static final int jdField_a_of_type_Int = 2;
  public static final String a = "key_change_number";
  private static final int jdField_b_of_type_Int = 1;
  public static final String b = "key_is_qqwifi";
  private static final int jdField_c_of_type_Int = 0;
  private static final int d = 2;
  private static final int jdField_e_of_type_Int = 3;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public EditText a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  public String d;
  private String jdField_e_of_type_JavaLangString;
  private int f;
  
  public BindNumberActivity()
  {
    this.jdField_c_of_type_JavaLangString = "+86";
    this.e = "中国";
  }
  
  private void b()
  {
    if (getIntent().getBooleanExtra("key_change_number", false)) {
      setTitle("更改手机号码");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        setLeftButton(2131365736, null);
      }
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298084));
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("首次使用QQWiFi功能时，需要验证你的手机号码并推荐绑定通讯录。");
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298085));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.e + " " + this.jdField_c_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298086));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298088);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298089));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("已同意");
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298090));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298087));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
      setTitle("验证手机号码");
    }
  }
  
  private void c()
  {
    this.d = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if ((this.jdField_c_of_type_JavaLangString.equalsIgnoreCase("+86")) && (this.d.length() != 11))
    {
      b(2131362556);
      return;
    }
    d();
  }
  
  private void d()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131367136);
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  private void e()
  {
    startActivityForResult(new Intent(this, CountryActivity.class), 1);
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this, TosActivity.class);
    localIntent.putExtra("frombusiness", 1);
    startActivity(localIntent);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.e = paramIntent.getStringExtra("k_name");
      this.jdField_c_of_type_JavaLangString = ("+" + paramIntent.getStringExtra("k_code"));
      paramIntent = this.e + " " + this.jdField_c_of_type_JavaLangString;
      localRect = new Rect();
      this.jdField_b_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramIntent, 0, paramIntent.length(), localRect);
      if (localRect.right > this.f) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      }
    }
    while ((paramInt1 != 2) || (paramInt2 == 0))
    {
      Rect localRect;
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramIntent);
      return;
    }
    setResult(paramInt2);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903393);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_is_first_activity", true);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_is_qqwifi", false);
    this.f = (getResources().getDimensionPixelSize(2131493535) - getResources().getDimensionPixelSize(2131493536));
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("kNeedUnbind", false);
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new gpj(this), 300L);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130968592, 2130968748);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 0: 
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new gpk(this);
      this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      paramMessage = (PhoneContactManager)this.app.getManager(10);
      a(2131366988, 1000L);
      paramMessage.d();
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new gpl(this);
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(this.jdField_c_of_type_JavaLangString, this.d);
      if (3 != paramMessage.what) {
        a(2131366988, 1000L);
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.jdField_a_of_type_AndroidWidgetButton;
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() > 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCompoundButton.setEnabled(paramBoolean);
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("已同意");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("未同意");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131298086: 
    case 2131298089: 
    default: 
      return;
    case 2131298085: 
      e();
      return;
    case 2131298087: 
      c();
      return;
    case 2131298090: 
      f();
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity
 * JD-Core Version:    0.7.0.1
 */