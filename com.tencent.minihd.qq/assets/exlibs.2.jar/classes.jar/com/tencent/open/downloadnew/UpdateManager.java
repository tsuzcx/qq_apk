package com.tencent.open.downloadnew;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import com.tencent.apkupdate.ApkUpdateListener;
import com.tencent.apkupdate.ApkUpdateSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import lhu;

public class UpdateManager
  implements ApkUpdateListener
{
  protected static UpdateManager a;
  public static final String a;
  protected ConcurrentLinkedQueue a;
  
  static
  {
    jdField_a_of_type_JavaLangString = UpdateManager.class.getName();
  }
  
  protected UpdateManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    ApkUpdateSDK.getInstance().init(CommonDataAdapter.a().a());
    ApkUpdateSDK.getInstance().addListener(this);
  }
  
  public static UpdateManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager = new UpdateManager();
      }
      UpdateManager localUpdateManager = jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager;
      return localUpdateManager;
    }
    finally {}
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 54	com/tencent/open/downloadnew/UpdateManager:jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager	Lcom/tencent/open/downloadnew/UpdateManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localUpdateManager	UpdateManager
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public void a()
  {
    try
    {
      ApkUpdateSDK.getInstance().removeListener(this);
      ApkUpdateSDK.getInstance().destory();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        LogUtility.a(jdField_a_of_type_JavaLangString, "onDestroy>>>", localException);
      }
    }
    finally {}
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    String str2 = paramDownloadInfo.d;
    String str3 = paramDownloadInfo.k;
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    int i;
    for (String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + DownloadManager.b + "newApkDir";; str1 = CommonDataAdapter.a().a().getFilesDir().getAbsolutePath())
    {
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str1 = str1 + "/" + str2 + ".newGen.apk";
      LogUtility.b(jdField_a_of_type_JavaLangString, "patchNewApk>>>>>packageName=" + str2 + ", patchPath=" + str3 + ", newApkPath=" + str1);
      i = ApkUpdateSDK.getInstance().patchNewApk(str2, str3, str1);
      if (i != 0) {
        break;
      }
      LogUtility.b(jdField_a_of_type_JavaLangString, "patchNewApk>>>>>合成成功");
      paramDownloadInfo.a(4);
      paramDownloadInfo.k = str1;
      DownloadManager.a().e(paramDownloadInfo);
      LogUtility.c(jdField_a_of_type_JavaLangString, "info.path = " + paramDownloadInfo.k);
      DownloadManager.a().a(4, paramDownloadInfo);
      if (paramDownloadInfo.a) {
        DownloadManager.a().c(paramDownloadInfo);
      }
      StaticAnalyz.a("300", paramDownloadInfo.g, paramDownloadInfo.b);
      ThreadManager.b().post(new lhu(this, str1, paramDownloadInfo));
      return;
    }
    LogUtility.e(jdField_a_of_type_JavaLangString, "patchNewApk>>>>>合成失败 errcode = " + i);
    DownloadManager.a().a(-24, paramDownloadInfo);
  }
  
  public void a(UpdateManager.OnCheckUpdateListener paramOnCheckUpdateListener)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramOnCheckUpdateListener);
      return;
    }
    finally
    {
      paramOnCheckUpdateListener = finally;
      throw paramOnCheckUpdateListener;
    }
  }
  
  public void a(List paramList)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdate(paramList);
  }
  
  public void b(UpdateManager.OnCheckUpdateListener paramOnCheckUpdateListener)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramOnCheckUpdateListener);
      return;
    }
    finally
    {
      paramOnCheckUpdateListener = finally;
      throw paramOnCheckUpdateListener;
    }
  }
  
  public void b(List paramList)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdateList(paramList);
  }
  
  public void onCheckUpdateFailed(String paramString)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onCheckUpdateFailed>>>errMsg=" + paramString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext()) {
      ((UpdateManager.OnCheckUpdateListener)localIterator.next()).a(paramString);
    }
  }
  
  public void onCheckUpdateSucceed(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((UpdateManager.OnCheckUpdateListener)localIterator.next()).a(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager
 * JD-Core Version:    0.7.0.1
 */