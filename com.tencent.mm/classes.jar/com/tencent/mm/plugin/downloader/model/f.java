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
import com.tencent.mm.b.q;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.jr.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private static int lCZ;
  private static Map<Long, Long> qIr;
  private static f qIz;
  public boolean qIA;
  private n qIs;
  private n qIt;
  private n qIu;
  private com.tencent.mm.plugin.downloader.h.a qIv;
  private b qIw;
  private n qIx;
  public c qIy;
  
  static
  {
    AppMethodBeat.i(89004);
    qIr = new HashMap();
    lCZ = 2;
    AppMethodBeat.o(89004);
  }
  
  private f()
  {
    AppMethodBeat.i(88975);
    this.qIA = false;
    cBC();
    if (com.tencent.mm.kernel.g.aAf().azp())
    {
      com.tencent.mm.kernel.g.aAf();
      if (!com.tencent.mm.kernel.a.azj())
      {
        lCZ = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("FileDownloaderType"), 2);
        Log.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(lCZ) });
      }
    }
    for (;;)
    {
      this.qIy = new c();
      AppMethodBeat.o(88975);
      return;
      Log.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  static boolean CB(long paramLong)
  {
    AppMethodBeat.i(88993);
    boolean bool = qIr.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(88993);
    return bool;
  }
  
  static long CC(long paramLong)
  {
    AppMethodBeat.i(88995);
    Long localLong = (Long)qIr.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(88995);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(88995);
    return paramLong;
  }
  
  private void CD(long paramLong)
  {
    AppMethodBeat.i(88998);
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if (locala == null)
    {
      this.qIA = false;
      AppMethodBeat.o(88998);
      return;
    }
    a(locala.field_appId, null);
    AppMethodBeat.o(88998);
  }
  
  static void N(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88994);
    qIr.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    AppMethodBeat.o(88994);
  }
  
  public static LinkedList<FileDownloadTaskInfo> U(LinkedList<String> paramLinkedList)
  {
    com.tencent.mm.plugin.downloader.g.a locala = null;
    AppMethodBeat.i(88988);
    Object localObject2 = d.aSU();
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
      if ((locala.field_status != 3) || (s.YS(locala.field_filePath))) {
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
      ((FileDownloadTaskInfo)localObject2).qJe = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject2).oJj = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject2).qJf = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).dNv = locala.field_downloaderType;
      ((FileDownloadTaskInfo)localObject2).qJg = locala.field_downloadInWifi;
      ((FileDownloadTaskInfo)localObject2).qJh = locala.field_reserveInWifi;
      paramLinkedList.add(localObject2);
      break label41;
      localObject1 = locala;
      if (Util.isNullOrNil(paramLinkedList)) {
        break;
      }
      localObject2 = ((com.tencent.mm.plugin.downloader.g.b)localObject2).rawQuery(String.format("select * from %s where %s in %s or %s in %s", new Object[] { "FileDownloadInfo", "appId", com.tencent.mm.plugin.downloader.g.b.W(paramLinkedList), "rawAppId", com.tencent.mm.plugin.downloader.g.b.W(paramLinkedList) }), new String[0]);
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
    AppMethodBeat.i(258694);
    c.a(paramm);
    AppMethodBeat.o(258694);
  }
  
  private void a(String paramString, g paramg)
  {
    AppMethodBeat.i(88997);
    com.tencent.mm.plugin.downloader.g.a locala;
    if (!this.qIA)
    {
      locala = d.alb(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        ja localja = new ja();
        localja.dNH.dNI = paramString;
        EventCenter.instance.publish(localja);
        if (paramg == null) {
          break label117;
        }
        locala.field_autoInstall = paramg.qIH;
        locala.field_showNotification = paramg.lCY;
      }
    }
    for (locala.field_autoDownload = paramg.qIJ;; locala.field_autoDownload = false)
    {
      d.e(locala);
      Log.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.qIA = false;
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
    s.c localc = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id");
    if (!TextUtils.isEmpty(paramString2))
    {
      localc.f(paramString2);
      localc.g(paramString3);
      localc.as(17301634);
      localc.E(true);
      if (paramPendingIntent == null) {
        break label150;
      }
    }
    for (localc.Hv = paramPendingIntent;; localc.Hv = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
      Log.i("MicroMsg.FileDownloadManager", "show notification");
      AppMethodBeat.o(88992);
      return;
      paramString1 = h.o(paramString1, false, false);
      if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.field_appName)))
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
  
  public static String ali(String paramString)
  {
    AppMethodBeat.i(192260);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(192260);
      return "";
    }
    String str2 = r.bdN(paramString);
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = r.bdN(q.k(paramString, false));
    }
    AppMethodBeat.o(192260);
    return str1;
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(258695);
    c.b(paramm);
    AppMethodBeat.o(258695);
  }
  
  private n cBB()
  {
    AppMethodBeat.i(88981);
    if (this.qIx == null) {
      this.qIx = new l(this.qIy);
    }
    n localn = this.qIx;
    AppMethodBeat.o(88981);
    return localn;
  }
  
  private static void cBC()
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
    qIr.clear();
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
            qIr.put(Long.valueOf(l1), Long.valueOf(l2));
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
    localObject = qIr.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    AppMethodBeat.o(88991);
  }
  
  public static f cBv()
  {
    AppMethodBeat.i(88974);
    if (qIz == null) {
      qIz = new f();
    }
    f localf = qIz;
    AppMethodBeat.o(88974);
    return localf;
  }
  
  private n cBx()
  {
    AppMethodBeat.i(88977);
    if (this.qIu == null) {
      this.qIu = new i(this.qIy);
    }
    n localn = this.qIu;
    AppMethodBeat.o(88977);
    return localn;
  }
  
  private n cBy()
  {
    AppMethodBeat.i(88978);
    if (this.qIt == null) {
      this.qIt = new k(this.qIy);
    }
    n localn = this.qIt;
    AppMethodBeat.o(88978);
    return localn;
  }
  
  public final int Cn(long paramLong)
  {
    AppMethodBeat.i(88984);
    Log.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (CB(paramLong))
    {
      i = cBx().Cn(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = cBA().Cn(paramLong);
      AppMethodBeat.o(88984);
      return i;
    }
    int i = cBw().Cn(paramLong);
    AppMethodBeat.o(88984);
    return i;
  }
  
  public final FileDownloadTaskInfo Co(long paramLong)
  {
    AppMethodBeat.i(88985);
    Object localObject1;
    if (CB(paramLong))
    {
      localObject1 = cBx().Co(paramLong);
      AppMethodBeat.o(88985);
      return localObject1;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    Object localObject2;
    if ((locala != null) && (locala.field_status == 3) && (s.YS(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).md5 = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).qJe = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).oJj = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).qJf = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).dNv = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (s.YS(((FileDownloadTaskInfo)localObject2).path)) {
          break label406;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        ((FileDownloadTaskInfo)localObject2).qJg = locala.field_downloadInWifi;
        ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
        ((FileDownloadTaskInfo)localObject2).qJh = locala.field_reserveInWifi;
      }
      Log.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).md5, Long.valueOf(((FileDownloadTaskInfo)localObject2).oJj), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).qJf), Integer.valueOf(((FileDownloadTaskInfo)localObject2).dNv) });
      AppMethodBeat.o(88985);
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = cBA().Co(paramLong);
        break;
      }
      localObject2 = cBw().Co(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).qJf = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).dNv = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      label406:
      if (((FileDownloadTaskInfo)localObject2).status == 6) {
        ((FileDownloadTaskInfo)localObject2).status = 1;
      }
    }
  }
  
  public final boolean Cp(long paramLong)
  {
    AppMethodBeat.i(88989);
    Log.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(paramLong)));
    CD(paramLong);
    if (CB(paramLong))
    {
      bool = cBx().Cp(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cBA().Cp(paramLong);
      AppMethodBeat.o(88989);
      return bool;
    }
    boolean bool = cBw().Cp(paramLong);
    AppMethodBeat.o(88989);
    return bool;
  }
  
  public final boolean Cq(long paramLong)
  {
    AppMethodBeat.i(88990);
    Log.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    CD(paramLong);
    if (CB(paramLong))
    {
      bool = cBx().Cq(paramLong);
      AppMethodBeat.o(88990);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if ((locala != null) && (!locala.field_reserveInWifi) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cBA().n(paramLong, true);
      AppMethodBeat.o(88990);
      return bool;
    }
    boolean bool = cBw().Cq(paramLong);
    AppMethodBeat.o(88990);
    return bool;
  }
  
  public final boolean Cr(long paramLong)
  {
    AppMethodBeat.i(88999);
    Log.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (CB(paramLong))
    {
      AppMethodBeat.o(88999);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = cBA().Cr(paramLong);
      AppMethodBeat.o(88999);
      return bool;
    }
    boolean bool = cBz().Cr(paramLong);
    AppMethodBeat.o(88999);
    return bool;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(88982);
    Log.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(paramg.qIG), paramg.mAppId });
    if (paramg.qIG == 2)
    {
      l = cBB().a(paramg);
      AppMethodBeat.o(88982);
      return l;
    }
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.aAf().azp())
    {
      com.tencent.mm.kernel.g.aAf();
      if (!com.tencent.mm.kernel.a.azj())
      {
        Log.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
        l = cBw().a(paramg);
        AppMethodBeat.o(88982);
        return l;
      }
    }
    long l = cBx().a(paramg);
    if (l >= 0L)
    {
      qIr.put(Long.valueOf(l), Long.valueOf(0L));
      MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      Log.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88982);
      return l;
    }
    Log.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    cBy().a(paramg);
    AppMethodBeat.o(88982);
    return l;
  }
  
  public final FileDownloadTaskInfo alg(String paramString)
  {
    AppMethodBeat.i(88986);
    paramString = d.alb(paramString);
    if (paramString != null)
    {
      paramString = Co(paramString.field_downloadId);
      AppMethodBeat.o(88986);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(88986);
    return paramString;
  }
  
  public final FileDownloadTaskInfo alh(String paramString)
  {
    AppMethodBeat.i(88987);
    paramString = d.ale(paramString);
    if (paramString != null)
    {
      paramString = Co(paramString.field_downloadId);
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
    if (com.tencent.mm.kernel.g.aAf().azp())
    {
      com.tencent.mm.kernel.g.aAf();
      if (!com.tencent.mm.kernel.a.azj())
      {
        l = cBA().a(paramg);
        AppMethodBeat.o(88983);
        return l;
      }
    }
    long l = cBx().a(paramg);
    if (l >= 0L)
    {
      qIr.put(Long.valueOf(l), Long.valueOf(0L));
      MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      Log.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(88983);
      return l;
    }
    Log.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    cBy().a(paramg);
    AppMethodBeat.o(88983);
    return l;
  }
  
  public final b cBA()
  {
    AppMethodBeat.i(88980);
    if (this.qIw == null) {
      this.qIw = new b(this.qIy);
    }
    b localb = this.qIw;
    AppMethodBeat.o(88980);
    return localb;
  }
  
  public final n cBw()
  {
    AppMethodBeat.i(88976);
    Log.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + lCZ);
    if (this.qIs != null)
    {
      localObject = this.qIs;
      AppMethodBeat.o(88976);
      return localObject;
    }
    Object localObject = new jr();
    EventCenter.instance.publish((IEvent)localObject);
    int i = ((jr)localObject).dOB.dNv;
    Log.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i)));
    if (i > 0) {
      lCZ = i;
    }
    if (lCZ == 1) {}
    for (this.qIs = cBx();; this.qIs = cBz())
    {
      localObject = this.qIs;
      AppMethodBeat.o(88976);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.downloader.h.a cBz()
  {
    AppMethodBeat.i(88979);
    if (this.qIv == null) {
      this.qIv = new com.tencent.mm.plugin.downloader.h.a(this.qIy);
    }
    com.tencent.mm.plugin.downloader.h.a locala = this.qIv;
    AppMethodBeat.o(88979);
    return locala;
  }
  
  public final boolean h(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(89000);
    if ((parama != null) && (parama.field_downloaderType == 3))
    {
      bool = cBA().n(parama.field_downloadId, true);
      AppMethodBeat.o(89000);
      return bool;
    }
    boolean bool = cBz().n(parama.field_downloadId, true);
    AppMethodBeat.o(89000);
    return bool;
  }
  
  final void o(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(88996);
    Log.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    MMApplicationContext.getContext();
    if (CB(paramLong))
    {
      localObject = Co(paramLong);
      this.qIy.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      AppMethodBeat.o(88996);
      return;
    }
    Object localObject = d.Cw(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(88996);
      return;
    }
    if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName))
    {
      str = ali(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
      if (!Util.isNullOrNil(str))
      {
        ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName = str;
        Log.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, str });
        d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
      }
    }
    String str = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath;
    int i;
    if (Util.isNullOrNil(str)) {
      i = 0;
    }
    for (;;)
    {
      Log.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName, ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, Integer.valueOf(i) });
      com.tencent.mm.kernel.g.aAk().postToWorker(new f.1(this, (com.tencent.mm.plugin.downloader.g.a)localObject, i, paramBoolean));
      AppMethodBeat.o(88996);
      return;
      int j = r.bdO(str);
      i = j;
      if (j == 0) {
        i = r.bdO(q.k(str, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */