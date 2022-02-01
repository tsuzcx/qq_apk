package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import gri;
import grj;
import grl;

public class SettingActivity2
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "SettingActivity2";
  private Button jdField_a_of_type_AndroidWidgetButton;
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private grl jdField_a_of_type_Grl;
  public ContactBindObserver b;
  
  private void b()
  {
    setTitle(2131368120);
    this.leftView.setText("通讯录");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298122));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    c();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298123));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b();
    if ((1 != i) && (2 != i))
    {
      findViewById(2131298122).setVisibility(0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a();
      localObject = ((RespondQueryQQBindingStat)localObject).nationCode + " " + ((RespondQueryQQBindingStat)localObject).mobileNo;
      try
      {
        int j = ((String)localObject).length();
        localObject = ((String)localObject).substring(0, j - 5) + "****" + ((String)localObject).substring(j - 1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SettingActivity2", 2, localException.getMessage());
          QLog.d("SettingActivity2", 2, "error happend! contact bind state is : " + i);
        }
        findViewById(2131298122).setVisibility(8);
        return;
      }
    }
    findViewById(2131298122).setVisibility(8);
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this, BindNumberFromPcActivity.class);
    localIntent.putExtra("key_is_first_activity", true);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968746, 2130968592);
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_is_first_activity", true);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968746, 2130968592);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903406);
    b();
    this.jdField_a_of_type_Grl = new grl(this);
    this.app.a(SettingActivity2.class, this.jdField_a_of_type_Grl);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.a(SettingActivity2.class);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.b != null)
    {
      this.app.unRegistObserver(this.b);
      this.b = null;
    }
    this.app.a(SettingActivity2.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      throw new RuntimeException("unknown id: " + i);
    case 2131298122: 
      if (1 == this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b())
      {
        e();
        return;
      }
      if (2 == this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b())
      {
        d();
        return;
      }
      paramView = (ActionSheet)ActionSheetHelper.a(this, null);
      paramView.a(2131368130, 1);
      paramView.setCanceledOnTouchOutside(true);
      paramView.a(new gri(this, paramView));
      paramView.e(2131365736);
      paramView.show();
      return;
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this, null);
    paramView.a(2131368127);
    paramView.setCanceledOnTouchOutside(true);
    paramView.a(2131368128, 3);
    paramView.a(new grj(this, paramView));
    paramView.e(2131365736);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2
 * JD-Core Version:    0.7.0.1
 */