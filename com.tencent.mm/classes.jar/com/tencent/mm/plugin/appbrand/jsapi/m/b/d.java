package com.tencent.mm.plugin.appbrand.jsapi.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.o.e;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 243;
  public static final String NAME = "operateRequestTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179534);
    a(paramc, paramJSONObject, paramInt, paramc.aYh());
    AppMethodBeat.o(179534);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(187750);
    ad.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiOperateRequestTask", "data is null");
      AppMethodBeat.o(187750);
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      paramc.h(paramInt, e("fail:requestTaskId is null or nil", null));
      AppMethodBeat.o(187750);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bt.isNullOrNil(paramJSONObject))
    {
      ad.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      paramc.h(paramInt, e("fail:operationType is null or nil", null));
      AppMethodBeat.o(187750);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = f.bti().SM(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, e("fail:no task", null));
        ad.w("MicroMsg.JsApiOperateRequestTask", "request is null");
        AppMethodBeat.o(187750);
        return;
      }
      e locale = paramJSONObject.SL(str);
      if (locale != null) {
        paramJSONObject.b(locale);
      }
      for (boolean bool = true; !bool; bool = paramJSONObject.SJ(str))
      {
        paramc.h(paramInt, e("fail:no task", null));
        ad.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", new Object[] { str, paramc.getAppId() });
        AppMethodBeat.o(187750);
        return;
      }
      paramc.h(paramInt, e("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().h(paramc).Pi(paramJSONObject).a(paramo);
      ad.i("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", new Object[] { str, paramc.getAppId() });
      AppMethodBeat.o(187750);
      return;
    }
    paramc.h(paramInt, e("fail:unknown operationType", null));
    AppMethodBeat.o(187750);
  }
  
  public final boolean bij()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b.d
 * JD-Core Version:    0.7.0.1
 */