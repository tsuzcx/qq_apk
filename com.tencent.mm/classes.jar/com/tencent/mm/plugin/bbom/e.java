package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;

public final class e
  extends y
  implements com.tencent.mm.kernel.a.b.b
{
  public e()
  {
    super(com.tencent.mm.plugin.account.b.class);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(22354);
    a.a(this, c.class).db(h.az(n.class));
    AppMethodBeat.o(22354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.e
 * JD-Core Version:    0.7.0.1
 */