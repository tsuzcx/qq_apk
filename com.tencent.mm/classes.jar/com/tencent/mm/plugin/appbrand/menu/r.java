package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;

public final class r
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ah>
{
  r()
  {
    super(x.tkl.ordinal());
    AppMethodBeat.i(47660);
    AppMethodBeat.o(47660);
  }
  
  public static boolean g(ah paramah)
  {
    AppMethodBeat.i(323827);
    if (paramah.CF(x.tkl.ordinal()) == null)
    {
      AppMethodBeat.o(323827);
      return false;
    }
    if ((!paramah.CF(x.tkl.ordinal()).disable) && (!com.tencent.mm.plugin.appbrand.k.a.a.F(paramah.getRuntime())))
    {
      AppMethodBeat.o(323827);
      return true;
    }
    AppMethodBeat.o(323827);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.r
 * JD-Core Version:    0.7.0.1
 */