package com.tencent.mm.plugin.game.commlib.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<b> ipW;
  
  static
  {
    AppMethodBeat.i(59423);
    ipW = new LinkedList();
    AppMethodBeat.o(59423);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(59421);
    ipW.add(paramb);
    AppMethodBeat.o(59421);
  }
  
  public static void boB()
  {
    AppMethodBeat.i(59422);
    Iterator localIterator = ipW.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).ye();
    }
    AppMethodBeat.o(59422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.c.a
 * JD-Core Version:    0.7.0.1
 */