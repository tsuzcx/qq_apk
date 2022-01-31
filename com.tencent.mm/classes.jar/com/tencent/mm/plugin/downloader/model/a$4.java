package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class a$4
  implements Runnable
{
  a$4(a parama, long paramLong) {}
  
  public final void run()
  {
    y.i("MicroMsg.FileCDNDownloader", "pauseDownloadTask");
    FileDownloadTaskInfo localFileDownloadTaskInfo = this.iOY.dd(this.iPa);
    if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status == 1))
    {
      com.tencent.mm.plugin.cdndownloader.d.a.aDw().zf(localFileDownloadTaskInfo.url);
      a.a(this.iOY, localFileDownloadTaskInfo.url);
      com.tencent.mm.plugin.downloader.f.a locala = c.dk(this.iPa);
      if (locala != null)
      {
        locala.field_finishTime = System.currentTimeMillis();
        locala.field_status = 2;
        locala.field_downloadedSize = localFileDownloadTaskInfo.iPM;
        c.d(locala);
        Long localLong = Long.valueOf(bk.a((Long)a.b(this.iOY).get(localFileDownloadTaskInfo.url), locala.field_startTime));
        if (localLong != null)
        {
          long l1 = bk.a((Long)a.a(this.iOY).get(localFileDownloadTaskInfo.url), locala.field_startSize);
          long l2 = System.currentTimeMillis();
          long l3 = localLong.longValue();
          float f = (float)(locala.field_downloadedSize - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
          int i = (int)((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F);
          com.tencent.mm.plugin.downloader.h.b.a(locala.field_downloadId, f, i);
        }
      }
      a.a(this.iOY).remove(localFileDownloadTaskInfo.url);
      a.b(this.iOY).remove(localFileDownloadTaskInfo.url);
      this.iOY.iPn.dh(this.iPa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a.4
 * JD-Core Version:    0.7.0.1
 */