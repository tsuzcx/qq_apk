package com.tencent.mm.plugin.game.model;

import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.luggage.d.e;

final class aw$7$1
  implements Runnable
{
  aw$7$1(aw.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(111469);
    k localk = d.PR(this.npy.npw);
    if (localk != null)
    {
      ((e)localk.uv()).setBlockNetworkImage(true);
      ((e)localk.uv()).onPause();
    }
    this.npy.njo.eAe = System.currentTimeMillis();
    aw.b(this.npy.npx, this.npy.cax);
    AppMethodBeat.o(111469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw.7.1
 * JD-Core Version:    0.7.0.1
 */