package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class l
  extends n
{
  public static final int CTRL_INDEX = 691;
  public static final String NAME = "requestJointPayment";
  
  public final void a(k paramk, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327837);
    if (paramJSONObject == null)
    {
      paramk.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(327837);
      return;
    }
    try
    {
      paramJSONObject.put("key_joint_pay", true);
      super.a(paramk, paramJSONObject, paramInt);
      AppMethodBeat.o(327837);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiRequestJointPayment", paramJSONObject.getMessage());
      paramk.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(327837);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.l
 * JD-Core Version:    0.7.0.1
 */