package com.tencent.mm.plugin.downloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static BroadcastReceiver xoD = null;
  private static int xoE = -1;
  
  public static void cuD()
  {
    AppMethodBeat.i(89072);
    if (xoD != null) {}
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(xoD);
      xoD = null;
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
  
  public static void duo()
  {
    AppMethodBeat.i(89071);
    if (xoD == null) {
      xoD = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      MMApplicationContext.getContext().registerReceiver(xoD, localIntentFilter);
      AppMethodBeat.o(89071);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      AppMethodBeat.o(89071);
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(89070);
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89069);
          if ((!com.tencent.mm.kernel.h.baz()) || (com.tencent.mm.kernel.b.aZG()))
          {
            Log.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
            AppMethodBeat.o(89069);
            return;
          }
          int i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
          if (i == a.xoE)
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
            localObject1 = d.bzH();
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
                localObject2 = (com.tencent.mm.plugin.downloader.f.a)((Iterator)localObject1).next();
                Log.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", new Object[] { ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_status) });
                if (d.amN(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadUrl))
                {
                  Log.i("MicroMsg.Downloader.NetWorkManager", "hasDuplicatedTask");
                  d.amK(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadUrl);
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(710L, 26L, 1L, false);
                  continue;
                  Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1")));
                  localObject3 = ((com.tencent.mm.plugin.downloader.f.b)localObject1).rawQuery("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1", new String[0]);
                  localObject2 = new LinkedList();
                  localObject1 = localObject2;
                  if (localObject3 == null) {
                    break;
                  }
                  while (((Cursor)localObject3).moveToNext())
                  {
                    localObject1 = new com.tencent.mm.plugin.downloader.f.a();
                    ((com.tencent.mm.plugin.downloader.f.a)localObject1).convertFrom((Cursor)localObject3);
                    ((LinkedList)localObject2).add(localObject1);
                  }
                  ((Cursor)localObject3).close();
                  localObject1 = localObject2;
                  break;
                }
                if (((com.tencent.mm.plugin.downloader.f.a)localObject2).field_status == 2)
                {
                  localObject3 = f.duv();
                  l = ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId;
                  localObject2 = d.la(l);
                  if ((localObject2 != null) && (((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloaderType == 3))
                  {
                    localObject2 = ((f)localObject3).duA();
                    localObject3 = d.la(l);
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadType = 2;
                      d.e((com.tencent.mm.plugin.downloader.f.a)localObject3);
                    }
                    com.tencent.mm.plugin.downloader.e.a.A(l, 14);
                    ((com.tencent.mm.plugin.downloader.model.b)localObject2).t(l, true);
                  }
                  else
                  {
                    localObject2 = ((f)localObject3).duz();
                    localObject3 = d.la(l);
                    if (localObject3 != null)
                    {
                      ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadType = 2;
                      d.e((com.tencent.mm.plugin.downloader.f.a)localObject3);
                    }
                    com.tencent.mm.plugin.downloader.e.a.A(l, 14);
                    ((com.tencent.mm.plugin.downloader.g.a)localObject2).t(l, true);
                  }
                }
                else if ((((com.tencent.mm.plugin.downloader.f.a)localObject2).field_status == 0) && (((com.tencent.mm.plugin.downloader.f.a)localObject2).field_reserveInWifi))
                {
                  localObject3 = f.duv();
                  if (((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloaderType == 3) {
                    ((f)localObject3).duA().a((com.tencent.mm.plugin.downloader.f.a)localObject2);
                  } else {
                    ((f)localObject3).duw().a((com.tencent.mm.plugin.downloader.f.a)localObject2);
                  }
                }
              }
            }
            label511:
            com.tencent.mm.plugin.game.commlib.c.a.fEf().a("download_resume", new com.tencent.mm.plugin.game.commlib.c.a.a()
            {
              public final void dun()
              {
                AppMethodBeat.i(267106);
                com.tencent.threadpool.h.ahAA.bm(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(267104);
                    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                      com.tencent.mm.plugin.downloader.model.a.dup();
                    }
                    AppMethodBeat.o(267104);
                  }
                });
                AppMethodBeat.o(267106);
              }
            });
            AppMethodBeat.o(89069);
            return;
          }
          Object localObject1 = d.dus();
          if (localObject1 != null)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (com.tencent.mm.plugin.downloader.f.a)((Iterator)localObject1).next();
              Log.i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId);
              localObject2 = f.duv();
              l = ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId;
              localObject3 = d.la(l);
              if ((localObject3 != null) && (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloaderType == 3))
              {
                ((f)localObject2).duA().kW(l);
              }
              else
              {
                localObject2 = ((f)localObject2).duz();
                localObject3 = d.la(l);
                if (localObject3 != null)
                {
                  ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadType = 2;
                  d.e((com.tencent.mm.plugin.downloader.f.a)localObject3);
                }
                com.tencent.mm.plugin.downloader.e.a.A(l, 13);
                ((com.tencent.mm.plugin.downloader.g.a)localObject2).kT(l);
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
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.a
 * JD-Core Version:    0.7.0.1
 */