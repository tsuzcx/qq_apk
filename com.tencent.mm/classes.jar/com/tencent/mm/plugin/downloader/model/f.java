package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.jq;
import com.tencent.mm.f.a.kh;
import com.tencent.mm.f.a.kh.a;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.plugin.downloader.c.d;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private static int oyB;
  private static Map<Long, Long> uhr;
  private static f uhz;
  public boolean uhA;
  private n uhs;
  private n uht;
  private n uhu;
  private com.tencent.mm.plugin.downloader.h.a uhv;
  private b uhw;
  private n uhx;
  public c uhy;
  
  static
  {
    AppMethodBeat.i(89004);
    uhr = new HashMap();
    oyB = 2;
    AppMethodBeat.o(89004);
  }
  
  private f()
  {
    AppMethodBeat.i(88975);
    this.uhA = false;
    cQg();
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      com.tencent.mm.kernel.h.aHE();
      if (!com.tencent.mm.kernel.b.aGE())
      {
        oyB = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("FileDownloaderType"), 2);
        Log.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(oyB) });
      }
    }
    for (;;)
    {
      this.uhy = new c();
      AppMethodBeat.o(88975);
      return;
      Log.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  static boolean IK(long paramLong)
  {
    AppMethodBeat.i(88993);
    boolean bool = uhr.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(88993);
    return bool;
  }
  
  static long IL(long paramLong)
  {
    AppMethodBeat.i(88995);
    Long localLong = (Long)uhr.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(88995);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(88995);
    return paramLong;
  }
  
  private void IM(long paramLong)
  {
    AppMethodBeat.i(88998);
    com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    if (locala == null)
    {
      this.uhA = false;
      AppMethodBeat.o(88998);
      return;
    }
    a(locala.field_appId, null);
    AppMethodBeat.o(88998);
  }
  
  static void P(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88994);
    uhr.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    AppMethodBeat.o(88994);
  }
  
  public static LinkedList<FileDownloadTaskInfo> S(LinkedList<String> paramLinkedList)
  {
    com.tencent.mm.plugin.downloader.g.a locala = null;
    AppMethodBeat.i(88988);
    Object localObject2 = d.bbS();
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
      if ((locala.field_status != 3) || (u.agG(locala.field_filePath))) {
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
      ((FileDownloadTaskInfo)localObject2).uih = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject2).rKZ = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject2).uii = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).fGH = locala.field_downloaderType;
      ((FileDownloadTaskInfo)localObject2).uij = locala.field_downloadInWifi;
      ((FileDownloadTaskInfo)localObject2).uik = locala.field_reserveInWifi;
      paramLinkedList.add(localObject2);
      break label41;
      localObject1 = locala;
      if (Util.isNullOrNil(paramLinkedList)) {
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
    AppMethodBeat.i(292888);
    c.a(paramm);
    AppMethodBeat.o(292888);
  }
  
  private void a(String paramString, g paramg)
  {
    AppMethodBeat.i(88997);
    com.tencent.mm.plugin.downloader.g.a locala;
    if (!this.uhA)
    {
      locala = d.asU(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        jq localjq = new jq();
        localjq.fGT.appid = paramString;
        EventCenter.instance.publish(localjq);
        if (paramg == null) {
          break label117;
        }
        locala.field_autoInstall = paramg.uhH;
        locala.field_showNotification = paramg.oyA;
      }
    }
    for (locala.field_autoDownload = paramg.uhJ;; locala.field_autoDownload = false)
    {
      d.e(locala);
      Log.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.uhA = false;
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
    e.d locald = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id");
    if (!TextUtils.isEmpty(paramString2))
    {
      locald.k(paramString2);
      locald.l(paramString3);
      locald.bn(17301634);
      locald.W(true);
      if (paramPendingIntent == null) {
        break label150;
      }
    }
    for (locald.Ip = paramPendingIntent;; locald.Ip = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(locald.gr());
      Log.i("MicroMsg.FileDownloadManager", "show notification");
      AppMethodBeat.o(88992);
      return;
      paramString1 = com.tencent.mm.pluginsdk.model.app.h.o(paramString1, false, false);
      if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.field_appName)))
      {
        locald.k(paramString1.field_appName);
        break;
      }
      locald.k("");
      break;
      label150:
      paramString1 = new Intent();
    }
  }
  
  public static String atb(String paramString)
  {
    AppMethodBeat.i(219540);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(219540);
      return "";
    }
    String str2 = r.bqj(paramString);
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = r.bqj(com.tencent.mm.b.q.n(paramString, false));
    }
    AppMethodBeat.o(219540);
    return str1;
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(292889);
    c.b(paramm);
    AppMethodBeat.o(292889);
  }
  
  public static f cPZ()
  {
    AppMethodBeat.i(88974);
    if (uhz == null) {
      uhz = new f();
    }
    f localf = uhz;
    AppMethodBeat.o(88974);
    return localf;
  }
  
  private n cQb()
  {
    AppMethodBeat.i(88977);
    if (this.uhu == null) {
      this.uhu = new i(this.uhy);
    }
    n localn = this.uhu;
    AppMethodBeat.o(88977);
    return localn;
  }
  
  private n cQc()
  {
    AppMethodBeat.i(88978);
    if (this.uht == null) {
      this.uht = new k(this.uhy);
    }
    n localn = this.uht;
    AppMethodBeat.o(88978);
    return localn;
  }
  
  private n cQf()
  {
    AppMethodBeat.i(88981);
    if (this.uhx == null) {
      this.uhx = new l(this.uhy);
    }
    n localn = this.uhx;
    AppMethodBeat.o(88981);
    return localn;
  }
  
  private static void cQg()
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
    uhr.clear();
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
            uhr.put(Long.valueOf(l1), Long.valueOf(l2));
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
    localObject = uhr.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    AppMethodBeat.o(88991);
  }
  
  public final boolean IA(long paramLong)
  {
    AppMethodBeat.i(88999);
    Log.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (IK(paramLong))
    {
      AppMethodBeat.o(88999);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cQe().IA(paramLong);
      AppMethodBeat.o(88999);
      return bool;
    }
    boolean bool = cQd().IA(paramLong);
    AppMethodBeat.o(88999);
    return bool;
  }
  
  public final int Iw(long paramLong)
  {
    AppMethodBeat.i(88984);
    Log.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (IK(paramLong))
    {
      i = cQb().Iw(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = cQe().Iw(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    int i = cQa().Iw(paramLong);
    AppMethodBeat.o(88984);
    return i;
  }
  
  public final FileDownloadTaskInfo Ix(long paramLong)
  {
    AppMethodBeat.i(88985);
    Object localObject1;
    if (IK(paramLong))
    {
      localObject1 = cQb().Ix(paramLong);
      AppMethodBeat.o(88985);
      return localObject1;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    Object localObject2;
    if ((locala != null) && (locala.field_status == 3) && (u.agG(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).uih = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).rKZ = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).uii = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).fGH = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (u.agG(((FileDownloadTaskInfo)localObject2).path)) {
          break label406;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        ((FileDownloadTaskInfo)localObject2).uij = locala.field_downloadInWifi;
        ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
        ((FileDownloadTaskInfo)localObject2).uik = locala.field_reserveInWifi;
      }
      Log.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).md5, Long.valueOf(((FileDownloadTaskInfo)localObject2).rKZ), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).uii), Integer.valueOf(((FileDownloadTaskInfo)localObject2).fGH) });
      AppMethodBeat.o(88985);
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = cQe().Ix(paramLong);
        break;
      }
      localObject2 = cQa().Ix(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).uii = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).fGH = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      label406:
      if (((FileDownloadTaskInfo)localObject2).status == 6) {
        ((FileDownloadTaskInfo)localObject2).status = 1;
      }
    }
  }
  
  public final boolean Iy(long paramLong)
  {
    AppMethodBeat.i(88989);
    Log.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(paramLong)));
    IM(paramLong);
    if (IK(paramLong))
    {
      bool = cQb().Iy(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cQe().Iy(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    boolean bool = cQa().Iy(paramLong);
    AppMethodBeat.o(88989);
    return bool;
  }
  
  public final boolean Iz(long paramLong)
  {
    AppMethodBeat.i(88990);
    Log.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    IM(paramLong);
    if (IK(paramLong))
    {
      bool = cQb().Iz(paramLong);
      AppMethodBeat.o(88990);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    if ((locala != null) && (!locala.field_reserveInWifi) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cQe().n(paramLong, true);
      AppMethodBeat.o(88990);
      return bool;
    }
    boolean bool = cQa().Iz(paramLong);
    AppMethodBeat.o(88990);
    return bool;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(88982);
    Log.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(paramg.uhG), paramg.mAppId });
    if (paramg.uhG == 2)
    {
      l = cQf().a(paramg);
      AppMethodBeat.o(88982);
      return l;
    }
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      com.tencent.mm.kernel.h.aHE();
      if (!com.tencent.mm.kernel.b.aGE())
      {
        Log.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
        l = cQa().a(paramg);
        AppMethodBeat.o(88982);
        return l;
      }
    }
    long l = cQb().a(paramg);
    if (l >= 0L)
    {
      uhr.put(Long.valueOf(l), Long.valueOf(0L));
      MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      Log.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88982);
      return l;
    }
    Log.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    cQc().a(paramg);
    AppMethodBeat.o(88982);
    return l;
  }
  
  public final FileDownloadTaskInfo asZ(String paramString)
  {
    AppMethodBeat.i(88986);
    paramString = d.asU(paramString);
    if (paramString != null)
    {
      paramString = Ix(paramString.field_downloadId);
      AppMethodBeat.o(88986);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88986);
    return paramString;
  }
  
  public final FileDownloadTaskInfo ata(String paramString)
  {
    AppMethodBeat.i(88987);
    paramString = d.asX(paramString);
    if (paramString != null)
    {
      paramString = Ix(paramString.field_downloadId);
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
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      com.tencent.mm.kernel.h.aHE();
      if (!com.tencent.mm.kernel.b.aGE())
      {
        l = cQe().a(paramg);
        AppMethodBeat.o(88983);
        return l;
      }
    }
    long l = cQb().a(paramg);
    if (l >= 0L)
    {
      uhr.put(Long.valueOf(l), Long.valueOf(0L));
      MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      Log.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88983);
      return l;
    }
    Log.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    cQc().a(paramg);
    AppMethodBeat.o(88983);
    return l;
  }
  
  public final n cQa()
  {
    AppMethodBeat.i(88976);
    Log.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + oyB);
    if (this.uhs != null)
    {
      localObject = this.uhs;
      AppMethodBeat.o(88976);
      return localObject;
    }
    Object localObject = new kh();
    EventCenter.instance.publish((IEvent)localObject);
    int i = ((kh)localObject).fHM.fGH;
    Log.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i)));
    if (i > 0) {
      oyB = i;
    }
    if (oyB == 1) {}
    for (this.uhs = cQb();; this.uhs = cQd())
    {
      localObject = this.uhs;
      AppMethodBeat.o(88976);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.downloader.h.a cQd()
  {
    AppMethodBeat.i(88979);
    if (this.uhv == null) {
      this.uhv = new com.tencent.mm.plugin.downloader.h.a(this.uhy);
    }
    com.tencent.mm.plugin.downloader.h.a locala = this.uhv;
    AppMethodBeat.o(88979);
    return locala;
  }
  
  public final b cQe()
  {
    AppMethodBeat.i(88980);
    if (this.uhw == null) {
      this.uhw = new b(this.uhy);
    }
    b localb = this.uhw;
    AppMethodBeat.o(88980);
    return localb;
  }
  
  public final boolean h(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(89000);
    if ((parama != null) && (parama.field_downloaderType == 3))
    {
      bool = cQe().n(parama.field_downloadId, true);
      AppMethodBeat.o(89000);
      return bool;
    }
    boolean bool = cQd().n(parama.field_downloadId, true);
    AppMethodBeat.o(89000);
    return bool;
  }
  
  final void o(long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(88996);
    Log.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    MMApplicationContext.getContext();
    if (IK(paramLong))
    {
      localObject = Ix(paramLong);
      this.uhy.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      AppMethodBeat.o(88996);
      return;
    }
    Object localObject = d.IF(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(88996);
      return;
    }
    if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName))
    {
      str = atb(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
      if (!Util.isNullOrNil(str))
      {
        ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName = str;
        Log.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, str });
        d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
      }
    }
    String str = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath;
    final int i;
    if (Util.isNullOrNil(str)) {
      i = 0;
    }
    for (;;)
    {
      Log.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName, ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, Integer.valueOf(i) });
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(88972);
          Object localObject = com.tencent.mm.kernel.h.aHF().kcd;
          if (localObject == null)
          {
            AppMethodBeat.o(88972);
            return;
          }
          localObject = ((t)localObject).lCD;
          if (localObject == null)
          {
            AppMethodBeat.o(88972);
            return;
          }
          new af(this.uhi.field_packageName, i).doScene((com.tencent.mm.network.g)localObject, new com.tencent.mm.an.i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.q paramAnonymous2q)
            {
              AppMethodBeat.i(88971);
              paramAnonymous2q.setHasCallbackToQueue(true);
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                Log.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 28L, 1L, false);
                com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { f.1.this.uhi.field_packageName, f.1.this.uhi.field_filePath, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) }) });
                if ((!Util.isNullOrNil(f.1.this.uhi.field_appId)) && (com.tencent.mm.pluginsdk.model.app.h.ha(f.1.this.uhi.field_appId)))
                {
                  Log.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", new Object[] { f.1.this.uhi.field_appId });
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 24L, 1L, false);
                }
              }
              for (;;)
              {
                MMHandlerThread.postToMainThread(new f.2(f.this, f.1.this.uhi, f.1.this.uhn));
                AppMethodBeat.o(88971);
                return;
                paramAnonymous2String = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.avK()).getString(f.1.this.uhi.field_packageName, "");
                Log.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramAnonymous2String });
                if ((!Util.isNullOrNil(paramAnonymous2String)) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE))
                {
                  try
                  {
                    com.tencent.mm.d.c.h(new File(u.n(f.1.this.uhi.field_filePath, true)), paramAnonymous2String);
                    Log.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 25L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { f.1.this.uhi.field_packageName, f.1.this.uhi.field_filePath, paramAnonymous2String }) });
                  }
                  catch (Exception paramAnonymous2String)
                  {
                    Log.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramAnonymous2String.getMessage());
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 27L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { f.1.this.uhi.field_packageName, f.1.this.uhi.field_filePath, paramAnonymous2String.getMessage() }) });
                  }
                }
                else
                {
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 26L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { f.1.this.uhi.field_packageName, f.1.this.uhi.field_filePath }) });
                }
              }
            }
          });
          AppMethodBeat.o(88972);
        }
      });
      AppMethodBeat.o(88996);
      return;
      int j = r.bqk(str);
      i = j;
      if (j == 0) {
        i = r.bqk(com.tencent.mm.b.q.n(str, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */