package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class m
  extends n
{
  public static final int CTRL_INDEX = 431;
  public static final String NAME = "requestMallPayment";
  
  public final void a(j paramj, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(281083);
    if (paramJSONObject == null)
    {
      paramj.j(paramInt, h("fail", null));
      AppMethodBeat.o(281083);
      return;
    }
    try
    {
      paramJSONObject.put("appId", paramj.getAppId());
      paramJSONObject.put("pay_for_wallet_type", 3);
      super.a(paramj, paramJSONObject, paramInt);
      AppMethodBeat.o(281083);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiRequestMallPayment", paramJSONObject.getMessage());
      paramj.j(paramInt, h("fail", null));
      AppMethodBeat.o(281083);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.m
 * JD-Core Version:    0.7.0.1
 */