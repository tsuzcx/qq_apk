package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;

public final class b
  extends aa<j>
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorageSync";
  
  private String b(j paramj, int paramInt)
  {
    AppMethodBeat.i(147231);
    JsApiClearStorageTask localJsApiClearStorageTask = new JsApiClearStorageTask();
    localJsApiClearStorageTask.appId = paramj.getAppId();
    localJsApiClearStorageTask.prw = paramInt;
    localJsApiClearStorageTask.bPu();
    paramj = h("ok", null);
    AppMethodBeat.o(147231);
    return paramj;
  }
  
  private String c(j paramj, int paramInt)
  {
    AppMethodBeat.i(147232);
    ((a)e.K(a.class)).dX(paramj.getAppId()).aa(paramInt, paramj.getAppId());
    paramj = h("ok", null);
    AppMethodBeat.o(147232);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.b
 * JD-Core Version:    0.7.0.1
 */