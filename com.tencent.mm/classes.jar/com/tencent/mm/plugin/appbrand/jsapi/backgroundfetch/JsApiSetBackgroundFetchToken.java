package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiSetBackgroundFetchToken
  extends a
{
  public static final int CTRL_INDEX = 641;
  public static final String NAME = "setBackgroundFetchToken";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143394);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(143394);
      return;
    }
    paramJSONObject = paramJSONObject.optString("token");
    if (bo.isNullOrNil(paramJSONObject))
    {
      ab.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:token is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(143394);
      return;
    }
    if (paramJSONObject.length() > 1024)
    {
      ab.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:token is too long");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(143394);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new JsApiSetBackgroundFetchToken.SetBackgroundFetchTokenParcel(paramc.getAppId(), paramJSONObject), JsApiSetBackgroundFetchToken.a.class, new com.tencent.mm.ipcinvoker.c() {});
    AppMethodBeat.o(143394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiSetBackgroundFetchToken
 * JD-Core Version:    0.7.0.1
 */