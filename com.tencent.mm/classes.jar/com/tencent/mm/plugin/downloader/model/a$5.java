package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class a$5
  implements Runnable
{
  a$5(a parama, com.tencent.mm.plugin.downloader.f.a parama1, boolean paramBoolean, long paramLong) {}
  
  public final void run()
  {
    long l = 0L;
    int i = com.tencent.mm.plugin.cdndownloader.d.a.aDw().b(a.b(this.iOZ));
    y.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: " + i);
    this.iOZ.field_startTime = System.currentTimeMillis();
    this.iOZ.field_startSize = this.iOZ.field_downloadedSize;
    this.iOZ.field_startState = com.tencent.mm.plugin.downloader.a.b.iOw;
    if (i == 0)
    {
      this.iOZ.field_status = 1;
      this.iOZ.field_errCode = 0;
      c.d(this.iOZ);
      if (this.iPb) {
        this.iOY.iPn.m(this.iPa, this.iOZ.field_filePath);
      }
      if (this.iOZ.field_totalSize != 0L) {
        l = this.iOZ.field_downloadedSize * 100L / this.iOZ.field_totalSize;
      }
      y.d("MicroMsg.FileCDNDownloader", "resumeDownloadTask, progress = %d, downloadedSize = %d, totalSize = %d", new Object[] { Long.valueOf(l), Long.valueOf(this.iOZ.field_downloadedSize), Long.valueOf(this.iOZ.field_totalSize) });
      a.a(this.iOY, this.iOZ.field_downloadUrl, 1, (int)l, true);
    }
    do
    {
      return;
      if (i == -2)
      {
        this.iOZ.field_status = 1;
        this.iOZ.field_errCode = 0;
        c.d(this.iOZ);
        return;
      }
      if (i != 1) {
        break;
      }
    } while ((this.iOZ.field_status == 6) || (this.iOZ.field_status == 3));
    this.iOZ.field_status = 6;
    Object localObject = this.iOZ;
    com.tencent.mm.plugin.downloader.f.a locala = this.iOZ;
    l = this.iOZ.field_totalSize;
    locala.field_downloadedSize = l;
    ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startSize = l;
    localObject = this.iOZ;
    locala = this.iOZ;
    l = System.currentTimeMillis();
    locala.field_finishTime = l;
    ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startTime = l;
    c.d(this.iOZ);
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
    this.iOZ.field_status = 4;
    this.iOZ.field_errCode = com.tencent.mm.plugin.downloader.a.a.iOk;
    c.d(this.iOZ);
    this.iOY.iPn.c(this.iPa, this.iOZ.field_errCode, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a.5
 * JD-Core Version:    0.7.0.1
 */