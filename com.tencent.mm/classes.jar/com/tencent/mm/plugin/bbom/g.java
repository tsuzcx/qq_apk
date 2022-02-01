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
  private AddrBookObserver peW;
  private WatchDogPushReceiver peX;
  private TrafficStatsReceiver peY;
  
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
        this.peW = new AddrBookObserver(paramService);
        paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.b.glF(), true, this.peW);
        this.peX = new WatchDogPushReceiver();
        paramService.registerReceiver(this.peX, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.peY = new TrafficStatsReceiver();
        paramService.registerReceiver(this.peY, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.cm(paramService);
        AppMethodBeat.o(22357);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.peW = null;
          Log.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void b(Service paramService)
  {
    AppMethodBeat.i(22358);
    if (this.peW != null)
    {
      paramService.getContentResolver().unregisterContentObserver(this.peW);
      this.peW = null;
    }
    paramService.unregisterReceiver(this.peX);
    paramService.unregisterReceiver(this.peY);
    TrafficStatsReceiver.cn(paramService);
    AppMethodBeat.o(22358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.g
 * JD-Core Version:    0.7.0.1
 */