package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

@TargetApi(16)
public final class f
  implements Choreographer.FrameCallback
{
  private Choreographer dL;
  private long lHO;
  private int lHP;
  public volatile double lHQ;
  public a lHz;
  private boolean mEnabled;
  public long mInterval;
  
  public f()
  {
    AppMethodBeat.i(139905);
    this.lHO = 0L;
    this.lHP = 0;
    this.mEnabled = false;
    this.lHQ = 0.0D;
    this.dL = Choreographer.getInstance();
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
      if (this.lHO <= 0L) {
        break label136;
      }
      long l = paramLong - this.lHO;
      this.lHP += 1;
      if (l > this.mInterval)
      {
        d2 = this.lHP * 1000 / l;
        if (d2 < 60.0D) {
          break label144;
        }
      }
    }
    for (;;)
    {
      this.lHO = paramLong;
      this.lHP = 0;
      this.lHQ = d1;
      if (this.lHz != null) {
        this.lHz.s(d1);
      }
      for (;;)
      {
        if (this.mEnabled) {
          this.dL.postFrameCallback(this);
        }
        AppMethodBeat.o(139908);
        return;
        label136:
        this.lHO = paramLong;
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
    ac.i("FPSMetronome", "[start] stack:%s", new Object[] { bs.eWi() });
    this.dL.postFrameCallback(this);
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
    this.lHO = 0L;
    this.lHP = 0;
    ac.i("FPSMetronome", "[stop] stack:%s", new Object[] { bs.eWi() });
    this.dL.removeFrameCallback(this);
    AppMethodBeat.o(139907);
  }
  
  public static abstract interface a
  {
    public abstract void s(double paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.f
 * JD-Core Version:    0.7.0.1
 */