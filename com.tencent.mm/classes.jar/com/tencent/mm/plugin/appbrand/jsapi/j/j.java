package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends a
{
  public static final int CTRL_INDEX = 243;
  public static final String NAME = "operateRequestTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(108075);
    ab.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null", null));
      ab.e("MicroMsg.JsApiOperateRequestTask", "data is null");
      AppMethodBeat.o(108075);
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      paramc.h(paramInt, j("fail:requestTaskId is null or nil", null));
      AppMethodBeat.o(108075);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bo.isNullOrNil(paramJSONObject))
    {
      ab.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      paramc.h(paramInt, j("fail:operationType is null or nil", null));
      AppMethodBeat.o(108075);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = f.aIk().DS(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, j("fail:no task", null));
        ab.w("MicroMsg.JsApiOperateRequestTask", "request is null");
        AppMethodBeat.o(108075);
        return;
      }
      e locale = paramJSONObject.DR(str);
      if (locale == null)
      {
        paramc.h(paramInt, j("fail:no task", null));
        ab.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null %s", new Object[] { str });
        AppMethodBeat.o(108075);
        return;
      }
      paramJSONObject.b(locale);
      paramc.h(paramInt, j("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new e.a().j(paramc).BN(paramJSONObject).aBz();
      ab.d("MicroMsg.JsApiOperateRequestTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(108075);
      return;
    }
    paramc.h(paramInt, j("fail:unknown operationType", null));
    AppMethodBeat.o(108075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.j
 * JD-Core Version:    0.7.0.1
 */