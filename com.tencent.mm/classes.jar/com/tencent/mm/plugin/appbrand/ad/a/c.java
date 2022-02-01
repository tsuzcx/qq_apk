package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class c
  extends p
{
  private static final int CTRL_INDEX = 753;
  public static final String NAME = "onSplashAdClose";
  public String source = "launch";
  
  public final void c(r paramr)
  {
    AppMethodBeat.i(44047);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", bu.bI(this.source, "launch"));
    ae.i("MicroMsg.JsApiEventOnSplashAdClosed[AppBrandSplashAd]", "dispatch, source:%s", new Object[] { this.source });
    H(localHashMap).g(paramr).bja();
    AppMethodBeat.o(44047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.c
 * JD-Core Version:    0.7.0.1
 */