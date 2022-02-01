package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;

public final class f
  extends y
  implements com.tencent.mm.kernel.a.b.b
{
  public f()
  {
    super(com.tencent.mm.br.b.bsb("search"));
    AppMethodBeat.i(22355);
    AppMethodBeat.o(22355);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(22356);
    a.a(this, c.class).db(h.az(n.class));
    AppMethodBeat.o(22356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.f
 * JD-Core Version:    0.7.0.1
 */