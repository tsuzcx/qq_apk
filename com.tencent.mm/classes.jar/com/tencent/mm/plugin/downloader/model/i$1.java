package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.CopyOnWriteArraySet;

final class i$1
  implements Runnable
{
  i$1(i parami, g paramg, com.tencent.mm.plugin.downloader.g.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(2452);
    if (this.kZd.kYG)
    {
      String str = h.JO(this.kYh.field_downloadUrl);
      this.kYh.field_md5 = str;
    }
    long l = this.kZe.h(this.kYh);
    if (l > 0L)
    {
      this.kYh.field_sysDownloadId = l;
      this.kYh.field_status = 1;
      d.e(this.kYh);
      this.kZe.kYw.j(this.kYh.field_downloadId, this.kYh.field_filePath);
      f.bjl();
      if (f.iO(this.kYh.field_downloadId))
      {
        f.bjl();
        f.I(this.kYh.field_downloadId, l);
      }
      this.kZe.kZc.add(Long.valueOf(this.kYh.field_downloadId));
      if (this.kZe.bAz.dtj()) {
        this.kZe.bAz.ag(100L, 100L);
      }
      ab.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", new Object[] { Long.valueOf(this.kYh.field_downloadId), this.kYh.field_downloadUrl, this.kYh.field_filePath });
      AppMethodBeat.o(2452);
      return;
    }
    this.kYh.field_status = 4;
    d.e(this.kYh);
    this.kZe.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kVA, false);
    ab.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
    AppMethodBeat.o(2452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.i.1
 * JD-Core Version:    0.7.0.1
 */