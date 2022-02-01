package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import gpq;
import gpr;

public class BindNumberDialogActivity
  extends DialogBaseActivity
{
  static final int jdField_a_of_type_Int = 2;
  protected static final String a = "BindNumberBusinessActivity";
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public ContactBindObserver a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  public String b;
  public boolean b;
  public String c;
  
  public BindNumberDialogActivity()
  {
    this.jdField_b_of_type_JavaLangString = "+86";
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, BindNumberDialogActivity.class);
    localIntent.putExtra("phone_number", paramString);
    localIntent.putExtra("cmd_param_bind_type", 1);
    localIntent.putExtra("unbind", paramBoolean);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void b()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131367136);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new gpr(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(this.jdField_b_of_type_JavaLangString, this.c, 1);
    a(2131366988, 1000L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("unbind", false);
      this.c = paramBundle.getStringExtra("phone_number");
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("cmd_param_bind_type", 0);
      paramBundle = (PhoneContactManager)this.app.getManager(10);
      if (this.jdField_b_of_type_Boolean) {
        break label153;
      }
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new gpq(this, paramBundle);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      paramBundle = (PhoneContactManager)this.app.getManager(10);
      if (NetworkUtil.e(this)) {
        break label123;
      }
      b(2131367136);
      finish();
    }
    label123:
    do
    {
      return true;
      paramBundle.c();
      a(2131365787, 0L);
    } while (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    return true;
    label153:
    BindNumberBusinessActivity.a(this, this.c, this.jdField_b_of_type_Boolean);
    finish();
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
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130968592, 2130968748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberDialogActivity
 * JD-Core Version:    0.7.0.1
 */