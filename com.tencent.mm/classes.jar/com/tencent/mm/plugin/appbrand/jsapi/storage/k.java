package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.g.b;

public class k
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorage";
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString, int paramInt)
  {
    AppMethodBeat.i(147267);
    JsApiRemoveStorageTask localJsApiRemoveStorageTask = new JsApiRemoveStorageTask();
    localJsApiRemoveStorageTask.appId = B(paramh);
    localJsApiRemoveStorageTask.liU = paramInt;
    localJsApiRemoveStorageTask.key = paramString;
    AppBrandMainProcessService.a(localJsApiRemoveStorageTask);
    AppMethodBeat.o(147267);
  }
  
  private void b(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(147268);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147266);
        ((com.tencent.luggage.sdk.customize.a)e.K(com.tencent.luggage.sdk.customize.a.class)).dg(paramh.getAppId()).l(paramInt, k.this.B(paramh), paramString);
        AppMethodBeat.o(147266);
      }
    }, "JsApiRemoveStorage");
    AppMethodBeat.o(147268);
  }
  
  protected String B(c paramc)
  {
    AppMethodBeat.i(147269);
    paramc = paramc.getAppId();
    AppMethodBeat.o(147269);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.k
 * JD-Core Version:    0.7.0.1
 */