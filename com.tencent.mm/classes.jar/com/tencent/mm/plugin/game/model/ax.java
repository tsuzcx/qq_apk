package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class ax
{
  private static ax npD;
  private static TMQQDownloaderOpenSDK npE;
  
  public static int a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    AppMethodBeat.i(111493);
    try
    {
      bGV();
      paramTMQQDownloaderOpenSDKParam = bGW().getDownloadTaskState(paramTMQQDownloaderOpenSDKParam);
      if (paramTMQQDownloaderOpenSDKParam != null)
      {
        int i = paramTMQQDownloaderOpenSDKParam.mState;
        AppMethodBeat.o(111493);
        return i;
      }
    }
    catch (Exception paramTMQQDownloaderOpenSDKParam)
    {
      ab.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[] { paramTMQQDownloaderOpenSDKParam.getMessage() });
      AppMethodBeat.o(111493);
    }
    return -1;
  }
  
  public static void aw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(111492);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
      AppMethodBeat.o(111492);
      return;
    }
    if (paramContext == null)
    {
      ab.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
      AppMethodBeat.o(111492);
      return;
    }
    ab.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[] { paramString });
    paramString = new a((byte)0).Qf(paramString);
    try
    {
      bGV();
      bGW().startToDownloadTaskList(paramContext, paramString, true, true);
      AppMethodBeat.o(111492);
      return;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", paramContext, "", new Object[0]);
      AppMethodBeat.o(111492);
    }
  }
  
  public static ax bGV()
  {
    AppMethodBeat.i(111489);
    if (npD == null) {}
    try
    {
      if (npD == null) {
        npD = new ax();
      }
      ax localax = npD;
      AppMethodBeat.o(111489);
      return localax;
    }
    finally
    {
      AppMethodBeat.o(111489);
    }
  }
  
  private static TMQQDownloaderOpenSDK bGW()
  {
    AppMethodBeat.i(111490);
    if (npE == null)
    {
      localTMQQDownloaderOpenSDK = TMQQDownloaderOpenSDK.getInstance();
      npE = localTMQQDownloaderOpenSDK;
      localTMQQDownloaderOpenSDK.initQQDownloaderOpenSDK(ah.getContext());
    }
    TMQQDownloaderOpenSDK localTMQQDownloaderOpenSDK = npE;
    AppMethodBeat.o(111490);
    return localTMQQDownloaderOpenSDK;
  }
  
  public static void bGX()
  {
    boolean bool2 = false;
    AppMethodBeat.i(111491);
    if (npE == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (npD == null) {
        bool2 = true;
      }
      ab.i("MicroMsg.QQDownloaderSDKWrapper", "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (npE != null) {
        npE.destroyQQDownloaderOpenSDK();
      }
      npE = null;
      npD = null;
      AppMethodBeat.o(111491);
      return;
    }
  }
  
  public static int k(Context paramContext, String paramString, int paramInt)
  {
    i = -1;
    AppMethodBeat.i(111494);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
      AppMethodBeat.o(111494);
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
        ab.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[] { paramContext.getMessage() });
        paramInt = i;
        continue;
      }
      ab.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111494);
      return paramInt;
      ab.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[] { Integer.valueOf(paramContext.versionCode) });
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
    AppMethodBeat.i(111495);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
      AppMethodBeat.o(111495);
      return;
    }
    paramString = new a((byte)0).Qf(paramString);
    try
    {
      bGV();
      bGW().startToAuthorized(paramContext, paramString, "1");
      AppMethodBeat.o(111495);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(111495);
    }
  }
  
  public static final class a
  {
    public String SNGAppId;
    public String actionFlag;
    public String npF;
    public String taskApkId;
    public String taskAppId;
    public String taskPackageName;
    public int taskVersion;
    public String uin;
    public String uinType;
    public String via;
    
    private void Qe(String paramString)
    {
      AppMethodBeat.i(111487);
      ab.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[] { paramString });
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
        AppMethodBeat.o(111487);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        this.taskApkId = paramString.optString("taskApkId");
        this.via = paramString.optString("via");
        this.taskVersion = paramString.optInt("taskVersion");
        this.npF = paramString.optString("channelID");
        this.uin = paramString.optString("uin");
        this.SNGAppId = paramString.optString("SNGAppId");
        this.taskAppId = paramString.optString("taskAppId");
        this.uinType = paramString.optString("uinType");
        this.taskPackageName = paramString.optString("taskPackageName");
        this.actionFlag = paramString.optString("actionFlag");
        AppMethodBeat.o(111487);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(111487);
      }
    }
    
    public final TMQQDownloaderOpenSDKParam Qf(String paramString)
    {
      AppMethodBeat.i(111488);
      Qe(paramString);
      paramString = new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.npF, this.actionFlag);
      AppMethodBeat.o(111488);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ax
 * JD-Core Version:    0.7.0.1
 */