package com.tencent.mm.plugin.appbrand.jsapi.p.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends c
{
  public static final int CTRL_INDEX = 243;
  public static final String NAME = "operateRequestTask";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179534);
    a(parame, paramJSONObject, paramInt, parame.getJsRuntime());
    AppMethodBeat.o(179534);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.m.o paramo)
  {
    AppMethodBeat.i(186455);
    Log.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiOperateRequestTask", "data is null");
      AppMethodBeat.o(186455);
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      parame.j(paramInt, h("fail:requestTaskId is null or nil", null));
      AppMethodBeat.o(186455);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      parame.j(paramInt, h("fail:operationType is null or nil", null));
      AppMethodBeat.o(186455);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = f.cbR().akT(parame.getAppId());
      if (paramJSONObject == null)
      {
        parame.j(paramInt, h("fail:no task", null));
        Log.w("MicroMsg.JsApiOperateRequestTask", "request is null");
        AppMethodBeat.o(186455);
        return;
      }
      com.tencent.mm.plugin.appbrand.s.e locale = paramJSONObject.akS(str);
      if (locale != null) {
        paramJSONObject.b(locale);
      }
      for (boolean bool = true; !bool; bool = paramJSONObject.akQ(str))
      {
        parame.j(paramInt, h("fail:no task", null));
        Log.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", new Object[] { str, parame.getAppId() });
        AppMethodBeat.o(186455);
        return;
      }
      parame.j(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().j(parame).agU(paramJSONObject).b(paramo);
      Log.i("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", new Object[] { str, parame.getAppId() });
      AppMethodBeat.o(186455);
      return;
    }
    parame.j(paramInt, h("fail:unknown operationType", null));
    AppMethodBeat.o(186455);
  }
  
  public final boolean bPG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b.d
 * JD-Core Version:    0.7.0.1
 */