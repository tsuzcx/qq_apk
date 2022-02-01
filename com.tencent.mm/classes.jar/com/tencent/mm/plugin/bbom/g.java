package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.ContentResolver;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  implements com.tencent.mm.plugin.zero.a.a
{
  private AddrBookObserver nnO;
  private WatchDogPushReceiver nnP;
  private TrafficStatsReceiver nnQ;
  
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
        bool2 = b.o(paramService.getApplicationContext(), "android.permission.READ_CONTACTS");
      }
      if (bool2) {}
      try
      {
        this.nnO = new AddrBookObserver(paramService);
        paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.eJS(), true, this.nnO);
        this.nnP = new WatchDogPushReceiver();
        paramService.registerReceiver(this.nnP, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.nnQ = new TrafficStatsReceiver();
        paramService.registerReceiver(this.nnQ, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.bQ(paramService);
        AppMethodBeat.o(22357);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.nnO = null;
          ac.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void b(Service paramService)
  {
    AppMethodBeat.i(22358);
    if (this.nnO != null)
    {
      paramService.getContentResolver().unregisterContentObserver(this.nnO);
      this.nnO = null;
    }
    paramService.unregisterReceiver(this.nnP);
    paramService.unregisterReceiver(this.nnQ);
    TrafficStatsReceiver.bR(paramService);
    AppMethodBeat.o(22358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.g
 * JD-Core Version:    0.7.0.1
 */