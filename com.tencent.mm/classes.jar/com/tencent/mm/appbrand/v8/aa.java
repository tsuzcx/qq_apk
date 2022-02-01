package com.tencent.mm.appbrand.v8;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class aa
{
  private static final String TAG;
  private final MultiContextV8 cMb;
  private final int cOF;
  private Integer cOG;
  private boolean cOH;
  private int cOI;
  private final Runnable cOJ;
  private final ComponentCallbacks2 cOK;
  
  static
  {
    AppMethodBeat.i(144153);
    TAG = "MicroMsg.V8MemoryPressureMonitor" + ai.getProcessName().replace("com.tencent.mm", "");
    AppMethodBeat.o(144153);
  }
  
  public aa(MultiContextV8 paramMultiContextV8)
  {
    AppMethodBeat.i(144147);
    this.cOF = 1000;
    this.cOG = null;
    this.cOI = 0;
    this.cOJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144144);
        aa.a(aa.this);
        AppMethodBeat.o(144144);
      }
    };
    this.cMb = paramMultiContextV8;
    this.cOK = new ComponentCallbacks2()
    {
      public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
      
      public final void onLowMemory()
      {
        AppMethodBeat.i(144146);
        ac.i(aa.TAG, "onLowMemory");
        aa.this.hs(2);
        ac.i(aa.TAG, "onLowMemory notification with CRITICAL end");
        AppMethodBeat.o(144146);
      }
      
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(144145);
        ac.i(aa.TAG, "onTrimMemory level = [%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        Integer localInteger = aa.hu(paramAnonymousInt);
        if (localInteger != null) {
          aa.this.hs(localInteger.intValue());
        }
        AppMethodBeat.o(144145);
      }
    };
    AppMethodBeat.o(144147);
  }
  
  private static void LY()
  {
    AppMethodBeat.i(144150);
    ac.i(TAG, "startThrottlingInterval");
    AppMethodBeat.o(144150);
  }
  
  private void ht(int paramInt)
  {
    AppMethodBeat.i(144149);
    LY();
    this.cOI = paramInt;
    String str;
    if (paramInt == 2) {
      str = "CRITICAL";
    }
    for (;;)
    {
      ac.i(TAG, "reportPressure [%s]", new Object[] { str });
      this.cMb.memoryPressureNotification(paramInt);
      AppMethodBeat.o(144149);
      return;
      if (paramInt == 1) {
        str = "MODERATE";
      } else {
        str = "NONE";
      }
    }
  }
  
  public final void hs(int paramInt)
  {
    AppMethodBeat.i(144148);
    if (this.cOH)
    {
      ac.i(TAG, "notifyPressure but throttle");
      this.cOG = Integer.valueOf(paramInt);
      AppMethodBeat.o(144148);
      return;
    }
    ht(paramInt);
    AppMethodBeat.o(144148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.aa
 * JD-Core Version:    0.7.0.1
 */