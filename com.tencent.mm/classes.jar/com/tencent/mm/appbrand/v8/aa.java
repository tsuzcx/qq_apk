package com.tencent.mm.appbrand.v8;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class aa
{
  private static final String TAG;
  private final MultiContextV8 cOG;
  private final int cRk;
  private Integer cRl;
  private boolean cRm;
  private int cRn;
  private final Runnable cRo;
  private final ComponentCallbacks2 cRp;
  
  static
  {
    AppMethodBeat.i(144153);
    TAG = "MicroMsg.V8MemoryPressureMonitor" + aj.getProcessName().replace("com.tencent.mm", "");
    AppMethodBeat.o(144153);
  }
  
  public aa(MultiContextV8 paramMultiContextV8)
  {
    AppMethodBeat.i(144147);
    this.cRk = 1000;
    this.cRl = null;
    this.cRn = 0;
    this.cRo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144144);
        aa.a(aa.this);
        AppMethodBeat.o(144144);
      }
    };
    this.cOG = paramMultiContextV8;
    this.cRp = new ComponentCallbacks2()
    {
      public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
      
      public final void onLowMemory()
      {
        AppMethodBeat.i(144146);
        ad.i(aa.TAG, "onLowMemory");
        aa.this.hI(2);
        ad.i(aa.TAG, "onLowMemory notification with CRITICAL end");
        AppMethodBeat.o(144146);
      }
      
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(144145);
        ad.i(aa.TAG, "onTrimMemory level = [%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        Integer localInteger = aa.hK(paramAnonymousInt);
        if (localInteger != null) {
          aa.this.hI(localInteger.intValue());
        }
        AppMethodBeat.o(144145);
      }
    };
    AppMethodBeat.o(144147);
  }
  
  private static void Ma()
  {
    AppMethodBeat.i(144150);
    ad.i(TAG, "startThrottlingInterval");
    AppMethodBeat.o(144150);
  }
  
  private void hJ(int paramInt)
  {
    AppMethodBeat.i(144149);
    Ma();
    this.cRn = paramInt;
    String str;
    if (paramInt == 2) {
      str = "CRITICAL";
    }
    for (;;)
    {
      ad.i(TAG, "reportPressure [%s]", new Object[] { str });
      this.cOG.memoryPressureNotification(paramInt);
      AppMethodBeat.o(144149);
      return;
      if (paramInt == 1) {
        str = "MODERATE";
      } else {
        str = "NONE";
      }
    }
  }
  
  public final void hI(int paramInt)
  {
    AppMethodBeat.i(144148);
    if (this.cRm)
    {
      ad.i(TAG, "notifyPressure but throttle");
      this.cRl = Integer.valueOf(paramInt);
      AppMethodBeat.o(144148);
      return;
    }
    hJ(paramInt);
    AppMethodBeat.o(144148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.aa
 * JD-Core Version:    0.7.0.1
 */