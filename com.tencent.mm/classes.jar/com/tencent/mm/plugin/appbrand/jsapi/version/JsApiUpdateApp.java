package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;

public final class JsApiUpdateApp
  extends a<c>
{
  private static final int CTRL_INDEX = 359;
  private static final String NAME = "updateApp";
  
  public final void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(143435);
    XIPCInvoker.a("com.tencent.mm", new JsApiUpdateApp.SyncRequest(paramc.getRuntime().atS(), paramc.getRuntime().wS().bDh), JsApiUpdateApp.a.class, new JsApiUpdateApp.1(this, paramc, paramInt));
    AppMethodBeat.o(143435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp
 * JD-Core Version:    0.7.0.1
 */