package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends b
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTask";
  
  private static void a(c paramc, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString1 = new JSONObject(localHashMap).toString();
    new d.a().e(paramc).tM(paramString1).dispatch();
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    y.d("MicroMsg.JsApiCreateRequestTask", "JsApiCreateRequestTask");
    d.1 local1 = new d.1(this, System.currentTimeMillis(), paramc, paramString);
    String str1 = paramJSONObject.optString("url");
    if (bk.bl(str1))
    {
      y.e("MicroMsg.JsApiCreateRequestTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      return;
    }
    a locala = (a)paramc.D(a.class);
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a(locala, 0);
    }
    if (i > 0) {}
    for (;;)
    {
      if (locala.fPZ <= 0) {
        y.i("MicroMsg.JsApiCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
      }
      Map localMap = j.a(paramJSONObject, locala);
      if ((locala.gQw) && (paramJSONObject.optBoolean("__skipDomainCheck__")))
      {
        j = 1;
        if (j == 0) {
          break label196;
        }
      }
      label196:
      for (boolean bool = false;; bool = locala.gQx)
      {
        if ((!bool) || (j.c(locala.fQj, str1))) {
          break label206;
        }
        y.i("MicroMsg.JsApiCreateRequestTask", "not in domain url %s", new Object[] { str1 });
        a(paramc, paramString, "url not in domain list");
        return;
        j = 0;
        break;
      }
      label206:
      com.tencent.mm.plugin.appbrand.o.d locald2;
      if (f.amG().vv(paramc.getAppId()) == null)
      {
        locald2 = new com.tencent.mm.plugin.appbrand.o.d(paramc);
        f localf = f.amG();
        String str2 = paramc.getAppId();
        locald1 = locald2;
        if (!localf.goq.containsKey(str2)) {
          localf.goq.put(str2, locald2);
        }
      }
      for (com.tencent.mm.plugin.appbrand.o.d locald1 = locald2;; locald1 = f.amG().vv(paramc.getAppId()))
      {
        y.i("MicroMsg.JsApiCreateRequestTask", "request url: %s", new Object[] { str1 });
        if (locald1 == null) {
          break label368;
        }
        if (bool) {
          break;
        }
        y.i("MicroMsg.JsApiCreateRequestTask", "debug type, do not verify domains");
        locald1.a(paramc, i, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
        return;
      }
      locald1.a(paramc, i, paramJSONObject, localMap, locala.fQj, local1, paramString, "createRequestTask");
      return;
      label368:
      a(paramc, paramString, "create request error");
      return;
      i = 60000;
    }
  }
  
  protected final String ajy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    f.amG();
    return f.amC();
  }
  
  protected final String ajz()
  {
    return "requestTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.d
 * JD-Core Version:    0.7.0.1
 */