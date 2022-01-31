package com.tencent.mm.plugin.favorite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends q
  implements b
{
  public a()
  {
    super(com.tencent.mm.bq.c.anc("favorite"));
    AppMethodBeat.i(20496);
    AppMethodBeat.o(20496);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(20497);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(g.G(n.class));
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(g.G(ae.class));
    AppMethodBeat.o(20497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.a
 * JD-Core Version:    0.7.0.1
 */