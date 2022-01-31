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
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  implements com.tencent.mm.plugin.zero.a.a
{
  private AddrBookObserver jMD;
  private WatchDogPushReceiver jME;
  private TrafficStatsReceiver jMF;
  
  public final void a(Service paramService)
  {
    AppMethodBeat.i(18256);
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
        this.jMD = new AddrBookObserver(paramService);
        paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.dkO(), true, this.jMD);
        this.jME = new WatchDogPushReceiver();
        paramService.registerReceiver(this.jME, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.jMF = new TrafficStatsReceiver();
        paramService.registerReceiver(this.jMF, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.bz(paramService);
        AppMethodBeat.o(18256);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.jMD = null;
          ab.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void b(Service paramService)
  {
    AppMethodBeat.i(18257);
    if (this.jMD != null)
    {
      paramService.getContentResolver().unregisterContentObserver(this.jMD);
      this.jMD = null;
    }
    paramService.unregisterReceiver(this.jME);
    paramService.unregisterReceiver(this.jMF);
    TrafficStatsReceiver.bA(paramService);
    AppMethodBeat.o(18257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.g
 * JD-Core Version:    0.7.0.1
 */