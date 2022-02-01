package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public volatile boolean sEZ;
  public int sFa;
  Handler sFb;
  public b sFc;
  a sFd;
  
  public i(Handler paramHandler)
  {
    AppMethodBeat.i(328641);
    this.sEZ = false;
    this.sFa = 1000;
    this.sFd = new a((byte)0);
    this.sFb = paramHandler;
    AppMethodBeat.o(328641);
  }
  
  public final void start()
  {
    AppMethodBeat.i(328647);
    if (!this.sEZ)
    {
      this.sEZ = true;
      this.sFd.cwB();
    }
    AppMethodBeat.o(328647);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    final void cwB()
    {
      AppMethodBeat.i(328630);
      i.this.sFb.postDelayed(i.this.sFd, i.this.sFa);
      AppMethodBeat.o(328630);
    }
    
    public final void run()
    {
      AppMethodBeat.i(328629);
      if (i.this.sFc != null) {
        i.this.sFc.cwC();
      }
      if (i.this.sEZ) {
        cwB();
      }
      AppMethodBeat.o(328629);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cwC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.i
 * JD-Core Version:    0.7.0.1
 */