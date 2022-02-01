package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class x$a
{
  private static final Set<x> qwC;
  
  static
  {
    AppMethodBeat.i(43958);
    qwC = new HashSet();
    AppMethodBeat.o(43958);
  }
  
  public static void a(x paramx)
  {
    AppMethodBeat.i(43956);
    if (paramx != null) {
      synchronized (qwC)
      {
        qwC.add(paramx);
        AppMethodBeat.o(43956);
        return;
      }
    }
    AppMethodBeat.o(43956);
  }
  
  static Set<x> cdh()
  {
    AppMethodBeat.i(43957);
    synchronized (qwC)
    {
      HashSet localHashSet = new HashSet(qwC);
      AppMethodBeat.o(43957);
      return localHashSet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.a
 * JD-Core Version:    0.7.0.1
 */