package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class g$3
  implements Runnable
{
  g$3(g paramg) {}
  
  public final void run()
  {
    for (;;)
    {
      g localg;
      Long localLong;
      com.tencent.mm.plugin.downloader.f.a locala;
      try
      {
        Iterator localIterator = this.iPS.iPQ.iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          localg = this.iPS;
          localLong = Long.valueOf(l);
          y.d("MicroMsg.FileDownloaderImpl23", "updateDownloadStatus");
          locala = c.dk(localLong.longValue());
          if (locala == null) {
            continue;
          }
          localObject1 = new DownloadManager.Query();
          ((DownloadManager.Query)localObject1).setFilterById(new long[] { locala.field_sysDownloadId });
        }
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject1 = localg.iPP.query((DownloadManager.Query)localObject1);
          if (localObject1 != null) {
            break label213;
          }
          y.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
          localg.iPQ.remove(localLong);
          locala.field_status = 4;
          c.d(locala);
        }
        catch (Exception localException2)
        {
          y.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[] { localException2.toString(), localLong });
          localg.iPQ.remove(localLong);
          locala.field_status = 4;
          c.d(locala);
        }
        localException1 = localException1;
        y.e("MicroMsg.FileDownloaderImpl23", localException1.getMessage());
      }
      return;
      continue;
      label213:
      int m;
      int i;
      int j;
      int k;
      if (localException2.moveToFirst())
      {
        m = localException2.getColumnIndex("status");
        i = localException2.getColumnIndex("local_uri");
        j = localException2.getColumnIndex("bytes_so_far");
        k = localException2.getColumnIndex("total_size");
        if (m == -1) {}
      }
      try
      {
        m = localException2.getInt(m);
        y.d("MicroMsg.FileDownloaderImpl23", "status = %d", new Object[] { Integer.valueOf(m) });
        switch (m)
        {
        default: 
        case 1: 
        case 2: 
          for (;;)
          {
            localException2.close();
            break;
            if (j != -1) {
              locala.field_downloadedSize = localException2.getLong(j);
            }
            if (k != -1) {
              locala.field_totalSize = localException2.getLong(k);
            }
            locala.field_status = 1;
            c.d(locala);
            localg.iPn.di(localLong.longValue());
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          localg.iPQ.remove(localLong);
          locala.field_status = 4;
          c.d(locala);
          y.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[] { localException3.toString() });
          continue;
          localg.iPQ.remove(localLong);
          i = com.tencent.mm.plugin.downloader.a.a.iOu;
          locala.field_status = 4;
          c.d(locala);
          localg.iPn.c(localLong.longValue(), i, false);
          continue;
          localg.iPQ.remove(localLong);
          locala.field_status = 2;
          c.d(locala);
          localg.iPn.dh(localLong.longValue());
          continue;
          localg.iPQ.remove(localLong);
          if (i != -1)
          {
            if ((bk.bl(locala.field_filePath)) || (!e.bK(locala.field_filePath)))
            {
              y.e("MicroMsg.FileDownloaderImpl23", "path not exists, path = %s", new Object[] { locala.field_filePath });
              locala.field_status = 4;
              c.d(locala);
              break;
            }
            Object localObject2 = new Intent();
            ((Intent)localObject2).setClass(ae.getContext(), FileDownloadService.class);
            ((Intent)localObject2).putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
            ((Intent)localObject2).putExtra(FileDownloadService.iPI, 1);
            localObject2 = ae.getContext().startService((Intent)localObject2);
            y.d("MicroMsg.FileDownloaderImpl23", "start download service: " + ((ComponentName)localObject2).getClassName() + ", " + ((ComponentName)localObject2).getPackageName());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g.3
 * JD-Core Version:    0.7.0.1
 */