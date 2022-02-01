package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.hw.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class e
{
  private static n.a appForegroundListener;
  private static int ogc;
  private static b rZc;
  private static a rZd;
  private static c rZe;
  private static com.tencent.mm.sdk.b.c rZf;
  private static com.tencent.mm.sdk.b.c rZg;
  
  static
  {
    AppMethodBeat.i(41682);
    ogc = -1;
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(41674);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new hw();
            paramAnonymousString.dlC.dbV = 1;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(41674);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(41673);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new hw();
            paramAnonymousString.dlC.dbV = 2;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(41673);
      }
    };
    rZf = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(hw paramAnonymoushw)
      {
        AppMethodBeat.i(41675);
        switch (paramAnonymoushw.dlC.dbV)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(41675);
          return false;
          if (bt.lZ(bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqa, Long.valueOf(0L)))) > 600L)
          {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqa, Long.valueOf(bt.aGK()));
            h.a.cDV().lS(false);
            continue;
            paramAnonymoushw = paramAnonymoushw.dlC.dlB;
            if (bt.isNullOrNil(paramAnonymoushw))
            {
              ad.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().execSQL("GameSilentDownload", String.format("delete from %s", new Object[] { "GameSilentDownload" }))) });
            }
            else
            {
              Object localObject = new d();
              ((d)localObject).field_appId = paramAnonymoushw;
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().delete((com.tencent.mm.sdk.e.c)localObject, new String[0]);
              ad.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", new Object[] { paramAnonymoushw });
              continue;
              paramAnonymoushw = paramAnonymoushw.dlC.dlB;
              if (!bt.isNullOrNil(paramAnonymoushw))
              {
                localObject = com.tencent.mm.plugin.downloader.model.d.Sk(paramAnonymoushw);
                if (localObject != null)
                {
                  long l = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId;
                  f.bQt().og(l);
                  com.tencent.mm.plugin.downloader.model.d.or(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId);
                  ad.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", new Object[] { paramAnonymoushw });
                }
              }
            }
          }
        }
      }
    };
    rZg = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(41682);
  }
  
  public static void bQj()
  {
    AppMethodBeat.i(41680);
    try
    {
      if (rZc == null) {
        rZc = new b((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      aj.getContext().registerReceiver(rZc, localIntentFilter);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        IntentFilter localIntentFilter;
        label107:
        ad.i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", new Object[] { localException1.getMessage() });
      }
    }
    try
    {
      if (rZd == null) {
        rZd = new a((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
      localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
      aj.getContext().registerReceiver(rZd, localIntentFilter);
    }
    catch (Exception localException2)
    {
      ad.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", new Object[] { localException2.getMessage() });
      break label107;
    }
    appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.ESL.c(rZf);
    com.tencent.mm.sdk.b.a.ESL.c(rZg);
    if (rZe == null) {
      rZe = new c();
    }
    f.bQt();
    com.tencent.mm.plugin.downloader.model.c.a(rZe);
    AppMethodBeat.o(41680);
  }
  
  public static void bQk()
  {
    AppMethodBeat.i(41681);
    appForegroundListener.dead();
    if (rZc != null) {}
    try
    {
      aj.getContext().unregisterReceiver(rZc);
      rZc = null;
      if (rZd == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        aj.getContext().unregisterReceiver(rZd);
        rZd = null;
        com.tencent.mm.sdk.b.a.ESL.d(rZf);
        com.tencent.mm.sdk.b.a.ESL.d(rZg);
        if (rZe != null)
        {
          f.bQt();
          com.tencent.mm.plugin.downloader.model.c.b(rZe);
          rZe = null;
        }
        AppMethodBeat.o(41681);
        return;
        localException1 = localException1;
        ad.i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(41678);
      if ((!com.tencent.mm.kernel.g.afw()) || (com.tencent.mm.kernel.a.aeC()))
      {
        ad.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
        AppMethodBeat.o(41678);
        return;
      }
      if (paramIntent == null)
      {
        AppMethodBeat.o(41678);
        return;
      }
      if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
      {
        ad.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
        h.a.cDV().lS(true);
        AppMethodBeat.o(41678);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction()))
      {
        ad.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
        h.a.cDV();
        h.pauseDownload();
      }
      AppMethodBeat.o(41678);
    }
  }
  
  static final class b
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(41679);
      if ((!com.tencent.mm.kernel.g.afw()) || (com.tencent.mm.kernel.a.aeC()))
      {
        ad.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
        AppMethodBeat.o(41679);
        return;
      }
      int i = ay.getNetType(aj.getContext());
      if (i == e.ogc)
      {
        AppMethodBeat.o(41679);
        return;
      }
      e.EC(i);
      if (i == 0)
      {
        ad.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, checkDownload", new Object[] { Integer.valueOf(i) });
        h.a.cDV().lS(false);
        AppMethodBeat.o(41679);
        return;
      }
      ad.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, pauseDownload", new Object[] { Integer.valueOf(i) });
      h.a.cDV();
      h.pauseDownload();
      AppMethodBeat.o(41679);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e
 * JD-Core Version:    0.7.0.1
 */