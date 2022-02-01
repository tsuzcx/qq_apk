package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class m
  extends n
{
  public static final int CTRL_INDEX = 431;
  public static final String NAME = "requestMallPayment";
  
  public final void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(222653);
    if (paramJSONObject == null)
    {
      paramh.h(paramInt, e("fail", null));
      AppMethodBeat.o(222653);
      return;
    }
    try
    {
      paramJSONObject.put("appId", paramh.getAppId());
      paramJSONObject.put("pay_for_wallet_type", 3);
      super.a(paramh, paramJSONObject, paramInt);
      AppMethodBeat.o(222653);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ae.e("MicroMsg.JsApiRequestMallPayment", paramJSONObject.getMessage());
      paramh.h(paramInt, e("fail", null));
      AppMethodBeat.o(222653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.m
 * JD-Core Version:    0.7.0.1
 */