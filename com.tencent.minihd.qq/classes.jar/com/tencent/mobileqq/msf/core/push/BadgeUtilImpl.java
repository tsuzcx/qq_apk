package com.tencent.mobileqq.msf.core.push;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class BadgeUtilImpl
{
  public static final String ACTION_APPLICATION_MESSAGE_QUERY = "android.intent.action.APPLICATION_MESSAGE_QUERY";
  public static final String ACTION_APPLICATION_MESSAGE_UPDATE = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
  public static final String ACTION_QQLAUNCHER_BADGE_UPDATE = "com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT";
  public static final String EXTRA_UPDATE_APPLICATION_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
  public static final String EXTRA_UPDATE_APPLICATION_MESSAGE_TEXT = "android.intent.extra.update_application_message_text";
  public static final String LENOVO_PACKAGE_NAME = "com.lenovo.launcher";
  public static final String MANUFACTURER_OF_HARDWARE_HUAWEI = "huawei";
  public static final String MANUFACTURER_OF_HARDWARE_LENOVO = "lenovo";
  public static final String MANUFACTURER_OF_HARDWARE_OPPO = "OPPO";
  public static final String MANUFACTURER_OF_HARDWARE_SANXING = "samsung";
  public static final String MANUFACTURER_OF_HARDWARE_SONY = "Sony Ericsson";
  public static final String MANUFACTURER_OF_HARDWARE_XIAOMI = "Xiaomi";
  public static final String MANUFACTURER_OF_HARDWARE_ZUK = "ZUK";
  public static final String MANUFACTURER_OF_LENOVO_LAUNCHER_BADGE = "content://com.lenovo.launcher.badge/lenovo_badges";
  public static int NOTIFICATION_ID_NOTIFYID = 0;
  private static final String OPPO_QQ_BADGE_NUMBER = "com.tencent.mobileqq.badge";
  public static final String QQSETTING_SHOW_BADGEUNREAD_KEY = "qqsetting_show_badgeunread_key";
  public static final String TAG = "BadgeUtilImpl";
  private static Boolean haveprovider = null;
  public static String mLauncherClassName = "";
  private static int miui6Flag = 0;
  public static PackageManager packmag;
  public static String[] sQQLuancherPackageNames;
  
  static
  {
    NOTIFICATION_ID_NOTIFYID = 110234;
    sQQLuancherPackageNames = new String[] { "com.tencent.qlauncher.lite", "com.tencent.qlauncher", "com.tencent.qqlauncher", "com.tencent.launcher" };
  }
  
  public static void changeMI6Badge(Context paramContext, int paramInt, Notification paramNotification)
  {
    int i = 99;
    if (!isEnabled(paramContext)) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 99) {
        paramInt = i;
      }
      for (;;)
      {
        try
        {
          paramContext = Class.forName("android.app.MiuiNotification").newInstance();
          Field localField = paramContext.getClass().getDeclaredField("messageCount");
          localField.setAccessible(true);
          localField.set(paramContext, Integer.valueOf(paramInt));
          paramNotification.getClass().getField("extraNotification").set(paramNotification, paramContext);
          if (QLog.isColorLevel()) {
            QLog.d("BadgeUtilImpl", 2, "changeMI6Badge mcount=" + paramInt);
          }
          return;
        }
        catch (NoSuchFieldException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (IllegalArgumentException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (IllegalAccessException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (ClassNotFoundException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (InstantiationException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
    }
  }
  
  public static void changeMIBadge(Context paramContext, int paramInt)
  {
    if (isMIUI6()) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
    localIntent.putExtra("android.intent.extra.update_application_component_name", "com.tencent.minihd.qq/.activity.SplashActivity");
    String str;
    if (paramInt > 0) {
      if (paramInt > 99) {
        str = "99";
      }
    }
    for (;;)
    {
      localIntent.putExtra("android.intent.extra.update_application_message_text", str);
      paramContext.sendBroadcast(localIntent);
      return;
      str = paramInt + "";
      continue;
      str = "";
    }
  }
  
  public static void changeOPPOBadge(Context paramContext, int paramInt)
  {
    int i = 99;
    if (!isEnabled(paramContext)) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 99) {
        paramInt = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtilImpl", 2, "changeOPPOBadge mcount=" + paramInt);
        }
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("app_badge_count", paramInt);
          paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle);
          return;
        }
        catch (Exception paramContext)
        {
          QLog.d("BadgeUtilImpl", 2, "OPPOBadge badge get a  crash" + paramContext.getMessage());
          return;
        }
      }
    }
  }
  
  public static void changeZUKBadge(Context paramContext, int paramInt)
  {
    int i = 99;
    if (!isEnabled(paramContext)) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 99) {
        paramInt = i;
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("app_shortcut_custom_id", null);
          localBundle.putInt("app_badge_count", paramInt);
          if (paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle) == null) {
            continue;
          }
          bool = true;
          if (QLog.isColorLevel())
          {
            QLog.d("BadgeUtilImpl", 2, "changeZUKBadge mcount=" + paramInt);
            QLog.d("BadgeUtilImpl", 2, "changeZUKBadge success=" + bool);
          }
          return;
        }
        catch (Throwable paramContext)
        {
          boolean bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("BadgeUtilImpl", 2, "zukBadge badge get a  crash" + paramContext.toString());
          return;
        }
        continue;
        bool = false;
      }
    }
  }
  
  public static void disableBadge(Context paramContext)
  {
    if (isSupportBadge())
    {
      setBadge(paramContext, 0, true);
      SettingCloneUtil.writeValue(paramContext, null, null, "qqsetting_show_badgeunread_key", false);
    }
  }
  
  public static void enableBadge(Context paramContext)
  {
    if (isSupportBadge()) {
      SettingCloneUtil.writeValue(paramContext, null, null, "qqsetting_show_badgeunread_key", true);
    }
  }
  
  public static String getLauncherClassName(Context paramContext)
  {
    if (!TextUtils.isEmpty(mLauncherClassName)) {
      paramContext = mLauncherClassName;
    }
    for (;;)
    {
      return paramContext;
      Object localObject1 = paramContext.getPackageManager();
      Object localObject2 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
      try
      {
        localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ResolveInfo)((Iterator)localObject1).next();
            if (((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName.equalsIgnoreCase(paramContext.getPackageName()))
            {
              localObject1 = ((ResolveInfo)localObject2).activityInfo.name;
              mLauncherClassName = (String)localObject1;
              paramContext = (Context)localObject1;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("BadgeUtilImpl", 2, "getLauncherClassName" + mLauncherClassName);
              return localObject1;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        return null;
      }
    }
    return null;
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    boolean bool = false;
    if (isSupportBadge()) {
      bool = SettingCloneUtil.readValue(paramContext, null, null, "qqsetting_show_badgeunread_key", true);
    }
    return bool;
  }
  
  /* Error */
  public static boolean isMIUI6()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: getstatic 92	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:miui6Flag	I
    //   5: ifne +101 -> 106
    //   8: iconst_m1
    //   9: putstatic 92	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:miui6Flag	I
    //   12: ldc 88
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore_3
    //   21: new 364	java/io/BufferedReader
    //   24: dup
    //   25: new 366	java/io/InputStreamReader
    //   28: dup
    //   29: new 368	java/lang/ProcessBuilder
    //   32: dup
    //   33: iconst_2
    //   34: anewarray 76	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc_w 370
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc_w 372
    //   48: aastore
    //   49: invokespecial 375	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   52: invokevirtual 379	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   55: invokevirtual 385	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   58: invokespecial 388	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   61: sipush 1024
    //   64: invokespecial 391	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 394	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore_3
    //   73: aload_2
    //   74: invokevirtual 397	java/io/BufferedReader:close	()V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 397	java/io/BufferedReader:close	()V
    //   85: aload_3
    //   86: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +17 -> 106
    //   92: aload_3
    //   93: invokestatic 401	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   96: istore_0
    //   97: iload_0
    //   98: iconst_3
    //   99: if_icmple +7 -> 106
    //   102: iconst_1
    //   103: putstatic 92	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:miui6Flag	I
    //   106: getstatic 92	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:miui6Flag	I
    //   109: iconst_1
    //   110: if_icmpne +41 -> 151
    //   113: iconst_1
    //   114: ireturn
    //   115: astore_2
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 397	java/io/BufferedReader:close	()V
    //   124: aload 4
    //   126: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifne +20 -> 149
    //   132: aload 4
    //   134: invokestatic 401	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   137: istore_1
    //   138: iload_1
    //   139: istore_0
    //   140: iload_0
    //   141: iconst_3
    //   142: if_icmple +7 -> 149
    //   145: iconst_1
    //   146: putstatic 92	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:miui6Flag	I
    //   149: aload_2
    //   150: athrow
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_2
    //   156: ldc 88
    //   158: astore_3
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 397	java/io/BufferedReader:close	()V
    //   167: aload_3
    //   168: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifne -65 -> 106
    //   174: aload_3
    //   175: invokestatic 401	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   178: istore_0
    //   179: iload_0
    //   180: iconst_3
    //   181: if_icmple -75 -> 106
    //   184: goto -82 -> 102
    //   187: astore_2
    //   188: goto -21 -> 167
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 402	java/lang/NumberFormatException:printStackTrace	()V
    //   196: iconst_0
    //   197: istore_0
    //   198: goto -19 -> 179
    //   201: astore_2
    //   202: aload 5
    //   204: astore_2
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 397	java/io/BufferedReader:close	()V
    //   213: aload 4
    //   215: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifne -112 -> 106
    //   221: aload 4
    //   223: invokestatic 401	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   226: istore_0
    //   227: iload_0
    //   228: iconst_3
    //   229: if_icmple -123 -> 106
    //   232: goto -130 -> 102
    //   235: astore_2
    //   236: goto -23 -> 213
    //   239: astore_2
    //   240: aload_2
    //   241: invokevirtual 402	java/lang/NumberFormatException:printStackTrace	()V
    //   244: iconst_0
    //   245: istore_0
    //   246: goto -19 -> 227
    //   249: astore_3
    //   250: goto -126 -> 124
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 402	java/lang/NumberFormatException:printStackTrace	()V
    //   258: goto -118 -> 140
    //   261: astore_2
    //   262: goto -177 -> 85
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual 402	java/lang/NumberFormatException:printStackTrace	()V
    //   270: iconst_0
    //   271: istore_0
    //   272: goto -175 -> 97
    //   275: astore 5
    //   277: aload_2
    //   278: astore_3
    //   279: aload 5
    //   281: astore_2
    //   282: goto -166 -> 116
    //   285: astore 5
    //   287: aload_3
    //   288: astore 4
    //   290: aload_2
    //   291: astore_3
    //   292: aload 5
    //   294: astore_2
    //   295: goto -179 -> 116
    //   298: astore_3
    //   299: goto -94 -> 205
    //   302: astore 4
    //   304: aload_3
    //   305: astore 4
    //   307: goto -102 -> 205
    //   310: astore_3
    //   311: ldc 88
    //   313: astore_3
    //   314: goto -155 -> 159
    //   317: astore 4
    //   319: goto -160 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	271	0	i	int
    //   137	2	1	j	int
    //   67	15	2	localBufferedReader	java.io.BufferedReader
    //   115	35	2	localObject1	Object
    //   153	1	2	localIOException1	java.io.IOException
    //   155	9	2	localObject2	Object
    //   187	1	2	localIOException2	java.io.IOException
    //   191	2	2	localNumberFormatException1	java.lang.NumberFormatException
    //   201	1	2	localException1	Exception
    //   204	6	2	localObject3	Object
    //   235	1	2	localIOException3	java.io.IOException
    //   239	2	2	localNumberFormatException2	java.lang.NumberFormatException
    //   261	1	2	localIOException4	java.io.IOException
    //   265	13	2	localNumberFormatException3	java.lang.NumberFormatException
    //   281	14	2	localObject4	Object
    //   20	155	3	str1	String
    //   249	1	3	localIOException5	java.io.IOException
    //   253	2	3	localNumberFormatException4	java.lang.NumberFormatException
    //   278	14	3	localObject5	Object
    //   298	7	3	localException2	Exception
    //   310	1	3	localIOException6	java.io.IOException
    //   313	1	3	str2	String
    //   14	275	4	localObject6	Object
    //   302	1	4	localException3	Exception
    //   305	1	4	localObject7	Object
    //   317	1	4	localIOException7	java.io.IOException
    //   17	186	5	localObject8	Object
    //   275	5	5	localObject9	Object
    //   285	8	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   21	68	115	finally
    //   21	68	153	java/io/IOException
    //   163	167	187	java/io/IOException
    //   174	179	191	java/lang/NumberFormatException
    //   21	68	201	java/lang/Exception
    //   209	213	235	java/io/IOException
    //   221	227	239	java/lang/NumberFormatException
    //   120	124	249	java/io/IOException
    //   132	138	253	java/lang/NumberFormatException
    //   81	85	261	java/io/IOException
    //   92	97	265	java/lang/NumberFormatException
    //   68	73	275	finally
    //   73	77	285	finally
    //   68	73	298	java/lang/Exception
    //   73	77	302	java/lang/Exception
    //   68	73	310	java/io/IOException
    //   73	77	317	java/io/IOException
  }
  
  public static boolean isQQLanucher()
  {
    boolean bool2 = false;
    if (packmag == null) {
      packmag = BaseApplication.getContext().getPackageManager();
    }
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < sQQLuancherPackageNames.length) {}
      try
      {
        PackageInfo localPackageInfo = packmag.getPackageInfo(sQQLuancherPackageNames[i], 0);
        if (localPackageInfo != null)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public static boolean isSupportBadge()
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("ZUK")) {}
    while ((islenovoLanucher("com.lenovo.launcher")) || (isQQLanucher()) || (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (Build.MANUFACTURER.equalsIgnoreCase("samsung")) || (Build.MANUFACTURER.equalsIgnoreCase("huawei")) || (Build.MANUFACTURER.equalsIgnoreCase("OPPO"))) {
      return true;
    }
    return false;
  }
  
  public static boolean islenovoLanucher(String paramString)
  {
    if (Build.VERSION.SDK_INT < 15) {}
    for (;;)
    {
      return false;
      try
      {
        if (packmag == null) {
          packmag = BaseApplication.getContext().getPackageManager();
        }
        float f = Float.valueOf(Float.parseFloat(packmag.getPackageInfo(paramString, 0).versionName.substring(0, 3))).floatValue();
        if (f >= 6.7F) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (PackageManager.NameNotFoundException paramString) {}
    }
    return false;
  }
  
  public static void setBadge(Context paramContext, int paramInt)
  {
    setBadge(paramContext, paramInt, false);
  }
  
  public static void setBadge(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtilImpl", 2, "setBadge count=" + paramInt + "|forceSet=" + paramBoolean);
    }
    if ((!isEnabled(paramContext)) && (!paramBoolean)) {}
    do
    {
      return;
      if (isQQLanucher()) {
        setQQLauncherBadges(paramContext, paramInt);
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("ZUK")) {
        changeZUKBadge(paramContext, paramInt);
      }
      if (islenovoLanucher("com.lenovo.launcher")) {
        setLenovoBadge(paramContext, paramInt);
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        changeMIBadge(paramContext, paramInt);
        return;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        setSamsungBadge(paramContext, paramInt);
        return;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
      {
        setHuaweiBadge(paramContext, paramInt);
        return;
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("OPPO"));
    changeOPPOBadge(paramContext, paramInt);
  }
  
  public static void setHuaweiBadge(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtilImpl", 2, "huawiBadge mcount=" + paramInt);
        }
        str = getLauncherClassName(paramContext);
        if (str != null) {
          break label104;
        }
        return;
      }
      catch (Throwable paramContext)
      {
        String str;
        Bundle localBundle;
        return;
      }
      localBundle = new Bundle();
      localBundle.putString("package", paramContext.getPackageName());
      localBundle.putString("class", str);
      localBundle.putInt("badgenumber", i);
      paramContext.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle);
      return;
      label104:
      int i = paramInt;
      if (paramInt > 99) {
        i = 99;
      }
    }
  }
  
  /* Error */
  public static void setLenovoBadge(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 29
    //   10: iconst_2
    //   11: new 163	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 497
    //   21: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_1
    //   25: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 499	android/content/ContentValues
    //   37: dup
    //   38: invokespecial 500	android/content/ContentValues:<init>	()V
    //   41: astore 4
    //   43: aload_0
    //   44: invokestatic 481	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:getLauncherClassName	(Landroid/content/Context;)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnonnull +4 -> 53
    //   52: return
    //   53: aload 4
    //   55: ldc_w 483
    //   58: aload_0
    //   59: invokevirtual 346	android/content/Context:getPackageName	()Ljava/lang/String;
    //   62: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload 4
    //   67: ldc_w 489
    //   70: aload_3
    //   71: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 4
    //   76: ldc_w 505
    //   79: iload_1
    //   80: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: invokevirtual 508	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   86: aload 4
    //   88: ldc_w 510
    //   91: ldc 88
    //   93: invokevirtual 503	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: invokevirtual 230	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: astore_3
    //   101: ldc 47
    //   103: invokestatic 238	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   106: astore 5
    //   108: aload_0
    //   109: invokevirtual 346	android/content/Context:getPackageName	()Ljava/lang/String;
    //   112: astore 6
    //   114: aload_3
    //   115: aload 5
    //   117: iconst_4
    //   118: anewarray 76	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: ldc_w 483
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: ldc_w 489
    //   132: aastore
    //   133: dup
    //   134: iconst_2
    //   135: ldc_w 505
    //   138: aastore
    //   139: dup
    //   140: iconst_3
    //   141: ldc_w 510
    //   144: aastore
    //   145: ldc_w 512
    //   148: iconst_1
    //   149: anewarray 76	java/lang/String
    //   152: dup
    //   153: iconst_0
    //   154: aload 6
    //   156: aastore
    //   157: aconst_null
    //   158: invokevirtual 516	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   161: astore_3
    //   162: aload_3
    //   163: astore_2
    //   164: aload_2
    //   165: ifnull +61 -> 226
    //   168: aload_2
    //   169: invokeinterface 522 1 0
    //   174: ifle +52 -> 226
    //   177: aload_2
    //   178: invokeinterface 525 1 0
    //   183: ifeq +32 -> 215
    //   186: aload_0
    //   187: invokevirtual 230	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   190: ldc 47
    //   192: invokestatic 238	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   195: aload 4
    //   197: ldc_w 512
    //   200: iconst_1
    //   201: anewarray 76	java/lang/String
    //   204: dup
    //   205: iconst_0
    //   206: aload_0
    //   207: invokevirtual 346	android/content/Context:getPackageName	()Ljava/lang/String;
    //   210: aastore
    //   211: invokevirtual 529	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   214: pop
    //   215: aload_2
    //   216: ifnull -164 -> 52
    //   219: aload_2
    //   220: invokeinterface 530 1 0
    //   225: return
    //   226: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +12 -> 241
    //   232: ldc 29
    //   234: iconst_2
    //   235: ldc_w 532
    //   238: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_0
    //   242: invokevirtual 230	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   245: ldc 47
    //   247: invokestatic 238	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   250: aload 4
    //   252: invokevirtual 536	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   255: pop
    //   256: aload_2
    //   257: ifnull -205 -> 52
    //   260: goto -41 -> 219
    //   263: astore_0
    //   264: aload_2
    //   265: ifnull +9 -> 274
    //   268: aload_2
    //   269: invokeinterface 530 1 0
    //   274: aload_0
    //   275: athrow
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_2
    //   279: aload_2
    //   280: ifnull -228 -> 52
    //   283: goto -64 -> 219
    //   286: astore_0
    //   287: goto -23 -> 264
    //   290: astore_0
    //   291: goto -12 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramContext	Context
    //   0	294	1	paramInt	int
    //   1	279	2	localObject1	Object
    //   47	116	3	localObject2	Object
    //   41	210	4	localContentValues	android.content.ContentValues
    //   106	10	5	localUri	Uri
    //   112	43	6	str	String
    // Exception table:
    //   from	to	target	type
    //   53	162	263	finally
    //   53	162	276	java/lang/Throwable
    //   168	215	286	finally
    //   226	241	286	finally
    //   241	256	286	finally
    //   168	215	290	java/lang/Throwable
    //   226	241	290	java/lang/Throwable
    //   241	256	290	java/lang/Throwable
  }
  
  public static void setMIUI6Badge(Context paramContext, int paramInt, Notification paramNotification)
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (isMIUI6())) {
      changeMI6Badge(paramContext, paramInt, paramNotification);
    }
  }
  
  public static void setQQLauncherBadges(Context paramContext, int paramInt)
  {
    int i;
    if (paramInt > 99) {
      i = 99;
    }
    for (;;)
    {
      Intent localIntent = new Intent("com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT");
      localIntent.putExtra("webappId", "20634");
      localIntent.putExtra("info_tips", String.valueOf(i));
      paramContext.sendBroadcast(localIntent);
      return;
      i = paramInt;
      if (paramInt < 1) {
        i = 0;
      }
    }
  }
  
  /* Error */
  public static void setSamsungBadge(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 71	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   6: ifnonnull +272 -> 278
    //   9: ldc_w 550
    //   12: invokestatic 238	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   15: astore_3
    //   16: aload_0
    //   17: invokevirtual 230	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: aload_3
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 516	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull +27 -> 57
    //   33: aload_3
    //   34: astore 4
    //   36: aload_3
    //   37: astore 5
    //   39: iconst_0
    //   40: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: putstatic 71	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   46: aload_3
    //   47: ifnull +9 -> 56
    //   50: aload_3
    //   51: invokeinterface 530 1 0
    //   56: return
    //   57: aload_3
    //   58: astore 4
    //   60: aload_3
    //   61: astore 5
    //   63: iconst_1
    //   64: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   67: putstatic 71	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   70: aload_3
    //   71: astore 4
    //   73: aload_3
    //   74: astore 5
    //   76: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +35 -> 114
    //   82: aload_3
    //   83: astore 4
    //   85: aload_3
    //   86: astore 5
    //   88: ldc 59
    //   90: iconst_2
    //   91: new 163	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 557
    //   101: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_1
    //   105: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_3
    //   115: astore 4
    //   117: aload_3
    //   118: astore 5
    //   120: getstatic 71	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   123: invokevirtual 560	java/lang/Boolean:booleanValue	()Z
    //   126: ifeq +109 -> 235
    //   129: aload_3
    //   130: astore 4
    //   132: aload_3
    //   133: astore 5
    //   135: aload_0
    //   136: invokestatic 481	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:getLauncherClassName	(Landroid/content/Context;)Ljava/lang/String;
    //   139: astore 6
    //   141: aload 6
    //   143: ifnonnull +140 -> 283
    //   146: aload_3
    //   147: ifnull -91 -> 56
    //   150: goto -100 -> 50
    //   153: aload_3
    //   154: astore 4
    //   156: aload_3
    //   157: astore 5
    //   159: new 195	android/content/Intent
    //   162: dup
    //   163: ldc_w 562
    //   166: invokespecial 198	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   169: astore 7
    //   171: aload_3
    //   172: astore 4
    //   174: aload_3
    //   175: astore 5
    //   177: aload 7
    //   179: ldc_w 564
    //   182: iload_2
    //   183: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   186: pop
    //   187: aload_3
    //   188: astore 4
    //   190: aload_3
    //   191: astore 5
    //   193: aload 7
    //   195: ldc_w 569
    //   198: aload_0
    //   199: invokevirtual 346	android/content/Context:getPackageName	()Ljava/lang/String;
    //   202: invokevirtual 204	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   205: pop
    //   206: aload_3
    //   207: astore 4
    //   209: aload_3
    //   210: astore 5
    //   212: aload 7
    //   214: ldc_w 571
    //   217: aload 6
    //   219: invokevirtual 204	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   222: pop
    //   223: aload_3
    //   224: astore 4
    //   226: aload_3
    //   227: astore 5
    //   229: aload_0
    //   230: aload 7
    //   232: invokevirtual 212	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   235: aload_3
    //   236: ifnull -180 -> 56
    //   239: goto -189 -> 50
    //   242: astore_0
    //   243: aload 4
    //   245: ifnull +10 -> 255
    //   248: aload 4
    //   250: invokeinterface 530 1 0
    //   255: aload_0
    //   256: athrow
    //   257: astore_0
    //   258: aconst_null
    //   259: astore_3
    //   260: aload_3
    //   261: ifnull -205 -> 56
    //   264: goto -214 -> 50
    //   267: astore_0
    //   268: goto -25 -> 243
    //   271: astore_0
    //   272: aload 5
    //   274: astore_3
    //   275: goto -15 -> 260
    //   278: aconst_null
    //   279: astore_3
    //   280: goto -210 -> 70
    //   283: iload_1
    //   284: istore_2
    //   285: iload_1
    //   286: bipush 99
    //   288: if_icmple -135 -> 153
    //   291: bipush 99
    //   293: istore_2
    //   294: goto -141 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramContext	Context
    //   0	297	1	paramInt	int
    //   182	112	2	i	int
    //   15	265	3	localObject1	Object
    //   1	248	4	localObject2	Object
    //   37	236	5	localObject3	Object
    //   139	79	6	str	String
    //   169	62	7	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   3	29	242	finally
    //   3	29	257	java/lang/Throwable
    //   39	46	267	finally
    //   63	70	267	finally
    //   76	82	267	finally
    //   88	114	267	finally
    //   120	129	267	finally
    //   135	141	267	finally
    //   159	171	267	finally
    //   177	187	267	finally
    //   193	206	267	finally
    //   212	223	267	finally
    //   229	235	267	finally
    //   39	46	271	java/lang/Throwable
    //   63	70	271	java/lang/Throwable
    //   76	82	271	java/lang/Throwable
    //   88	114	271	java/lang/Throwable
    //   120	129	271	java/lang/Throwable
    //   135	141	271	java/lang/Throwable
    //   159	171	271	java/lang/Throwable
    //   177	187	271	java/lang/Throwable
    //   193	206	271	java/lang/Throwable
    //   212	223	271	java/lang/Throwable
    //   229	235	271	java/lang/Throwable
  }
  
  public static void setSonyBadge(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    String str2 = getLauncherClassName(paramContext);
    if (str2 == null) {
      return;
    }
    if (paramInt < 1)
    {
      str1 = "";
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", false);
      localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", str2);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", str1);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    if (paramInt > 99) {}
    for (String str1 = "99";; str1 = paramInt + "")
    {
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.BadgeUtilImpl
 * JD-Core Version:    0.7.0.1
 */