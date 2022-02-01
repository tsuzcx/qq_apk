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
  private AddrBookObserver vsV;
  private WatchDogPushReceiver vsW;
  private TrafficStatsReceiver vsX;
  
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
        bool2 = com.tencent.mm.pluginsdk.permission.b.s(paramService.getApplicationContext(), "android.permission.READ_CONTACTS");
      }
      if (bool2) {}
      try
      {
        this.vsV = new AddrBookObserver(paramService);
        paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.b.iGs(), true, this.vsV);
        this.vsW = new WatchDogPushReceiver();
        paramService.registerReceiver(this.vsW, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.vsX = new TrafficStatsReceiver();
        paramService.registerReceiver(this.vsX, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.cU(paramService);
        AppMethodBeat.o(22357);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.vsV = null;
          Log.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void b(Service paramService)
  {
    AppMethodBeat.i(22358);
    if (this.vsV != null)
    {
      paramService.getContentResolver().unregisterContentObserver(this.vsV);
      this.vsV = null;
    }
    paramService.unregisterReceiver(this.vsW);
    paramService.unregisterReceiver(this.vsX);
    TrafficStatsReceiver.cV(paramService);
    AppMethodBeat.o(22358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.g
 * JD-Core Version:    0.7.0.1
 */