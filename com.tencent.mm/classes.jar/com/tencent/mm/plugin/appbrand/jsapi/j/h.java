package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends a
{
  public static final int CTRL_INDEX = 270;
  public static final String NAME = "operateDownloadTask";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(108060);
    ab.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null", null));
      ab.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
      AppMethodBeat.o(108060);
      return;
    }
    String str = paramJSONObject.optString("downloadTaskId");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
      paramc.h(paramInt, j("fail:downloadTaskId is null or nil", null));
      AppMethodBeat.o(108060);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bo.isNullOrNil(paramJSONObject))
    {
      ab.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
      paramc.h(paramInt, j("fail:operationType is null or nil", null));
      AppMethodBeat.o(108060);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.mm.plugin.appbrand.m.c.aIh().DP(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, j("fail:no task", null));
        ab.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
        AppMethodBeat.o(108060);
        return;
      }
      com.tencent.mm.plugin.appbrand.m.a.b localb = paramJSONObject.DM(str);
      if (localb == null)
      {
        paramc.h(paramInt, j("fail:no task", null));
        ab.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[] { str });
        AppMethodBeat.o(108060);
        return;
      }
      paramJSONObject.a(localb);
      paramc.h(paramInt, j("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("downloadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new d.a().j(paramc).BN(paramJSONObject).aBz();
      ab.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(108060);
      return;
    }
    paramc.h(paramInt, j("fail:unknown operationType", null));
    AppMethodBeat.o(108060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.h
 * JD-Core Version:    0.7.0.1
 */