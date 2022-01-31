package com.tencent.mm.plugin.favorite;

import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends p
  implements b
{
  public a()
  {
    super(com.tencent.mm.br.c.Xh("favorite"));
  }
  
  public final void parallelsDependency()
  {
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).ao(g.t(n.class));
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).ao(g.t(ae.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.a
 * JD-Core Version:    0.7.0.1
 */