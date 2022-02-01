package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;

public final class r
  extends a<ah>
{
  r()
  {
    super(w.qfH.ordinal());
    AppMethodBeat.i(47660);
    AppMethodBeat.o(47660);
  }
  
  public static boolean h(ah paramah)
  {
    AppMethodBeat.i(257943);
    if (paramah.Cp(w.qfH.ordinal()) == null)
    {
      AppMethodBeat.o(257943);
      return false;
    }
    if (!paramah.Cp(w.qfH.ordinal()).qfB)
    {
      AppMethodBeat.o(257943);
      return true;
    }
    AppMethodBeat.o(257943);
    return false;
  }
  
  public static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.r
  {
    private static final int CTRL_INDEX = 76;
    public static final String NAME = "onShareTimeline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.r
 * JD-Core Version:    0.7.0.1
 */