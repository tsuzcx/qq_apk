package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class aw
{
  private static aw rYY;
  private static TMQQDownloaderOpenSDK rYZ;
  
  public static int a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    AppMethodBeat.i(41657);
    try
    {
      cDQ();
      paramTMQQDownloaderOpenSDKParam = cDR().getDownloadTaskState(paramTMQQDownloaderOpenSDKParam);
      if (paramTMQQDownloaderOpenSDKParam != null)
      {
        int i = paramTMQQDownloaderOpenSDKParam.mState;
        AppMethodBeat.o(41657);
        return i;
      }
    }
    catch (Exception paramTMQQDownloaderOpenSDKParam)
    {
      ad.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[] { paramTMQQDownloaderOpenSDKParam.getMessage() });
      AppMethodBeat.o(41657);
    }
    return -1;
  }
  
  public static void aw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41656);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
      AppMethodBeat.o(41656);
      return;
    }
    if (paramContext == null)
    {
      ad.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
      AppMethodBeat.o(41656);
      return;
    }
    ad.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[] { paramString });
    paramString = new a((byte)0).acE(paramString);
    try
    {
      cDQ();
      cDR().startToDownloadTaskList(paramContext, paramString, true, true);
      AppMethodBeat.o(41656);
      return;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", paramContext, "", new Object[0]);
      AppMethodBeat.o(41656);
    }
  }
  
  public static aw cDQ()
  {
    AppMethodBeat.i(41653);
    if (rYY == null) {}
    try
    {
      if (rYY == null) {
        rYY = new aw();
      }
      aw localaw = rYY;
      AppMethodBeat.o(41653);
      return localaw;
    }
    finally
    {
      AppMethodBeat.o(41653);
    }
  }
  
  private static TMQQDownloaderOpenSDK cDR()
  {
    AppMethodBeat.i(41654);
    if (rYZ == null)
    {
      localTMQQDownloaderOpenSDK = TMQQDownloaderOpenSDK.getInstance();
      rYZ = localTMQQDownloaderOpenSDK;
      localTMQQDownloaderOpenSDK.initQQDownloaderOpenSDK(aj.getContext());
    }
    TMQQDownloaderOpenSDK localTMQQDownloaderOpenSDK = rYZ;
    AppMethodBeat.o(41654);
    return localTMQQDownloaderOpenSDK;
  }
  
  public static void cDS()
  {
    boolean bool2 = false;
    AppMethodBeat.i(41655);
    if (rYZ == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (rYY == null) {
        bool2 = true;
      }
      ad.i("MicroMsg.QQDownloaderSDKWrapper", "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (rYZ != null) {
        rYZ.destroyQQDownloaderOpenSDK();
      }
      rYZ = null;
      rYY = null;
      AppMethodBeat.o(41655);
      return;
    }
  }
  
  public static int l(Context paramContext, String paramString, int paramInt)
  {
    i = -1;
    AppMethodBeat.i(41658);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
      AppMethodBeat.o(41658);
      return -1;
    }
    for (;;)
    {
      try
      {
        paramContext = b.getPackageInfo(paramContext, paramString);
        if (paramContext != null) {
          continue;
        }
        paramInt = 1;
      }
      catch (Exception paramContext)
      {
        int j;
        ad.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[] { paramContext.getMessage() });
        paramInt = i;
        continue;
      }
      ad.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(41658);
      return paramInt;
      ad.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[] { Integer.valueOf(paramContext.versionCode) });
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
    AppMethodBeat.i(41659);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      AppMethodBeat.o(41659);
      return;
    }
    paramString = new a((byte)0).acE(paramString);
    try
    {
      cDQ();
      cDR().startToAuthorized(paramContext, paramString, "1");
      AppMethodBeat.o(41659);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(41659);
    }
  }
  
  public static final class a
  {
    public String SNGAppId;
    public String actionFlag;
    public String rZa;
    public String taskApkId;
    public String taskAppId;
    public String taskPackageName;
    public int taskVersion;
    public String uin;
    public String uinType;
    public String via;
    
    private void acD(String paramString)
    {
      AppMethodBeat.i(41651);
      ad.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[] { paramString });
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
        AppMethodBeat.o(41651);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        this.taskApkId = paramString.optString("taskApkId");
        this.via = paramString.optString("via");
        this.taskVersion = paramString.optInt("taskVersion");
        this.rZa = paramString.optString("channelID");
        this.uin = paramString.optString("uin");
        this.SNGAppId = paramString.optString("SNGAppId");
        this.taskAppId = paramString.optString("taskAppId");
        this.uinType = paramString.optString("uinType");
        this.taskPackageName = paramString.optString("taskPackageName");
        this.actionFlag = paramString.optString("actionFlag");
        AppMethodBeat.o(41651);
        return;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(41651);
      }
    }
    
    public final TMQQDownloaderOpenSDKParam acE(String paramString)
    {
      AppMethodBeat.i(41652);
      acD(paramString);
      paramString = new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.rZa, this.actionFlag);
      AppMethodBeat.o(41652);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw
 * JD-Core Version:    0.7.0.1
 */