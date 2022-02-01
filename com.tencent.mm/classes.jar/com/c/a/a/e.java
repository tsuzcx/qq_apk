package com.c.a.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class e
{
  private a bOV;
  long bOW;
  final Handler handler;
  
  e(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      this.handler = paramHandler;
      return;
      paramHandler = new Handler();
    }
  }
  
  final void q(long paramLong1, long paramLong2)
  {
    stop();
    this.bOW = paramLong1;
    this.bOV = new a((byte)0);
    a.a(this.bOV, paramLong2);
  }
  
  final void stop()
  {
    if (this.bOV != null) {
      a.a(this.bOV);
    }
  }
  
  abstract void yV();
  
  final class a
    implements Runnable
  {
    private boolean bOX;
    private boolean started;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(87957);
      if (this.bOX)
      {
        AppMethodBeat.o(87957);
        return;
      }
      e.this.yV();
      e.this.handler.postDelayed(this, e.this.bOW);
      AppMethodBeat.o(87957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.e
 * JD-Core Version:    0.7.0.1
 */