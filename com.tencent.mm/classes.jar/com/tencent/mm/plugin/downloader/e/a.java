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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static BroadcastReceiver oJC = null;
  private static int oJD = -1;
  
  public static void bXA()
  {
    AppMethodBeat.i(89071);
    if (oJC == null) {
      oJC = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      ai.getContext().registerReceiver(oJC, localIntentFilter);
      AppMethodBeat.o(89071);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      AppMethodBeat.o(89071);
    }
  }
  
  public static void bXB()
  {
    AppMethodBeat.i(89072);
    if (oJC != null) {}
    try
    {
      ai.getContext().unregisterReceiver(oJC);
      oJC = null;
      AppMethodBeat.o(89072);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      }
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(89070);
      com.tencent.e.h.JZN.aS(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89069);
          if ((!g.agM()) || (com.tencent.mm.kernel.a.afS()))
          {
            ac.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
            AppMethodBeat.o(89069);
            return;
          }
          int i = ax.getNetType(ai.getContext());
          if (i == a.oJD)
          {
            AppMethodBeat.o(89069);
            return;
          }
          a.AL(i);
          ac.i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = ".concat(String.valueOf(i)));
          if (!ax.isConnected(paramContext))
          {
            ac.w("MicroMsg.Downloader.NetWorkManager", "network is not connected");
            AppMethodBeat.o(89069);
            return;
          }
          Object localObject2;
          Object localObject3;
          long l;
          if (ax.isWifi(i))
          {
            localObject1 = d.awH();
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
                  break label511;
                }
                localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
                ac.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status) });
                if (d.WA(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
                {
                  ac.i("MicroMsg.Downloader.NetWorkManager", "hasDuplicatedTask");
                  d.Wx(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(710L, 26L, 1L, false);
                  continue;
                  ac.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1")));
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
                  localObject3 = f.bXJ();
                  l = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
                  localObject2 = d.sc(l);
                  if ((localObject2 != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3))
                  {
                    localObject2 = ((f)localObject3).bXO();
                    localObject3 = d.sc(l);
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                      d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                    }
                    com.tencent.mm.plugin.downloader.f.a.s(l, 14);
                    ((com.tencent.mm.plugin.downloader.model.b)localObject2).n(l, true);
                  }
                  else
                  {
                    localObject2 = ((f)localObject3).bXN();
                    localObject3 = d.sc(l);
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                      d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                    }
                    com.tencent.mm.plugin.downloader.f.a.s(l, 14);
                    ((com.tencent.mm.plugin.downloader.h.a)localObject2).n(l, true);
                  }
                }
                else if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status == 0) && (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_reserveInWifi))
                {
                  localObject3 = f.bXJ();
                  if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) {
                    ((f)localObject3).bXO().a((com.tencent.mm.plugin.downloader.g.a)localObject2);
                  } else {
                    ((f)localObject3).bXK().a((com.tencent.mm.plugin.downloader.g.a)localObject2);
                  }
                }
              }
            }
            label511:
            com.tencent.mm.plugin.game.commlib.c.a.cOB().a("download_resume", new com.tencent.mm.plugin.game.commlib.c.a.a()
            {
              public final void bXz()
              {
                AppMethodBeat.i(209632);
                com.tencent.e.h.JZN.aS(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(209631);
                    if (ax.isWifi(ai.getContext())) {
                      com.tencent.mm.plugin.downloader.model.a.bXC();
                    }
                    AppMethodBeat.o(209631);
                  }
                });
                AppMethodBeat.o(209632);
              }
            });
            AppMethodBeat.o(89069);
            return;
          }
          Object localObject1 = d.bXG();
          if (localObject1 != null)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
              ac.i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId);
              localObject2 = f.bXJ();
              l = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId;
              localObject3 = d.sc(l);
              if ((localObject3 != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloaderType == 3))
              {
                ((f)localObject2).bXO().rX(l);
              }
              else
              {
                localObject2 = ((f)localObject2).bXN();
                localObject3 = d.sc(l);
                if (localObject3 != null)
                {
                  ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                  d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                }
                com.tencent.mm.plugin.downloader.f.a.s(l, 13);
                ((com.tencent.mm.plugin.downloader.h.a)localObject2).rU(l);
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