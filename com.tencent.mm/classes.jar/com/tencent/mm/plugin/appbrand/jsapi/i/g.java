package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = 270;
  public static final String NAME = "operateDownloadTask";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
      return;
    }
    String str = paramJSONObject.optString("downloadTaskId");
    if (bk.bl(str))
    {
      y.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
      paramc.C(paramInt, h("fail:downloadTaskId is null or nil", null));
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bk.bl(paramJSONObject))
    {
      y.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
      paramc.C(paramInt, h("fail:operationType is null or nil", null));
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.mm.plugin.appbrand.o.c.amD().vs(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.C(paramInt, h("fail:no task", null));
        y.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
        return;
      }
      com.tencent.mm.plugin.appbrand.o.a.b localb = paramJSONObject.vp(str);
      if (localb == null)
      {
        paramc.C(paramInt, h("fail:no task", null));
        y.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[] { str });
        return;
      }
      paramJSONObject.a(localb);
      paramc.C(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("downloadTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new c.a().e(paramc).tM(paramJSONObject).dispatch();
      y.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[] { str });
      return;
    }
    paramc.C(paramInt, h("fail:unknown operationType", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.g
 * JD-Core Version:    0.7.0.1
 */