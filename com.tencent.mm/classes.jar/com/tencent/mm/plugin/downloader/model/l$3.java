package com.tencent.mm.plugin.downloader.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class l$3
  implements Runnable
{
  l$3(l paraml, com.tencent.mm.plugin.downloader.g.a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2467);
    int i = CdnLogic.resumeHttpMultiSocketDownloadTask(this.kYh.field_downloadUrl);
    ab.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: ".concat(String.valueOf(i)));
    this.kYh.field_startTime = System.currentTimeMillis();
    this.kYh.field_startState = b.kVC;
    this.kYh.field_startSize = this.kYh.field_downloadedSize;
    if (i == 0)
    {
      this.kYh.field_status = 1;
      this.kYh.field_errCode = 0;
      d.e(this.kYh);
      this.kZg.kYw.k(this.kYi, this.kYh.field_filePath);
      AppMethodBeat.o(2467);
      return;
    }
    this.kYh.field_status = 4;
    this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVq;
    d.e(this.kYh);
    this.kZg.kYw.d(this.kYi, this.kYh.field_errCode, false);
    AppMethodBeat.o(2467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.l.3
 * JD-Core Version:    0.7.0.1
 */