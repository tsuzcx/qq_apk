package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.ci.a;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.Set;

public final class b$6
  implements a
{
  public b$6(b paramb) {}
  
  public final void xC(String paramString)
  {
    AppMethodBeat.i(132052);
    ae.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", new Object[] { paramString });
    g.ajS();
    if (g.ajT() != null)
    {
      g.ajS();
      ci localci = g.ajT();
      localci.isRunning = true;
      Iterator localIterator = localci.hLo.iterator();
      while (localIterator.hasNext())
      {
        ci.a locala = (ci.a)localIterator.next();
        if (locala != null) {
          locala.aDe();
        }
      }
      localci.isRunning = false;
    }
    g.ajS();
    if (g.ajR() != null)
    {
      g.ajS();
      g.ajR().uv(paramString);
    }
    AppMethodBeat.o(132052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.6
 * JD-Core Version:    0.7.0.1
 */