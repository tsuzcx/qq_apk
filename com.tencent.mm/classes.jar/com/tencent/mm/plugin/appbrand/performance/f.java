package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(16)
public final class f
  implements Choreographer.FrameCallback
{
  private Choreographer fH;
  private boolean mEnabled;
  public long mInterval;
  public a nwI;
  private long nwY;
  private int nwZ;
  public volatile double nxa;
  
  public f()
  {
    AppMethodBeat.i(139905);
    this.nwY = 0L;
    this.nwZ = 0;
    this.mEnabled = false;
    this.nxa = 0.0D;
    this.fH = Choreographer.getInstance();
    this.mInterval = 200L;
    AppMethodBeat.o(139905);
  }
  
  public final void doFrame(long paramLong)
  {
    double d1 = 60.0D;
    AppMethodBeat.i(139908);
    double d2;
    if (this.mEnabled)
    {
      paramLong /= 1000000L;
      if (this.nwY <= 0L) {
        break label136;
      }
      long l = paramLong - this.nwY;
      this.nwZ += 1;
      if (l > this.mInterval)
      {
        d2 = this.nwZ * 1000 / l;
        if (d2 < 60.0D) {
          break label144;
        }
      }
    }
    for (;;)
    {
      this.nwY = paramLong;
      this.nwZ = 0;
      this.nxa = d1;
      if (this.nwI != null) {
        this.nwI.t(d1);
      }
      for (;;)
      {
        if (this.mEnabled) {
          this.fH.postFrameCallback(this);
        }
        AppMethodBeat.o(139908);
        return;
        label136:
        this.nwY = paramLong;
      }
      label144:
      d1 = d2;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(139906);
    if (this.mEnabled)
    {
      AppMethodBeat.o(139906);
      return;
    }
    this.mEnabled = true;
    Log.i("FPSMetronome", "[start] stack:%s", new Object[] { Util.getStack() });
    this.fH.postFrameCallback(this);
    AppMethodBeat.o(139906);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(139907);
    if (!this.mEnabled)
    {
      AppMethodBeat.o(139907);
      return;
    }
    this.mEnabled = false;
    this.nwY = 0L;
    this.nwZ = 0;
    Log.i("FPSMetronome", "[stop] stack:%s", new Object[] { Util.getStack() });
    this.fH.removeFrameCallback(this);
    AppMethodBeat.o(139907);
  }
  
  public static abstract interface a
  {
    public abstract void t(double paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.f
 * JD-Core Version:    0.7.0.1
 */