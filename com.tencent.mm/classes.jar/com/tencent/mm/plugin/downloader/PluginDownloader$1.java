package com.tencent.mm.plugin.downloader;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class PluginDownloader$1
  implements Runnable
{
  PluginDownloader$1(PluginDownloader paramPluginDownloader) {}
  
  public final void run()
  {
    Object localObject1 = c.FC();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!bk.dk((List)localObject1)) {
        localObject1 = ((LinkedList)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        Object localObject4;
        long l;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            return;
          }
          Object localObject2 = (com.tencent.mm.plugin.downloader.f.a)((Iterator)localObject1).next();
          localObject4 = d.aFP().dd(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId);
          if (((FileDownloadTaskInfo)localObject4).status == 3)
          {
            y.i("MicroMsg.PluginDownloader", "has download finish");
            ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_finishTime = System.currentTimeMillis();
            ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadedSize = ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_totalSize;
            ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_status = 6;
            y.i("MicroMsg.PluginDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadedSize), Long.valueOf(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_startSize) });
            c.d((com.tencent.mm.plugin.downloader.f.a)localObject2);
            localObject4 = d.aFP();
            l = ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId;
            if (((d)localObject4).iPn != null) {
              ((d)localObject4).iPn.dj(l);
            }
            localObject4 = new Intent();
            ((Intent)localObject4).putExtra(FileDownloadService.iPI, 1);
            ((Intent)localObject4).setClass(ae.getContext(), FileDownloadService.class);
            ((Intent)localObject4).putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId);
            try
            {
              ae.getContext().startService((Intent)localObject4);
              h.nFQ.a(710L, 12L, 1L, false);
              continue;
              y.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
              localObject2 = ((com.tencent.mm.plugin.downloader.f.b)localObject1).rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
              if (localObject2 == null)
              {
                y.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
                localObject1 = null;
                break;
              }
              localObject1 = new LinkedList();
              while (((Cursor)localObject2).moveToNext())
              {
                localObject4 = new com.tencent.mm.plugin.downloader.f.a();
                ((com.tencent.mm.plugin.downloader.f.a)localObject4).d((Cursor)localObject2);
                ((LinkedList)localObject1).add(localObject4);
              }
              ((Cursor)localObject2).close();
            }
            catch (Exception localException)
            {
              for (;;)
              {
                y.e("MicroMsg.PluginDownloader", localException.getMessage());
              }
            }
          }
        }
        Object localObject3;
        if (((FileDownloadTaskInfo)localObject4).status != 1)
        {
          h.nFQ.a(710L, 14L, 1L, false);
          y.i("MicroMsg.PluginDownloader", "download fail, all process dead, appId: " + localException.field_appId);
          l = (System.currentTimeMillis() - localException.field_startTime) / 1000L;
          y.i("MicroMsg.PluginDownloader", "lastTime = " + l);
          if (l <= 1800L)
          {
            y.i("MicroMsg.PluginDownloader", "in half hour, restart in wifi");
            if (aq.isWifi(ae.getContext()))
            {
              y.i("MicroMsg.PluginDownloader", "in half hour, in wifi, restart");
              localObject4 = d.aFP();
              l = localException.field_downloadId;
              y.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = " + l);
              if (!d.dm(l))
              {
                localObject3 = c.dk(l);
                if ((localObject3 == null) || (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloaderType != 3)) {
                  break label581;
                }
                localObject3 = ((d)localObject4).aFU();
                y.i("MicroMsg.FileCDNDownloader", "resumeDownloadTaskWhenProcessRestart, id = " + l);
                ((com.tencent.mm.plugin.downloader.model.a)localObject3).k(l, false);
              }
              for (;;)
              {
                h.nFQ.a(710L, 15L, 1L, false);
                break;
                label581:
                localObject3 = ((d)localObject4).aFT();
                y.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTaskWhenProcessRestart, id = " + l);
                ((com.tencent.mm.plugin.downloader.g.a)localObject3).k(l, false);
              }
            }
            h.nFQ.a(710L, 17L, 1L, false);
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_finishTime = System.currentTimeMillis();
            ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status = 4;
            ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_errCode = com.tencent.mm.plugin.downloader.a.a.iOn;
            c.d((com.tencent.mm.plugin.downloader.f.a)localObject3);
            localObject4 = d.aFP();
            l = ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId;
            int i = ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_errCode;
            if (((d)localObject4).iPn == null) {
              break;
            }
            ((d)localObject4).iPn.c(l, i, false);
            break;
            h.nFQ.a(710L, 16L, 1L, false);
            if (!aq.isWifi(ae.getContext())) {
              h.nFQ.a(710L, 17L, 1L, false);
            }
          }
        }
        y.i("MicroMsg.PluginDownloader", "download process alive, still downloading: " + ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId);
        h.nFQ.a(710L, 13L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.PluginDownloader.1
 * JD-Core Version:    0.7.0.1
 */