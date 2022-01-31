package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.x.c;
import com.tencent.mm.h.a.gx;
import com.tencent.mm.h.a.ho;
import com.tencent.mm.h.a.ho.a;
import com.tencent.mm.model.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static int ghV = 2;
  private static Map<Long, Long> iPg = new HashMap();
  private static d iPo;
  private l iPh;
  private l iPi;
  private l iPj;
  private com.tencent.mm.plugin.downloader.g.a iPk;
  private a iPl;
  private l iPm;
  public b iPn;
  public boolean iPp = false;
  
  private d()
  {
    aFV();
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      com.tencent.mm.kernel.g.DN();
      if (!com.tencent.mm.kernel.a.CW())
      {
        ghV = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("FileDownloaderType"), 2);
        y.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(ghV) });
      }
    }
    for (;;)
    {
      this.iPn = new b();
      return;
      y.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  public static LinkedList<FileDownloadTaskInfo> N(LinkedList<String> paramLinkedList)
  {
    Object localObject = c.M(paramLinkedList);
    paramLinkedList = new LinkedList();
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      localObject = ((LinkedList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.downloader.f.a locala = (com.tencent.mm.plugin.downloader.f.a)((Iterator)localObject).next();
        FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
        if ((locala.field_status == 3) && (!com.tencent.mm.vfs.e.bK(locala.field_filePath))) {}
        for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = locala.field_status)
        {
          localFileDownloadTaskInfo.appId = locala.field_appId;
          localFileDownloadTaskInfo.id = locala.field_downloadId;
          localFileDownloadTaskInfo.url = locala.field_downloadUrl;
          localFileDownloadTaskInfo.path = locala.field_filePath;
          localFileDownloadTaskInfo.bIW = locala.field_md5;
          localFileDownloadTaskInfo.iPM = locala.field_downloadedSize;
          localFileDownloadTaskInfo.hFz = locala.field_totalSize;
          localFileDownloadTaskInfo.iPN = locala.field_autoDownload;
          localFileDownloadTaskInfo.bOz = locala.field_downloaderType;
          paramLinkedList.add(localFileDownloadTaskInfo);
          break;
        }
      }
    }
    return paramLinkedList;
  }
  
  private void a(String paramString, e parame)
  {
    com.tencent.mm.plugin.downloader.f.a locala;
    if (!this.iPp)
    {
      locala = c.zH(paramString);
      if ((locala != null) && (locala.field_autoDownload))
      {
        gx localgx = new gx();
        localgx.bOK.bOL = paramString;
        com.tencent.mm.sdk.b.a.udP.m(localgx);
        if (parame == null) {
          break label105;
        }
        locala.field_autoInstall = parame.iPy;
        locala.field_showNotification = parame.ghU;
      }
    }
    for (locala.field_autoDownload = parame.iPA;; locala.field_autoDownload = false)
    {
      c.d(locala);
      y.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", new Object[] { paramString });
      this.iPp = false;
      return;
      label105:
      locala.field_autoInstall = true;
      locala.field_showNotification = true;
    }
  }
  
  static void a(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    x.c localc = new x.c(ae.getContext(), (byte)0);
    paramString1 = com.tencent.mm.pluginsdk.model.app.g.by(paramString1, false);
    if ((paramString1 != null) && (!bk.bl(paramString1.field_appName)))
    {
      localc.c(paramString1.field_appName);
      localc.d(paramString3);
      localc.ah(17301634);
      localc.z(true);
      if (paramPendingIntent == null) {
        break label120;
      }
    }
    for (localc.xz = paramPendingIntent;; localc.xz = PendingIntent.getActivity(ae.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
      y.i("MicroMsg.FileDownloadManager", "show notification");
      return;
      localc.c(paramString2);
      break;
      label120:
      paramString1 = new Intent();
    }
  }
  
  public static d aFP()
  {
    if (iPo == null) {
      iPo = new d();
    }
    return iPo;
  }
  
  private l aFQ()
  {
    y.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + ghV);
    if (this.iPh != null) {
      return this.iPh;
    }
    ho localho = new ho();
    com.tencent.mm.sdk.b.a.udP.m(localho);
    int i = localho.bPA.bOz;
    if (i > 0) {
      ghV = i;
    }
    if (ghV == 1) {}
    for (this.iPh = aFR();; this.iPh = aFT()) {
      return this.iPh;
    }
  }
  
  private l aFR()
  {
    if (this.iPj == null) {
      this.iPj = new g(this.iPn);
    }
    return this.iPj;
  }
  
  private l aFS()
  {
    if (this.iPi == null) {
      this.iPi = new i(this.iPn);
    }
    return this.iPi;
  }
  
  private static void aFV()
  {
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("off_line_download_ids", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localObject = localSharedPreferences.getAll();
    } while ((localObject == null) || (((Map)localObject).size() == 0));
    iPg.clear();
    Object localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry1 != null) && (!bk.bl((String)localEntry1.getKey()))) {
        try
        {
          long l1 = bk.getLong((String)localEntry1.getKey(), 0L);
          long l2 = ((Long)localEntry1.getValue()).longValue();
          long l3 = System.currentTimeMillis() - l1;
          if ((l3 - l1 > 0L) && (l3 - l1 < 86400000L)) {
            iPg.put(Long.valueOf(l1), Long.valueOf(l2));
          }
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.FileDownloadManager", "parse download task failed: " + localException.toString());
          y.printErrStackTrace("MicroMsg.FileDownloadManager", localException, "", new Object[0]);
        }
      }
    }
    localSharedPreferences.edit().clear();
    localObject = iPg.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
  }
  
  public static boolean dm(long paramLong)
  {
    return iPg.containsKey(Long.valueOf(paramLong));
  }
  
  static long dn(long paramLong)
  {
    Long localLong = (Long)iPg.get(Long.valueOf(paramLong));
    if (localLong == null) {
      return -1L;
    }
    return localLong.longValue();
  }
  
  private void jdMethod_do(long paramLong)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if (locala == null)
    {
      this.iPp = false;
      return;
    }
    a(locala.field_appId, null);
  }
  
  static void w(long paramLong1, long paramLong2)
  {
    iPg.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    ae.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
  }
  
  public final long a(e parame)
  {
    y.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", new Object[] { Integer.valueOf(parame.iPx), parame.mAppId });
    if (parame.iPx == 2)
    {
      if (this.iPm == null) {
        this.iPm = new j(this.iPn);
      }
      return this.iPm.a(parame);
    }
    a(parame.mAppId, parame);
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      com.tencent.mm.kernel.g.DN();
      if (!com.tencent.mm.kernel.a.CW()) {
        return aFQ().a(parame);
      }
    }
    long l = aFR().a(parame);
    if (l >= 0L)
    {
      iPg.put(Long.valueOf(l), Long.valueOf(0L));
      ae.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      y.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      return l;
    }
    y.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    aFS().a(parame);
    return l;
  }
  
  public final com.tencent.mm.plugin.downloader.g.a aFT()
  {
    if (this.iPk == null) {
      this.iPk = new com.tencent.mm.plugin.downloader.g.a(this.iPn);
    }
    return this.iPk;
  }
  
  public final a aFU()
  {
    if (this.iPl == null) {
      this.iPl = new a(this.iPn);
    }
    return this.iPl;
  }
  
  public final long b(e parame)
  {
    y.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", new Object[] { parame.mAppId });
    a(parame.mAppId, parame);
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      com.tencent.mm.kernel.g.DN();
      if (!com.tencent.mm.kernel.a.CW()) {
        return aFU().a(parame);
      }
    }
    long l = aFR().a(parame);
    if (l >= 0L)
    {
      iPg.put(Long.valueOf(l), Long.valueOf(0L));
      ae.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      y.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      return l;
    }
    y.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    aFS().a(parame);
    return l;
  }
  
  public final int dc(long paramLong)
  {
    y.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = " + paramLong);
    if (dm(paramLong)) {
      return aFR().dc(paramLong);
    }
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3)) {
      return aFU().dc(paramLong);
    }
    return aFQ().dc(paramLong);
  }
  
  public final FileDownloadTaskInfo dd(long paramLong)
  {
    if (dm(paramLong)) {
      return aFR().dd(paramLong);
    }
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    Object localObject2;
    label194:
    boolean bool;
    if ((locala != null) && (locala.field_status == 3) && (com.tencent.mm.vfs.e.bK(locala.field_filePath)))
    {
      localObject1 = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject1).id = paramLong;
      ((FileDownloadTaskInfo)localObject1).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject1).status = 3;
      ((FileDownloadTaskInfo)localObject1).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject1).bIW = locala.field_md5;
      ((FileDownloadTaskInfo)localObject1).iPM = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject1).hFz = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject1).iPN = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject1).bOz = locala.field_downloaderType;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FileDownloadTaskInfo();
      }
      if ((((FileDownloadTaskInfo)localObject2).status == 3) || (((FileDownloadTaskInfo)localObject2).status == 6))
      {
        if (com.tencent.mm.vfs.e.bK(((FileDownloadTaskInfo)localObject2).path)) {
          break label402;
        }
        ((FileDownloadTaskInfo)localObject2).status = 0;
      }
      if (locala == null) {
        break label421;
      }
      bool = locala.field_downloadInWifi;
      label205:
      ((FileDownloadTaskInfo)localObject2).iPO = bool;
      if (locala == null) {
        break label426;
      }
    }
    label402:
    label421:
    label426:
    for (Object localObject1 = locala.field_appId;; localObject1 = "")
    {
      ((FileDownloadTaskInfo)localObject2).appId = ((String)localObject1);
      y.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject2).id), ((FileDownloadTaskInfo)localObject2).url, Integer.valueOf(((FileDownloadTaskInfo)localObject2).status), ((FileDownloadTaskInfo)localObject2).path, ((FileDownloadTaskInfo)localObject2).bIW, Long.valueOf(((FileDownloadTaskInfo)localObject2).hFz), Boolean.valueOf(((FileDownloadTaskInfo)localObject2).iPN), Integer.valueOf(((FileDownloadTaskInfo)localObject2).bOz) });
      return localObject2;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject1 = aFU().dd(paramLong);
        break;
      }
      localObject2 = aFQ().dd(paramLong);
      localObject1 = localObject2;
      if (locala == null) {
        break;
      }
      ((FileDownloadTaskInfo)localObject2).iPN = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject2).bOz = locala.field_downloaderType;
      localObject1 = localObject2;
      break;
      if (((FileDownloadTaskInfo)localObject2).status != 6) {
        break label194;
      }
      ((FileDownloadTaskInfo)localObject2).status = 1;
      break label194;
      bool = false;
      break label205;
    }
  }
  
  public final boolean de(long paramLong)
  {
    y.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = " + paramLong);
    jdMethod_do(paramLong);
    if (dm(paramLong)) {
      return aFR().de(paramLong);
    }
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3)) {
      return aFU().de(paramLong);
    }
    return aFQ().de(paramLong);
  }
  
  public final boolean df(long paramLong)
  {
    y.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = " + paramLong);
    jdMethod_do(paramLong);
    if (dm(paramLong)) {
      return aFR().df(paramLong);
    }
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3)) {
      return aFU().k(paramLong, true);
    }
    return aFQ().df(paramLong);
  }
  
  final void l(long paramLong, boolean paramBoolean)
  {
    y.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bk.csb() });
    Object localObject = ae.getContext();
    if (dm(paramLong))
    {
      localObject = dd(paramLong);
      this.iPn.c(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
    }
    com.tencent.mm.plugin.downloader.f.a locala;
    do
    {
      return;
      locala = c.dk(paramLong);
    } while (locala == null);
    if (bk.bl(locala.field_packageName))
    {
      String str = q.Wb(locala.field_filePath);
      if (!bk.bl(str))
      {
        locala.field_packageName = str;
        y.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { locala.field_filePath, str });
        c.d(locala);
      }
    }
    int i = q.Wc(locala.field_filePath);
    y.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { locala.field_packageName, locala.field_filePath, Integer.valueOf(i) });
    com.tencent.mm.kernel.g.DS().O(new d.1(this, locala, i, (Context)localObject, paramLong, paramBoolean));
  }
  
  public final FileDownloadTaskInfo zL(String paramString)
  {
    paramString = c.zH(paramString);
    if (paramString != null) {
      return dd(paramString.field_downloadId);
    }
    return new FileDownloadTaskInfo();
  }
  
  public final FileDownloadTaskInfo zM(String paramString)
  {
    paramString = c.zK(paramString);
    if (paramString != null) {
      return dd(paramString.field_downloadId);
    }
    return new FileDownloadTaskInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.d
 * JD-Core Version:    0.7.0.1
 */