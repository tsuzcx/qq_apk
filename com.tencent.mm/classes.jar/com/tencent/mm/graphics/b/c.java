package com.tencent.mm.graphics.b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

public enum c
  implements Choreographer.FrameCallback
{
  public Choreographer choreographer;
  private int eAQ;
  double eAR;
  private int eAS;
  public boolean eAT;
  private long frameStartTime;
  
  static
  {
    AppMethodBeat.i(57085);
    eAP = new c("INSTANCE");
    eAU = new c[] { eAP };
    AppMethodBeat.o(57085);
  }
  
  private c()
  {
    AppMethodBeat.i(57082);
    this.frameStartTime = 0L;
    this.eAQ = 0;
    this.eAR = 0.0D;
    this.eAS = 500;
    this.eAT = false;
    this.choreographer = Choreographer.getInstance();
    AppMethodBeat.o(57082);
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(57084);
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
      AppMethodBeat.o(57084);
      return;
      this.frameStartTime = paramLong;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(57083);
    this.frameStartTime = 0L;
    this.eAQ = 0;
    this.eAT = false;
    ab.i("MicroMsg.Metronome", "[stop] stack:%s", new Object[] { bo.dtY() });
    this.choreographer.removeFrameCallback(this);
    AppMethodBeat.o(57083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.b.c
 * JD-Core Version:    0.7.0.1
 */