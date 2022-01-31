package com.tencent.mm.plugin.game.luggage;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.xweb.n;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    synchronized ()
    {
      if (this.kMw.getSettings().getBlockNetworkImage())
      {
        com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
        this.kMw.getSettings().setBlockNetworkImage(false);
        h.nFQ.h(949L, 0L, 1L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.1
 * JD-Core Version:    0.7.0.1
 */