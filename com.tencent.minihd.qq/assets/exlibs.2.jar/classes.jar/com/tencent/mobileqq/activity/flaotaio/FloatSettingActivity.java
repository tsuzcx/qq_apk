package com.tencent.mobileqq.activity.flaotaio;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class FloatSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  FloatSetting jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  String jdField_a_of_type_JavaLangString;
  FormSwitchItem b;
  FormSwitchItem c;
  FormSwitchItem d;
  FormSwitchItem e;
  
  private void a()
  {
    this.d = ((FormSwitchItem)findViewById(2131297719));
    this.e = ((FormSwitchItem)findViewById(2131297720));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297721));
    this.b = ((FormSwitchItem)findViewById(2131297722));
    this.c = ((FormSwitchItem)findViewById(2131297723));
    this.d.setOnCheckedChangeListener(this);
    this.e.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.b.setOnCheckedChangeListener(this);
    this.c.setOnCheckedChangeListener(this);
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.a(this.jdField_a_of_type_JavaLangString);
    boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131367906), "qqsetting_lock_screen_whenexit_key", true);
    this.e.setChecked(bool1);
    this.d.setChecked(bool2);
    bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.b(this.jdField_a_of_type_JavaLangString);
    bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.c(this.jdField_a_of_type_JavaLangString);
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.d(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
    this.b.setChecked(bool2);
    this.c.setChecked(bool3);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903325);
    setTitle(2131367909);
    if (this.app == null) {
      finish();
    }
    this.jdField_a_of_type_JavaLangString = this.app.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting = FloatSetting.a(this);
    boolean bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131367906), "qqsetting_lock_screen_whenexit_key", true);
    boolean bool2 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131366821), "qqsetting_notify_showcontent_key", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.a(this.jdField_a_of_type_JavaLangString, bool2, bool1);
    a();
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.b(this.jdField_a_of_type_JavaLangString, paramBoolean);
    }
    do
    {
      return;
      if (paramCompoundButton == this.b.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.c(this.jdField_a_of_type_JavaLangString, paramBoolean);
        return;
      }
      if (paramCompoundButton == this.c.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.d(this.jdField_a_of_type_JavaLangString, paramBoolean);
        return;
      }
      if (paramCompoundButton == this.d.a())
      {
        SettingCloneUtil.writeValue(this, this.jdField_a_of_type_JavaLangString, getString(2131367905), "qqsetting_lock_screen_whenexit_key", paramBoolean);
        return;
      }
    } while (paramCompoundButton != this.e.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting.a(this.jdField_a_of_type_JavaLangString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatSettingActivity
 * JD-Core Version:    0.7.0.1
 */