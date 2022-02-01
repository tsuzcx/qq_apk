package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  volatile boolean lvK;
  int lvL;
  Handler lvM;
  b lvN;
  a lvO;
  
  f(Handler paramHandler)
  {
    AppMethodBeat.i(211375);
    this.lvK = false;
    this.lvL = 1000;
    this.lvO = new a((byte)0);
    this.lvM = paramHandler;
    AppMethodBeat.o(211375);
  }
  
  final void start()
  {
    AppMethodBeat.i(211376);
    if (!this.lvK)
    {
      this.lvK = true;
      this.lvO.bpg();
    }
    AppMethodBeat.o(211376);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    final void bpg()
    {
      AppMethodBeat.i(211374);
      f.this.lvM.postDelayed(f.this.lvO, f.this.lvL);
      AppMethodBeat.o(211374);
    }
    
    public final void run()
    {
      AppMethodBeat.i(211373);
      if (f.this.lvN != null) {
        f.this.lvN.agz();
      }
      if (f.this.lvK) {
        bpg();
      }
      AppMethodBeat.o(211373);
    }
  }
  
  static abstract interface b
  {
    public abstract void agz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f
 * JD-Core Version:    0.7.0.1
 */