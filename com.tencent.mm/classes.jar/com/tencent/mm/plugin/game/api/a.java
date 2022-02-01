package com.tencent.mm.plugin.game.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<h> Cqn;
  
  static
  {
    AppMethodBeat.i(89655);
    Cqn = new LinkedList();
    AppMethodBeat.o(89655);
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(89651);
    if (paramh != null) {
      Cqn.add(paramh);
    }
    AppMethodBeat.o(89651);
  }
  
  public static void b(h paramh)
  {
    AppMethodBeat.i(89652);
    if (paramh != null) {
      Cqn.remove(paramh);
    }
    AppMethodBeat.o(89652);
  }
  
  public static void ex(String paramString, int paramInt)
  {
    AppMethodBeat.i(89653);
    Iterator localIterator = Cqn.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh != null) {
        localh.ey(paramString, paramInt);
      }
    }
    AppMethodBeat.o(89653);
  }
  
  public static void f(String paramString, float paramFloat)
  {
    AppMethodBeat.i(89654);
    Iterator localIterator = Cqn.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh != null) {
        localh.g(paramString, paramFloat);
      }
    }
    AppMethodBeat.o(89654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.a
 * JD-Core Version:    0.7.0.1
 */