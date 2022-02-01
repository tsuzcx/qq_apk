package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.game.protobuf.dy;

public final class ag
  extends x
{
  public dy CLA;
  
  public ag(a parama)
  {
    AppMethodBeat.i(41554);
    if (parama == null)
    {
      this.CLA = new dy();
      AppMethodBeat.o(41554);
      return;
    }
    this.CLA = ((dy)parama);
    AppMethodBeat.o(41554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ag
 * JD-Core Version:    0.7.0.1
 */