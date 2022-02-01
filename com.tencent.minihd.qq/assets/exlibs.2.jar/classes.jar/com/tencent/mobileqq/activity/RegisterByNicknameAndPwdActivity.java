package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import exi;
import exj;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterByNicknameAndPwdActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "RegisterByNicknameAndPwdActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new exj(this);
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private ClearableEditText jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText;
  private String jdField_b_of_type_JavaLangString = "";
  private String c = null;
  
  private boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label46;
      }
      int k = paramString.charAt(i);
      if ((k < 48) || (k > 57)) {
        break;
      }
      i += 1;
    }
    label46:
    return true;
  }
  
  private boolean b(String paramString)
  {
    return paramString.indexOf(" ") != -1;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366374);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300744));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new exi(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300741));
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297937));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, RegisterQQNumberActivity.class);
    localIntent.putExtra("phonenum", this.d);
    localIntent.putExtra("key", this.e);
    localIntent.putExtra("uin", this.c);
    localIntent.putExtra("key_register_now_account", this.f);
    localIntent.putExtra("key_register_sign", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("key_register_password", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText()));
    localIntent.putExtra("key_register_unbind", true);
    startActivity(localIntent);
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramEditable.toString()))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131365730, 0);
      return;
    }
    paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText());
    if (TextUtils.isEmpty(paramView))
    {
      a(2131366902, 1);
      return;
    }
    if (b(paramView))
    {
      a(2131366889, 1);
      return;
    }
    if (a(paramView))
    {
      if (paramView.length() < 9) {
        a(2131366887, 1);
      }
    }
    else if (paramView.length() < 6)
    {
      a(2131366888, 1);
      return;
    }
    String str = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((TextUtils.isEmpty(str)) || (str.trim().length() == 0))
    {
      a(2131366916, 1);
      return;
    }
    try
    {
      if (str.getBytes("utf-8").length > 24L)
      {
        a(2131366917, 1);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      PhoneNumLoginImpl.a().a(this.app, false);
      try
      {
        ((AccountManager)this.app.getManager(0)).sendRegisterBySetPass(paramView, str, this.jdField_b_of_type_JavaLangString, false, this.jdField_a_of_type_MqqObserverAccountObserver);
        a(2131366854);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904070));
    setTitle(2131366835);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key_register_smscode");
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    this.d = getIntent().getStringExtra("phonenum");
    this.e = getIntent().getStringExtra("key");
    this.f = getIntent().getStringExtra("key_register_now_account");
    c();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity
 * JD-Core Version:    0.7.0.1
 */