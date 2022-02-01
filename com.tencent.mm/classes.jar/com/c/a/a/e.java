package com.c.a.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class e
{
  private a bMD;
  long bME;
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
  
  final void n(long paramLong1, long paramLong2)
  {
    stop();
    this.bME = paramLong1;
    this.bMD = new a((byte)0);
    a.a(this.bMD, paramLong2);
  }
  
  final void stop()
  {
    if (this.bMD != null) {
      a.a(this.bMD);
    }
  }
  
  abstract void yI();
  
  final class a
    implements Runnable
  {
    private boolean bMF;
    private boolean started;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(87957);
      if (this.bMF)
      {
        AppMethodBeat.o(87957);
        return;
      }
      e.this.yI();
      e.this.handler.postDelayed(this, e.this.bME);
      AppMethodBeat.o(87957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.e
 * JD-Core Version:    0.7.0.1
 */