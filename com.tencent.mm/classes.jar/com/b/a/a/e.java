package com.b.a.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class e
{
  private a bmv;
  long bmw;
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
  
  final void p(long paramLong1, long paramLong2)
  {
    stop();
    this.bmw = paramLong1;
    this.bmv = new a((byte)0);
    a.a(this.bmv, paramLong2);
  }
  
  final void stop()
  {
    if (this.bmv != null) {
      a.a(this.bmv);
    }
  }
  
  abstract void th();
  
  final class a
    implements Runnable
  {
    private boolean bmx;
    private boolean started;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(55612);
      if (this.bmx)
      {
        AppMethodBeat.o(55612);
        return;
      }
      e.this.th();
      e.this.handler.postDelayed(this, e.this.bmw);
      AppMethodBeat.o(55612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */