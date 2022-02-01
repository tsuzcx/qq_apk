package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import inc;
import ind;
import inf;
import ing;
import inh;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class FileViewerFacade
{
  static final String a = "<FileAssistant>FileViewerFacade";
  
  public static int a(String paramString)
  {
    Iterator localIterator = BaseApplication.getContext().getPackageManager().getInstalledPackages(0).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if (localPackageInfo.packageName.equalsIgnoreCase(paramString)) {
        return localPackageInfo.versionCode;
      }
    }
    return -1;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("<FileAssistant>FileViewerFacade", 2, "app is null");
      }
    }
    do
    {
      return;
      if ((paramString1 == null) || (!FileUtil.a(paramString1)))
      {
        FMToastUtil.a(2131362429);
        return;
      }
      if (FileManagerUtil.b(paramQQAppInterface, paramString2) == true)
      {
        b(paramActivity, paramQQAppInterface, paramString1, paramString2);
        return;
      }
    } while (FileManagerUtil.a(paramQQAppInterface, paramString2) != true);
    c(paramActivity, paramQQAppInterface, paramString1, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, IFileBrowser paramIFileBrowser)
  {
    String str1 = paramFileManagerEntity.strFilePath;
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FileViewerFacade", 2, "open[" + str1 + "]");
    }
    if ((str1 != null) && (str1.lastIndexOf(".rename") > 0))
    {
      String str3 = str1.replace(".rename", "");
      String str2 = str3.substring(0, str3.lastIndexOf("."));
      str3 = str3.substring(str3.lastIndexOf(".")).replaceAll("[0-9]*", "").replace("(", "").replace(")", "");
      str2 = str2 + str3;
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FileViewerFacade", 2, "file maybe renmaed,realName[" + str2 + "]");
      }
      FMDialogUtil.a(paramActivity, paramActivity.getString(2131362411), 2131362413, new inc(str2, str1, paramFileManagerEntity, paramQQAppInterface, paramActivity, paramIFileBrowser));
      return;
    }
    FileManagerUtil.b(paramActivity, paramFileManagerEntity.strFilePath);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    int i;
    do
    {
      String str;
      do
      {
        return false;
        str = FMConfig.c(paramQQAppInterface, "OpenForQQMusic", "SupportVersion");
      } while (str == null);
      i = Integer.valueOf(str).intValue();
    } while (a("com.tencent.qqmusic") < i);
    return b(paramQQAppInterface, paramString);
  }
  
  static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = FileUtil.a(paramString2);
    long l = FileUtil.a(paramString1);
    if (!a(paramQQAppInterface, paramString2))
    {
      paramString1 = new FileManagerReporter.fileAssistantReportData();
      paramString1.b = "file_local_qqmusic_uninstall";
      paramString1.c = str;
      paramString1.a = l;
      FileManagerReporter.a(paramQQAppInterface.a(), paramString1);
      DialogUtil.a(paramActivity, 233, paramActivity.getString(2131366765), paramActivity.getString(2131367614), new ind(str, l, paramQQAppInterface, paramActivity), new inf()).show();
      return;
    }
    paramString2 = new FileManagerReporter.fileAssistantReportData();
    paramString2.b = "file_local_qqmusic_opened";
    paramString2.c = str;
    paramString2.a = l;
    FileManagerReporter.a(paramQQAppInterface.a(), paramString2);
    paramQQAppInterface = new Intent("com.tencent.qqmusic.forthird.activity.PLAYER2");
    paramQQAppInterface.putExtra("file_path", paramString1);
    paramQQAppInterface.putExtra("from", 268435457);
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FMConfig.c(paramQQAppInterface, "OpenForQQMusic", "FormatSupport");
    String str = FileUtil.a(paramString);
    if ((paramQQAppInterface != null) && (str != null) && (str.length() > 0) && (paramQQAppInterface.indexOf(str) >= 0)) {}
    while (FileManagerUtil.a(paramString) == 1) {
      return true;
    }
    return false;
  }
  
  static void c(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = FileUtil.a(paramString2);
    long l = FileUtil.a(paramString1);
    if (!c(paramQQAppInterface, paramString2))
    {
      paramString1 = new FileManagerReporter.fileAssistantReportData();
      paramString1.b = "file_local_qqbrowse_uninstall";
      paramString1.c = str;
      paramString1.a = l;
      FileManagerReporter.a(paramQQAppInterface.a(), paramString1);
      DialogUtil.a(paramActivity, 233, paramActivity.getString(2131367512), paramActivity.getString(2131367615), new ing(str, l, paramQQAppInterface, paramActivity), new inh()).show();
      return;
    }
    paramString2 = new FileManagerReporter.fileAssistantReportData();
    paramString2.b = "file_local_qqbrowse_opened";
    paramString2.c = str;
    paramString2.a = l;
    FileManagerReporter.a(paramQQAppInterface.a(), paramString2);
    new Intent("com.tencent.QQBrowser.action.sdk.document");
    paramQQAppInterface = new Intent("com.tencent.QQBrowser.action.sdk.document");
    paramQQAppInterface.setFlags(268435456);
    paramString2 = new File(paramString1);
    paramQQAppInterface.putExtra("key_reader_sdk_id", 2);
    paramQQAppInterface.putExtra("key_reader_sdk_path", paramString1);
    paramQQAppInterface.putExtra("key_reader_sdk_type", 0);
    paramQQAppInterface.setData(Uri.fromFile(paramString2));
    FileProvider7Helper.intentCompatForN(paramActivity, paramQQAppInterface);
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    while (a("com.tencent.mtt") < 561300) {
      return false;
    }
    return d(paramQQAppInterface, paramString);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = FileUtil.a(paramString);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "mtt/" + str.replace(".", ""));
    paramQQAppInterface = paramQQAppInterface.a().getApplicationContext().getPackageManager().queryIntentActivities(localIntent, 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext()) {
        if (((ResolveInfo)paramQQAppInterface.next()).activityInfo.packageName.contains("com.tencent.mtt")) {
          return true;
        }
      }
    }
    paramQQAppInterface = str + "|";
    return (paramQQAppInterface != null) && (paramQQAppInterface.length() > 0) && (".rar|.zip|.7z|.doc|.docx|.ppt|.pptx|.xls|.xlsx|.txt|.pdf|.epub|.chm|.ini|.log|.bat|.php|.js|.lrc|.m3u8|.mp4|.flv|.avi|.3gp|.3gpp|.webm|.ts|.ogv|.asf|.wmv|.rmvb|.rm|.f4v|.mov|.mpg|.mkv|.mpeg|".contains(paramQQAppInterface.toLowerCase()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade
 * JD-Core Version:    0.7.0.1
 */