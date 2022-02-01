package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.teenmode.a.d;

public final class c
{
  public static boolean cMX()
  {
    AppMethodBeat.i(49292);
    if (cMZ())
    {
      AppMethodBeat.o(49292);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGO, 0) > 0)
    {
      AppMethodBeat.o(49292);
      return true;
    }
    AppMethodBeat.o(49292);
    return false;
  }
  
  public static boolean cMY()
  {
    AppMethodBeat.i(49294);
    if (cMZ())
    {
      AppMethodBeat.o(49294);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUg, -1) == 1)
    {
      AppMethodBeat.o(49294);
      return true;
    }
    AppMethodBeat.o(49294);
    return false;
  }
  
  private static boolean cMZ()
  {
    AppMethodBeat.i(322561);
    if (((d)h.ax(d.class)).aBu())
    {
      if (((d)h.ax(d.class)).hEr() != 1)
      {
        AppMethodBeat.o(322561);
        return true;
      }
      AppMethodBeat.o(322561);
      return false;
    }
    AppMethodBeat.o(322561);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c
 * JD-Core Version:    0.7.0.1
 */