package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.g;

final class c$4
  implements f
{
  c$4(c paramc) {}
  
  public final void agZ()
  {
    AppMethodBeat.i(20244);
    az.ayL();
    AppMethodBeat.o(20244);
  }
  
  public final void ul(String paramString)
  {
    AppMethodBeat.i(20245);
    if (com.tencent.mm.compatible.util.e.YD())
    {
      g.agS();
      if (g.agR().ghB.equals(com.tencent.mm.loader.j.b.aph()))
      {
        g.agS();
        com.tencent.mm.sdk.g.b.c(new c.b(g.agR().cachePath, paramString), "AccountStorage_moveDataFiles");
      }
    }
    AppMethodBeat.o(20245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.4
 * JD-Core Version:    0.7.0.1
 */