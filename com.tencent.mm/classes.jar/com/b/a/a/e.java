package com.b.a.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class e
{
  private a chy;
  long chz;
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
  
  abstract void IZ();
  
  final void n(long paramLong1, long paramLong2)
  {
    stop();
    this.chz = paramLong1;
    this.chy = new a((byte)0);
    a.a(this.chy, paramLong2);
  }
  
  final void stop()
  {
    if (this.chy != null) {
      a.a(this.chy);
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean chA;
    private boolean started;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(87957);
      if (this.chA)
      {
        AppMethodBeat.o(87957);
        return;
      }
      e.this.IZ();
      e.this.handler.postDelayed(this, e.this.chz);
      AppMethodBeat.o(87957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */