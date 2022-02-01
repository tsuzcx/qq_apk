package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class c
{
  public static boolean bBQ()
  {
    AppMethodBeat.i(49292);
    if (((b)g.ab(b.class)).a(b.a.qwD, 0) > 0)
    {
      AppMethodBeat.o(49292);
      return true;
    }
    AppMethodBeat.o(49292);
    return false;
  }
  
  public static boolean bBR()
  {
    AppMethodBeat.i(49293);
    if (((Integer)g.ajR().ajA().get(am.a.IQn, Integer.valueOf(0))).intValue() == 1)
    {
      AppMethodBeat.o(49293);
      return true;
    }
    AppMethodBeat.o(49293);
    return false;
  }
  
  public static boolean bBS()
  {
    AppMethodBeat.i(49294);
    if (((b)g.ab(b.class)).a(b.a.qEM, -1) == 1)
    {
      AppMethodBeat.o(49294);
      return true;
    }
    AppMethodBeat.o(49294);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c
 * JD-Core Version:    0.7.0.1
 */