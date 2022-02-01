package com.tencent.mm.plugin.game.commlib.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static LinkedList<b> kRj;
  
  static
  {
    AppMethodBeat.i(89959);
    kRj = new LinkedList();
    AppMethodBeat.o(89959);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(89957);
    kRj.add(paramb);
    AppMethodBeat.o(89957);
  }
  
  public static void cot()
  {
    AppMethodBeat.i(89958);
    Iterator localIterator = kRj.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).acz();
    }
    AppMethodBeat.o(89958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d.a
 * JD-Core Version:    0.7.0.1
 */