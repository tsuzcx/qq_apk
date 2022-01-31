package com.tencent.mm.plugin.downloader.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends h
{
  private byte[] dMQ = new byte[0];
  HashMap<String, Long> iOW = new HashMap();
  HashMap<String, Long> iOX = new HashMap();
  private HashMap<String, Long> iRe = new HashMap();
  HashMap<String, Long> iRf = new HashMap();
  private ConcurrentHashMap<String, Integer> iRg = new ConcurrentHashMap();
  HashSet<Long> iRh = new HashSet();
  Map<String, String> iRi = null;
  am iRj = new am(Looper.getMainLooper(), new a.4(this), false);
  private ITMAssistantDownloadSDKClientListener iRk = new a.5(this);
  private TMAssistantDownloadSDKClient mClient = null;
  Context mContext = ae.getContext();
  
  public a(com.tencent.mm.plugin.downloader.model.b paramb)
  {
    super(paramb);
    HashMap localHashMap = new HashMap();
    String str = System.getProperty("http.agent");
    y.i("MicroMsg.FileDownloaderImplTMAssistant", str);
    paramb = str;
    if (bk.bl(str)) {
      paramb = "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)";
    }
    str = paramb + " MicroMessenger";
    PackageInfo localPackageInfo = getPackageInfo(this.mContext, ae.getPackageName());
    paramb = str;
    if (localPackageInfo != null)
    {
      paramb = str + "/";
      paramb = paramb + localPackageInfo.versionName;
      paramb = paramb + localPackageInfo.versionCode;
    }
    str = aq.getNetTypeString(ae.getContext());
    paramb = paramb + " NetType/" + str;
    y.i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", new Object[] { paramb });
    localHashMap.put("User-Agent", paramb);
    this.iRi = localHashMap;
  }
  
  private static void aFZ()
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(TMAssistantFile.getSavePathRootDir() + "/.tmp/");
    if (!localb.exists()) {
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", new Object[] { Boolean.valueOf(localb.mkdirs()) });
    }
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if (paramString == null)
    {
      y.e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public final long a(com.tencent.mm.plugin.downloader.model.e parame)
  {
    if ((parame == null) || (bk.bl(parame.fDR)))
    {
      y.e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
      return -1L;
    }
    String str1 = parame.fDR;
    String str2 = parame.mAppId;
    com.tencent.mm.plugin.downloader.f.a locala = c.zK(str1);
    if (locala != null)
    {
      localObject = dd(locala.field_downloadId);
      if (((FileDownloadTaskInfo)localObject).status == 1) {
        return ((FileDownloadTaskInfo)localObject).id;
      }
      if ((((FileDownloadTaskInfo)localObject).status == 6) || (((FileDownloadTaskInfo)localObject).status == 3))
      {
        y.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask, has download finished, return");
        return ((FileDownloadTaskInfo)localObject).id;
      }
    }
    Object localObject = locala;
    if (locala == null) {
      localObject = c.zH(str2);
    }
    aFZ();
    c.zI(str1);
    c.zJ(str2);
    locala = f.c(parame);
    if ((parame.iPC) && (localObject != null))
    {
      locala.field_downloadId = ((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadId;
      locala.field_status = 0;
      locala.field_downloaderType = 2;
      if (localObject == null) {
        break label270;
      }
      if (((com.tencent.mm.plugin.downloader.f.a)localObject).field_status != 2) {
        break label242;
      }
      locala.field_startState = com.tencent.mm.plugin.downloader.a.b.iOw;
    }
    label270:
    for (;;)
    {
      if (parame.iPz) {
        locala.field_md5 = f.zS(locala.field_downloadUrl);
      }
      c.c(locala);
      if ((!parame.ghq) || (aq.isWifi(ae.getContext()))) {
        break label278;
      }
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "downloadInWifi, not wifi");
      return locala.field_downloadId;
      locala.field_downloadId = System.currentTimeMillis();
      break;
      label242:
      if (((com.tencent.mm.plugin.downloader.f.a)localObject).field_status == 4)
      {
        locala.field_startState = com.tencent.mm.plugin.downloader.a.b.iOw;
      }
      else
      {
        locala.field_startState = com.tencent.mm.plugin.downloader.a.b.iOv;
        continue;
        locala.field_startState = 0;
      }
    }
    label278:
    if (aq.isWifi(ae.getContext())) {
      locala.field_downloadInWifi = true;
    }
    g.DS().O(new a.1(this, locala));
    return locala.field_downloadId;
  }
  
  final boolean aFY()
  {
    if ((this.iRh == null) || (this.iRh.size() == 0))
    {
      TMAssistantDownloadSDKManager.getInstance(this.mContext).releaseDownloadSDKClient("WechatDownloadClient");
      if (this.mClient != null) {
        this.mClient.unRegisterDownloadTaskListener(this.iRk);
      }
      this.mClient = null;
      TMAssistantDownloadSDKManager.closeAllService(this.mContext);
      try
      {
        Intent localIntent = new Intent(this.mContext, TMAssistantDownloadSDKService.class);
        this.mContext.stopService(localIntent);
        y.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + localException.toString());
        }
      }
    }
    y.i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
    return false;
  }
  
  final void cancelNotification(String paramString)
  {
    synchronized (this.dMQ)
    {
      Integer localInteger = (Integer)this.iRg.get(paramString);
      if (localInteger == null)
      {
        y.i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = " + localInteger);
      this.iRg.remove(paramString);
      return;
    }
  }
  
  public final int dc(long paramLong)
  {
    g.DS().O(new a.2(this, paramLong));
    return 1;
  }
  
  public final FileDownloadTaskInfo dd(long paramLong)
  {
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = paramLong;
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if ((locala == null) || (bk.bl(locala.field_downloadUrl))) {
      return localFileDownloadTaskInfo;
    }
    localFileDownloadTaskInfo.url = locala.field_downloadUrl;
    localFileDownloadTaskInfo.status = locala.field_status;
    localFileDownloadTaskInfo.path = locala.field_filePath;
    if (!com.tencent.mm.vfs.e.bK(locala.field_filePath)) {
      localFileDownloadTaskInfo.iPM = 0L;
    }
    for (localFileDownloadTaskInfo.hFz = 0L;; localFileDownloadTaskInfo.hFz = locala.field_totalSize)
    {
      localFileDownloadTaskInfo.bIW = locala.field_md5;
      return (FileDownloadTaskInfo)new a.3(this, localFileDownloadTaskInfo, localFileDownloadTaskInfo, locala).b(g.DS().crf());
      localFileDownloadTaskInfo.iPM = locala.field_downloadedSize;
    }
  }
  
  public final boolean de(long paramLong)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if ((locala == null) || (bk.bl(locala.field_downloadUrl)))
    {
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    if (locala.field_downloaderType != 2)
    {
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", new Object[] { Long.valueOf(paramLong) });
      com.tencent.mm.vfs.e.deleteFile(locala.field_filePath);
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask, delete file: %s", new Object[] { locala.field_filePath });
      c.dl(paramLong);
      return false;
    }
    g.DS().O(new a.6(this, locala, paramLong));
    return true;
  }
  
  public final boolean df(long paramLong)
  {
    return k(paramLong, true);
  }
  
  public final boolean k(long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: id = " + paramLong);
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if ((locala == null) || (bk.bl(locala.field_downloadUrl)))
    {
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    if (locala.field_downloaderType != 2)
    {
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", new Object[] { Long.valueOf(paramLong) });
      com.tencent.mm.vfs.e.deleteFile(locala.field_filePath);
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, delete file: " + locala.field_filePath);
      c.dl(paramLong);
      return false;
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = dd(locala.field_downloadId);
    if ((localFileDownloadTaskInfo.status == 1) || (localFileDownloadTaskInfo.status == 6) || (localFileDownloadTaskInfo.status == 3))
    {
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "has download finished, return");
      return true;
    }
    if (locala.field_status == 2) {
      locala.field_startState = com.tencent.mm.plugin.downloader.a.b.iOw;
    }
    for (;;)
    {
      locala.field_startSize = locala.field_downloadedSize;
      locala.field_errCode = 0;
      aFZ();
      if ((!locala.field_downloadInWifi) || (aq.isWifi(ae.getContext()))) {
        break;
      }
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask downloadInWifi, not wifi");
      return true;
      if (locala.field_status == 4) {
        locala.field_startState = com.tencent.mm.plugin.downloader.a.b.iOx;
      } else {
        locala.field_startState = com.tencent.mm.plugin.downloader.a.b.iOv;
      }
    }
    if (aq.isWifi(ae.getContext())) {
      locala.field_downloadInWifi = true;
    }
    g.DS().O(new a.7(this, locala, paramBoolean, paramLong));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a
 * JD-Core Version:    0.7.0.1
 */