package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class a$1
  implements com.tencent.mm.plugin.cdndownloader.d.b
{
  a$1(a parama) {}
  
  public final void f(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.zK(paramString1);
    if (locala == null)
    {
      h.nFQ.a(710L, 18L, 1L, false);
      y.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
      return;
    }
    y.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    switch (paramInt1)
    {
    case 2: 
    default: 
      return;
    case 1: 
      locala.field_status = 1;
      c.d(locala);
      return;
    case 4: 
      locala.field_finishTime = System.currentTimeMillis();
      locala.field_errCode = Math.abs(paramInt2);
      locala.field_status = 4;
      if ((aq.isWifi(ae.getContext())) && (locala.field_downloadInWifi)) {
        locala.field_downloadInWifi = false;
      }
      c.d(locala);
      this.iOY.iPn.c(locala.field_downloadId, Math.abs(paramInt2), false);
      a.a(this.iOY, locala.field_downloadUrl, 4, 0, false);
      a.a(this.iOY).remove(locala.field_downloadUrl);
      a.b(this.iOY).remove(locala.field_downloadUrl);
      return;
    }
    locala.field_finishTime = System.currentTimeMillis();
    locala.field_downloadedSize = locala.field_totalSize;
    locala.field_status = 6;
    y.i("MicroMsg.FileCDNDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(locala.field_downloadedSize), Long.valueOf(locala.field_startSize) });
    c.d(locala);
    this.iOY.iPn.dj(locala.field_downloadId);
    paramString1 = new Intent();
    paramString1.putExtra(FileDownloadService.iPI, 1);
    paramString1.setClass(a.c(this.iOY), FileDownloadService.class);
    paramString1.putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
    try
    {
      a.c(this.iOY).startService(paramString1);
      a.a(this.iOY, locala.field_downloadUrl);
      a.a(this.iOY).remove(locala.field_downloadUrl);
      a.b(this.iOY).remove(locala.field_downloadUrl);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.FileCDNDownloader", paramString1.getMessage());
      }
    }
  }
  
  public final void m(String paramString, long paramLong1, long paramLong2)
  {
    y.d("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = %d, receiveDataLen = %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
    com.tencent.mm.plugin.downloader.f.a locala = c.zK(paramString);
    if (locala == null) {
      y.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
    }
    Long localLong;
    long l1;
    long l2;
    do
    {
      return;
      if ((locala.field_downloadInWifi) && (!aq.isWifi(ae.getContext()))) {
        this.iOY.iH(locala.field_downloadId);
      }
      localLong = Long.valueOf(bk.c((Long)a.a(this.iOY).get(locala.field_downloadUrl)));
      paramString = localLong;
      if (localLong.longValue() == 0L)
      {
        paramString = Long.valueOf(paramLong1);
        a.a(this.iOY).put(locala.field_downloadUrl, Long.valueOf(paramLong1));
      }
      l1 = paramLong1 - paramString.longValue();
      if (paramLong2 != 0L) {
        break;
      }
      y.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = 0");
      paramString = Long.valueOf(bk.c((Long)a.d(this.iOY).get(locala.field_downloadUrl)));
      localLong = Long.valueOf(System.currentTimeMillis());
      l1 = localLong.longValue();
      l2 = paramString.longValue();
    } while ((paramString != null) && (l1 - l2 < 500L));
    a.d(this.iOY).put(locala.field_downloadUrl, localLong);
    locala.field_downloadedSize = paramLong1;
    locala.field_totalSize = paramLong2;
    c.d(locala);
    this.iOY.iPn.di(locala.field_downloadId);
    int i = 0;
    if (paramLong2 > 0L) {
      i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
    }
    int j;
    if (i < 0) {
      j = 0;
    }
    for (;;)
    {
      a.a(this.iOY, locala.field_downloadUrl, 1, j, false);
      return;
      l2 = 100L * l1 / paramLong2;
      i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
      if (l2 < 1L) {
        break;
      }
      long l3 = bk.a((Long)a.b(this.iOY).get(locala.field_downloadUrl), locala.field_startTime);
      l2 = System.currentTimeMillis();
      l3 = l2 - l3;
      float f = (float)l1 * 1000.0F / (float)l3 / 1048576.0F;
      y.d("MicroMsg.FileCDNDownloader", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d, totalPercent = %d", new Object[] { locala.field_appId, Float.valueOf(f), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(paramLong2), Integer.valueOf(i) });
      com.tencent.mm.plugin.downloader.h.b.a(locala.field_downloadId, f, i);
      a.b(this.iOY).put(locala.field_downloadUrl, Long.valueOf(l2));
      a.a(this.iOY).put(locala.field_downloadUrl, Long.valueOf(paramLong1));
      break;
      j = i;
      if (i > 100) {
        j = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a.1
 * JD-Core Version:    0.7.0.1
 */