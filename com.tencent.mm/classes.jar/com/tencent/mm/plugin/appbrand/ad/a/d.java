package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  private static final int CTRL_INDEX = 752;
  public static final String NAME = "onSplashAdHide";
  public String source = "launch";
  
  public final void d(com.tencent.mm.plugin.appbrand.s params)
  {
    AppMethodBeat.i(44048);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    Log.i("MicroMsg.JsApiEventOnSplashAdHide[AppBrandSplashAd]", "dispatch, source:%s", new Object[] { this.source });
    K(localHashMap).g(params).bEo();
    AppMethodBeat.o(44048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.d
 * JD-Core Version:    0.7.0.1
 */