package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  volatile boolean lrk;
  int lrl;
  Handler lrm;
  b lrn;
  a lro;
  
  f(Handler paramHandler)
  {
    AppMethodBeat.i(206345);
    this.lrk = false;
    this.lrl = 1000;
    this.lro = new a((byte)0);
    this.lrm = paramHandler;
    AppMethodBeat.o(206345);
  }
  
  final void start()
  {
    AppMethodBeat.i(206346);
    if (!this.lrk)
    {
      this.lrk = true;
      this.lro.bow();
    }
    AppMethodBeat.o(206346);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    final void bow()
    {
      AppMethodBeat.i(206344);
      f.this.lrm.postDelayed(f.this.lro, f.this.lrl);
      AppMethodBeat.o(206344);
    }
    
    public final void run()
    {
      AppMethodBeat.i(206343);
      if (f.this.lrn != null) {
        f.this.lrn.agl();
      }
      if (f.this.lrk) {
        bow();
      }
      AppMethodBeat.o(206343);
    }
  }
  
  static abstract interface b
  {
    public abstract void agl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f
 * JD-Core Version:    0.7.0.1
 */