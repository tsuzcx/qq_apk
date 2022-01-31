package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.h.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class f$1
  implements g.a
{
  private JSONObject gxo;
  
  f$1(f paramf, c paramc, String paramString1, String paramString2) {}
  
  public final void e(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      y.d("MicroMsg.JsApiCreateUploadTask", "success: file name %s, result %s , errMsg %d", new Object[] { this.val$filePath, paramString, Integer.valueOf(paramInt1) });
      localHashMap = new HashMap();
      localHashMap.put("data", paramString);
      localHashMap.put("statusCode", Integer.valueOf(paramInt2));
      localHashMap.put("uploadTaskId", this.gxy);
      localHashMap.put("state", "success");
      if (this.gxo != null) {
        localHashMap.put("header", this.gxo);
      }
      paramString = new JSONObject(localHashMap).toString();
      new f.a().e(this.ggH).tM(paramString).dispatch();
    }
    while (f.j(this.ggH, this.gxy))
    {
      HashMap localHashMap;
      return;
    }
    y.e("MicroMsg.JsApiCreateUploadTask", "error: file name %s, result %s , errMsg %d", new Object[] { this.val$filePath, paramString, Integer.valueOf(paramInt1) });
    f.f(this.ggH, this.gxy, paramString);
  }
  
  public final void f(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("uploadTaskId", this.gxy);
    ((Map)localObject).put("state", "progressUpdate");
    ((Map)localObject).put("progress", Integer.valueOf(paramInt));
    ((Map)localObject).put("totalBytesSent", Long.valueOf(paramLong1));
    ((Map)localObject).put("totalBytesExpectedToSend", Long.valueOf(paramLong2));
    localObject = new JSONObject((Map)localObject).toString();
    new f.a().e(this.ggH).tM((String)localObject).dispatch();
  }
  
  public final void uu(String paramString)
  {
    if (f.j(this.ggH, this.gxy)) {
      return;
    }
    f.f(this.ggH, this.gxy, paramString);
  }
  
  public final void y(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      if (!paramJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
        break;
      }
    } while (!((com.tencent.mm.plugin.appbrand.o.a)this.ggH.D(com.tencent.mm.plugin.appbrand.o.a.class)).fPx);
    paramJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
    m localm = new m();
    localm.bFp.bFq = "upload";
    localm.bFp.bFs = paramJSONObject;
    localm.bFp.bFr = this.gxy;
    com.tencent.mm.sdk.b.a.udP.m(localm);
    return;
    this.gxo = paramJSONObject;
    paramJSONObject = new HashMap();
    paramJSONObject.put("uploadTaskId", this.gxy);
    paramJSONObject.put("state", "headersReceived");
    paramJSONObject.put("header", this.gxo);
    paramJSONObject = new JSONObject(paramJSONObject).toString();
    new f.a().e(this.ggH).tM(paramJSONObject).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.f.1
 * JD-Core Version:    0.7.0.1
 */