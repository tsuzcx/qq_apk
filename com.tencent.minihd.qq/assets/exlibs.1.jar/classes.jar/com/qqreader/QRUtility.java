package com.qqreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.util.Utils;
import java.io.File;

public class QRUtility
{
  public static final int a = 0;
  public static String a = "{\"id\":\"220628\",\"title\":\"天才魔音师\",\"author\":\"紫漠蝶\",\"downloadURL\":\"\",\"coverURL\":\"https://wfqqreader.3g.qq.com/cover/628/220628/b_220628.jpg\",\"contentUrl\":\"https://allreader.3g.qq.com/readonline\",\"is_real_url\": 0,\"type\":0,\"version\":417,\"chapterId\":-1,\"chapterTitle\": \"第1章 诡异事件\", \"drm\":0, \"finished\": 1, \"fileFormat\":\"txt\", \"sourceurl\":\"\"}";
  public static final int b = 1;
  public static final String b = "QR_SETTING";
  public static final int c = 2;
  public static final String c = "QR_USERPREF";
  public static final String d = "QR_BOOKADDED";
  
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getInt("QR_USERPREF", -1);
  }
  
  public static String a(Context paramContext)
  {
    return b(paramContext) + "pluginBooks";
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramActivity, 2, "inter2");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putInt("QR_USERPREF", paramInt).commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putBoolean("QR_BOOKADDED", paramBoolean).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    String str = "qqreaderplugin.apk";
    Intent localIntent = new Intent();
    localIntent.putExtra("account", paramQQAppInterface.a());
    localIntent.putExtra("load_from_third_app", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
    if (0 == 0)
    {
      localIntent.setClassName(paramActivity, "com.qqreader.QRBridgeActivity");
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("qq_share_book_type", paramInt);
      paramQQAppInterface.putString("book_info", paramString);
      localIntent.putExtras(paramQQAppInterface);
      paramActivity.startActivity(localIntent);
      return;
    }
    paramString = str;
    if (!TextUtils.isEmpty("qqreaderplugin.apk")) {
      paramString = "qqreaderplugin.apk".substring(0, "qqreaderplugin.apk".indexOf("."));
    }
    PluginStatisticsCollector.a(paramActivity, paramQQAppInterface.a(), paramString, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, boolean paramBoolean)
  {
    String str = "qqreaderplugin.apk";
    Intent localIntent = new Intent();
    localIntent.putExtra("account", paramQQAppInterface.a());
    localIntent.putExtra("load_from_third_app", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
    if (0 == 0)
    {
      localIntent.setClassName(paramActivity, "com.qqreader.QRBridgeActivity");
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putBoolean("qq_adv", true);
      localIntent.putExtras(paramQQAppInterface);
      paramActivity.startActivity(localIntent);
      return;
    }
    if (!TextUtils.isEmpty("qqreaderplugin.apk")) {
      str = "qqreaderplugin.apk".substring(0, "qqreaderplugin.apk".indexOf("."));
    }
    PluginStatisticsCollector.a(paramActivity, paramQQAppInterface.a(), str, null);
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getBoolean("QR_BOOKADDED", false);
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    paramAppInterface = (PublicAccountDataManager)paramAppInterface.getManager(54);
    if (paramAppInterface != null) {
      return paramAppInterface.a("1805987832") != null;
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    if (Utils.e()) {
      return Environment.getExternalStorageDirectory().getPath() + "/Tencent/ReaderZone/";
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRUtility
 * JD-Core Version:    0.7.0.1
 */