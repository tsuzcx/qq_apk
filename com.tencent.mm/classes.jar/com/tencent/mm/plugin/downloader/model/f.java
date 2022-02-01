package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.support.v4.app.s.c;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.im;
import com.tencent.mm.g.a.im.a;
import com.tencent.mm.m.e;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private static int jAz;
  private static Map<Long, Long> ofa;
  private static f ofj;
  private n ofb;
  private n ofc;
  private n ofd;
  private com.tencent.mm.plugin.downloader.h.a ofe;
  private b ofg;
  private n ofh;
  public c ofi;
  public boolean ofk;
  
  static
  {
    AppMethodBeat.i(89004);
    ofa = new HashMap();
    jAz = 2;
    AppMethodBeat.o(89004);
  }
  
  private f()
  {
    AppMethodBeat.i(88975);
    this.ofk = false;
    bQA();
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afz();
      if (!com.tencent.mm.kernel.a.aeC())
      {
        jAz = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("FileDownloaderType"), 2);
        ad.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(jAz) });
      }
    }
    for (;;)
    {
      this.ofi = new c();
      AppMethodBeat.o(88975);
      return;
      ad.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  static void O(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88994);
    ofa.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    aj.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    AppMethodBeat.o(88994);
  }
  
  public static LinkedList<FileDownloadTaskInfo> R(LinkedList<String> paramLinkedList)
  {
    com.tencent.mm.plugin.downloader.g.a locala = null;
    AppMethodBeat.i(88988);
    Object localObject2 = d.apS();
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = locala;
      paramLinkedList = new LinkedList();
      if ((localObject1 == null) || (((LinkedList)localObject1).size() <= 0)) {
        break label327;
      }
      localObject1 = ((LinkedList)localObject1).iterator();
      label41:
      if (!((Iterator)localObject1).hasNext()) {
        break label327;
      }
      locala = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
      localObject2 = new FileDownloadTaskInfo();
      if ((locala.field_status != 3) || (com.tencent.mm.vfs.i.eK(locala.field_filePath))) {
        break label316;
      }
    }
    label316:
    for (((FileDownloadTaskInfo)localObject2).status = 0;; ((FileDownloadTaskInfo)localObject2).status = locala.field_status)
    {
      ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
      ((FileDownloadTaskInfo)localObject2).id = locala.field_downloadId;
      ((FileDownloadTaskInfo)localObject2).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject2).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject2).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject2).ofL = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject2).mqq = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject2).ofM = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).dlp = locala.field_downloaderType;
      ((FileDownloadTaskInfo)localObject2).ofN = locala.field_downloadInWifi;
      ((FileDownloadTaskInfo)localObject2).ofO = locala.field_reserveInWifi;
      paramLinkedList.add(localObject2);
      break label41;
      localObject1 = locala;
      if (bt.gL(paramLinkedList)) {
        break;
      }
      localObject2 = ((com.tencent.mm.plugin.downloader.g.b)localObject2).rawQuery(String.format("select * from %s where %s in %s or %s in %s", new Object[] { "FileDownloadInfo", "appId", com.tencent.mm.plugin.downloader.g.b.T(paramLinkedList), "rawAppId", com.tencent.mm.plugin.downloader.g.b.T(paramLinkedList) }), new String[0]);
      localObject1 = locala;
      if (localObject2 == null) {
        break;
      }
      paramLinkedList = new LinkedList();
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          localObject1 = new com.tencent.mm.plugin.downloader.g.a();
          ((com.tencent.mm.plugin.downloader.g.a)localObject1).convertFrom((Cursor)localObject2);
          paramLinkedList.add(localObject1);
        } while (((Cursor)localObject2).moveToNext());
      }
      localObject1 = paramLinkedList;
      if (localObject2 == null) {
        break;
      }
      ((Cursor)localObject2).close();
      localObject1 = paramLinkedList;
      break;
    }
    label327:
    AppMethodBeat.o(88988);
    return paramLinkedList;
  }
  
  private void a(String paramString, g paramg)
  {
    AppMethodBeat.i(88997);
    com.tencent.mm.plugin.downloader.g.a locala;
    if (!this.ofk)
    {
      locala = d.Sk(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        hv localhv = new hv();
        localhv.dlA.dlB = paramString;
        com.tencent.mm.sdk.b.a.ESL.l(localhv);
        if (paramg == null) {
          break label117;
        }
        locala.field_autoInstall = paramg.ofr;
        locala.field_showNotification = paramg.jAy;
      }
    }
    for (locala.field_autoDownload = paramg.oft;; locala.field_autoDownload = false)
    {
      d.e(locala);
      ad.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.ofk = false;
      AppMethodBeat.o(88997);
      return;
      label117:
      locala.field_autoInstall = true;
      locala.field_showNotification = true;
    }
  }
  
  static void a(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(88992);
    s.c localc = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id");
    if (!TextUtils.isEmpty(paramString2))
    {
      localc.f(paramString2);
      localc.g(paramString3);
      localc.as(17301634);
      localc.F(true);
      if (paramPendingIntent == null) {
        break label150;
      }
    }
    for (localc.Ew = paramPendingIntent;; localc.Ew = PendingIntent.getActivity(aj.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
      ad.i("MicroMsg.FileDownloadManager", "show notification");
      AppMethodBeat.o(88992);
      return;
      paramString1 = com.tencent.mm.pluginsdk.model.app.h.j(paramString1, false, false);
      if ((paramString1 != null) && (!bt.isNullOrNil(paramString1.field_appName)))
      {
        localc.f(paramString1.field_appName);
        break;
      }
      localc.f("");
      break;
      label150:
      paramString1 = new Intent();
    }
  }
  
  private static void bQA()
  {
    AppMethodBeat.i(88991);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("off_line_download_ids", 0);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(88991);
      return;
    }
    Object localObject = localSharedPreferences.getAll();
    if ((localObject == null) || (((Map)localObject).size() == 0))
    {
      AppMethodBeat.o(88991);
      return;
    }
    ofa.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry1 != null) && (!bt.isNullOrNil((String)localEntry1.getKey()))) {
        try
        {
          long l1 = bt.getLong((String)localEntry1.getKey(), 0L);
          long l2 = ((Long)localEntry1.getValue()).longValue();
          long l3 = System.currentTimeMillis() - l1;
          if ((l3 - l1 > 0L) && (l3 - l1 < 86400000L)) {
            ofa.put(Long.valueOf(l1), Long.valueOf(l2));
          }
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.FileDownloadManager", "parse download task failed: " + localException.toString());
          ad.printErrStackTrace("MicroMsg.FileDownloadManager", localException, "", new Object[0]);
        }
      }
    }
    localSharedPreferences.edit().clear();
    localObject = ofa.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    AppMethodBeat.o(88991);
  }
  
  public static f bQt()
  {
    AppMethodBeat.i(88974);
    if (ofj == null) {
      ofj = new f();
    }
    f localf = ofj;
    AppMethodBeat.o(88974);
    return localf;
  }
  
  private n bQv()
  {
    AppMethodBeat.i(88977);
    if (this.ofd == null) {
      this.ofd = new i(this.ofi);
    }
    n localn = this.ofd;
    AppMethodBeat.o(88977);
    return localn;
  }
  
  private n bQw()
  {
    AppMethodBeat.i(88978);
    if (this.ofc == null) {
      this.ofc = new k(this.ofi);
    }
    n localn = this.ofc;
    AppMethodBeat.o(88978);
    return localn;
  }
  
  private n bQz()
  {
    AppMethodBeat.i(88981);
    if (this.ofh == null) {
      this.ofh = new l(this.ofi);
    }
    n localn = this.ofh;
    AppMethodBeat.o(88981);
    return localn;
  }
  
  static boolean ov(long paramLong)
  {
    AppMethodBeat.i(88993);
    boolean bool = ofa.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(88993);
    return bool;
  }
  
  static long ow(long paramLong)
  {
    AppMethodBeat.i(88995);
    Long localLong = (Long)ofa.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(88995);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(88995);
    return paramLong;
  }
  
  private void ox(long paramLong)
  {
    AppMethodBeat.i(88998);
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if (locala == null)
    {
      this.ofk = false;
      AppMethodBeat.o(88998);
      return;
    }
    a(locala.field_appId, null);
    AppMethodBeat.o(88998);
  }
  
  public final FileDownloadTaskInfo Sp(String paramString)
  {
    AppMethodBeat.i(88986);
    paramString = d.Sk(paramString);
    if (paramString != null)
    {
      paramString = oh(paramString.field_downloadId);
      AppMethodBeat.o(88986);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88986);
    return paramString;
  }
  
  public final FileDownloadTaskInfo Sq(String paramString)
  {
    AppMethodBeat.i(88987);
    paramString = d.Sn(paramString);
    if (paramString != null)
    {
      paramString = oh(paramString.field_downloadId);
      AppMethodBeat.o(88987);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88987);
    return paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(88982);
    ad.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(paramg.ofq), paramg.mAppId });
    if (paramg.ofq == 2)
    {
      l = bQz().a(paramg);
      AppMethodBeat.o(88982);
      return l;
    }
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afz();
      if (!com.tencent.mm.kernel.a.aeC())
      {
        ad.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
        l = bQu().a(paramg);
        AppMethodBeat.o(88982);
        return l;
      }
    }
    long l = bQv().a(paramg);
    if (l >= 0L)
    {
      ofa.put(Long.valueOf(l), Long.valueOf(0L));
      aj.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ad.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88982);
      return l;
    }
    ad.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    bQw().a(paramg);
    AppMethodBeat.o(88982);
    return l;
  }
  
  public final long b(g paramg)
  {
    AppMethodBeat.i(88983);
    ad.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", new Object[] { paramg.mAppId });
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afz();
      if (!com.tencent.mm.kernel.a.aeC())
      {
        l = bQy().a(paramg);
        AppMethodBeat.o(88983);
        return l;
      }
    }
    long l = bQv().a(paramg);
    if (l >= 0L)
    {
      ofa.put(Long.valueOf(l), Long.valueOf(0L));
      aj.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ad.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88983);
      return l;
    }
    ad.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    bQw().a(paramg);
    AppMethodBeat.o(88983);
    return l;
  }
  
  public final n bQu()
  {
    AppMethodBeat.i(88976);
    ad.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + jAz);
    if (this.ofb != null)
    {
      localObject = this.ofb;
      AppMethodBeat.o(88976);
      return localObject;
    }
    Object localObject = new im();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    int i = ((im)localObject).dmu.dlp;
    ad.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i)));
    if (i > 0) {
      jAz = i;
    }
    if (jAz == 1) {}
    for (this.ofb = bQv();; this.ofb = bQx())
    {
      localObject = this.ofb;
      AppMethodBeat.o(88976);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.downloader.h.a bQx()
  {
    AppMethodBeat.i(88979);
    if (this.ofe == null) {
      this.ofe = new com.tencent.mm.plugin.downloader.h.a(this.ofi);
    }
    com.tencent.mm.plugin.downloader.h.a locala = this.ofe;
    AppMethodBeat.o(88979);
    return locala;
  }
  
  public final b bQy()
  {
    AppMethodBeat.i(88980);
    if (this.ofg == null) {
      this.ofg = new b(this.ofi);
    }
    b localb = this.ofg;
    AppMethodBeat.o(88980);
    return localb;
  }
  
  public final boolean h(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(89000);
    if ((parama != null) && (parama.field_downloaderType == 3))
    {
      bool = bQy().m(parama.field_downloadId, true);
      AppMethodBeat.o(89000);
      return bool;
    }
    boolean bool = bQx().m(parama.field_downloadId, true);
    AppMethodBeat.o(89000);
    return bool;
  }
  
  final void n(long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88996);
    ad.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bt.eGN() });
    aj.getContext();
    if (ov(paramLong))
    {
      localObject = oh(paramLong);
      this.ofi.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      AppMethodBeat.o(88996);
      return;
    }
    Object localObject = d.oq(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(88996);
      return;
    }
    if (bt.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName))
    {
      String str = r.aAZ(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
      if (!bt.isNullOrNil(str))
      {
        ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName = str;
        ad.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, str });
        d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
      }
    }
    final int i = r.aBa(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
    ad.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName, ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, Integer.valueOf(i) });
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88972);
        if ((com.tencent.mm.kernel.g.afA().gcy == null) || (com.tencent.mm.kernel.g.afA().gcy.gVH == null))
        {
          AppMethodBeat.o(88972);
          return;
        }
        new ae(this.oeS.field_packageName, i).doScene(com.tencent.mm.kernel.g.afA().gcy.gVH, new com.tencent.mm.al.g()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
          {
            AppMethodBeat.i(88971);
            paramAnonymous2n.setHasCallbackToQueue(true);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
            {
              ad.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(322L, 28L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { f.1.this.oeS.field_packageName, f.1.this.oeS.field_filePath, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) }) });
              if ((!bt.isNullOrNil(f.1.this.oeS.field_appId)) && (com.tencent.mm.pluginsdk.model.app.h.eN(f.1.this.oeS.field_appId)))
              {
                ad.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", new Object[] { f.1.this.oeS.field_appId });
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(710L, 24L, 1L, false);
              }
            }
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.aq.f(new f.2(f.this, f.1.this.oeS, f.1.this.oeY));
              AppMethodBeat.o(88971);
              return;
              paramAnonymous2String = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.XN()).getString(f.1.this.oeS.field_packageName, "");
              ad.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramAnonymous2String });
              if ((!bt.isNullOrNil(paramAnonymous2String)) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
              {
                try
                {
                  com.tencent.mm.d.c.g(new File(com.tencent.mm.vfs.i.k(f.1.this.oeS.field_filePath, true)), paramAnonymous2String);
                  ad.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(322L, 25L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { f.1.this.oeS.field_packageName, f.1.this.oeS.field_filePath, paramAnonymous2String }) });
                }
                catch (Exception paramAnonymous2String)
                {
                  ad.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramAnonymous2String.getMessage());
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(322L, 27L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { f.1.this.oeS.field_packageName, f.1.this.oeS.field_filePath, paramAnonymous2String.getMessage() }) });
                }
              }
              else
              {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(322L, 26L, 1L, false);
                com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { f.1.this.oeS.field_packageName, f.1.this.oeS.field_filePath }) });
              }
            }
          }
        });
        AppMethodBeat.o(88972);
      }
    });
    AppMethodBeat.o(88996);
  }
  
  public final int og(long paramLong)
  {
    AppMethodBeat.i(88984);
    ad.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (ov(paramLong))
    {
      i = bQv().og(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = bQy().og(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    int i = bQu().og(paramLong);
    AppMethodBeat.o(88984);
    return i;
  }
  
  public final FileDownloadTaskInfo oh(long paramLong)
  {
    AppMethodBeat.i(88985);
    Object localObject1;
    if (ov(paramLong))
    {
      localObject1 = bQv().oh(paramLong);
      AppMethodBeat.o(88985);
      return localObject1;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    Object localObject2;
    if ((locala != null) && (locala.field_status == 3) && (com.tencent.mm.vfs.i.eK(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).ofL = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).mqq = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).ofM = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).dlp = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (com.tencent.mm.vfs.i.eK(((FileDownloadTaskInfo)localObject2).path)) {
          break label406;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        ((FileDownloadTaskInfo)localObject2).ofN = locala.field_downloadInWifi;
        ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
        ((FileDownloadTaskInfo)localObject2).ofO = locala.field_reserveInWifi;
      }
      ad.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).md5, Long.valueOf(((FileDownloadTaskInfo)localObject2).mqq), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).ofM), Integer.valueOf(((FileDownloadTaskInfo)localObject2).dlp) });
      AppMethodBeat.o(88985);
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = bQy().oh(paramLong);
        break;
      }
      localObject2 = bQu().oh(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).ofM = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).dlp = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      label406:
      if (((FileDownloadTaskInfo)localObject2).status == 6) {
        ((FileDownloadTaskInfo)localObject2).status = 1;
      }
    }
  }
  
  public final boolean oi(long paramLong)
  {
    AppMethodBeat.i(88989);
    ad.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(paramLong)));
    ox(paramLong);
    if (ov(paramLong))
    {
      bool = bQv().oi(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bQy().oi(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    boolean bool = bQu().oi(paramLong);
    AppMethodBeat.o(88989);
    return bool;
  }
  
  public final boolean oj(long paramLong)
  {
    AppMethodBeat.i(88990);
    ad.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    ox(paramLong);
    if (ov(paramLong))
    {
      bool = bQv().oj(paramLong);
      AppMethodBeat.o(88990);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if ((locala != null) && (!locala.field_reserveInWifi) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bQy().m(paramLong, true);
      AppMethodBeat.o(88990);
      return bool;
    }
    boolean bool = bQu().oj(paramLong);
    AppMethodBeat.o(88990);
    return bool;
  }
  
  public final boolean ok(long paramLong)
  {
    AppMethodBeat.i(88999);
    ad.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (ov(paramLong))
    {
      AppMethodBeat.o(88999);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bQy().ok(paramLong);
      AppMethodBeat.o(88999);
      return bool;
    }
    boolean bool = bQx().ok(paramLong);
    AppMethodBeat.o(88999);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */