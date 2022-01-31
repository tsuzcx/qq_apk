package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.expt.e.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static boolean bsL()
  {
    AppMethodBeat.i(73520);
    c.btm();
    if (bo.getInt(c.a(a.a.lUC, "", false), 0) > 0)
    {
      AppMethodBeat.o(73520);
      return true;
    }
    AppMethodBeat.o(73520);
    return false;
  }
  
  public static boolean bsM()
  {
    AppMethodBeat.i(73521);
    c.btm();
    if (bo.getInt(c.a(a.a.lUD, "", false), 0) > 0)
    {
      AppMethodBeat.o(73521);
      return true;
    }
    AppMethodBeat.o(73521);
    return false;
  }
  
  public static boolean bsN()
  {
    AppMethodBeat.i(73522);
    c.btm();
    if (bo.getInt(c.a(a.a.lUE, "", false), 0) > 0)
    {
      AppMethodBeat.o(73522);
      return true;
    }
    AppMethodBeat.o(73522);
    return false;
  }
  
  public static int c(a.a parama)
  {
    AppMethodBeat.i(73523);
    c.btm();
    int i = bo.getInt(c.a(parama, "", false), 0);
    AppMethodBeat.o(73523);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.a
 * JD-Core Version:    0.7.0.1
 */