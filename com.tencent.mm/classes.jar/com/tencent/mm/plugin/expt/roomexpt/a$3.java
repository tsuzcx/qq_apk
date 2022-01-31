package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(73562);
    com.tencent.mm.plugin.expt.a.a locala = (com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class);
    a.a locala1 = a.a.lRx;
    if (a.a(this.mcI) != null) {}
    for (boolean bool = a.a(this.mcI).cUf; !locala.a(locala1, bool); bool = false)
    {
      AppMethodBeat.o(73562);
      return;
    }
    int j = Math.min(a.b(this.mcI).length, 5);
    while (i < j)
    {
      if (this.mcJ.equals(a.b(this.mcI)[i]))
      {
        a.aL(this.mcJ, this.kLR);
        a.a(this.mcI).cUc = 6L;
        a.a(this.mcI).fz("");
        a.c(this.mcI);
        AppMethodBeat.o(73562);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(73562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.3
 * JD-Core Version:    0.7.0.1
 */