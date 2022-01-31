package com.tencent.mm.plugin.game.model.a;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class e
{
  private static j.a appForegroundListener;
  private static int kZo;
  private static e.b npH;
  private static e.a npI;
  private static c npJ;
  private static com.tencent.mm.sdk.b.c npK;
  private static com.tencent.mm.sdk.b.c npL;
  
  static
  {
    AppMethodBeat.i(111517);
    kZo = -1;
    appForegroundListener = new e.1();
    npK = new e.2();
    npL = new e.3();
    AppMethodBeat.o(111517);
  }
  
  public static void bje()
  {
    AppMethodBeat.i(111515);
    try
    {
      if (npH == null) {
        npH = new e.b((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ah.getContext().registerReceiver(npH, localIntentFilter);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        IntentFilter localIntentFilter;
        label107:
        ab.i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", new Object[] { localException1.getMessage() });
      }
    }
    try
    {
      if (npI == null) {
        npI = new e.a((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
      localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
      ah.getContext().registerReceiver(npI, localIntentFilter);
    }
    catch (Exception localException2)
    {
      ab.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", new Object[] { localException2.getMessage() });
      break label107;
    }
    appForegroundListener.alive();
    a.ymk.c(npK);
    a.ymk.c(npL);
    if (npJ == null) {
      npJ = new c();
    }
    f.bjl();
    com.tencent.mm.plugin.downloader.model.c.a(npJ);
    AppMethodBeat.o(111515);
  }
  
  public static void bjf()
  {
    AppMethodBeat.i(111516);
    appForegroundListener.dead();
    if (npH != null) {}
    try
    {
      ah.getContext().unregisterReceiver(npH);
      npH = null;
      if (npI == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        ah.getContext().unregisterReceiver(npI);
        npI = null;
        a.ymk.d(npK);
        a.ymk.d(npL);
        if (npJ != null)
        {
          f.bjl();
          com.tencent.mm.plugin.downloader.model.c.b(npJ);
          npJ = null;
        }
        AppMethodBeat.o(111516);
        return;
        localException1 = localException1;
        ab.i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e
 * JD-Core Version:    0.7.0.1
 */