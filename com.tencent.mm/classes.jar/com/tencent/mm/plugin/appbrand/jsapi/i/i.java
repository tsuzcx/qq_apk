package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.d;
import com.tencent.mm.plugin.appbrand.o.e;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends a
{
  public static final int CTRL_INDEX = 243;
  public static final String NAME = "operateRequestTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.JsApiOperateRequestTask", "data is null");
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (bk.bl(str))
    {
      y.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      paramc.C(paramInt, h("fail:requestTaskId is null or nil", null));
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bk.bl(paramJSONObject))
    {
      y.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      paramc.C(paramInt, h("fail:operationType is null or nil", null));
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = f.amG().vv(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.C(paramInt, h("fail:no task", null));
        y.w("MicroMsg.JsApiOperateRequestTask", "request is null");
        return;
      }
      e locale = paramJSONObject.vu(str);
      if (locale == null)
      {
        paramc.C(paramInt, h("fail:no task", null));
        y.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null %s", new Object[] { str });
        return;
      }
      paramJSONObject.b(locale);
      paramc.C(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new d.a().e(paramc).tM(paramJSONObject).dispatch();
      y.d("MicroMsg.JsApiOperateRequestTask", "abortTask finish %s", new Object[] { str });
      return;
    }
    paramc.C(paramInt, h("fail:unknown operationType", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.i
 * JD-Core Version:    0.7.0.1
 */