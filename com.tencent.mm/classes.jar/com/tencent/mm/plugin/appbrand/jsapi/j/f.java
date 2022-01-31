package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.m.k.a;
import com.tencent.mm.plugin.appbrand.m.k.c;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends b
{
  public static final int CTRL_INDEX = 346;
  public static final String NAME = "createSocketTask";
  private static k.a hTR;
  public static int hTT = 0;
  public static int hTU = 1;
  private k.c hTS;
  private int hTV;
  private boolean hTW;
  private boolean hTX;
  
  public f(int paramInt, k.c paramc)
  {
    AppMethodBeat.i(108043);
    this.hTV = hTT;
    this.hTW = false;
    this.hTX = false;
    ab.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.hTV = paramInt;
    this.hTS = paramc;
    AppMethodBeat.o(108043);
  }
  
  private static JSONObject a(com.tencent.mm.plugin.appbrand.u.e.f paramf)
  {
    AppMethodBeat.i(108048);
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.aOs();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.Fy(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      ab.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
      AppMethodBeat.o(108048);
    }
  }
  
  public static void a(c paramc, String paramString1, com.tencent.mm.plugin.appbrand.b.b paramb, String paramString2)
  {
    AppMethodBeat.i(108045);
    if ((paramb == com.tencent.mm.plugin.appbrand.b.b.gYg) || (paramb == com.tencent.mm.plugin.appbrand.b.b.gYh))
    {
      paramString1 = l.aIp().DZ(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(108045);
        return;
      }
      paramString1.a(paramString1.CX(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new f.a().j(paramc).BN(paramString1).aBz();
    }
    AppMethodBeat.o(108045);
  }
  
  private static void a(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108049);
    if (bo.isNullOrNil(paramString2)) {}
    for (paramString2 = "fail";; paramString2 = "fail:".concat(String.valueOf(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("socketTaskId", paramString1);
      localHashMap.put("state", "error");
      localHashMap.put("errMsg", paramString2);
      paramString1 = new JSONObject(localHashMap).toString();
      new f.a().j(paramc).BN(paramString1).aBz();
      ab.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString1 });
      ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 3L, 1L, false);
      AppMethodBeat.o(108049);
      return;
    }
  }
  
  public static void a(k.a parama)
  {
    hTR = parama;
  }
  
  public final String Ox()
  {
    return "socketTaskId";
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(108046);
    Object localObject1 = l.aIp().DZ(paramc.getAppId());
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (((this.hTV != hTT) || (!this.hTW)) && ((this.hTV != hTU) || (!this.hTX))) {
        break label180;
      }
    }
    Object localObject3;
    label180:
    for (localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.m.a)paramc.U(com.tencent.mm.plugin.appbrand.m.a.class));; localObject1 = new k((com.tencent.mm.plugin.appbrand.m.a)paramc.U(com.tencent.mm.plugin.appbrand.m.a.class)))
    {
      localObject3 = l.aIp();
      localObject4 = paramc.getAppId();
      localObject2 = localObject1;
      if (!((l)localObject3).hIm.containsKey(localObject4))
      {
        ((l)localObject3).hIm.put(localObject4, localObject1);
        localObject2 = localObject1;
      }
      localObject1 = new f.1(this, paramc, paramString);
      localObject3 = paramJSONObject.optString("url");
      if (!bo.isNullOrNil((String)localObject3)) {
        break;
      }
      ab.i("MicroMsg.JsApiCreateSocketTask", "url is null");
      a(paramc, paramString, "url is null");
      AppMethodBeat.o(108046);
      return;
    }
    ab.i("MicroMsg.JsApiCreateSocketTask", "url is ".concat(String.valueOf(localObject3)));
    Object localObject4 = (com.tencent.mm.plugin.appbrand.m.a)paramc.U(com.tencent.mm.plugin.appbrand.m.a.class);
    Map localMap = j.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.m.a)localObject4);
    if ((((com.tencent.mm.plugin.appbrand.m.a)localObject4).isl) && (paramJSONObject.optBoolean("__skipDomainCheck__")))
    {
      i = 1;
      if (i == 0) {
        break label329;
      }
    }
    label329:
    for (boolean bool = false;; bool = ((com.tencent.mm.plugin.appbrand.m.a)localObject4).ism)
    {
      if ((!bool) || (j.a(((com.tencent.mm.plugin.appbrand.m.a)localObject4).bDA, (String)localObject3, ((com.tencent.mm.plugin.appbrand.m.a)localObject4).bDv))) {
        break label339;
      }
      ab.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { localObject3 });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(108046);
      return;
      i = 0;
      break;
    }
    label339:
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a((com.tencent.mm.plugin.appbrand.m.a)localObject4, 1);
    }
    if (i > 0) {}
    for (;;)
    {
      localObject2.a(paramc.getAppId(), paramString, this.hTV, i, paramJSONObject, localMap, (d.a)localObject1);
      if ((this.hTW) || (this.hTX)) {
        ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 10L, 1L, false);
      }
      for (;;)
      {
        ab.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { localObject3, Integer.valueOf(paramc.aAN()) });
        AppMethodBeat.o(108046);
        return;
        ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 0L, 1L, false);
      }
      i = 60000;
    }
  }
  
  public final String aAR()
  {
    AppMethodBeat.i(108044);
    Object localObject = new StringBuilder();
    l.aIp();
    localObject = l.aIg();
    AppMethodBeat.o(108044);
    return localObject;
  }
  
  public final void g(c paramc)
  {
    AppMethodBeat.i(108047);
    if (this.hTS != null)
    {
      this.hTW = this.hTS.yi(paramc.getAppId());
      this.hTX = this.hTS.auq();
    }
    AppMethodBeat.o(108047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.f
 * JD-Core Version:    0.7.0.1
 */