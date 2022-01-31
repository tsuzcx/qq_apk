package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l
  extends a
{
  public static final int CTRL_INDEX = 273;
  public static final String NAME = "operateUploadTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(108078);
    ab.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null", null));
      ab.e("MicroMsg.JsApiOperateUploadTask", "data is null");
      AppMethodBeat.o(108078);
      return;
    }
    String str = paramJSONObject.optString("uploadTaskId");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
      paramc.h(paramInt, j("fail:uploadTaskId is null or nil", null));
      AppMethodBeat.o(108078);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bo.isNullOrNil(paramJSONObject))
    {
      ab.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
      paramc.h(paramInt, j("fail:operationType is null or nil", null));
      AppMethodBeat.o(108078);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = i.aIm().DU(paramc.getAppId());
      if (paramJSONObject == null)
      {
        ab.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
        paramc.h(paramInt, j("fail:no task", null));
        AppMethodBeat.o(108078);
        return;
      }
      h localh = paramJSONObject.DT(str);
      if (localh == null)
      {
        ab.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[] { str });
        paramc.h(paramInt, j("fail:no task", null));
        AppMethodBeat.o(108078);
        return;
      }
      paramJSONObject.a(localh);
      paramc.h(paramInt, j("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("uploadTaskId", String.valueOf(str));
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new g.a().j(paramc).BN(paramJSONObject).aBz();
      ab.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[] { str });
      AppMethodBeat.o(108078);
      return;
    }
    paramc.h(paramInt, j("fail:unknown operationType", null));
    AppMethodBeat.o(108078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.l
 * JD-Core Version:    0.7.0.1
 */