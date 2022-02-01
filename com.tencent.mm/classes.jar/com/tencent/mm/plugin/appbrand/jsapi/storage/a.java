package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorage";
  
  private void a(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, final int paramInt)
  {
    AppMethodBeat.i(147229);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147228);
        ((com.tencent.luggage.sdk.customize.a)e.K(com.tencent.luggage.sdk.customize.a.class)).cs(paramh.getAppId()).R(paramInt, paramh.getAppId());
        AppMethodBeat.o(147228);
      }
    }, "JsApiClearStorage");
    AppMethodBeat.o(147229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.a
 * JD-Core Version:    0.7.0.1
 */