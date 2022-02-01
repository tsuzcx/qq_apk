package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends p
{
  private static final int CTRL_INDEX = 633;
  private static final String NAME = "onCustomRightButtonClick";
  
  public static void g(z paramz)
  {
    AppMethodBeat.i(135321);
    ae.i("OnCustomRightButtonClickEvent", "OnCustomRightButtonClickEvent dispatch");
    new d().g(paramz.Ey()).bja();
    AppMethodBeat.o(135321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.d
 * JD-Core Version:    0.7.0.1
 */