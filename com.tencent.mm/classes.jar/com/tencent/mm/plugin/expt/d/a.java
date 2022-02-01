package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.f.c;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static int b(b.a parama)
  {
    AppMethodBeat.i(122357);
    c.ceF();
    int i = bt.getInt(c.b(parama, ""), 0);
    AppMethodBeat.o(122357);
    return i;
  }
  
  public static boolean ced()
  {
    AppMethodBeat.i(122354);
    c.ceF();
    if (bt.getInt(c.b(b.a.pmS, ""), 0) > 0)
    {
      AppMethodBeat.o(122354);
      return true;
    }
    AppMethodBeat.o(122354);
    return false;
  }
  
  public static boolean cee()
  {
    AppMethodBeat.i(122355);
    c.ceF();
    if (bt.getInt(c.b(b.a.pmT, ""), 0) > 0)
    {
      AppMethodBeat.o(122355);
      return true;
    }
    AppMethodBeat.o(122355);
    return false;
  }
  
  public static boolean cef()
  {
    AppMethodBeat.i(122356);
    c.ceF();
    if (bt.getInt(c.b(b.a.pmU, ""), 0) > 0)
    {
      AppMethodBeat.o(122356);
      return true;
    }
    AppMethodBeat.o(122356);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a
 * JD-Core Version:    0.7.0.1
 */