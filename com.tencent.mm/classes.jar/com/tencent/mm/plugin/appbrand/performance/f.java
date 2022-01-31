package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@TargetApi(16)
public final class f
  implements Choreographer.FrameCallback
{
  public f.a iAO;
  private Choreographer iBd;
  private long iBe;
  private int iBf;
  public volatile double iBg;
  private boolean mEnabled;
  public long mInterval;
  
  public f()
  {
    AppMethodBeat.i(114391);
    this.iBe = 0L;
    this.iBf = 0;
    this.mEnabled = true;
    this.iBg = 0.0D;
    this.iBd = Choreographer.getInstance();
    this.mInterval = 200L;
    AppMethodBeat.o(114391);
  }
  
  public final void doFrame(long paramLong)
  {
    double d1 = 60.0D;
    AppMethodBeat.i(114394);
    double d2;
    if (this.mEnabled)
    {
      paramLong /= 1000000L;
      if (this.iBe <= 0L) {
        break label136;
      }
      long l = paramLong - this.iBe;
      this.iBf += 1;
      if (l > this.mInterval)
      {
        d2 = this.iBf * 1000 / l;
        if (d2 < 60.0D) {
          break label144;
        }
      }
    }
    for (;;)
    {
      this.iBe = paramLong;
      this.iBf = 0;
      this.iBg = d1;
      if (this.iAO != null) {
        this.iAO.u(d1);
      }
      for (;;)
      {
        if (this.mEnabled) {
          this.iBd.postFrameCallback(this);
        }
        AppMethodBeat.o(114394);
        return;
        label136:
        this.iBe = paramLong;
      }
      label144:
      d1 = d2;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(114392);
    if (this.mEnabled)
    {
      AppMethodBeat.o(114392);
      return;
    }
    this.mEnabled = true;
    ab.i("FPSMetronome", "[start] stack:%s", new Object[] { bo.dtY() });
    this.iBd.postFrameCallback(this);
    AppMethodBeat.o(114392);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(114393);
    if (!this.mEnabled)
    {
      AppMethodBeat.o(114393);
      return;
    }
    this.mEnabled = false;
    this.iBe = 0L;
    this.iBf = 0;
    ab.i("FPSMetronome", "[stop] stack:%s", new Object[] { bo.dtY() });
    this.iBd.removeFrameCallback(this);
    AppMethodBeat.o(114393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.f
 * JD-Core Version:    0.7.0.1
 */