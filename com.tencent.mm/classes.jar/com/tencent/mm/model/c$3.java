package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.d;

final class c$3
  implements com.tencent.mm.kernel.api.f
{
  c$3(c paramc) {}
  
  public final void RS()
  {
    AppMethodBeat.i(16201);
    aw.aay();
    AppMethodBeat.o(16201);
  }
  
  public final void mE(String paramString)
  {
    AppMethodBeat.i(16202);
    if (com.tencent.mm.compatible.util.f.Mi())
    {
      g.RM();
      if (g.RL().eHQ.equals(com.tencent.mm.compatible.util.e.eQz))
      {
        g.RM();
        d.post(new c.b(g.RL().cachePath, paramString), "AccountStorage_moveDataFiles");
      }
    }
    AppMethodBeat.o(16202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.c.3
 * JD-Core Version:    0.7.0.1
 */