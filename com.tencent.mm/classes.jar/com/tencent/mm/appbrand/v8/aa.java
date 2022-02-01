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
  private final MultiContextV8 hlG;
  private final int hoB;
  private Integer hoC;
  private boolean hoD;
  private int hoE;
  private final Runnable hoF;
  private final ComponentCallbacks2 hoG;
  
  static
  {
    AppMethodBeat.i(144153);
    TAG = "MicroMsg.V8MemoryPressureMonitor" + MMApplicationContext.getProcessName().replace(MMApplicationContext.getApplicationId(), "");
    AppMethodBeat.o(144153);
  }
  
  public aa(MultiContextV8 paramMultiContextV8)
  {
    AppMethodBeat.i(144147);
    this.hoB = 1000;
    this.hoC = null;
    this.hoE = 0;
    this.hoF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144144);
        aa.a(aa.this);
        AppMethodBeat.o(144144);
      }
    };
    this.hlG = paramMultiContextV8;
    this.hoG = new ComponentCallbacks2()
    {
      public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
      
      public final void onLowMemory()
      {
        AppMethodBeat.i(144146);
        Log.i(aa.TAG, "onLowMemory");
        aa.this.nT(2);
        Log.i(aa.TAG, "onLowMemory notification with CRITICAL end");
        AppMethodBeat.o(144146);
      }
      
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(144145);
        Log.i(aa.TAG, "onTrimMemory level = [%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        Integer localInteger = aa.nV(paramAnonymousInt);
        if (localInteger != null) {
          aa.this.nT(localInteger.intValue());
        }
        AppMethodBeat.o(144145);
      }
    };
    AppMethodBeat.o(144147);
  }
  
  private static void aEx()
  {
    AppMethodBeat.i(144150);
    Log.i(TAG, "startThrottlingInterval");
    AppMethodBeat.o(144150);
  }
  
  private void nU(int paramInt)
  {
    AppMethodBeat.i(144149);
    aEx();
    this.hoE = paramInt;
    String str;
    if (paramInt == 2) {
      str = "CRITICAL";
    }
    for (;;)
    {
      Log.i(TAG, "reportPressure [%s]", new Object[] { str });
      this.hlG.memoryPressureNotification(paramInt);
      AppMethodBeat.o(144149);
      return;
      if (paramInt == 1) {
        str = "MODERATE";
      } else {
        str = "NONE";
      }
    }
  }
  
  public final void nT(int paramInt)
  {
    AppMethodBeat.i(144148);
    if (this.hoD)
    {
      Log.i(TAG, "notifyPressure but throttle");
      this.hoC = Integer.valueOf(paramInt);
      AppMethodBeat.o(144148);
      return;
    }
    nU(paramInt);
    AppMethodBeat.o(144148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.aa
 * JD-Core Version:    0.7.0.1
 */