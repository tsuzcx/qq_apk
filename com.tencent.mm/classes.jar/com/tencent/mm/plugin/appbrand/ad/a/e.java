package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class e
  extends p
{
  private static final int CTRL_INDEX = 751;
  public static final String NAME = "onSplashAdShow";
  public String source = "launch";
  
  public final void c(q paramq)
  {
    AppMethodBeat.i(44049);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", bt.bI(this.source, "launch"));
    ad.i("MicroMsg.JsApiEventOnSplashAdShow[AppBrandSplashAd]", "dispatch, source:%s", new Object[] { this.source });
    A(localHashMap).g(paramq).bir();
    AppMethodBeat.o(44049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.e
 * JD-Core Version:    0.7.0.1
 */