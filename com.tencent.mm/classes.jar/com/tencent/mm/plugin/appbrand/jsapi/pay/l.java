package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class l
  extends n
{
  public static final int CTRL_INDEX = 691;
  public static final String NAME = "requestJointPayment";
  
  public final void a(j paramj, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(282831);
    if (paramJSONObject == null)
    {
      paramj.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(282831);
      return;
    }
    try
    {
      paramJSONObject.put("key_joint_pay", true);
      super.a(paramj, paramJSONObject, paramInt);
      AppMethodBeat.o(282831);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiRequestJointPayment", paramJSONObject.getMessage());
      paramj.j(paramInt, h("fail", null));
      AppMethodBeat.o(282831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.l
 * JD-Core Version:    0.7.0.1
 */