package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.g;

final class c$4
  implements f
{
  c$4(c paramc) {}
  
  public final void ajZ()
  {
    AppMethodBeat.i(20244);
    bc.aCf();
    AppMethodBeat.o(20244);
  }
  
  public final void xK(String paramString)
  {
    AppMethodBeat.i(20245);
    if (com.tencent.mm.compatible.util.e.abo())
    {
      g.ajS();
      if (g.ajR().gDS.equals(com.tencent.mm.loader.j.b.asj()))
      {
        g.ajS();
        com.tencent.mm.sdk.g.b.c(new c.b(g.ajR().cachePath, paramString), "AccountStorage_moveDataFiles");
      }
    }
    AppMethodBeat.o(20245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.4
 * JD-Core Version:    0.7.0.1
 */