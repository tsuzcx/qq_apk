package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class a
  extends d<k>
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
        ((com.tencent.luggage.sdk.customize.a)e.M(com.tencent.luggage.sdk.customize.a.class)).dD(paramk.getAppId()).Y(paramInt, paramk.getAppId());
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