package com.tencent.mm.plugin.game.luggage.d;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2$2
  implements Runnable
{
  e$2$2(e.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(135928);
    d.i("MicroMsg.GameWebCoreImpl", "onForceUpdate");
    e.a(this.nkB.nkA, true);
    this.nkB.nkA.postDelayed(new e.2.2.1(this), 1000L);
    AppMethodBeat.o(135928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.e.2.2
 * JD-Core Version:    0.7.0.1
 */