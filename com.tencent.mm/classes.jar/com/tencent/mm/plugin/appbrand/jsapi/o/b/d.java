package com.tencent.mm.plugin.appbrand.jsapi.o.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 243;
  public static final String NAME = "operateRequestTask";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179534);
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
    AppMethodBeat.o(179534);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(207098);
    Log.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiOperateRequestTask", "data is null");
      AppMethodBeat.o(207098);
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      paramf.i(paramInt, h("fail:requestTaskId is null or nil", null));
      AppMethodBeat.o(207098);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      paramf.i(paramInt, h("fail:operationType is null or nil", null));
      AppMethodBeat.o(207098);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(paramf.getAppId());
      if (paramJSONObject == null)
      {
        paramf.i(paramInt, h("fail:no task", null));
        Log.w("MicroMsg.JsApiOperateRequestTask", "request is null");
        AppMethodBeat.o(207098);
        return;
      }
      e locale = paramJSONObject.acY(str);
      if (locale != null) {
        paramJSONObject.b(locale);
      }
      for (boolean bool = true; !bool; bool = paramJSONObject.acW(str))
      {
        paramf.i(paramInt, h("fail:no task", null));
        Log.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", new Object[] { str, paramf.getAppId() });
        AppMethodBeat.o(207098);
        return;
      }
      paramf.i(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().h(paramf).Zh(paramJSONObject).a(paramo);
      Log.i("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", new Object[] { str, paramf.getAppId() });
      AppMethodBeat.o(207098);
      return;
    }
    paramf.i(paramInt, h("fail:unknown operationType", null));
    AppMethodBeat.o(207098);
  }
  
  public final boolean bEi()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b.d
 * JD-Core Version:    0.7.0.1
 */