package com.tencent.mm.plugin.downloader.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static BroadcastReceiver qJv = null;
  private static int qJw = -1;
  
  public static void cBn()
  {
    AppMethodBeat.i(89071);
    if (qJv == null) {
      qJv = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      MMApplicationContext.getContext().registerReceiver(qJv, localIntentFilter);
      AppMethodBeat.o(89071);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      AppMethodBeat.o(89071);
    }
  }
  
  public static void cBo()
  {
    AppMethodBeat.i(89072);
    if (qJv != null) {}
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(qJv);
      qJv = null;
      AppMethodBeat.o(89072);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      }
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(89070);
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89069);
          if ((!g.aAc()) || (com.tencent.mm.kernel.a.azj()))
          {
            Log.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
            AppMethodBeat.o(89069);
            return;
          }
          int i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
          if (i == a.qJw)
          {
            AppMethodBeat.o(89069);
            return;
          }
          a.access$102(i);
          Log.i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = ".concat(String.valueOf(i)));
          if (!NetStatusUtil.isConnected(paramContext))
          {
            Log.w("MicroMsg.Downloader.NetWorkManager", "network is not connected");
            AppMethodBeat.o(89069);
            return;
          }
          Object localObject2;
          Object localObject3;
          long l;
          if (NetStatusUtil.isWifi(i))
          {
            localObject1 = d.aSU();
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
                Log.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status) });
                if (d.alf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
                {
                  Log.i("MicroMsg.Downloader.NetWorkManager", "hasDuplicatedTask");
                  d.alc(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(710L, 26L, 1L, false);
                  continue;
                  Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1")));
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
                  localObject3 = f.cBv();
                  l = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
                  localObject2 = d.Cw(l);
                  if ((localObject2 != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3))
                  {
                    localObject2 = ((f)localObject3).cBA();
                    localObject3 = d.Cw(l);
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                      d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                    }
                    com.tencent.mm.plugin.downloader.f.a.p(l, 14);
                    ((com.tencent.mm.plugin.downloader.model.b)localObject2).n(l, true);
                  }
                  else
                  {
                    localObject2 = ((f)localObject3).cBz();
                    localObject3 = d.Cw(l);
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                      d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                    }
                    com.tencent.mm.plugin.downloader.f.a.p(l, 14);
                    ((com.tencent.mm.plugin.downloader.h.a)localObject2).n(l, true);
                  }
                }
                else if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status == 0) && (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_reserveInWifi))
                {
                  localObject3 = f.cBv();
                  if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) {
                    ((f)localObject3).cBA().a((com.tencent.mm.plugin.downloader.g.a)localObject2);
                  } else {
                    ((f)localObject3).cBw().a((com.tencent.mm.plugin.downloader.g.a)localObject2);
                  }
                }
              }
            }
            label511:
            com.tencent.mm.plugin.game.commlib.c.a.dTf().a("download_resume", new com.tencent.mm.plugin.game.commlib.c.a.a()
            {
              public final void cBm()
              {
                AppMethodBeat.i(192272);
                com.tencent.f.h.RTc.aX(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(192271);
                    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                      com.tencent.mm.plugin.downloader.model.a.cBp();
                    }
                    AppMethodBeat.o(192271);
                  }
                });
                AppMethodBeat.o(192272);
              }
            });
            AppMethodBeat.o(89069);
            return;
          }
          Object localObject1 = d.cBs();
          if (localObject1 != null)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
              Log.i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId);
              localObject2 = f.cBv();
              l = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId;
              localObject3 = d.Cw(l);
              if ((localObject3 != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloaderType == 3))
              {
                ((f)localObject2).cBA().Cs(l);
              }
              else
              {
                localObject2 = ((f)localObject2).cBz();
                localObject3 = d.Cw(l);
                if (localObject3 != null)
                {
                  ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                  d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
                }
                com.tencent.mm.plugin.downloader.f.a.p(l, 13);
                ((com.tencent.mm.plugin.downloader.h.a)localObject2).Cp(l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.a
 * JD-Core Version:    0.7.0.1
 */