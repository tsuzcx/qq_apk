package com.d.a.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class e
{
  private a bWQ;
  long bWR;
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
  
  abstract void Ag();
  
  final void n(long paramLong1, long paramLong2)
  {
    stop();
    this.bWR = paramLong1;
    this.bWQ = new a((byte)0);
    a.a(this.bWQ, paramLong2);
  }
  
  final void stop()
  {
    if (this.bWQ != null) {
      a.a(this.bWQ);
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean bWS;
    private boolean started;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(87957);
      if (this.bWS)
      {
        AppMethodBeat.o(87957);
        return;
      }
      e.this.Ag();
      e.this.handler.postDelayed(this, e.this.bWR);
      AppMethodBeat.o(87957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */