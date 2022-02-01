package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  volatile boolean mCE;
  int mCF;
  Handler mCG;
  b mCH;
  a mCI;
  
  k(Handler paramHandler)
  {
    AppMethodBeat.i(235052);
    this.mCE = false;
    this.mCF = 1000;
    this.mCI = new a((byte)0);
    this.mCG = paramHandler;
    AppMethodBeat.o(235052);
  }
  
  final void start()
  {
    AppMethodBeat.i(235053);
    if (!this.mCE)
    {
      this.mCE = true;
      this.mCI.bKM();
    }
    AppMethodBeat.o(235053);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    final void bKM()
    {
      AppMethodBeat.i(235051);
      k.this.mCG.postDelayed(k.this.mCI, k.this.mCF);
      AppMethodBeat.o(235051);
    }
    
    public final void run()
    {
      AppMethodBeat.i(235050);
      if (k.this.mCH != null) {
        k.this.mCH.awp();
      }
      if (k.this.mCE) {
        bKM();
      }
      AppMethodBeat.o(235050);
    }
  }
  
  static abstract interface b
  {
    public abstract void awp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.k
 * JD-Core Version:    0.7.0.1
 */