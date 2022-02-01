package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public final class d
  extends p
{
  private static final int CTRL_INDEX = 752;
  public static final String NAME = "onSplashAdHide";
  public String source = "launch";
  
  public final void c(q paramq)
  {
    AppMethodBeat.i(44048);
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", bs.bG(this.source, "launch"));
    ac.i("MicroMsg.JsApiEventOnSplashAdHide", "dispatch, source:%s", new Object[] { this.source });
    A(localHashMap).g(paramq).beN();
    AppMethodBeat.o(44048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.d
 * JD-Core Version:    0.7.0.1
 */