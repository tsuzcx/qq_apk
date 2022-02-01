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
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.jb.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.n.e;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
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
  private static int kvr;
  private static Map<Long, Long> pmi;
  private static f pmq;
  private n pmj;
  private n pmk;
  private n pml;
  private com.tencent.mm.plugin.downloader.h.a pmm;
  private b pmn;
  private n pmo;
  public c pmp;
  public boolean pmr;
  
  static
  {
    AppMethodBeat.i(89004);
    pmi = new HashMap();
    kvr = 2;
    AppMethodBeat.o(89004);
  }
  
  private f()
  {
    AppMethodBeat.i(88975);
    this.pmr = false;
    ccs();
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      com.tencent.mm.kernel.g.ajA();
      if (!com.tencent.mm.kernel.a.aiE())
      {
        kvr = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("FileDownloaderType"), 2);
        ad.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(kvr) });
      }
    }
    for (;;)
    {
      this.pmp = new c();
      AppMethodBeat.o(88975);
      return;
      ad.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  static void K(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88994);
    pmi.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    aj.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    AppMethodBeat.o(88994);
  }
  
  public static LinkedList<FileDownloadTaskInfo> S(LinkedList<String> paramLinkedList)
  {
    com.tencent.mm.plugin.downloader.g.a locala = null;
    AppMethodBeat.i(88988);
    Object localObject2 = d.azw();
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
      if ((locala.field_status != 3) || (com.tencent.mm.vfs.i.fv(locala.field_filePath))) {
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
      ((FileDownloadTaskInfo)localObject2).pmT = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject2).nsQ = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject2).pmU = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).duJ = locala.field_downloaderType;
      ((FileDownloadTaskInfo)localObject2).pmV = locala.field_downloadInWifi;
      ((FileDownloadTaskInfo)localObject2).pmW = locala.field_reserveInWifi;
      paramLinkedList.add(localObject2);
      break label41;
      localObject1 = locala;
      if (bt.hj(paramLinkedList)) {
        break;
      }
      localObject2 = ((com.tencent.mm.plugin.downloader.g.b)localObject2).rawQuery(String.format("select * from %s where %s in %s or %s in %s", new Object[] { "FileDownloadInfo", "appId", com.tencent.mm.plugin.downloader.g.b.U(paramLinkedList), "rawAppId", com.tencent.mm.plugin.downloader.g.b.U(paramLinkedList) }), new String[0]);
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
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(221587);
    c.a(paramm);
    AppMethodBeat.o(221587);
  }
  
  private void a(String paramString, g paramg)
  {
    AppMethodBeat.i(88997);
    com.tencent.mm.plugin.downloader.g.a locala;
    if (!this.pmr)
    {
      locala = d.aad(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        ik localik = new ik();
        localik.duV.duW = paramString;
        com.tencent.mm.sdk.b.a.IbL.l(localik);
        if (paramg == null) {
          break label117;
        }
        locala.field_autoInstall = paramg.pmy;
        locala.field_showNotification = paramg.kvq;
      }
    }
    for (locala.field_autoDownload = paramg.pmA;; locala.field_autoDownload = false)
    {
      d.e(locala);
      ad.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.pmr = false;
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
    s.c localc = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id");
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
    for (localc.Hl = paramPendingIntent;; localc.Hl = PendingIntent.getActivity(aj.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
      ad.i("MicroMsg.FileDownloadManager", "show notification");
      AppMethodBeat.o(88992);
      return;
      paramString1 = h.m(paramString1, false, false);
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
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(221588);
    c.b(paramm);
    AppMethodBeat.o(221588);
  }
  
  public static f ccl()
  {
    AppMethodBeat.i(88974);
    if (pmq == null) {
      pmq = new f();
    }
    f localf = pmq;
    AppMethodBeat.o(88974);
    return localf;
  }
  
  private n ccn()
  {
    AppMethodBeat.i(88977);
    if (this.pml == null) {
      this.pml = new i(this.pmp);
    }
    n localn = this.pml;
    AppMethodBeat.o(88977);
    return localn;
  }
  
  private n cco()
  {
    AppMethodBeat.i(88978);
    if (this.pmk == null) {
      this.pmk = new k(this.pmp);
    }
    n localn = this.pmk;
    AppMethodBeat.o(88978);
    return localn;
  }
  
  private n ccr()
  {
    AppMethodBeat.i(88981);
    if (this.pmo == null) {
      this.pmo = new l(this.pmp);
    }
    n localn = this.pmo;
    AppMethodBeat.o(88981);
    return localn;
  }
  
  private static void ccs()
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
    pmi.clear();
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
            pmi.put(Long.valueOf(l1), Long.valueOf(l2));
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
    localObject = pmi.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    AppMethodBeat.o(88991);
  }
  
  static boolean uf(long paramLong)
  {
    AppMethodBeat.i(88993);
    boolean bool = pmi.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(88993);
    return bool;
  }
  
  static long ug(long paramLong)
  {
    AppMethodBeat.i(88995);
    Long localLong = (Long)pmi.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(88995);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(88995);
    return paramLong;
  }
  
  private void uh(long paramLong)
  {
    AppMethodBeat.i(88998);
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    if (locala == null)
    {
      this.pmr = false;
      AppMethodBeat.o(88998);
      return;
    }
    a(locala.field_appId, null);
    AppMethodBeat.o(88998);
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(88982);
    ad.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(paramg.pmx), paramg.mAppId });
    if (paramg.pmx == 2)
    {
      l = ccr().a(paramg);
      AppMethodBeat.o(88982);
      return l;
    }
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      com.tencent.mm.kernel.g.ajA();
      if (!com.tencent.mm.kernel.a.aiE())
      {
        ad.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
        l = ccm().a(paramg);
        AppMethodBeat.o(88982);
        return l;
      }
    }
    long l = ccn().a(paramg);
    if (l >= 0L)
    {
      pmi.put(Long.valueOf(l), Long.valueOf(0L));
      aj.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ad.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88982);
      return l;
    }
    ad.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    cco().a(paramg);
    AppMethodBeat.o(88982);
    return l;
  }
  
  public final FileDownloadTaskInfo aai(String paramString)
  {
    AppMethodBeat.i(88986);
    paramString = d.aad(paramString);
    if (paramString != null)
    {
      paramString = tS(paramString.field_downloadId);
      AppMethodBeat.o(88986);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88986);
    return paramString;
  }
  
  public final FileDownloadTaskInfo aaj(String paramString)
  {
    AppMethodBeat.i(88987);
    paramString = d.aag(paramString);
    if (paramString != null)
    {
      paramString = tS(paramString.field_downloadId);
      AppMethodBeat.o(88987);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88987);
    return paramString;
  }
  
  public final long b(g paramg)
  {
    AppMethodBeat.i(88983);
    ad.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", new Object[] { paramg.mAppId });
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      com.tencent.mm.kernel.g.ajA();
      if (!com.tencent.mm.kernel.a.aiE())
      {
        l = ccq().a(paramg);
        AppMethodBeat.o(88983);
        return l;
      }
    }
    long l = ccn().a(paramg);
    if (l >= 0L)
    {
      pmi.put(Long.valueOf(l), Long.valueOf(0L));
      aj.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ad.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88983);
      return l;
    }
    ad.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    cco().a(paramg);
    AppMethodBeat.o(88983);
    return l;
  }
  
  public final n ccm()
  {
    AppMethodBeat.i(88976);
    ad.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + kvr);
    if (this.pmj != null)
    {
      localObject = this.pmj;
      AppMethodBeat.o(88976);
      return localObject;
    }
    Object localObject = new jb();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    int i = ((jb)localObject).dvP.duJ;
    ad.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i)));
    if (i > 0) {
      kvr = i;
    }
    if (kvr == 1) {}
    for (this.pmj = ccn();; this.pmj = ccp())
    {
      localObject = this.pmj;
      AppMethodBeat.o(88976);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.downloader.h.a ccp()
  {
    AppMethodBeat.i(88979);
    if (this.pmm == null) {
      this.pmm = new com.tencent.mm.plugin.downloader.h.a(this.pmp);
    }
    com.tencent.mm.plugin.downloader.h.a locala = this.pmm;
    AppMethodBeat.o(88979);
    return locala;
  }
  
  public final b ccq()
  {
    AppMethodBeat.i(88980);
    if (this.pmn == null) {
      this.pmn = new b(this.pmp);
    }
    b localb = this.pmn;
    AppMethodBeat.o(88980);
    return localb;
  }
  
  public final boolean h(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(89000);
    if ((parama != null) && (parama.field_downloaderType == 3))
    {
      bool = ccq().n(parama.field_downloadId, true);
      AppMethodBeat.o(89000);
      return bool;
    }
    boolean bool = ccp().n(parama.field_downloadId, true);
    AppMethodBeat.o(89000);
    return bool;
  }
  
  final void o(long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88996);
    ad.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bt.flS() });
    aj.getContext();
    if (uf(paramLong))
    {
      localObject = tS(paramLong);
      this.pmp.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      AppMethodBeat.o(88996);
      return;
    }
    Object localObject = d.ua(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(88996);
      return;
    }
    if (bt.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName))
    {
      String str = r.aLR(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
      if (!bt.isNullOrNil(str))
      {
        ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName = str;
        ad.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, str });
        d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
      }
    }
    final int i = r.aLS(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
    ad.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName, ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, Integer.valueOf(i) });
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88972);
        if ((com.tencent.mm.kernel.g.ajB().gAO == null) || (com.tencent.mm.kernel.g.ajB().gAO.hOv == null))
        {
          AppMethodBeat.o(88972);
          return;
        }
        new ae(this.plY.field_packageName, i).doScene(com.tencent.mm.kernel.g.ajB().gAO.hOv, new com.tencent.mm.al.f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
          {
            AppMethodBeat.i(88971);
            paramAnonymous2n.setHasCallbackToQueue(true);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
            {
              ad.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 28L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { f.1.this.plY.field_packageName, f.1.this.plY.field_filePath, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) }) });
              if ((!bt.isNullOrNil(f.1.this.plY.field_appId)) && (h.fy(f.1.this.plY.field_appId)))
              {
                ad.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", new Object[] { f.1.this.plY.field_appId });
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(710L, 24L, 1L, false);
              }
            }
            for (;;)
            {
              aq.f(new f.2(f.this, f.1.this.plY, f.1.this.pme));
              AppMethodBeat.o(88971);
              return;
              paramAnonymous2String = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.abm()).getString(f.1.this.plY.field_packageName, "");
              ad.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramAnonymous2String });
              if ((!bt.isNullOrNil(paramAnonymous2String)) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE))
              {
                try
                {
                  com.tencent.mm.d.c.g(new File(com.tencent.mm.vfs.i.k(f.1.this.plY.field_filePath, true)), paramAnonymous2String);
                  ad.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 25L, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { f.1.this.plY.field_packageName, f.1.this.plY.field_filePath, paramAnonymous2String }) });
                }
                catch (Exception paramAnonymous2String)
                {
                  ad.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramAnonymous2String.getMessage());
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 27L, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { f.1.this.plY.field_packageName, f.1.this.plY.field_filePath, paramAnonymous2String.getMessage() }) });
                }
              }
              else
              {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 26L, 1L, false);
                com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { f.1.this.plY.field_packageName, f.1.this.plY.field_filePath }) });
              }
            }
          }
        });
        AppMethodBeat.o(88972);
      }
    });
    AppMethodBeat.o(88996);
  }
  
  public final int tR(long paramLong)
  {
    AppMethodBeat.i(88984);
    ad.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (uf(paramLong))
    {
      i = ccn().tR(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = ccq().tR(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    int i = ccm().tR(paramLong);
    AppMethodBeat.o(88984);
    return i;
  }
  
  public final FileDownloadTaskInfo tS(long paramLong)
  {
    AppMethodBeat.i(88985);
    Object localObject1;
    if (uf(paramLong))
    {
      localObject1 = ccn().tS(paramLong);
      AppMethodBeat.o(88985);
      return localObject1;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    Object localObject2;
    if ((locala != null) && (locala.field_status == 3) && (com.tencent.mm.vfs.i.fv(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).pmT = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).nsQ = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).pmU = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).duJ = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (com.tencent.mm.vfs.i.fv(((FileDownloadTaskInfo)localObject2).path)) {
          break label406;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        ((FileDownloadTaskInfo)localObject2).pmV = locala.field_downloadInWifi;
        ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
        ((FileDownloadTaskInfo)localObject2).pmW = locala.field_reserveInWifi;
      }
      ad.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).md5, Long.valueOf(((FileDownloadTaskInfo)localObject2).nsQ), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).pmU), Integer.valueOf(((FileDownloadTaskInfo)localObject2).duJ) });
      AppMethodBeat.o(88985);
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = ccq().tS(paramLong);
        break;
      }
      localObject2 = ccm().tS(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).pmU = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).duJ = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      label406:
      if (((FileDownloadTaskInfo)localObject2).status == 6) {
        ((FileDownloadTaskInfo)localObject2).status = 1;
      }
    }
  }
  
  public final boolean tT(long paramLong)
  {
    AppMethodBeat.i(88989);
    ad.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(paramLong)));
    uh(paramLong);
    if (uf(paramLong))
    {
      bool = ccn().tT(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = ccq().tT(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    boolean bool = ccm().tT(paramLong);
    AppMethodBeat.o(88989);
    return bool;
  }
  
  public final boolean tU(long paramLong)
  {
    AppMethodBeat.i(88990);
    ad.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    uh(paramLong);
    if (uf(paramLong))
    {
      bool = ccn().tU(paramLong);
      AppMethodBeat.o(88990);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    if ((locala != null) && (!locala.field_reserveInWifi) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = ccq().n(paramLong, true);
      AppMethodBeat.o(88990);
      return bool;
    }
    boolean bool = ccm().tU(paramLong);
    AppMethodBeat.o(88990);
    return bool;
  }
  
  public final boolean tV(long paramLong)
  {
    AppMethodBeat.i(88999);
    ad.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (uf(paramLong))
    {
      AppMethodBeat.o(88999);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = ccq().tV(paramLong);
      AppMethodBeat.o(88999);
      return bool;
    }
    boolean bool = ccp().tV(paramLong);
    AppMethodBeat.o(88999);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */