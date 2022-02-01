package com.tencent.mm.plugin.appbrand.jsapi.s.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.t.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends c
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
    AppMethodBeat.i(327297);
    Log.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data is null"));
      Log.e("MicroMsg.JsApiOperateRequestTask", "data is null");
      AppMethodBeat.o(327297);
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      paramf.callback(paramInt, ZP("fail:requestTaskId is null or nil"));
      AppMethodBeat.o(327297);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      paramf.callback(paramInt, ZP("fail:operationType is null or nil"));
      AppMethodBeat.o(327297);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.mm.plugin.appbrand.t.f.cCk().aea(paramf.getAppId());
      if (paramJSONObject == null)
      {
        paramf.callback(paramInt, ZP("fail:no task"));
        Log.w("MicroMsg.JsApiOperateRequestTask", "request is null");
        AppMethodBeat.o(327297);
        return;
      }
      com.tencent.mm.plugin.appbrand.t.e locale = paramJSONObject.adZ(str);
      if (locale != null) {
        paramJSONObject.b(locale);
      }
      for (boolean bool = true; !bool; bool = paramJSONObject.adX(str))
      {
        paramf.callback(paramInt, ZP("fail:no task"));
        Log.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", new Object[] { str, paramf.getAppId() });
        AppMethodBeat.o(327297);
        return;
      }
      paramf.callback(paramInt, ZP("ok"));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().i(paramf).ZR(paramJSONObject).b(paramo);
      Log.i("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", new Object[] { str, paramf.getAppId() });
      AppMethodBeat.o(327297);
      return;
    }
    paramf.callback(paramInt, ZP("fail:unknown operationType"));
    AppMethodBeat.o(327297);
  }
  
  public final boolean cpN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.e
 * JD-Core Version:    0.7.0.1
 */