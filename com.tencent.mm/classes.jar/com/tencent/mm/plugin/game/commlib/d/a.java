package com.tencent.mm.plugin.game.commlib.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<b> lWt;
  
  static
  {
    AppMethodBeat.i(89959);
    lWt = new LinkedList();
    AppMethodBeat.o(89959);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(89957);
    lWt.add(paramb);
    AppMethodBeat.o(89957);
  }
  
  public static void cGJ()
  {
    AppMethodBeat.i(89958);
    Iterator localIterator = lWt.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).agz();
    }
    AppMethodBeat.o(89958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d.a
 * JD-Core Version:    0.7.0.1
 */