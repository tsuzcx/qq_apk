package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static final String gtF;
  private static LinkedList<String> tSO;
  private static final String tSP;
  private static final String tSQ;
  
  static
  {
    AppMethodBeat.i(149404);
    tSO = new LinkedList();
    tSP = aj.getPackageName();
    gtF = aj.getPackageName() + ":tools";
    tSQ = aj.getPackageName() + ":toolsmp";
    tSO.add(gtF);
    tSO.add(tSQ);
    AppMethodBeat.o(149404);
  }
  
  public static void aln(String paramString)
  {
    AppMethodBeat.i(149402);
    if ((paramString.equals(tSP)) || (tSO.contains(paramString))) {
      a.cWO();
    }
    AppMethodBeat.o(149402);
  }
  
  public static void cWW()
  {
    AppMethodBeat.i(149403);
    Iterator localIterator = tSO.iterator();
    while (localIterator.hasNext()) {
      h.a((String)localIterator.next(), null, a.class, null);
    }
    AppMethodBeat.o(149403);
  }
  
  static class a
    implements b
  {
    public void invoke(Object paramObject, d paramd)
    {
      AppMethodBeat.i(149401);
      a.cWO();
      AppMethodBeat.o(149401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e
 * JD-Core Version:    0.7.0.1
 */