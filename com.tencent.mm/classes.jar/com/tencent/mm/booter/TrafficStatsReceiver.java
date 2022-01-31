package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.y;

public class TrafficStatsReceiver
  extends BroadcastReceiver
{
  private long mLastTime = -1L;
  
  public static void aX(Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    paramContext = PendingIntent.getBroadcast(paramContext, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), 268435456);
    localAlarmManager.setRepeating(3, SystemClock.elapsedRealtime(), 300000L, paramContext);
    y.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", new Object[] { Long.valueOf(300000L) });
  }
  
  public static void aY(Context paramContext)
  {
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(paramContext, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), 268435456));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    y.d("MicroMsg.TrafficStats", "onRecieve");
    long l1 = SystemClock.elapsedRealtime();
    bj.update();
    if (this.mLastTime >= 0L)
    {
      long l2 = l1 - this.mLastTime;
      long l3 = bj.crO() + bj.crN();
      long l4 = bj.crM() + bj.crL();
      long l5 = bj.crS() + bj.crR();
      long l6 = bj.crS() + bj.crR();
      y.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Double.valueOf((l3 + l4) / (l2 / 1000L)), Long.valueOf(l5), Long.valueOf(l6), Double.valueOf((l5 + l6) / (l2 / 1000L)) });
    }
    this.mLastTime = l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.TrafficStatsReceiver
 * JD-Core Version:    0.7.0.1
 */