package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;

public class ay
{
  private static ay kRB;
  private static TMQQDownloaderOpenSDK kRC;
  
  public static int a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    try
    {
      aZP();
      paramTMQQDownloaderOpenSDKParam = aZQ().getDownloadTaskState(paramTMQQDownloaderOpenSDKParam);
      if (paramTMQQDownloaderOpenSDKParam != null)
      {
        int i = paramTMQQDownloaderOpenSDKParam.mState;
        return i;
      }
    }
    catch (Exception paramTMQQDownloaderOpenSDKParam)
    {
      y.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[] { paramTMQQDownloaderOpenSDKParam.getMessage() });
    }
    return -1;
  }
  
  public static ay aZP()
  {
    if (kRB == null) {}
    try
    {
      if (kRB == null) {
        kRB = new ay();
      }
      return kRB;
    }
    finally {}
  }
  
  private static TMQQDownloaderOpenSDK aZQ()
  {
    if (kRC == null)
    {
      TMQQDownloaderOpenSDK localTMQQDownloaderOpenSDK = TMQQDownloaderOpenSDK.getInstance();
      kRC = localTMQQDownloaderOpenSDK;
      localTMQQDownloaderOpenSDK.initQQDownloaderOpenSDK(ae.getContext());
    }
    return kRC;
  }
  
  public static void aZR()
  {
    boolean bool2 = false;
    if (kRC == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (kRB == null) {
        bool2 = true;
      }
      y.i("MicroMsg.QQDownloaderSDKWrapper", "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (kRC != null) {
        kRC.destroyQQDownloaderOpenSDK();
      }
      kRC = null;
      kRB = null;
      return;
    }
  }
  
  public static void am(Context paramContext, String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
      return;
    }
    if (paramContext == null)
    {
      y.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
      return;
    }
    y.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[] { paramString });
    paramString = new ay.a((byte)0).EN(paramString);
    try
    {
      aZP();
      aZQ().startToDownloadTaskList(paramContext, paramString, true, true);
      return;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", paramContext, "", new Object[0]);
    }
  }
  
  public static int h(Context paramContext, String paramString, int paramInt)
  {
    i = -1;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
      return -1;
    }
    for (;;)
    {
      try
      {
        paramContext = p.getPackageInfo(paramContext, paramString);
        if (paramContext != null) {
          continue;
        }
        paramInt = 1;
      }
      catch (Exception paramContext)
      {
        int j;
        y.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[] { paramContext.getMessage() });
        paramInt = i;
        continue;
      }
      y.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[] { Integer.valueOf(paramInt) });
      return paramInt;
      y.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[] { Integer.valueOf(paramContext.versionCode) });
      j = paramContext.versionCode;
      if (j >= paramInt) {
        paramInt = 0;
      } else {
        paramInt = 2;
      }
    }
  }
  
  public static void startToAuthorized(Context paramContext, String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      return;
    }
    paramString = new ay.a((byte)0).EN(paramString);
    try
    {
      aZP();
      aZQ().startToAuthorized(paramContext, paramString, "1");
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[] { paramContext.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ay
 * JD-Core Version:    0.7.0.1
 */