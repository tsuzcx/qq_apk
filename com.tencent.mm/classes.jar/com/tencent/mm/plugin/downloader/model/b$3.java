package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

final class b$3
  implements Runnable
{
  b$3(b paramb, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2357);
    FileDownloadTaskInfo localFileDownloadTaskInfo = this.kYg.iA(this.kYi);
    if (localFileDownloadTaskInfo == null)
    {
      AppMethodBeat.o(2357);
      return;
    }
    com.tencent.mm.plugin.cdndownloader.d.a.bfT().IP(localFileDownloadTaskInfo.url);
    b.a(this.kYg, localFileDownloadTaskInfo.url);
    e.deleteFile(localFileDownloadTaskInfo.path);
    ab.i("MicroMsg.FileCDNDownloader", "removeDownloadTask, delete file, path: %s", new Object[] { localFileDownloadTaskInfo.path });
    if (localFileDownloadTaskInfo.status != 5)
    {
      com.tencent.mm.plugin.downloader.g.a locala = d.iJ(this.kYi);
      if (locala == null)
      {
        AppMethodBeat.o(2357);
        return;
      }
      locala.field_finishTime = System.currentTimeMillis();
      locala.field_downloadedSize = localFileDownloadTaskInfo.kYX;
      locala.field_status = 5;
      d.e(locala);
      Long localLong = Long.valueOf(bo.a((Long)b.b(this.kYg).get(localFileDownloadTaskInfo.url), locala.field_startTime));
      if (localLong != null)
      {
        long l1 = bo.a((Long)b.a(this.kYg).get(localFileDownloadTaskInfo.url), locala.field_startSize);
        long l2 = System.currentTimeMillis();
        long l3 = localLong.longValue();
        float f = (float)(localFileDownloadTaskInfo.kYX - Long.valueOf(l1).longValue()) * 1000.0F / (float)(l2 - l3) / 1048576.0F;
        int i = (int)((float)localFileDownloadTaskInfo.kYX / (float)localFileDownloadTaskInfo.jyU * 100.0F);
        com.tencent.mm.plugin.downloader.i.b.a(this.kYi, f, i);
      }
      b.a(this.kYg).remove(localFileDownloadTaskInfo.url);
      b.b(this.kYg).remove(localFileDownloadTaskInfo.url);
      this.kYg.kYw.iF(this.kYi);
    }
    AppMethodBeat.o(2357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.3
 * JD-Core Version:    0.7.0.1
 */