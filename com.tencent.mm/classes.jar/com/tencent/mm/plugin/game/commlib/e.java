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
  private static LinkedList<String> rOr;
  private static final String rOs;
  private static final String rOt;
  private static final String rOu;
  
  static
  {
    AppMethodBeat.i(149404);
    rOr = new LinkedList();
    rOs = aj.getPackageName();
    rOt = aj.getPackageName() + ":tools";
    rOu = aj.getPackageName() + ":toolsmp";
    rOr.add(rOt);
    rOr.add(rOu);
    AppMethodBeat.o(149404);
  }
  
  public static void abY(String paramString)
  {
    AppMethodBeat.i(149402);
    if ((paramString.equals(rOs)) || (rOr.contains(paramString))) {
      a.cBk();
    }
    AppMethodBeat.o(149402);
  }
  
  public static void cBr()
  {
    AppMethodBeat.i(149403);
    Iterator localIterator = rOr.iterator();
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
      a.cBk();
      AppMethodBeat.o(149401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e
 * JD-Core Version:    0.7.0.1
 */