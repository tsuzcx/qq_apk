package com.tencent.mm.plugin.game.commlib.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<b> lRS;
  
  static
  {
    AppMethodBeat.i(89959);
    lRS = new LinkedList();
    AppMethodBeat.o(89959);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(89957);
    lRS.add(paramb);
    AppMethodBeat.o(89957);
  }
  
  public static void cEN()
  {
    AppMethodBeat.i(89958);
    Iterator localIterator = lRS.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).agl();
    }
    AppMethodBeat.o(89958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d.a
 * JD-Core Version:    0.7.0.1
 */