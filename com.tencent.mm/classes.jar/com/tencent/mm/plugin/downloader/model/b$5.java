package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;

final class b$5
  implements Runnable
{
  b$5(b paramb, com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2359);
    com.tencent.mm.plugin.downloader.a.c.h(this.kYh.field_appId, new String[] { this.kYh.field_downloadUrl, this.kYh.field_secondaryUrl });
    com.tencent.mm.plugin.s.a.cae();
    m.alw(this.kYh.field_appId);
    int i = com.tencent.mm.plugin.cdndownloader.d.a.bfT().b(b.c(this.kYh));
    ab.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: ".concat(String.valueOf(i)));
    this.kYh.field_startTime = System.currentTimeMillis();
    this.kYh.field_startSize = this.kYh.field_downloadedSize;
    this.kYh.field_startState = com.tencent.mm.plugin.downloader.a.b.kVC;
    long l;
    if (i == 0)
    {
      this.kYh.field_status = 1;
      this.kYh.field_errCode = 0;
      d.e(this.kYh);
      if (this.kYj) {
        this.kYg.kYw.k(this.kYi, this.kYh.field_filePath);
      }
      l = 0L;
      if (this.kYh.field_totalSize != 0L) {
        l = this.kYh.field_downloadedSize * 100L / this.kYh.field_totalSize;
      }
      ab.d("MicroMsg.FileCDNDownloader", "resumeDownloadTask, progress = %d, downloadedSize = %d, totalSize = %d", new Object[] { Long.valueOf(l), Long.valueOf(this.kYh.field_downloadedSize), Long.valueOf(this.kYh.field_totalSize) });
      b.a(this.kYg, this.kYh.field_downloadUrl, 1, (int)l, true);
      AppMethodBeat.o(2359);
      return;
    }
    if (i == -2)
    {
      this.kYh.field_status = 1;
      this.kYh.field_errCode = 0;
      d.e(this.kYh);
      AppMethodBeat.o(2359);
      return;
    }
    if (i == 1)
    {
      if ((this.kYh.field_status == 6) || (this.kYh.field_status == 3))
      {
        AppMethodBeat.o(2359);
        return;
      }
      this.kYh.field_status = 6;
      Object localObject = this.kYh;
      com.tencent.mm.plugin.downloader.g.a locala = this.kYh;
      l = this.kYh.field_totalSize;
      locala.field_downloadedSize = l;
      ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startSize = l;
      localObject = this.kYh;
      locala = this.kYh;
      l = System.currentTimeMillis();
      locala.field_finishTime = l;
      ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startTime = l;
      d.e(this.kYh);
      this.kYg.kYw.iI(this.kYh.field_downloadId);
      localObject = new Intent();
      ((Intent)localObject).putExtra(FileDownloadService.kYT, 1);
      ((Intent)localObject).setClass(b.c(this.kYg), FileDownloadService.class);
      ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, this.kYh.field_downloadId);
      try
      {
        com.tencent.mm.bq.d.aG((Intent)localObject);
        AppMethodBeat.o(2359);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.FileCDNDownloader", localException.getMessage());
        AppMethodBeat.o(2359);
        return;
      }
    }
    this.kYh.field_status = 4;
    this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVq;
    d.e(this.kYh);
    this.kYg.kYw.d(this.kYi, this.kYh.field_errCode, false);
    AppMethodBeat.o(2359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.5
 * JD-Core Version:    0.7.0.1
 */