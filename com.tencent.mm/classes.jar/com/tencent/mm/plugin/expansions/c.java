package com.tencent.mm.plugin.expansions;

import android.util.Pair;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c
{
  static final ArrayList<IDKey> pLM;
  static final List<Pair<String, Object>> pLN;
  
  static
  {
    AppMethodBeat.i(152978);
    pLM = new ArrayList();
    pLN = new ArrayList();
    AppMethodBeat.o(152978);
  }
  
  public static void ciq()
  {
    AppMethodBeat.i(152974);
    com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
    {
      public final void Lh()
      {
        AppMethodBeat.i(152973);
        com.tencent.mm.kernel.g.agS().b(this);
        c.access$000();
        AppMethodBeat.o(152973);
      }
      
      public final void cf(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(152974);
  }
  
  public static void cir()
  {
    AppMethodBeat.i(152976);
    Iterator localIterator = pLN.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair.second instanceof String)) {
        ac.i((String)localPair.first, "pending log: " + localPair.second);
      }
      if ((localPair.second instanceof Throwable)) {
        ac.printErrStackTrace((String)localPair.first, (Throwable)localPair.second, "pending exception", new Object[0]);
      }
    }
    pLN.clear();
    AppMethodBeat.o(152976);
  }
  
  public static void fC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152975);
    pLN.add(new Pair(paramString1, paramString2));
    AppMethodBeat.o(152975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.c
 * JD-Core Version:    0.7.0.1
 */