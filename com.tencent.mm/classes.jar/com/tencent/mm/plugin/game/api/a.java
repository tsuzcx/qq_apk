package com.tencent.mm.plugin.game.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<g> rNw;
  
  static
  {
    AppMethodBeat.i(89655);
    rNw = new LinkedList();
    AppMethodBeat.o(89655);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(89651);
    if (paramg != null) {
      rNw.add(paramg);
    }
    AppMethodBeat.o(89651);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(89652);
    if (paramg != null) {
      rNw.remove(paramg);
    }
    AppMethodBeat.o(89652);
  }
  
  public static void dl(String paramString, int paramInt)
  {
    AppMethodBeat.i(89653);
    Iterator localIterator = rNw.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg != null) {
        localg.dm(paramString, paramInt);
      }
    }
    AppMethodBeat.o(89653);
  }
  
  public static void g(String paramString, float paramFloat)
  {
    AppMethodBeat.i(89654);
    Iterator localIterator = rNw.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg != null) {
        localg.h(paramString, paramFloat);
      }
    }
    AppMethodBeat.o(89654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.a
 * JD-Core Version:    0.7.0.1
 */