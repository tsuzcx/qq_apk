package com.tencent.mm.plugin.appbrand.page.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends p
{
  private static final int CTRL_INDEX = 633;
  private static final String NAME = "onCustomRightButtonClick";
  
  public static void h(aa paramaa)
  {
    AppMethodBeat.i(135321);
    ad.i("OnCustomRightButtonClickEvent", "OnCustomRightButtonClickEvent dispatch");
    new d().g(paramaa.Ew()).bir();
    AppMethodBeat.o(135321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.d
 * JD-Core Version:    0.7.0.1
 */