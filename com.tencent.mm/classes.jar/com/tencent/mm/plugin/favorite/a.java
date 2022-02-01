package com.tencent.mm.plugin.favorite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends u
  implements b
{
  public a()
  {
    super(com.tencent.mm.br.c.aPo("favorite"));
    AppMethodBeat.i(24569);
    AppMethodBeat.o(24569);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(24570);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(g.ad(n.class));
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(g.ad(af.class));
    AppMethodBeat.o(24570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.a
 * JD-Core Version:    0.7.0.1
 */