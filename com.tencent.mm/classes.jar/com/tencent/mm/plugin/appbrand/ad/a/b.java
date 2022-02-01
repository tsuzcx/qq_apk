package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class b
  extends p
{
  private static final int CTRL_INDEX = 760;
  public static final String NAME = "onSplashAdButtonClicked";
  public String source = "launch";
  public String type = "close";
  
  public final void c(q paramq)
  {
    AppMethodBeat.i(160554);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", bt.bI(this.source, "launch"));
    localHashMap.put("buttonType", bt.bI(this.type, "close"));
    ad.i("MicroMsg.JsApiEventOnSplashAdButtonClicked[AppBrandSplashAd]", "dispatch, source:%s, buttonType:%s", new Object[] { this.source, this.type });
    A(localHashMap).g(paramq).bir();
    AppMethodBeat.o(160554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.b
 * JD-Core Version:    0.7.0.1
 */