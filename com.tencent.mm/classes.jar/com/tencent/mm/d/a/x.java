package com.tencent.mm.d.a;

import android.content.ComponentCallbacks2;
import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class x
{
  private static final String TAG;
  private final MultiContextV8 cba;
  private final int ccE;
  private Integer ccF;
  private boolean ccG;
  private int ccH;
  private final Runnable ccI;
  private final ComponentCallbacks2 ccJ;
  
  static
  {
    AppMethodBeat.i(113928);
    TAG = "MicroMsg.V8MemoryPressureMonitor" + ah.getProcessName().replace("com.tencent.mm", "");
    AppMethodBeat.o(113928);
  }
  
  public x(MultiContextV8 paramMultiContextV8)
  {
    AppMethodBeat.i(113922);
    this.ccE = 1000;
    this.ccF = null;
    this.ccH = 0;
    this.ccI = new x.1(this);
    this.cba = paramMultiContextV8;
    this.ccJ = new x.2(this);
    AppMethodBeat.o(113922);
  }
  
  private static void Cy()
  {
    AppMethodBeat.i(113925);
    ab.i(TAG, "startThrottlingInterval");
    AppMethodBeat.o(113925);
  }
  
  private void gm(int paramInt)
  {
    AppMethodBeat.i(113924);
    Cy();
    this.ccH = paramInt;
    String str;
    if (paramInt == 2) {
      str = "CRITICAL";
    }
    for (;;)
    {
      ab.i(TAG, "reportPressure [%s]", new Object[] { str });
      this.cba.memoryPressureNotification(paramInt);
      AppMethodBeat.o(113924);
      return;
      if (paramInt == 1) {
        str = "MODERATE";
      } else {
        str = "NONE";
      }
    }
  }
  
  public final void gl(int paramInt)
  {
    AppMethodBeat.i(113923);
    if (this.ccG)
    {
      ab.i(TAG, "notifyPressure but throttle");
      this.ccF = Integer.valueOf(paramInt);
      AppMethodBeat.o(113923);
      return;
    }
    gm(paramInt);
    AppMethodBeat.o(113923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.x
 * JD-Core Version:    0.7.0.1
 */