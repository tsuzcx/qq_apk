package com.tencent.mm.plugin.game.model.a;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private static int iPW = -1;
  private static d.b kRE;
  private static d.a kRF;
  private static b kRG;
  private static c kRH = new d.1();
  private static c kRI = new d.2();
  
  public static void aFI()
  {
    try
    {
      if (kRE == null) {
        kRE = new d.b((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ae.getContext().registerReceiver(kRE, localIntentFilter);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        IntentFilter localIntentFilter;
        label102:
        y.i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", new Object[] { localException1.getMessage() });
      }
    }
    try
    {
      if (kRF == null) {
        kRF = new d.a((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
      localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
      ae.getContext().registerReceiver(kRF, localIntentFilter);
    }
    catch (Exception localException2)
    {
      y.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", new Object[] { localException2.getMessage() });
      break label102;
    }
    a.udP.c(kRH);
    a.udP.c(kRI);
    if (kRG == null) {
      kRG = new b();
    }
    com.tencent.mm.plugin.downloader.model.d.aFP();
    com.tencent.mm.plugin.downloader.model.b.a(kRG);
  }
  
  public static void aFJ()
  {
    if (kRE != null) {}
    try
    {
      ae.getContext().unregisterReceiver(kRE);
      kRE = null;
      if (kRF == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        ae.getContext().unregisterReceiver(kRF);
        kRF = null;
        a.udP.d(kRH);
        a.udP.d(kRI);
        if (kRG != null)
        {
          com.tencent.mm.plugin.downloader.model.d.aFP();
          com.tencent.mm.plugin.downloader.model.b.b(kRG);
          kRG = null;
        }
        return;
        localException1 = localException1;
        y.i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.d
 * JD-Core Version:    0.7.0.1
 */