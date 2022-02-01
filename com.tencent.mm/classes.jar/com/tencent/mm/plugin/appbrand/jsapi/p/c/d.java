package com.tencent.mm.plugin.appbrand.jsapi.p.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.i;
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
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179549);
    a(parame, paramJSONObject, paramInt, parame.getJsRuntime());
    AppMethodBeat.o(179549);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.m.o paramo)
  {
    AppMethodBeat.i(186484);
    Log.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiOperateUploadTask", "data is null");
      AppMethodBeat.o(186484);
      return;
    }
    String str = paramJSONObject.optString("uploadTaskId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
      parame.j(paramInt, h("fail:uploadTaskId is null or nil", null));
      AppMethodBeat.o(186484);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
      parame.j(paramInt, h("fail:operationType is null or nil", null));
      AppMethodBeat.o(186484);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = i.cbT().akV(parame.getAppId());
      if (paramJSONObject == null)
      {
        Log.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
        parame.j(paramInt, h("fail:no task", null));
        AppMethodBeat.o(186484);
        return;
      }
      h localh = paramJSONObject.akU(str);
      if (localh == null)
      {
        Log.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[] { str });
        parame.j(paramInt, h("fail:no task", null));
        AppMethodBeat.o(186484);
        return;
      }
      paramJSONObject.a(localh);
      parame.j(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("uploadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().j(parame).agU(paramJSONObject).b(paramo);
      Log.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(186484);
      return;
    }
    parame.j(paramInt, h("fail:unknown operationType", null));
    AppMethodBeat.o(186484);
  }
  
  public final boolean bPG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.c.d
 * JD-Core Version:    0.7.0.1
 */