package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface e
{
  public abstract void a(d paramd);
  
  public abstract void b(int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  public abstract void b(d paramd);
  
  public abstract void b(String paramString, long paramLong1, long paramLong2);
  
  public abstract void c(Format paramFormat);
  
  public abstract void f(Surface paramSurface);
  
  public abstract void h(int paramInt, long paramLong);
  
  public static final class a
  {
    final e dmf;
    final Handler handler;
    
    public a(Handler paramHandler, e parame)
    {
      AppMethodBeat.i(93316);
      if (parame != null) {}
      for (paramHandler = (Handler)a.checkNotNull(paramHandler);; paramHandler = null)
      {
        this.handler = paramHandler;
        this.dmf = parame;
        AppMethodBeat.o(93316);
        return;
      }
    }
    
    public final void c(final int paramInt1, final int paramInt2, final int paramInt3, final float paramFloat)
    {
      AppMethodBeat.i(93318);
      if (this.dmf != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(93313);
            e.a.this.dmf.b(paramInt1, paramInt2, paramInt3, paramFloat);
            AppMethodBeat.o(93313);
          }
        });
      }
      AppMethodBeat.o(93318);
    }
    
    public final void e(final d paramd)
    {
      AppMethodBeat.i(93320);
      if (this.dmf != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(93315);
            e.a.this.dmf.b(paramd);
            AppMethodBeat.o(93315);
          }
        });
      }
      AppMethodBeat.o(93320);
    }
    
    public final void g(final Surface paramSurface)
    {
      AppMethodBeat.i(93319);
      if (this.dmf != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(93314);
            e.a.this.dmf.f(paramSurface);
            AppMethodBeat.o(93314);
          }
        });
      }
      AppMethodBeat.o(93319);
    }
    
    public final void m(final int paramInt, final long paramLong)
    {
      AppMethodBeat.i(93317);
      if (this.dmf != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(93312);
            e.a.this.dmf.h(paramInt, paramLong);
            AppMethodBeat.o(93312);
          }
        });
      }
      AppMethodBeat.o(93317);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.video.e
 * JD-Core Version:    0.7.0.1
 */