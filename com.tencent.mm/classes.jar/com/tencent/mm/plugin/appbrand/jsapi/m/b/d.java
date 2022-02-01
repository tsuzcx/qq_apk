package com.tencent.mm.plugin.appbrand.jsapi.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.o.e;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
    a(paramc, paramJSONObject, paramInt, paramc.aYB());
    AppMethodBeat.o(179534);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(193479);
    ae.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ae.e("MicroMsg.JsApiOperateRequestTask", "data is null");
      AppMethodBeat.o(193479);
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      paramc.h(paramInt, e("fail:requestTaskId is null or nil", null));
      AppMethodBeat.o(193479);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bu.isNullOrNil(paramJSONObject))
    {
      ae.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      paramc.h(paramInt, e("fail:operationType is null or nil", null));
      AppMethodBeat.o(193479);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = f.btT().Tv(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, e("fail:no task", null));
        ae.w("MicroMsg.JsApiOperateRequestTask", "request is null");
        AppMethodBeat.o(193479);
        return;
      }
      e locale = paramJSONObject.Tu(str);
      if (locale != null) {
        paramJSONObject.b(locale);
      }
      for (boolean bool = true; !bool; bool = paramJSONObject.Ts(str))
      {
        paramc.h(paramInt, e("fail:no task", null));
        ae.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", new Object[] { str, paramc.getAppId() });
        AppMethodBeat.o(193479);
        return;
      }
      paramc.h(paramInt, e("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().h(paramc).PQ(paramJSONObject).a(paramo);
      ae.i("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", new Object[] { str, paramc.getAppId() });
      AppMethodBeat.o(193479);
      return;
    }
    paramc.h(paramInt, e("fail:unknown operationType", null));
    AppMethodBeat.o(193479);
  }
  
  public final boolean biS()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b.d
 * JD-Core Version:    0.7.0.1
 */