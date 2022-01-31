package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

final class a$3
  implements Runnable
{
  a$3(a parama, long paramLong) {}
  
  public final void run()
  {
    FileDownloadTaskInfo localFileDownloadTaskInfo = this.iOY.dd(this.iPa);
    if (localFileDownloadTaskInfo == null) {}
    com.tencent.mm.plugin.downloader.f.a locala;
    do
    {
      do
      {
        return;
        com.tencent.mm.plugin.cdndownloader.d.a.aDw().zg(localFileDownloadTaskInfo.url);
        a.a(this.iOY, localFileDownloadTaskInfo.url);
        e.deleteFile(localFileDownloadTaskInfo.path);
        y.i("MicroMsg.FileCDNDownloader", "removeDownloadTask, delete file, path: %s", new Object[] { localFileDownloadTaskInfo.path });
      } while (localFileDownloadTaskInfo.status == 5);
      locala = c.dk(this.iPa);
    } while (locala == null);
    locala.field_finishTime = System.currentTimeMillis();
    locala.field_downloadedSize = localFileDownloadTaskInfo.iPM;
    locala.field_status = 5;
    c.d(locala);
    Long localLong = Long.valueOf(bk.a((Long)a.b(this.iOY).get(localFileDownloadTaskInfo.url), locala.field_startTime));
    if (localLong != null)
    {
      long l1 = bk.a((Long)a.a(this.iOY).get(localFileDownloadTaskInfo.url), locala.field_startSize);
      long l2 = System.currentTimeMillis();
      long l3 = localLong.longValue();
      float f = (float)(localFileDownloadTaskInfo.iPM - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
      int i = (int)((float)localFileDownloadTaskInfo.iPM / (float)localFileDownloadTaskInfo.hFz * 100.0F);
      com.tencent.mm.plugin.downloader.h.b.a(this.iPa, f, i);
    }
    a.a(this.iOY).remove(localFileDownloadTaskInfo.url);
    a.b(this.iOY).remove(localFileDownloadTaskInfo.url);
    this.iOY.iPn.dg(this.iPa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a.3
 * JD-Core Version:    0.7.0.1
 */