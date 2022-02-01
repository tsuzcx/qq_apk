package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;

final class FloatBallHelper$3
  implements Runnable
{
  FloatBallHelper$3(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(224562);
    if (this.nLP.nLM != null) {
      this.nLP.nLM.p(this.nLP.nLK);
    }
    if (this.nLP.nLK != null)
    {
      a.a(this.nLP);
      a.b(this.nLP);
    }
    AppMethodBeat.o(224562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallHelper.3
 * JD-Core Version:    0.7.0.1
 */