package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class q$a
{
  private static final Set<q> gRE;
  
  static
  {
    AppMethodBeat.i(143048);
    gRE = new HashSet();
    AppMethodBeat.o(143048);
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(143046);
    if (paramq != null) {
      synchronized (gRE)
      {
        gRE.add(paramq);
        AppMethodBeat.o(143046);
        return;
      }
    }
    AppMethodBeat.o(143046);
  }
  
  static Set<q> auc()
  {
    AppMethodBeat.i(143047);
    synchronized (gRE)
    {
      HashSet localHashSet = new HashSet(gRE);
      AppMethodBeat.o(143047);
      return localHashSet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a
 * JD-Core Version:    0.7.0.1
 */