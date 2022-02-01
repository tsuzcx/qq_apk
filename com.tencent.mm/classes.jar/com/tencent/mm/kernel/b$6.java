package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cg.a;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Set;

public final class b$6
  implements a
{
  public b$6(b paramb) {}
  
  public final void wT(String paramString)
  {
    AppMethodBeat.i(132052);
    ad.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", new Object[] { paramString });
    g.ajD();
    if (g.ajE() != null)
    {
      g.ajD();
      cg localcg = g.ajE();
      localcg.isRunning = true;
      Iterator localIterator = localcg.hIv.iterator();
      while (localIterator.hasNext())
      {
        cg.a locala = (cg.a)localIterator.next();
        if (locala != null) {
          locala.aCO();
        }
      }
      localcg.isRunning = false;
    }
    g.ajD();
    if (g.ajC() != null)
    {
      g.ajD();
      g.ajC().ua(paramString);
    }
    AppMethodBeat.o(132052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.b.6
 * JD-Core Version:    0.7.0.1
 */