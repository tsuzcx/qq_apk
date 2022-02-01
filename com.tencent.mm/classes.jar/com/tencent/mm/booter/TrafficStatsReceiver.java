package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bs;

public class TrafficStatsReceiver
  extends BroadcastReceiver
{
  private long mLastTime = -1L;
  
  public static void bP(Context paramContext)
  {
    AppMethodBeat.i(131938);
    Intent localIntent = new Intent("com.tencent.mm.TrafficStatsReceiver");
    a.a(paramContext, 111, 3, SystemClock.elapsedRealtime(), 300000L, localIntent);
    ad.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", new Object[] { Long.valueOf(300000L) });
    AppMethodBeat.o(131938);
  }
  
  public static void bQ(Context paramContext)
  {
    AppMethodBeat.i(131939);
    a.c(paramContext, new Intent("com.tencent.mm.TrafficStatsReceiver"));
    AppMethodBeat.o(131939);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131937);
    ad.d("MicroMsg.TrafficStats", "onRecieve");
    long l1 = SystemClock.elapsedRealtime();
    if ((Build.VERSION.SDK_INT > 28) || (Build.VERSION.CODENAME.equals("Q"))) {
      bs.m(q.aas(), aj.getContext());
    }
    for (;;)
    {
      if (this.mLastTime >= 0L)
      {
        long l2 = l1 - this.mLastTime;
        long l3 = bs.flH() + bs.flG();
        long l4 = bs.flF() + bs.flE();
        long l5 = bs.Da(0L) + bs.CZ(0L);
        long l6 = bs.Da(0L) + bs.CZ(0L);
        ad.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Double.valueOf((l3 + l4) / (l2 / 1000L)), Long.valueOf(l5), Long.valueOf(l6), Double.valueOf((l5 + l6) / (l2 / 1000L)) });
      }
      this.mLastTime = l1;
      AppMethodBeat.o(131937);
      return;
      bs.update();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.TrafficStatsReceiver
 * JD-Core Version:    0.7.0.1
 */