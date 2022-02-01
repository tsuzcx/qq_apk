package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.game.protobuf.ec;

public final class ag
  extends x
{
  public ec IFH;
  
  public ag(a parama)
  {
    AppMethodBeat.i(41554);
    if (parama == null)
    {
      this.IFH = new ec();
      AppMethodBeat.o(41554);
      return;
    }
    this.IFH = ((ec)parama);
    AppMethodBeat.o(41554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ag
 * JD-Core Version:    0.7.0.1
 */