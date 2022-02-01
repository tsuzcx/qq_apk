package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  private static final int CTRL_INDEX = 760;
  public static final String NAME = "onSplashAdButtonClicked";
  public String source = "launch";
  public String type = "close";
  
  public final void d(com.tencent.mm.plugin.appbrand.s params)
  {
    AppMethodBeat.i(160554);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    localHashMap.put("buttonType", Util.nullAs(this.type, "close"));
    Log.i("MicroMsg.JsApiEventOnSplashAdButtonClicked[AppBrandSplashAd]", "dispatch, source:%s, buttonType:%s", new Object[] { this.source, this.type });
    K(localHashMap).g(params).bEo();
    AppMethodBeat.o(160554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.b
 * JD-Core Version:    0.7.0.1
 */