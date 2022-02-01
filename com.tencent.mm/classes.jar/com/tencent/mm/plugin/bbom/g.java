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
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  implements com.tencent.mm.plugin.zero.a.a
{
  private AddrBookObserver mLF;
  private WatchDogPushReceiver mLG;
  private TrafficStatsReceiver mLH;
  
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
        this.mLF = new AddrBookObserver(paramService);
        paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.euz(), true, this.mLF);
        this.mLG = new WatchDogPushReceiver();
        paramService.registerReceiver(this.mLG, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.mLH = new TrafficStatsReceiver();
        paramService.registerReceiver(this.mLH, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.bN(paramService);
        AppMethodBeat.o(22357);
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.mLF = null;
          ad.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public final void b(Service paramService)
  {
    AppMethodBeat.i(22358);
    if (this.mLF != null)
    {
      paramService.getContentResolver().unregisterContentObserver(this.mLF);
      this.mLF = null;
    }
    paramService.unregisterReceiver(this.mLG);
    paramService.unregisterReceiver(this.mLH);
    TrafficStatsReceiver.bO(paramService);
    AppMethodBeat.o(22358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.g
 * JD-Core Version:    0.7.0.1
 */