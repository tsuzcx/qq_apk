package com.tencent.mm.plugin.favorite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends y
  implements com.tencent.mm.kernel.a.b.b
{
  public a()
  {
    super(com.tencent.mm.br.b.bsb("favorite"));
    AppMethodBeat.i(24569);
    AppMethodBeat.o(24569);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(24570);
    com.tencent.mm.kernel.a.b.a.a(this, c.class).db(h.az(n.class));
    com.tencent.mm.kernel.a.b.a.a(this, c.class).db(h.az(ah.class));
    AppMethodBeat.o(24570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.a
 * JD-Core Version:    0.7.0.1
 */