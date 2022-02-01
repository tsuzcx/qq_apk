package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.model.e;

public final class b
  extends e
{
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(55682);
    parama = super.b(parama);
    if (parama != null) {
      SubCoreLocation.aY(parama.hzO);
    }
    AppMethodBeat.o(55682);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.b
 * JD-Core Version:    0.7.0.1
 */