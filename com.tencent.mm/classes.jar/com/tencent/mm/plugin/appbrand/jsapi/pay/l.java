package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class l
  extends n
{
  public static final int CTRL_INDEX = 691;
  public static final String NAME = "requestJointPayment";
  
  public final void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(188502);
    if (paramJSONObject == null)
    {
      paramh.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(188502);
      return;
    }
    try
    {
      paramJSONObject.put("key_joint_pay", true);
      super.a(paramh, paramJSONObject, paramInt);
      AppMethodBeat.o(188502);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.JsApiRequestJointPayment", paramJSONObject.getMessage());
      paramh.h(paramInt, e("fail", null));
      AppMethodBeat.o(188502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.l
 * JD-Core Version:    0.7.0.1
 */