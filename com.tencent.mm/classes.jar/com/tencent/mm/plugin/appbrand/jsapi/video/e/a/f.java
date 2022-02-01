package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  volatile boolean kUm;
  int kUn;
  Handler kUo;
  b kUp;
  a kUq;
  
  f(Handler paramHandler)
  {
    AppMethodBeat.i(194533);
    this.kUm = false;
    this.kUn = 1000;
    this.kUq = new a((byte)0);
    this.kUo = paramHandler;
    AppMethodBeat.o(194533);
  }
  
  final void start()
  {
    AppMethodBeat.i(194534);
    if (!this.kUm)
    {
      this.kUm = true;
      this.kUq.bkL();
    }
    AppMethodBeat.o(194534);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    final void bkL()
    {
      AppMethodBeat.i(194532);
      f.this.kUo.postDelayed(f.this.kUq, f.this.kUn);
      AppMethodBeat.o(194532);
    }
    
    public final void run()
    {
      AppMethodBeat.i(194531);
      if (f.this.kUp != null) {
        f.this.kUp.adF();
      }
      if (f.this.kUm) {
        bkL();
      }
      AppMethodBeat.o(194531);
    }
  }
  
  static abstract interface b
  {
    public abstract void adF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.f
 * JD-Core Version:    0.7.0.1
 */