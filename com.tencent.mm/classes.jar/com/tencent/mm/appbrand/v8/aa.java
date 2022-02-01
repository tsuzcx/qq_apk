package com.tencent.mm.appbrand.v8;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.mmv8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class aa
{
  private static final String TAG;
  private final MultiContextV8 fhw;
  private final int fko;
  private Integer fkp;
  private boolean fkq;
  private int fkr;
  private final Runnable fks;
  private final ComponentCallbacks2 fkt;
  
  static
  {
    AppMethodBeat.i(144153);
    TAG = "MicroMsg.V8MemoryPressureMonitor" + MMApplicationContext.getProcessName().replace(MMApplicationContext.getApplicationId(), "");
    AppMethodBeat.o(144153);
  }
  
  public aa(MultiContextV8 paramMultiContextV8)
  {
    AppMethodBeat.i(144147);
    this.fko = 1000;
    this.fkp = null;
    this.fkr = 0;
    this.fks = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144144);
        aa.a(aa.this);
        AppMethodBeat.o(144144);
      }
    };
    this.fhw = paramMultiContextV8;
    this.fkt = new ComponentCallbacks2()
    {
      public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
      
      public final void onLowMemory()
      {
        AppMethodBeat.i(144146);
        Log.i(aa.TAG, "onLowMemory");
        aa.this.kl(2);
        Log.i(aa.TAG, "onLowMemory notification with CRITICAL end");
        AppMethodBeat.o(144146);
      }
      
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(144145);
        Log.i(aa.TAG, "onTrimMemory level = [%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        Integer localInteger = aa.kn(paramAnonymousInt);
        if (localInteger != null) {
          aa.this.kl(localInteger.intValue());
        }
        AppMethodBeat.o(144145);
      }
    };
    AppMethodBeat.o(144147);
  }
  
  private static void acx()
  {
    AppMethodBeat.i(144150);
    Log.i(TAG, "startThrottlingInterval");
    AppMethodBeat.o(144150);
  }
  
  private void km(int paramInt)
  {
    AppMethodBeat.i(144149);
    acx();
    this.fkr = paramInt;
    String str;
    if (paramInt == 2) {
      str = "CRITICAL";
    }
    for (;;)
    {
      Log.i(TAG, "reportPressure [%s]", new Object[] { str });
      this.fhw.memoryPressureNotification(paramInt);
      AppMethodBeat.o(144149);
      return;
      if (paramInt == 1) {
        str = "MODERATE";
      } else {
        str = "NONE";
      }
    }
  }
  
  public final void kl(int paramInt)
  {
    AppMethodBeat.i(144148);
    if (this.fkq)
    {
      Log.i(TAG, "notifyPressure but throttle");
      this.fkp = Integer.valueOf(paramInt);
      AppMethodBeat.o(144148);
      return;
    }
    km(paramInt);
    AppMethodBeat.o(144148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.aa
 * JD-Core Version:    0.7.0.1
 */