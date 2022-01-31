package com.tencent.mm.plugin.game.model;

import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;

final class aw$6
  implements Runnable
{
  aw$6(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(111468);
    ((e)this.njp.uv()).onResume();
    ((e)this.njp.uv()).setBlockNetworkImage(false);
    AppMethodBeat.o(111468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw.6
 * JD-Core Version:    0.7.0.1
 */