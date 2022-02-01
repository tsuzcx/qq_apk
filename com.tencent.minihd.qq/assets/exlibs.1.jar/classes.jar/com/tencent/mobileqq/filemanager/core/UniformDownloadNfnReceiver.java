package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadNfnReceiver
  extends BroadcastReceiver
{
  private static int a = 0;
  public static String a;
  public static final String b = "com.tencent.mobileqq.UniformDownloadNfn.PAUSE";
  public static final String c = "com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD";
  public static final String d = "com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD";
  public static final String e = "com.tencent.mobileqq.UniformDownloadNfn.INSTALL";
  public static final String f = "com.tencent.mobileqq.UniformDownloadNfn.BEDEL";
  public static final String g = "_PARAM_EXTRA";
  public static final String h = "_PARAM_FILEPATH";
  public static final String i = "_PARAM_PKGNAME";
  public static final String j = "_PARAM_DL_SUC_NEW_NID";
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloadNfnReceiver<FileAssistant>";
    jdField_a_of_type_Int = 0;
  }
  
  public static String a(String paramString)
  {
    paramString = new StringBuilder().append(paramString).append("@");
    int k = jdField_a_of_type_Int;
    jdField_a_of_type_Int = k + 1;
    return k;
  }
  
  public static String b(String paramString)
  {
    int k = paramString.lastIndexOf("@");
    String str = paramString;
    if (k >= 0) {
      str = paramString.substring(0, k);
    }
    return str;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramContext = paramIntent.getBundleExtra("_PARAM_EXTRA");
    if (str != null)
    {
      if (!str.equals("com.tencent.mobileqq.UniformDownloadNfn.PAUSE")) {
        break label100;
      }
      if (paramContext == null) {
        break label90;
      }
      k = paramContext.getInt("_notify_param_Id");
      paramIntent = paramContext.getString("_notify_param_Url");
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: id:" + k + " url:" + paramIntent);
      UniformDownloadMgr.a().c(paramIntent, paramContext);
    }
    label90:
    label100:
    do
    {
      return;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: param = null");
      return;
      if (str.equals("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD"))
      {
        if (paramContext != null)
        {
          k = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. DO_DOWNLOAD:id:" + k + " url:" + paramIntent);
          UniformDownloadMgr.a().d(paramIntent, paramContext);
          return;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. DO_DOWNLOAD: param = null");
        return;
      }
      if (str.equals("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD"))
      {
        if (paramContext != null)
        {
          k = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. TRY_DOWNLOAD:id:" + k + " url:" + paramIntent);
          UniformDownloadMgr.a().e(paramIntent, paramContext);
          return;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. TRY_DOWNLOAD: param = null");
        return;
      }
      if (!str.equals("com.tencent.mobileqq.UniformDownloadNfn.INSTALL")) {
        break;
      }
      paramContext = paramIntent.getStringExtra("_PARAM_FILEPATH");
      str = paramIntent.getStringExtra("_PARAM_PKGNAME");
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. DO_INSTALL: PH:" + paramContext + "PKGN:" + str);
      UniformDownloadMgr.a().a(paramContext);
    } while (str == null);
    int k = paramIntent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
    UniformDownloadMgr.a().a(str, k);
    return;
    if (str.equals("com.tencent.mobileqq.UniformDownloadNfn.BEDEL"))
    {
      if (paramContext != null)
      {
        k = paramContext.getInt("_notify_param_Id");
        str = paramContext.getString("_notify_param_Url");
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: id:" + k + " url:" + str);
        UniformDownloadMgr.a().f(str, paramContext);
      }
      for (;;)
      {
        paramContext = paramIntent.getStringExtra("_PARAM_PKGNAME");
        if (paramContext == null) {
          break;
        }
        k = paramIntent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. download suc. NOTIFICATION_BE_DEL: id:" + k);
        UniformDownloadMgr.a().a(paramContext, k);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: param = null. may not be clean info except download succ");
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] onReceive. unkown action:" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadNfnReceiver
 * JD-Core Version:    0.7.0.1
 */