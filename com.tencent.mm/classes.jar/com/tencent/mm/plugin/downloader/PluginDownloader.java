package com.tencent.mm.plugin.downloader;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.downloader.a.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginDownloader
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, e
{
  private static j.a appForegroundListener;
  private static a kVj;
  
  static
  {
    AppMethodBeat.i(141053);
    appForegroundListener = new PluginDownloader.1();
    AppMethodBeat.o(141053);
  }
  
  private void checkMD5CheckingTasks()
  {
    AppMethodBeat.i(141051);
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.YG();
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (!bo.es((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        label27:
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
          Object localObject3 = new Intent();
          ((Intent)localObject3).putExtra(FileDownloadService.kYT, 1);
          ((Intent)localObject3).setClass(ah.getContext(), FileDownloadService.class);
          ((Intent)localObject3).putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
          try
          {
            com.tencent.mm.bq.d.aG((Intent)localObject3);
            h.qsU.idkeyStat(710L, 25L, 1L, false);
            break label27;
            ab.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=6")));
            localObject3 = ((com.tencent.mm.plugin.downloader.g.b)localObject1).rawQuery("select * from FileDownloadInfo where status=6", new String[0]);
            localObject2 = new LinkedList();
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              while (((Cursor)localObject3).moveToNext())
              {
                localObject1 = new com.tencent.mm.plugin.downloader.g.a();
                ((com.tencent.mm.plugin.downloader.g.a)localObject1).convertFrom((Cursor)localObject3);
                ((LinkedList)localObject2).add(localObject1);
              }
              ((Cursor)localObject3).close();
              localObject1 = localObject2;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.e("MicroMsg.PluginDownloader", localException.getMessage());
            }
          }
        }
      }
    }
    AppMethodBeat.o(141051);
  }
  
  private void resumeDownloadTaskWhenProcessRestart()
  {
    AppMethodBeat.i(2281);
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.YG();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!bo.es((List)localObject1)) {
        localObject1 = ((LinkedList)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        Object localObject3;
        long l;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label783;
          }
          Object localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
          localObject3 = new com.tencent.mm.plugin.downloader.f.b();
          ((com.tencent.mm.plugin.downloader.f.b)localObject3).i((com.tencent.mm.plugin.downloader.g.a)localObject2);
          com.tencent.mm.plugin.downloader.f.a.a(20, (com.tencent.mm.plugin.downloader.f.b)localObject3);
          localObject3 = com.tencent.mm.plugin.downloader.model.f.bjl().iA(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
          if (((FileDownloadTaskInfo)localObject3).status == 3)
          {
            ab.i("MicroMsg.PluginDownloader", "has download finish");
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_finishTime = System.currentTimeMillis();
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_totalSize;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 6;
            ab.i("MicroMsg.PluginDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize), Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_startSize) });
            com.tencent.mm.plugin.downloader.model.d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
            localObject3 = com.tencent.mm.plugin.downloader.model.f.bjl();
            l = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
            if (((com.tencent.mm.plugin.downloader.model.f)localObject3).kYw != null) {
              ((com.tencent.mm.plugin.downloader.model.f)localObject3).kYw.iI(l);
            }
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra(FileDownloadService.kYT, 1);
            ((Intent)localObject3).setClass(ah.getContext(), FileDownloadService.class);
            ((Intent)localObject3).putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
            try
            {
              com.tencent.mm.bq.d.aG((Intent)localObject3);
              h.qsU.idkeyStat(710L, 12L, 1L, false);
              continue;
              ab.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
              localObject2 = ((com.tencent.mm.plugin.downloader.g.b)localObject1).rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
              if (localObject2 == null)
              {
                ab.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
                localObject1 = null;
                break;
              }
              localObject1 = new LinkedList();
              while (((Cursor)localObject2).moveToNext())
              {
                localObject3 = new com.tencent.mm.plugin.downloader.g.a();
                ((com.tencent.mm.plugin.downloader.g.a)localObject3).convertFrom((Cursor)localObject2);
                ((LinkedList)localObject1).add(localObject3);
              }
              ((Cursor)localObject2).close();
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ab.e("MicroMsg.PluginDownloader", localException.getMessage());
              }
            }
          }
        }
        if (((FileDownloadTaskInfo)localObject3).status != 1)
        {
          h.qsU.idkeyStat(710L, 14L, 1L, false);
          ab.i("MicroMsg.PluginDownloader", "download fail, all process dead, appId: " + localException.field_appId);
          l = (System.currentTimeMillis() - localException.field_updateTime) / 1000L;
          ab.i("MicroMsg.PluginDownloader", "lastTime = ".concat(String.valueOf(l)));
          if (l <= 259200L)
          {
            boolean bool = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.game.report.a.b.class)).b(a.a.lRJ);
            ab.i("MicroMsg.PluginDownloader", "in half hour, net: %s, downloadInWifi: %b, expt: %b", new Object[] { at.getNetTypeString(ah.getContext()), Boolean.valueOf(((FileDownloadTaskInfo)localObject3).kYZ), Boolean.valueOf(bool) });
            if (at.isWifi(ah.getContext()))
            {
              ab.i("MicroMsg.PluginDownloader", "in half hour, in wifi, restart");
              com.tencent.mm.plugin.downloader.model.f.bjl().iD(localException.field_downloadId);
              h.qsU.idkeyStat(710L, 15L, 1L, false);
            }
            else if ((!((FileDownloadTaskInfo)localObject3).kYZ) && (bool))
            {
              ab.i("MicroMsg.PluginDownloader", "download not in wifi");
              com.tencent.mm.plugin.downloader.model.f.bjl().iD(localException.field_downloadId);
              h.qsU.idkeyStat(710L, 19L, 1L, false);
            }
            else
            {
              h.qsU.idkeyStat(710L, 17L, 1L, false);
            }
          }
          else
          {
            for (;;)
            {
              localException.field_finishTime = System.currentTimeMillis();
              localException.field_status = 4;
              localException.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVt;
              com.tencent.mm.plugin.downloader.model.d.e(localException);
              localObject3 = com.tencent.mm.plugin.downloader.model.f.bjl();
              l = localException.field_downloadId;
              int i = localException.field_errCode;
              if (((com.tencent.mm.plugin.downloader.model.f)localObject3).kYw == null) {
                break;
              }
              ((com.tencent.mm.plugin.downloader.model.f)localObject3).kYw.d(l, i, false);
              break;
              h.qsU.idkeyStat(710L, 16L, 1L, false);
              if (!at.isWifi(ah.getContext())) {
                h.qsU.idkeyStat(710L, 17L, 1L, false);
              }
            }
          }
        }
        else
        {
          ab.i("MicroMsg.PluginDownloader", "download process alive, still downloading: " + localException.field_appId);
          h.qsU.idkeyStat(710L, 13L, 1L, false);
        }
      }
    }
    label783:
    AppMethodBeat.o(2281);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(2278);
    ab.d("MicroMsg.PluginDownloader", "execute");
    if (paramg.SD())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader.a.d.class, new b());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.cdndownloader.b.a.class, new com.tencent.mm.plugin.cdndownloader.a());
      paramg = new a(com.tencent.mm.plugin.downloader.model.b.kYa);
      kVj = paramg;
      paramg.startWatching();
    }
    AppMethodBeat.o(2278);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(2279);
    ab.i("MicroMsg.PluginDownloader", "onAccountInitialized");
    com.tencent.mm.plugin.downloader.e.a.bje();
    appForegroundListener.alive();
    com.tencent.mm.plugin.cdndownloader.g.a.aNS().o(new PluginDownloader.2(this), 500L);
    com.tencent.mm.plugin.downloader.b.a.bje();
    AppMethodBeat.o(2279);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(2280);
    ab.i("MicroMsg.PluginDownloader", "onAccountRelease");
    com.tencent.mm.plugin.downloader.e.a.bjf();
    appForegroundListener.dead();
    com.tencent.mm.plugin.downloader.b.a.bjf();
    com.tencent.mm.plugin.downloader.a.c.clearCache();
    AppMethodBeat.o(2280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */