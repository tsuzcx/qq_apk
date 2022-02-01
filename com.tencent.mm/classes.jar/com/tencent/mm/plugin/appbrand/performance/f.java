package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@TargetApi(16)
public final class f
  implements Choreographer.FrameCallback
{
  private Choreographer fF;
  private boolean mEnabled;
  public long mInterval;
  private int mhA;
  public volatile double mhB;
  public a mhl;
  private long mhz;
  
  public f()
  {
    AppMethodBeat.i(139905);
    this.mhz = 0L;
    this.mhA = 0;
    this.mEnabled = false;
    this.mhB = 0.0D;
    this.fF = Choreographer.getInstance();
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
      if (this.mhz <= 0L) {
        break label136;
      }
      long l = paramLong - this.mhz;
      this.mhA += 1;
      if (l > this.mInterval)
      {
        d2 = this.mhA * 1000 / l;
        if (d2 < 60.0D) {
          break label144;
        }
      }
    }
    for (;;)
    {
      this.mhz = paramLong;
      this.mhA = 0;
      this.mhB = d1;
      if (this.mhl != null) {
        this.mhl.s(d1);
      }
      for (;;)
      {
        if (this.mEnabled) {
          this.fF.postFrameCallback(this);
        }
        AppMethodBeat.o(139908);
        return;
        label136:
        this.mhz = paramLong;
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
    ad.i("FPSMetronome", "[start] stack:%s", new Object[] { bt.flS() });
    this.fF.postFrameCallback(this);
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
    this.mhz = 0L;
    this.mhA = 0;
    ad.i("FPSMetronome", "[stop] stack:%s", new Object[] { bt.flS() });
    this.fF.removeFrameCallback(this);
    AppMethodBeat.o(139907);
  }
  
  public static abstract interface a
  {
    public abstract void s(double paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.f
 * JD-Core Version:    0.7.0.1
 */