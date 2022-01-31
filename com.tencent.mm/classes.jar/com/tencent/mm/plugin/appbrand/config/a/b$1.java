package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Timer;
import java.util.TimerTask;

final class b$1
  implements Runnable
{
  b$1(b paramb, b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(86932);
    b.a(this.hkR);
    this.hkR.hkO = this.hkQ;
    this.hkR.hkP = new Timer();
    this.hkR.hkP.schedule(new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(86931);
        al.d(new b.1.1.1(this));
        AppMethodBeat.o(86931);
      }
    }, 500L, 500L);
    AppMethodBeat.o(86932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b.1
 * JD-Core Version:    0.7.0.1
 */