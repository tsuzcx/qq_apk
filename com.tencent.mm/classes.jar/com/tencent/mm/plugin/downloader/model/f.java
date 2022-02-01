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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.jc.a;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.n.e;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private static int kyG;
  private static Map<Long, Long> psN;
  private static f psV;
  private n psO;
  private n psP;
  private n psQ;
  private com.tencent.mm.plugin.downloader.h.a psR;
  private b psS;
  private n psT;
  public c psU;
  public boolean psW;
  
  static
  {
    AppMethodBeat.i(89004);
    psN = new HashMap();
    kyG = 2;
    AppMethodBeat.o(89004);
  }
  
  private f()
  {
    AppMethodBeat.i(88975);
    this.psW = false;
    cdH();
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.kernel.g.ajP();
      if (!com.tencent.mm.kernel.a.aiT())
      {
        kyG = bu.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("FileDownloaderType"), 2);
        ae.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(kyG) });
      }
    }
    for (;;)
    {
      this.psU = new c();
      AppMethodBeat.o(88975);
      return;
      ae.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  static void J(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88994);
    psN.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    ak.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    AppMethodBeat.o(88994);
  }
  
  public static LinkedList<FileDownloadTaskInfo> S(LinkedList<String> paramLinkedList)
  {
    com.tencent.mm.plugin.downloader.g.a locala = null;
    AppMethodBeat.i(88988);
    Object localObject2 = d.azM();
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
      if ((locala.field_status != 3) || (o.fB(locala.field_filePath))) {
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
      ((FileDownloadTaskInfo)localObject2).ptA = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject2).nyl = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject2).ptB = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).dvO = locala.field_downloaderType;
      ((FileDownloadTaskInfo)localObject2).ptC = locala.field_downloadInWifi;
      ((FileDownloadTaskInfo)localObject2).ptD = locala.field_reserveInWifi;
      paramLinkedList.add(localObject2);
      break label41;
      localObject1 = locala;
      if (bu.ht(paramLinkedList)) {
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
    AppMethodBeat.i(224412);
    c.a(paramm);
    AppMethodBeat.o(224412);
  }
  
  private void a(String paramString, g paramg)
  {
    AppMethodBeat.i(88997);
    com.tencent.mm.plugin.downloader.g.a locala;
    if (!this.psW)
    {
      locala = d.aaU(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        il localil = new il();
        localil.dwa.dwb = paramString;
        com.tencent.mm.sdk.b.a.IvT.l(localil);
        if (paramg == null) {
          break label117;
        }
        locala.field_autoInstall = paramg.ptd;
        locala.field_showNotification = paramg.kyF;
      }
    }
    for (locala.field_autoDownload = paramg.ptf;; locala.field_autoDownload = false)
    {
      d.e(locala);
      ae.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.psW = false;
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
    s.c localc = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id");
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
    for (localc.Hl = paramPendingIntent;; localc.Hl = PendingIntent.getActivity(ak.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
      ae.i("MicroMsg.FileDownloadManager", "show notification");
      AppMethodBeat.o(88992);
      return;
      paramString1 = h.m(paramString1, false, false);
      if ((paramString1 != null) && (!bu.isNullOrNil(paramString1.field_appName)))
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
    AppMethodBeat.i(224413);
    c.b(paramm);
    AppMethodBeat.o(224413);
  }
  
  public static f cdA()
  {
    AppMethodBeat.i(88974);
    if (psV == null) {
      psV = new f();
    }
    f localf = psV;
    AppMethodBeat.o(88974);
    return localf;
  }
  
  private n cdC()
  {
    AppMethodBeat.i(88977);
    if (this.psQ == null) {
      this.psQ = new i(this.psU);
    }
    n localn = this.psQ;
    AppMethodBeat.o(88977);
    return localn;
  }
  
  private n cdD()
  {
    AppMethodBeat.i(88978);
    if (this.psP == null) {
      this.psP = new k(this.psU);
    }
    n localn = this.psP;
    AppMethodBeat.o(88978);
    return localn;
  }
  
  private n cdG()
  {
    AppMethodBeat.i(88981);
    if (this.psT == null) {
      this.psT = new l(this.psU);
    }
    n localn = this.psT;
    AppMethodBeat.o(88981);
    return localn;
  }
  
  private static void cdH()
  {
    AppMethodBeat.i(88991);
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("off_line_download_ids", 0);
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
    psN.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry1 != null) && (!bu.isNullOrNil((String)localEntry1.getKey()))) {
        try
        {
          long l1 = bu.getLong((String)localEntry1.getKey(), 0L);
          long l2 = ((Long)localEntry1.getValue()).longValue();
          long l3 = System.currentTimeMillis() - l1;
          if ((l3 - l1 > 0L) && (l3 - l1 < 86400000L)) {
            psN.put(Long.valueOf(l1), Long.valueOf(l2));
          }
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.FileDownloadManager", "parse download task failed: " + localException.toString());
          ae.printErrStackTrace("MicroMsg.FileDownloadManager", localException, "", new Object[0]);
        }
      }
    }
    localSharedPreferences.edit().clear();
    localObject = psN.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    AppMethodBeat.o(88991);
  }
  
  static boolean uw(long paramLong)
  {
    AppMethodBeat.i(88993);
    boolean bool = psN.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(88993);
    return bool;
  }
  
  static long ux(long paramLong)
  {
    AppMethodBeat.i(88995);
    Long localLong = (Long)psN.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(88995);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(88995);
    return paramLong;
  }
  
  private void uy(long paramLong)
  {
    AppMethodBeat.i(88998);
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if (locala == null)
    {
      this.psW = false;
      AppMethodBeat.o(88998);
      return;
    }
    a(locala.field_appId, null);
    AppMethodBeat.o(88998);
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(88982);
    ae.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(paramg.ptc), paramg.mAppId });
    if (paramg.ptc == 2)
    {
      l = cdG().a(paramg);
      AppMethodBeat.o(88982);
      return l;
    }
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.kernel.g.ajP();
      if (!com.tencent.mm.kernel.a.aiT())
      {
        ae.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
        l = cdB().a(paramg);
        AppMethodBeat.o(88982);
        return l;
      }
    }
    long l = cdC().a(paramg);
    if (l >= 0L)
    {
      psN.put(Long.valueOf(l), Long.valueOf(0L));
      ak.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ae.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88982);
      return l;
    }
    ae.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    cdD().a(paramg);
    AppMethodBeat.o(88982);
    return l;
  }
  
  public final FileDownloadTaskInfo aaZ(String paramString)
  {
    AppMethodBeat.i(88986);
    paramString = d.aaU(paramString);
    if (paramString != null)
    {
      paramString = uj(paramString.field_downloadId);
      AppMethodBeat.o(88986);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88986);
    return paramString;
  }
  
  public final FileDownloadTaskInfo aba(String paramString)
  {
    AppMethodBeat.i(88987);
    paramString = d.aaX(paramString);
    if (paramString != null)
    {
      paramString = uj(paramString.field_downloadId);
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
    ae.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", new Object[] { paramg.mAppId });
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.kernel.g.ajP();
      if (!com.tencent.mm.kernel.a.aiT())
      {
        l = cdF().a(paramg);
        AppMethodBeat.o(88983);
        return l;
      }
    }
    long l = cdC().a(paramg);
    if (l >= 0L)
    {
      psN.put(Long.valueOf(l), Long.valueOf(0L));
      ak.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ae.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88983);
      return l;
    }
    ae.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    cdD().a(paramg);
    AppMethodBeat.o(88983);
    return l;
  }
  
  public final n cdB()
  {
    AppMethodBeat.i(88976);
    ae.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + kyG);
    if (this.psO != null)
    {
      localObject = this.psO;
      AppMethodBeat.o(88976);
      return localObject;
    }
    Object localObject = new jc();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    int i = ((jc)localObject).dwU.dvO;
    ae.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i)));
    if (i > 0) {
      kyG = i;
    }
    if (kyG == 1) {}
    for (this.psO = cdC();; this.psO = cdE())
    {
      localObject = this.psO;
      AppMethodBeat.o(88976);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.downloader.h.a cdE()
  {
    AppMethodBeat.i(88979);
    if (this.psR == null) {
      this.psR = new com.tencent.mm.plugin.downloader.h.a(this.psU);
    }
    com.tencent.mm.plugin.downloader.h.a locala = this.psR;
    AppMethodBeat.o(88979);
    return locala;
  }
  
  public final b cdF()
  {
    AppMethodBeat.i(88980);
    if (this.psS == null) {
      this.psS = new b(this.psU);
    }
    b localb = this.psS;
    AppMethodBeat.o(88980);
    return localb;
  }
  
  public final boolean h(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(89000);
    if ((parama != null) && (parama.field_downloaderType == 3))
    {
      bool = cdF().n(parama.field_downloadId, true);
      AppMethodBeat.o(89000);
      return bool;
    }
    boolean bool = cdE().n(parama.field_downloadId, true);
    AppMethodBeat.o(89000);
    return bool;
  }
  
  final void o(long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88996);
    ae.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bu.fpN() });
    ak.getContext();
    if (uw(paramLong))
    {
      localObject = uj(paramLong);
      this.psU.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      AppMethodBeat.o(88996);
      return;
    }
    Object localObject = d.ur(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(88996);
      return;
    }
    if (bu.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName))
    {
      String str = r.aNn(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
      if (!bu.isNullOrNil(str))
      {
        ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName = str;
        ae.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, str });
        d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
      }
    }
    final int i = r.aNo(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
    ae.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName, ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, Integer.valueOf(i) });
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88972);
        if ((com.tencent.mm.kernel.g.ajQ().gDv == null) || (com.tencent.mm.kernel.g.ajQ().gDv.hRo == null))
        {
          AppMethodBeat.o(88972);
          return;
        }
        new af(this.psD.field_packageName, i).doScene(com.tencent.mm.kernel.g.ajQ().gDv.hRo, new com.tencent.mm.ak.f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
          {
            AppMethodBeat.i(88971);
            paramAnonymous2n.setHasCallbackToQueue(true);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
            {
              ae.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 28L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { f.1.this.psD.field_packageName, f.1.this.psD.field_filePath, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) }) });
              if ((!bu.isNullOrNil(f.1.this.psD.field_appId)) && (h.fE(f.1.this.psD.field_appId)))
              {
                ae.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", new Object[] { f.1.this.psD.field_appId });
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 24L, 1L, false);
              }
            }
            for (;;)
            {
              ar.f(new f.2(f.this, f.1.this.psD, f.1.this.psJ));
              AppMethodBeat.o(88971);
              return;
              paramAnonymous2String = MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.abv()).getString(f.1.this.psD.field_packageName, "");
              ae.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramAnonymous2String });
              if ((!bu.isNullOrNil(paramAnonymous2String)) && (!j.IS_FLAVOR_RED) && (!j.IS_FLAVOR_PURPLE))
              {
                try
                {
                  com.tencent.mm.d.c.g(new File(o.k(f.1.this.psD.field_filePath, true)), paramAnonymous2String);
                  ae.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 25L, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { f.1.this.psD.field_packageName, f.1.this.psD.field_filePath, paramAnonymous2String }) });
                }
                catch (Exception paramAnonymous2String)
                {
                  ae.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramAnonymous2String.getMessage());
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 27L, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { f.1.this.psD.field_packageName, f.1.this.psD.field_filePath, paramAnonymous2String.getMessage() }) });
                }
              }
              else
              {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 26L, 1L, false);
                com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { f.1.this.psD.field_packageName, f.1.this.psD.field_filePath }) });
              }
            }
          }
        });
        AppMethodBeat.o(88972);
      }
    });
    AppMethodBeat.o(88996);
  }
  
  public final int ui(long paramLong)
  {
    AppMethodBeat.i(88984);
    ae.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (uw(paramLong))
    {
      i = cdC().ui(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = cdF().ui(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    int i = cdB().ui(paramLong);
    AppMethodBeat.o(88984);
    return i;
  }
  
  public final FileDownloadTaskInfo uj(long paramLong)
  {
    AppMethodBeat.i(88985);
    Object localObject1;
    if (uw(paramLong))
    {
      localObject1 = cdC().uj(paramLong);
      AppMethodBeat.o(88985);
      return localObject1;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    Object localObject2;
    if ((locala != null) && (locala.field_status == 3) && (o.fB(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).ptA = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).nyl = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).ptB = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).dvO = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (o.fB(((FileDownloadTaskInfo)localObject2).path)) {
          break label406;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        ((FileDownloadTaskInfo)localObject2).ptC = locala.field_downloadInWifi;
        ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
        ((FileDownloadTaskInfo)localObject2).ptD = locala.field_reserveInWifi;
      }
      ae.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).md5, Long.valueOf(((FileDownloadTaskInfo)localObject2).nyl), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).ptB), Integer.valueOf(((FileDownloadTaskInfo)localObject2).dvO) });
      AppMethodBeat.o(88985);
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = cdF().uj(paramLong);
        break;
      }
      localObject2 = cdB().uj(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).ptB = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).dvO = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      label406:
      if (((FileDownloadTaskInfo)localObject2).status == 6) {
        ((FileDownloadTaskInfo)localObject2).status = 1;
      }
    }
  }
  
  public final boolean uk(long paramLong)
  {
    AppMethodBeat.i(88989);
    ae.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(paramLong)));
    uy(paramLong);
    if (uw(paramLong))
    {
      bool = cdC().uk(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cdF().uk(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    boolean bool = cdB().uk(paramLong);
    AppMethodBeat.o(88989);
    return bool;
  }
  
  public final boolean ul(long paramLong)
  {
    AppMethodBeat.i(88990);
    ae.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    uy(paramLong);
    if (uw(paramLong))
    {
      bool = cdC().ul(paramLong);
      AppMethodBeat.o(88990);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if ((locala != null) && (!locala.field_reserveInWifi) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cdF().n(paramLong, true);
      AppMethodBeat.o(88990);
      return bool;
    }
    boolean bool = cdB().ul(paramLong);
    AppMethodBeat.o(88990);
    return bool;
  }
  
  public final boolean um(long paramLong)
  {
    AppMethodBeat.i(88999);
    ae.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (uw(paramLong))
    {
      AppMethodBeat.o(88999);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cdF().um(paramLong);
      AppMethodBeat.o(88999);
      return bool;
    }
    boolean bool = cdE().um(paramLong);
    AppMethodBeat.o(88999);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */