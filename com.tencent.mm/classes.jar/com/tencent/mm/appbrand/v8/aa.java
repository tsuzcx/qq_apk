package com.tencent.mm.appbrand.v8;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class aa
{
  private static final String TAG;
  private final MultiContextV8 cYm;
  private final int daX;
  private Integer daY;
  private boolean daZ;
  private int dba;
  private final Runnable dbb;
  private final ComponentCallbacks2 dbc;
  
  static
  {
    AppMethodBeat.i(144153);
    TAG = "MicroMsg.V8MemoryPressureMonitor" + ak.getProcessName().replace("com.tencent.mm", "");
    AppMethodBeat.o(144153);
  }
  
  public aa(MultiContextV8 paramMultiContextV8)
  {
    AppMethodBeat.i(144147);
    this.daX = 1000;
    this.daY = null;
    this.dba = 0;
    this.dbb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144144);
        aa.a(aa.this);
        AppMethodBeat.o(144144);
      }
    };
    this.cYm = paramMultiContextV8;
    this.dbc = new ComponentCallbacks2()
    {
      public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
      
      public final void onLowMemory()
      {
        AppMethodBeat.i(144146);
        ae.i(aa.TAG, "onLowMemory");
        aa.this.hB(2);
        ae.i(aa.TAG, "onLowMemory notification with CRITICAL end");
        AppMethodBeat.o(144146);
      }
      
      public final void onTrimMemory(int paramAnonymousInt)
      {
        AppMethodBeat.i(144145);
        ae.i(aa.TAG, "onTrimMemory level = [%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        Integer localInteger = aa.hD(paramAnonymousInt);
        if (localInteger != null) {
          aa.this.hB(localInteger.intValue());
        }
        AppMethodBeat.o(144145);
      }
    };
    AppMethodBeat.o(144147);
  }
  
  private static void NF()
  {
    AppMethodBeat.i(144150);
    ae.i(TAG, "startThrottlingInterval");
    AppMethodBeat.o(144150);
  }
  
  private void hC(int paramInt)
  {
    AppMethodBeat.i(144149);
    NF();
    this.dba = paramInt;
    String str;
    if (paramInt == 2) {
      str = "CRITICAL";
    }
    for (;;)
    {
      ae.i(TAG, "reportPressure [%s]", new Object[] { str });
      this.cYm.memoryPressureNotification(paramInt);
      AppMethodBeat.o(144149);
      return;
      if (paramInt == 1) {
        str = "MODERATE";
      } else {
        str = "NONE";
      }
    }
  }
  
  public final void hB(int paramInt)
  {
    AppMethodBeat.i(144148);
    if (this.daZ)
    {
      ae.i(TAG, "notifyPressure but throttle");
      this.daY = Integer.valueOf(paramInt);
      AppMethodBeat.o(144148);
      return;
    }
    hC(paramInt);
    AppMethodBeat.o(144148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.aa
 * JD-Core Version:    0.7.0.1
 */