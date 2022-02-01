package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class FloatSetting
{
  private static FloatSetting jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting;
  public static final String a = "key_auto_grap_hb";
  private static final String b = "float_open_main_switch";
  private static final String c = "float_notify_friend";
  private static final String d = "float_notify_discuss";
  private static final String e = "float_notify_troop";
  private static final String f = "first_enter_new_version";
  private Context jdField_a_of_type_AndroidContentContext;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  
  private FloatSetting(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("mobileQQ", 0);
  }
  
  public static FloatSetting a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting == null) {
      jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting = new FloatSetting(paramContext);
    }
    return jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatSetting;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "float_open_main_switch", paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_auto_grap_hb", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_auto_grap_hb", false);
  }
  
  public boolean a(String paramString)
  {
    return SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "float_open_main_switch", true);
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (e(paramString))
    {
      e(paramString, false);
      bool1 = bool2;
      if (!paramBoolean1)
      {
        bool1 = bool2;
        if (paramBoolean2)
        {
          SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "qqsetting_lock_screen_whenexit_key", false);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "float_notify_friend", paramBoolean);
  }
  
  public boolean b(String paramString)
  {
    return SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "float_notify_friend", true);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "float_notify_discuss", paramBoolean);
  }
  
  public boolean c(String paramString)
  {
    return SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "float_notify_discuss", false);
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "float_notify_troop", paramBoolean);
  }
  
  public boolean d(String paramString)
  {
    return SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "float_notify_troop", false);
  }
  
  public void e(String paramString, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "first_enter_new_version", paramBoolean);
  }
  
  public boolean e(String paramString)
  {
    return SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidContentContext, paramString, null, "first_enter_new_version", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatSetting
 * JD-Core Version:    0.7.0.1
 */