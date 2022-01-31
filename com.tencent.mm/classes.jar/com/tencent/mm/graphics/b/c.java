package com.tencent.mm.graphics.b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.concurrent.TimeUnit;

public enum c
  implements Choreographer.FrameCallback
{
  public Choreographer aUi = Choreographer.getInstance();
  public int dDp = 0;
  double dDq = 0.0D;
  private int dDr = 500;
  public boolean dDs = false;
  public long frameStartTime = 0L;
  
  private c() {}
  
  public final void doFrame(long paramLong)
  {
    paramLong = TimeUnit.NANOSECONDS.toMillis(paramLong);
    if (this.frameStartTime > 0L)
    {
      long l = paramLong - this.frameStartTime;
      this.dDp += 1;
      if (l > this.dDr)
      {
        this.dDq = (this.dDp * 1000 / l);
        this.frameStartTime = paramLong;
        this.dDp = 0;
      }
    }
    for (;;)
    {
      this.aUi.postFrameCallback(this);
      return;
      this.frameStartTime = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.b.c
 * JD-Core Version:    0.7.0.1
 */