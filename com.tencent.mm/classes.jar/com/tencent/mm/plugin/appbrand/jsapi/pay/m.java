package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class m
  extends n
{
  public static final int CTRL_INDEX = 431;
  public static final String NAME = "requestMallPayment";
  
  public final void a(k paramk, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327838);
    if (paramJSONObject == null)
    {
      paramk.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(327838);
      return;
    }
    try
    {
      paramJSONObject.put("appId", paramk.getAppId());
      paramJSONObject.put("pay_for_wallet_type", 3);
      super.a(paramk, paramJSONObject, paramInt);
      AppMethodBeat.o(327838);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiRequestMallPayment", paramJSONObject.getMessage());
      paramk.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(327838);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.m
 * JD-Core Version:    0.7.0.1
 */