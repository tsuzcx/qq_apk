package com.tencent.mm.plugin.downloader.g;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.a.gz;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class a$5
  implements ITMAssistantDownloadSDKClientListener
{
  a$5(a parama) {}
  
  public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString, long paramLong1, long paramLong2)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.zK(paramString);
    if (locala == null)
    {
      y.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
      return;
    }
    Long localLong = Long.valueOf(bk.c((Long)this.iRl.iOW.get(locala.field_downloadUrl)));
    paramTMAssistantDownloadSDKClient = localLong;
    if (localLong.longValue() == 0L)
    {
      paramTMAssistantDownloadSDKClient = Long.valueOf(paramLong1);
      this.iRl.iOW.put(locala.field_downloadUrl, Long.valueOf(paramLong1));
    }
    long l1 = paramLong1 - paramTMAssistantDownloadSDKClient.longValue();
    if (paramLong2 == 0L) {
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "onDownloadTaskProgressChanged, totalDataLen = 0");
    }
    for (;;)
    {
      paramTMAssistantDownloadSDKClient = (Long)this.iRl.iRf.get(paramString);
      localLong = Long.valueOf(System.currentTimeMillis());
      if ((paramTMAssistantDownloadSDKClient != null) && (localLong.longValue() - paramTMAssistantDownloadSDKClient.longValue() < 500L)) {
        break;
      }
      this.iRl.iRf.put(paramString, localLong);
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
      int i = (int)(100L * paramLong1 / paramLong2);
      a.a(this.iRl, paramString, 2, i, false);
      l1 = locala.field_downloadId;
      paramTMAssistantDownloadSDKClient = c.FC();
      if (paramTMAssistantDownloadSDKClient != null) {
        paramTMAssistantDownloadSDKClient.gk("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + paramLong1 + ",totalSize= " + paramLong2 + " where downloadId = " + l1);
      }
      this.iRl.iPn.di(locala.field_downloadId);
      return;
      long l2 = 100L * l1 / paramLong2;
      i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
      if (l2 >= 1L)
      {
        long l3 = bk.a((Long)this.iRl.iOX.get(locala.field_downloadUrl), locala.field_startTime);
        l2 = System.currentTimeMillis();
        l3 = l2 - l3;
        float f = (float)l1 * 1000.0F / (float)l3 / 1048576.0F;
        y.d("MicroMsg.FileDownloaderImplTMAssistant", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d", new Object[] { locala.field_appId, Float.valueOf(f), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(paramLong2) });
        com.tencent.mm.plugin.downloader.h.b.a(locala.field_downloadId, f, i);
        this.iRl.iOX.put(locala.field_downloadUrl, Long.valueOf(l2));
        this.iRl.iOW.put(locala.field_downloadUrl, Long.valueOf(paramLong1));
      }
    }
  }
  
  public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + paramInt1 + " | ErrorCode: " + paramInt2 + " | ErrorMsg: " + paramString2);
    paramTMAssistantDownloadSDKClient = c.zK(paramString1);
    if (paramTMAssistantDownloadSDKClient == null)
    {
      y.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
      return;
    }
    y.i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramTMAssistantDownloadSDKClient.field_downloadId), paramTMAssistantDownloadSDKClient.field_filePath, Boolean.valueOf(e.bK(paramTMAssistantDownloadSDKClient.field_filePath)), paramString1 });
    if ((paramInt1 != 1) && (paramInt1 != 2))
    {
      paramString2 = this.iRl.dd(paramTMAssistantDownloadSDKClient.field_downloadId);
      long l1 = bk.a((Long)this.iRl.iOX.get(paramTMAssistantDownloadSDKClient.field_downloadUrl), paramTMAssistantDownloadSDKClient.field_startTime);
      long l2 = bk.a((Long)this.iRl.iOW.get(paramTMAssistantDownloadSDKClient.field_downloadUrl), paramTMAssistantDownloadSDKClient.field_startSize);
      long l3 = System.currentTimeMillis();
      int i = (int)((float)paramString2.iPM / (float)paramString2.hFz * 100.0F);
      float f = (float)(paramString2.iPM - l2) * 1000.0F / (float)(l3 - l1) / 1048576.0F;
      com.tencent.mm.plugin.downloader.h.b.a(paramTMAssistantDownloadSDKClient.field_downloadId, f, i);
      this.iRl.iOW.remove(paramTMAssistantDownloadSDKClient.field_downloadUrl);
      this.iRl.iOX.remove(paramTMAssistantDownloadSDKClient.field_downloadUrl);
    }
    switch (paramInt1)
    {
    case 1: 
    default: 
      return;
    case 2: 
      c.j(paramTMAssistantDownloadSDKClient.field_downloadId, 1);
      return;
    case 3: 
      paramTMAssistantDownloadSDKClient.field_finishTime = System.currentTimeMillis();
      paramTMAssistantDownloadSDKClient.field_status = 2;
      c.d(paramTMAssistantDownloadSDKClient);
      this.iRl.cancelNotification(paramString1);
      this.iRl.iRh.remove(Long.valueOf(paramTMAssistantDownloadSDKClient.field_downloadId));
      this.iRl.iPn.dh(paramTMAssistantDownloadSDKClient.field_downloadId);
      return;
    case 4: 
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
      paramTMAssistantDownloadSDKClient.field_status = 6;
      paramTMAssistantDownloadSDKClient.field_finishTime = System.currentTimeMillis();
      paramTMAssistantDownloadSDKClient.field_downloadedSize = paramTMAssistantDownloadSDKClient.field_totalSize;
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(paramTMAssistantDownloadSDKClient.field_downloadedSize), Long.valueOf(paramTMAssistantDownloadSDKClient.field_startSize) });
      c.d(paramTMAssistantDownloadSDKClient);
      this.iRl.iPn.dj(paramTMAssistantDownloadSDKClient.field_downloadId);
      if (paramBoolean2)
      {
        paramString2 = new gz();
        paramString2.bON.appId = paramTMAssistantDownloadSDKClient.field_appId;
        paramString2.bON.opType = 6;
        com.tencent.mm.sdk.b.a.udP.m(paramString2);
      }
      paramString2 = new Intent();
      paramString2.putExtra(FileDownloadService.iPI, 1);
      paramString2.setClass(this.iRl.mContext, FileDownloadService.class);
      paramString2.putExtra(FileDownloadService.EXTRA_ID, paramTMAssistantDownloadSDKClient.field_downloadId);
      paramString2.putExtra(FileDownloadService.iPL, paramBoolean1);
      try
      {
        this.iRl.mContext.startService(paramString2);
        this.iRl.cancelNotification(paramString1);
        this.iRl.iRh.remove(Long.valueOf(paramTMAssistantDownloadSDKClient.field_downloadId));
        return;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          y.e("MicroMsg.FileDownloaderImplTMAssistant", paramString2.getMessage());
        }
      }
    }
    if ((paramInt2 == 601) || (paramInt2 == 602) || (paramInt2 == 603) || (paramInt2 == 605) || (paramInt2 == 606))
    {
      y.d("MicroMsg.FileDownloaderImplTMAssistant", "releaseTimer 4 min");
      this.iRl.iRj.S(240000L, 240000L);
    }
    if ((aq.isWifi(ae.getContext())) && (paramTMAssistantDownloadSDKClient.field_downloadInWifi)) {
      paramTMAssistantDownloadSDKClient.field_downloadInWifi = false;
    }
    a.a(this.iRl, paramString1, paramInt1, 0, false);
    this.iRl.iRh.remove(Long.valueOf(paramTMAssistantDownloadSDKClient.field_downloadId));
    paramTMAssistantDownloadSDKClient.field_finishTime = System.currentTimeMillis();
    paramTMAssistantDownloadSDKClient.field_errCode = paramInt2;
    paramTMAssistantDownloadSDKClient.field_status = 4;
    c.d(paramTMAssistantDownloadSDKClient);
    this.iRl.iPn.c(paramTMAssistantDownloadSDKClient.field_downloadId, paramInt2, paramBoolean1);
  }
  
  public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient)
  {
    y.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
    paramTMAssistantDownloadSDKClient = this.iRl.iRh.iterator();
    while (paramTMAssistantDownloadSDKClient.hasNext())
    {
      com.tencent.mm.plugin.downloader.f.a locala = c.dk(((Long)paramTMAssistantDownloadSDKClient.next()).longValue());
      if (locala != null)
      {
        locala.field_finishTime = System.currentTimeMillis();
        locala.field_status = 4;
        locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.iOf;
        c.d(locala);
        this.iRl.iPn.c(locala.field_downloadId, com.tencent.mm.plugin.downloader.a.a.iOf, false);
        a.a(this.iRl, locala.field_downloadUrl, 5, 0, false);
      }
    }
    this.iRl.iRh.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a.5
 * JD-Core Version:    0.7.0.1
 */