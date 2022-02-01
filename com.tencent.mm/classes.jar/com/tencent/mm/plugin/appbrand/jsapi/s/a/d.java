package com.tencent.mm.plugin.appbrand.jsapi.s.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n.o;
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
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179519);
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
    AppMethodBeat.o(179519);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(327289);
    Log.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data is null"));
      Log.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
      AppMethodBeat.o(327289);
      return;
    }
    String str = paramJSONObject.optString("downloadTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
      paramf.callback(paramInt, ZP("fail:downloadTaskId is null or nil"));
      AppMethodBeat.o(327289);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
      paramf.callback(paramInt, ZP("fail:operationType is null or nil"));
      AppMethodBeat.o(327289);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.mm.plugin.appbrand.t.c.cCh().adW(paramf.getAppId());
      if (paramJSONObject == null)
      {
        paramf.callback(paramInt, ZP("fail:no task"));
        Log.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
        AppMethodBeat.o(327289);
        return;
      }
      com.tencent.mm.plugin.appbrand.t.a.b localb = paramJSONObject.adT(str);
      if (localb == null)
      {
        paramf.callback(paramInt, ZP("fail:no task"));
        Log.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[] { str });
        AppMethodBeat.o(327289);
        return;
      }
      paramJSONObject.a(localb);
      paramf.callback(paramInt, ZP("ok"));
      paramJSONObject = new HashMap();
      paramJSONObject.put("downloadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().i(paramf).ZR(paramJSONObject).b(paramo);
      Log.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(327289);
      return;
    }
    paramf.callback(paramInt, ZP("fail:unknown operationType"));
    AppMethodBeat.o(327289);
  }
  
  public final boolean cpN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.a.d
 * JD-Core Version:    0.7.0.1
 */