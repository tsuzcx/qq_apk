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
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  implements a
{
  private AddrBookObserver nUi;
  private WatchDogPushReceiver nUj;
  private TrafficStatsReceiver nUk;
  
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
        bool2 = com.tencent.mm.pluginsdk.permission.b.n(paramService.getApplicationContext(), "android.permission.READ_CONTACTS");
      }
      if (bool2) {}
      try
      {
        this.nUi = new AddrBookObserver(paramService);
        paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.b.fcu(), true, this.nUi);
        this.nUj = new WatchDogPushReceiver();
        paramService.registerReceiver(this.nUj, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.nUk = new TrafficStatsReceiver();
        paramService.registerReceiver(this.nUk, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.bR(paramService);
        AppMethodBeat.o(22357);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.nUi = null;
          ae.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void b(Service paramService)
  {
    AppMethodBeat.i(22358);
    if (this.nUi != null)
    {
      paramService.getContentResolver().unregisterContentObserver(this.nUi);
      this.nUi = null;
    }
    paramService.unregisterReceiver(this.nUj);
    paramService.unregisterReceiver(this.nUk);
    TrafficStatsReceiver.bS(paramService);
    AppMethodBeat.o(22358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.g
 * JD-Core Version:    0.7.0.1
 */