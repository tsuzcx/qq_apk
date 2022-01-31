package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class b$1
  implements com.tencent.mm.plugin.cdndownloader.d.b
{
  b$1(b paramb) {}
  
  public final void f(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(2354);
    a locala = d.JG(paramString1);
    if (locala == null)
    {
      h.qsU.idkeyStat(710L, 18L, 1L, false);
      ab.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
      AppMethodBeat.o(2354);
      return;
    }
    ab.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2354);
      return;
      locala.field_status = 1;
      d.e(locala);
      AppMethodBeat.o(2354);
      return;
      locala.field_finishTime = System.currentTimeMillis();
      locala.field_errCode = Math.abs(paramInt2);
      locala.field_status = 4;
      if ((at.isWifi(ah.getContext())) && (locala.field_downloadInWifi))
      {
        locala.field_downloadInWifi = false;
        locala.field_reserveInWifi = false;
      }
      d.e(locala);
      this.kYg.kYw.d(locala.field_downloadId, Math.abs(paramInt2), false);
      b.a(this.kYg, locala.field_downloadUrl, 4, 0, false);
      b.a(this.kYg).remove(locala.field_downloadUrl);
      b.b(this.kYg).remove(locala.field_downloadUrl);
      AppMethodBeat.o(2354);
      return;
      locala.field_finishTime = System.currentTimeMillis();
      locala.field_downloadedSize = locala.field_totalSize;
      locala.field_status = 6;
      ab.i("MicroMsg.FileCDNDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(locala.field_downloadedSize), Long.valueOf(locala.field_startSize) });
      d.e(locala);
      this.kYg.kYw.iI(locala.field_downloadId);
      paramString1 = new Intent();
      paramString1.putExtra(FileDownloadService.kYT, 1);
      paramString1.setClass(b.c(this.kYg), FileDownloadService.class);
      paramString1.putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
      try
      {
        com.tencent.mm.bq.d.aG(paramString1);
        b.a(this.kYg, locala.field_downloadUrl);
        b.a(this.kYg).remove(locala.field_downloadUrl);
        b.b(this.kYg).remove(locala.field_downloadUrl);
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ab.e("MicroMsg.FileCDNDownloader", paramString1.getMessage());
        }
      }
    }
  }
  
  public final void t(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(2355);
    ab.d("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = %d, receiveDataLen = %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
    a locala = d.JG(paramString);
    if (locala == null)
    {
      ab.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
      AppMethodBeat.o(2355);
      return;
    }
    if ((locala.field_downloadInWifi) && (!at.isWifi(ah.getContext()))) {
      this.kYg.iE(locala.field_downloadId);
    }
    Long localLong = Long.valueOf(bo.c((Long)b.a(this.kYg).get(locala.field_downloadUrl)));
    paramString = localLong;
    if (localLong.longValue() == 0L)
    {
      paramString = Long.valueOf(paramLong1);
      b.a(this.kYg).put(locala.field_downloadUrl, Long.valueOf(paramLong1));
    }
    long l1 = paramLong1 - paramString.longValue();
    if (paramLong2 == 0L) {
      ab.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = 0");
    }
    for (;;)
    {
      paramString = Long.valueOf(bo.c((Long)b.d(this.kYg).get(locala.field_downloadUrl)));
      localLong = Long.valueOf(System.currentTimeMillis());
      l1 = localLong.longValue() - paramString.longValue();
      if ((paramString == null) || (l1 <= 0L) || (l1 >= 500L)) {
        break;
      }
      AppMethodBeat.o(2355);
      return;
      long l2 = 100L * l1 / paramLong2;
      i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
      if (l2 >= 1L)
      {
        long l3 = bo.a((Long)b.b(this.kYg).get(locala.field_downloadUrl), locala.field_startTime);
        l2 = System.currentTimeMillis();
        l3 = l2 - l3;
        float f = (float)l1 * 1000.0F / (float)l3 / 1048576.0F;
        ab.d("MicroMsg.FileCDNDownloader", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d, totalPercent = %d", new Object[] { locala.field_appId, Float.valueOf(f), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(paramLong2), Integer.valueOf(i) });
        com.tencent.mm.plugin.downloader.i.b.a(locala.field_downloadId, f, i);
        b.b(this.kYg).put(locala.field_downloadUrl, Long.valueOf(l2));
        b.a(this.kYg).put(locala.field_downloadUrl, Long.valueOf(paramLong1));
      }
    }
    b.d(this.kYg).put(locala.field_downloadUrl, localLong);
    locala.field_downloadedSize = paramLong1;
    locala.field_totalSize = paramLong2;
    d.e(locala);
    this.kYg.kYw.iH(locala.field_downloadId);
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
      b.a(this.kYg, locala.field_downloadUrl, 1, j, false);
      AppMethodBeat.o(2355);
      return;
      j = i;
      if (i > 100) {
        j = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.1
 * JD-Core Version:    0.7.0.1
 */