package com.tencent.mm.plugin.downloader;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.downloader.a.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginDownloader
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, e
{
  private static o.a appForegroundListener;
  private static a uef;
  
  static
  {
    AppMethodBeat.i(88831);
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(88822);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader.a.d.class)).md(false);
          }
        }
        AppMethodBeat.o(88822);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(88821);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader.a.d.class)).md(true);
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
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.bbS();
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (!Util.isNullOrNil((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        label27:
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
          Object localObject3 = new Intent();
          ((Intent)localObject3).putExtra(FileDownloadService.uib, 1);
          ((Intent)localObject3).setClass(MMApplicationContext.getContext(), FileDownloadService.class);
          ((Intent)localObject3).putExtra(FileDownloadService.uia, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
          try
          {
            com.tencent.mm.by.c.startService((Intent)localObject3);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 25L, 1L, false);
            break label27;
            Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=6")));
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
              Log.e("MicroMsg.PluginDownloader", localException.getMessage());
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
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.bbS();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!Util.isNullOrNil((List)localObject1)) {
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
        Log.i("MicroMsg.PluginDownloader", "resumeDownloadTaskWhenProcessRestart, downloadid : %d, appid : %s, status : %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId), ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status) });
        if (com.tencent.mm.plugin.downloader.model.d.asY(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
        {
          Log.i("MicroMsg.PluginDownloader", "hasDuplicatedTask");
          com.tencent.mm.plugin.downloader.model.d.asV(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 26L, 1L, false);
          continue;
          Log.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
          localObject2 = ((com.tencent.mm.plugin.downloader.g.b)localObject1).rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
          if (localObject2 == null)
          {
            Log.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
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
        localObject3 = com.tencent.mm.plugin.downloader.model.f.cPZ().Ix(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
        long l;
        if (((FileDownloadTaskInfo)localObject3).status == 3)
        {
          Log.i("MicroMsg.PluginDownloader", "has download finish");
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_finishTime = System.currentTimeMillis();
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_totalSize;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 6;
          Log.i("MicroMsg.PluginDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize), Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_startSize) });
          com.tencent.mm.plugin.downloader.model.d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          localObject3 = com.tencent.mm.plugin.downloader.model.f.cPZ();
          l = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
          if (((com.tencent.mm.plugin.downloader.model.f)localObject3).uhy != null) {
            ((com.tencent.mm.plugin.downloader.model.f)localObject3).uhy.IE(l);
          }
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra(FileDownloadService.uib, 1);
          ((Intent)localObject3).setClass(MMApplicationContext.getContext(), FileDownloadService.class);
          ((Intent)localObject3).putExtra(FileDownloadService.uia, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
          try
          {
            com.tencent.mm.by.c.startService((Intent)localObject3);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 12L, 1L, false);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicroMsg.PluginDownloader", localException.getMessage());
            }
          }
        }
        else if (((FileDownloadTaskInfo)localObject3).status != 1)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 14L, 1L, false);
          Log.i("MicroMsg.PluginDownloader", "download fail, all process dead, appId: " + localException.field_appId);
          l = (System.currentTimeMillis() - localException.field_updateTime) / 1000L;
          Log.i("MicroMsg.PluginDownloader", "lastTime = ".concat(String.valueOf(l)));
          if (l <= 1800L)
          {
            boolean bool = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vuk, false);
            Log.i("MicroMsg.PluginDownloader", "in half hour, net: %s, downloadInWifi: %b, expt: %b", new Object[] { NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()), Boolean.valueOf(((FileDownloadTaskInfo)localObject3).uij), Boolean.valueOf(bool) });
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
            {
              Log.i("MicroMsg.PluginDownloader", "in half hour, in wifi, restart");
              com.tencent.mm.plugin.downloader.model.f.cPZ().IA(localException.field_downloadId);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 15L, 1L, false);
            }
            else if ((!((FileDownloadTaskInfo)localObject3).uij) && (bool))
            {
              Log.i("MicroMsg.PluginDownloader", "download not in wifi");
              com.tencent.mm.plugin.downloader.model.f.cPZ().IA(localException.field_downloadId);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 19L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 17L, 1L, false);
            }
          }
          else
          {
            for (;;)
            {
              localException.field_finishTime = System.currentTimeMillis();
              localException.field_status = 4;
              localException.field_errCode = com.tencent.mm.plugin.downloader.a.a.ues;
              com.tencent.mm.plugin.downloader.model.d.e(localException);
              localObject3 = com.tencent.mm.plugin.downloader.model.f.cPZ();
              l = localException.field_downloadId;
              int i = localException.field_errCode;
              if (((com.tencent.mm.plugin.downloader.model.f)localObject3).uhy == null) {
                break;
              }
              ((com.tencent.mm.plugin.downloader.model.f)localObject3).uhy.c(l, i, false);
              break;
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 16L, 1L, false);
              if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 17L, 1L, false);
              }
            }
          }
        }
        else
        {
          Log.i("MicroMsg.PluginDownloader", "download process alive, still downloading: " + localException.field_appId);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 13L, 1L, false);
        }
      }
    }
    label867:
    AppMethodBeat.o(88828);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(219670);
    ab.a("CDNDownloadBigFile", "BigFile", 2592000000L, 53);
    AppMethodBeat.o(219670);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(88824);
    Log.d("MicroMsg.PluginDownloader", "execute");
    if (paramg.aIE())
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.downloader.a.d.class, new b());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.cdndownloader.b.a.class, new com.tencent.mm.plugin.cdndownloader.a());
      paramg = new a(com.tencent.mm.plugin.downloader.model.b.uhb);
      uef = paramg;
      paramg.startWatching();
    }
    AppMethodBeat.o(88824);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(88825);
    Log.i("MicroMsg.PluginDownloader", "onAccountInitialized");
    com.tencent.mm.plugin.downloader.e.a.cPR();
    appForegroundListener.alive();
    com.tencent.mm.plugin.game.commlib.c.a.ewo().a("md5_check", new a.a()
    {
      public final void cPQ()
      {
        AppMethodBeat.i(220121);
        com.tencent.mm.plugin.cdndownloader.g.a.cMC().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220124);
            PluginDownloader.access$000(PluginDownloader.this);
            AppMethodBeat.o(220124);
          }
        }, 0L);
        AppMethodBeat.o(220121);
      }
    });
    com.tencent.mm.plugin.game.commlib.c.a.ewo().a("download_resume", new a.a()
    {
      public final void cPQ()
      {
        AppMethodBeat.i(219899);
        com.tencent.mm.plugin.cdndownloader.g.a.cMC().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219761);
            PluginDownloader.access$100(PluginDownloader.this);
            AppMethodBeat.o(219761);
          }
        }, 0L);
        AppMethodBeat.o(219899);
      }
    });
    com.tencent.mm.plugin.downloader.b.a.cPR();
    AppMethodBeat.o(88825);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88826);
    Log.i("MicroMsg.PluginDownloader", "onAccountRelease");
    com.tencent.mm.plugin.downloader.e.a.cPS();
    appForegroundListener.dead();
    com.tencent.mm.plugin.downloader.b.a.cPS();
    com.tencent.mm.plugin.downloader.a.c.clearCache();
    AppMethodBeat.o(88826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */