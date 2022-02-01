package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
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
    AppMethodBeat.i(207095);
    Log.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
      AppMethodBeat.o(207095);
      return;
    }
    String str = paramJSONObject.optString("downloadTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
      paramf.i(paramInt, h("fail:downloadTaskId is null or nil", null));
      AppMethodBeat.o(207095);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
      paramf.i(paramInt, h("fail:operationType is null or nil", null));
      AppMethodBeat.o(207095);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = c.bPx().acV(paramf.getAppId());
      if (paramJSONObject == null)
      {
        paramf.i(paramInt, h("fail:no task", null));
        Log.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
        AppMethodBeat.o(207095);
        return;
      }
      com.tencent.mm.plugin.appbrand.s.a.b localb = paramJSONObject.acS(str);
      if (localb == null)
      {
        paramf.i(paramInt, h("fail:no task", null));
        Log.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[] { str });
        AppMethodBeat.o(207095);
        return;
      }
      paramJSONObject.a(localb);
      paramf.i(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("downloadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().h(paramf).Zh(paramJSONObject).a(paramo);
      Log.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(207095);
      return;
    }
    paramf.i(paramInt, h("fail:unknown operationType", null));
    AppMethodBeat.o(207095);
  }
  
  public final boolean bEi()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.d
 * JD-Core Version:    0.7.0.1
 */