package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
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
import gpt;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final String a = "k_number";
  public int a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  
  public BindVerifyActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void c()
  {
    setTitle("验证手机号码");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298095));
    String str = getIntent().getStringExtra("k_number");
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362557, new Object[] { str }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298096));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298087));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_a_of_type_Boolean) {
        findViewById(2131298097).setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298089));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.b = ((TextView)findViewById(2131298090));
      this.b.setOnClickListener(this);
      return;
      if (1 == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362558, new Object[] { str }));
      }
    }
  }
  
  private void d()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131367136);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new gpt(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_Int);
    a(2131366988, 1000L);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    b();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() >= 4))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903396);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kBindType", 0);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("kShowAgree", false);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131298088: 
    case 2131298089: 
    default: 
      return;
    case 2131298087: 
      d();
      return;
    }
    paramView = new Intent(this, TosActivity.class);
    paramView.putExtra("frombusiness", 0);
    startActivity(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */