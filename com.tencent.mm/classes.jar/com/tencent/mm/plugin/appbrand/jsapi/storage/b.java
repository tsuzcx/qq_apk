package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u;

public final class b
  extends u<h>
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorageSync";
  
  private String b(h paramh, int paramInt)
  {
    AppMethodBeat.i(102025);
    JsApiClearStorageTask localJsApiClearStorageTask = new JsApiClearStorageTask();
    localJsApiClearStorageTask.appId = paramh.getAppId();
    localJsApiClearStorageTask.ias = paramInt;
    AppBrandMainProcessService.b(localJsApiClearStorageTask);
    paramh = j("ok", null);
    AppMethodBeat.o(102025);
    return paramh;
  }
  
  private String c(h paramh, int paramInt)
  {
    AppMethodBeat.i(102026);
    ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).cc(paramh.getAppId()).I(paramInt, paramh.getAppId());
    paramh = j("ok", null);
    AppMethodBeat.o(102026);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.b
 * JD-Core Version:    0.7.0.1
 */