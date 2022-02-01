package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static LinkedList<String> Czh;
  private static final String Czi;
  private static final String Czj;
  private static final String jUU;
  
  static
  {
    AppMethodBeat.i(149404);
    Czh = new LinkedList();
    Czi = MMApplicationContext.getPackageName();
    jUU = MMApplicationContext.getPackageName() + ":tools";
    Czj = MMApplicationContext.getPackageName() + ":toolsmp";
    Czh.add(jUU);
    Czh.add(Czj);
    AppMethodBeat.o(149404);
  }
  
  public static void aIZ(String paramString)
  {
    AppMethodBeat.i(149402);
    if ((paramString.equals(Czi)) || (Czh.contains(paramString))) {
      a.ewa();
    }
    AppMethodBeat.o(149402);
  }
  
  public static void ewn()
  {
    AppMethodBeat.i(149403);
    Iterator localIterator = Czh.iterator();
    while (localIterator.hasNext()) {
      j.a((String)localIterator.next(), null, a.class, null);
    }
    AppMethodBeat.o(149403);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements d
  {
    public void invoke(Object paramObject, f paramf)
    {
      AppMethodBeat.i(149401);
      a.ewa();
      AppMethodBeat.o(149401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e
 * JD-Core Version:    0.7.0.1
 */