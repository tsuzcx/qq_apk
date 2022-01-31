package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public enum c
  implements Choreographer.FrameCallback
{
  public Choreographer choreographer;
  public int eAQ;
  double eAR;
  private int eAS;
  public boolean eAT;
  public long frameStartTime;
  
  static
  {
    AppMethodBeat.i(134243);
    jiO = new c("INSTANCE");
    jiP = new c[] { jiO };
    AppMethodBeat.o(134243);
  }
  
  private c()
  {
    AppMethodBeat.i(134241);
    this.frameStartTime = 0L;
    this.eAQ = 0;
    this.eAR = 0.0D;
    this.eAS = 500;
    this.eAT = false;
    this.choreographer = Choreographer.getInstance();
    AppMethodBeat.o(134241);
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(134242);
    paramLong = TimeUnit.NANOSECONDS.toMillis(paramLong);
    if (this.frameStartTime > 0L)
    {
      long l = paramLong - this.frameStartTime;
      this.eAQ += 1;
      if (l > this.eAS)
      {
        this.eAR = (this.eAQ * 1000 / l);
        this.frameStartTime = paramLong;
        this.eAQ = 0;
      }
    }
    for (;;)
    {
      this.choreographer.postFrameCallback(this);
      AppMethodBeat.o(134242);
      return;
      this.frameStartTime = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.c
 * JD-Core Version:    0.7.0.1
 */