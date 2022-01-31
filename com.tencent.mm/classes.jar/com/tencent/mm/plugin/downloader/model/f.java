package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.hs.a;
import com.tencent.mm.model.an;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private static int hAV;
  private static Map<Long, Long> kYp;
  private static f kYx;
  private n kYq;
  private n kYr;
  private n kYs;
  private com.tencent.mm.plugin.downloader.h.a kYt;
  private b kYu;
  private n kYv;
  public c kYw;
  public boolean kYy;
  
  static
  {
    AppMethodBeat.i(2438);
    kYp = new HashMap();
    hAV = 2;
    AppMethodBeat.o(2438);
  }
  
  private f()
  {
    AppMethodBeat.i(2410);
    this.kYy = false;
    bjs();
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      com.tencent.mm.kernel.g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        hAV = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("FileDownloaderType"), 2);
        ab.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(hAV) });
      }
    }
    for (;;)
    {
      this.kYw = new c();
      AppMethodBeat.o(2410);
      return;
      ab.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  static void I(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(2429);
    kYp.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    AppMethodBeat.o(2429);
  }
  
  public static LinkedList<FileDownloadTaskInfo> M(LinkedList<String> paramLinkedList)
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(2423);
    Object localObject = d.YG();
    label42:
    FileDownloadTaskInfo localFileDownloadTaskInfo;
    if (localObject == null)
    {
      paramLinkedList = localLinkedList;
      localLinkedList = new LinkedList();
      if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
        break label290;
      }
      paramLinkedList = paramLinkedList.iterator();
      if (!paramLinkedList.hasNext()) {
        break label290;
      }
      localObject = (com.tencent.mm.plugin.downloader.g.a)paramLinkedList.next();
      localFileDownloadTaskInfo = new FileDownloadTaskInfo();
      if ((((com.tencent.mm.plugin.downloader.g.a)localObject).field_status != 3) || (com.tencent.mm.vfs.e.cN(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath))) {
        break label279;
      }
    }
    label279:
    for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status)
    {
      localFileDownloadTaskInfo.appId = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
      localFileDownloadTaskInfo.id = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId;
      localFileDownloadTaskInfo.url = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadUrl;
      localFileDownloadTaskInfo.path = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath;
      localFileDownloadTaskInfo.cqq = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_md5;
      localFileDownloadTaskInfo.kYX = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadedSize;
      localFileDownloadTaskInfo.jyU = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_totalSize;
      localFileDownloadTaskInfo.kYY = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_autoDownload;
      localFileDownloadTaskInfo.cvQ = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloaderType;
      localFileDownloadTaskInfo.kYZ = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadInWifi;
      localFileDownloadTaskInfo.kZa = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_reserveInWifi;
      localLinkedList.add(localFileDownloadTaskInfo);
      break label42;
      localObject = ((com.tencent.mm.plugin.downloader.g.b)localObject).rawQuery("select * from FileDownloadInfo where ".concat(String.valueOf(com.tencent.mm.plugin.downloader.g.b.N(paramLinkedList))), new String[0]);
      paramLinkedList = localLinkedList;
      if (localObject == null) {
        break;
      }
      localLinkedList = new LinkedList();
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          paramLinkedList = new com.tencent.mm.plugin.downloader.g.a();
          paramLinkedList.convertFrom((Cursor)localObject);
          localLinkedList.add(paramLinkedList);
        } while (((Cursor)localObject).moveToNext());
      }
      paramLinkedList = localLinkedList;
      if (localObject == null) {
        break;
      }
      ((Cursor)localObject).close();
      paramLinkedList = localLinkedList;
      break;
    }
    label290:
    AppMethodBeat.o(2423);
    return localLinkedList;
  }
  
  private void a(String paramString, g paramg)
  {
    AppMethodBeat.i(2432);
    com.tencent.mm.plugin.downloader.g.a locala;
    if (!this.kYy)
    {
      locala = d.JD(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        hb localhb = new hb();
        localhb.cwb.cwc = paramString;
        com.tencent.mm.sdk.b.a.ymk.l(localhb);
        if (paramg == null) {
          break label117;
        }
        locala.field_autoInstall = paramg.kYF;
        locala.field_showNotification = paramg.hAU;
      }
    }
    for (locala.field_autoDownload = paramg.kYH;; locala.field_autoDownload = false)
    {
      d.e(locala);
      ab.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.kYy = false;
      AppMethodBeat.o(2432);
      return;
      label117:
      locala.field_autoInstall = true;
      locala.field_showNotification = true;
    }
  }
  
  static void a(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(2427);
    s.c localc = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id");
    paramString1 = com.tencent.mm.pluginsdk.model.app.g.ca(paramString1, false);
    if ((paramString1 != null) && (!bo.isNullOrNil(paramString1.field_appName)))
    {
      localc.e(paramString1.field_appName);
      localc.f(paramString3);
      localc.Y(17301634);
      localc.z(true);
      if (paramPendingIntent == null) {
        break label130;
      }
    }
    for (localc.ya = paramPendingIntent;; localc.ya = PendingIntent.getActivity(ah.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
      ab.i("MicroMsg.FileDownloadManager", "show notification");
      AppMethodBeat.o(2427);
      return;
      localc.e(paramString2);
      break;
      label130:
      paramString1 = new Intent();
    }
  }
  
  public static f bjl()
  {
    AppMethodBeat.i(2409);
    if (kYx == null) {
      kYx = new f();
    }
    f localf = kYx;
    AppMethodBeat.o(2409);
    return localf;
  }
  
  private n bjn()
  {
    AppMethodBeat.i(2412);
    if (this.kYs == null) {
      this.kYs = new i(this.kYw);
    }
    n localn = this.kYs;
    AppMethodBeat.o(2412);
    return localn;
  }
  
  private n bjo()
  {
    AppMethodBeat.i(2413);
    if (this.kYr == null) {
      this.kYr = new k(this.kYw);
    }
    n localn = this.kYr;
    AppMethodBeat.o(2413);
    return localn;
  }
  
  private n bjr()
  {
    AppMethodBeat.i(2416);
    if (this.kYv == null) {
      this.kYv = new l(this.kYw);
    }
    n localn = this.kYv;
    AppMethodBeat.o(2416);
    return localn;
  }
  
  private static void bjs()
  {
    AppMethodBeat.i(2426);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("off_line_download_ids", 0);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(2426);
      return;
    }
    Object localObject = localSharedPreferences.getAll();
    if ((localObject == null) || (((Map)localObject).size() == 0))
    {
      AppMethodBeat.o(2426);
      return;
    }
    kYp.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry1 != null) && (!bo.isNullOrNil((String)localEntry1.getKey()))) {
        try
        {
          long l1 = bo.getLong((String)localEntry1.getKey(), 0L);
          long l2 = ((Long)localEntry1.getValue()).longValue();
          long l3 = System.currentTimeMillis() - l1;
          if ((l3 - l1 > 0L) && (l3 - l1 < 86400000L)) {
            kYp.put(Long.valueOf(l1), Long.valueOf(l2));
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.FileDownloadManager", "parse download task failed: " + localException.toString());
          ab.printErrStackTrace("MicroMsg.FileDownloadManager", localException, "", new Object[0]);
        }
      }
    }
    localSharedPreferences.edit().clear();
    localObject = kYp.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    AppMethodBeat.o(2426);
  }
  
  static boolean iO(long paramLong)
  {
    AppMethodBeat.i(2428);
    boolean bool = kYp.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(2428);
    return bool;
  }
  
  static long iP(long paramLong)
  {
    AppMethodBeat.i(2430);
    Long localLong = (Long)kYp.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(2430);
      return -1L;
    }
    paramLong = localLong.longValue();
    AppMethodBeat.o(2430);
    return paramLong;
  }
  
  private void iQ(long paramLong)
  {
    AppMethodBeat.i(2433);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala == null)
    {
      this.kYy = false;
      AppMethodBeat.o(2433);
      return;
    }
    a(locala.field_appId, null);
    AppMethodBeat.o(2433);
  }
  
  public final FileDownloadTaskInfo JH(String paramString)
  {
    AppMethodBeat.i(2421);
    paramString = d.JD(paramString);
    if (paramString != null)
    {
      paramString = iA(paramString.field_downloadId);
      AppMethodBeat.o(2421);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(2421);
    return paramString;
  }
  
  public final FileDownloadTaskInfo JI(String paramString)
  {
    AppMethodBeat.i(2422);
    paramString = d.JG(paramString);
    if (paramString != null)
    {
      paramString = iA(paramString.field_downloadId);
      AppMethodBeat.o(2422);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    AppMethodBeat.o(2422);
    return paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(2417);
    ab.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(paramg.kYE), paramg.mAppId });
    if (paramg.kYE == 2)
    {
      l = bjr().a(paramg);
      AppMethodBeat.o(2417);
      return l;
    }
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      com.tencent.mm.kernel.g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        ab.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
        l = bjm().a(paramg);
        AppMethodBeat.o(2417);
        return l;
      }
    }
    long l = bjn().a(paramg);
    if (l >= 0L)
    {
      kYp.put(Long.valueOf(l), Long.valueOf(0L));
      ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ab.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(2417);
      return l;
    }
    ab.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    bjo().a(paramg);
    AppMethodBeat.o(2417);
    return l;
  }
  
  public final long b(g paramg)
  {
    AppMethodBeat.i(2418);
    ab.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", new Object[] { paramg.mAppId });
    a(paramg.mAppId, paramg);
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      com.tencent.mm.kernel.g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        l = bjq().a(paramg);
        AppMethodBeat.o(2418);
        return l;
      }
    }
    long l = bjn().a(paramg);
    if (l >= 0L)
    {
      kYp.put(Long.valueOf(l), Long.valueOf(0L));
      ah.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      ab.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(2418);
      return l;
    }
    ab.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    bjo().a(paramg);
    AppMethodBeat.o(2418);
    return l;
  }
  
  public final n bjm()
  {
    AppMethodBeat.i(2411);
    ab.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + hAV);
    if (this.kYq != null)
    {
      localObject = this.kYq;
      AppMethodBeat.o(2411);
      return localObject;
    }
    Object localObject = new hs();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    int i = ((hs)localObject).cwT.cvQ;
    ab.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i)));
    if (i > 0) {
      hAV = i;
    }
    if (hAV == 1) {}
    for (this.kYq = bjn();; this.kYq = bjp())
    {
      localObject = this.kYq;
      AppMethodBeat.o(2411);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.downloader.h.a bjp()
  {
    AppMethodBeat.i(2414);
    if (this.kYt == null) {
      this.kYt = new com.tencent.mm.plugin.downloader.h.a(this.kYw);
    }
    com.tencent.mm.plugin.downloader.h.a locala = this.kYt;
    AppMethodBeat.o(2414);
    return locala;
  }
  
  public final b bjq()
  {
    AppMethodBeat.i(2415);
    if (this.kYu == null) {
      this.kYu = new b(this.kYw);
    }
    b localb = this.kYu;
    AppMethodBeat.o(2415);
    return localb;
  }
  
  public final boolean f(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(141064);
    if ((parama != null) && (parama.field_downloaderType == 3))
    {
      bool = bjq().o(parama.field_downloadId, true);
      AppMethodBeat.o(141064);
      return bool;
    }
    boolean bool = bjp().o(parama.field_downloadId, true);
    AppMethodBeat.o(141064);
    return bool;
  }
  
  public final FileDownloadTaskInfo iA(long paramLong)
  {
    AppMethodBeat.i(2420);
    Object localObject1;
    if (iO(paramLong))
    {
      localObject1 = bjn().iA(paramLong);
      AppMethodBeat.o(2420);
      return localObject1;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    Object localObject2;
    if ((locala != null) && (locala.field_status == 3) && (com.tencent.mm.vfs.e.cN(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).cqq = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).kYX = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).jyU = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).kYY = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).cvQ = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (com.tencent.mm.vfs.e.cN(((FileDownloadTaskInfo)localObject2).path)) {
          break label406;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        ((FileDownloadTaskInfo)localObject2).kYZ = locala.field_downloadInWifi;
        ((FileDownloadTaskInfo)localObject2).appId = locala.field_appId;
        ((FileDownloadTaskInfo)localObject2).kZa = locala.field_reserveInWifi;
      }
      ab.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).cqq, Long.valueOf(((FileDownloadTaskInfo)localObject2).jyU), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).kYY), Integer.valueOf(((FileDownloadTaskInfo)localObject2).cvQ) });
      AppMethodBeat.o(2420);
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = bjq().iA(paramLong);
        break;
      }
      localObject2 = bjm().iA(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).kYY = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).cvQ = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      label406:
      if (((FileDownloadTaskInfo)localObject2).status == 6) {
        ((FileDownloadTaskInfo)localObject2).status = 1;
      }
    }
  }
  
  public final boolean iB(long paramLong)
  {
    AppMethodBeat.i(2424);
    ab.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(paramLong)));
    iQ(paramLong);
    if (iO(paramLong))
    {
      bool = bjn().iB(paramLong);
      AppMethodBeat.o(2424);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bjq().iB(paramLong);
      AppMethodBeat.o(2424);
      return bool;
    }
    boolean bool = bjm().iB(paramLong);
    AppMethodBeat.o(2424);
    return bool;
  }
  
  public final boolean iC(long paramLong)
  {
    AppMethodBeat.i(2425);
    ab.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    iQ(paramLong);
    if (iO(paramLong))
    {
      bool = bjn().iC(paramLong);
      AppMethodBeat.o(2425);
      return bool;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if ((locala != null) && (!locala.field_reserveInWifi) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bjq().o(paramLong, true);
      AppMethodBeat.o(2425);
      return bool;
    }
    boolean bool = bjm().iC(paramLong);
    AppMethodBeat.o(2425);
    return bool;
  }
  
  public final boolean iD(long paramLong)
  {
    AppMethodBeat.i(2434);
    ab.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (iO(paramLong))
    {
      AppMethodBeat.o(2434);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = bjq().iD(paramLong);
      AppMethodBeat.o(2434);
      return bool;
    }
    boolean bool = bjp().iD(paramLong);
    AppMethodBeat.o(2434);
    return bool;
  }
  
  public final int iz(long paramLong)
  {
    AppMethodBeat.i(2419);
    ab.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(paramLong)));
    if (iO(paramLong))
    {
      i = bjn().iz(paramLong);
      AppMethodBeat.o(2419);
      return i;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if ((locala != null) && ((locala.field_downloadInWifi) || (locala.field_reserveInWifi)))
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = bjq().iz(paramLong);
      AppMethodBeat.o(2419);
      return i;
    }
    int i = bjm().iz(paramLong);
    AppMethodBeat.o(2419);
    return i;
  }
  
  final void p(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(2431);
    ab.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bo.dtY() });
    ah.getContext();
    if (iO(paramLong))
    {
      localObject = iA(paramLong);
      this.kYw.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      AppMethodBeat.o(2431);
      return;
    }
    Object localObject = d.iJ(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(2431);
      return;
    }
    if (bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName))
    {
      String str = q.alz(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
      if (!bo.isNullOrNil(str))
      {
        ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName = str;
        ab.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, str });
        d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
      }
    }
    int i = q.alA(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath);
    ab.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject).field_packageName, ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath, Integer.valueOf(i) });
    com.tencent.mm.kernel.g.RO().ac(new f.1(this, (com.tencent.mm.plugin.downloader.g.a)localObject, i, paramBoolean));
    AppMethodBeat.o(2431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */