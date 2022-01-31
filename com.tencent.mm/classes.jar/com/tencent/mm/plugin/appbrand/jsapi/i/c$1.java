package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.h.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.file.ae;
import com.tencent.mm.plugin.appbrand.o.b;
import com.tencent.mm.plugin.appbrand.o.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class c$1
  implements b.a
{
  private JSONObject gxo;
  
  c$1(c paramc, String paramString1, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, String paramString2) {}
  
  public final void c(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    y.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2) });
    if (!bk.bl(this.gxp))
    {
      paramString1 = ae.a(this.ggH, new File(paramString2), this.gxp, null);
      if ((b.FAILED == paramInt1) || (!"ok".equals(paramString1))) {
        if (!c.i(this.ggH, this.gxq)) {}
      }
    }
    do
    {
      return;
      c.b(this.ggH, this.gxq, paramString1);
      return;
      y.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.gxp });
      paramString1 = new HashMap();
      paramString1.put("downloadTaskId", this.gxq);
      paramString1.put("filePath", this.gxp);
      paramString1.put("statusCode", Integer.valueOf(paramInt2));
      paramString1.put("state", "success");
      if (this.gxo != null) {
        paramString1.put("header", this.gxo);
      }
      paramString1 = new JSONObject(paramString1).toString();
      new c.a().e(this.ggH).tM(paramString1).dispatch();
      return;
      if (paramInt1 != b.FAILED)
      {
        paramString1 = c.c(this.ggH, paramString2, paramString1);
        if (paramString1 != null) {
          break;
        }
      }
    } while (c.i(this.ggH, this.gxq));
    c.b(this.ggH, this.gxq, "download fail");
    return;
    y.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[] { paramString1 });
    paramString2 = new HashMap();
    paramString2.put("downloadTaskId", this.gxq);
    paramString2.put("tempFilePath", paramString1);
    paramString2.put("statusCode", Integer.valueOf(paramInt2));
    paramString2.put("state", "success");
    if (this.gxo != null) {
      paramString2.put("header", this.gxo);
    }
    paramString1 = new JSONObject(paramString2).toString();
    new c.a().e(this.ggH).tM(paramString1).dispatch();
  }
  
  public final void e(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("downloadTaskId", this.gxq);
    ((Map)localObject).put("state", "progressUpdate");
    ((Map)localObject).put("progress", Integer.valueOf(paramInt));
    ((Map)localObject).put("totalBytesWritten", Long.valueOf(paramLong1));
    ((Map)localObject).put("totalBytesExpectedToWrite", Long.valueOf(paramLong2));
    localObject = new JSONObject((Map)localObject).toString();
    new c.a().e(this.ggH).tM((String)localObject).dispatch();
  }
  
  public final void us(String paramString)
  {
    if (c.i(this.ggH, this.gxq)) {
      return;
    }
    c.b(this.ggH, this.gxq, paramString);
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
    localm.bFp.bFq = "download";
    localm.bFp.bFs = paramJSONObject;
    localm.bFp.bFr = this.gxq;
    com.tencent.mm.sdk.b.a.udP.m(localm);
    return;
    this.gxo = paramJSONObject;
    paramJSONObject = new HashMap();
    paramJSONObject.put("downloadTaskId", this.gxq);
    paramJSONObject.put("state", "headersReceived");
    paramJSONObject.put("header", this.gxo);
    paramJSONObject = new JSONObject(paramJSONObject).toString();
    new c.a().e(this.ggH).tM(paramJSONObject).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.c.1
 * JD-Core Version:    0.7.0.1
 */