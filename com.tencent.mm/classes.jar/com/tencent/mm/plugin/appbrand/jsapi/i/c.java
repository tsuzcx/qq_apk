package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.plugin.appbrand.o.b.1;
import com.tencent.mm.plugin.appbrand.o.b.a;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public class c
  extends b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString1 = new JSONObject(localHashMap).toString();
    new c.a().e(paramc).tM(paramString1).dispatch();
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject arg2, String arg3)
  {
    y.d("MicroMsg.JsApiCreateDownloadTask", "JsApiCreateDownloadTask");
    Object localObject2 = new c.1(this, ???.optString("filePath"), paramc, ???);
    Object localObject3 = (a)paramc.D(a.class);
    Map localMap = j.a(???, (a)localObject3);
    Object localObject1 = ???.optString("url");
    if (bk.bl((String)localObject1))
    {
      y.i("MicroMsg.JsApiCreateDownloadTask", "url is null");
      a(paramc, ???, "url is null or nil");
      return;
    }
    if ((((a)localObject3).gQw) && (???.optBoolean("__skipDomainCheck__")))
    {
      i = 1;
      if (i == 0) {
        break label153;
      }
    }
    label153:
    for (boolean bool = false;; bool = ((a)localObject3).gQx)
    {
      if ((!bool) || (j.c(((a)localObject3).fQm, (String)localObject1))) {
        break label163;
      }
      y.i("MicroMsg.JsApiCreateDownloadTask", "not in domain url %s", new Object[] { localObject1 });
      a(paramc, ???, "url not in domain list");
      return;
      i = 0;
      break;
    }
    label163:
    if (((a)localObject3).fQb <= 0) {
      y.i("MicroMsg.JsApiCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
    }
    int j = ???.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a((a)localObject3, 3);
    }
    if (i > 0) {}
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.o.c.amD().vs(paramc.getAppId());
      if (localObject1 == null)
      {
        localObject1 = new com.tencent.mm.plugin.appbrand.o.b(paramc);
        com.tencent.mm.plugin.appbrand.o.c localc = com.tencent.mm.plugin.appbrand.o.c.amD();
        paramc = paramc.getAppId();
        if (!localc.goq.containsKey(paramc)) {
          localc.goq.put(paramc, localObject1);
        }
      }
      for (paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1; paramc != null; paramc = (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1)
      {
        y.i("MicroMsg.JsApiCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        j = ((a)localObject3).fOD;
        if (bool) {}
        for (localObject1 = ((a)localObject3).fQm;; localObject1 = null)
        {
          localObject3 = ???.optString("url");
          synchronized (paramc.gQN)
          {
            if (paramc.gQN.size() < paramc.gQH) {
              break;
            }
            ((b.a)localObject2).us("max_connected");
            y.i("MicroMsg.AppBrandNetworkDownload", "max connected");
            return;
          }
        }
        ??? = paramc.gQI + ad.bB((String)localObject3) + "temp";
        localObject2 = new com.tencent.mm.plugin.appbrand.o.a.b(paramc.geu, (String)localObject3, ???, paramc.gQK, new b.1(paramc, ???, (b.a)localObject2));
        ((com.tencent.mm.plugin.appbrand.o.a.b)localObject2).gRQ = localMap;
        ((com.tencent.mm.plugin.appbrand.o.a.b)localObject2).dEk = i;
        ((com.tencent.mm.plugin.appbrand.o.a.b)localObject2).isRunning = true;
        ((com.tencent.mm.plugin.appbrand.o.a.b)localObject2).gRf = ((ArrayList)localObject1);
        ((com.tencent.mm.plugin.appbrand.o.a.b)localObject2).gRR = j;
        ((com.tencent.mm.plugin.appbrand.o.a.b)localObject2).gQJ = paramc.gQJ;
        ((com.tencent.mm.plugin.appbrand.o.a.b)localObject2).gep = ???;
        ((com.tencent.mm.plugin.appbrand.o.a.b)localObject2).gRj = "createDownloadTask";
        synchronized (paramc.gQN)
        {
          paramc.gQN.add(localObject2);
        }
        synchronized (paramc.gQM)
        {
          if (!paramc.gQM.containsKey(localObject3))
          {
            ??? = new ConcurrentLinkedQueue();
            paramc.gQM.put(localObject3, ???);
            ???.offer(localObject2);
            if ((paramc.gQM.get(localObject3) != null) && (((ConcurrentLinkedQueue)paramc.gQM.get(localObject3)).size() > 1))
            {
              y.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
              return;
              paramc = finally;
              throw paramc;
            }
          }
          else
          {
            ??? = (ConcurrentLinkedQueue)paramc.gQM.get(localObject3);
          }
        }
        paramc.vn((String)localObject3);
        return;
      }
      break;
      i = 60000;
    }
  }
  
  protected final String ajy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.plugin.appbrand.o.c.amD();
    return com.tencent.mm.plugin.appbrand.o.c.amC();
  }
  
  protected final String ajz()
  {
    return "downloadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.c
 * JD-Core Version:    0.7.0.1
 */