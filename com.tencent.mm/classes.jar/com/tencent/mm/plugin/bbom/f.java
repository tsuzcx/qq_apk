package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.n;

public final class f
  extends q
  implements b
{
  public f()
  {
    super(com.tencent.mm.bq.c.anc("search"));
    AppMethodBeat.i(18254);
    AppMethodBeat.o(18254);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(18255);
    a.a(this, com.tencent.mm.kernel.api.c.class).az(g.G(n.class));
    AppMethodBeat.o(18255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.f
 * JD-Core Version:    0.7.0.1
 */