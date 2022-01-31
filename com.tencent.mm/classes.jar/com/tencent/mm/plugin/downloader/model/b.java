package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends j
{
  public static final String kYa;
  private byte[] eKs;
  private com.tencent.mm.plugin.cdndownloader.d.b kDH;
  private HashMap<String, Long> kYb;
  private HashMap<String, Long> kYc;
  private ConcurrentHashMap<String, Integer> kYd;
  private HashMap<String, Long> kYe;
  private HashMap<String, Long> kYf;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(2375);
    kYa = com.tencent.mm.loader.j.b.eQz + "BigFile/";
    AppMethodBeat.o(2375);
  }
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(2360);
    this.eKs = new byte[0];
    this.kYe = new HashMap();
    this.kYf = new HashMap();
    this.kDH = new b.1(this);
    this.mContext = ah.getContext();
    this.kYb = new HashMap();
    this.kYc = new HashMap();
    this.kYd = new ConcurrentHashMap();
    com.tencent.mm.plugin.cdndownloader.d.a.bfT().kDH = this.kDH;
    AppMethodBeat.o(2360);
  }
  
  private static CDNTaskInfo b(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(2363);
    CDNTaskInfo localCDNTaskInfo = new CDNTaskInfo();
    localCDNTaskInfo.edy = true;
    localCDNTaskInfo.cBO = parama.field_downloadUrl;
    localCDNTaskInfo.downloadUrl = parama.field_downloadUrl;
    localCDNTaskInfo.filePath = parama.field_filePath;
    localCDNTaskInfo.kDN = parama.field_secondaryUrl;
    localCDNTaskInfo.kDP = 15;
    localCDNTaskInfo.kDQ = 3600;
    localCDNTaskInfo.kDR = true;
    localCDNTaskInfo.kDS = parama.field_downloadInWifi;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (parama.field_fileSize > 0L) {
        localJSONObject.put("Content-Length", parama.field_fileSize);
      }
      localCDNTaskInfo.kDO = localJSONObject.toString();
    }
    catch (JSONException parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + parama.getMessage());
      }
    }
    AppMethodBeat.o(2363);
    return localCDNTaskInfo;
  }
  
  private void cancelNotification(String paramString)
  {
    AppMethodBeat.i(2370);
    synchronized (this.eKs)
    {
      Integer localInteger = (Integer)this.kYd.get(paramString);
      if (localInteger == null)
      {
        ab.i("MicroMsg.FileCDNDownloader", "No notification id found");
        AppMethodBeat.o(2370);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      ab.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      this.kYd.remove(paramString);
      AppMethodBeat.o(2370);
      return;
    }
  }
  
  public final long a(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(2361);
    com.tencent.mm.ch.a.post(new b.2(this, parama));
    long l = parama.field_downloadId;
    AppMethodBeat.o(2361);
    return l;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(2362);
    if ((paramg == null) || (bo.isNullOrNil(paramg.gWh)))
    {
      ab.e("MicroMsg.FileCDNDownloader", "Invalid Request");
      AppMethodBeat.o(2362);
      return -1L;
    }
    String str = paramg.gWh;
    Object localObject2 = d.JG(str);
    if (localObject2 == null) {
      localObject2 = d.JD(paramg.mAppId);
    }
    for (;;)
    {
      Object localObject1 = null;
      if (localObject2 != null)
      {
        localObject3 = iA(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          ab.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject3).status);
          if ((((FileDownloadTaskInfo)localObject3).status == 1) || (((FileDownloadTaskInfo)localObject3).status == 6))
          {
            l = ((FileDownloadTaskInfo)localObject3).id;
            AppMethodBeat.o(2362);
            return l;
          }
          localObject1 = localObject3;
          if (((FileDownloadTaskInfo)localObject3).status == 3)
          {
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_autoInstall) {
              com.tencent.mm.plugin.downloader.i.a.a(((FileDownloadTaskInfo)localObject3).id, false, null);
            }
            l = ((FileDownloadTaskInfo)localObject3).id;
            AppMethodBeat.o(2362);
            return l;
          }
        }
      }
      Object localObject3 = new com.tencent.mm.vfs.b(kYa);
      com.tencent.mm.vfs.b localb1;
      if (!((com.tencent.mm.vfs.b)localObject3).exists())
      {
        if (!((com.tencent.mm.vfs.b)localObject3).dQI().exists())
        {
          localb1 = ((com.tencent.mm.vfs.b)localObject3).dQI();
          com.tencent.mm.vfs.b localb2 = new com.tencent.mm.vfs.b(com.tencent.mm.vfs.j.p(localb1.dQJ()) + System.currentTimeMillis());
          if (localb2.mkdirs()) {
            localb2.p(localb1);
          }
        }
        else
        {
          ab.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.b)localObject3).mkdirs()) });
        }
      }
      else
      {
        d.JE(str);
        d.JF(paramg.mAppId);
        if (localObject2 != null) {
          d.iK(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
        }
        localObject3 = h.c(paramg);
        if ((!paramg.kYJ) || (localObject2 == null)) {
          break label643;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
        label366:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloaderType = 3;
        localObject2 = ag.cE(str);
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath = (kYa + (String)localObject2);
        if (localObject1 == null) {
          break label685;
        }
        localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath;
        str = localObject1.path;
        if ((localObject2 != null) && (str != null) && (!((String)localObject2).equals(str)))
        {
          ab.i("MicroMsg.FileCDNDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject2, str });
          localObject2 = new com.tencent.mm.vfs.b(str);
          if (((com.tencent.mm.vfs.b)localObject2).exists()) {
            ab.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.b)localObject2).delete()) });
          }
        }
        if (localObject1.status != 2) {
          break label654;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.kVC;
        label525:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startSize = localObject1.kYX;
        ab.i("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + localObject1.kYX);
      }
      for (;;)
      {
        if ((!paramg.hzD) || (at.isWifi(ah.getContext()))) {
          break label696;
        }
        ab.i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_status = 0;
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadInWifi = true;
        d.d((com.tencent.mm.plugin.downloader.g.a)localObject3);
        l = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId;
        AppMethodBeat.o(2362);
        return l;
        ab.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", new Object[] { com.tencent.mm.vfs.j.p(localb1.dQJ()) });
        break;
        label643:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId = System.currentTimeMillis();
        break label366;
        label654:
        if (localObject1.status == 4)
        {
          ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.kVD;
          break label525;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.kVB;
        break label525;
        label685:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.kVB;
      }
      label696:
      if (at.isWifi(ah.getContext())) {
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadInWifi = true;
      }
      long l = a((com.tencent.mm.plugin.downloader.g.a)localObject3);
      AppMethodBeat.o(2362);
      return l;
    }
  }
  
  public final FileDownloadTaskInfo iA(long paramLong)
  {
    AppMethodBeat.i(2365);
    Object localObject = null;
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    FileDownloadTaskInfo localFileDownloadTaskInfo;
    label143:
    label163:
    long l;
    if (locala != null)
    {
      localFileDownloadTaskInfo = new FileDownloadTaskInfo();
      if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
        break label441;
      }
      localObject = com.tencent.mm.plugin.cdndownloader.d.a.bfT().IQ(locala.field_downloadUrl);
      if (localObject == null) {
        break label599;
      }
      ab.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, cdntaskstate: %d", new Object[] { Integer.valueOf(((CDNTaskState)localObject).taskState) });
      switch (((CDNTaskState)localObject).taskState)
      {
      case 103: 
      default: 
        if (locala.field_status == 1)
        {
          localFileDownloadTaskInfo.status = 0;
          localFileDownloadTaskInfo.kYX = locala.field_downloadedSize;
          localFileDownloadTaskInfo.jyU = locala.field_totalSize;
          if (localFileDownloadTaskInfo.kYX <= localFileDownloadTaskInfo.jyU) {
            break label590;
          }
          l = localFileDownloadTaskInfo.jyU;
          label183:
          localFileDownloadTaskInfo.kYX = l;
          locala.field_downloadedSize = localFileDownloadTaskInfo.kYX;
          locala.field_totalSize = localFileDownloadTaskInfo.jyU;
        }
        break;
      }
    }
    for (;;)
    {
      if (((localFileDownloadTaskInfo.status == 6) || (localFileDownloadTaskInfo.status == 3)) && (!com.tencent.mm.vfs.e.cN(locala.field_filePath))) {
        localFileDownloadTaskInfo.status = 0;
      }
      if ((localFileDownloadTaskInfo.status == 6) && (!e.iN(localFileDownloadTaskInfo.id))) {
        localFileDownloadTaskInfo.status = 3;
      }
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.cvQ = locala.field_downloaderType;
      localFileDownloadTaskInfo.kYY = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.cqq = locala.field_md5;
      if ((locala.field_status != localFileDownloadTaskInfo.status) && ((localFileDownloadTaskInfo.status == 1) || (locala.field_status == 1)))
      {
        locala.field_status = localFileDownloadTaskInfo.status;
        d.e(locala);
      }
      ab.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, url: %s, status = %d, downloadedSize = %d, totalSize = %d", new Object[] { localFileDownloadTaskInfo.url, Integer.valueOf(localFileDownloadTaskInfo.status), Long.valueOf(localFileDownloadTaskInfo.kYX), Long.valueOf(localFileDownloadTaskInfo.jyU) });
      localObject = localFileDownloadTaskInfo;
      AppMethodBeat.o(2365);
      return localObject;
      label441:
      localObject = com.tencent.mm.plugin.cdndownloader.d.a.bfT().IS(locala.field_downloadUrl);
      break;
      localFileDownloadTaskInfo.status = 1;
      break label143;
      localFileDownloadTaskInfo.status = 1;
      localFileDownloadTaskInfo.kYX = ((CDNTaskState)localObject).kDU;
      localFileDownloadTaskInfo.jyU = ((CDNTaskState)localObject).kDV;
      break label163;
      localFileDownloadTaskInfo.status = 2;
      localFileDownloadTaskInfo.kYX = ((CDNTaskState)localObject).kDU;
      localFileDownloadTaskInfo.jyU = ((CDNTaskState)localObject).kDV;
      break label163;
      if (com.tencent.mm.vfs.e.cN(locala.field_filePath))
      {
        if (locala.field_status == 6)
        {
          localFileDownloadTaskInfo.status = 6;
          break label163;
        }
        localFileDownloadTaskInfo.status = 3;
        break label163;
      }
      localFileDownloadTaskInfo.status = 0;
      break label163;
      localFileDownloadTaskInfo.status = locala.field_status;
      break label143;
      label590:
      l = localFileDownloadTaskInfo.kYX;
      break label183;
      label599:
      if (locala.field_status == 1) {}
      for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = locala.field_status)
      {
        if (com.tencent.mm.a.e.cN(locala.field_filePath)) {
          break label653;
        }
        localFileDownloadTaskInfo.kYX = 0L;
        localFileDownloadTaskInfo.jyU = 0L;
        break;
      }
      label653:
      localFileDownloadTaskInfo.kYX = locala.field_downloadedSize;
      localFileDownloadTaskInfo.jyU = locala.field_totalSize;
    }
  }
  
  public final boolean iB(long paramLong)
  {
    AppMethodBeat.i(2366);
    com.tencent.mm.sdk.g.d.ysm.execute(new b.4(this, paramLong));
    AppMethodBeat.o(2366);
    return true;
  }
  
  public final boolean iC(long paramLong)
  {
    AppMethodBeat.i(2367);
    boolean bool = o(paramLong, true);
    AppMethodBeat.o(2367);
    return bool;
  }
  
  public final boolean iD(long paramLong)
  {
    AppMethodBeat.i(2369);
    ab.i("MicroMsg.FileCDNDownloader", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(paramLong)));
    boolean bool = o(paramLong, false);
    AppMethodBeat.o(2369);
    return bool;
  }
  
  public final boolean iE(long paramLong)
  {
    AppMethodBeat.i(2371);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala != null)
    {
      locala.field_downloadType = 2;
      d.e(locala);
    }
    com.tencent.mm.plugin.downloader.f.a.o(paramLong, 13);
    boolean bool = iB(paramLong);
    AppMethodBeat.o(2371);
    return bool;
  }
  
  public final int iz(long paramLong)
  {
    AppMethodBeat.i(2364);
    com.tencent.mm.ch.a.post(new b.3(this, paramLong));
    AppMethodBeat.o(2364);
    return 1;
  }
  
  public final boolean o(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(2368);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala != null)
    {
      FileDownloadTaskInfo localFileDownloadTaskInfo = iA(locala.field_downloadId);
      if (localFileDownloadTaskInfo == null)
      {
        AppMethodBeat.o(2368);
        return false;
      }
      if ((localFileDownloadTaskInfo.status == 1) || (localFileDownloadTaskInfo.status == 6))
      {
        AppMethodBeat.o(2368);
        return true;
      }
      if (localFileDownloadTaskInfo.status == 3)
      {
        if (locala.field_autoInstall) {
          com.tencent.mm.plugin.downloader.i.a.a(localFileDownloadTaskInfo.id, false, null);
        }
        AppMethodBeat.o(2368);
        return true;
      }
      if (((locala.field_reserveInWifi) || (locala.field_downloadInWifi)) && (!at.isWifi(ah.getContext())))
      {
        ab.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask, downloadInWifi, not wifi");
        AppMethodBeat.o(2368);
        return true;
      }
      if (at.isWifi(ah.getContext())) {
        locala.field_downloadInWifi = true;
      }
      com.tencent.mm.ch.a.post(new b.5(this, locala, paramBoolean, paramLong));
      AppMethodBeat.o(2368);
      return true;
    }
    AppMethodBeat.o(2368);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b
 * JD-Core Version:    0.7.0.1
 */