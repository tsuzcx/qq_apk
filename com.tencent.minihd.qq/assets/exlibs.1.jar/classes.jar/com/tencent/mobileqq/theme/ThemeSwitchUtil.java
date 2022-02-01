package com.tencent.mobileqq.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ThemeSwitchUtil
{
  public static final String TAG = "ThemeSwitchUtil";
  public static final String THEME_KEY_PREVIOUS_THEME_ID = "previousThemeId";
  public static final String THEME_KEY_PREVIOUS_THEME_VERSION = "previousThemeVersion";
  public static final String THEME_KEY_THEME_DOWNLOADNIGHT_USER = "nightmodedownload_uin";
  
  public static Bundle getPreviousThemeIdVersion(QQAppInterface paramQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = ((SharedPreferences)localObject).getString("previousThemeId", "1000");
    localObject = ((SharedPreferences)localObject).getString("previousThemeVersion", "0");
    localBundle.putString("themeID", paramQQAppInterface);
    localBundle.putString("version", (String)localObject);
    return localBundle;
  }
  
  public static Bundle getUserDownload(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramContext.getSharedPreferences("userThemeSharedPreferences", 0).getString("nightmodedownload_uin", ""));
    return localBundle;
  }
  
  public static Boolean setPreviousThemeIdVersion(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    String str = ((SharedPreferences)localObject).getString("previousThemeId", "1000");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("previousThemeId", paramString1);
    ((SharedPreferences.Editor)localObject).putString("previousThemeVersion", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitchUtil", 2, "ThemeSwitchUtil setPreviousThemeIdVersion,uin=" + paramQQAppInterface + ",oldPreviousThemeId=" + str + ",set new themeId=" + paramString1);
    }
    return Boolean.valueOf(((SharedPreferences.Editor)localObject).commit());
  }
  
  public static boolean setUserDownload(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getSharedPreferences("userThemeSharedPreferences", 0);
    paramContext = ((SharedPreferences)localObject).getString("nightmodedownload_uin", "");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("nightmodedownload_uin", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitchUtil", 2, "setUserDownload ,curruin=" + paramString + ",oldPreviousUser=" + paramContext);
    }
    return ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchUtil
 * JD-Core Version:    0.7.0.1
 */