package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface e
{
  public abstract void c(int paramInt, long paramLong1, long paramLong2);
  
  public abstract void c(d paramd);
  
  public abstract void c(String paramString, long paramLong1, long paramLong2);
  
  public abstract void d(Format paramFormat);
  
  public abstract void d(d paramd);
  
  public abstract void dI(int paramInt);
  
  public static final class a
  {
    final e aTI;
    final Handler handler;
    
    public a(Handler paramHandler, e parame)
    {
      AppMethodBeat.i(91769);
      if (parame != null) {}
      for (paramHandler = (Handler)a.checkNotNull(paramHandler);; paramHandler = null)
      {
        this.handler = paramHandler;
        this.aTI = parame;
        AppMethodBeat.o(91769);
        return;
      }
    }
    
    public final void e(final d paramd)
    {
      AppMethodBeat.i(91770);
      if (this.aTI != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(91767);
            e.a.this.aTI.d(paramd);
            AppMethodBeat.o(91767);
          }
        });
      }
      AppMethodBeat.o(91770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.e
 * JD-Core Version:    0.7.0.1
 */