package com.tencent.mm.plugin.game.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<i> Icw;
  
  static
  {
    AppMethodBeat.i(89655);
    Icw = new LinkedList();
    AppMethodBeat.o(89655);
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(89651);
    if (parami != null) {
      Icw.add(parami);
    }
    AppMethodBeat.o(89651);
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(89652);
    if (parami != null) {
      Icw.remove(parami);
    }
    AppMethodBeat.o(89652);
  }
  
  public static void fm(String paramString, int paramInt)
  {
    AppMethodBeat.i(89653);
    Iterator localIterator = Icw.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali != null) {
        locali.fn(paramString, paramInt);
      }
    }
    AppMethodBeat.o(89653);
  }
  
  public static void g(String paramString, float paramFloat)
  {
    AppMethodBeat.i(89654);
    Iterator localIterator = Icw.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali != null) {
        locali.h(paramString, paramFloat);
      }
    }
    AppMethodBeat.o(89654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.a
 * JD-Core Version:    0.7.0.1
 */