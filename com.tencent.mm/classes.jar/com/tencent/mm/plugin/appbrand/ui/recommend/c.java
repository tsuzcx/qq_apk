package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;

public final class c
{
  public static boolean clA()
  {
    AppMethodBeat.i(49292);
    if (clC())
    {
      AppMethodBeat.o(49292);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuj, 0) > 0)
    {
      AppMethodBeat.o(49292);
      return true;
    }
    AppMethodBeat.o(49292);
    return false;
  }
  
  public static boolean clB()
  {
    AppMethodBeat.i(49294);
    if (clC())
    {
      AppMethodBeat.o(49294);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEL, -1) == 1)
    {
      AppMethodBeat.o(49294);
      return true;
    }
    AppMethodBeat.o(49294);
    return false;
  }
  
  private static boolean clC()
  {
    AppMethodBeat.i(271209);
    if (((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM())
    {
      if (((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gks() != 1)
      {
        AppMethodBeat.o(271209);
        return true;
      }
      AppMethodBeat.o(271209);
      return false;
    }
    AppMethodBeat.o(271209);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c
 * JD-Core Version:    0.7.0.1
 */