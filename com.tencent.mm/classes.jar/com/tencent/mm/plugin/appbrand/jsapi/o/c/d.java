package com.tencent.mm.plugin.appbrand.jsapi.o.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
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
    AppMethodBeat.i(207099);
    Log.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiOperateUploadTask", "data is null");
      AppMethodBeat.o(207099);
      return;
    }
    String str = paramJSONObject.optString("uploadTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
      paramf.i(paramInt, h("fail:uploadTaskId is null or nil", null));
      AppMethodBeat.o(207099);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
      paramf.i(paramInt, h("fail:operationType is null or nil", null));
      AppMethodBeat.o(207099);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = i.bPC().adb(paramf.getAppId());
      if (paramJSONObject == null)
      {
        Log.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
        paramf.i(paramInt, h("fail:no task", null));
        AppMethodBeat.o(207099);
        return;
      }
      h localh = paramJSONObject.ada(str);
      if (localh == null)
      {
        Log.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[] { str });
        paramf.i(paramInt, h("fail:no task", null));
        AppMethodBeat.o(207099);
        return;
      }
      paramJSONObject.a(localh);
      paramf.i(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("uploadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().h(paramf).Zh(paramJSONObject).a(paramo);
      Log.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(207099);
      return;
    }
    paramf.i(paramInt, h("fail:unknown operationType", null));
    AppMethodBeat.o(207099);
  }
  
  public final boolean bEi()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c.d
 * JD-Core Version:    0.7.0.1
 */