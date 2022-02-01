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
  public a lhG;
  private Choreographer lhV;
  private long lhW;
  private int lhX;
  public volatile double lhY;
  private boolean mEnabled;
  public long mInterval;
  
  public f()
  {
    AppMethodBeat.i(139905);
    this.lhW = 0L;
    this.lhX = 0;
    this.mEnabled = false;
    this.lhY = 0.0D;
    this.lhV = Choreographer.getInstance();
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
      if (this.lhW <= 0L) {
        break label136;
      }
      long l = paramLong - this.lhW;
      this.lhX += 1;
      if (l > this.mInterval)
      {
        d2 = this.lhX * 1000 / l;
        if (d2 < 60.0D) {
          break label144;
        }
      }
    }
    for (;;)
    {
      this.lhW = paramLong;
      this.lhX = 0;
      this.lhY = d1;
      if (this.lhG != null) {
        this.lhG.t(d1);
      }
      for (;;)
      {
        if (this.mEnabled) {
          this.lhV.postFrameCallback(this);
        }
        AppMethodBeat.o(139908);
        return;
        label136:
        this.lhW = paramLong;
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
    ad.i("FPSMetronome", "[start] stack:%s", new Object[] { bt.eGN() });
    this.lhV.postFrameCallback(this);
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
    this.lhW = 0L;
    this.lhX = 0;
    ad.i("FPSMetronome", "[stop] stack:%s", new Object[] { bt.eGN() });
    this.lhV.removeFrameCallback(this);
    AppMethodBeat.o(139907);
  }
  
  public static abstract interface a
  {
    public abstract void t(double paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.f
 * JD-Core Version:    0.7.0.1
 */