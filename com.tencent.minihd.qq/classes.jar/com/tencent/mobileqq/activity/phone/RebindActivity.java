package com.tencent.mobileqq.activity.phone;

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
import grh;

public class RebindActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  protected static final int a = 1;
  protected static final String a = "k_uin";
  protected static final String b = "k_number";
  protected static final String c = "k_country_code";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private int jdField_b_of_type_Int = 0;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public String d;
  private String e;
  
  private void b()
  {
    setTitle("验证手机号");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298119));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362555, new Object[] { this.d, getIntent().getStringExtra("k_uin"), this.app.a() }));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298120));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298121));
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
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new grh(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b(this.e, this.d, this.jdField_b_of_type_Int);
    a(2131366988, 1000L);
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
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      c();
    }
    while (paramView != this.jdField_b_of_type_AndroidWidgetButton) {
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903405);
    this.e = getIntent().getStringExtra("k_country_code");
    this.d = getIntent().getStringExtra("k_number");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("kBindType", 0);
    b();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.RebindActivity
 * JD-Core Version:    0.7.0.1
 */