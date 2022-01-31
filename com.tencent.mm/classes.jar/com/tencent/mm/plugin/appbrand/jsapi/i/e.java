package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.h.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.o.k;
import com.tencent.mm.plugin.appbrand.o.k.a;
import com.tencent.mm.plugin.appbrand.o.k.b;
import com.tencent.mm.plugin.appbrand.o.l;
import com.tencent.mm.plugin.appbrand.v.n;
import com.tencent.mm.plugin.appbrand.v.n.a;
import com.tencent.mm.plugin.appbrand.v.n.b;
import com.tencent.mm.plugin.appbrand.v.o;
import com.tencent.mm.plugin.appbrand.w.e.f;
import com.tencent.mm.plugin.appbrand.w.e.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends b
{
  public static final int CTRL_INDEX = 346;
  public static final String NAME = "createSocketTask";
  private static k.a gxv;
  
  private static JSONObject a(f paramf)
  {
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.aqQ();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.wS(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      y.w("MicroMsg.JsApiCreateSocketTask", "JSONException " + paramf);
    }
  }
  
  public static void a(c paramc, String paramString1, com.tencent.mm.plugin.appbrand.b.b paramb, String paramString2)
  {
    if ((paramb == com.tencent.mm.plugin.appbrand.b.b.fFK) || (paramb == com.tencent.mm.plugin.appbrand.b.b.fFL))
    {
      paramString1 = l.amK().vC(paramString1);
      if (paramString1 != null) {}
    }
    else
    {
      return;
    }
    paramString1.c(paramString1.vB(paramString2));
    paramString1 = new HashMap();
    paramString1.put("reason", "interrupted");
    paramString1.put("socketTaskId", paramString2);
    paramString1.put("state", "close");
    paramString1 = new JSONObject(paramString1).toString();
    new e.a().e(paramc).tM(paramString1).dispatch();
  }
  
  private static void a(c paramc, String paramString1, String paramString2)
  {
    if (bk.bl(paramString2)) {}
    for (paramString2 = "fail";; paramString2 = "fail:" + paramString2)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("socketTaskId", paramString1);
      localHashMap.put("state", "error");
      localHashMap.put("errMsg", paramString2);
      paramString1 = new JSONObject(localHashMap).toString();
      new e.a().e(paramc).tM(paramString1).dispatch();
      y.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString1 });
      return;
    }
  }
  
  public static void a(k.a parama)
  {
    gxv = parama;
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final String paramString)
  {
    Object localObject2 = l.amK().vC(paramc.getAppId());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new k((com.tencent.mm.plugin.appbrand.o.a)paramc.D(com.tencent.mm.plugin.appbrand.o.a.class));
      localObject2 = l.amK();
      str = paramc.getAppId();
      if (!((l)localObject2).goq.containsKey(str)) {
        ((l)localObject2).goq.put(str, localObject1);
      }
    }
    localObject2 = new k.b()
    {
      boolean gxw = false;
      
      public final void A(int paramAnonymousInt, String paramAnonymousString)
      {
        if (e.ajA() != null) {
          e.ajA().e(paramc, paramString);
        }
        HashMap localHashMap = new HashMap();
        if (j.b(paramc.Zk())) {
          localHashMap.put("reason", "interrupted");
        }
        for (;;)
        {
          localHashMap.put("code", Integer.valueOf(paramAnonymousInt));
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "close");
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().e(paramc).tM(paramAnonymousString).dispatch();
          return;
          if (!bk.bl(paramAnonymousString)) {
            localHashMap.put("reason", paramAnonymousString);
          }
        }
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.w.e.a paramAnonymousa)
      {
        if ((paramAnonymousa == null) || (!((com.tencent.mm.plugin.appbrand.o.a)paramc.D(com.tencent.mm.plugin.appbrand.o.a.class)).fPx)) {
          return;
        }
        m localm = new m();
        localm.bFp.bFq = "socket";
        localm.bFp.bFs = e.b(paramAnonymousa);
        localm.bFp.bFr = paramString;
        com.tencent.mm.sdk.b.a.udP.m(localm);
      }
      
      public final void a(h paramAnonymoush)
      {
        if (e.ajA() != null) {
          e.ajA().d(paramc, paramString);
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("socketTaskId", paramString);
        localHashMap.put("state", "open");
        localHashMap.put("header", e.b(paramAnonymoush));
        paramAnonymoush = new JSONObject(localHashMap).toString();
        new e.a().e(paramc).tM(paramAnonymoush).dispatch();
      }
      
      public final void g(ByteBuffer paramAnonymousByteBuffer)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("socketTaskId", paramString);
        localHashMap.put("data", paramAnonymousByteBuffer);
        localHashMap.put("isBuffer", Boolean.valueOf(true));
        localHashMap.put("state", "message");
        paramAnonymousByteBuffer = (n.a)paramc.D(n.a.class);
        paramAnonymousByteBuffer = n.a(paramc.ahK(), localHashMap, paramAnonymousByteBuffer);
        if (paramAnonymousByteBuffer == n.b.hlF)
        {
          paramAnonymousByteBuffer = new JSONObject(localHashMap).toString();
          new e.a().e(paramc).tM(paramAnonymousByteBuffer).dispatch();
        }
        while (paramAnonymousByteBuffer != n.b.hlG) {
          return;
        }
        n.m(paramc, "onSocketTaskStateChange");
      }
      
      public final void sL(String paramAnonymousString)
      {
        if (this.gxw)
        {
          y.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
          return;
        }
        this.gxw = true;
        HashMap localHashMap = new HashMap();
        localHashMap.put("socketTaskId", paramString);
        localHashMap.put("state", "error");
        localHashMap.put("errMsg", paramAnonymousString);
        paramAnonymousString = new JSONObject(localHashMap).toString();
        new e.a().e(paramc).tM(paramAnonymousString).dispatch();
      }
      
      public final void sM(String paramAnonymousString)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("data", o.wH(paramAnonymousString));
        localHashMap.put("isBuffer", Boolean.valueOf(false));
        localHashMap.put("socketTaskId", paramString);
        localHashMap.put("state", "message");
        paramAnonymousString = new JSONObject(localHashMap).toString();
        new e.a().e(paramc).tM(paramAnonymousString).dispatch();
      }
      
      public final void sN(String paramAnonymousString)
      {
        e.e(paramc, paramString, paramAnonymousString);
      }
    };
    String str = paramJSONObject.optString("url");
    if (bk.bl(str))
    {
      y.i("MicroMsg.JsApiCreateSocketTask", "url is null");
      a(paramc, paramString, "url is null");
      return;
    }
    y.i("MicroMsg.JsApiCreateSocketTask", "url is " + str);
    com.tencent.mm.plugin.appbrand.o.a locala = (com.tencent.mm.plugin.appbrand.o.a)paramc.D(com.tencent.mm.plugin.appbrand.o.a.class);
    Map localMap = j.a(paramJSONObject, locala);
    if ((locala.gQw) && (paramJSONObject.optBoolean("__skipDomainCheck__")))
    {
      i = 1;
      if (i == 0) {
        break label249;
      }
    }
    label249:
    for (boolean bool = false;; bool = locala.gQx)
    {
      if ((!bool) || (j.a(locala.fQk, str, locala.fQe))) {
        break label259;
      }
      y.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { str });
      a(paramc, paramString, "url not in domain list");
      return;
      i = 0;
      break;
    }
    label259:
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a(locala, 1);
    }
    if (i > 0) {}
    for (;;)
    {
      ((k)localObject1).a(paramString, i, paramJSONObject, localMap, (k.b)localObject2);
      y.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { str, Integer.valueOf(paramc.ahJ()) });
      return;
      i = 60000;
    }
  }
  
  protected final String ajy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    l.amK();
    return l.amC();
  }
  
  protected final String ajz()
  {
    return "socketTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.e
 * JD-Core Version:    0.7.0.1
 */