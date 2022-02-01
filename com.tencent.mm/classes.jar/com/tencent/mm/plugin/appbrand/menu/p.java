package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;

public final class p
  extends a<ag>
{
  p()
  {
    super(u.neZ.ordinal());
    AppMethodBeat.i(47660);
    AppMethodBeat.o(47660);
  }
  
  public static boolean g(ag paramag)
  {
    AppMethodBeat.i(227171);
    if (!paramag.yK(u.neZ.ordinal()).neT)
    {
      AppMethodBeat.o(227171);
      return true;
    }
    AppMethodBeat.o(227171);
    return false;
  }
  
  public static final class a
    extends s
  {
    private static final int CTRL_INDEX = 76;
    public static final String NAME = "onShareTimeline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.p
 * JD-Core Version:    0.7.0.1
 */