package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static final String hja;
  private static LinkedList<String> xvr;
  private static final String xvs;
  private static final String xvt;
  
  static
  {
    AppMethodBeat.i(149404);
    xvr = new LinkedList();
    xvs = MMApplicationContext.getPackageName();
    hja = MMApplicationContext.getPackageName() + ":tools";
    xvt = MMApplicationContext.getPackageName() + ":toolsmp";
    xvr.add(hja);
    xvr.add(xvt);
    AppMethodBeat.o(149404);
  }
  
  public static void azp(String paramString)
  {
    AppMethodBeat.i(149402);
    if ((paramString.equals(xvs)) || (xvr.contains(paramString))) {
      a.dSS();
    }
    AppMethodBeat.o(149402);
  }
  
  public static void dTe()
  {
    AppMethodBeat.i(149403);
    Iterator localIterator = xvr.iterator();
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
      a.dSS();
      AppMethodBeat.o(149401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e
 * JD-Core Version:    0.7.0.1
 */