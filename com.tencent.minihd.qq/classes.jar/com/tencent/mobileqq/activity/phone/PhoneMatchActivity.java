package com.tencent.mobileqq.activity.phone;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import grd;
import gre;

public class PhoneMatchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private Button a;
  public ContactBindObserver a;
  
  private void b()
  {
    this.centerView.setText("通讯录");
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298118));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setLeftButton(2131367454, this);
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
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new grd(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.app.a(new gre(this));
    a(2131366988, 1000L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if ((paramBundle == null) && ((!this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.e()) || (!this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.d())))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.k();
    setContentViewB(2130903404);
    b();
    return true;
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968584);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      c();
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity
 * JD-Core Version:    0.7.0.1
 */