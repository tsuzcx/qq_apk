package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends s
{
  private static final int CTRL_INDEX = 633;
  private static final String NAME = "onCustomRightButtonClick";
  
  public static void h(ad paramad)
  {
    AppMethodBeat.i(135321);
    Log.i("OnCustomRightButtonClickEvent", "OnCustomRightButtonClickEvent dispatch");
    new d().h(paramad.ari()).cpV();
    AppMethodBeat.o(135321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.d
 * JD-Core Version:    0.7.0.1
 */