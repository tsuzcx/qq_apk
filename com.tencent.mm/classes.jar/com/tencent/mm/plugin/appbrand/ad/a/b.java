package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class b
  extends p
{
  private static final int CTRL_INDEX = 760;
  public static final String NAME = "onSplashAdButtonClicked";
  public String source = "launch";
  public String type = "close";
  
  public final void c(r paramr)
  {
    AppMethodBeat.i(160554);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", bu.bI(this.source, "launch"));
    localHashMap.put("buttonType", bu.bI(this.type, "close"));
    ae.i("MicroMsg.JsApiEventOnSplashAdButtonClicked[AppBrandSplashAd]", "dispatch, source:%s, buttonType:%s", new Object[] { this.source, this.type });
    H(localHashMap).g(paramr).bja();
    AppMethodBeat.o(160554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.b
 * JD-Core Version:    0.7.0.1
 */