package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.g;
import com.tencent.mm.plugin.appbrand.o.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends a
{
  public static final int CTRL_INDEX = 273;
  public static final String NAME = "operateUploadTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.JsApiOperateUploadTask", "data is null");
      return;
    }
    String str = paramJSONObject.optString("uploadTaskId");
    if (bk.bl(str))
    {
      y.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
      paramc.C(paramInt, h("fail:uploadTaskId is null or nil", null));
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bk.bl(paramJSONObject))
    {
      y.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
      paramc.C(paramInt, h("fail:operationType is null or nil", null));
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.mm.plugin.appbrand.o.i.amI().vx(paramc.getAppId());
      if (paramJSONObject == null)
      {
        y.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
        paramc.C(paramInt, h("fail:no task", null));
        return;
      }
      h localh = paramJSONObject.vw(str);
      if (localh == null)
      {
        y.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[] { str });
        paramc.C(paramInt, h("fail:no task", null));
        return;
      }
      paramJSONObject.a(localh);
      paramc.C(paramInt, h("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("uploadTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new f.a().e(paramc).tM(paramJSONObject).dispatch();
      y.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[] { str });
      return;
    }
    paramc.C(paramInt, h("fail:unknown operationType", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.k
 * JD-Core Version:    0.7.0.1
 */