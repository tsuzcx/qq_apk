package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.cm.a;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

public final class b$6
  implements CallbackForReset
{
  public b$6(b paramb) {}
  
  public final void callbackForReset(String paramString)
  {
    AppMethodBeat.i(132052);
    Log.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", new Object[] { paramString });
    g.aAi();
    if (g.aAj() != null)
    {
      g.aAi();
      cm localcm = g.aAj();
      localcm.isRunning = true;
      Iterator localIterator = localcm.iGc.iterator();
      while (localIterator.hasNext())
      {
        cm.a locala = (cm.a)localIterator.next();
        if (locala != null) {
          locala.aWC();
        }
      }
      localcm.isRunning = false;
    }
    g.aAi();
    if (g.aAh() != null)
    {
      g.aAi();
      g.aAh().CL(paramString);
    }
    AppMethodBeat.o(132052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.b.6
 * JD-Core Version:    0.7.0.1
 */