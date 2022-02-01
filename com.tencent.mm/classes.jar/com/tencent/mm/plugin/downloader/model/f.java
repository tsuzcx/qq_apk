package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ks;
import com.tencent.mm.autogen.a.ll;
import com.tencent.mm.autogen.a.ll.a;
import com.tencent.mm.b.q;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.plugin.downloader.c.d;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private static int rCt;
  private static f xnF;
  private static Map<Long, Long> xnx;
  private n xnA;
  private com.tencent.mm.plugin.downloader.g.a xnB;
  private b xnC;
  private n xnD;
  public c xnE;
  public boolean xnG;
  private n xny;
  private n xnz;
  
  static
  {
    AppMethodBeat.i(89004);
    xnx = new HashMap();
    rCt = 2;
    AppMethodBeat.o(89004);
  }
  
  private f()
  {
    AppMethodBeat.i(88975);
    this.xnG = false;
    duC();
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.kernel.h.baC();
      if (!com.tencent.mm.kernel.b.aZG())
      {
        rCt = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("FileDownloaderType"), 2);
        Log.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(rCt) });
      }
    }
    for (;;)
    {
      this.xnE = new c();
      AppMethodBeat.o(88975);
      return;
      Log.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  public static LinkedList<FileDownloadTaskInfo> U(LinkedList<String> paramLinkedList)
  {
    com.tencent.mm.plugin.downloader.f.a locala = null;
    AppMethodBeat.i(88988);
    Object localObject2 = d.bzH();
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = locala;
      paramLinkedList = new LinkedList();
      if ((localObject1 == null) || (((LinkedList)localObject1).size() <= 0)) {
        break label324;
      }
      localObject1 = ((LinkedList)localObject1).iterator();
      label41:
      if (!((Iterator)localObject1).hasNext()) {
        break label324;
      }
      locala = (com.tencent.mm.plugin.downloader.f.a)((Iterator)localObject1).next();
      localObject2 = new FileDownloadTaskInfo();
      if ((locala.field_status != 3) || (y.ZC(locala.field_filePath))) {
        break label313;
      }
    }
    label313:
    for (((FileDownloadTaskInfo)localObject2).status = 0;; ((FileDownloadTaskInfo)localObject2).status = locala.field_status)
    {
      ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
      ((FileDownloadTaskInfo)localObject2).id = locala.field_downloadId;
      ((FileDownloadTaskInfo)localObject2).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject2).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject2).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject2).xom = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject2).uWn = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject2).xon = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).hMd = locala.field_downloaderType;
      ((FileDownloadTaskInfo)localObject2).xoo = locala.field_downloadInWifi;
      ((FileDownloadTaskInfo)localObject2).xop = locala.field_reserveInWifi;
      paramLinkedList.add(localObject2);
      break label41;
      localObject1 = locala;
      if (Util.isNullOrNil(paramLinkedList)) {
        break;
      }
      localObject2 = ((com.tencent.mm.plugin.downloader.f.b)localObject2).rawQuery(String.format("select * from %s where %s in %s or %s in %s", new Object[] { "FileDownloadInfo", "appId", com.tencent.mm.plugin.downloader.f.b.W(paramLinkedList), "rawAppId", com.tencent.mm.plugin.downloader.f.b.W(paramLinkedList) }), new String[0]);
      localObject1 = locala;
      if (localObject2 == null) {
        break;
      }
      paramLinkedList = new LinkedList();
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          localObject1 = new com.tencent.mm.plugin.downloader.f.a();
          ((com.tencent.mm.plugin.downloader.f.a)localObject1).convertFrom((Cursor)localObject2);
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
    label324:
    AppMethodBeat.o(88988);
    return paramLinkedList;
  }
  
  private void a(String paramString, g paramg)
  {
    AppMethodBeat.i(88997);
    com.tencent.mm.plugin.downloader.f.a locala;
    if (!this.xnG)
    {
      locala = d.amJ(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        ks localks = new ks();
        localks.hMq.appid = paramString;
        localks.publish();
        if (paramg == null) {
          break label114;
        }
        locala.field_autoInstall = paramg.xnN;
        locala.field_showNotification = paramg.rCs;
      }
    }
    for (locala.field_autoDownload = paramg.xnP;; locala.field_autoDownload = false)
    {
      d.e(locala);
      Log.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.xnG = false;
      AppMethodBeat.o(88997);
      return;
      label114:
      locala.field_autoInstall = true;
      locala.field_showNotification = true;
    }
  }
  
  static void a(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(88992);
    f.d locald = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id");
    if (!TextUtils.isEmpty(paramString2))
    {
      locald.l(paramString2);
      locald.m(paramString3);
      locald.eb(17301634);
      locald.aC(true);
      if (paramPendingIntent == null) {
        break label150;
      }
    }
    for (locald.bor = paramPendingIntent;; locald.bor = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().d(locald.DA());
      Log.i("MicroMsg.FileDownloadManager", "show notification");
      AppMethodBeat.o(88992);
      return;
      paramString1 = com.tencent.mm.pluginsdk.model.app.h.s(paramString1, false, false);
      if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.field_appName)))
      {
        locald.l(paramString1.field_appName);
        break;
      }
      locald.l("");
      break;
      label150:
      paramString1 = new Intent();
    }
  }
  
  static void am(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88994);
    xnx.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    AppMethodBeat.o(88994);
  }
  
  public static String amQ(String paramString)
  {
    AppMethodBeat.i(267137);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267137);
      return "";
    }
    String str2 = v.bpY(paramString);
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = v.bpY(q.n(paramString, false));
    }
    AppMethodBeat.o(267137);
    return str1;
  }
  
  private n duB()
  {
    AppMethodBeat.i(88981);
    if (this.xnD == null) {
      this.xnD = new l(this.xnE);
    }
    n localn = this.xnD;
    AppMethodBeat.o(88981);
    return localn;
  }
  
  private static void duC()
  {
    AppMethodBeat.i(88991);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0);
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
    xnx.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry1 != null) && (!Util.isNullOrNil((String)localEntry1.getKey()))) {
        try
        {
          long l1 = Util.getLong((String)localEntry1.getKey(), 0L);
          long l2 = ((Long)localEntry1.getValue()).longValue();
          long l3 = System.currentTimeMillis() - l1;
          if ((l3 - l1 > 0L) && (l3 - l1 < 86400000L)) {
            xnx.put(Long.valueOf(l1), Long.valueOf(l2));
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.FileDownloadManager", "parse download task failed: " + localException.toString());
          Log.printErrStackTrace("MicroMsg.FileDownloadManager", localException, "", new Object[0]);
        }
      }
    }
    localSharedPreferences.edit().clear();
    localObject = xnx.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    AppMethodBeat.o(88991);
  }
  
  public static f duv()
  {
    AppMethodBeat.i(88974);
    if (xnF == null) {
      xnF = new f();
    }
    f localf = xnF;
    AppMethodBeat.o(88974);
    return localf;
  }
  
  private n dux()
  {
    AppMethodBeat.i(88977);
    if (this.xnA == null) {
      this.xnA = new i(this.xnE);
    }
    n localn = this.xnA;
    AppMethodBeat.o(88977);
    return localn;
  }
  
  private n duy()
  {
    AppMethodBeat.i(88978);
    if (this.xnz == null) {
      this.xnz = new k(this.xnE);
    }
    n localn = this.xnz;
    AppMethodBeat.o(88978);
    return localn;
  }
  
  static boolean lf(long paramLong)
  {
    AppMethodBeat.i(88993);
    boolean bool = xnx.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(88993);
    return bool;
  }
  
  static long lg(long paramLong)
  {
    AppMethodBeat.i(88995);
    Long localLong = (Long)xnx.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(88995);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(88995);
    return paramLong;
  }
  
  private void lh(long paramLong)
  {
    AppMethodBeat.i(88998);
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if (locala == null)
    {
      this.xnG = false;
      AppMethodBeat.o(88998);
      return;
    }
    a(locala.field_appId, null);
    AppMethodBeat.o(88998);
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(88982);
    Log.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(paramg.xnM), paramg.mAppId });
    if (paramg.xnM == 2)
    {
      l = duB().a(paramg);
      AppMethodBeat.o(88982);
      return l;
    }
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.kernel.h.baC();
      if (!com.tencent.mm.kernel.b.aZG())
      {
        Log.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
        l = duw().a(paramg);
        AppMethodBeat.o(88982);
        return l;
      }
    }
    long l = dux().a(paramg);
    if (l >= 0L)
    {
      xnx.put(Long.valueOf(l), Long.valueOf(0L));
      MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      Log.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88982);
      return l;
    }
    Log.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    duy().a(paramg);
    AppMethodBeat.o(88982);
    return l;
  }
  
  public final FileDownloadTaskInfo amO(String paramString)
  {
    AppMethodBeat.i(88986);
    paramString = d.amJ(paramString);
    if (paramString != null)
    {
      paramString = kS(paramString.field_downloadId);
      AppMethodBeat.o(88986);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88986);
    return paramString;
  }
  
  public final FileDownloadTaskInfo amP(String paramString)
  {
    AppMethodBeat.i(88987);
    paramString = d.amM(paramString);
    if (paramString != null)
    {
      paramString = kS(paramString.field_downloadId);
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
    Log.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", new Object[] { paramg.mAppId });
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.kernel.h.baC();
      if (!com.tencent.mm.kernel.b.aZG())
      {
        l = duA().a(paramg);
        AppMethodBeat.o(88983);
        return l;
      }
    }
    long l = dux().a(paramg);
    if (l >= 0L)
    {
      xnx.put(Long.valueOf(l), Long.valueOf(0L));
      MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      Log.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88983);
      return l;
    }
    Log.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    duy().a(paramg);
    AppMethodBeat.o(88983);
    return l;
  }
  
  public final b duA()
  {
    AppMethodBeat.i(88980);
    if (this.xnC == null) {
      this.xnC = new b(this.xnE);
    }
    b localb = this.xnC;
    AppMethodBeat.o(88980);
    return localb;
  }
  
  public final n duw()
  {
    AppMethodBeat.i(88976);
    Log.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + rCt);
    if (this.xny != null)
    {
      localObject = this.xny;
      AppMethodBeat.o(88976);
      return localObject;
    }
    Object localObject = new ll();
    ((ll)localObject).publish();
    int i = ((ll)localObject).hNm.hMd;
    Log.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i)));
    if (i > 0) {
      rCt = i;
    }
    if (rCt == 1) {}
    for (this.xny = dux();; this.xny = duz())
    {
      localObject = this.xny;
      AppMethodBeat.o(88976);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.downloader.g.a duz()
  {
    AppMethodBeat.i(88979);
    if (this.xnB == null) {
      this.xnB = new com.tencent.mm.plugin.downloader.g.a(this.xnE);
    }
    com.tencent.mm.plugin.downloader.g.a locala = this.xnB;
    AppMethodBeat.o(88979);
    return locala;
  }
  
  public final boolean h(com.tencent.mm.plugin.downloader.f.a parama)
  {
    AppMethodBeat.i(89000);
    if ((parama != null) && (parama.field_downloaderType == 3))
    {
      bool = duA().t(parama.field_downloadId, true);
      AppMethodBeat.o(89000);
      return bool;
    }
    boolean bool = duz().t(parama.field_downloadId, true);
    AppMethodBeat.o(89000);
    return bool;
  }
  
  public final int kR(long paramLong)
  {
    AppMethodBeat.i(88984);
    Log.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (lf(paramLong))
    {
      i = dux().kR(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = duA().kR(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    int i = duw().kR(paramLong);
    AppMethodBeat.o(88984);
    return i;
  }
  
  public final FileDownloadTaskInfo kS(long paramLong)
  {
    AppMethodBeat.i(88985);
    Object localObject1;
    if (lf(paramLong))
    {
      localObject1 = dux().kS(paramLong);
      AppMethodBeat.o(88985);
      return localObject1;
    }
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    Object localObject2;
    if ((locala != null) && (locala.field_status == 3) && (y.ZC(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).xom = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).uWn = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).xon = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).hMd = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (y.ZC(((FileDownloadTaskInfo)localObject2).path)) {
          break label406;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        ((FileDownloadTaskInfo)localObject2).xoo = locala.field_downloadInWifi;
        ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
        ((FileDownloadTaskInfo)localObject2).xop = locala.field_reserveInWifi;
      }
      Log.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).md5, Long.valueOf(((FileDownloadTaskInfo)localObject2).uWn), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).xon), Integer.valueOf(((FileDownloadTaskInfo)localObject2).hMd) });
      AppMethodBeat.o(88985);
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = duA().kS(paramLong);
        break;
      }
      localObject2 = duw().kS(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).xon = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).hMd = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      label406:
      if (((FileDownloadTaskInfo)localObject2).status == 6) {
        ((FileDownloadTaskInfo)localObject2).status = 1;
      }
    }
  }
  
  public final boolean kT(long paramLong)
  {
    AppMethodBeat.i(88989);
    Log.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(paramLong)));
    lh(paramLong);
    if (lf(paramLong))
    {
      bool = dux().kT(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = duA().kT(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    boolean bool = duw().kT(paramLong);
    AppMethodBeat.o(88989);
    return bool;
  }
  
  public final boolean kU(long paramLong)
  {
    AppMethodBeat.i(88990);
    Log.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    lh(paramLong);
    if (lf(paramLong))
    {
      bool = dux().kU(paramLong);
      AppMethodBeat.o(88990);
      return bool;
    }
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if ((locala != null) && (!locala.field_reserveInWifi) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = duA().t(paramLong, true);
      AppMethodBeat.o(88990);
      return bool;
    }
    boolean bool = duw().kU(paramLong);
    AppMethodBeat.o(88990);
    return bool;
  }
  
  public final boolean kV(long paramLong)
  {
    AppMethodBeat.i(88999);
    Log.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (lf(paramLong))
    {
      AppMethodBeat.o(88999);
      return false;
    }
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = duA().kV(paramLong);
      AppMethodBeat.o(88999);
      return bool;
    }
    boolean bool = duz().kV(paramLong);
    AppMethodBeat.o(88999);
    return bool;
  }
  
  final void u(long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88996);
    Log.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    Object localObject = MMApplicationContext.getContext();
    if (lf(paramLong))
    {
      localObject = kS(paramLong);
      this.xnE.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      AppMethodBeat.o(88996);
      return;
    }
    final com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(88996);
      return;
    }
    if (Util.isNullOrNil(locala.field_packageName))
    {
      str = amQ(locala.field_filePath);
      if (!Util.isNullOrNil(str))
      {
        locala.field_packageName = str;
        Log.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { locala.field_filePath, str });
        d.e(locala);
      }
    }
    String str = locala.field_filePath;
    final int i;
    if (Util.isNullOrNil(str)) {
      i = 0;
    }
    for (;;)
    {
      Log.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { locala.field_packageName, locala.field_filePath, Integer.valueOf(i) });
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(88972);
          Object localObject = com.tencent.mm.kernel.h.baD().mCm;
          if (localObject == null)
          {
            AppMethodBeat.o(88972);
            return;
          }
          localObject = ((s)localObject).oun;
          if (localObject == null)
          {
            AppMethodBeat.o(88972);
            return;
          }
          new ag(locala.field_packageName, i).doScene((com.tencent.mm.network.g)localObject, new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(88971);
              paramAnonymous2p.setHasCallbackToQueue(true);
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                Log.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 28L, 1L, false);
                com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { f.1.this.xno.field_packageName, f.1.this.xno.field_filePath, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) }) });
                if ((!Util.isNullOrNil(f.1.this.xno.field_appId)) && (com.tencent.mm.pluginsdk.model.app.h.iB(f.1.this.xno.field_appId)))
                {
                  Log.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", new Object[] { f.1.this.xno.field_appId });
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(710L, 24L, 1L, false);
                }
              }
              for (;;)
              {
                MMHandlerThread.postToMainThread(new f.2(f.this, f.1.this.xno, f.1.this.xnt));
                AppMethodBeat.o(88971);
                return;
                paramAnonymous2String = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aQe()).getString(f.1.this.xno.field_packageName, "");
                Log.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramAnonymous2String });
                if ((!Util.isNullOrNil(paramAnonymous2String)) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
                  for (;;)
                  {
                    try
                    {
                      paramAnonymous2p = f.amQ(f.1.this.xno.field_filePath);
                      if ((!f.1.this.val$context.getPackageName().equalsIgnoreCase(paramAnonymous2p)) || (com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_appcompat_pkg_sig", "0", false, true).equals("1"))) {
                        break label549;
                      }
                      Log.i("MicroMsg.FileDownloadManager", "Skip writing apkSig for v2 signing, pkg = ".concat(String.valueOf(paramAnonymous2p)));
                      Log.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 25L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { f.1.this.xno.field_packageName, f.1.this.xno.field_filePath, paramAnonymous2String }) });
                    }
                    catch (Exception paramAnonymous2String)
                    {
                      Log.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramAnonymous2String.getMessage());
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 27L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { f.1.this.xno.field_packageName, f.1.this.xno.field_filePath, paramAnonymous2String.getMessage() }) });
                    }
                    break;
                    label549:
                    com.tencent.mm.d.c.h(new File(y.n(f.1.this.xno.field_filePath, true)), paramAnonymous2String);
                  }
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 26L, 1L, false);
                com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { f.1.this.xno.field_packageName, f.1.this.xno.field_filePath }) });
              }
            }
          });
          AppMethodBeat.o(88972);
        }
      });
      AppMethodBeat.o(88996);
      return;
      int j = v.bpZ(str);
      i = j;
      if (j == 0) {
        i = v.bpZ(q.n(str, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */