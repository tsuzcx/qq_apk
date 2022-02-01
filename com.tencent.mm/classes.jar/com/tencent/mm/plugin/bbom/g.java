package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.ContentResolver;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.plugin.zero.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  implements a
{
  private AddrBookObserver sha;
  private WatchDogPushReceiver shb;
  private TrafficStatsReceiver shc;
  
  public final void a(Service paramService)
  {
    AppMethodBeat.i(22357);
    boolean bool1;
    if (Build.VERSION.SDK_INT < 26) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = com.tencent.mm.pluginsdk.permission.b.o(paramService.getApplicationContext(), "android.permission.READ_CONTACTS");
      }
      if (bool2) {}
      try
      {
        this.sha = new AddrBookObserver(paramService);
        paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.b.hfw(), true, this.sha);
        this.shb = new WatchDogPushReceiver();
        paramService.registerReceiver(this.shb, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.shc = new TrafficStatsReceiver();
        paramService.registerReceiver(this.shc, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.ci(paramService);
        AppMethodBeat.o(22357);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.sha = null;
          Log.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void b(Service paramService)
  {
    AppMethodBeat.i(22358);
    if (this.sha != null)
    {
      paramService.getContentResolver().unregisterContentObserver(this.sha);
      this.sha = null;
    }
    paramService.unregisterReceiver(this.shb);
    paramService.unregisterReceiver(this.shc);
    TrafficStatsReceiver.cj(paramService);
    AppMethodBeat.o(22358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.g
 * JD-Core Version:    0.7.0.1
 */