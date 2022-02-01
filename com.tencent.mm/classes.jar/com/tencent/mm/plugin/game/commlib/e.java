package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static final String gwm;
  private static LinkedList<String> udF;
  private static final String udG;
  private static final String udH;
  
  static
  {
    AppMethodBeat.i(149404);
    udF = new LinkedList();
    udG = ak.getPackageName();
    gwm = ak.getPackageName() + ":tools";
    udH = ak.getPackageName() + ":toolsmp";
    udF.add(gwm);
    udF.add(udH);
    AppMethodBeat.o(149404);
  }
  
  public static void aml(String paramString)
  {
    AppMethodBeat.i(149402);
    if ((paramString.equals(udG)) || (udF.contains(paramString))) {
      a.cZs();
    }
    AppMethodBeat.o(149402);
  }
  
  public static void cZD()
  {
    AppMethodBeat.i(149403);
    Iterator localIterator = udF.iterator();
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
      a.cZs();
      AppMethodBeat.o(149401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e
 * JD-Core Version:    0.7.0.1
 */