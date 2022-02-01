package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.TrafficStats;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class TrafficStatsReceiver
  extends BroadcastReceiver
{
  private long mLastTime = -1L;
  
  public static void cU(Context paramContext)
  {
    AppMethodBeat.i(131938);
    Intent localIntent = new Intent("com.tencent.mm.TrafficStatsReceiver");
    a.a(paramContext, 111, 3, SystemClock.elapsedRealtime(), 300000L, localIntent);
    Log.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", new Object[] { Long.valueOf(300000L) });
    AppMethodBeat.o(131938);
  }
  
  public static void cV(Context paramContext)
  {
    AppMethodBeat.i(131939);
    a.c(paramContext, new Intent("com.tencent.mm.TrafficStatsReceiver"));
    AppMethodBeat.o(131939);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131937);
    Log.d("MicroMsg.TrafficStats", "onRecieve");
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238894);
        long l1 = SystemClock.elapsedRealtime();
        if (Build.VERSION.SDK_INT >= 28) {
          TrafficStats.updateNsm(MMApplicationContext.getContext());
        }
        for (;;)
        {
          if (TrafficStatsReceiver.a(TrafficStatsReceiver.this) >= 0L)
          {
            long l2 = l1 - TrafficStatsReceiver.a(TrafficStatsReceiver.this);
            long l3 = TrafficStats.getMobileRx(0L) + TrafficStats.getMobileTx(0L);
            long l4 = TrafficStats.getWifiRx(0L) + TrafficStats.getWifiTx(0L);
            long l5 = TrafficStats.getWxMobileRx(0L) + TrafficStats.getWxMobileTx(0L);
            long l6 = TrafficStats.getWxMobileRx(0L) + TrafficStats.getWxMobileTx(0L);
            Log.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Double.valueOf((l3 + l4) / (l2 / 1000L)), Long.valueOf(l5), Long.valueOf(l6), Double.valueOf((l5 + l6) / (l2 / 1000L)) });
          }
          TrafficStatsReceiver.a(TrafficStatsReceiver.this, l1);
          AppMethodBeat.o(238894);
          return;
          TrafficStats.update();
        }
      }
    }, "TrafficStats.onReceive");
    AppMethodBeat.o(131937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.TrafficStatsReceiver
 * JD-Core Version:    0.7.0.1
 */