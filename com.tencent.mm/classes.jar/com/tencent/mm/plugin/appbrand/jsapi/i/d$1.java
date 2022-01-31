package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.luggage.b.e;
import com.tencent.mm.h.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.plugin.appbrand.v.n.a;
import com.tencent.mm.plugin.appbrand.v.n.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class d$1
  implements com.tencent.mm.plugin.appbrand.o.d.a
{
  d$1(d paramd, long paramLong, c paramc, String paramString) {}
  
  public final void a(String paramString, Object paramObject, int paramInt, JSONObject paramJSONObject)
  {
    int i;
    if ((paramObject != null) && ((paramObject instanceof ByteBuffer))) {
      i = ((ByteBuffer)paramObject).array().length;
    }
    for (;;)
    {
      y.d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d, code %s,reqrestId %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.gxs), Integer.valueOf(i), Integer.valueOf(paramInt), this.gxt });
      HashMap localHashMap = new HashMap();
      localHashMap.put("requestTaskId", this.gxt);
      if (paramString.equalsIgnoreCase("ok"))
      {
        localHashMap.put("state", "success");
        localHashMap.put("data", paramObject);
        label123:
        localHashMap.put("statusCode", Integer.valueOf(paramInt));
        if (paramJSONObject != null) {
          localHashMap.put("header", paramJSONObject);
        }
        paramString = new d.a();
        paramJSONObject = com.tencent.mm.plugin.appbrand.v.n.a(this.ggH.ahK(), localHashMap, (n.a)this.ggH.D(n.a.class));
        if (((paramObject == null) || (!(paramObject instanceof String))) && (paramJSONObject != n.b.hlF)) {
          break label278;
        }
        paramObject = new JSONObject(localHashMap).toString();
        paramString.e(this.ggH).tM(paramObject).dispatch();
      }
      label278:
      while (paramJSONObject != n.b.hlG)
      {
        return;
        if ((paramObject == null) || (!(paramObject instanceof String))) {
          break label296;
        }
        i = ((String)paramObject).length();
        break;
        localHashMap.put("state", "fail");
        break label123;
      }
      com.tencent.mm.plugin.appbrand.v.n.m(this.ggH, "onRequestTaskStateChange");
      return;
      label296:
      i = 0;
    }
  }
  
  public final void ut(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.gxs;
    if (paramString == null) {}
    for (int i = 0;; i = paramString.length())
    {
      y.d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.o.d locald = f.amG().vv(this.ggH.getAppId());
      if ((locald == null) || (!locald.vq(this.gxt))) {
        break;
      }
      y.d("MicroMsg.JsApiCreateRequestTask", "request abort %s", new Object[] { this.gxt });
      return;
    }
    d.d(this.ggH, this.gxt, paramString);
    ((com.tencent.mm.plugin.appbrand.o.n)e.j(com.tencent.mm.plugin.appbrand.o.n.class)).sV(this.ggH.getAppId());
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
    Object localObject = new m();
    ((m)localObject).bFp.bFq = "request";
    ((m)localObject).bFp.bFs = paramJSONObject;
    ((m)localObject).bFp.bFr = this.gxt;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    return;
    localObject = new HashMap();
    ((Map)localObject).put("requestTaskId", this.gxt);
    ((Map)localObject).put("state", "headersReceived");
    ((Map)localObject).put("header", paramJSONObject);
    paramJSONObject = new d.a();
    localObject = new JSONObject((Map)localObject).toString();
    paramJSONObject.e(this.ggH).tM((String)localObject).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.d.1
 * JD-Core Version:    0.7.0.1
 */