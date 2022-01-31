package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o.o;
import com.tencent.mm.plugin.appbrand.o.o.1;
import com.tencent.mm.plugin.appbrand.o.o.b;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class h
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 529;
  public static final String NAME = "operateLocalServicesScan";
  final Map<String, h.a> gxA = new ConcurrentHashMap();
  
  private void b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString, int paramInt)
  {
    synchronized (this.gxA)
    {
      Object localObject2 = this.gxA.keySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((String)((Iterator)localObject2).next()).contains(paramc.getAppId()))
        {
          paramc.C(paramInt, h("fail:scan task already exist", null));
          return;
        }
      }
      ??? = new h.a(this, paramc);
      ((h.a)???).gxG.set(paramInt);
      this.gxA.put(k(paramc, paramString), ???);
      localObject2 = o.gRH;
      NsdManager localNsdManager = o.amO();
      o.1 local1 = new o.1((o)localObject2, (o.b)???);
      ((o)localObject2).gRI.put(???, local1);
      localNsdManager.discoverServices(paramString, 1, local1);
      ai.l(new h.1(this, paramc, paramString, (h.a)???), 30000L);
      return;
    }
  }
  
  private void c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    Map localMap = this.gxA;
    int i = 1;
    try
    {
      Iterator localIterator = this.gxA.values().iterator();
      while (localIterator.hasNext())
      {
        h.a locala = (h.a)localIterator.next();
        locala.gxH.set(paramInt);
        o.gRH.a(locala);
        i = 0;
      }
      if (i != 0) {
        paramc.C(paramInt, h("fail:task not found", null));
      }
      this.gxA.clear();
      return;
    }
    finally {}
  }
  
  static String k(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    return paramc.getAppId() + "#" + paramString;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("action");
    com.tencent.luggage.j.c.i("MicroMsg.JsApiOperateLocalServicesScan", "action = " + str);
    if (TextUtils.equals("start", str))
    {
      paramJSONObject = paramJSONObject.optString("serviceType");
      if (TextUtils.isEmpty(paramJSONObject))
      {
        paramc.C(paramInt, h("fail:invalid param", null));
        return;
      }
      b(paramc, paramJSONObject, paramInt);
      return;
    }
    if (TextUtils.equals("stop", str))
    {
      c(paramc, paramInt);
      return;
    }
    paramc.C(paramInt, h("fail:invalid param", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.h
 * JD-Core Version:    0.7.0.1
 */