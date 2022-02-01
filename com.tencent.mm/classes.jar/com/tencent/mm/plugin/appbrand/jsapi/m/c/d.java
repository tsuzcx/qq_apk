package com.tencent.mm.plugin.appbrand.jsapi.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.o.g;
import com.tencent.mm.plugin.appbrand.o.h;
import com.tencent.mm.plugin.appbrand.o.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 273;
  public static final String NAME = "operateUploadTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179549);
    a(paramc, paramJSONObject, paramInt, paramc.aYh());
    AppMethodBeat.o(179549);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(187751);
    ad.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiOperateUploadTask", "data is null");
      AppMethodBeat.o(187751);
      return;
    }
    String str = paramJSONObject.optString("uploadTaskId");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
      paramc.h(paramInt, e("fail:uploadTaskId is null or nil", null));
      AppMethodBeat.o(187751);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bt.isNullOrNil(paramJSONObject))
    {
      ad.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
      paramc.h(paramInt, e("fail:operationType is null or nil", null));
      AppMethodBeat.o(187751);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = i.btk().SO(paramc.getAppId());
      if (paramJSONObject == null)
      {
        ad.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
        paramc.h(paramInt, e("fail:no task", null));
        AppMethodBeat.o(187751);
        return;
      }
      h localh = paramJSONObject.SN(str);
      if (localh == null)
      {
        ad.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[] { str });
        paramc.h(paramInt, e("fail:no task", null));
        AppMethodBeat.o(187751);
        return;
      }
      paramJSONObject.a(localh);
      paramc.h(paramInt, e("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("uploadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().h(paramc).Pi(paramJSONObject).a(paramo);
      ad.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(187751);
      return;
    }
    paramc.h(paramInt, e("fail:unknown operationType", null));
    AppMethodBeat.o(187751);
  }
  
  public final boolean bij()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.c.d
 * JD-Core Version:    0.7.0.1
 */