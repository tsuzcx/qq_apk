package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public volatile boolean pzR;
  public int pzS;
  Handler pzT;
  public b pzU;
  a pzV;
  
  public h(Handler paramHandler)
  {
    AppMethodBeat.i(227735);
    this.pzR = false;
    this.pzS = 1000;
    this.pzV = new a((byte)0);
    this.pzT = paramHandler;
    AppMethodBeat.o(227735);
  }
  
  public final void start()
  {
    AppMethodBeat.i(227736);
    if (!this.pzR)
    {
      this.pzR = true;
      this.pzV.bWo();
    }
    AppMethodBeat.o(227736);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    final void bWo()
    {
      AppMethodBeat.i(227734);
      h.this.pzT.postDelayed(h.this.pzV, h.this.pzS);
      AppMethodBeat.o(227734);
    }
    
    public final void run()
    {
      AppMethodBeat.i(227733);
      if (h.this.pzU != null) {
        h.this.pzU.bWp();
      }
      if (h.this.pzR) {
        bWo();
      }
      AppMethodBeat.o(227733);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bWp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.h
 * JD-Core Version:    0.7.0.1
 */