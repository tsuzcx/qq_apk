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
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.it.a;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aq;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private static int kaV;
  private static Map<Long, Long> oIC;
  private static f oIK;
  private n oID;
  private n oIE;
  private n oIF;
  private com.tencent.mm.plugin.downloader.h.a oIG;
  private b oIH;
  private n oII;
  public c oIJ;
  public boolean oIL;
  
  static
  {
    AppMethodBeat.i(89004);
    oIC = new HashMap();
    kaV = 2;
    AppMethodBeat.o(89004);
  }
  
  private f()
  {
    AppMethodBeat.i(88975);
    this.oIL = false;
    bXQ();
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agP();
      if (!com.tencent.mm.kernel.a.afS())
      {
        kaV = bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("FileDownloaderType"), 2);
        ac.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(kaV) });
      }
    }
    for (;;)
    {
      this.oIJ = new c();
      AppMethodBeat.o(88975);
      return;
      ac.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  static void K(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88994);
    oIC.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    ai.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    AppMethodBeat.o(88994);
  }
  
  public static LinkedList<FileDownloadTaskInfo> R(LinkedList<String> paramLinkedList)
  {
    com.tencent.mm.plugin.downloader.g.a locala = null;
    AppMethodBeat.i(88988);
    Object localObject2 = d.awH();
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
      if ((locala.field_status != 3) || (com.tencent.mm.vfs.i.eA(locala.field_filePath))) {
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
      ((FileDownloadTaskInfo)localObject2).oJm = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject2).mSs = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject2).oJn = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).diX = locala.field_downloaderType;
      ((FileDownloadTaskInfo)localObject2).oJo = locala.field_downloadInWifi;
      ((FileDownloadTaskInfo)localObject2).oJp = locala.field_reserveInWifi;
      paramLinkedList.add(localObject2);
      break label41;
      localObject1 = locala;
      if (bs.gY(paramLinkedList)) {
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
    if (!this.oIL)
    {
      locala = d.Ww(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        ic localic = new ic();
        localic.dji.djj = paramString;
        com.tencent.mm.sdk.b.a.GpY.l(localic);
        if (paramg == null) {
          break label117;
        }
        locala.field_autoInstall = paramg.oIS;
        locala.field_showNotification = paramg.kaU;
      }
    }
    for (locala.field_autoDownload = paramg.oIU;; locala.field_autoDownload = false)
    {
      d.e(locala);
      ac.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.oIL = false;
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
    s.c localc = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id");
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
    for (localc.Fu = paramPendingIntent;; localc.Fu = PendingIntent.getActivity(ai.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
      ac.i("MicroMsg.FileDownloadManager", "show notification");
      AppMethodBeat.o(88992);
      return;
      paramString1 = com.tencent.mm.pluginsdk.model.app.h.k(paramString1, false, false);
      if ((paramString1 != null) && (!bs.isNullOrNil(paramString1.field_appName)))
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
  
  public static f bXJ()
  {
    AppMethodBeat.i(88974);
    if (oIK == null) {
      oIK = new f();
    }
    f localf = oIK;
    AppMethodBeat.o(88974);
    return localf;
  }
  
  private n bXL()
  {
    AppMethodBeat.i(88977);
    if (this.oIF == null) {
      this.oIF = new i(this.oIJ);
    }
    n localn = this.oIF;
    AppMethodBeat.o(88977);
    return localn;
  }
  
  private n bXM()
  {
    AppMethodBeat.i(88978);
    if (this.oIE == null) {
      this.oIE = new k(this.oIJ);
    }
    n localn = this.oIE;
    AppMethodBeat.o(88978);
    return localn;
  }
  
  private n bXP()
  {
    AppMethodBeat.i(88981);
    if (this.oII == null) {
      this.oII = new l(this.oIJ);
    }
    n localn = this.oII;
    AppMethodBeat.o(88981);
    return localn;
  }
  
  private static void bXQ()
  {
    AppMethodBeat.i(88991);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("off_line_download_ids", 0);
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
    oIC.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry1 != null) && (!bs.isNullOrNil((String)localEntry1.getKey()))) {
        try
        {
          long l1 = bs.getLong((String)localEntry1.getKey(), 0L);
          long l2 = ((Long)localEntry1.getValue()).longValue();
          long l3 = System.currentTimeMillis() - l1;
          if ((l3 - l1 > 0L) && (l3 - l1 < 86400000L)) {
            oIC.put(Long.valueOf(l1), Long.valueOf(l2));
          }
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.FileDownloadManager", "parse download task failed: " + localException.toString());
          ac.printErrStackTrace("MicroMsg.FileDownloadManager", localException, "", new Object[0]);
        }
      }
    }
    localSharedPreferences.edit().clear();
    localObject = oIC.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    AppMethodBeat.o(88991);
  }
  
  static boolean sh(long paramLong)
  {
    AppMethodBeat.i(88993);
    boolean bool = oIC.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(88993);
    return bool;
  }
  
  static long si(long paramLong)
  {
    AppMethodBeat.i(88995);
    Long localLong = (Long)oIC.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(88995);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(88995);
    return paramLong;
  }
  
  private void sj(long paramLong)
  {
    AppMethodBeat.i(88998);
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    if (locala == null)
    {
      this.oIL = false;
      AppMethodBeat.o(88998);
      return;
    }
    a(locala.field_appId, null);
    AppMethodBeat.o(88998);
  }
  
  public final FileDownloadTaskInfo WB(String paramString)
  {
    AppMethodBeat.i(88986);
    paramString = d.Ww(paramString);
    if (paramString != null)
    {
      paramString = rT(paramString.field_downloadId);
      AppMethodBeat.o(88986);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88986);
    return paramString;
  }
  
  public final FileDownloadTaskInfo WC(String paramString)
  {
    AppMethodBeat.i(88987);
    paramString = d.Wz(paramString);
    if (paramString != null)
    {
      paramString = rT(paramString.field_downloadId);
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
    ac.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(paramg.oIR), paramg.mAppId });
    if (paramg.oIR == 2)
    {
      l = bXP().a(paramg);
      AppMethodBeat.o(88982);
      return l;
    }
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agP();
      if (!com.tencent.mm.kernel.a.afS())
      {
        ac.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
        l = bXK().a(paramg);
        AppMethodBeat.o(88982);
        return l;
      }
    }
    long l = bXL().a(paramg);
    if (l >= 0L)
    {
      oIC.put(Long.valueOf(l), Long.valueOf(0L));
      ai.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ac.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88982);
      return l;
    }
    ac.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    bXM().a(paramg);
    AppMethodBeat.o(88982);
    return l;
  }
  
  public final long b(g paramg)
  {
    AppMethodBeat.i(88983);
    ac.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", new Object[] { paramg.mAppId });
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agP();
      if (!com.tencent.mm.kernel.a.afS())
      {
        l = bXO().a(paramg);
        AppMethodBeat.o(88983);
        return l;
      }
    }
    long l = bXL().a(paramg);
    if (l >= 0L)
    {
      oIC.put(Long.valueOf(l), Long.valueOf(0L));
      ai.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ac.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88983);
      return l;
    }
    ac.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    bXM().a(paramg);
    AppMethodBeat.o(88983);
    return l;
  }
  
  public final n bXK()
  {
    AppMethodBeat.i(88976);
    ac.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + kaV);
    if (this.oID != null)
    {
      localObject = this.oID;
      AppMethodBeat.o(88976);
      return localObject;
    }
    Object localObject = new it();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    int i = ((it)localObject).dkc.diX;
    ac.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i)));
    if (i > 0) {
      kaV = i;
    }
    if (kaV == 1) {}
    for (this.oID = bXL();; this.oID = bXN())
    {
      localObject = this.oID;
      AppMethodBeat.o(88976);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.downloader.h.a bXN()
  {
    AppMethodBeat.i(88979);
    if (this.oIG == null) {
      this.oIG = new com.tencent.mm.plugin.downloader.h.a(this.oIJ);
    }
    com.tencent.mm.plugin.downloader.h.a locala = this.oIG;
    AppMethodBeat.o(88979);
    return locala;
  }
  
  public final b bXO()
  {
    AppMethodBeat.i(88980);
    if (this.oIH == null) {
      this.oIH = new b(this.oIJ);
    }
    b localb = this.oIH;
    AppMethodBeat.o(88980);
    return localb;
  }
  
  public final boolean h(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(89000);
    if ((parama != null) && (parama.field_downloaderType == 3))
    {
      bool = bXO().n(parama.field_downloadId, true);
      AppMethodBeat.o(89000);
      return bool;
    }
    boolean bool = bXN().n(parama.field_downloadId, true);
    AppMethodBeat.o(89000);
    return bool;
  }
  
  final void o(long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88996);
    ac.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bs.eWi() });
    ai.getContext();
    if (sh(paramLong))
    {
      localObject = rT(paramLong);
      this.oIJ.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      AppMethodBeat.o(88996);
      return;
    }
    Object localObject = d.sc(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(88996);
      return;
    }
    if (bs.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName))
    {
      String str = r.aGr(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
      if (!bs.isNullOrNil(str))
      {
        ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName = str;
        ac.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, str });
        d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
      }
    }
    final int i = r.aGs(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
    ac.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName, ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, Integer.valueOf(i) });
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(88972);
        if ((com.tencent.mm.kernel.g.agQ().ghe == null) || (com.tencent.mm.kernel.g.agQ().ghe.hwg == null))
        {
          AppMethodBeat.o(88972);
          return;
        }
        new ae(this.oIu.field_packageName, i).doScene(com.tencent.mm.kernel.g.agQ().ghe.hwg, new com.tencent.mm.ak.g()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
          {
            AppMethodBeat.i(88971);
            paramAnonymous2n.setHasCallbackToQueue(true);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
            {
              ac.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 28L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { f.1.this.oIu.field_packageName, f.1.this.oIu.field_filePath, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) }) });
              if ((!bs.isNullOrNil(f.1.this.oIu.field_appId)) && (com.tencent.mm.pluginsdk.model.app.h.eD(f.1.this.oIu.field_appId)))
              {
                ac.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", new Object[] { f.1.this.oIu.field_appId });
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(710L, 24L, 1L, false);
              }
            }
            for (;;)
            {
              ap.f(new f.2(f.this, f.1.this.oIu, f.1.this.oIA));
              AppMethodBeat.o(88971);
              return;
              paramAnonymous2String = MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.YK()).getString(f.1.this.oIu.field_packageName, "");
              ac.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramAnonymous2String });
              if ((!bs.isNullOrNil(paramAnonymous2String)) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
              {
                try
                {
                  com.tencent.mm.d.c.g(new File(com.tencent.mm.vfs.i.k(f.1.this.oIu.field_filePath, true)), paramAnonymous2String);
                  ac.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 25L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { f.1.this.oIu.field_packageName, f.1.this.oIu.field_filePath, paramAnonymous2String }) });
                }
                catch (Exception paramAnonymous2String)
                {
                  ac.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramAnonymous2String.getMessage());
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 27L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { f.1.this.oIu.field_packageName, f.1.this.oIu.field_filePath, paramAnonymous2String.getMessage() }) });
                }
              }
              else
              {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 26L, 1L, false);
                com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { f.1.this.oIu.field_packageName, f.1.this.oIu.field_filePath }) });
              }
            }
          }
        });
        AppMethodBeat.o(88972);
      }
    });
    AppMethodBeat.o(88996);
  }
  
  public final int rS(long paramLong)
  {
    AppMethodBeat.i(88984);
    ac.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (sh(paramLong))
    {
      i = bXL().rS(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = bXO().rS(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    int i = bXK().rS(paramLong);
    AppMethodBeat.o(88984);
    return i;
  }
  
  public final FileDownloadTaskInfo rT(long paramLong)
  {
    AppMethodBeat.i(88985);
    Object localObject1;
    if (sh(paramLong))
    {
      localObject1 = bXL().rT(paramLong);
      AppMethodBeat.o(88985);
      return localObject1;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    Object localObject2;
    if ((locala != null) && (locala.field_status == 3) && (com.tencent.mm.vfs.i.eA(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).oJm = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).mSs = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).oJn = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).diX = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (com.tencent.mm.vfs.i.eA(((FileDownloadTaskInfo)localObject2).path)) {
          break label406;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        ((FileDownloadTaskInfo)localObject2).oJo = locala.field_downloadInWifi;
        ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
        ((FileDownloadTaskInfo)localObject2).oJp = locala.field_reserveInWifi;
      }
      ac.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).md5, Long.valueOf(((FileDownloadTaskInfo)localObject2).mSs), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).oJn), Integer.valueOf(((FileDownloadTaskInfo)localObject2).diX) });
      AppMethodBeat.o(88985);
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = bXO().rT(paramLong);
        break;
      }
      localObject2 = bXK().rT(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).oJn = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).diX = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      label406:
      if (((FileDownloadTaskInfo)localObject2).status == 6) {
        ((FileDownloadTaskInfo)localObject2).status = 1;
      }
    }
  }
  
  public final boolean rU(long paramLong)
  {
    AppMethodBeat.i(88989);
    ac.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(paramLong)));
    sj(paramLong);
    if (sh(paramLong))
    {
      bool = bXL().rU(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bXO().rU(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    boolean bool = bXK().rU(paramLong);
    AppMethodBeat.o(88989);
    return bool;
  }
  
  public final boolean rV(long paramLong)
  {
    AppMethodBeat.i(88990);
    ac.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    sj(paramLong);
    if (sh(paramLong))
    {
      bool = bXL().rV(paramLong);
      AppMethodBeat.o(88990);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    if ((locala != null) && (!locala.field_reserveInWifi) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bXO().n(paramLong, true);
      AppMethodBeat.o(88990);
      return bool;
    }
    boolean bool = bXK().rV(paramLong);
    AppMethodBeat.o(88990);
    return bool;
  }
  
  public final boolean rW(long paramLong)
  {
    AppMethodBeat.i(88999);
    ac.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (sh(paramLong))
    {
      AppMethodBeat.o(88999);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bXO().rW(paramLong);
      AppMethodBeat.o(88999);
      return bool;
    }
    boolean bool = bXN().rW(paramLong);
    AppMethodBeat.o(88999);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */