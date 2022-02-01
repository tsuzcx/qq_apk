package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import gps;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BindNumberFromPcActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  protected static final int a = 1;
  public Button a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public String b;
  private String c;
  
  private void b()
  {
    setTitle("验证手机号码");
    if (this.jdField_a_of_type_Boolean) {
      setLeftButton(2131367454, null);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298092));
    int i = this.jdField_a_of_type_JavaLangString.length();
    String str = this.jdField_a_of_type_JavaLangString.substring(0, i - 5) + "****" + this.jdField_a_of_type_JavaLangString.substring(i - 1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString + " " + str);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298091));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362560, new Object[] { this.c }));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298093));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298094));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void c()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131367136);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new gps(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    a(2131366988, 1000L);
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_change_number", true);
    localIntent.putExtra("key_is_first_activity", false);
    startActivityForResult(localIntent, 1);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130968592, 2130968748);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298093: 
      c();
      return;
    }
    d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903395);
    int i = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a();
    if ((i != 2) || (paramBundle == null))
    {
      a("请求错误", "请稍后重试");
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramBundle.nationCode;
    this.jdField_a_of_type_JavaLangString = paramBundle.mobileNo;
    this.c = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramBundle.bindingTime * 1000L));
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_is_first_activity", true);
    b();
  }
  
  protected void onDestroy()
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
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity
 * JD-Core Version:    0.7.0.1
 */