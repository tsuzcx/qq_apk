package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;

final class b$10
  implements bv.a
{
  public final void a(g paramg)
  {
    AppMethodBeat.i(276418);
    if (paramg == null)
    {
      AppMethodBeat.o(276418);
      return;
    }
    paramg = paramg.biw();
    bh.beI();
    int i = c.getUin();
    paramg.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(276418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.10
 * JD-Core Version:    0.7.0.1
 */