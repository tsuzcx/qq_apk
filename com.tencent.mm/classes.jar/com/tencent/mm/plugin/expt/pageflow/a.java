package com.tencent.mm.plugin.expt.pageflow;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.f.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static int b(c.a parama)
  {
    AppMethodBeat.i(122357);
    c.dNK();
    int i = Util.getInt(c.c(parama, ""), 0);
    AppMethodBeat.o(122357);
    return i;
  }
  
  public static boolean dMW()
  {
    AppMethodBeat.i(122354);
    c.dNK();
    if (Util.getInt(c.c(c.a.yOI, ""), 0) > 0)
    {
      AppMethodBeat.o(122354);
      return true;
    }
    AppMethodBeat.o(122354);
    return false;
  }
  
  public static boolean dMX()
  {
    AppMethodBeat.i(122355);
    c.dNK();
    if (Util.getInt(c.c(c.a.yOJ, ""), 0) > 0)
    {
      AppMethodBeat.o(122355);
      return true;
    }
    AppMethodBeat.o(122355);
    return false;
  }
  
  public static boolean dMY()
  {
    AppMethodBeat.i(122356);
    c.dNK();
    if (Util.getInt(c.c(c.a.yOK, ""), 0) > 0)
    {
      AppMethodBeat.o(122356);
      return true;
    }
    AppMethodBeat.o(122356);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.pageflow.a
 * JD-Core Version:    0.7.0.1
 */