package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.ContentResolver;
import android.content.IntentFilter;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;

public final class g
  implements com.tencent.mm.plugin.zero.a.a
{
  private AddrBookObserver hSQ;
  private WatchDogPushReceiver hSR;
  private TrafficStatsReceiver hSS;
  
  public final void a(Service paramService)
  {
    this.hSQ = new AddrBookObserver(paramService);
    paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.ckj(), true, this.hSQ);
    this.hSR = new WatchDogPushReceiver();
    paramService.registerReceiver(this.hSR, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
    this.hSS = new TrafficStatsReceiver();
    paramService.registerReceiver(this.hSS, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
    TrafficStatsReceiver.aX(paramService);
  }
  
  public final void b(Service paramService)
  {
    paramService.getContentResolver().unregisterContentObserver(this.hSQ);
    paramService.unregisterReceiver(this.hSR);
    paramService.unregisterReceiver(this.hSS);
    TrafficStatsReceiver.aY(paramService);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.g
 * JD-Core Version:    0.7.0.1
 */