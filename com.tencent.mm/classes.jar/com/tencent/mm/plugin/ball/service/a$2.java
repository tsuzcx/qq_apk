package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(224563);
    if (this.nLP.nLM != null) {
      this.nLP.nLM.q(this.nLP.nLK);
    }
    if (this.nLP.nLK != null)
    {
      a.a(this.nLP);
      a.b(this.nLP);
    }
    AppMethodBeat.o(224563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.a.2
 * JD-Core Version:    0.7.0.1
 */