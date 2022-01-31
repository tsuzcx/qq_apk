package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class b$2
  implements Runnable
{
  b$2(b paramb, com.tencent.mm.plugin.downloader.g.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(2356);
    com.tencent.mm.plugin.downloader.a.c.h(this.kYh.field_appId, new String[] { this.kYh.field_downloadUrl, this.kYh.field_secondaryUrl });
    com.tencent.mm.plugin.s.a.cae();
    m.alw(this.kYh.field_appId);
    Object localObject = b.c(this.kYh);
    int i = com.tencent.mm.plugin.cdndownloader.d.a.bfT().a((CDNTaskInfo)localObject);
    ab.i("MicroMsg.FileCDNDownloader", "addDownloadTask: ret = %d, downloadId = %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.kYh.field_downloadId) });
    if (i == 0)
    {
      this.kYh.field_status = 1;
      this.kYh.field_startTime = System.currentTimeMillis();
      d.d(this.kYh);
      this.kYg.kYw.j(this.kYh.field_downloadId, this.kYh.field_filePath);
      b.a(this.kYg, this.kYh.field_downloadUrl, 1, 0, true);
      AppMethodBeat.o(2356);
      return;
    }
    if (i == -2)
    {
      this.kYh.field_status = 1;
      this.kYh.field_startTime = System.currentTimeMillis();
      d.d(this.kYh);
      AppMethodBeat.o(2356);
      return;
    }
    if (i == 1)
    {
      this.kYh.field_status = 6;
      localObject = this.kYh;
      com.tencent.mm.plugin.downloader.g.a locala1 = this.kYh;
      com.tencent.mm.plugin.downloader.g.a locala2 = this.kYh;
      long l = e.avI(this.kYh.field_filePath);
      locala2.field_totalSize = l;
      locala1.field_downloadedSize = l;
      ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startSize = l;
      localObject = this.kYh;
      locala1 = this.kYh;
      l = System.currentTimeMillis();
      locala1.field_finishTime = l;
      ((com.tencent.mm.plugin.downloader.g.a)localObject).field_startTime = l;
      d.d(this.kYh);
      this.kYg.kYw.iI(this.kYh.field_downloadId);
      localObject = new Intent();
      ((Intent)localObject).putExtra(FileDownloadService.kYT, 1);
      ((Intent)localObject).setClass(b.c(this.kYg), FileDownloadService.class);
      ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, this.kYh.field_downloadId);
      try
      {
        com.tencent.mm.bq.d.aG((Intent)localObject);
        AppMethodBeat.o(2356);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.FileCDNDownloader", localException.getMessage());
        AppMethodBeat.o(2356);
        return;
      }
    }
    this.kYh.field_status = 4;
    this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVp;
    d.d(this.kYh);
    this.kYg.kYw.d(this.kYh.field_downloadId, this.kYh.field_errCode, false);
    AppMethodBeat.o(2356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.2
 * JD-Core Version:    0.7.0.1
 */