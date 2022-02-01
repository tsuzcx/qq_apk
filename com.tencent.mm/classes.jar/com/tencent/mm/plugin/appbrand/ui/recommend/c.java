package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class c
{
  public static boolean bYQ()
  {
    AppMethodBeat.i(49292);
    if (bYT())
    {
      AppMethodBeat.o(49292);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOo, 0) > 0)
    {
      AppMethodBeat.o(49292);
      return true;
    }
    AppMethodBeat.o(49292);
    return false;
  }
  
  public static boolean bYR()
  {
    AppMethodBeat.i(49293);
    if (((Integer)g.aAh().azQ().get(ar.a.NYo, Integer.valueOf(0))).intValue() == 1)
    {
      AppMethodBeat.o(49293);
      return true;
    }
    AppMethodBeat.o(49293);
    return false;
  }
  
  public static boolean bYS()
  {
    AppMethodBeat.i(49294);
    if (bYT())
    {
      AppMethodBeat.o(49294);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXV, -1) == 1)
    {
      AppMethodBeat.o(49294);
      return true;
    }
    AppMethodBeat.o(49294);
    return false;
  }
  
  private static boolean bYT()
  {
    AppMethodBeat.i(227735);
    if (((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt())
    {
      if (((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp() != 1)
      {
        AppMethodBeat.o(227735);
        return true;
      }
      AppMethodBeat.o(227735);
      return false;
    }
    AppMethodBeat.o(227735);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c
 * JD-Core Version:    0.7.0.1
 */