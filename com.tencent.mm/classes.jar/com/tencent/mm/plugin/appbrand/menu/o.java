package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ad;

public final class o
  extends a<ad>
{
  o()
  {
    super(s.lXm.ordinal());
    AppMethodBeat.i(47660);
    AppMethodBeat.o(47660);
  }
  
  public static boolean f(ad paramad)
  {
    AppMethodBeat.i(222823);
    if (!paramad.uS(s.lXm.ordinal()).lXh)
    {
      AppMethodBeat.o(222823);
      return true;
    }
    AppMethodBeat.o(222823);
    return false;
  }
  
  public static final class a
    extends p
  {
    private static final int CTRL_INDEX = 76;
    public static final String NAME = "onShareTimeline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o
 * JD-Core Version:    0.7.0.1
 */