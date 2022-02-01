package com.tencent.mm.plugin.appbrand.jsapi.p.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 270;
  public static final String NAME = "operateDownloadTask";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179519);
    a(parame, paramJSONObject, paramInt, parame.getJsRuntime());
    AppMethodBeat.o(179519);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.m.o paramo)
  {
    AppMethodBeat.i(187074);
    Log.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
      AppMethodBeat.o(187074);
      return;
    }
    String str = paramJSONObject.optString("downloadTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
      parame.j(paramInt, h("fail:downloadTaskId is null or nil", null));
      AppMethodBeat.o(187074);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
      parame.j(paramInt, h("fail:operationType is null or nil", null));
      AppMethodBeat.o(187074);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.mm.plugin.appbrand.s.c.cbO().akP(parame.getAppId());
      if (paramJSONObject == null)
      {
        parame.j(paramInt, h("fail:no task", null));
        Log.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
        AppMethodBeat.o(187074);
        return;
      }
      com.tencent.mm.plugin.appbrand.s.a.b localb = paramJSONObject.akM(str);
      if (localb == null)
      {
        parame.j(paramInt, h("fail:no task", null));
        Log.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[] { str });
        AppMethodBeat.o(187074);
        return;
      }
      paramJSONObject.a(localb);
      parame.j(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("downloadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().j(parame).agU(paramJSONObject).b(paramo);
      Log.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(187074);
      return;
    }
    parame.j(paramInt, h("fail:unknown operationType", null));
    AppMethodBeat.o(187074);
  }
  
  public final boolean bPG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a.d
 * JD-Core Version:    0.7.0.1
 */