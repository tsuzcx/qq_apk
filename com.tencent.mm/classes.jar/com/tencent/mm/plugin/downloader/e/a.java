package com.tencent.mm.plugin.downloader.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static BroadcastReceiver ogb = null;
  private static int ogc = -1;
  
  public static void bQj()
  {
    AppMethodBeat.i(89071);
    if (ogb == null) {
      ogb = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      aj.getContext().registerReceiver(ogb, localIntentFilter);
      AppMethodBeat.o(89071);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      AppMethodBeat.o(89071);
    }
  }
  
  public static void bQk()
  {
    AppMethodBeat.i(89072);
    if (ogb != null) {}
    try
    {
      aj.getContext().unregisterReceiver(ogb);
      ogb = null;
      AppMethodBeat.o(89072);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      }
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(89070);
      if ((!g.afw()) || (com.tencent.mm.kernel.a.aeC()))
      {
        ad.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
        AppMethodBeat.o(89070);
        return;
      }
      final int i = ay.getNetType(aj.getContext());
      if (i == a.ogc)
      {
        AppMethodBeat.o(89070);
        return;
      }
      a.zT(i);
      ad.i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = ".concat(String.valueOf(i)));
      if (!ay.isConnected(paramContext))
      {
        ad.w("MicroMsg.Downloader.NetWorkManager", "network is not connected");
        AppMethodBeat.o(89070);
        return;
      }
      com.tencent.e.h.Iye.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89069);
          Object localObject2;
          Object localObject3;
          long l;
          if (ay.isWifi(i))
          {
            localObject1 = d.apS();
            if (localObject1 == null)
            {
              localObject1 = null;
              if (localObject1 != null) {
                localObject1 = ((LinkedList)localObject1).iterator();
              }
            }
            else
            {
              for (;;)
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break label413;
                }
                localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
                ad.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status) });
                if (d.So(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
                {
                  ad.i("MicroMsg.Downloader.NetWorkManager", "hasDuplicatedTask");
                  d.Sl(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(710L, 26L, 1L, false);
                  continue;
                  ad.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1")));
                  localObject3 = ((com.tencent.mm.plugin.downloader.g.b)localObject1).rawQuery("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1", new String[0]);
                  localObject2 = new LinkedList();
                  localObject1 = localObject2;
                  if (localObject3 == null) {
                    break;
                  }
                  while (((Cursor)localObject3).moveToNext())
                  {
                    localObject1 = new com.tencent.mm.plugin.downloader.g.a();
                    ((com.tencent.mm.plugin.downloader.g.a)localObject1).convertFrom((Cursor)localObject3);
                    ((LinkedList)localObject2).add(localObject1);
                  }
                  ((Cursor)localObject3).close();
                  localObject1 = localObject2;
                  break;
                }
                if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status == 2)
                {
                  localObject3 = f.bQt();
                  l = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
                  localObject2 = d.oq(l);
                  if ((localObject2 != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3))
                  {
                    localObject2 = ((f)localObject3).bQy();
                    localObject3 = d.oq(l);
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                      d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                    }
                    com.tencent.mm.plugin.downloader.f.a.r(l, 14);
                    ((com.tencent.mm.plugin.downloader.model.b)localObject2).m(l, true);
                  }
                  else
                  {
                    localObject2 = ((f)localObject3).bQx();
                    localObject3 = d.oq(l);
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                      d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                    }
                    com.tencent.mm.plugin.downloader.f.a.r(l, 14);
                    ((com.tencent.mm.plugin.downloader.h.a)localObject2).m(l, true);
                  }
                }
                else if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status == 0) && (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_reserveInWifi))
                {
                  localObject3 = f.bQt();
                  if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) {
                    ((f)localObject3).bQy().a((com.tencent.mm.plugin.downloader.g.a)localObject2);
                  } else {
                    ((f)localObject3).bQu().a((com.tencent.mm.plugin.downloader.g.a)localObject2);
                  }
                }
              }
            }
            label413:
            com.tencent.mm.plugin.game.commlib.c.a.cBs().a("download_resume", new com.tencent.mm.plugin.game.commlib.c.a.a()
            {
              public final void bQi()
              {
                AppMethodBeat.i(189078);
                com.tencent.e.h.Iye.aP(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(189077);
                    if (ay.isWifi(aj.getContext())) {
                      com.tencent.mm.plugin.downloader.model.a.bQm();
                    }
                    AppMethodBeat.o(189077);
                  }
                });
                AppMethodBeat.o(189078);
              }
            });
            AppMethodBeat.o(89069);
            return;
          }
          Object localObject1 = d.bQq();
          if (localObject1 != null)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
              ad.i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId);
              localObject2 = f.bQt();
              l = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId;
              localObject3 = d.oq(l);
              if ((localObject3 != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloaderType == 3))
              {
                ((f)localObject2).bQy().ol(l);
              }
              else
              {
                localObject2 = ((f)localObject2).bQx();
                localObject3 = d.oq(l);
                if (localObject3 != null)
                {
                  ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                  d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                }
                com.tencent.mm.plugin.downloader.f.a.r(l, 13);
                ((com.tencent.mm.plugin.downloader.h.a)localObject2).oi(l);
              }
            }
          }
          AppMethodBeat.o(89069);
        }
      });
      AppMethodBeat.o(89070);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.a
 * JD-Core Version:    0.7.0.1
 */