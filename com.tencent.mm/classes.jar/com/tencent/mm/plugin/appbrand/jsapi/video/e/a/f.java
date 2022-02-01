package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  volatile boolean ksX;
  int ksY;
  Handler ksZ;
  b kta;
  a ktb;
  
  f(Handler paramHandler)
  {
    AppMethodBeat.i(194188);
    this.ksX = false;
    this.ksY = 1000;
    this.ktb = new a((byte)0);
    this.ksZ = paramHandler;
    AppMethodBeat.o(194188);
  }
  
  final void start()
  {
    AppMethodBeat.i(194189);
    if (!this.ksX)
    {
      this.ksX = true;
      this.ktb.bdR();
    }
    AppMethodBeat.o(194189);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    final void bdR()
    {
      AppMethodBeat.i(194187);
      f.this.ksZ.postDelayed(f.this.ktb, f.this.ksY);
      AppMethodBeat.o(194187);
    }
    
    public final void run()
    {
      AppMethodBeat.i(194186);
      if (f.this.kta != null) {
        f.this.kta.acz();
      }
      if (f.this.ksX) {
        bdR();
      }
      AppMethodBeat.o(194186);
    }
  }
  
  static abstract interface b
  {
    public abstract void acz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.f
 * JD-Core Version:    0.7.0.1
 */