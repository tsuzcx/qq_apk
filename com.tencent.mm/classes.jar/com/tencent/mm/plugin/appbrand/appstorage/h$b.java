package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pathname", "Lcom/tencent/mm/vfs/VFSFile;", "accept"})
final class h$b
  implements s
{
  public static final b nMJ;
  
  static
  {
    AppMethodBeat.i(274137);
    nMJ = new b();
    AppMethodBeat.o(274137);
  }
  
  public final boolean accept(q paramq)
  {
    AppMethodBeat.i(274134);
    p.k(paramq, "pathname");
    String str = paramq.getName();
    p.j(str, "pathname.name");
    if (!n.pu(str, ".data"))
    {
      str = paramq.getName();
      p.j(str, "pathname.name");
      if (!n.M(str, "store_", false))
      {
        paramq = paramq.getName();
        p.j(paramq, "pathname.name");
        if (!n.pu(paramq, ".nomedia"))
        {
          AppMethodBeat.o(274134);
          return true;
        }
      }
    }
    AppMethodBeat.o(274134);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.h.b
 * JD-Core Version:    0.7.0.1
 */