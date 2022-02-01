package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class UniformDownloadPkgInstallReceiver
  extends BroadcastReceiver
{
  private static IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private static UniformDownloadPkgInstallReceiver jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadPkgInstallReceiver = new UniformDownloadPkgInstallReceiver();
  public static final String a = "UniformDownloadPkgInstallReceiver<FileAssistant>";
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
    jdField_a_of_type_AndroidContentIntentFilter.addDataScheme("package");
    jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    paramContext.registerReceiver(jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadPkgInstallReceiver, jdField_a_of_type_AndroidContentIntentFilter);
  }
  
  public static void b(Context paramContext)
  {
    paramContext.unregisterReceiver(jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadPkgInstallReceiver);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    paramContext = paramIntent.getDataString();
    QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] package operate broadcast. action:" + (String)localObject + " pkgName:" + paramContext);
    if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase((String)localObject)) || ("android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase((String)localObject)))
    {
      paramIntent = UniformDownloadMgr.a().a(paramContext, true);
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          localObject = (UniformDownloadMgr.SucDownloadInfo)paramIntent.next();
          if (localObject != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] send cancel notification.pkgName:" + paramContext + " notificationId:" + ((UniformDownloadMgr.SucDownloadInfo)localObject).a);
            UniformDownloadNfn.a().c(((UniformDownloadMgr.SucDownloadInfo)localObject).a, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver
 * JD-Core Version:    0.7.0.1
 */