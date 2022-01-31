package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class b$4
  implements Runnable
{
  b$4(b paramb, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2358);
    ab.i("MicroMsg.FileCDNDownloader", "pauseDownloadTask");
    FileDownloadTaskInfo localFileDownloadTaskInfo = this.kYg.iA(this.kYi);
    if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status == 1))
    {
      com.tencent.mm.plugin.cdndownloader.d.a.bfT().IO(localFileDownloadTaskInfo.url);
      b.a(this.kYg, localFileDownloadTaskInfo.url);
      com.tencent.mm.plugin.downloader.g.a locala = d.iJ(this.kYi);
      if (locala != null)
      {
        locala.field_finishTime = System.currentTimeMillis();
        locala.field_status = 2;
        locala.field_downloadedSize = localFileDownloadTaskInfo.kYX;
        d.e(locala);
        Long localLong = Long.valueOf(bo.a((Long)b.b(this.kYg).get(localFileDownloadTaskInfo.url), locala.field_startTime));
        if (localLong != null)
        {
          long l1 = bo.a((Long)b.a(this.kYg).get(localFileDownloadTaskInfo.url), locala.field_startSize);
          long l2 = System.currentTimeMillis();
          long l3 = localLong.longValue();
          float f = (float)(locala.field_downloadedSize - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
          int i = (int)((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F);
          com.tencent.mm.plugin.downloader.i.b.a(locala.field_downloadId, f, i);
        }
      }
      b.a(this.kYg).remove(localFileDownloadTaskInfo.url);
      b.b(this.kYg).remove(localFileDownloadTaskInfo.url);
      this.kYg.kYw.iG(this.kYi);
    }
    AppMethodBeat.o(2358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.4
 * JD-Core Version:    0.7.0.1
 */