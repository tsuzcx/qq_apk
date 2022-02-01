package com.tencent.mobileqq.theme;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeUtil
{
  public static final String DEFAULT_CUSTOM_ID = "999";
  public static final String DEFAULT_THEME_ID = "1000";
  public static final String DIY_THEME_ID = "999";
  public static final String DIY_THEME_VERSION = "540";
  public static final String PKG_SUFFIX = ".zip";
  public static final String TAG = "Theme.ThemeUtil";
  public static final String THEME_BASE_DIR_NAME = "mobileqq_theme";
  public static final String THEME_DIY_BROADCASTPERMISSION = "com.tencent.msg.permission.pushnotify2";
  public static final String THEME_DIY_UPDATE = "com.tencent.qplus.THEME_DIY_UPDATE";
  public static final String THEME_ERROR_ID_LIST = "listOfErrorThemeSrc";
  public static final String THEME_ID_NIGHTMODE = "1103";
  public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_20140108";
  public static final String THEME_KEY_CURRENT_THEME_VERSION = "currentThemeVersion";
  public static final String THEME_KEY_NIGHT_MODE = "night_theme_info_";
  public static final String THEME_KEY_USER_DOWNLOAD = "userDownloadTheme";
  public static final String THEME_KEY_USER_SWITCH_TIMES = "user_switch_theme_times";
  public static final String THEME_MSSAGE_VOICE_NAME = "message.mp3";
  public static final String THEME_SHARED_PREFERENCES = "userThemeSharedPreferences";
  public static final String THEME_STATUS_COMPLETE = "5";
  public static final String THEME_STATUS_DOWNLOAD_END = "3";
  public static final String THEME_STATUS_DOWNLOAD_NONE = "1";
  public static final String THEME_STATUS_DOWNLOAD_PAUSE = "4";
  public static final String THEME_STATUS_DOWNLOAD_PROGRESS = "2";
  public static final String THEME_VOICE_BASE_HOME = "voice";
  public static final String THEME_VOICE_SETTING = "theme_voice_setting_";
  
  public static Bundle getCurrentThemeInfo()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("themeId", "1000");
    localBundle.putString("version", "0");
    String str = SkinEngine.getInstances().getSkinRootPath();
    localBundle.putString("themePath", str);
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeUtil", 2, "getCurrentThemeInfo,currentThemeResPath=" + str);
    }
    if ((str != null) && (str.length() > 0))
    {
      Object localObject = str;
      if (str.endsWith("/")) {
        localObject = str.substring(0, str.length() - 1);
      }
      str = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "getCurrentThemeInfo,currentThemeResPath=" + (String)localObject + ",themeIdVersion=" + str);
      }
      if (str != null)
      {
        localObject = str.split("_");
        if (localObject.length == 2)
        {
          localBundle.putString("themeId", localObject[0]);
          localBundle.putString("version", localObject[1]);
        }
      }
    }
    return localBundle;
  }
  
  public static int getErrorThemeId(Context paramContext, String paramString)
  {
    int j = 0;
    paramContext = paramContext.getSharedPreferences("userThemeSharedPreferences", 4).getString("listOfErrorThemeSrc", "");
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (paramContext.length() <= 0) {}
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      i = j;
      if (paramContext.has(paramString)) {
        i = paramContext.getInt(paramString);
      }
    }
    catch (JSONException paramContext)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.d("Theme.ThemeUtil", 2, "getErrorThemeId error:" + paramContext.getMessage());
    }
    return i;
    return 0;
  }
  
  public static String getThemeDensity(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext.densityDpi <= 160) {
      return "m";
    }
    if ((paramContext.densityDpi > 160) && (paramContext.densityDpi < 320)) {
      return "h";
    }
    return "xh";
  }
  
  public static String getThemeDownloadFilePath(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = AppConstants.bP;
    return paramContext + paramString1 + "_" + paramString2 + ".zip";
  }
  
  public static int getThemeDownloadNum(Context paramContext)
  {
    int m = 0;
    int n = 0;
    int i = 0;
    paramContext = paramContext.getSharedPreferences("userThemeSharedPreferences", 0).getString("userDownloadTheme", "");
    k = n;
    if (paramContext != null)
    {
      int j = m;
      k = n;
      try
      {
        if (paramContext.length() > 0)
        {
          j = m;
          paramContext = new JSONObject(paramContext);
          j = m;
          Iterator localIterator = paramContext.keys();
          for (;;)
          {
            j = i;
            k = i;
            if (!localIterator.hasNext()) {
              break;
            }
            j = i;
            String str = paramContext.getJSONObject(String.valueOf(localIterator.next())).getString("status");
            j = i;
            if (!str.equals("5"))
            {
              j = i;
              boolean bool = str.equals("3");
              if (!bool) {}
            }
            else
            {
              i += 1;
            }
          }
        }
        return k;
      }
      catch (Exception paramContext)
      {
        k = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Theme.ThemeUtil", 2, "getThemeDownloadNum error:" + paramContext.getMessage());
          k = j;
        }
      }
    }
  }
  
  /* Error */
  public static ThemeUtil.ThemeInfo getThemeInfo(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 57
    //   3: iconst_4
    //   4: invokevirtual 173	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: ldc 48
    //   9: ldc 175
    //   11: invokeinterface 181 3 0
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +162 -> 180
    //   21: aload_0
    //   22: invokevirtual 138	java/lang/String:length	()I
    //   25: ifle +155 -> 180
    //   28: new 183	org/json/JSONObject
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 186	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 189	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   42: ifeq +138 -> 180
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 256	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   50: astore_2
    //   51: new 272	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   54: dup
    //   55: invokespecial 273	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   58: astore_0
    //   59: aload_0
    //   60: aload_1
    //   61: putfield 275	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   64: aload_0
    //   65: aload_2
    //   66: ldc 96
    //   68: invokevirtual 261	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: putfield 277	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   74: aload_0
    //   75: aload_2
    //   76: ldc_w 279
    //   79: invokevirtual 283	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   82: putfield 286	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   85: aload_0
    //   86: aload_2
    //   87: ldc_w 258
    //   90: invokevirtual 261	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: putfield 288	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   96: aload_0
    //   97: aload_2
    //   98: ldc_w 290
    //   101: invokevirtual 283	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   104: putfield 292	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   107: aload_0
    //   108: astore_1
    //   109: aload_2
    //   110: ldc_w 294
    //   113: invokevirtual 189	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   116: ifeq +16 -> 132
    //   119: aload_0
    //   120: aload_2
    //   121: ldc_w 294
    //   124: invokevirtual 297	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   127: putfield 301	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   130: aload_0
    //   131: astore_1
    //   132: aload_1
    //   133: areturn
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_0
    //   137: aload_0
    //   138: astore_1
    //   139: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq -10 -> 132
    //   145: ldc 21
    //   147: iconst_2
    //   148: new 118	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 303
    //   158: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_2
    //   162: invokevirtual 197	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_0
    //   175: areturn
    //   176: astore_2
    //   177: goto -40 -> 137
    //   180: aconst_null
    //   181: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramContext	Context
    //   0	182	1	paramString	String
    //   50	71	2	localJSONObject	JSONObject
    //   134	28	2	localJSONException1	JSONException
    //   176	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   21	59	134	org/json/JSONException
    //   59	107	176	org/json/JSONException
    //   109	130	176	org/json/JSONException
  }
  
  public static String getThemeResourcePath(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString1 != null)
    {
      localObject1 = localObject3;
      if (paramString2 != null)
      {
        localObject1 = localObject3;
        if (paramString1 == "1000") {}
      }
    }
    do
    {
      for (;;)
      {
        try
        {
          if (Utils.f()) {
            paramContext = AppConstants.bI + "using_theme_res";
          }
        }
        catch (Exception paramString1)
        {
          paramContext = localObject2;
        }
        try
        {
          localObject1 = paramContext + File.separator + paramString1 + "_" + paramString2;
          return localObject1;
        }
        catch (Exception paramString1)
        {
          break;
        }
        paramContext = paramContext.getDir("mobileqq_theme", 0).getAbsolutePath();
      }
      localObject1 = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("Theme.ThemeUtil", 2, "getThemeResourcePath error:" + paramString1.getMessage());
    return paramContext;
  }
  
  public static int getThemeSwitchTimes(QQAppInterface paramQQAppInterface)
  {
    int i = paramQQAppInterface.getPreferences().getInt("user_switch_theme_times", 0);
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "getThemeSwitchTimes userSwitchThemeTimes=" + i);
    }
    return i;
  }
  
  public static String getThemeVoiceRootPath()
  {
    Object localObject = SkinEngine.getInstances().getSkinRootPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject + File.separatorChar + "voice");
      if (((File)localObject).exists()) {
        return ((File)localObject).getAbsolutePath();
      }
    }
    return null;
  }
  
  public static SharedPreferences getUinPreferences(AppRuntime paramAppRuntime)
  {
    String str2 = paramAppRuntime.getAccount();
    String str1 = str2;
    if (str2 == null) {
      str1 = "noLogin";
    }
    return paramAppRuntime.getApplication().getSharedPreferences(str1, 4);
  }
  
  public static String getUserCurrentThemeId(AppInterface paramAppInterface)
  {
    String str = getUinPreferences(paramAppInterface).getString("currentThemeId_20140108", "1000");
    if (((paramAppInterface instanceof QQAppInterface)) && (QLog.isColorLevel())) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,uin=" + paramAppInterface.getAccount() + ",currentThemeId=" + str);
    }
    return str;
  }
  
  public static String getUserCurrentThemeVersion(QQAppInterface paramQQAppInterface)
  {
    Object localObject = getUinPreferences(paramQQAppInterface);
    paramQQAppInterface = paramQQAppInterface.getAccount();
    localObject = ((SharedPreferences)localObject).getString("currentThemeVersion", "0");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,uin=" + paramQQAppInterface + ",currentThemeVersion=" + (String)localObject);
    }
    return localObject;
  }
  
  @TargetApi(9)
  public static void initTheme(QQAppInterface paramQQAppInterface)
  {
    Object localObject1;
    Object localObject2;
    String str1;
    String str2;
    int i;
    if (paramQQAppInterface.isLogin())
    {
      localObject1 = BaseApplicationImpl.a;
      localObject2 = getCurrentThemeInfo().getString("themeId");
      str1 = getUserCurrentThemeId(paramQQAppInterface);
      str2 = getUserCurrentThemeVersion(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "initTheme,userThemeId=" + str1 + ",currentThemeId=" + (String)localObject2);
      }
      if (str1.equals("1000"))
      {
        i = paramQQAppInterface.getPreferences().getInt("themeAuthResult", 0);
        if (i != 0)
        {
          if (Build.VERSION.SDK_INT <= 8) {
            break label221;
          }
          paramQQAppInterface.getPreferences().edit().putInt("stripUserTheme", i).remove("themeAuthResult").apply();
        }
      }
      if (((String)localObject2).equals(str1)) {
        break label367;
      }
      if (!str1.equals("1000")) {
        break label256;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "initTheme reset user to default theme");
      }
      SkinEngine.getInstances().setSkinRootPath((Context)localObject1, null);
      label184:
      localObject1 = new ThemeActiveLogic(paramQQAppInterface);
      if (!str1.equals("1000")) {
        break label444;
      }
      ((ThemeActiveLogic)localObject1).handleActiveTheme();
      label208:
      localObject2 = ((ThemeActiveLogic)localObject1).getActiveThemeJson();
      if (localObject2 != null) {
        break label482;
      }
    }
    label221:
    label367:
    do
    {
      do
      {
        return;
        paramQQAppInterface.getPreferences().edit().putInt("stripUserTheme", i).remove("themeAuthResult").commit();
        break;
        localObject2 = getThemeResourcePath((Context)localObject1, str1, str2);
        localObject3 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeUtil", 2, "initTheme reset user theme resourcePath=" + (String)localObject2 + ",dir exists=" + ((File)localObject3).exists());
        }
        if (((File)localObject3).exists())
        {
          SkinEngine.getInstances().setSkinRootPath((Context)localObject1, (String)localObject2);
          break label184;
        }
        SkinEngine.getInstances().setSkinRootPath((Context)localObject1, null);
        setCurrentThemeIdVersion(paramQQAppInterface, "1000", "0");
        break label184;
        localObject3 = SkinEngine.getInstances().getSkinRootPath();
        if ((localObject3 == null) || (((String)localObject3).length() <= 0) || (!((String)localObject2).equals("1000"))) {
          break label184;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeUtil", 2, "initTheme reset user to default theme for old version,currentThemeResPath=" + (String)localObject3);
        }
        SkinEngine.getInstances().setSkinRootPath((Context)localObject1, null);
        break label184;
        if (((ThemeActiveLogic)localObject1).DuringActiveTime() != ThemeActiveLogic.DURING) {
          break label208;
        }
        getUinPreferences(paramQQAppInterface).edit().putBoolean("is_first_login_during_active", true).commit();
        break label208;
        localObject2 = ThemeActiveLogic.getActiveThemeInfo((JSONArray)localObject2);
      } while (localObject2 == null);
      Object localObject3 = ((ThemeActiveLogic)localObject1).getActiveThemeInfoByDensity((ThemeActiveLogic.ActiveThemeInfo)localObject2).version;
      if ((((ThemeActiveLogic.ActiveThemeInfo)localObject2).themeID.equals(str1)) && (((String)localObject3).equals(str2)))
      {
        ((ThemeActiveLogic)localObject1).handleDelete((ThemeActiveLogic.ActiveThemeInfo)localObject2);
        return;
      }
    } while (((ThemeActiveLogic)localObject1).DuringActiveTime() != ThemeActiveLogic.AFTER);
    label256:
    label444:
    label482:
    getUinPreferences(paramQQAppInterface).edit().putInt("active_theme_sp_delete_key_" + ((ThemeActiveLogic.ActiveThemeInfo)localObject2).actID, 1).commit();
  }
  
  public static boolean isInNightMode(AppInterface paramAppInterface)
  {
    return "1103".equals(getUserCurrentThemeId(paramAppInterface));
  }
  
  public static void resetThemeSwitchTimes(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("user_switch_theme_times", 0);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "resetThemeSwitchTimes");
    }
  }
  
  public static Boolean setCurrentThemeIdVersion(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    Object localObject = getUinPreferences(paramAppRuntime);
    paramAppRuntime = paramAppRuntime.getAccount();
    String str = ((SharedPreferences)localObject).getString("currentThemeId_20140108", "1000");
    int i = ((SharedPreferences)localObject).getInt("user_switch_theme_times", 0) + 1;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("currentThemeId_20140108", paramString1);
    ((SharedPreferences.Editor)localObject).putString("currentThemeVersion", paramString2);
    ((SharedPreferences.Editor)localObject).putInt("user_switch_theme_times", i);
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil getCurrentTheme,uin=" + paramAppRuntime + ",currentThemeId=" + str + ",set new themeId=" + paramString1 + ",userSwitchThemeTimes=" + i);
    }
    return Boolean.valueOf(((SharedPreferences.Editor)localObject).commit());
  }
  
  public static void setErrorThemeId(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("userThemeSharedPreferences", 4);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("listOfErrorThemeSrc", "");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setErrorThemeID themeId=" + paramString);
    }
    label180:
    label197:
    label198:
    label201:
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(paramContext))
        {
          paramContext = new JSONObject();
          if (!paramContext.has(paramString)) {
            break label198;
          }
          i = paramContext.getInt(paramString);
          break label180;
          paramContext.put(paramString, i);
          localEditor.putString("listOfErrorThemeSrc", paramContext.toString()).commit();
          return;
        }
        paramContext = new JSONObject(paramContext);
        continue;
        i = i % 100000 + 300001;
        continue;
        QLog.d("Theme.ThemeUtil", 2, "setErrorThemeId error:" + paramContext.getMessage());
      }
      catch (JSONException paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label197;
        }
      }
      return;
      for (;;)
      {
        if (!paramBoolean) {
          break label201;
        }
        i = i % 100000 + 500000;
        break;
        return;
        i = 0;
      }
    }
  }
  
  public static Boolean setThemeInfo(Context paramContext, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    paramContext = paramContext.getSharedPreferences("userThemeSharedPreferences", 4);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("userDownloadTheme", "");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo themeInfo=" + paramThemeInfo.toString() + ",userTheme=" + paramContext);
    }
    String str = paramThemeInfo.themeId;
    if (str != null)
    {
      if (paramContext != null) {}
      try
      {
        if (paramContext.length() > 0)
        {
          paramContext = new JSONObject(paramContext);
          if (!paramContext.has(str)) {
            break label257;
          }
        }
        label257:
        for (JSONObject localJSONObject = paramContext.getJSONObject(str);; localJSONObject = new JSONObject())
        {
          localJSONObject.put("downsize", paramThemeInfo.downsize);
          localJSONObject.put("size", paramThemeInfo.size);
          localJSONObject.put("version", paramThemeInfo.version);
          localJSONObject.put("status", paramThemeInfo.status);
          paramContext.put(str, localJSONObject);
          localJSONObject.put("sound", paramThemeInfo.isVoiceTheme);
          boolean bool = localEditor.putString("userDownloadTheme", paramContext.toString()).commit();
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.d("Theme.ThemeUtil", 2, "setThemeInfo sp comit rt=" + bool);
          }
          return Boolean.valueOf(bool);
          paramContext = new JSONObject();
          break;
        }
        if (!QLog.isColorLevel()) {
          break label324;
        }
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo error:" + paramContext.getMessage());
        }
        return Boolean.valueOf(false);
      }
    }
    else
    {
      QLog.d("Theme.ThemeUtil", 2, "ThemeUtil setThemeInfo error themeId is null");
    }
    label324:
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil
 * JD-Core Version:    0.7.0.1
 */