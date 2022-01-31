package com.tencent.mm.plugin.game.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<g> niB;
  
  static
  {
    AppMethodBeat.i(141584);
    niB = new LinkedList();
    AppMethodBeat.o(141584);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(141580);
    if (paramg != null) {
      niB.add(paramg);
    }
    AppMethodBeat.o(141580);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(141581);
    if (paramg != null) {
      niB.remove(paramg);
    }
    AppMethodBeat.o(141581);
  }
  
  public static void cp(String paramString, int paramInt)
  {
    AppMethodBeat.i(141582);
    Iterator localIterator = niB.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg != null) {
        localg.cq(paramString, paramInt);
      }
    }
    AppMethodBeat.o(141582);
  }
  
  public static void g(String paramString, float paramFloat)
  {
    AppMethodBeat.i(141583);
    Iterator localIterator = niB.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg != null) {
        localg.h(paramString, paramFloat);
      }
    }
    AppMethodBeat.o(141583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.a
 * JD-Core Version:    0.7.0.1
 */