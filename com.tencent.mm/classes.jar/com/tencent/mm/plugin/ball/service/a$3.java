package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(224564);
    if (this.nLP.nLM != null) {
      this.nLP.nLM.r(this.nLP.nLK);
    }
    if (this.nLP.nLK != null)
    {
      if (this.nLP.bLq()) {
        this.nLP.bLH();
      }
      ((b)g.ab(b.class)).c(this.nLP.nLK.nLw.nLC, this.nLP.bLw(), this.nLP.bhq());
    }
    AppMethodBeat.o(224564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.a.3
 * JD-Core Version:    0.7.0.1
 */