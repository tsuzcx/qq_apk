package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class e
  extends p
{
  private static final int CTRL_INDEX = 751;
  public static final String NAME = "onSplashAdShow";
  public String source = "launch";
  
  public final void c(r paramr)
  {
    AppMethodBeat.i(44049);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", bu.bI(this.source, "launch"));
    ae.i("MicroMsg.JsApiEventOnSplashAdShow[AppBrandSplashAd]", "dispatch, source:%s", new Object[] { this.source });
    H(localHashMap).g(paramr).bja();
    AppMethodBeat.o(44049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.e
 * JD-Core Version:    0.7.0.1
 */