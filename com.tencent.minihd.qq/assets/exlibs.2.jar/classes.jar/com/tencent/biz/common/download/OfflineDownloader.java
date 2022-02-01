package com.tencent.biz.common.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import android.text.TextUtils;
import cdh;
import cdi;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class OfflineDownloader
{
  public static final int a = 0;
  private static ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new cdi();
  private static TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  public static final String a = "OfflineDownload";
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static final int b = 10;
  protected static final String b = ".tmp";
  public static final int c = 11;
  public static final int d = 12;
  public static final int e = 13;
  public static final int f = 14;
  public static final int g = 15;
  public static final int h = 16;
  
  public static int a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected())) {
        switch (paramContext.getType())
        {
        default: 
          return 4;
        case 1: 
          return 1;
        }
      }
    }
    switch (paramContext.getSubtype())
    {
    case 7: 
    case 10: 
    case 11: 
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
      return 2;
    }
    return 3;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "NetWorkState Unavailabel");
      }
      return null;
    }
    NetworkInfo localNetworkInfo = paramContext.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "default NetWorkState Availabel");
      }
      return localNetworkInfo;
    }
    paramContext = paramContext.getAllNetworkInfo();
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        if (paramContext[i].getState() == NetworkInfo.State.CONNECTED)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OfflineDownload", 2, "NetWorkState Availabel");
          }
          return paramContext[i];
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack)
  {
    a(paramContext, paramString1, "0", paramString2, paramAsyncBack, null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack, Map paramMap)
  {
    a(paramContext, paramString1, "0", paramString2, paramAsyncBack, paramMap);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, AsyncBack paramAsyncBack, Map paramMap)
  {
    if (paramAsyncBack == null) {}
    int i;
    for (;;)
    {
      return;
      if (paramContext == null)
      {
        paramAsyncBack.a(paramString1, 11);
        return;
      }
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
      {
        paramAsyncBack.a(paramString1, 12);
        return;
      }
      if (a(paramContext) == null)
      {
        paramAsyncBack.a(paramString1, 10);
        return;
      }
      i = paramString3.lastIndexOf("/");
      if (!new File(paramString3.substring(0, i)).exists())
      {
        paramAsyncBack.a(paramString1, 13);
        return;
      }
      String str = paramString3.substring(i + 1);
      paramString2 = new cdh(str, paramString3, paramString2, paramAsyncBack);
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      if (jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null) {
        jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload" + Process.myPid());
      }
      jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
      try
      {
        i = jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.startDownloadTask(paramString1, 0, "resource/tm.android.unknown", str, paramMap);
        if (i == 0)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("OfflineDownload", 2, "offline downloader start, url: " + paramString1);
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + -1 + ", url: " + paramString1);
        }
        paramAsyncBack.a(paramString1, 10);
        return;
      }
    }
    if (i == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "offline downloader start fail, file exists, url: " + paramString1);
      }
      b(jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient, paramString2, paramString1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + i + ", url: " + paramString1);
    }
    paramAsyncBack.a(paramString1, 10);
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString + ".tmp");
    } while (!paramString.exists());
    paramString.delete();
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "NetWorkState Unavailabel");
      }
    }
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if (paramContext[i].getState() == NetworkInfo.State.CONNECTED)
          {
            if (QLog.isColorLevel()) {
              QLog.d("OfflineDownload", 2, "NetWorkState Availabel");
            }
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static void b(AsyncBack paramAsyncBack, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, paramString3 + ", bid: " + paramString2 + ", errCode: " + paramInt);
    }
    if ((paramAsyncBack != null) && (paramInt >= 0)) {
      paramAsyncBack.a(paramString1, paramInt);
    }
    jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
  }
  
  private static void b(TMAssistantDownloadClient paramTMAssistantDownloadClient, cdh paramcdh, String paramString)
  {
    TMAssistantDownloadClient localTMAssistantDownloadClient = null;
    Object localObject = null;
    try
    {
      paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (paramTMAssistantDownloadClient == null) {}
      for (paramTMAssistantDownloadClient = localObject;; paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.mSavePath)
      {
        localTMAssistantDownloadClient = paramTMAssistantDownloadClient;
        if (!TextUtils.isEmpty(paramTMAssistantDownloadClient)) {
          break;
        }
        b(paramcdh.a, paramString, paramcdh.c, 14, "get current download path fail after download");
        return;
      }
      paramTMAssistantDownloadClient = new File(localTMAssistantDownloadClient);
    }
    catch (Exception paramTMAssistantDownloadClient)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("OfflineDownload", 4, paramTMAssistantDownloadClient.toString());
      }
    }
    finally
    {
      if (TextUtils.isEmpty(null))
      {
        b(paramcdh.a, paramString, paramcdh.c, 14, "get current download path fail after download");
        return;
      }
    }
    if (!paramTMAssistantDownloadClient.exists())
    {
      b(paramcdh.a, paramString, paramcdh.c, 15, "cannot get current file after download");
      return;
    }
    boolean bool = FileUtils.b(localTMAssistantDownloadClient, paramcdh.b);
    if (!bool) {
      FileUtils.a(localTMAssistantDownloadClient, paramcdh.b);
    }
    if (!bool)
    {
      b(paramcdh.a, paramString, paramcdh.c, 16, "rename file fail after download");
      paramTMAssistantDownloadClient.delete();
      return;
    }
    b(paramcdh.a, paramString, paramcdh.c, 0, "offline zip download success");
  }
  
  public static void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)) {
      return;
    }
    jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.pauseDownloadTask(paramString);
    jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.common.download.OfflineDownloader
 * JD-Core Version:    0.7.0.1
 */