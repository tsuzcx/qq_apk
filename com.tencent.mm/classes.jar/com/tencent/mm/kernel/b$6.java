package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.Set;

public final class b$6
  implements a
{
  public b$6(b paramb) {}
  
  public final void ud(String paramString)
  {
    AppMethodBeat.i(132052);
    ac.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", new Object[] { paramString });
    g.agS();
    if (g.agT() != null)
    {
      g.agS();
      cf localcf = g.agT();
      localcf.isRunning = true;
      Iterator localIterator = localcf.hqd.iterator();
      while (localIterator.hasNext())
      {
        cf.a locala = (cf.a)localIterator.next();
        if (locala != null) {
          locala.azL();
        }
      }
      localcf.isRunning = false;
    }
    g.agS();
    if (g.agR() != null)
    {
      g.agS();
      g.agR().ro(paramString);
    }
    AppMethodBeat.o(132052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.6
 * JD-Core Version:    0.7.0.1
 */