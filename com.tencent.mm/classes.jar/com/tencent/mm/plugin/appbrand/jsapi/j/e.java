package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.a;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTask";
  
  static void a(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108035);
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString1 = new JSONObject(localHashMap).toString();
    new e.a().j(paramc).BN(paramString1).aBz();
    AppMethodBeat.o(108035);
  }
  
  public final String Ox()
  {
    return "requestTaskId";
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(108034);
    ab.d("MicroMsg.JsApiCreateRequestTask", "JsApiCreateRequestTask");
    e.1 local1 = new e.1(this, System.currentTimeMillis(), paramc, paramString);
    String str1 = paramJSONObject.optString("url");
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.JsApiCreateRequestTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(108034);
      return;
    }
    a locala = (a)paramc.U(a.class);
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    ab.i("MicroMsg.JsApiCreateRequestTask", "lm:data configTimeout %d", new Object[] { Integer.valueOf(k) });
    int i = k;
    if (k <= 0)
    {
      i = j.a(locala, 0);
      ab.i("MicroMsg.JsApiCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", new Object[] { Integer.valueOf(i) });
    }
    if (i > 0) {
      j = i;
    }
    ab.i("MicroMsg.JsApiCreateRequestTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (locala.bDq <= 0) {
      ab.i("MicroMsg.JsApiCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = j.a(paramJSONObject, locala);
    if ((locala.isl) && (paramJSONObject.optBoolean("__skipDomainCheck__")))
    {
      i = 1;
      if (i == 0) {
        break label284;
      }
    }
    label284:
    for (boolean bool = false;; bool = locala.ism)
    {
      if ((!bool) || (j.c(locala.bDz, str1))) {
        break label294;
      }
      ab.i("MicroMsg.JsApiCreateRequestTask", "not in domain url %s", new Object[] { str1 });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(108034);
      return;
      i = 0;
      break;
    }
    label294:
    d locald2;
    if (f.aIk().DS(paramc.getAppId()) == null)
    {
      locald2 = new d(paramc);
      f localf = f.aIk();
      String str2 = paramc.getAppId();
      locald1 = locald2;
      if (!localf.hIm.containsKey(str2)) {
        localf.hIm.put(str2, locald2);
      }
    }
    for (d locald1 = locald2;; locald1 = f.aIk().DS(paramc.getAppId()))
    {
      ab.i("MicroMsg.JsApiCreateRequestTask", "request url: %s", new Object[] { str1 });
      if (locald1 == null) {
        break label466;
      }
      if (bool) {
        break;
      }
      ab.i("MicroMsg.JsApiCreateRequestTask", "debug type, do not verify domains");
      locald1.a(paramc, j, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
      AppMethodBeat.o(108034);
      return;
    }
    locald1.a(paramc, j, paramJSONObject, localMap, locala.bDz, local1, paramString, "createRequestTask");
    AppMethodBeat.o(108034);
    return;
    label466:
    a(paramc, paramString, "create request error");
    AppMethodBeat.o(108034);
  }
  
  public final String aAR()
  {
    AppMethodBeat.i(108033);
    Object localObject = new StringBuilder();
    f.aIk();
    localObject = f.aIg();
    AppMethodBeat.o(108033);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.e
 * JD-Core Version:    0.7.0.1
 */