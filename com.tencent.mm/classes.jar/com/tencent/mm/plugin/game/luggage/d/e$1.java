package com.tencent.mm.plugin.game.luggage.d;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.xweb.t;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(135925);
    synchronized (e.access$000())
    {
      if (this.nkA.getSettings().getBlockNetworkImage())
      {
        d.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
        this.nkA.getSettings().setBlockNetworkImage(false);
        h.qsU.j(949L, 0L, 1L);
      }
      AppMethodBeat.o(135925);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.e.1
 * JD-Core Version:    0.7.0.1
 */