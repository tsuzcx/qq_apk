package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;

public final class b
  extends y<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorageSync";
  
  private String b(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt)
  {
    AppMethodBeat.i(147231);
    JsApiClearStorageTask localJsApiClearStorageTask = new JsApiClearStorageTask();
    localJsApiClearStorageTask.appId = paramh.getAppId();
    localJsApiClearStorageTask.kkZ = paramInt;
    AppBrandMainProcessService.b(localJsApiClearStorageTask);
    paramh = e("ok", null);
    AppMethodBeat.o(147231);
    return paramh;
  }
  
  private String c(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt)
  {
    AppMethodBeat.i(147232);
    ((a)e.K(a.class)).cs(paramh.getAppId()).R(paramInt, paramh.getAppId());
    paramh = e("ok", null);
    AppMethodBeat.o(147232);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.b
 * JD-Core Version:    0.7.0.1
 */