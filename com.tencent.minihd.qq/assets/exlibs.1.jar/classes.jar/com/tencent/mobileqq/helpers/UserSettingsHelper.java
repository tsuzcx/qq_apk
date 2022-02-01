package com.tencent.mobileqq.helpers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.UserSettings;
import com.tencent.util.SerializeHelper;
import mqq.app.MobileQQ;

public class UserSettingsHelper
{
  private static final String a = "com_tecent_common_preferences";
  private static final String b = "user_settings_str";
  
  public static UserSettings a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    if (paramQQAppInterface == null) {
      return null;
    }
    String str = paramQQAppInterface.getApplication().getSharedPreferences("com_tecent_common_preferences", 0).getString("user_settings_str", "");
    paramQQAppInterface = localObject;
    if (!TextUtils.isEmpty(str)) {
      paramQQAppInterface = SerializeHelper.a(str);
    }
    return (UserSettings)paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, UserSettings paramUserSettings)
  {
    if ((paramQQAppInterface == null) || (paramUserSettings == null)) {}
    do
    {
      return;
      paramUserSettings = SerializeHelper.a(paramUserSettings);
    } while (TextUtils.isEmpty(paramUserSettings));
    paramQQAppInterface.getApplication().getSharedPreferences("com_tecent_common_preferences", 0).edit().putString("user_settings_str", paramUserSettings).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.helpers.UserSettingsHelper
 * JD-Core Version:    0.7.0.1
 */