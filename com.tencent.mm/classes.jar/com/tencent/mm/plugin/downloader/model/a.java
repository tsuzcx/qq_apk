package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.j;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends h
{
  public static final String iOS = com.tencent.mm.loader.a.b.bkH + "BigFile/";
  private byte[] dMQ = new byte[0];
  private com.tencent.mm.plugin.cdndownloader.d.b iAB = new a.1(this);
  private HashMap<String, Long> iOT = new HashMap();
  private HashMap<String, Long> iOU = new HashMap();
  private ConcurrentHashMap<String, Integer> iOV = new ConcurrentHashMap();
  private HashMap<String, Long> iOW = new HashMap();
  private HashMap<String, Long> iOX = new HashMap();
  private Context mContext = ae.getContext();
  
  public a(b paramb)
  {
    super(paramb);
    com.tencent.mm.plugin.cdndownloader.d.a.aDw().iAB = this.iAB;
  }
  
  private static CDNTaskInfo a(com.tencent.mm.plugin.downloader.f.a parama)
  {
    CDNTaskInfo localCDNTaskInfo = new CDNTaskInfo();
    localCDNTaskInfo.dlW = true;
    localCDNTaskInfo.bUi = parama.field_downloadUrl;
    localCDNTaskInfo.downloadUrl = parama.field_downloadUrl;
    localCDNTaskInfo.filePath = parama.field_filePath;
    localCDNTaskInfo.iAH = parama.field_secondaryUrl;
    localCDNTaskInfo.iAJ = 15;
    localCDNTaskInfo.iAK = 3600;
    localCDNTaskInfo.iAL = true;
    localCDNTaskInfo.iAM = parama.field_downloadInWifi;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (parama.field_fileSize > 0L) {
        localJSONObject.put("Content-Length", parama.field_fileSize);
      }
      localCDNTaskInfo.iAI = localJSONObject.toString();
      return localCDNTaskInfo;
    }
    catch (JSONException parama)
    {
      y.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + parama.getMessage());
    }
    return localCDNTaskInfo;
  }
  
  private void cancelNotification(String paramString)
  {
    synchronized (this.dMQ)
    {
      Integer localInteger = (Integer)this.iOV.get(paramString);
      if (localInteger == null)
      {
        y.i("MicroMsg.FileCDNDownloader", "No notification id found");
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      y.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = " + localInteger);
      this.iOV.remove(paramString);
      return;
    }
  }
  
  public final long a(e parame)
  {
    if ((parame == null) || (bk.bl(parame.fDR)))
    {
      y.e("MicroMsg.FileCDNDownloader", "Invalid Request");
      return -1L;
    }
    String str = parame.fDR;
    Object localObject2 = c.zK(str);
    if (localObject2 == null) {
      localObject2 = c.zH(parame.mAppId);
    }
    for (;;)
    {
      Object localObject1 = null;
      if (localObject2 != null)
      {
        localObject3 = dd(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId);
        y.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject3).status);
        if ((((FileDownloadTaskInfo)localObject3).status != 1) && (((FileDownloadTaskInfo)localObject3).status != 6))
        {
          localObject1 = localObject3;
          if (((FileDownloadTaskInfo)localObject3).status != 3) {}
        }
        else
        {
          return ((FileDownloadTaskInfo)localObject3).id;
        }
      }
      Object localObject3 = new com.tencent.mm.vfs.b(iOS);
      com.tencent.mm.vfs.b localb1;
      if (!((com.tencent.mm.vfs.b)localObject3).exists())
      {
        if (!((com.tencent.mm.vfs.b)localObject3).cLq().exists())
        {
          localb1 = ((com.tencent.mm.vfs.b)localObject3).cLq();
          com.tencent.mm.vfs.b localb2 = new com.tencent.mm.vfs.b(j.n(localb1.cLr()) + System.currentTimeMillis());
          if (localb2.mkdirs()) {
            localb2.n(localb1);
          }
        }
        else
        {
          y.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.b)localObject3).mkdirs()) });
        }
      }
      else
      {
        c.zI(str);
        c.zJ(parame.mAppId);
        if (localObject2 != null) {
          c.dl(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId);
        }
        localObject3 = f.c(parame);
        if ((!parame.iPC) || (localObject2 == null)) {
          break label543;
        }
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId = ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId;
        label294:
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloaderType = 3;
        localObject2 = ad.bB(str);
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath = (iOS + (String)localObject2);
        if (localObject1 == null) {
          break label584;
        }
        localObject2 = ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath;
        str = localObject1.path;
        if ((localObject2 != null) && (str != null) && (!((String)localObject2).equals(str)))
        {
          y.i("MicroMsg.FileCDNDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject2, str });
          localObject2 = new com.tencent.mm.vfs.b(str);
          if (((com.tencent.mm.vfs.b)localObject2).exists()) {
            y.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.b)localObject2).delete()) });
          }
        }
        if (localObject1.status != 2) {
          break label554;
        }
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.iOw;
        label441:
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startSize = localObject1.iPM;
        y.i("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + localObject1.iPM);
      }
      for (;;)
      {
        if ((!parame.ghq) || (aq.isWifi(ae.getContext()))) {
          break label595;
        }
        y.i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status = 2;
        c.c((com.tencent.mm.plugin.downloader.f.a)localObject3);
        return ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId;
        y.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", new Object[] { j.n(localb1.cLr()) });
        break;
        label543:
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId = System.currentTimeMillis();
        break label294;
        label554:
        if (localObject1.status == 4)
        {
          ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.iOx;
          break label441;
        }
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.iOv;
        break label441;
        label584:
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.iOv;
      }
      label595:
      if (aq.isWifi(ae.getContext())) {
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadInWifi = true;
      }
      com.tencent.mm.cg.a.post(new a.2(this, (com.tencent.mm.plugin.downloader.f.a)localObject3));
      return ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId;
    }
  }
  
  public final int dc(long paramLong)
  {
    com.tencent.mm.cg.a.post(new a.3(this, paramLong));
    return 1;
  }
  
  public final FileDownloadTaskInfo dd(long paramLong)
  {
    Object localObject = null;
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    FileDownloadTaskInfo localFileDownloadTaskInfo;
    label139:
    label159:
    long l;
    if (locala != null)
    {
      localFileDownloadTaskInfo = new FileDownloadTaskInfo();
      if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
        break label379;
      }
      localObject = com.tencent.mm.plugin.cdndownloader.d.a.aDw().zh(locala.field_downloadUrl);
      if (localObject == null) {
        break label537;
      }
      y.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, cdntaskstate: %d", new Object[] { Integer.valueOf(((CDNTaskState)localObject).taskState) });
      switch (((CDNTaskState)localObject).taskState)
      {
      case 103: 
      default: 
        if (locala.field_status == 1)
        {
          localFileDownloadTaskInfo.status = 0;
          localFileDownloadTaskInfo.iPM = locala.field_downloadedSize;
          localFileDownloadTaskInfo.hFz = locala.field_totalSize;
          if (localFileDownloadTaskInfo.iPM <= localFileDownloadTaskInfo.hFz) {
            break label528;
          }
          l = localFileDownloadTaskInfo.hFz;
          label179:
          localFileDownloadTaskInfo.iPM = l;
          locala.field_status = localFileDownloadTaskInfo.status;
          locala.field_downloadedSize = localFileDownloadTaskInfo.iPM;
          locala.field_totalSize = localFileDownloadTaskInfo.hFz;
          c.d(locala);
        }
        break;
      }
    }
    for (;;)
    {
      if (((localFileDownloadTaskInfo.status == 6) || (localFileDownloadTaskInfo.status == 3)) && (!com.tencent.mm.vfs.e.bK(locala.field_filePath)))
      {
        localFileDownloadTaskInfo.status = 0;
        c.j(paramLong, 0);
      }
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.bOz = locala.field_downloaderType;
      localFileDownloadTaskInfo.iPN = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.bIW = locala.field_md5;
      y.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, url: %s, status = %d, downloadedSize = %d, totalSize = %d", new Object[] { localFileDownloadTaskInfo.url, Integer.valueOf(localFileDownloadTaskInfo.status), Long.valueOf(localFileDownloadTaskInfo.iPM), Long.valueOf(localFileDownloadTaskInfo.hFz) });
      localObject = localFileDownloadTaskInfo;
      return localObject;
      label379:
      localObject = com.tencent.mm.plugin.cdndownloader.d.a.aDw().zj(locala.field_downloadUrl);
      break;
      localFileDownloadTaskInfo.status = 1;
      break label139;
      localFileDownloadTaskInfo.status = 1;
      localFileDownloadTaskInfo.iPM = ((CDNTaskState)localObject).completeSize;
      localFileDownloadTaskInfo.hFz = ((CDNTaskState)localObject).fileTotalSize;
      break label159;
      localFileDownloadTaskInfo.status = 2;
      localFileDownloadTaskInfo.iPM = ((CDNTaskState)localObject).completeSize;
      localFileDownloadTaskInfo.hFz = ((CDNTaskState)localObject).fileTotalSize;
      break label159;
      if (com.tencent.mm.vfs.e.bK(locala.field_filePath))
      {
        if (locala.field_status == 6)
        {
          localFileDownloadTaskInfo.status = 6;
          break label159;
        }
        localFileDownloadTaskInfo.status = 3;
        break label159;
      }
      localFileDownloadTaskInfo.status = 0;
      break label159;
      localFileDownloadTaskInfo.status = locala.field_status;
      break label139;
      label528:
      l = localFileDownloadTaskInfo.iPM;
      break label179;
      label537:
      if (locala.field_status == 1)
      {
        localFileDownloadTaskInfo.status = 0;
        c.j(paramLong, 0);
      }
      for (;;)
      {
        if (com.tencent.mm.a.e.bK(locala.field_filePath)) {
          break label597;
        }
        localFileDownloadTaskInfo.iPM = 0L;
        localFileDownloadTaskInfo.hFz = 0L;
        break;
        localFileDownloadTaskInfo.status = locala.field_status;
      }
      label597:
      localFileDownloadTaskInfo.iPM = locala.field_downloadedSize;
      localFileDownloadTaskInfo.hFz = locala.field_totalSize;
    }
  }
  
  public final boolean de(long paramLong)
  {
    com.tencent.mm.cg.a.post(new a.4(this, paramLong));
    return true;
  }
  
  public final boolean df(long paramLong)
  {
    return k(paramLong, true);
  }
  
  public final boolean iH(long paramLong)
  {
    com.tencent.mm.game.report.api.b.dCw.a(paramLong, new com.tencent.mm.game.report.api.a(13));
    return de(paramLong);
  }
  
  public final boolean k(long paramLong, boolean paramBoolean)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if (locala != null)
    {
      FileDownloadTaskInfo localFileDownloadTaskInfo = dd(locala.field_downloadId);
      if ((localFileDownloadTaskInfo.status == 1) || (localFileDownloadTaskInfo.status == 6) || (localFileDownloadTaskInfo.status == 3)) {
        return true;
      }
      if ((locala.field_downloadInWifi) && (!aq.isWifi(ae.getContext())))
      {
        y.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask, downloadInWifi, not wifi");
        return true;
      }
      if (aq.isWifi(ae.getContext())) {
        locala.field_downloadInWifi = true;
      }
      com.tencent.mm.cg.a.post(new a.5(this, locala, paramBoolean, paramLong));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a
 * JD-Core Version:    0.7.0.1
 */