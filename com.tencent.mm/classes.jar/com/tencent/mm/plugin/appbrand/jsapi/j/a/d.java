package com.tencent.mm.plugin.appbrand.jsapi.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 270;
  public static final String NAME = "operateDownloadTask";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179519);
    ad.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
      AppMethodBeat.o(179519);
      return;
    }
    String str = paramJSONObject.optString("downloadTaskId");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
      paramc.h(paramInt, e("fail:downloadTaskId is null or nil", null));
      AppMethodBeat.o(179519);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bt.isNullOrNil(paramJSONObject))
    {
      ad.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
      paramc.h(paramInt, e("fail:operationType is null or nil", null));
      AppMethodBeat.o(179519);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.mm.plugin.appbrand.q.c.bim().KY(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, e("fail:no task", null));
        ad.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
        AppMethodBeat.o(179519);
        return;
      }
      com.tencent.mm.plugin.appbrand.q.a.b localb = paramJSONObject.KV(str);
      if (localb == null)
      {
        paramc.h(paramInt, e("fail:no task", null));
        ad.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[] { str });
        AppMethodBeat.o(179519);
        return;
      }
      paramJSONObject.a(localb);
      paramc.h(paramInt, e("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("downloadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().h(paramc).HK(paramJSONObject).aXQ();
      ad.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(179519);
      return;
    }
    paramc.h(paramInt, e("fail:unknown operationType", null));
    AppMethodBeat.o(179519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a.d
 * JD-Core Version:    0.7.0.1
 */