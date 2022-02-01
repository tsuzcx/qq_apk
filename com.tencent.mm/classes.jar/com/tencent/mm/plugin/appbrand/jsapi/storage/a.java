package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class a
  extends c<k>
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorage";
  
  private void a(final k paramk, final int paramInt)
  {
    AppMethodBeat.i(147229);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147228);
        n localn = paramk.getRuntime().asG();
        ((com.tencent.luggage.sdk.customize.a)e.T(com.tencent.luggage.sdk.customize.a.class)).f(paramk.getAppId(), localn.qYZ, localn.qLQ).ai(paramInt, paramk.getAppId());
        AppMethodBeat.o(147228);
      }
    }, "JsApiClearStorage");
    AppMethodBeat.o(147229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.a
 * JD-Core Version:    0.7.0.1
 */