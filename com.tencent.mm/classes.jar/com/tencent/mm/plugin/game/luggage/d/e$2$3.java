package com.tencent.mm.plugin.game.luggage.d;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2$3
  implements Runnable
{
  e$2$3(e.2 param2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(135929);
    if (e.c(this.nkB.nkA))
    {
      e.a(this.nkB.nkA, false);
      e.e(this.nkB.nkA);
      if (this.egM)
      {
        d.i("MicroMsg.GameWebCoreImpl", "onPkgReady");
        this.nkB.nkA.stopLoading();
        e.f(this.nkB.nkA);
        this.nkB.nkA.loadUrl(e.g(this.nkB.nkA));
      }
    }
    AppMethodBeat.o(135929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.e.2.3
 * JD-Core Version:    0.7.0.1
 */