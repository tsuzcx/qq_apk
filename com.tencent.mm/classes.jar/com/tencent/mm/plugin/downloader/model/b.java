package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.c.d;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends j
{
  public static final String xnh;
  private byte[] lock;
  private Context mContext;
  private com.tencent.mm.plugin.cdndownloader.d.b wOH;
  private HashMap<String, Long> xni;
  private HashMap<String, Long> xnj;
  private ConcurrentHashMap<String, Integer> xnk;
  private HashMap<String, Long> xnl;
  private HashMap<String, Long> xnm;
  
  static
  {
    AppMethodBeat.i(88930);
    xnh = com.tencent.mm.loader.i.b.bmz() + "BigFile/";
    AppMethodBeat.o(88930);
  }
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(88913);
    this.lock = new byte[0];
    this.xnl = new HashMap();
    this.xnm = new HashMap();
    this.wOH = new com.tencent.mm.plugin.cdndownloader.d.b()
    {
      public final void A(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(88908);
        Log.d("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = %d, receiveDataLen = %d", new Object[] { Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.downloader.f.a locala = d.amM(paramAnonymousString);
        if (locala == null)
        {
          Log.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
          AppMethodBeat.o(88908);
          return;
        }
        if ((locala.field_downloadInWifi) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
          b.this.kW(locala.field_downloadId);
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
            com.tencent.mm.plugin.downloader.h.b.a(locala.field_downloadId, f, i);
            b.b(b.this).put(locala.field_downloadUrl, Long.valueOf(l2));
            b.a(b.this).put(locala.field_downloadUrl, Long.valueOf(paramAnonymousLong1));
          }
        }
        b.d(b.this).put(locala.field_downloadUrl, localLong2);
        locala.field_downloadedSize = paramAnonymousLong1;
        locala.field_totalSize = paramAnonymousLong2;
        d.e(locala);
        b.this.xnE.b(locala.field_downloadId, paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
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
      
      public final void h(String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        boolean bool = true;
        AppMethodBeat.i(88907);
        com.tencent.mm.plugin.downloader.f.a locala = d.amM(paramAnonymousString1);
        if (locala == null)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(710L, 18L, 1L, false);
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
          d.dR(locala.field_downloadUrl, 1);
          AppMethodBeat.o(88907);
          return;
          if (((paramAnonymousInt2 == 21009) || (paramAnonymousInt2 == 21020)) && (!h.lj(locala.field_totalSize)))
          {
            if (h.li(locala.field_totalSize))
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
          b.this.xnE.d(locala.field_downloadId, Math.abs(paramAnonymousInt2), false);
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
          d.dR(locala.field_downloadUrl, 6);
          b.this.xnE.kZ(locala.field_downloadId);
          paramAnonymousString1 = new Intent();
          paramAnonymousString1.putExtra(FileDownloadService.xoh, 1);
          paramAnonymousString1.setClass(b.c(b.this), FileDownloadService.class);
          paramAnonymousString1.putExtra(FileDownloadService.xog, locala.field_downloadId);
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
    };
    this.mContext = MMApplicationContext.getContext();
    this.xni = new HashMap();
    this.xnj = new HashMap();
    this.xnk = new ConcurrentHashMap();
    com.tencent.mm.plugin.cdndownloader.d.a.dpZ().wOH = this.wOH;
    AppMethodBeat.o(88913);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(88923);
    Log.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1) });
    ??? = d.amM(paramString);
    if (??? == null)
    {
      Log.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
      AppMethodBeat.o(88923);
      return;
    }
    if (!((com.tencent.mm.plugin.downloader.f.a)???).field_showNotification)
    {
      AppMethodBeat.o(88923);
      return;
    }
    f.d locald = com.tencent.mm.bq.a.cA(this.mContext, "reminder_channel_id");
    if (paramBoolean1)
    {
      long l = System.currentTimeMillis();
      this.xni.put(paramString, Long.valueOf(l));
      locald.bt(l);
      label119:
      if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.f.a)???).field_notificationTitle)) {
        break label280;
      }
      locald.l(((com.tencent.mm.plugin.downloader.f.a)???).field_notificationTitle + " · " + MMApplicationContext.getContext().getString(c.d.file_downloader_book_download));
    }
    Object localObject2;
    for (;;)
    {
      switch (paramInt1)
      {
      case 2: 
      case 3: 
      default: 
        iH(paramString);
        AppMethodBeat.o(88923);
        return;
        localObject2 = (Long)this.xni.get(paramString);
        if (localObject2 != null)
        {
          locald.bt(((Long)localObject2).longValue());
          break label119;
        }
        localObject2 = Long.valueOf(System.currentTimeMillis());
        this.xni.put(paramString, localObject2);
        locald.bt(((Long)localObject2).longValue());
        break label119;
        label280:
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(((com.tencent.mm.plugin.downloader.f.a)???).field_appId, false, false);
        if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName))) {
          locald.l(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName);
        } else {
          locald.l(((com.tencent.mm.plugin.downloader.f.a)???).field_fileName);
        }
        break;
      }
    }
    locald.eb(17301633);
    int i = paramInt2;
    if (paramInt2 == 0) {
      i = 1;
    }
    if (i == 0) {
      paramBoolean1 = true;
    }
    for (;;)
    {
      locald.d(100, i, paramBoolean1);
      if (((com.tencent.mm.plugin.downloader.f.a)???).field_reserveInWifi)
      {
        locald.m(this.mContext.getString(c.d.file_downloader_reversed_wifi) + "·" + this.mContext.getString(c.d.file_downloader_download_running));
        label430:
        locald.q(2, true);
        localObject2 = new Intent(this.mContext, FileDownloadConfirmUI.class);
        ((Intent)localObject2).putExtra("extra_download_id", ((com.tencent.mm.plugin.downloader.f.a)???).field_downloadId);
        locald.bor = PendingIntent.getActivity(this.mContext, (int)System.currentTimeMillis(), (Intent)localObject2, 268435456);
      }
      synchronized (this.lock)
      {
        for (;;)
        {
          localObject2 = (Integer)this.xnk.get(paramString);
          if (localObject2 != null) {
            break label684;
          }
          paramInt2 = ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().d(locald.DA());
          this.xnk.put(paramString, Integer.valueOf(paramInt2));
          if (paramInt1 == 4) {
            this.xnk.remove(paramString);
          }
          AppMethodBeat.o(88923);
          return;
          paramBoolean1 = false;
          break;
          locald.m(this.mContext.getString(c.d.file_downloader_download_running));
          break label430;
          locald.eb(17301634);
          locald.aC(true);
          ??? = new Intent();
          locald.bor = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, (Intent)???, 0);
          if (paramBoolean2) {
            locald.m(this.mContext.getString(c.d.file_downloader_download_failed_not_enough_space));
          } else {
            locald.m(this.mContext.getString(c.d.file_downloader_download_failed));
          }
        }
        label684:
        ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().c(((Integer)localObject2).intValue(), locald.DA());
      }
    }
  }
  
  private static CDNTaskInfo b(com.tencent.mm.plugin.downloader.f.a parama)
  {
    AppMethodBeat.i(88916);
    CDNTaskInfo localCDNTaskInfo = new CDNTaskInfo();
    localCDNTaskInfo.lwU = true;
    localCDNTaskInfo.mediaId = parama.field_downloadUrl;
    localCDNTaskInfo.downloadUrl = parama.field_downloadUrl;
    localCDNTaskInfo.filePath = parama.field_filePath;
    localCDNTaskInfo.wON = parama.field_secondaryUrl;
    localCDNTaskInfo.wOP = 15;
    localCDNTaskInfo.wOQ = 3600;
    localCDNTaskInfo.wOR = true;
    localCDNTaskInfo.wOS = parama.field_downloadInWifi;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (parama.field_fileSize > 0L) {
        localJSONObject.put("Content-Length", parama.field_fileSize);
      }
      localCDNTaskInfo.wOO = localJSONObject.toString();
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
  
  private void iH(String paramString)
  {
    AppMethodBeat.i(88924);
    synchronized (this.lock)
    {
      Integer localInteger = (Integer)this.xnk.get(paramString);
      if (localInteger == null)
      {
        Log.i("MicroMsg.FileCDNDownloader", "No notification id found");
        AppMethodBeat.o(88924);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(localInteger.intValue());
      Log.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      this.xnk.remove(paramString);
      AppMethodBeat.o(88924);
      return;
    }
  }
  
  public final long a(final com.tencent.mm.plugin.downloader.f.a parama)
  {
    AppMethodBeat.i(88914);
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88909);
        com.tencent.mm.plugin.downloader.a.c.g(parama.field_appId, new String[] { parama.field_downloadUrl, parama.field_secondaryUrl });
        com.tencent.mm.plugin.openapi.a.gxp();
        q.bpV(parama.field_appId);
        Object localObject = b.c(parama);
        int i = com.tencent.mm.plugin.cdndownloader.d.a.dpZ().a((CDNTaskInfo)localObject);
        Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", new Object[] { Integer.valueOf(i), Long.valueOf(parama.field_downloadId) });
        if (i == 0)
        {
          parama.field_status = 1;
          parama.field_startTime = System.currentTimeMillis();
          d.d(parama);
          b.this.xnE.x(parama.field_downloadId, parama.field_filePath);
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
          com.tencent.mm.plugin.downloader.f.a locala1 = parama;
          com.tencent.mm.plugin.downloader.f.a locala2 = parama;
          long l = y.bEl(parama.field_filePath);
          locala2.field_totalSize = l;
          locala1.field_downloadedSize = l;
          ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startSize = l;
          localObject = parama;
          locala1 = parama;
          l = System.currentTimeMillis();
          locala1.field_finishTime = l;
          ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startTime = l;
          d.d(parama);
          b.this.xnE.kZ(parama.field_downloadId);
          localObject = new Intent();
          ((Intent)localObject).putExtra(FileDownloadService.xoh, 1);
          ((Intent)localObject).setClass(b.c(b.this), FileDownloadService.class);
          ((Intent)localObject).putExtra(FileDownloadService.xog, parama.field_downloadId);
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
        parama.field_errCode = com.tencent.mm.plugin.downloader.a.a.xkq;
        d.d(parama);
        b.this.xnE.d(parama.field_downloadId, parama.field_errCode, false);
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
    if ((paramg == null) || (Util.isNullOrNil(paramg.qGJ)))
    {
      Log.e("MicroMsg.FileCDNDownloader", "Invalid Request");
      AppMethodBeat.o(88915);
      return -1L;
    }
    Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask, appId : %s", new Object[] { paramg.mAppId });
    Object localObject4 = paramg.qGJ;
    Object localObject2 = d.amM((String)localObject4);
    if (localObject2 == null) {
      localObject2 = d.amJ(paramg.mAppId);
    }
    for (;;)
    {
      Object localObject1 = null;
      if (localObject2 != null)
      {
        localObject3 = kS(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId);
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
            if (((com.tencent.mm.plugin.downloader.f.a)localObject2).field_autoInstall) {
              com.tencent.mm.plugin.downloader.h.a.a(((FileDownloadTaskInfo)localObject3).id, false, null);
            }
            l = ((FileDownloadTaskInfo)localObject3).id;
            AppMethodBeat.o(88915);
            return l;
          }
        }
      }
      if (localObject2 != null) {
        d.lb(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId);
      }
      Object localObject3 = h.c(paramg);
      if ((paramg.xnR) && (localObject2 != null))
      {
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId = ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId;
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloaderType = 3;
        if (Util.isNullOrNil(paramg.xoc)) {
          break label639;
        }
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath = paramg.xoc;
        label283:
        localObject2 = ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath;
        localObject2 = new u(((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("/") + 1));
        if (!((u)localObject2).jKS())
        {
          if (!((u)localObject2).jKP().jKS())
          {
            localObject4 = ((u)localObject2).jKP();
            u localu = new u(ah.v(((u)localObject4).jKT()) + System.currentTimeMillis());
            if (!localu.jKY()) {
              break label675;
            }
            localu.am((u)localObject4);
          }
          Log.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((u)localObject2).jKY()) });
        }
        label416:
        if (localObject1 == null) {
          break label732;
        }
        localObject2 = ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath;
        localObject4 = localObject1.path;
        if ((localObject2 != null) && (localObject4 != null) && (!((String)localObject2).equals(localObject4)))
        {
          Log.i("MicroMsg.FileCDNDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject2, localObject4 });
          localObject2 = new u((String)localObject4);
          if (((u)localObject2).jKS()) {
            Log.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((u)localObject2).diJ()) });
          }
        }
        if (localObject1.status != 2) {
          break label701;
        }
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.xkD;
        label536:
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startSize = localObject1.xom;
        Log.i("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + localObject1.xom);
      }
      for (;;)
      {
        if ((!paramg.rAz) || (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
          break label743;
        }
        Log.i("MicroMsg.FileCDNDownloader", "downloadInWifi, not in wifi");
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status = 0;
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadInWifi = true;
        d.d((com.tencent.mm.plugin.downloader.f.a)localObject3);
        l = ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId;
        AppMethodBeat.o(88915);
        return l;
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId = System.currentTimeMillis();
        break;
        label639:
        localObject2 = MD5Util.getMD5String((String)localObject4);
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath = (xnh + (String)localObject2);
        break label283;
        label675:
        Log.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", new Object[] { ah.v(((u)localObject4).jKT()) });
        break label416;
        label701:
        if (localObject1.status == 4)
        {
          ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.xkE;
          break label536;
        }
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.xkC;
        break label536;
        label732:
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_startState = com.tencent.mm.plugin.downloader.a.b.xkC;
      }
      label743:
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadInWifi = true;
      }
      long l = a((com.tencent.mm.plugin.downloader.f.a)localObject3);
      AppMethodBeat.o(88915);
      return l;
    }
  }
  
  public final int kR(final long paramLong)
  {
    AppMethodBeat.i(88917);
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88910);
        FileDownloadTaskInfo localFileDownloadTaskInfo = b.this.kS(paramLong);
        if (localFileDownloadTaskInfo == null)
        {
          AppMethodBeat.o(88910);
          return;
        }
        com.tencent.mm.plugin.cdndownloader.d.a.dpZ().alK(localFileDownloadTaskInfo.url);
        b.a(b.this, localFileDownloadTaskInfo.url);
        y.deleteFile(localFileDownloadTaskInfo.path);
        Log.i("MicroMsg.FileCDNDownloader", "removeDownloadTask, delete file, path: %s", new Object[] { localFileDownloadTaskInfo.path });
        if (localFileDownloadTaskInfo.status != 5)
        {
          com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
          if (locala == null)
          {
            AppMethodBeat.o(88910);
            return;
          }
          locala.field_finishTime = System.currentTimeMillis();
          locala.field_downloadedSize = localFileDownloadTaskInfo.xom;
          locala.field_status = 5;
          d.e(locala);
          d.dR(locala.field_downloadUrl, 5);
          Long localLong = Long.valueOf(Util.nullAs((Long)b.b(b.this).get(localFileDownloadTaskInfo.url), locala.field_startTime));
          if (localLong != null)
          {
            long l1 = Util.nullAs((Long)b.a(b.this).get(localFileDownloadTaskInfo.url), locala.field_startSize);
            long l2 = System.currentTimeMillis();
            long l3 = localLong.longValue();
            float f = (float)(localFileDownloadTaskInfo.xom - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
            int i = (int)((float)localFileDownloadTaskInfo.xom / (float)localFileDownloadTaskInfo.uWn * 100.0F);
            com.tencent.mm.plugin.downloader.h.b.a(paramLong, f, i);
          }
          b.a(b.this).remove(localFileDownloadTaskInfo.url);
          b.b(b.this).remove(localFileDownloadTaskInfo.url);
          b.this.xnE.kX(paramLong);
        }
        AppMethodBeat.o(88910);
      }
    });
    AppMethodBeat.o(88917);
    return 1;
  }
  
  public final FileDownloadTaskInfo kS(long paramLong)
  {
    AppMethodBeat.i(88918);
    FileDownloadTaskInfo localFileDownloadTaskInfo = null;
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    CDNTaskState localCDNTaskState;
    label203:
    long l;
    if (locala != null)
    {
      Log.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, downloadid ; %d, appId : %s, status : %d", new Object[] { Long.valueOf(locala.field_downloadId), locala.field_appId, Integer.valueOf(locala.field_status) });
      localFileDownloadTaskInfo = new FileDownloadTaskInfo();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      localCDNTaskState = com.tencent.mm.plugin.cdndownloader.d.a.dpZ().alL(locala.field_downloadUrl);
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
          localFileDownloadTaskInfo.xom = locala.field_downloadedSize;
          localFileDownloadTaskInfo.uWn = locala.field_totalSize;
          if (localFileDownloadTaskInfo.xom <= localFileDownloadTaskInfo.uWn) {
            break label606;
          }
          l = localFileDownloadTaskInfo.uWn;
          label223:
          localFileDownloadTaskInfo.xom = l;
          locala.field_downloadedSize = localFileDownloadTaskInfo.xom;
          locala.field_totalSize = localFileDownloadTaskInfo.uWn;
        }
        break;
      }
    }
    for (;;)
    {
      if (((localFileDownloadTaskInfo.status == 6) || (localFileDownloadTaskInfo.status == 3)) && (!y.ZC(locala.field_filePath))) {
        localFileDownloadTaskInfo.status = 0;
      }
      if ((localFileDownloadTaskInfo.status == 6) && (!e.le(localFileDownloadTaskInfo.id))) {
        localFileDownloadTaskInfo.status = 3;
      }
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.hMd = locala.field_downloaderType;
      localFileDownloadTaskInfo.xon = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.md5 = locala.field_md5;
      if ((locala.field_status != localFileDownloadTaskInfo.status) && ((localFileDownloadTaskInfo.status == 1) || (locala.field_status == 1)))
      {
        locala.field_status = localFileDownloadTaskInfo.status;
        d.e(locala);
      }
      Log.i("MicroMsg.FileCDNDownloader", "queryDownloadTask, url: %s, status = %d, downloadedSize = %d, totalSize = %d", new Object[] { localFileDownloadTaskInfo.url, Integer.valueOf(localFileDownloadTaskInfo.status), Long.valueOf(localFileDownloadTaskInfo.xom), Long.valueOf(localFileDownloadTaskInfo.uWn) });
      AppMethodBeat.o(88918);
      return localFileDownloadTaskInfo;
      localFileDownloadTaskInfo.status = 1;
      break;
      localFileDownloadTaskInfo.status = 1;
      localFileDownloadTaskInfo.xom = localCDNTaskState.completeSize;
      localFileDownloadTaskInfo.uWn = localCDNTaskState.fileTotalSize;
      break label203;
      localFileDownloadTaskInfo.status = 2;
      localFileDownloadTaskInfo.xom = localCDNTaskState.completeSize;
      localFileDownloadTaskInfo.uWn = localCDNTaskState.fileTotalSize;
      break label203;
      if (y.ZC(locala.field_filePath))
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
      l = localFileDownloadTaskInfo.xom;
      break label223;
      label615:
      if (locala.field_status == 1) {}
      for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = locala.field_status)
      {
        if (y.ZC(locala.field_filePath)) {
          break label669;
        }
        localFileDownloadTaskInfo.xom = 0L;
        localFileDownloadTaskInfo.uWn = 0L;
        break;
      }
      label669:
      localFileDownloadTaskInfo.xom = locala.field_downloadedSize;
      localFileDownloadTaskInfo.uWn = locala.field_totalSize;
    }
  }
  
  public final boolean kT(final long paramLong)
  {
    AppMethodBeat.i(88919);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88911);
        Log.i("MicroMsg.FileCDNDownloader", "pauseDownloadTask");
        FileDownloadTaskInfo localFileDownloadTaskInfo = b.this.kS(paramLong);
        if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status == 1))
        {
          com.tencent.mm.plugin.cdndownloader.d.a.dpZ().alJ(localFileDownloadTaskInfo.url);
          b.a(b.this, localFileDownloadTaskInfo.url);
          com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
          if (locala != null)
          {
            locala.field_finishTime = System.currentTimeMillis();
            locala.field_status = 2;
            locala.field_downloadedSize = localFileDownloadTaskInfo.xom;
            d.e(locala);
            Long localLong = Long.valueOf(Util.nullAs((Long)b.b(b.this).get(localFileDownloadTaskInfo.url), locala.field_startTime));
            if (localLong != null)
            {
              long l1 = Util.nullAs((Long)b.a(b.this).get(localFileDownloadTaskInfo.url), locala.field_startSize);
              long l2 = System.currentTimeMillis();
              long l3 = localLong.longValue();
              float f = (float)(locala.field_downloadedSize - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
              int i = (int)((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F);
              com.tencent.mm.plugin.downloader.h.b.a(locala.field_downloadId, f, i);
            }
          }
          b.a(b.this).remove(localFileDownloadTaskInfo.url);
          b.b(b.this).remove(localFileDownloadTaskInfo.url);
          b.this.xnE.kY(paramLong);
        }
        AppMethodBeat.o(88911);
      }
    });
    AppMethodBeat.o(88919);
    return true;
  }
  
  public final boolean kU(long paramLong)
  {
    AppMethodBeat.i(88920);
    boolean bool = t(paramLong, true);
    AppMethodBeat.o(88920);
    return bool;
  }
  
  public final boolean kV(long paramLong)
  {
    AppMethodBeat.i(88922);
    Log.i("MicroMsg.FileCDNDownloader", "resumeDownloadTaskWhenProcessRestart, id = ".concat(String.valueOf(paramLong)));
    boolean bool = t(paramLong, false);
    AppMethodBeat.o(88922);
    return bool;
  }
  
  public final boolean kW(long paramLong)
  {
    AppMethodBeat.i(88925);
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if (locala != null)
    {
      locala.field_downloadType = 2;
      d.e(locala);
    }
    com.tencent.mm.plugin.downloader.e.a.A(paramLong, 13);
    boolean bool = kT(paramLong);
    AppMethodBeat.o(88925);
    return bool;
  }
  
  public final boolean t(final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88921);
    final com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if (locala != null)
    {
      FileDownloadTaskInfo localFileDownloadTaskInfo = kS(locala.field_downloadId);
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
          com.tencent.mm.plugin.downloader.h.a.a(localFileDownloadTaskInfo.id, false, null);
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
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(88912);
          com.tencent.mm.plugin.downloader.a.c.g(locala.field_appId, new String[] { locala.field_downloadUrl, locala.field_secondaryUrl });
          com.tencent.mm.plugin.openapi.a.gxp();
          q.bpV(locala.field_appId);
          int i = com.tencent.mm.plugin.cdndownloader.d.a.dpZ().b(b.c(locala));
          Log.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: ".concat(String.valueOf(i)));
          locala.field_startTime = System.currentTimeMillis();
          locala.field_startSize = locala.field_downloadedSize;
          locala.field_startState = com.tencent.mm.plugin.downloader.a.b.xkD;
          long l;
          if (i == 0)
          {
            locala.field_status = 1;
            locala.field_errCode = 0;
            d.e(locala);
            if (paramBoolean) {
              b.this.xnE.y(paramLong, locala.field_filePath);
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
            com.tencent.mm.plugin.downloader.f.a locala = locala;
            l = locala.field_totalSize;
            locala.field_downloadedSize = l;
            ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startSize = l;
            localObject = locala;
            locala = locala;
            l = System.currentTimeMillis();
            locala.field_finishTime = l;
            ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startTime = l;
            d.e(locala);
            b.this.xnE.kZ(locala.field_downloadId);
            localObject = new Intent();
            ((Intent)localObject).putExtra(FileDownloadService.xoh, 1);
            ((Intent)localObject).setClass(b.c(b.this), FileDownloadService.class);
            ((Intent)localObject).putExtra(FileDownloadService.xog, locala.field_downloadId);
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
          locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.xkr;
          d.e(locala);
          b.this.xnE.d(paramLong, locala.field_errCode, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b
 * JD-Core Version:    0.7.0.1
 */