package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class u$a
{
  private static final Set<u> nxo;
  
  static
  {
    AppMethodBeat.i(43958);
    nxo = new HashSet();
    AppMethodBeat.o(43958);
  }
  
  public static void a(u paramu)
  {
    AppMethodBeat.i(43956);
    if (paramu != null) {
      synchronized (nxo)
      {
        nxo.add(paramu);
        AppMethodBeat.o(43956);
        return;
      }
    }
    AppMethodBeat.o(43956);
  }
  
  static Set<u> bDT()
  {
    AppMethodBeat.i(43957);
    synchronized (nxo)
    {
      HashSet localHashSet = new HashSet(nxo);
      AppMethodBeat.o(43957);
      return localHashSet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a
 * JD-Core Version:    0.7.0.1
 */