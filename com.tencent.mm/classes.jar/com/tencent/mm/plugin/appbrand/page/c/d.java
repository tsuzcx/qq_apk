package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends p
{
  private static final int CTRL_INDEX = 633;
  private static final String NAME = "onCustomRightButtonClick";
  private static d iAD;
  
  static
  {
    AppMethodBeat.i(87378);
    iAD = new d();
    AppMethodBeat.o(87378);
  }
  
  public static void d(v paramv)
  {
    AppMethodBeat.i(87377);
    ab.i("onCustomRightButtonClickEvent", "onCustomRightButtonClickEvent dispatch");
    iAD.i(paramv.ws()).aBz();
    AppMethodBeat.o(87377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.d
 * JD-Core Version:    0.7.0.1
 */