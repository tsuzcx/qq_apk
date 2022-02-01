package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import exm;
import mqq.observer.WtloginObserver;

public class RegisterPersonalInfoActivity
  extends RegisterBaseActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "RegisterPersonalInfoActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new exm(this);
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private ClearableEditText jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText;
  private String jdField_b_of_type_JavaLangString = "";
  private String c = null;
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        a(2131365730, 0);
        return;
      }
      paramView = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if ((TextUtils.isEmpty(paramView)) || (paramView.trim().length() == 0))
      {
        a(2131366916, 1);
        return;
      }
      try
      {
        a(2131366854);
        if (PhoneNumLoginImpl.a().a(this.app, this.jdField_b_of_type_JavaLangString.getBytes(), paramView.getBytes(), this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
        {
          e();
          a(2131366833, 1);
          return;
        }
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904071));
    setTitle(2131366884);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key_register_smscode");
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366374);
    this.d = getIntent().getStringExtra("phonenum");
    this.e = getIntent().getStringExtra("key");
    this.f = getIntent().getStringExtra("key_register_now_account");
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300741));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300747));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */