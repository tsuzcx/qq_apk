package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;

public final class b
  extends ab<k>
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorageSync";
  
  private String b(k paramk, int paramInt)
  {
    AppMethodBeat.i(147231);
    JsApiClearStorageTask localJsApiClearStorageTask = new JsApiClearStorageTask();
    localJsApiClearStorageTask.appId = paramk.getAppId();
    localJsApiClearStorageTask.svX = paramInt;
    localJsApiClearStorageTask.cpB();
    paramk = ZP("ok");
    AppMethodBeat.o(147231);
    return paramk;
  }
  
  private String c(k paramk, int paramInt)
  {
    AppMethodBeat.i(147232);
    n localn = paramk.getRuntime().asG();
    ((a)e.T(a.class)).f(paramk.getAppId(), localn.qYZ, localn.qLQ).ai(paramInt, paramk.getAppId());
    paramk = ZP("ok");
    AppMethodBeat.o(147232);
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.b
 * JD-Core Version:    0.7.0.1
 */