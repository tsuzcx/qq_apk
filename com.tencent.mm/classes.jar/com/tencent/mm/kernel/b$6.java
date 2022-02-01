package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Set;

public final class b$6
  implements a
{
  public b$6(b paramb) {}
  
  public final void qO(String paramString)
  {
    AppMethodBeat.i(132052);
    ad.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", new Object[] { paramString });
    g.afC();
    if (g.afD() != null)
    {
      g.afC();
      cf localcf = g.afD();
      localcf.isRunning = true;
      Iterator localIterator = localcf.gPD.iterator();
      while (localIterator.hasNext())
      {
        cf.a locala = (cf.a)localIterator.next();
        if (locala != null) {
          locala.asU();
        }
      }
      localcf.isRunning = false;
    }
    g.afC();
    if (g.afB() != null)
    {
      g.afC();
      g.afB().oi(paramString);
    }
    AppMethodBeat.o(132052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kernel.b.6
 * JD-Core Version:    0.7.0.1
 */