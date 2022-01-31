package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CopyOnWriteArraySet;

final class g$1
  implements Runnable
{
  g$1(g paramg, e parame, com.tencent.mm.plugin.downloader.f.a parama) {}
  
  public final void run()
  {
    if (this.iPR.iPz)
    {
      String str = f.zS(this.iOZ.field_downloadUrl);
      this.iOZ.field_md5 = str;
    }
    long l = this.iPS.f(this.iOZ);
    if (l > 0L)
    {
      this.iOZ.field_sysDownloadId = l;
      this.iOZ.field_status = 1;
      c.d(this.iOZ);
      this.iPS.iPn.l(this.iOZ.field_downloadId, this.iOZ.field_filePath);
      d.aFP();
      if (d.dm(this.iOZ.field_downloadId))
      {
        d.aFP();
        d.w(this.iOZ.field_downloadId, l);
      }
      this.iPS.iPQ.add(Long.valueOf(this.iOZ.field_downloadId));
      if (this.iPS.fjC.crl()) {
        this.iPS.fjC.S(100L, 100L);
      }
      y.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", new Object[] { Long.valueOf(this.iOZ.field_downloadId), this.iOZ.field_downloadUrl, this.iOZ.field_filePath });
      return;
    }
    this.iOZ.field_status = 4;
    c.d(this.iOZ);
    this.iPS.iPn.c(this.iOZ.field_downloadId, com.tencent.mm.plugin.downloader.a.a.iOu, false);
    y.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g.1
 * JD-Core Version:    0.7.0.1
 */