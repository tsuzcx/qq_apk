package com.tencent.mm.plugin.appbrand.jsapi.s.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.plugin.appbrand.t.g;
import com.tencent.mm.plugin.appbrand.t.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends c
{
  public static final int CTRL_INDEX = 273;
  public static final String NAME = "operateUploadTask";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179549);
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
    AppMethodBeat.o(179549);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(327273);
    Log.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data is null"));
      Log.e("MicroMsg.JsApiOperateUploadTask", "data is null");
      AppMethodBeat.o(327273);
      return;
    }
    String str = paramJSONObject.optString("uploadTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
      paramf.callback(paramInt, ZP("fail:uploadTaskId is null or nil"));
      AppMethodBeat.o(327273);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
      paramf.callback(paramInt, ZP("fail:operationType is null or nil"));
      AppMethodBeat.o(327273);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = h.cCm().aec(paramf.getAppId());
      if (paramJSONObject == null)
      {
        Log.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
        paramf.callback(paramInt, ZP("fail:no task"));
        AppMethodBeat.o(327273);
        return;
      }
      a locala = paramJSONObject.aeb(str);
      if (locala == null)
      {
        Log.i("MicroMsg.JsApiOperateUploadTask", "uploadWorker is null %s", new Object[] { str });
        paramf.callback(paramInt, ZP("fail:no task"));
        AppMethodBeat.o(327273);
        return;
      }
      paramJSONObject.a(locala);
      paramf.callback(paramInt, ZP("ok"));
      paramJSONObject = new HashMap();
      paramJSONObject.put("uploadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().i(paramf).ZR(paramJSONObject).b(paramo);
      Log.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(327273);
      return;
    }
    paramf.callback(paramInt, ZP("fail:unknown operationType"));
    AppMethodBeat.o(327273);
  }
  
  public final boolean cpN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.c.d
 * JD-Core Version:    0.7.0.1
 */