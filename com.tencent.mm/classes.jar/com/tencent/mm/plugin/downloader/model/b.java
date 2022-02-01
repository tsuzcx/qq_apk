package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends j
{
  public static final String oeL;
  private byte[] lock;
  private Context mContext;
  private com.tencent.mm.plugin.cdndownloader.d.b nKH;
  private HashMap<String, Long> oeM;
  private HashMap<String, Long> oeN;
  private ConcurrentHashMap<String, Integer> oeO;
  private HashMap<String, Long> oeP;
  private HashMap<String, Long> oeQ;
  
  static
  {
    AppMethodBeat.i(88930);
    oeL = com.tencent.mm.loader.j.b.aih() + "BigFile/";
    AppMethodBeat.o(88930);
  }
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(88913);
    this.lock = new byte[0];
    this.oeP = new HashMap();
    this.oeQ = new HashMap();
    this.nKH = new com.tencent.mm.plugin.cdndownloader.d.b()
    {
      public final void f(String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        boolean bool = true;
        AppMethodBeat.i(88907);
        com.tencent.mm.plugin.downloader.g.a locala = d.Sn(paramAnonymousString1);
        if (locala == null)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(710L, 18L, 1L, false);
          ad.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
          AppMethodBeat.o(88907);
          return;
        }
        ad.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString2 });
        switch (paramAnonymousInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(88907);
          return;
          d.cF(locala.field_downloadUrl, 1);
          AppMethodBeat.o(88907);
          return;
          if (((paramAnonymousInt2 == 21009) || (paramAnonymousInt2 == 21020)) && (!h.oA(locala.field_totalSize)))
          {
            if (h.oz(locala.field_totalSize))
            {
              b.this.a(locala);
              AppMethodBeat.o(88907);
            }
          }
          else {
            bool = false;
          }
          locala.field_finishTime = System.currentTimeMillis();
          locala.field_errCode = Math.abs(paramAnonymousInt2);
          locala.field_status = 4;
          if ((ay.isWifi(aj.getContext())) && (locala.field_downloadInWifi))
          {
            locala.field_downloadInWifi = false;
            locala.field_reserveInWifi = false;
          }
          d.e(locala);
          b.this.ofi.c(locala.field_downloadId, Math.abs(paramAnonymousInt2), false);
          b.a(b.this, locala.field_downloadUrl, bool);
          b.a(b.this).remove(locala.field_downloadUrl);
          b.b(b.this).remove(locala.field_downloadUrl);
          AppMethodBeat.o(88907);
          return;
          locala.field_finishTime = System.currentTimeMillis();
          locala.field_downloadedSize = locala.field_totalSize;
          locala.field_status = 6;
          ad.i("MicroMsg.FileCDNDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(locala.field_downloadedSize), Long.valueOf(locala.field_startSize) });
          d.e(locala);
          d.cF(locala.field_downloadUrl, 6);
          b.this.ofi.op(locala.field_downloadId);
          paramAnonymousString1 = new Intent();
          paramAnonymousString1.putExtra(FileDownloadService.ofH, 1);
          paramAnonymousString1.setClass(b.c(b.this), FileDownloadService.class);
          paramAnonymousString1.putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
          try
          {
            com.tencent.mm.bs.d.aY(paramAnonymousString1);
            b.a(b.this, locala.field_downloadUrl);
            b.a(b.this).remove(locala.field_downloadUrl);
            b.b(b.this).remove(locala.field_downloadUrl);
          }
          catch (Exception paramAnonymousString1)
          {
            for (;;)
            {
              ad.e("MicroMsg.FileCDNDownloader", paramAnonymousString1.getMessage());
            }
          }
        }
      }
      
      public final void y(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(88908);
        ad.d("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = %d, receiveDataLen = %d", new Object[] { Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.downloader.g.a locala = d.Sn(paramAnonymousString);
        if (locala == null)
        {
          ad.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
          AppMethodBeat.o(88908);
          return;
        }
        if ((locala.field_downloadInWifi) && (!ay.isWifi(aj.getContext()))) {
          b.this.ol(locala.field_downloadId);
        }
        Long localLong = Long.valueOf(bt.f((Long)b.a(b.this).get(locala.field_downloadUrl)));
        paramAnonymousString = localLong;
        if (localLong.longValue() == 0L)
        {
          paramAnonymousString = Long.valueOf(paramAnonymousLong1);
          b.a(b.this).put(locala.field_downloadUrl, Long.valueOf(paramAnonymousLong1));
        }
        long l1 = paramAnonymousLong1 - paramAnonymousString.longValue();
        if (paramAnonymousLong2 == 0L) {
          ad.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = 0");
        }
        for (;;)
        {
          paramAnonymousString = Long.valueOf(bt.f((Long)b.d(b.this).get(locala.field_downloadUrl)));
          localLong = Long.valueOf(System.currentTimeMillis());
          l1 = localLong.longValue() - paramAnonymousString.longValue();
          if ((paramAnonymousString == null) || (l1 <= 0L) || (l1 >= 500L)) {
            break;
          }
          AppMethodBeat.o(88908);
          return;
          long l2 = 100L * l1 / paramAnonymousLong2;
          i = (int)((float)paramAnonymousLong1 / (float)paramAnonymousLong2 * 100.0F);
          if (l2 >= 1L)
          {
            long l3 = bt.a((Long)b.b(b.this).get(locala.field_downloadUrl), locala.field_startTime);
            l2 = System.currentTimeMillis();
            l3 = l2 - l3;
            float f = (float)l1 * 1000.0F / (float)l3 / 1048576.0F;
            ad.d("MicroMsg.FileCDNDownloader", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d, totalPercent = %d", new Object[] { locala.field_appId, Float.valueOf(f), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(i) });
            com.tencent.mm.plugin.downloader.i.b.a(locala.field_downloadId, f, i);
            b.b(b.this).put(locala.field_downloadUrl, Long.valueOf(l2));
            b.a(b.this).put(locala.field_downloadUrl, Long.valueOf(paramAnonymousLong1));
          }
        }
        b.d(b.this).put(locala.field_downloadUrl, localLong);
        locala.field_downloadedSize = paramAnonymousLong1;
        locala.field_totalSize = paramAnonymousLong2;
        d.e(locala);
        b.this.ofi.oo(locala.field_downloadId);
        int i = 0;
        if (paramAnonymousLong2 > 0L) {
          i = (int)((float)paramAnonymousLong1 / (float)paramAnonymousLong2 * 100.0F);
        }
        int j;
        if (i < 0) {
          j = 0;
        }
        for (;;)
        {
          b.a(b.this, locala.field_downloadUrl, j, false);
          AppMethodBeat.o(88908);
          return;
          j = i;
          if (i > 100) {
            j = 100;
          }
        }
      }
    };
    this.mContext = aj.getContext();
    this.oeM = new HashMap();
    this.oeN = new HashMap();
    this.oeO = new ConcurrentHashMap();
    com.tencent.mm.plugin.cdndownloader.d.a.bNe().nKH = this.nKH;
    AppMethodBeat.o(88913);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(88923);
    ad.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1) });
    ??? = d.Sn(paramString);
    if (??? == null)
    {
      ad.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
      AppMethodBeat.o(88923);
      return;
    }
    if (!((com.tencent.mm.plugin.downloader.g.a)???).field_showNotification)
    {
      AppMethodBeat.o(88923);
      return;
    }
    s.c localc = com.tencent.mm.br.a.bD(this.mContext, "reminder_channel_id");
    label119:
    Object localObject2;
    if (paramBoolean1)
    {
      long l = System.currentTimeMillis();
      this.oeM.put(paramString, Long.valueOf(l));
      localc.g(l);
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.j(((com.tencent.mm.plugin.downloader.g.a)???).field_appId, false, false);
      if ((localObject2 == null) || (bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName))) {
        break label264;
      }
      localc.f(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName);
    }
    for (;;)
    {
      switch (paramInt1)
      {
      case 2: 
      case 3: 
      default: 
        cancelNotification(paramString);
        AppMethodBeat.o(88923);
        return;
        localObject2 = (Long)this.oeM.get(paramString);
        if (localObject2 != null)
        {
          localc.g(((Long)localObject2).longValue());
          break label119;
        }
        localObject2 = Long.valueOf(System.currentTimeMillis());
        this.oeM.put(paramString, localObject2);
        localc.g(((Long)localObject2).longValue());
        break label119;
        label264:
        localc.f(((com.tencent.mm.plugin.downloader.g.a)???).field_fileName);
      }
    }
    localc.as(17301633);
    int i = paramInt2;
    if (paramInt2 == 0) {
      i = 1;
    }
    if (i == 0) {
      paramBoolean1 = true;
    }
    for (;;)
    {
      localc.b(100, i, paramBoolean1);
      if (((com.tencent.mm.plugin.downloader.g.a)???).field_reserveInWifi)
      {
        localc.g(this.mContext.getString(2131759054) + "·" + this.mContext.getString(2131759052));
        label369:
        localc.f(2, true);
        localObject2 = new Intent(this.mContext, FileDownloadConfirmUI.class);
        ((Intent)localObject2).putExtra("extra_download_id", ((com.tencent.mm.plugin.downloader.g.a)???).field_downloadId);
        localc.Ew = PendingIntent.getActivity(this.mContext, (int)System.currentTimeMillis(), (Intent)localObject2, 268435456);
      }
      synchronized (this.lock)
      {
        for (;;)
        {
          localObject2 = (Integer)this.oeO.get(paramString);
          if (localObject2 != null) {
            break label622;
          }
          paramInt2 = ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
          this.oeO.put(paramString, Integer.valueOf(paramInt2));
          if (paramInt1 == 4) {
            this.oeO.remove(paramString);
          }
          AppMethodBeat.o(88923);
          return;
          paramBoolean1 = false;
          break;
          localc.g(this.mContext.getString(2131759052));
          break label369;
          localc.as(17301634);
          localc.F(true);
          ??? = new Intent();
          localc.Ew = PendingIntent.getActivity(aj.getContext(), 0, (Intent)???, 0);
          if (paramBoolean2) {
            localc.g(this.mContext.getString(2131759050));
          } else {
            localc.g(this.mContext.getString(2131759049));
          }
        }
        label622:
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(((Integer)localObject2).intValue(), localc.build());
      }
    }
  }
  
  private static CDNTaskInfo b(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(88916);
    CDNTaskInfo localCDNTaskInfo = new CDNTaskInfo();
    localCDNTaskInfo.fnQ = true;
    localCDNTaskInfo.mediaId = parama.field_downloadUrl;
    localCDNTaskInfo.downloadUrl = parama.field_downloadUrl;
    localCDNTaskInfo.filePath = parama.field_filePath;
    localCDNTaskInfo.nKN = parama.field_secondaryUrl;
    localCDNTaskInfo.nKP = 15;
    localCDNTaskInfo.nKQ = 3600;
    localCDNTaskInfo.nKR = true;
    localCDNTaskInfo.nKS = parama.field_downloadInWifi;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (parama.field_fileSize > 0L) {
        localJSONObject.put("Content-Length", parama.field_fileSize);
      }
      localCDNTaskInfo.nKO = localJSONObject.toString();
    }
    catch (JSONException parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + parama.getMessage());
      }
    }
    AppMethodBeat.o(88916);
    return localCDNTaskInfo;
  }
  
  private void cancelNotification(String paramString)
  {
    AppMethodBeat.i(88924);
    synchronized (this.lock)
    {
      Integer localInteger = (Integer)this.oeO.get(paramString);
      if (localInteger == null)
      {
        ad.i("MicroMsg.FileCDNDownloader", "No notification id found");
        AppMethodBeat.o(88924);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      ad.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      this.oeO.remove(paramString);
      AppMethodBeat.o(88924);
      return;
    }
  }
  
  public final long a(final com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(88914);
    com.tencent.mm.cj.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88909);
        com.tencent.mm.plugin.downloader.a.c.h(parama.field_appId, new String[] { parama.field_downloadUrl, parama.field_secondaryUrl });
        com.tencent.mm.plugin.s.a.cZS();
        n.aAW(parama.field_appId);
        Object localObject = b.c(parama);
        int i = com.tencent.mm.plugin.cdndownloader.d.a.bNe().a((CDNTaskInfo)localObject);
        ad.i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", new Object[] { Integer.valueOf(i), Long.valueOf(parama.field_downloadId) });
        if (i == 0)
        {
          parama.field_status = 1;
          parama.field_startTime = System.currentTimeMillis();
          d.d(parama);
          b.this.ofi.k(parama.field_downloadId, parama.field_filePath);
          b.a(b.this, parama.field_downloadUrl, 0, true);
          AppMethodBeat.o(88909);
          return;
        }
        if (i == -2)
        {
          parama.field_status = 1;
          parama.field_startTime = System.currentTimeMillis();
          d.d(parama);
          AppMethodBeat.o(88909);
          return;
        }
        if (i == 1)
        {
          parama.field_status = 6;
          localObject = parama;
          com.tencent.mm.plugin.downloader.g.a locala1 = parama;
          com.tencent.mm.plugin.downloader.g.a locala2 = parama;
          long l = com.tencent.mm.vfs.i.aMN(parama.field_filePath);
          locala2.field_totalSize = l;
          locala1.field_downloadedSize = l;
          ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startSize = l;
          localObject = parama;
          locala1 = parama;
          l = System.currentTimeMillis();
          locala1.field_finishTime = l;
          ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startTime = l;
          d.d(parama);
          b.this.ofi.op(parama.field_downloadId);
          localObject = new Intent();
          ((Intent)localObject).putExtra(FileDownloadService.ofH, 1);
          ((Intent)localObject).setClass(b.c(b.this), FileDownloadService.class);
          ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, parama.field_downloadId);
          try
          {
            com.tencent.mm.bs.d.aY((Intent)localObject);
            AppMethodBeat.o(88909);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.FileCDNDownloader", localException.getMessage());
            AppMethodBeat.o(88909);
            return;
          }
        }
        parama.field_status = 4;
        parama.field_errCode = com.tencent.mm.plugin.downloader.a.a.obZ;
        d.d(parama);
        b.this.ofi.c(parama.field_downloadId, parama.field_errCode, false);
        AppMethodBeat.o(88909);
      }
    });
    long l = parama.field_downloadId;
    AppMethodBeat.o(88914);
    return l;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(88915);
    if ((paramg == null) || (bt.isNullOrNil(paramg.iNT)))
    {
      ad.e("MicroMsg.FileCDNDownloader", "Invalid Request");
      AppMethodBeat.o(88915);
      return -1L;
    }
    ad.i("MicroMsg.FileCDNDownloader", "addDownloadTask, appId : %s", new Object[] { paramg.mAppId });
    String str = paramg.iNT;
    Object localObject2 = d.Sn(str);
    if (localObject2 == null) {
      localObject2 = d.Sk(paramg.mAppId);
    }
    for (;;)
    {
      Object localObject1 = null;
      if (localObject2 != null)
      {
        localObject3 = oh(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          ad.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject3).status);
          if ((((FileDownloadTaskInfo)localObject3).status == 1) || (((FileDownloadTaskInfo)localObject3).status == 6))
          {
            l = ((FileDownloadTaskInfo)localObject3).id;
            AppMethodBeat.o(88915);
            return l;
          }
          localObject1 = localObject3;
          if (((FileDownloadTaskInfo)localObject3).status == 3)
          {
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_autoInstall) {
              com.tencent.mm.plugin.downloader.i.a.a(((FileDownloadTaskInfo)localObject3).id, false, null);
            }
            l = ((FileDownloadTaskInfo)localObject3).id;
            AppMethodBeat.o(88915);
            return l;
          }
        }
      }
      Object localObject3 = new com.tencent.mm.vfs.e(oeL);
      com.tencent.mm.vfs.e locale1;
      if (!((com.tencent.mm.vfs.e)localObject3).exists())
      {
        if (!((com.tencent.mm.vfs.e)localObject3).fhT().exists())
        {
          locale1 = ((com.tencent.mm.vfs.e)localObject3).fhT();
          com.tencent.mm.vfs.e locale2 = new com.tencent.mm.vfs.e(q.B(locale1.fhU()) + System.currentTimeMillis());
          if (locale2.mkdirs()) {
            locale2.af(locale1);
          }
        }
        else
        {
          ad.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.e)localObject3).mkdirs()) });
        }
      }
      else
      {
        if (localObject2 != null) {
          d.or(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
        }
        localObject3 = h.c(paramg);
        if ((!paramg.ofv) || (localObject2 == null)) {
          break label648;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
        label371:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloaderType = 3;
        localObject2 = ai.du(str);
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath = (oeL + (String)localObject2);
        if (localObject1 == null) {
          break label690;
        }
        localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath;
        str = localObject1.path;
        if ((localObject2 != null) && (str != null) && (!((String)localObject2).equals(str)))
        {
          ad.i("MicroMsg.FileCDNDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject2, str });
          localObject2 = new com.tencent.mm.vfs.e(str);
          if (((com.tencent.mm.vfs.e)localObject2).exists()) {
            ad.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.e)localObject2).delete()) });
          }
        }
        if (localObject1.status != 2) {
          break label659;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.ocm;
        label530:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startSize = localObject1.ofL;
        ad.i("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + localObject1.ofL);
      }
      for (;;)
      {
        if ((!paramg.jzk) || (ay.isWifi(aj.getContext()))) {
          break label701;
        }
        ad.i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_status = 0;
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadInWifi = true;
        d.d((com.tencent.mm.plugin.downloader.g.a)localObject3);
        l = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId;
        AppMethodBeat.o(88915);
        return l;
        ad.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", new Object[] { q.B(locale1.fhU()) });
        break;
        label648:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId = System.currentTimeMillis();
        break label371;
        label659:
        if (localObject1.status == 4)
        {
          ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.ocn;
          break label530;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.ocl;
        break label530;
        label690:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.ocl;
      }
      label701:
      if (ay.isWifi(aj.getContext())) {
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadInWifi = true;
      }
      long l = a((com.tencent.mm.plugin.downloader.g.a)localObject3);
      AppMethodBeat.o(88915);
      return l;
    }
  }
  
  public final boolean m(final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88921);
    final com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if (locala != null)
    {
      FileDownloadTaskInfo localFileDownloadTaskInfo = oh(locala.field_downloadId);
      if (localFileDownloadTaskInfo == null)
      {
        AppMethodBeat.o(88921);
        return false;
      }
      if ((localFileDownloadTaskInfo.status == 1) || (localFileDownloadTaskInfo.status == 6))
      {
        AppMethodBeat.o(88921);
        return true;
      }
      if (localFileDownloadTaskInfo.status == 3)
      {
        if (locala.field_autoInstall) {
          com.tencent.mm.plugin.downloader.i.a.a(localFileDownloadTaskInfo.id, false, null);
        }
        AppMethodBeat.o(88921);
        return true;
      }
      if (((locala.field_reserveInWifi) || (locala.field_downloadInWifi)) && (!ay.isWifi(aj.getContext())))
      {
        ad.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask, downloadInWifi, not wifi");
        AppMethodBeat.o(88921);
        return true;
      }
      if (ay.isWifi(aj.getContext())) {
        locala.field_downloadInWifi = true;
      }
      com.tencent.mm.cj.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(88912);
          com.tencent.mm.plugin.downloader.a.c.h(locala.field_appId, new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
          com.tencent.mm.plugin.s.a.cZS();
          n.aAW(locala.field_appId);
          int i = com.tencent.mm.plugin.cdndownloader.d.a.bNe().b(b.c(locala));
          ad.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: ".concat(String.valueOf(i)));
          locala.field_startTime = System.currentTimeMillis();
          locala.field_startSize = locala.field_downloadedSize;
          locala.field_startState = com.tencent.mm.plugin.downloader.a.b.ocm;
          long l;
          if (i == 0)
          {
            locala.field_status = 1;
            locala.field_errCode = 0;
            d.e(locala);
            if (paramBoolean) {
              b.this.ofi.l(paramLong, locala.field_filePath);
            }
            l = 0L;
            if (locala.field_totalSize != 0L) {
              l = locala.field_downloadedSize * 100L / locala.field_totalSize;
            }
            ad.d("MicroMsg.FileCDNDownloader", "resumeDownloadTask, progress = %d, downloadedSize = %d, totalSize = %d", new Object[] { Long.valueOf(l), Long.valueOf(locala.field_downloadedSize), Long.valueOf(locala.field_totalSize) });
            b.a(b.this, locala.field_downloadUrl, (int)l, true);
            AppMethodBeat.o(88912);
            return;
          }
          if (i == -2)
          {
            locala.field_status = 1;
            locala.field_errCode = 0;
            d.e(locala);
            AppMethodBeat.o(88912);
            return;
          }
          if (i == 1)
          {
            if ((locala.field_status == 6) || (locala.field_status == 3))
            {
              AppMethodBeat.o(88912);
              return;
            }
            locala.field_status = 6;
            Object localObject = locala;
            com.tencent.mm.plugin.downloader.g.a locala = locala;
            l = locala.field_totalSize;
            locala.field_downloadedSize = l;
            ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startSize = l;
            localObject = locala;
            locala = locala;
            l = System.currentTimeMillis();
            locala.field_finishTime = l;
            ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startTime = l;
            d.e(locala);
            b.this.ofi.op(locala.field_downloadId);
            localObject = new Intent();
            ((Intent)localObject).putExtra(FileDownloadService.ofH, 1);
            ((Intent)localObject).setClass(b.c(b.this), FileDownloadService.class);
            ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
            try
            {
              com.tencent.mm.bs.d.aY((Intent)localObject);
              AppMethodBeat.o(88912);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.FileCDNDownloader", localException.getMessage());
              AppMethodBeat.o(88912);
              return;
            }
          }
          locala.field_status = 4;
          locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.oca;
          d.e(locala);
          b.this.ofi.c(paramLong, locala.field_errCode, false);
          AppMethodBeat.o(88912);
        }
      });
      AppMethodBeat.o(88921);
      return true;
    }
    AppMethodBeat.o(88921);
    return false;
  }
  
  public final int og(final long paramLong)
  {
    AppMethodBeat.i(88917);
    com.tencent.mm.cj.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88910);
        FileDownloadTaskInfo localFileDownloadTaskInfo = b.this.oh(paramLong);
        if (localFileDownloadTaskInfo == null)
        {
          AppMethodBeat.o(88910);
          return;
        }
        com.tencent.mm.plugin.cdndownloader.d.a.bNe().RA(localFileDownloadTaskInfo.url);
        b.a(b.this, localFileDownloadTaskInfo.url);
        com.tencent.mm.vfs.i.deleteFile(localFileDownloadTaskInfo.path);
        ad.i("MicroMsg.FileCDNDownloader", "removeDownloadTask, delete file, path: %s", new Object[] { localFileDownloadTaskInfo.path });
        if (localFileDownloadTaskInfo.status != 5)
        {
          com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
          if (locala == null)
          {
            AppMethodBeat.o(88910);
            return;
          }
          locala.field_finishTime = System.currentTimeMillis();
          locala.field_downloadedSize = localFileDownloadTaskInfo.ofL;
          locala.field_status = 5;
          d.e(locala);
          d.cF(locala.field_downloadUrl, 5);
          Long localLong = Long.valueOf(bt.a((Long)b.b(b.this).get(localFileDownloadTaskInfo.url), locala.field_startTime));
          if (localLong != null)
          {
            long l1 = bt.a((Long)b.a(b.this).get(localFileDownloadTaskInfo.url), locala.field_startSize);
            long l2 = System.currentTimeMillis();
            long l3 = localLong.longValue();
            float f = (float)(localFileDownloadTaskInfo.ofL - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
            int i = (int)((float)localFileDownloadTaskInfo.ofL / (float)localFileDownloadTaskInfo.mqq * 100.0F);
            com.tencent.mm.plugin.downloader.i.b.a(paramLong, f, i);
          }
          b.a(b.this).remove(localFileDownloadTaskInfo.url);
          b.b(b.this).remove(localFileDownloadTaskInfo.url);
          b.this.ofi.om(paramLong);
        }
        AppMethodBeat.o(88910);
      }
    });
    AppMethodBeat.o(88917);
    return 1;
  }
  
  public final FileDownloadTaskInfo oh(long paramLong)
  {
    AppMethodBeat.i(88918);
    FileDownloadTaskInfo localFileDownloadTaskInfo = null;
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    CDNTaskState localCDNTaskState;
    label203:
    long l;
    if (locala != null)
    {
      ad.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, downloadid ; %d, appId : %s, status : %d", new Object[] { Long.valueOf(locala.field_downloadId), locala.field_appId, Integer.valueOf(locala.field_status) });
      localFileDownloadTaskInfo = new FileDownloadTaskInfo();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      localCDNTaskState = com.tencent.mm.plugin.cdndownloader.d.a.bNe().RB(locala.field_downloadUrl);
      if (localCDNTaskState == null) {
        break label615;
      }
      ad.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, cdntaskstate: %d", new Object[] { Integer.valueOf(localCDNTaskState.taskState) });
      switch (localCDNTaskState.taskState)
      {
      case 103: 
      default: 
        if (locala.field_status == 1)
        {
          localFileDownloadTaskInfo.status = 0;
          localFileDownloadTaskInfo.ofL = locala.field_downloadedSize;
          localFileDownloadTaskInfo.mqq = locala.field_totalSize;
          if (localFileDownloadTaskInfo.ofL <= localFileDownloadTaskInfo.mqq) {
            break label606;
          }
          l = localFileDownloadTaskInfo.mqq;
          label223:
          localFileDownloadTaskInfo.ofL = l;
          locala.field_downloadedSize = localFileDownloadTaskInfo.ofL;
          locala.field_totalSize = localFileDownloadTaskInfo.mqq;
        }
        break;
      }
    }
    for (;;)
    {
      if (((localFileDownloadTaskInfo.status == 6) || (localFileDownloadTaskInfo.status == 3)) && (!com.tencent.mm.vfs.i.eK(locala.field_filePath))) {
        localFileDownloadTaskInfo.status = 0;
      }
      if ((localFileDownloadTaskInfo.status == 6) && (!e.ou(localFileDownloadTaskInfo.id))) {
        localFileDownloadTaskInfo.status = 3;
      }
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.dlp = locala.field_downloaderType;
      localFileDownloadTaskInfo.ofM = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.md5 = locala.field_md5;
      if ((locala.field_status != localFileDownloadTaskInfo.status) && ((localFileDownloadTaskInfo.status == 1) || (locala.field_status == 1)))
      {
        locala.field_status = localFileDownloadTaskInfo.status;
        d.e(locala);
      }
      ad.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, url: %s, status = %d, downloadedSize = %d, totalSize = %d", new Object[] { localFileDownloadTaskInfo.url, Integer.valueOf(localFileDownloadTaskInfo.status), Long.valueOf(localFileDownloadTaskInfo.ofL), Long.valueOf(localFileDownloadTaskInfo.mqq) });
      AppMethodBeat.o(88918);
      return localFileDownloadTaskInfo;
      localFileDownloadTaskInfo.status = 1;
      break;
      localFileDownloadTaskInfo.status = 1;
      localFileDownloadTaskInfo.ofL = localCDNTaskState.completeSize;
      localFileDownloadTaskInfo.mqq = localCDNTaskState.fileTotalSize;
      break label203;
      localFileDownloadTaskInfo.status = 2;
      localFileDownloadTaskInfo.ofL = localCDNTaskState.completeSize;
      localFileDownloadTaskInfo.mqq = localCDNTaskState.fileTotalSize;
      break label203;
      if (com.tencent.mm.vfs.i.eK(locala.field_filePath))
      {
        if (locala.field_status == 6)
        {
          localFileDownloadTaskInfo.status = 6;
          break label203;
        }
        localFileDownloadTaskInfo.status = 3;
        break label203;
      }
      localFileDownloadTaskInfo.status = 0;
      break label203;
      localFileDownloadTaskInfo.status = locala.field_status;
      break;
      label606:
      l = localFileDownloadTaskInfo.ofL;
      break label223;
      label615:
      if (locala.field_status == 1) {}
      for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = locala.field_status)
      {
        if (com.tencent.mm.vfs.i.eK(locala.field_filePath)) {
          break label669;
        }
        localFileDownloadTaskInfo.ofL = 0L;
        localFileDownloadTaskInfo.mqq = 0L;
        break;
      }
      label669:
      localFileDownloadTaskInfo.ofL = locala.field_downloadedSize;
      localFileDownloadTaskInfo.mqq = locala.field_totalSize;
    }
  }
  
  public final boolean oi(final long paramLong)
  {
    AppMethodBeat.i(88919);
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88911);
        ad.i("MicroMsg.FileCDNDownloader", "pauseDownloadTask");
        FileDownloadTaskInfo localFileDownloadTaskInfo = b.this.oh(paramLong);
        if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status == 1))
        {
          com.tencent.mm.plugin.cdndownloader.d.a.bNe().Rz(localFileDownloadTaskInfo.url);
          b.a(b.this, localFileDownloadTaskInfo.url);
          com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
          if (locala != null)
          {
            locala.field_finishTime = System.currentTimeMillis();
            locala.field_status = 2;
            locala.field_downloadedSize = localFileDownloadTaskInfo.ofL;
            d.e(locala);
            Long localLong = Long.valueOf(bt.a((Long)b.b(b.this).get(localFileDownloadTaskInfo.url), locala.field_startTime));
            if (localLong != null)
            {
              long l1 = bt.a((Long)b.a(b.this).get(localFileDownloadTaskInfo.url), locala.field_startSize);
              long l2 = System.currentTimeMillis();
              long l3 = localLong.longValue();
              float f = (float)(locala.field_downloadedSize - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
              int i = (int)((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F);
              com.tencent.mm.plugin.downloader.i.b.a(locala.field_downloadId, f, i);
            }
          }
          b.a(b.this).remove(localFileDownloadTaskInfo.url);
          b.b(b.this).remove(localFileDownloadTaskInfo.url);
          b.this.ofi.on(paramLong);
        }
        AppMethodBeat.o(88911);
      }
    });
    AppMethodBeat.o(88919);
    return true;
  }
  
  public final boolean oj(long paramLong)
  {
    AppMethodBeat.i(88920);
    boolean bool = m(paramLong, true);
    AppMethodBeat.o(88920);
    return bool;
  }
  
  public final boolean ok(long paramLong)
  {
    AppMethodBeat.i(88922);
    ad.i("MicroMsg.FileCDNDownloader", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(paramLong)));
    boolean bool = m(paramLong, false);
    AppMethodBeat.o(88922);
    return bool;
  }
  
  public final boolean ol(long paramLong)
  {
    AppMethodBeat.i(88925);
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if (locala != null)
    {
      locala.field_downloadType = 2;
      d.e(locala);
    }
    com.tencent.mm.plugin.downloader.f.a.r(paramLong, 13);
    boolean bool = oi(paramLong);
    AppMethodBeat.o(88925);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b
 * JD-Core Version:    0.7.0.1
 */