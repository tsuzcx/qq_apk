package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends s
{
  private static final int CTRL_INDEX = 633;
  private static final String NAME = "onCustomRightButtonClick";
  
  public static void h(ac paramac)
  {
    AppMethodBeat.i(135321);
    Log.i("OnCustomRightButtonClickEvent", "OnCustomRightButtonClickEvent dispatch");
    new d().g(paramac.NY()).bEo();
    AppMethodBeat.o(135321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.d
 * JD-Core Version:    0.7.0.1
 */