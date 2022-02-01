package com.tencent.mm.appbrand.v8;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class aa
{
  private static final String TAG;
  private final MultiContextV8 doQ;
  private final int drC;
  private Integer drD;
  private boolean drE;
  private int drF;
  private final Runnable drG;
  private final ComponentCallbacks2 drH;
  
  static
  {
    AppMethodBeat.i(144153);
    TAG = "MicroMsg.V8MemoryPressureMonitor" + MMApplicationContext.getProcessName().replace(MMApplicationContext.getApplicationId(), "");
    AppMethodBeat.o(144153);
  }
  
  public aa(MultiContextV8 paramMultiContextV8)
  {
    AppMethodBeat.i(144147);
    this.drC = 1000;
    this.drD = null;
    this.drF = 0;
    this.drG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144144);
        aa.a(aa.this);
        AppMethodBeat.o(144144);
      }
    };
    this.doQ = paramMultiContextV8;
    this.drH = new ComponentCallbacks2()
    {
      public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
      
      public final void onLowMemory()
      {
        AppMethodBeat.i(144146);
        Log.i(aa.TAG, "onLowMemory");
        aa.this.iV(2);
        Log.i(aa.TAG, "onLowMemory notification with CRITICAL end");
        AppMethodBeat.o(144146);
      }
      
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(144145);
        Log.i(aa.TAG, "onTrimMemory level = [%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        Integer localInteger = aa.iX(paramAnonymousInt);
        if (localInteger != null) {
          aa.this.iV(localInteger.intValue());
        }
        AppMethodBeat.o(144145);
      }
    };
    AppMethodBeat.o(144147);
  }
  
  private static void XR()
  {
    AppMethodBeat.i(144150);
    Log.i(TAG, "startThrottlingInterval");
    AppMethodBeat.o(144150);
  }
  
  private void iW(int paramInt)
  {
    AppMethodBeat.i(144149);
    XR();
    this.drF = paramInt;
    String str;
    if (paramInt == 2) {
      str = "CRITICAL";
    }
    for (;;)
    {
      Log.i(TAG, "reportPressure [%s]", new Object[] { str });
      this.doQ.memoryPressureNotification(paramInt);
      AppMethodBeat.o(144149);
      return;
      if (paramInt == 1) {
        str = "MODERATE";
      } else {
        str = "NONE";
      }
    }
  }
  
  public final void iV(int paramInt)
  {
    AppMethodBeat.i(144148);
    if (this.drE)
    {
      Log.i(TAG, "notifyPressure but throttle");
      this.drD = Integer.valueOf(paramInt);
      AppMethodBeat.o(144148);
      return;
    }
    iW(paramInt);
    AppMethodBeat.o(144148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.aa
 * JD-Core Version:    0.7.0.1
 */