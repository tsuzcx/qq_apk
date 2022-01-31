package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class a$2
  implements Runnable
{
  a$2(a parama, com.tencent.mm.plugin.downloader.f.a parama1) {}
  
  public final void run()
  {
    Object localObject = a.b(this.iOZ);
    int i = com.tencent.mm.plugin.cdndownloader.d.a.aDw().a((CDNTaskInfo)localObject);
    y.i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.iOZ.field_downloadId) });
    if (i == 0)
    {
      this.iOZ.field_status = 1;
      this.iOZ.field_startTime = System.currentTimeMillis();
      c.c(this.iOZ);
      this.iOY.iPn.l(this.iOZ.field_downloadId, this.iOZ.field_filePath);
      a.a(this.iOY, this.iOZ.field_downloadUrl, 1, 0, true);
      return;
    }
    if (i == -2)
    {
      this.iOZ.field_status = 1;
      this.iOZ.field_startTime = System.currentTimeMillis();
      c.c(this.iOZ);
      return;
    }
    if (i == 1)
    {
      this.iOZ.field_status = 6;
      localObject = this.iOZ;
      com.tencent.mm.plugin.downloader.f.a locala1 = this.iOZ;
      com.tencent.mm.plugin.downloader.f.a locala2 = this.iOZ;
      long l = e.aeQ(this.iOZ.field_filePath);
      locala2.field_totalSize = l;
      locala1.field_downloadedSize = l;
      ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startSize = l;
      localObject = this.iOZ;
      locala1 = this.iOZ;
      l = System.currentTimeMillis();
      locala1.field_finishTime = l;
      ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startTime = l;
      c.c(this.iOZ);
      this.iOY.iPn.dj(this.iOZ.field_downloadId);
      localObject = new Intent();
      ((Intent)localObject).putExtra(FileDownloadService.iPI, 1);
      ((Intent)localObject).setClass(a.c(this.iOY), FileDownloadService.class);
      ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, this.iOZ.field_downloadId);
      try
      {
        a.c(this.iOY).startService((Intent)localObject);
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.FileCDNDownloader", localException.getMessage());
        return;
      }
    }
    this.iOZ.field_status = 4;
    this.iOZ.field_errCode = com.tencent.mm.plugin.downloader.a.a.iOj;
    c.c(this.iOZ);
    this.iOY.iPn.c(this.iOZ.field_downloadId, this.iOZ.field_errCode, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a.2
 * JD-Core Version:    0.7.0.1
 */