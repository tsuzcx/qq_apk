package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.n;

public final class e
  extends u
  implements b
{
  public e()
  {
    super(com.tencent.mm.plugin.account.a.class);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(22354);
    com.tencent.mm.kernel.a.b.a.a(this, c.class).bA(g.ad(n.class));
    AppMethodBeat.o(22354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.e
 * JD-Core Version:    0.7.0.1
 */