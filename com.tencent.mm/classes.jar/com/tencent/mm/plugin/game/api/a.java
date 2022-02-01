package com.tencent.mm.plugin.game.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<h> tRO;
  
  static
  {
    AppMethodBeat.i(89655);
    tRO = new LinkedList();
    AppMethodBeat.o(89655);
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(89651);
    if (paramh != null) {
      tRO.add(paramh);
    }
    AppMethodBeat.o(89651);
  }
  
  public static void b(h paramh)
  {
    AppMethodBeat.i(89652);
    if (paramh != null) {
      tRO.remove(paramh);
    }
    AppMethodBeat.o(89652);
  }
  
  public static void dH(String paramString, int paramInt)
  {
    AppMethodBeat.i(89653);
    Iterator localIterator = tRO.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh != null) {
        localh.dI(paramString, paramInt);
      }
    }
    AppMethodBeat.o(89653);
  }
  
  public static void g(String paramString, float paramFloat)
  {
    AppMethodBeat.i(89654);
    Iterator localIterator = tRO.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh != null) {
        localh.h(paramString, paramFloat);
      }
    }
    AppMethodBeat.o(89654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.a
 * JD-Core Version:    0.7.0.1
 */