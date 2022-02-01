package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.i.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static int b(b.a parama)
  {
    AppMethodBeat.i(122357);
    c.cSa();
    int i = Util.getInt(c.c(parama, ""), 0);
    AppMethodBeat.o(122357);
    return i;
  }
  
  public static boolean cRq()
  {
    AppMethodBeat.i(122354);
    c.cSa();
    if (Util.getInt(c.c(b.a.rUk, ""), 0) > 0)
    {
      AppMethodBeat.o(122354);
      return true;
    }
    AppMethodBeat.o(122354);
    return false;
  }
  
  public static boolean cRr()
  {
    AppMethodBeat.i(122355);
    c.cSa();
    if (Util.getInt(c.c(b.a.rUl, ""), 0) > 0)
    {
      AppMethodBeat.o(122355);
      return true;
    }
    AppMethodBeat.o(122355);
    return false;
  }
  
  public static boolean cRs()
  {
    AppMethodBeat.i(122356);
    c.cSa();
    if (Util.getInt(c.c(b.a.rUm, ""), 0) > 0)
    {
      AppMethodBeat.o(122356);
      return true;
    }
    AppMethodBeat.o(122356);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.a
 * JD-Core Version:    0.7.0.1
 */