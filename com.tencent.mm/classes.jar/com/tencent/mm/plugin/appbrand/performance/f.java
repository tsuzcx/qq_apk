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
  private Choreographer SG;
  public volatile double mCurrentFps;
  private boolean mEnabled;
  public long mInterval;
  private long qza;
  private int qzb;
  public a qzc;
  
  public f()
  {
    AppMethodBeat.i(139905);
    this.qza = 0L;
    this.qzb = 0;
    this.mEnabled = false;
    this.mCurrentFps = 0.0D;
    this.SG = Choreographer.getInstance();
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
      if (this.qza <= 0L) {
        break label136;
      }
      long l = paramLong - this.qza;
      this.qzb += 1;
      if (l > this.mInterval)
      {
        d2 = this.qzb * 1000 / l;
        if (d2 < 60.0D) {
          break label144;
        }
      }
    }
    for (;;)
    {
      this.qza = paramLong;
      this.qzb = 0;
      this.mCurrentFps = d1;
      if (this.qzc != null) {
        this.qzc.t(d1);
      }
      for (;;)
      {
        if (this.mEnabled) {
          this.SG.postFrameCallback(this);
        }
        AppMethodBeat.o(139908);
        return;
        label136:
        this.qza = paramLong;
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
    this.SG.postFrameCallback(this);
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
    this.qza = 0L;
    this.qzb = 0;
    Log.i("FPSMetronome", "[stop] stack:%s", new Object[] { Util.getStack() });
    this.SG.removeFrameCallback(this);
    AppMethodBeat.o(139907);
  }
  
  public static abstract interface a
  {
    public abstract void t(double paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.f
 * JD-Core Version:    0.7.0.1
 */