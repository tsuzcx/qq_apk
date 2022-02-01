package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends j
{
  public static final String qIb;
  private byte[] lock;
  private Context mContext;
  private HashMap<String, Long> qIc;
  private HashMap<String, Long> qId;
  private ConcurrentHashMap<String, Integer> qIe;
  private HashMap<String, Long> qIf;
  private HashMap<String, Long> qIg;
  private com.tencent.mm.plugin.cdndownloader.d.b qmB;
  
  static
  {
    AppMethodBeat.i(88930);
    qIb = com.tencent.mm.loader.j.b.aKJ() + "BigFile/";
    AppMethodBeat.o(88930);
  }
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(88913);
    this.lock = new byte[0];
    this.qIf = new HashMap();
    this.qIg = new HashMap();
    this.qmB = new com.tencent.mm.plugin.cdndownloader.d.b()
    {
      public final void g(String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        boolean bool = true;
        AppMethodBeat.i(88907);
        com.tencent.mm.plugin.downloader.g.a locala = d.ale(paramAnonymousString1);
        if (locala == null)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(710L, 18L, 1L, false);
          Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
          AppMethodBeat.o(88907);
          return;
        }
        Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString2 });
        switch (paramAnonymousInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(88907);
          return;
          d.cW(locala.field_downloadUrl, 1);
          AppMethodBeat.o(88907);
          return;
          if (((paramAnonymousInt2 == 21009) || (paramAnonymousInt2 == 21020)) && (!h.CF(locala.field_totalSize)))
          {
            if (h.CE(locala.field_totalSize))
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
          if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (locala.field_downloadInWifi))
          {
            locala.field_downloadInWifi = false;
            locala.field_reserveInWifi = false;
          }
          d.e(locala);
          b.this.qIy.c(locala.field_downloadId, Math.abs(paramAnonymousInt2), false);
          b.a(b.this, locala.field_downloadUrl, bool);
          b.a(b.this).remove(locala.field_downloadUrl);
          b.b(b.this).remove(locala.field_downloadUrl);
          AppMethodBeat.o(88907);
          return;
          locala.field_finishTime = System.currentTimeMillis();
          locala.field_downloadedSize = locala.field_totalSize;
          locala.field_status = 6;
          Log.i("MicroMsg.FileCDNDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(locala.field_downloadedSize), Long.valueOf(locala.field_startSize) });
          d.e(locala);
          d.cW(locala.field_downloadUrl, 6);
          b.this.qIy.Cv(locala.field_downloadId);
          paramAnonymousString1 = new Intent();
          paramAnonymousString1.putExtra(FileDownloadService.qJa, 1);
          paramAnonymousString1.setClass(b.c(b.this), FileDownloadService.class);
          paramAnonymousString1.putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
          try
          {
            com.tencent.mm.br.c.startService(paramAnonymousString1);
            b.a(b.this, locala.field_downloadUrl);
            b.a(b.this).remove(locala.field_downloadUrl);
            b.b(b.this).remove(locala.field_downloadUrl);
          }
          catch (Exception paramAnonymousString1)
          {
            for (;;)
            {
              Log.e("MicroMsg.FileCDNDownloader", paramAnonymousString1.getMessage());
            }
          }
        }
      }
      
      public final void x(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(88908);
        Log.d("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = %d, receiveDataLen = %d", new Object[] { Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.downloader.g.a locala = d.ale(paramAnonymousString);
        if (locala == null)
        {
          Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
          AppMethodBeat.o(88908);
          return;
        }
        if ((locala.field_downloadInWifi) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
          b.this.Cs(locala.field_downloadId);
        }
        Long localLong2 = Long.valueOf(Util.nullAsNil((Long)b.a(b.this).get(locala.field_downloadUrl)));
        Long localLong1 = localLong2;
        if (localLong2.longValue() == 0L)
        {
          localLong1 = Long.valueOf(paramAnonymousLong1);
          b.a(b.this).put(locala.field_downloadUrl, Long.valueOf(paramAnonymousLong1));
        }
        long l1 = paramAnonymousLong1 - localLong1.longValue();
        if (paramAnonymousLong2 == 0L) {
          Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = 0");
        }
        for (;;)
        {
          localLong1 = Long.valueOf(Util.nullAsNil((Long)b.d(b.this).get(locala.field_downloadUrl)));
          localLong2 = Long.valueOf(System.currentTimeMillis());
          l1 = localLong2.longValue() - localLong1.longValue();
          if ((localLong1 == null) || (l1 <= 0L) || (l1 >= 500L)) {
            break;
          }
          AppMethodBeat.o(88908);
          return;
          long l2 = 100L * l1 / paramAnonymousLong2;
          i = (int)((float)paramAnonymousLong1 / (float)paramAnonymousLong2 * 100.0F);
          if (l2 >= 1L)
          {
            long l3 = Util.nullAs((Long)b.b(b.this).get(locala.field_downloadUrl), locala.field_startTime);
            l2 = System.currentTimeMillis();
            l3 = l2 - l3;
            float f = (float)l1 * 1000.0F / (float)l3 / 1048576.0F;
            Log.d("MicroMsg.FileCDNDownloader", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d, totalPercent = %d", new Object[] { locala.field_appId, Float.valueOf(f), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(i) });
            com.tencent.mm.plugin.downloader.i.b.a(locala.field_downloadId, f, i);
            b.b(b.this).put(locala.field_downloadUrl, Long.valueOf(l2));
            b.a(b.this).put(locala.field_downloadUrl, Long.valueOf(paramAnonymousLong1));
          }
        }
        b.d(b.this).put(locala.field_downloadUrl, localLong2);
        locala.field_downloadedSize = paramAnonymousLong1;
        locala.field_totalSize = paramAnonymousLong2;
        d.e(locala);
        b.this.qIy.b(locala.field_downloadId, paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
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
    this.mContext = MMApplicationContext.getContext();
    this.qIc = new HashMap();
    this.qId = new HashMap();
    this.qIe = new ConcurrentHashMap();
    com.tencent.mm.plugin.cdndownloader.d.a.cya().qmB = this.qmB;
    AppMethodBeat.o(88913);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(88923);
    Log.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1) });
    ??? = d.ale(paramString);
    if (??? == null)
    {
      Log.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
      AppMethodBeat.o(88923);
      return;
    }
    if (!((com.tencent.mm.plugin.downloader.g.a)???).field_showNotification)
    {
      AppMethodBeat.o(88923);
      return;
    }
    s.c localc = com.tencent.mm.bq.a.cd(this.mContext, "reminder_channel_id");
    if (paramBoolean1)
    {
      long l = System.currentTimeMillis();
      this.qIc.put(paramString, Long.valueOf(l));
      localc.i(l);
      label119:
      if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)???).field_notificationTitle)) {
        break label276;
      }
      localc.f(((com.tencent.mm.plugin.downloader.g.a)???).field_notificationTitle + " · " + MMApplicationContext.getContext().getString(2131759375));
    }
    Object localObject2;
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
        localObject2 = (Long)this.qIc.get(paramString);
        if (localObject2 != null)
        {
          localc.i(((Long)localObject2).longValue());
          break label119;
        }
        localObject2 = Long.valueOf(System.currentTimeMillis());
        this.qIc.put(paramString, localObject2);
        localc.i(((Long)localObject2).longValue());
        break label119;
        label276:
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(((com.tencent.mm.plugin.downloader.g.a)???).field_appId, false, false);
        if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName))) {
          localc.f(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName);
        } else {
          localc.f(((com.tencent.mm.plugin.downloader.g.a)???).field_fileName);
        }
        break;
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
        localc.g(this.mContext.getString(2131759382) + "·" + this.mContext.getString(2131759380));
        label423:
        localc.g(2, true);
        localObject2 = new Intent(this.mContext, FileDownloadConfirmUI.class);
        ((Intent)localObject2).putExtra("extra_download_id", ((com.tencent.mm.plugin.downloader.g.a)???).field_downloadId);
        localc.Hv = PendingIntent.getActivity(this.mContext, (int)System.currentTimeMillis(), (Intent)localObject2, 268435456);
      }
      synchronized (this.lock)
      {
        for (;;)
        {
          localObject2 = (Integer)this.qIe.get(paramString);
          if (localObject2 != null) {
            break label676;
          }
          paramInt2 = ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
          this.qIe.put(paramString, Integer.valueOf(paramInt2));
          if (paramInt1 == 4) {
            this.qIe.remove(paramString);
          }
          AppMethodBeat.o(88923);
          return;
          paramBoolean1 = false;
          break;
          localc.g(this.mContext.getString(2131759380));
          break label423;
          localc.as(17301634);
          localc.E(true);
          ??? = new Intent();
          localc.Hv = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, (Intent)???, 0);
          if (paramBoolean2) {
            localc.g(this.mContext.getString(2131759378));
          } else {
            localc.g(this.mContext.getString(2131759377));
          }
        }
        label676:
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(((Integer)localObject2).intValue(), localc.build());
      }
    }
  }
  
  private static CDNTaskInfo b(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(88916);
    CDNTaskInfo localCDNTaskInfo = new CDNTaskInfo();
    localCDNTaskInfo.gqH = true;
    localCDNTaskInfo.mediaId = parama.field_downloadUrl;
    localCDNTaskInfo.downloadUrl = parama.field_downloadUrl;
    localCDNTaskInfo.filePath = parama.field_filePath;
    localCDNTaskInfo.qmH = parama.field_secondaryUrl;
    localCDNTaskInfo.qmJ = 15;
    localCDNTaskInfo.qmK = 3600;
    localCDNTaskInfo.qmL = true;
    localCDNTaskInfo.qmM = parama.field_downloadInWifi;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (parama.field_fileSize > 0L) {
        localJSONObject.put("Content-Length", parama.field_fileSize);
      }
      localCDNTaskInfo.qmI = localJSONObject.toString();
    }
    catch (JSONException parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + parama.getMessage());
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
      Integer localInteger = (Integer)this.qIe.get(paramString);
      if (localInteger == null)
      {
        Log.i("MicroMsg.FileCDNDownloader", "No notification id found");
        AppMethodBeat.o(88924);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      Log.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      this.qIe.remove(paramString);
      AppMethodBeat.o(88924);
      return;
    }
  }
  
  public final int Cn(final long paramLong)
  {
    AppMethodBeat.i(88917);
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88910);
        FileDownloadTaskInfo localFileDownloadTaskInfo = b.this.Co(paramLong);
        if (localFileDownloadTaskInfo == null)
        {
          AppMethodBeat.o(88910);
          return;
        }
        com.tencent.mm.plugin.cdndownloader.d.a.cya().aks(localFileDownloadTaskInfo.url);
        b.a(b.this, localFileDownloadTaskInfo.url);
        s.deleteFile(localFileDownloadTaskInfo.path);
        Log.i("MicroMsg.FileCDNDownloader", "removeDownloadTask, delete file, path: %s", new Object[] { localFileDownloadTaskInfo.path });
        if (localFileDownloadTaskInfo.status != 5)
        {
          com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
          if (locala == null)
          {
            AppMethodBeat.o(88910);
            return;
          }
          locala.field_finishTime = System.currentTimeMillis();
          locala.field_downloadedSize = localFileDownloadTaskInfo.qJe;
          locala.field_status = 5;
          d.e(locala);
          d.cW(locala.field_downloadUrl, 5);
          Long localLong = Long.valueOf(Util.nullAs((Long)b.b(b.this).get(localFileDownloadTaskInfo.url), locala.field_startTime));
          if (localLong != null)
          {
            long l1 = Util.nullAs((Long)b.a(b.this).get(localFileDownloadTaskInfo.url), locala.field_startSize);
            long l2 = System.currentTimeMillis();
            long l3 = localLong.longValue();
            float f = (float)(localFileDownloadTaskInfo.qJe - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
            int i = (int)((float)localFileDownloadTaskInfo.qJe / (float)localFileDownloadTaskInfo.oJj * 100.0F);
            com.tencent.mm.plugin.downloader.i.b.a(paramLong, f, i);
          }
          b.a(b.this).remove(localFileDownloadTaskInfo.url);
          b.b(b.this).remove(localFileDownloadTaskInfo.url);
          b.this.qIy.Ct(paramLong);
        }
        AppMethodBeat.o(88910);
      }
    });
    AppMethodBeat.o(88917);
    return 1;
  }
  
  public final FileDownloadTaskInfo Co(long paramLong)
  {
    AppMethodBeat.i(88918);
    FileDownloadTaskInfo localFileDownloadTaskInfo = null;
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    CDNTaskState localCDNTaskState;
    label203:
    long l;
    if (locala != null)
    {
      Log.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, downloadid ; %d, appId : %s, status : %d", new Object[] { Long.valueOf(locala.field_downloadId), locala.field_appId, Integer.valueOf(locala.field_status) });
      localFileDownloadTaskInfo = new FileDownloadTaskInfo();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      localCDNTaskState = com.tencent.mm.plugin.cdndownloader.d.a.cya().akt(locala.field_downloadUrl);
      if (localCDNTaskState == null) {
        break label615;
      }
      Log.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, cdntaskstate: %d", new Object[] { Integer.valueOf(localCDNTaskState.taskState) });
      switch (localCDNTaskState.taskState)
      {
      case 103: 
      default: 
        if (locala.field_status == 1)
        {
          localFileDownloadTaskInfo.status = 0;
          localFileDownloadTaskInfo.qJe = locala.field_downloadedSize;
          localFileDownloadTaskInfo.oJj = locala.field_totalSize;
          if (localFileDownloadTaskInfo.qJe <= localFileDownloadTaskInfo.oJj) {
            break label606;
          }
          l = localFileDownloadTaskInfo.oJj;
          label223:
          localFileDownloadTaskInfo.qJe = l;
          locala.field_downloadedSize = localFileDownloadTaskInfo.qJe;
          locala.field_totalSize = localFileDownloadTaskInfo.oJj;
        }
        break;
      }
    }
    for (;;)
    {
      if (((localFileDownloadTaskInfo.status == 6) || (localFileDownloadTaskInfo.status == 3)) && (!s.YS(locala.field_filePath))) {
        localFileDownloadTaskInfo.status = 0;
      }
      if ((localFileDownloadTaskInfo.status == 6) && (!e.CA(localFileDownloadTaskInfo.id))) {
        localFileDownloadTaskInfo.status = 3;
      }
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.dNv = locala.field_downloaderType;
      localFileDownloadTaskInfo.qJf = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.md5 = locala.field_md5;
      if ((locala.field_status != localFileDownloadTaskInfo.status) && ((localFileDownloadTaskInfo.status == 1) || (locala.field_status == 1)))
      {
        locala.field_status = localFileDownloadTaskInfo.status;
        d.e(locala);
      }
      Log.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, url: %s, status = %d, downloadedSize = %d, totalSize = %d", new Object[] { localFileDownloadTaskInfo.url, Integer.valueOf(localFileDownloadTaskInfo.status), Long.valueOf(localFileDownloadTaskInfo.qJe), Long.valueOf(localFileDownloadTaskInfo.oJj) });
      AppMethodBeat.o(88918);
      return localFileDownloadTaskInfo;
      localFileDownloadTaskInfo.status = 1;
      break;
      localFileDownloadTaskInfo.status = 1;
      localFileDownloadTaskInfo.qJe = localCDNTaskState.completeSize;
      localFileDownloadTaskInfo.oJj = localCDNTaskState.fileTotalSize;
      break label203;
      localFileDownloadTaskInfo.status = 2;
      localFileDownloadTaskInfo.qJe = localCDNTaskState.completeSize;
      localFileDownloadTaskInfo.oJj = localCDNTaskState.fileTotalSize;
      break label203;
      if (s.YS(locala.field_filePath))
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
      l = localFileDownloadTaskInfo.qJe;
      break label223;
      label615:
      if (locala.field_status == 1) {}
      for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = locala.field_status)
      {
        if (s.YS(locala.field_filePath)) {
          break label669;
        }
        localFileDownloadTaskInfo.qJe = 0L;
        localFileDownloadTaskInfo.oJj = 0L;
        break;
      }
      label669:
      localFileDownloadTaskInfo.qJe = locala.field_downloadedSize;
      localFileDownloadTaskInfo.oJj = locala.field_totalSize;
    }
  }
  
  public final boolean Cp(final long paramLong)
  {
    AppMethodBeat.i(88919);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88911);
        Log.i("MicroMsg.FileCDNDownloader", "pauseDownloadTask");
        FileDownloadTaskInfo localFileDownloadTaskInfo = b.this.Co(paramLong);
        if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status == 1))
        {
          com.tencent.mm.plugin.cdndownloader.d.a.cya().akr(localFileDownloadTaskInfo.url);
          b.a(b.this, localFileDownloadTaskInfo.url);
          com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
          if (locala != null)
          {
            locala.field_finishTime = System.currentTimeMillis();
            locala.field_status = 2;
            locala.field_downloadedSize = localFileDownloadTaskInfo.qJe;
            d.e(locala);
            Long localLong = Long.valueOf(Util.nullAs((Long)b.b(b.this).get(localFileDownloadTaskInfo.url), locala.field_startTime));
            if (localLong != null)
            {
              long l1 = Util.nullAs((Long)b.a(b.this).get(localFileDownloadTaskInfo.url), locala.field_startSize);
              long l2 = System.currentTimeMillis();
              long l3 = localLong.longValue();
              float f = (float)(locala.field_downloadedSize - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
              int i = (int)((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F);
              com.tencent.mm.plugin.downloader.i.b.a(locala.field_downloadId, f, i);
            }
          }
          b.a(b.this).remove(localFileDownloadTaskInfo.url);
          b.b(b.this).remove(localFileDownloadTaskInfo.url);
          b.this.qIy.Cu(paramLong);
        }
        AppMethodBeat.o(88911);
      }
    });
    AppMethodBeat.o(88919);
    return true;
  }
  
  public final boolean Cq(long paramLong)
  {
    AppMethodBeat.i(88920);
    boolean bool = n(paramLong, true);
    AppMethodBeat.o(88920);
    return bool;
  }
  
  public final boolean Cr(long paramLong)
  {
    AppMethodBeat.i(88922);
    Log.i("MicroMsg.FileCDNDownloader", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(paramLong)));
    boolean bool = n(paramLong, false);
    AppMethodBeat.o(88922);
    return bool;
  }
  
  public final boolean Cs(long paramLong)
  {
    AppMethodBeat.i(88925);
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if (locala != null)
    {
      locala.field_downloadType = 2;
      d.e(locala);
    }
    com.tencent.mm.plugin.downloader.f.a.p(paramLong, 13);
    boolean bool = Cp(paramLong);
    AppMethodBeat.o(88925);
    return bool;
  }
  
  public final long a(final com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(88914);
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88909);
        com.tencent.mm.plugin.downloader.a.c.h(parama.field_appId, new String[] { parama.field_downloadUrl, parama.field_secondaryUrl });
        com.tencent.mm.plugin.r.a.eAU();
        n.bdK(parama.field_appId);
        Object localObject = b.c(parama);
        int i = com.tencent.mm.plugin.cdndownloader.d.a.cya().a((CDNTaskInfo)localObject);
        Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", new Object[] { Integer.valueOf(i), Long.valueOf(parama.field_downloadId) });
        if (i == 0)
        {
          parama.field_status = 1;
          parama.field_startTime = System.currentTimeMillis();
          d.d(parama);
          b.this.qIy.m(parama.field_downloadId, parama.field_filePath);
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
          long l = s.boW(parama.field_filePath);
          locala2.field_totalSize = l;
          locala1.field_downloadedSize = l;
          ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startSize = l;
          localObject = parama;
          locala1 = parama;
          l = System.currentTimeMillis();
          locala1.field_finishTime = l;
          ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startTime = l;
          d.d(parama);
          b.this.qIy.Cv(parama.field_downloadId);
          localObject = new Intent();
          ((Intent)localObject).putExtra(FileDownloadService.qJa, 1);
          ((Intent)localObject).setClass(b.c(b.this), FileDownloadService.class);
          ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, parama.field_downloadId);
          try
          {
            com.tencent.mm.br.c.startService((Intent)localObject);
            AppMethodBeat.o(88909);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.FileCDNDownloader", localException.getMessage());
            AppMethodBeat.o(88909);
            return;
          }
        }
        parama.field_status = 4;
        parama.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFm;
        d.d(parama);
        b.this.qIy.c(parama.field_downloadId, parama.field_errCode, false);
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
    if ((paramg == null) || (Util.isNullOrNil(paramg.kMX)))
    {
      Log.e("MicroMsg.FileCDNDownloader", "Invalid Request");
      AppMethodBeat.o(88915);
      return -1L;
    }
    Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask, appId : %s", new Object[] { paramg.mAppId });
    Object localObject4 = paramg.kMX;
    Object localObject2 = d.ale((String)localObject4);
    if (localObject2 == null) {
      localObject2 = d.alb(paramg.mAppId);
    }
    for (;;)
    {
      Object localObject1 = null;
      if (localObject2 != null)
      {
        localObject3 = Co(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject3).status);
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
      if (localObject2 != null) {
        d.Cx(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
      }
      Object localObject3 = h.c(paramg);
      if ((paramg.qIL) && (localObject2 != null))
      {
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloaderType = 3;
        if (Util.isNullOrNil(paramg.qIW)) {
          break label639;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath = paramg.qIW;
        label283:
        localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath;
        localObject2 = new o(((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("/") + 1));
        if (!((o)localObject2).exists())
        {
          if (!((o)localObject2).heq().exists())
          {
            localObject4 = ((o)localObject2).heq();
            o localo = new o(aa.z(((o)localObject4).her()) + System.currentTimeMillis());
            if (!localo.mkdirs()) {
              break label675;
            }
            localo.am((o)localObject4);
          }
          Log.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((o)localObject2).mkdirs()) });
        }
        label416:
        if (localObject1 == null) {
          break label732;
        }
        localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath;
        localObject4 = localObject1.path;
        if ((localObject2 != null) && (localObject4 != null) && (!((String)localObject2).equals(localObject4)))
        {
          Log.i("MicroMsg.FileCDNDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject2, localObject4 });
          localObject2 = new o((String)localObject4);
          if (((o)localObject2).exists()) {
            Log.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((o)localObject2).delete()) });
          }
        }
        if (localObject1.status != 2) {
          break label701;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
        label536:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startSize = localObject1.qJe;
        Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + localObject1.qJe);
      }
      for (;;)
      {
        if ((!paramg.lBG) || (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
          break label743;
        }
        Log.i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_status = 0;
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadInWifi = true;
        d.d((com.tencent.mm.plugin.downloader.g.a)localObject3);
        l = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId;
        AppMethodBeat.o(88915);
        return l;
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId = System.currentTimeMillis();
        break;
        label639:
        localObject2 = MD5Util.getMD5String((String)localObject4);
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath = (qIb + (String)localObject2);
        break label283;
        label675:
        Log.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", new Object[] { aa.z(((o)localObject4).her()) });
        break label416;
        label701:
        if (localObject1.status == 4)
        {
          ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.qFA;
          break label536;
        }
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.qFy;
        break label536;
        label732:
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.qFy;
      }
      label743:
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadInWifi = true;
      }
      long l = a((com.tencent.mm.plugin.downloader.g.a)localObject3);
      AppMethodBeat.o(88915);
      return l;
    }
  }
  
  public final boolean n(final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88921);
    final com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if (locala != null)
    {
      FileDownloadTaskInfo localFileDownloadTaskInfo = Co(locala.field_downloadId);
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
      if (((locala.field_reserveInWifi) || (locala.field_downloadInWifi)) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext())))
      {
        Log.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask, downloadInWifi, not wifi");
        AppMethodBeat.o(88921);
        return true;
      }
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        locala.field_downloadInWifi = true;
      }
      com.tencent.mm.ch.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(88912);
          com.tencent.mm.plugin.downloader.a.c.h(locala.field_appId, new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
          com.tencent.mm.plugin.r.a.eAU();
          n.bdK(locala.field_appId);
          int i = com.tencent.mm.plugin.cdndownloader.d.a.cya().b(b.c(locala));
          Log.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: ".concat(String.valueOf(i)));
          locala.field_startTime = System.currentTimeMillis();
          locala.field_startSize = locala.field_downloadedSize;
          locala.field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
          long l;
          if (i == 0)
          {
            locala.field_status = 1;
            locala.field_errCode = 0;
            d.e(locala);
            if (paramBoolean) {
              b.this.qIy.n(paramLong, locala.field_filePath);
            }
            l = 0L;
            if (locala.field_totalSize != 0L) {
              l = locala.field_downloadedSize * 100L / locala.field_totalSize;
            }
            Log.d("MicroMsg.FileCDNDownloader", "resumeDownloadTask, progress = %d, downloadedSize = %d, totalSize = %d", new Object[] { Long.valueOf(l), Long.valueOf(locala.field_downloadedSize), Long.valueOf(locala.field_totalSize) });
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
            b.this.qIy.Cv(locala.field_downloadId);
            localObject = new Intent();
            ((Intent)localObject).putExtra(FileDownloadService.qJa, 1);
            ((Intent)localObject).setClass(b.c(b.this), FileDownloadService.class);
            ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
            try
            {
              com.tencent.mm.br.c.startService((Intent)localObject);
              AppMethodBeat.o(88912);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.FileCDNDownloader", localException.getMessage());
              AppMethodBeat.o(88912);
              return;
            }
          }
          locala.field_status = 4;
          locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFn;
          d.e(locala);
          b.this.qIy.c(paramLong, locala.field_errCode, false);
          AppMethodBeat.o(88912);
        }
      });
      AppMethodBeat.o(88921);
      return true;
    }
    AppMethodBeat.o(88921);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b
 * JD-Core Version:    0.7.0.1
 */