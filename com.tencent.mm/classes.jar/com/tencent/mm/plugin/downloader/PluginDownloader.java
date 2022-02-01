package com.tencent.mm.plugin.downloader;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.downloader.a.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginDownloader
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, e
{
  private static n.a appForegroundListener;
  private static a obR;
  
  static
  {
    AppMethodBeat.i(88831);
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(88822);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC()) {
            ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader.a.d.class)).jb(false);
          }
        }
        AppMethodBeat.o(88822);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(88821);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC()) {
            ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader.a.d.class)).jb(true);
          }
        }
        AppMethodBeat.o(88821);
      }
    };
    AppMethodBeat.o(88831);
  }
  
  private void checkMD5CheckingTasks()
  {
    AppMethodBeat.i(88827);
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.apS();
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (!bt.gL((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        label27:
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
          Object localObject3 = new Intent();
          ((Intent)localObject3).putExtra(FileDownloadService.ofH, 1);
          ((Intent)localObject3).setClass(aj.getContext(), FileDownloadService.class);
          ((Intent)localObject3).putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
          try
          {
            com.tencent.mm.bs.d.aY((Intent)localObject3);
            h.vKh.idkeyStat(710L, 25L, 1L, false);
            break label27;
            ad.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=6")));
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
              ad.e("MicroMsg.PluginDownloader", localException.getMessage());
            }
          }
        }
      }
    }
    AppMethodBeat.o(88827);
  }
  
  private void resumeDownloadTaskWhenProcessRestart()
  {
    AppMethodBeat.i(88828);
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.apS();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!bt.gL((List)localObject1)) {
        localObject1 = ((LinkedList)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label867;
        }
        Object localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
        ad.i("MicroMsg.PluginDownloader", "resumeDownloadTaskWhenProcessRestart, downloadid : %d, appid : %s, status : %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId), ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status) });
        if (com.tencent.mm.plugin.downloader.model.d.So(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
        {
          ad.i("MicroMsg.PluginDownloader", "hasDuplicatedTask");
          com.tencent.mm.plugin.downloader.model.d.Sl(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
          h.vKh.idkeyStat(710L, 26L, 1L, false);
          continue;
          ad.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
          localObject2 = ((com.tencent.mm.plugin.downloader.g.b)localObject1).rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
          if (localObject2 == null)
          {
            ad.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
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
          break;
        }
        Object localObject3 = new com.tencent.mm.plugin.downloader.f.b();
        ((com.tencent.mm.plugin.downloader.f.b)localObject3).k((com.tencent.mm.plugin.downloader.g.a)localObject2);
        com.tencent.mm.plugin.downloader.f.a.a(20, (com.tencent.mm.plugin.downloader.f.b)localObject3);
        localObject3 = com.tencent.mm.plugin.downloader.model.f.bQt().oh(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
        long l;
        if (((FileDownloadTaskInfo)localObject3).status == 3)
        {
          ad.i("MicroMsg.PluginDownloader", "has download finish");
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_finishTime = System.currentTimeMillis();
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_totalSize;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 6;
          ad.i("MicroMsg.PluginDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize), Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_startSize) });
          com.tencent.mm.plugin.downloader.model.d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          localObject3 = com.tencent.mm.plugin.downloader.model.f.bQt();
          l = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
          if (((com.tencent.mm.plugin.downloader.model.f)localObject3).ofi != null) {
            ((com.tencent.mm.plugin.downloader.model.f)localObject3).ofi.op(l);
          }
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra(FileDownloadService.ofH, 1);
          ((Intent)localObject3).setClass(aj.getContext(), FileDownloadService.class);
          ((Intent)localObject3).putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
          try
          {
            com.tencent.mm.bs.d.aY((Intent)localObject3);
            h.vKh.idkeyStat(710L, 12L, 1L, false);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.e("MicroMsg.PluginDownloader", localException.getMessage());
            }
          }
        }
        else if (((FileDownloadTaskInfo)localObject3).status != 1)
        {
          h.vKh.idkeyStat(710L, 14L, 1L, false);
          ad.i("MicroMsg.PluginDownloader", "download fail, all process dead, appId: " + localException.field_appId);
          l = (System.currentTimeMillis() - localException.field_updateTime) / 1000L;
          ad.i("MicroMsg.PluginDownloader", "lastTime = ".concat(String.valueOf(l)));
          if (l <= 1800L)
          {
            boolean bool = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.piW, false);
            ad.i("MicroMsg.PluginDownloader", "in half hour, net: %s, downloadInWifi: %b, expt: %b", new Object[] { ay.getNetTypeString(aj.getContext()), Boolean.valueOf(((FileDownloadTaskInfo)localObject3).ofN), Boolean.valueOf(bool) });
            if (ay.isWifi(aj.getContext()))
            {
              ad.i("MicroMsg.PluginDownloader", "in half hour, in wifi, restart");
              com.tencent.mm.plugin.downloader.model.f.bQt().ok(localException.field_downloadId);
              h.vKh.idkeyStat(710L, 15L, 1L, false);
            }
            else if ((!((FileDownloadTaskInfo)localObject3).ofN) && (bool))
            {
              ad.i("MicroMsg.PluginDownloader", "download not in wifi");
              com.tencent.mm.plugin.downloader.model.f.bQt().ok(localException.field_downloadId);
              h.vKh.idkeyStat(710L, 19L, 1L, false);
            }
            else
            {
              h.vKh.idkeyStat(710L, 17L, 1L, false);
            }
          }
          else
          {
            for (;;)
            {
              localException.field_finishTime = System.currentTimeMillis();
              localException.field_status = 4;
              localException.field_errCode = com.tencent.mm.plugin.downloader.a.a.ocd;
              com.tencent.mm.plugin.downloader.model.d.e(localException);
              localObject3 = com.tencent.mm.plugin.downloader.model.f.bQt();
              l = localException.field_downloadId;
              int i = localException.field_errCode;
              if (((com.tencent.mm.plugin.downloader.model.f)localObject3).ofi == null) {
                break;
              }
              ((com.tencent.mm.plugin.downloader.model.f)localObject3).ofi.c(l, i, false);
              break;
              h.vKh.idkeyStat(710L, 16L, 1L, false);
              if (!ay.isWifi(aj.getContext())) {
                h.vKh.idkeyStat(710L, 17L, 1L, false);
              }
            }
          }
        }
        else
        {
          ad.i("MicroMsg.PluginDownloader", "download process alive, still downloading: " + localException.field_appId);
          h.vKh.idkeyStat(710L, 13L, 1L, false);
        }
      }
    }
    label867:
    AppMethodBeat.o(88828);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(88824);
    ad.d("MicroMsg.PluginDownloader", "execute");
    if (paramg.agu())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader.a.d.class, new b());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.cdndownloader.b.a.class, new com.tencent.mm.plugin.cdndownloader.a());
      paramg = new a(com.tencent.mm.plugin.downloader.model.b.oeL);
      obR = paramg;
      paramg.startWatching();
    }
    AppMethodBeat.o(88824);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(88825);
    ad.i("MicroMsg.PluginDownloader", "onAccountInitialized");
    com.tencent.mm.plugin.downloader.e.a.bQj();
    appForegroundListener.alive();
    com.tencent.mm.plugin.game.commlib.c.a.cBs().a("md5_check", new a.a()
    {
      public final void bQi()
      {
        AppMethodBeat.i(189073);
        com.tencent.mm.plugin.cdndownloader.g.a.bNl().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(189072);
            PluginDownloader.access$000(PluginDownloader.this);
            AppMethodBeat.o(189072);
          }
        }, 0L);
        AppMethodBeat.o(189073);
      }
    });
    com.tencent.mm.plugin.game.commlib.c.a.cBs().a("download_resume", new a.a()
    {
      public final void bQi()
      {
        AppMethodBeat.i(189075);
        com.tencent.mm.plugin.cdndownloader.g.a.bNl().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(189074);
            PluginDownloader.access$100(PluginDownloader.this);
            AppMethodBeat.o(189074);
          }
        }, 0L);
        AppMethodBeat.o(189075);
      }
    });
    com.tencent.mm.plugin.downloader.b.a.bQj();
    AppMethodBeat.o(88825);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88826);
    ad.i("MicroMsg.PluginDownloader", "onAccountRelease");
    com.tencent.mm.plugin.downloader.e.a.bQk();
    appForegroundListener.dead();
    com.tencent.mm.plugin.downloader.b.a.bQk();
    com.tencent.mm.plugin.downloader.a.c.clearCache();
    AppMethodBeat.o(88826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */