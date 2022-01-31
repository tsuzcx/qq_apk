package com.tencent.mm.plugin.downloader.h;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class a$5
  implements ITMAssistantDownloadSDKClientListener
{
  a$5(a parama) {}
  
  public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(2497);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JG(paramString);
    if (locala == null)
    {
      ab.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
      AppMethodBeat.o(2497);
      return;
    }
    Long localLong = Long.valueOf(bo.c((Long)this.kZJ.kYe.get(locala.field_downloadUrl)));
    paramTMAssistantDownloadSDKClient = localLong;
    if (localLong.longValue() == 0L)
    {
      paramTMAssistantDownloadSDKClient = Long.valueOf(paramLong1);
      this.kZJ.kYe.put(locala.field_downloadUrl, Long.valueOf(paramLong1));
    }
    long l1 = paramLong1 - paramTMAssistantDownloadSDKClient.longValue();
    if (paramLong2 == 0L) {
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "onDownloadTaskProgressChanged, totalDataLen = 0");
    }
    for (;;)
    {
      paramTMAssistantDownloadSDKClient = (Long)this.kZJ.kZD.get(paramString);
      localLong = Long.valueOf(System.currentTimeMillis());
      if (paramTMAssistantDownloadSDKClient == null) {
        break;
      }
      l1 = localLong.longValue() - paramTMAssistantDownloadSDKClient.longValue();
      if ((l1 <= 0L) || (l1 >= 500L)) {
        break;
      }
      AppMethodBeat.o(2497);
      return;
      long l2 = 100L * l1 / paramLong2;
      i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
      if (l2 >= 1L)
      {
        long l3 = bo.a((Long)this.kZJ.kYf.get(locala.field_downloadUrl), locala.field_startTime);
        l2 = System.currentTimeMillis();
        l3 = l2 - l3;
        float f = (float)l1 * 1000.0F / (float)l3 / 1048576.0F;
        ab.d("MicroMsg.FileDownloaderImplTMAssistant", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d", new Object[] { locala.field_appId, Float.valueOf(f), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(paramLong2) });
        com.tencent.mm.plugin.downloader.i.b.a(locala.field_downloadId, f, i);
        this.kZJ.kYf.put(locala.field_downloadUrl, Long.valueOf(l2));
        this.kZJ.kYe.put(locala.field_downloadUrl, Long.valueOf(paramLong1));
      }
    }
    this.kZJ.kZD.put(paramString, localLong);
    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
    int i = (int)(100L * paramLong1 / paramLong2);
    a.a(this.kZJ, paramString, 2, i, false);
    l1 = locala.field_downloadId;
    paramTMAssistantDownloadSDKClient = com.tencent.mm.plugin.downloader.model.d.YG();
    if (paramTMAssistantDownloadSDKClient != null) {
      paramTMAssistantDownloadSDKClient.execSQL("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + paramLong1 + ",totalSize= " + paramLong2 + " where downloadId = " + l1);
    }
    this.kZJ.kYw.iH(locala.field_downloadId);
    AppMethodBeat.o(2497);
  }
  
  public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(2496);
    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + paramInt1 + " | ErrorCode: " + paramInt2 + " | ErrorMsg: " + paramString2);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JG(paramString1);
    if (locala == null)
    {
      ab.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
      AppMethodBeat.o(2496);
      return;
    }
    ab.i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(locala.field_downloadId), locala.field_filePath, Boolean.valueOf(e.cN(locala.field_filePath)), paramString1 });
    if ((paramInt1 != 1) && (paramInt1 != 2))
    {
      paramTMAssistantDownloadSDKClient = this.kZJ.iA(locala.field_downloadId);
      long l1 = bo.a((Long)this.kZJ.kYf.get(locala.field_downloadUrl), locala.field_startTime);
      long l2 = bo.a((Long)this.kZJ.kYe.get(locala.field_downloadUrl), locala.field_startSize);
      long l3 = System.currentTimeMillis();
      int i = (int)((float)paramTMAssistantDownloadSDKClient.kYX / (float)paramTMAssistantDownloadSDKClient.jyU * 100.0F);
      float f = (float)(paramTMAssistantDownloadSDKClient.kYX - l2) * 1000.0F / (float)(l3 - l1) / 1048576.0F;
      com.tencent.mm.plugin.downloader.i.b.a(locala.field_downloadId, f, i);
      this.kZJ.kYe.remove(locala.field_downloadUrl);
      this.kZJ.kYf.remove(locala.field_downloadUrl);
    }
    paramTMAssistantDownloadSDKClient = null;
    try
    {
      paramString2 = this.kZJ.getClient().getDownloadTaskState(locala.field_downloadUrl);
      paramTMAssistantDownloadSDKClient = paramString2;
    }
    catch (Exception paramString2)
    {
      label317:
      break label317;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2496);
      return;
      AppMethodBeat.o(2496);
      return;
      locala.field_status = 1;
      if (paramTMAssistantDownloadSDKClient != null) {
        locala.field_filePath = paramTMAssistantDownloadSDKClient.mSavePath;
      }
      com.tencent.mm.plugin.downloader.model.d.e(locala);
      AppMethodBeat.o(2496);
      return;
      locala.field_finishTime = System.currentTimeMillis();
      locala.field_status = 2;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
      this.kZJ.cancelNotification(paramString1);
      this.kZJ.kZF.remove(Long.valueOf(locala.field_downloadId));
      this.kZJ.kYw.iG(locala.field_downloadId);
      AppMethodBeat.o(2496);
      return;
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
      locala.field_status = 6;
      locala.field_finishTime = System.currentTimeMillis();
      locala.field_downloadedSize = locala.field_totalSize;
      if (paramTMAssistantDownloadSDKClient != null) {
        locala.field_filePath = paramTMAssistantDownloadSDKClient.mSavePath;
      }
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(locala.field_downloadedSize), Long.valueOf(locala.field_startSize) });
      com.tencent.mm.plugin.downloader.model.d.e(locala);
      this.kZJ.kYw.iI(locala.field_downloadId);
      if (paramBoolean2)
      {
        paramTMAssistantDownloadSDKClient = new hd();
        paramTMAssistantDownloadSDKClient.cwe.appId = locala.field_appId;
        paramTMAssistantDownloadSDKClient.cwe.opType = 6;
        com.tencent.mm.sdk.b.a.ymk.l(paramTMAssistantDownloadSDKClient);
      }
      paramTMAssistantDownloadSDKClient = new Intent();
      paramTMAssistantDownloadSDKClient.putExtra(FileDownloadService.kYT, 1);
      paramTMAssistantDownloadSDKClient.setClass(this.kZJ.mContext, FileDownloadService.class);
      paramTMAssistantDownloadSDKClient.putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
      paramTMAssistantDownloadSDKClient.putExtra(FileDownloadService.kYW, paramBoolean1);
      try
      {
        com.tencent.mm.bq.d.aG(paramTMAssistantDownloadSDKClient);
        this.kZJ.cancelNotification(paramString1);
        this.kZJ.kZF.remove(Long.valueOf(locala.field_downloadId));
        AppMethodBeat.o(2496);
        return;
      }
      catch (Exception paramTMAssistantDownloadSDKClient)
      {
        for (;;)
        {
          ab.e("MicroMsg.FileDownloaderImplTMAssistant", paramTMAssistantDownloadSDKClient.getMessage());
        }
      }
      if ((paramInt2 == 601) || (paramInt2 == 602) || (paramInt2 == 603) || (paramInt2 == 605) || (paramInt2 == 606))
      {
        ab.d("MicroMsg.FileDownloaderImplTMAssistant", "releaseTimer 4 min");
        this.kZJ.kZH.ag(240000L, 240000L);
      }
      if ((at.isWifi(ah.getContext())) && (locala.field_downloadInWifi))
      {
        locala.field_downloadInWifi = false;
        locala.field_reserveInWifi = false;
      }
      a.a(this.kZJ, paramString1, paramInt1, 0, false);
      this.kZJ.kZF.remove(Long.valueOf(locala.field_downloadId));
      locala.field_finishTime = System.currentTimeMillis();
      locala.field_errCode = paramInt2;
      locala.field_status = 4;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
      this.kZJ.kYw.d(locala.field_downloadId, paramInt2, paramBoolean1);
    }
  }
  
  public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient)
  {
    AppMethodBeat.i(2495);
    ab.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
    paramTMAssistantDownloadSDKClient = this.kZJ.kZF.iterator();
    while (paramTMAssistantDownloadSDKClient.hasNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(((Long)paramTMAssistantDownloadSDKClient.next()).longValue());
      if (locala != null)
      {
        locala.field_finishTime = System.currentTimeMillis();
        locala.field_status = 4;
        locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVl;
        com.tencent.mm.plugin.downloader.model.d.e(locala);
        this.kZJ.kYw.d(locala.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kVl, false);
        a.a(this.kZJ, locala.field_downloadUrl, 5, 0, false);
      }
    }
    this.kZJ.kZF.clear();
    AppMethodBeat.o(2495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a.5
 * JD-Core Version:    0.7.0.1
 */