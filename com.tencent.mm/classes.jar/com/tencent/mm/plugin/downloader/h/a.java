package com.tencent.mm.plugin.downloader.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.plugin.downloader.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends j
{
  private byte[] eKs;
  HashMap<String, Long> kYe;
  HashMap<String, Long> kYf;
  private HashMap<String, Long> kZC;
  HashMap<String, Long> kZD;
  private ConcurrentHashMap<String, Integer> kZE;
  HashSet<Long> kZF;
  Map<String, String> kZG;
  ap kZH;
  private ITMAssistantDownloadSDKClientListener kZI;
  private TMAssistantDownloadSDKClient mClient;
  Context mContext;
  
  public a(com.tencent.mm.plugin.downloader.model.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(2500);
    this.mClient = null;
    this.kZG = null;
    this.kYe = new HashMap();
    this.kYf = new HashMap();
    this.eKs = new byte[0];
    this.kZH = new ap(Looper.getMainLooper(), new a.4(this), false);
    this.kZI = new a.5(this);
    this.mContext = ah.getContext();
    this.kZC = new HashMap();
    this.kZD = new HashMap();
    this.kZE = new ConcurrentHashMap();
    this.kZF = new HashSet();
    HashMap localHashMap = new HashMap();
    String str = System.getProperty("http.agent");
    ab.i("MicroMsg.FileDownloaderImplTMAssistant", str);
    paramc = str;
    if (bo.isNullOrNil(str)) {
      paramc = "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)";
    }
    str = paramc + " MicroMessenger";
    PackageInfo localPackageInfo = getPackageInfo(this.mContext, ah.getPackageName());
    paramc = str;
    if (localPackageInfo != null)
    {
      paramc = str + "/";
      paramc = paramc + localPackageInfo.versionName;
      paramc = paramc + localPackageInfo.versionCode;
    }
    str = at.getNetTypeString(ah.getContext());
    paramc = paramc + " NetType/" + str;
    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", new Object[] { paramc });
    localHashMap.put("User-Agent", paramc);
    this.kZG = localHashMap;
    AppMethodBeat.o(2500);
  }
  
  private static void bjB()
  {
    AppMethodBeat.i(2509);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(TMAssistantFile.getSavePathRootDir() + "/.tmp/");
    if (!localb.exists()) {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", new Object[] { Boolean.valueOf(localb.mkdirs()) });
    }
    AppMethodBeat.o(2509);
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(2508);
    if (paramString == null)
    {
      ab.e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
      AppMethodBeat.o(2508);
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(2508);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", paramContext, "", new Object[0]);
      AppMethodBeat.o(2508);
    }
    return null;
  }
  
  public final long a(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(2501);
    com.tencent.mm.sdk.g.d.ysn.a(new a.1(this, parama), "MicroMsg.FileDownloaderImplTMAssistant");
    long l = parama.field_downloadId;
    AppMethodBeat.o(2501);
    return l;
  }
  
  public final long a(com.tencent.mm.plugin.downloader.model.g paramg)
  {
    AppMethodBeat.i(2502);
    if ((paramg == null) || (bo.isNullOrNil(paramg.gWh)))
    {
      ab.e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
      AppMethodBeat.o(2502);
      return -1L;
    }
    String str1 = paramg.gWh;
    String str2 = paramg.mAppId;
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JG(str1);
    if (locala != null)
    {
      localObject = iA(locala.field_downloadId);
      if (((FileDownloadTaskInfo)localObject).status == 1)
      {
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, running, return");
        l = ((FileDownloadTaskInfo)localObject).id;
        AppMethodBeat.o(2502);
        return l;
      }
      if (((FileDownloadTaskInfo)localObject).status == 6)
      {
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, md5 checking, return");
        l = ((FileDownloadTaskInfo)localObject).id;
        AppMethodBeat.o(2502);
        return l;
      }
      if (((FileDownloadTaskInfo)localObject).status == 3)
      {
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, has download finished, install");
        if (paramg.kYF) {
          com.tencent.mm.plugin.downloader.i.a.a(((FileDownloadTaskInfo)localObject).id, false, null);
        }
        l = ((FileDownloadTaskInfo)localObject).id;
        AppMethodBeat.o(2502);
        return l;
      }
    }
    Object localObject = locala;
    if (locala == null) {
      localObject = com.tencent.mm.plugin.downloader.model.d.JD(str2);
    }
    bjB();
    com.tencent.mm.plugin.downloader.model.d.JE(str1);
    com.tencent.mm.plugin.downloader.model.d.JF(str2);
    locala = h.c(paramg);
    if ((paramg.kYJ) && (localObject != null))
    {
      locala.field_downloadId = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId;
      locala.field_status = 0;
      locala.field_downloaderType = 2;
      if (localObject == null) {
        break label395;
      }
      if (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status != 2) {
        break label364;
      }
      locala.field_startState = com.tencent.mm.plugin.downloader.a.b.kVC;
    }
    label395:
    for (;;)
    {
      if (paramg.kYG) {
        locala.field_md5 = h.JO(locala.field_downloadUrl);
      }
      if ((!paramg.hzD) || (at.isWifi(ah.getContext()))) {
        break label404;
      }
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "downloadInWifi, not wifi");
      locala.field_status = 0;
      locala.field_downloadInWifi = true;
      com.tencent.mm.plugin.downloader.model.d.d(locala);
      l = locala.field_downloadId;
      AppMethodBeat.o(2502);
      return l;
      locala.field_downloadId = System.currentTimeMillis();
      break;
      label364:
      if (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 4)
      {
        locala.field_startState = com.tencent.mm.plugin.downloader.a.b.kVC;
      }
      else
      {
        locala.field_startState = com.tencent.mm.plugin.downloader.a.b.kVB;
        continue;
        locala.field_startState = 0;
      }
    }
    label404:
    if (at.isWifi(ah.getContext())) {
      locala.field_downloadInWifi = true;
    }
    com.tencent.mm.plugin.downloader.model.d.d(locala);
    long l = a(locala);
    AppMethodBeat.o(2502);
    return l;
  }
  
  final boolean bjA()
  {
    AppMethodBeat.i(2505);
    if ((this.kZF == null) || (this.kZF.size() == 0))
    {
      TMAssistantDownloadSDKManager.getInstance(this.mContext).releaseDownloadSDKClient("WechatDownloadClient");
      if (this.mClient != null) {
        this.mClient.unRegisterDownloadTaskListener(this.kZI);
      }
      this.mClient = null;
      TMAssistantDownloadSDKManager.closeAllService(this.mContext);
      try
      {
        Intent localIntent = new Intent(this.mContext, TMAssistantDownloadSDKService.class);
        this.mContext.stopService(localIntent);
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
        AppMethodBeat.o(2505);
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + localException.toString());
        }
      }
    }
    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
    AppMethodBeat.o(2505);
    return false;
  }
  
  final void cancelNotification(String paramString)
  {
    AppMethodBeat.i(2507);
    synchronized (this.eKs)
    {
      Integer localInteger = (Integer)this.kZE.get(paramString);
      if (localInteger == null)
      {
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
        AppMethodBeat.o(2507);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      this.kZE.remove(paramString);
      AppMethodBeat.o(2507);
      return;
    }
  }
  
  final TMAssistantDownloadSDKClient getClient()
  {
    AppMethodBeat.i(2506);
    if (this.mClient == null)
    {
      this.mClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient("WechatDownloadClient");
      this.mClient.registerDownloadTaskListener(this.kZI);
    }
    this.kZH.ag(240000L, 240000L);
    TMAssistantDownloadSDKClient localTMAssistantDownloadSDKClient = this.mClient;
    AppMethodBeat.o(2506);
    return localTMAssistantDownloadSDKClient;
  }
  
  public final FileDownloadTaskInfo iA(long paramLong)
  {
    AppMethodBeat.i(2504);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = paramLong;
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((locala == null) || (bo.isNullOrNil(locala.field_downloadUrl)))
    {
      AppMethodBeat.o(2504);
      return localFileDownloadTaskInfo;
    }
    localFileDownloadTaskInfo.url = locala.field_downloadUrl;
    localFileDownloadTaskInfo.status = locala.field_status;
    localFileDownloadTaskInfo.path = locala.field_filePath;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
    if (!com.tencent.mm.vfs.e.cN(locala.field_filePath))
    {
      localFileDownloadTaskInfo.kYX = 0L;
      localFileDownloadTaskInfo.jyU = 0L;
      localFileDownloadTaskInfo.cqq = locala.field_md5;
      if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
        break label348;
      }
      localTMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo)new a.3(this, localFileDownloadTaskInfo.url).b(com.tencent.mm.kernel.g.RO().caB());
    }
    label348:
    Object localObject;
    for (;;)
    {
      if (localTMAssistantDownloadTaskInfo != null) {
        break label395;
      }
      if (localFileDownloadTaskInfo.status == 1) {
        localFileDownloadTaskInfo.status = 0;
      }
      if (((localFileDownloadTaskInfo.status == 6) || (localFileDownloadTaskInfo.status == 3)) && (!com.tencent.mm.vfs.e.cN(localFileDownloadTaskInfo.path))) {
        localFileDownloadTaskInfo.status = 0;
      }
      if ((localFileDownloadTaskInfo.status == 6) && (!com.tencent.mm.plugin.downloader.model.e.iN(localFileDownloadTaskInfo.id))) {
        localFileDownloadTaskInfo.status = 3;
      }
      if (bo.isNullOrNil(locala.field_filePath))
      {
        locala.field_filePath = localFileDownloadTaskInfo.path;
        com.tencent.mm.plugin.downloader.model.d.e(locala);
      }
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: appId: %s, status: %d, url: %s, path: %s", new Object[] { locala.field_appId, Integer.valueOf(localFileDownloadTaskInfo.status), localFileDownloadTaskInfo.url, localFileDownloadTaskInfo.path });
      AppMethodBeat.o(2504);
      return localFileDownloadTaskInfo;
      localFileDownloadTaskInfo.kYX = locala.field_downloadedSize;
      localFileDownloadTaskInfo.jyU = locala.field_totalSize;
      break;
      try
      {
        localTMAssistantDownloadTaskInfo = getClient().getDownloadTaskState(localFileDownloadTaskInfo.url);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + localException.toString());
        localObject = null;
      }
    }
    label395:
    switch (localObject.mState)
    {
    default: 
      if (localFileDownloadTaskInfo.status == 1) {
        localFileDownloadTaskInfo.status = 0;
      }
      break;
    }
    for (;;)
    {
      localFileDownloadTaskInfo.path = localObject.mSavePath;
      localFileDownloadTaskInfo.kYX = localObject.mReceiveDataLen;
      localFileDownloadTaskInfo.jyU = localObject.mTotalDataLen;
      break;
      localFileDownloadTaskInfo.status = 1;
      continue;
      localFileDownloadTaskInfo.status = 2;
      continue;
      if (localFileDownloadTaskInfo.status == 6) {
        localFileDownloadTaskInfo.status = 6;
      } else {
        localFileDownloadTaskInfo.status = 3;
      }
    }
  }
  
  public final boolean iB(long paramLong)
  {
    AppMethodBeat.i(2510);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((locala == null) || (bo.isNullOrNil(locala.field_downloadUrl)))
    {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(2510);
      return false;
    }
    if (locala.field_downloaderType != 2)
    {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", new Object[] { Long.valueOf(paramLong) });
      com.tencent.mm.vfs.e.deleteFile(locala.field_filePath);
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask, delete file: %s", new Object[] { locala.field_filePath });
      com.tencent.mm.plugin.downloader.model.d.iK(paramLong);
      AppMethodBeat.o(2510);
      return false;
    }
    com.tencent.mm.sdk.g.d.ysn.a(new a.6(this, locala, paramLong), "MicroMsg.FileDownloaderImplTMAssistant");
    AppMethodBeat.o(2510);
    return true;
  }
  
  public final boolean iC(long paramLong)
  {
    AppMethodBeat.i(156819);
    boolean bool = o(paramLong, true);
    AppMethodBeat.o(156819);
    return bool;
  }
  
  public final boolean iD(long paramLong)
  {
    AppMethodBeat.i(2512);
    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(paramLong)));
    boolean bool = o(paramLong, false);
    AppMethodBeat.o(2512);
    return bool;
  }
  
  public final int iz(long paramLong)
  {
    AppMethodBeat.i(2503);
    com.tencent.mm.sdk.g.d.ysn.a(new a.2(this, paramLong), "MicroMsg.FileDownloaderImplTMAssistant");
    AppMethodBeat.o(2503);
    return 1;
  }
  
  public final boolean o(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(2513);
    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: id = ".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((locala == null) || (bo.isNullOrNil(locala.field_downloadUrl)))
    {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(2513);
      return false;
    }
    if (locala.field_downloaderType != 2)
    {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", new Object[] { Long.valueOf(paramLong) });
      com.tencent.mm.vfs.e.deleteFile(locala.field_filePath);
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, delete file: " + locala.field_filePath);
      com.tencent.mm.plugin.downloader.model.d.iK(paramLong);
      AppMethodBeat.o(2513);
      return false;
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = iA(locala.field_downloadId);
    if (localFileDownloadTaskInfo.status == 1)
    {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "download runing, return");
      AppMethodBeat.o(2513);
      return true;
    }
    if (localFileDownloadTaskInfo.status == 6)
    {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "md5 checking ,return");
      AppMethodBeat.o(2513);
      return true;
    }
    if (localFileDownloadTaskInfo.status == 3)
    {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "has download finished, install");
      if (locala.field_autoInstall) {
        com.tencent.mm.plugin.downloader.i.a.a(localFileDownloadTaskInfo.id, false, null);
      }
      AppMethodBeat.o(2513);
      return true;
    }
    if (locala.field_status == 2) {
      locala.field_startState = com.tencent.mm.plugin.downloader.a.b.kVC;
    }
    for (;;)
    {
      locala.field_startSize = locala.field_downloadedSize;
      locala.field_errCode = 0;
      bjB();
      if (((!locala.field_reserveInWifi) && (!locala.field_downloadInWifi)) || (at.isWifi(ah.getContext()))) {
        break;
      }
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask downloadInWifi, not wifi");
      AppMethodBeat.o(2513);
      return true;
      if (locala.field_status == 4) {
        locala.field_startState = com.tencent.mm.plugin.downloader.a.b.kVD;
      } else {
        locala.field_startState = com.tencent.mm.plugin.downloader.a.b.kVB;
      }
    }
    if (at.isWifi(ah.getContext())) {
      locala.field_downloadInWifi = true;
    }
    com.tencent.mm.sdk.g.d.ysn.a(new a.7(this, locala, paramBoolean, paramLong), "MicroMsg.FileDownloaderImplTMAssistant");
    AppMethodBeat.o(2513);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a
 * JD-Core Version:    0.7.0.1
 */