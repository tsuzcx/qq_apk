package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class aw
{
  private static aw tgQ;
  private static TMQQDownloaderOpenSDK tgR;
  
  public static int a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    AppMethodBeat.i(41657);
    try
    {
      cRa();
      paramTMQQDownloaderOpenSDKParam = cRb().getDownloadTaskState(paramTMQQDownloaderOpenSDKParam);
      if (paramTMQQDownloaderOpenSDKParam != null)
      {
        int i = paramTMQQDownloaderOpenSDKParam.mState;
        AppMethodBeat.o(41657);
        return i;
      }
    }
    catch (Exception paramTMQQDownloaderOpenSDKParam)
    {
      ac.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[] { paramTMQQDownloaderOpenSDKParam.getMessage() });
      AppMethodBeat.o(41657);
    }
    return -1;
  }
  
  public static void ax(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41656);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
      AppMethodBeat.o(41656);
      return;
    }
    if (paramContext == null)
    {
      ac.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
      AppMethodBeat.o(41656);
      return;
    }
    ac.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[] { paramString });
    paramString = new a((byte)0).ahw(paramString);
    try
    {
      cRa();
      cRb().startToDownloadTaskList(paramContext, paramString, true, true);
      AppMethodBeat.o(41656);
      return;
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", paramContext, "", new Object[0]);
      AppMethodBeat.o(41656);
    }
  }
  
  public static aw cRa()
  {
    AppMethodBeat.i(41653);
    if (tgQ == null) {}
    try
    {
      if (tgQ == null) {
        tgQ = new aw();
      }
      aw localaw = tgQ;
      AppMethodBeat.o(41653);
      return localaw;
    }
    finally
    {
      AppMethodBeat.o(41653);
    }
  }
  
  private static TMQQDownloaderOpenSDK cRb()
  {
    AppMethodBeat.i(41654);
    if (tgR == null)
    {
      localTMQQDownloaderOpenSDK = TMQQDownloaderOpenSDK.getInstance();
      tgR = localTMQQDownloaderOpenSDK;
      localTMQQDownloaderOpenSDK.initQQDownloaderOpenSDK(ai.getContext());
    }
    TMQQDownloaderOpenSDK localTMQQDownloaderOpenSDK = tgR;
    AppMethodBeat.o(41654);
    return localTMQQDownloaderOpenSDK;
  }
  
  public static void cRc()
  {
    boolean bool2 = false;
    AppMethodBeat.i(41655);
    if (tgR == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (tgQ == null) {
        bool2 = true;
      }
      ac.i("MicroMsg.QQDownloaderSDKWrapper", "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (tgR != null) {
        tgR.destroyQQDownloaderOpenSDK();
      }
      tgR = null;
      tgQ = null;
      AppMethodBeat.o(41655);
      return;
    }
  }
  
  public static int l(Context paramContext, String paramString, int paramInt)
  {
    i = -1;
    AppMethodBeat.i(41658);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
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
        ac.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[] { paramContext.getMessage() });
        paramInt = i;
        continue;
      }
      ac.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(41658);
      return paramInt;
      ac.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[] { Integer.valueOf(paramContext.versionCode) });
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
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      AppMethodBeat.o(41659);
      return;
    }
    paramString = new a((byte)0).ahw(paramString);
    try
    {
      cRa();
      cRb().startToAuthorized(paramContext, paramString, "1");
      AppMethodBeat.o(41659);
      return;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[] { paramContext.getMessage() });
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
    public String tgS;
    public String uin;
    public String uinType;
    public String via;
    
    private void ahv(String paramString)
    {
      AppMethodBeat.i(41651);
      ac.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[] { paramString });
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
        AppMethodBeat.o(41651);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        this.taskApkId = paramString.optString("taskApkId");
        this.via = paramString.optString("via");
        this.taskVersion = paramString.optInt("taskVersion");
        this.tgS = paramString.optString("channelID");
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
        ac.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(41651);
      }
    }
    
    public final TMQQDownloaderOpenSDKParam ahw(String paramString)
    {
      AppMethodBeat.i(41652);
      ahv(paramString);
      paramString = new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.tgS, this.actionFlag);
      AppMethodBeat.o(41652);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw
 * JD-Core Version:    0.7.0.1
 */