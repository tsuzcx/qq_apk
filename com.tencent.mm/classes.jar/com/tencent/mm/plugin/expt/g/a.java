package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.i.c;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static int b(b.a parama)
  {
    AppMethodBeat.i(122357);
    c.crR();
    int i = bt.getInt(c.b(parama, ""), 0);
    AppMethodBeat.o(122357);
    return i;
  }
  
  public static boolean crh()
  {
    AppMethodBeat.i(122354);
    c.crR();
    if (bt.getInt(c.b(b.a.quH, ""), 0) > 0)
    {
      AppMethodBeat.o(122354);
      return true;
    }
    AppMethodBeat.o(122354);
    return false;
  }
  
  public static boolean cri()
  {
    AppMethodBeat.i(122355);
    c.crR();
    if (bt.getInt(c.b(b.a.quI, ""), 0) > 0)
    {
      AppMethodBeat.o(122355);
      return true;
    }
    AppMethodBeat.o(122355);
    return false;
  }
  
  public static boolean crj()
  {
    AppMethodBeat.i(122356);
    c.crR();
    if (bt.getInt(c.b(b.a.quJ, ""), 0) > 0)
    {
      AppMethodBeat.o(122356);
      return true;
    }
    AppMethodBeat.o(122356);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.a
 * JD-Core Version:    0.7.0.1
 */