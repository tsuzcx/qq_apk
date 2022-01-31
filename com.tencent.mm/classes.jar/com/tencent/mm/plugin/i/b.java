package com.tencent.mm.plugin.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.storage.bh;

public final class b
  extends q
{
  private static b nLj;
  
  private b()
  {
    super(o.class);
  }
  
  public static bh YH()
  {
    AppMethodBeat.i(79096);
    g.RJ().QQ();
    bh localbh = ((com.tencent.mm.plugin.m.a.a)g.E(com.tencent.mm.plugin.m.a.a.class)).YH();
    AppMethodBeat.o(79096);
    return localbh;
  }
  
  public static b bIA()
  {
    try
    {
      AppMethodBeat.i(79095);
      if (nLj == null) {
        nLj = new b();
      }
      b localb = nLj;
      AppMethodBeat.o(79095);
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.i.b
 * JD-Core Version:    0.7.0.1
 */