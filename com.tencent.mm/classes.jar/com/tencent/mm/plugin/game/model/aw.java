package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class aw
{
  private static aw upO;
  private static TMQQDownloaderOpenSDK upP;
  
  public static int a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    AppMethodBeat.i(41657);
    try
    {
      dcr();
      paramTMQQDownloaderOpenSDKParam = dcs().getDownloadTaskState(paramTMQQDownloaderOpenSDKParam);
      if (paramTMQQDownloaderOpenSDKParam != null)
      {
        int i = paramTMQQDownloaderOpenSDKParam.mState;
        AppMethodBeat.o(41657);
        return i;
      }
    }
    catch (Exception paramTMQQDownloaderOpenSDKParam)
    {
      ae.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[] { paramTMQQDownloaderOpenSDKParam.getMessage() });
      AppMethodBeat.o(41657);
    }
    return -1;
  }
  
  public static void aC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41656);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
      AppMethodBeat.o(41656);
      return;
    }
    if (paramContext == null)
    {
      ae.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
      AppMethodBeat.o(41656);
      return;
    }
    ae.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[] { paramString });
    paramString = new a((byte)0).amY(paramString);
    try
    {
      dcr();
      dcs().startToDownloadTaskList(paramContext, paramString, true, true);
      AppMethodBeat.o(41656);
      return;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", paramContext, "", new Object[0]);
      AppMethodBeat.o(41656);
    }
  }
  
  public static aw dcr()
  {
    AppMethodBeat.i(41653);
    if (upO == null) {}
    try
    {
      if (upO == null) {
        upO = new aw();
      }
      aw localaw = upO;
      AppMethodBeat.o(41653);
      return localaw;
    }
    finally
    {
      AppMethodBeat.o(41653);
    }
  }
  
  private static TMQQDownloaderOpenSDK dcs()
  {
    AppMethodBeat.i(41654);
    if (upP == null)
    {
      localTMQQDownloaderOpenSDK = TMQQDownloaderOpenSDK.getInstance();
      upP = localTMQQDownloaderOpenSDK;
      localTMQQDownloaderOpenSDK.initQQDownloaderOpenSDK(ak.getContext());
    }
    TMQQDownloaderOpenSDK localTMQQDownloaderOpenSDK = upP;
    AppMethodBeat.o(41654);
    return localTMQQDownloaderOpenSDK;
  }
  
  public static void dct()
  {
    boolean bool2 = false;
    AppMethodBeat.i(41655);
    if (upP == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (upO == null) {
        bool2 = true;
      }
      ae.i("MicroMsg.QQDownloaderSDKWrapper", "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (upP != null) {
        upP.destroyQQDownloaderOpenSDK();
      }
      upP = null;
      upO = null;
      AppMethodBeat.o(41655);
      return;
    }
  }
  
  public static int k(Context paramContext, String paramString, int paramInt)
  {
    i = -1;
    AppMethodBeat.i(41658);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
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
        ae.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[] { paramContext.getMessage() });
        paramInt = i;
        continue;
      }
      ae.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(41658);
      return paramInt;
      ae.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[] { Integer.valueOf(paramContext.versionCode) });
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
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      AppMethodBeat.o(41659);
      return;
    }
    paramString = new a((byte)0).amY(paramString);
    try
    {
      dcr();
      dcs().startToAuthorized(paramContext, paramString, "1");
      AppMethodBeat.o(41659);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(41659);
    }
  }
  
  public static final class a
  {
    public String SNGAppId;
    public String actionFlag;
    public String taskApkId;
    public String taskAppId;
    public String taskPackageName;
    public int taskVersion;
    public String uin;
    public String uinType;
    public String upQ;
    public String via;
    
    private void amX(String paramString)
    {
      AppMethodBeat.i(41651);
      ae.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[] { paramString });
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
        AppMethodBeat.o(41651);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        this.taskApkId = paramString.optString("taskApkId");
        this.via = paramString.optString("via");
        this.taskVersion = paramString.optInt("taskVersion");
        this.upQ = paramString.optString("channelID");
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
        ae.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(41651);
      }
    }
    
    public final TMQQDownloaderOpenSDKParam amY(String paramString)
    {
      AppMethodBeat.i(41652);
      amX(paramString);
      paramString = new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.upQ, this.actionFlag);
      AppMethodBeat.o(41652);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw
 * JD-Core Version:    0.7.0.1
 */