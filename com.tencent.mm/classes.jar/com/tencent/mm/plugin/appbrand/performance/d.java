package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

@TargetApi(16)
public final class d
  implements Choreographer.FrameCallback
{
  boolean IL = true;
  Choreographer brd = Choreographer.getInstance();
  public a gWi;
  int gWy = 0;
  public volatile double gWz = 0.0D;
  long mFrameStartTime = 0L;
  public long mInterval = 200L;
  boolean sn = false;
  
  public final void doFrame(long paramLong)
  {
    double d1 = 60.0D;
    double d2;
    if ((this.IL) && (!this.sn))
    {
      paramLong /= 1000000L;
      if (this.mFrameStartTime <= 0L) {
        break label133;
      }
      long l = paramLong - this.mFrameStartTime;
      this.gWy += 1;
      if (l > this.mInterval)
      {
        d2 = this.gWy * 1000 / l;
        if (d2 < 60.0D) {
          break label141;
        }
      }
    }
    for (;;)
    {
      this.mFrameStartTime = paramLong;
      this.gWy = 0;
      this.gWz = d1;
      if (this.gWi != null) {
        this.gWi.r(d1);
      }
      for (;;)
      {
        if (this.IL) {
          this.brd.postFrameCallback(this);
        }
        return;
        label133:
        this.mFrameStartTime = paramLong;
      }
      label141:
      d1 = d2;
    }
  }
  
  public final void start()
  {
    this.IL = true;
    this.brd.postFrameCallback(this);
  }
  
  public static abstract interface a
  {
    public abstract void r(double paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.d
 * JD-Core Version:    0.7.0.1
 */