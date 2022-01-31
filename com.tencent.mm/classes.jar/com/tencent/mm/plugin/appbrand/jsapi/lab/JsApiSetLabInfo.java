package com.tencent.mm.plugin.appbrand.jsapi.lab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiSetLabInfo
  extends a
{
  public static final int CTRL_INDEX = 558;
  public static final String NAME = "setLabInfo";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131107);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiSetLabInfo", "fail:data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131107);
      return;
    }
    String str = paramJSONObject.optString("labId");
    if ((bo.isNullOrNil(str)) || (!paramJSONObject.has("enabled")))
    {
      ab.e("MicroMsg.JsApiSetLabInfo", "fail:labId is null or no enabled");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131107);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new JsApiSetLabInfo.IPCSetLabInfoRequest(str, paramJSONObject.optBoolean("enabled")), JsApiSetLabInfo.a.class, new JsApiSetLabInfo.1(this, paramc, paramInt));
    AppMethodBeat.o(131107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo
 * JD-Core Version:    0.7.0.1
 */