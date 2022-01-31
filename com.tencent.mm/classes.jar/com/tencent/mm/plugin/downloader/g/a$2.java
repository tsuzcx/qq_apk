package com.tencent.mm.plugin.downloader.g;

import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import java.util.HashMap;
import java.util.HashSet;

final class a$2
  implements Runnable
{
  a$2(a parama, long paramLong) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(this.iPa);
    if (locala == null) {}
    for (;;)
    {
      return;
      try
      {
        a.a(this.iRl).cancelDownloadTask(locala.field_downloadUrl);
        e.deleteFile(locala.field_filePath);
        y.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask, delete file, path: %s", new Object[] { locala.field_filePath });
        this.iRl.iRh.remove(Long.valueOf(locala.field_downloadId));
        this.iRl.cancelNotification(locala.field_downloadUrl);
        y.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: status = " + locala.field_status);
        if (locala.field_status != 5)
        {
          locala.field_status = 5;
          locala.field_finishTime = System.currentTimeMillis();
          c.d(locala);
          long l1 = bk.a((Long)this.iRl.iOX.get(locala.field_downloadUrl), locala.field_startTime);
          long l2 = bk.a((Long)this.iRl.iOW.get(locala.field_downloadUrl), locala.field_startSize);
          long l3 = System.currentTimeMillis();
          int i = (int)((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F);
          float f = (float)(locala.field_downloadedSize - l2) * 1000.0F / (float)(l3 - l1) / 1048576.0F;
          com.tencent.mm.plugin.downloader.h.b.a(locala.field_downloadId, f, i);
          this.iRl.iPn.dg(locala.field_downloadId);
          y.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: id: %d, path: %s", new Object[] { Long.valueOf(this.iPa), locala.field_filePath });
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant remove task failed: " + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a.2
 * JD-Core Version:    0.7.0.1
 */