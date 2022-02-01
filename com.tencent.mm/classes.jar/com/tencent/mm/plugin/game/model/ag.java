package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.protobuf.dx;

public final class ag
  extends x
{
  public dx xHx;
  
  public ag(a parama)
  {
    AppMethodBeat.i(41554);
    if (parama == null)
    {
      this.xHx = new dx();
      AppMethodBeat.o(41554);
      return;
    }
    this.xHx = ((dx)parama);
    AppMethodBeat.o(41554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ag
 * JD-Core Version:    0.7.0.1
 */