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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginDownloader
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, e
{
  private static n.a appForegroundListener;
  private static a oFq;
  
  static
  {
    AppMethodBeat.i(88831);
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(88822);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS()) {
            ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader.a.d.class)).jE(false);
          }
        }
        AppMethodBeat.o(88822);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(88821);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS()) {
            ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader.a.d.class)).jE(true);
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
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.awH();
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (!bs.gY((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        label27:
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
          Object localObject3 = new Intent();
          ((Intent)localObject3).putExtra(FileDownloadService.oJi, 1);
          ((Intent)localObject3).setClass(ai.getContext(), FileDownloadService.class);
          ((Intent)localObject3).putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
          try
          {
            com.tencent.mm.br.d.aZ((Intent)localObject3);
            h.wUl.idkeyStat(710L, 25L, 1L, false);
            break label27;
            ac.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=6")));
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
              ac.e("MicroMsg.PluginDownloader", localException.getMessage());
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
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.awH();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!bs.gY((List)localObject1)) {
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
        ac.i("MicroMsg.PluginDownloader", "resumeDownloadTaskWhenProcessRestart, downloadid : %d, appid : %s, status : %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId), ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status) });
        if (com.tencent.mm.plugin.downloader.model.d.WA(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
        {
          ac.i("MicroMsg.PluginDownloader", "hasDuplicatedTask");
          com.tencent.mm.plugin.downloader.model.d.Wx(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
          h.wUl.idkeyStat(710L, 26L, 1L, false);
          continue;
          ac.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
          localObject2 = ((com.tencent.mm.plugin.downloader.g.b)localObject1).rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
          if (localObject2 == null)
          {
            ac.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
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
        localObject3 = com.tencent.mm.plugin.downloader.model.f.bXJ().rT(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
        long l;
        if (((FileDownloadTaskInfo)localObject3).status == 3)
        {
          ac.i("MicroMsg.PluginDownloader", "has download finish");
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_finishTime = System.currentTimeMillis();
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_totalSize;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 6;
          ac.i("MicroMsg.PluginDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize), Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_startSize) });
          com.tencent.mm.plugin.downloader.model.d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          localObject3 = com.tencent.mm.plugin.downloader.model.f.bXJ();
          l = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
          if (((com.tencent.mm.plugin.downloader.model.f)localObject3).oIJ != null) {
            ((com.tencent.mm.plugin.downloader.model.f)localObject3).oIJ.sb(l);
          }
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra(FileDownloadService.oJi, 1);
          ((Intent)localObject3).setClass(ai.getContext(), FileDownloadService.class);
          ((Intent)localObject3).putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
          try
          {
            com.tencent.mm.br.d.aZ((Intent)localObject3);
            h.wUl.idkeyStat(710L, 12L, 1L, false);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.e("MicroMsg.PluginDownloader", localException.getMessage());
            }
          }
        }
        else if (((FileDownloadTaskInfo)localObject3).status != 1)
        {
          h.wUl.idkeyStat(710L, 14L, 1L, false);
          ac.i("MicroMsg.PluginDownloader", "download fail, all process dead, appId: " + localException.field_appId);
          l = (System.currentTimeMillis() - localException.field_updateTime) / 1000L;
          ac.i("MicroMsg.PluginDownloader", "lastTime = ".concat(String.valueOf(l)));
          if (l <= 1800L)
          {
            boolean bool = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.pMj, false);
            ac.i("MicroMsg.PluginDownloader", "in half hour, net: %s, downloadInWifi: %b, expt: %b", new Object[] { ax.getNetTypeString(ai.getContext()), Boolean.valueOf(((FileDownloadTaskInfo)localObject3).oJo), Boolean.valueOf(bool) });
            if (ax.isWifi(ai.getContext()))
            {
              ac.i("MicroMsg.PluginDownloader", "in half hour, in wifi, restart");
              com.tencent.mm.plugin.downloader.model.f.bXJ().rW(localException.field_downloadId);
              h.wUl.idkeyStat(710L, 15L, 1L, false);
            }
            else if ((!((FileDownloadTaskInfo)localObject3).oJo) && (bool))
            {
              ac.i("MicroMsg.PluginDownloader", "download not in wifi");
              com.tencent.mm.plugin.downloader.model.f.bXJ().rW(localException.field_downloadId);
              h.wUl.idkeyStat(710L, 19L, 1L, false);
            }
            else
            {
              h.wUl.idkeyStat(710L, 17L, 1L, false);
            }
          }
          else
          {
            for (;;)
            {
              localException.field_finishTime = System.currentTimeMillis();
              localException.field_status = 4;
              localException.field_errCode = com.tencent.mm.plugin.downloader.a.a.oFC;
              com.tencent.mm.plugin.downloader.model.d.e(localException);
              localObject3 = com.tencent.mm.plugin.downloader.model.f.bXJ();
              l = localException.field_downloadId;
              int i = localException.field_errCode;
              if (((com.tencent.mm.plugin.downloader.model.f)localObject3).oIJ == null) {
                break;
              }
              ((com.tencent.mm.plugin.downloader.model.f)localObject3).oIJ.c(l, i, false);
              break;
              h.wUl.idkeyStat(710L, 16L, 1L, false);
              if (!ax.isWifi(ai.getContext())) {
                h.wUl.idkeyStat(710L, 17L, 1L, false);
              }
            }
          }
        }
        else
        {
          ac.i("MicroMsg.PluginDownloader", "download process alive, still downloading: " + localException.field_appId);
          h.wUl.idkeyStat(710L, 13L, 1L, false);
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
    ac.d("MicroMsg.PluginDownloader", "execute");
    if (paramg.ahL())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader.a.d.class, new b());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.cdndownloader.b.a.class, new com.tencent.mm.plugin.cdndownloader.a());
      paramg = new a(com.tencent.mm.plugin.downloader.model.b.oIn);
      oFq = paramg;
      paramg.startWatching();
    }
    AppMethodBeat.o(88824);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(88825);
    ac.i("MicroMsg.PluginDownloader", "onAccountInitialized");
    com.tencent.mm.plugin.downloader.e.a.bXA();
    appForegroundListener.alive();
    com.tencent.mm.plugin.game.commlib.c.a.cOB().a("md5_check", new a.a()
    {
      public final void bXz()
      {
        AppMethodBeat.i(209621);
        com.tencent.mm.plugin.cdndownloader.g.a.bUw().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209620);
            PluginDownloader.access$000(PluginDownloader.this);
            AppMethodBeat.o(209620);
          }
        }, 0L);
        AppMethodBeat.o(209621);
      }
    });
    com.tencent.mm.plugin.game.commlib.c.a.cOB().a("download_resume", new a.a()
    {
      public final void bXz()
      {
        AppMethodBeat.i(209623);
        com.tencent.mm.plugin.cdndownloader.g.a.bUw().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209622);
            PluginDownloader.access$100(PluginDownloader.this);
            AppMethodBeat.o(209622);
          }
        }, 0L);
        AppMethodBeat.o(209623);
      }
    });
    com.tencent.mm.plugin.downloader.b.a.bXA();
    AppMethodBeat.o(88825);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88826);
    ac.i("MicroMsg.PluginDownloader", "onAccountRelease");
    com.tencent.mm.plugin.downloader.e.a.bXB();
    appForegroundListener.dead();
    com.tencent.mm.plugin.downloader.b.a.bXB();
    com.tencent.mm.plugin.downloader.a.c.clearCache();
    AppMethodBeat.o(88826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */