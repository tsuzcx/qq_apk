package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.u.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.aa.c.b
{
  private Handler bhG;
  public String dIX;
  public com.tencent.mm.plugin.appbrand.dynamic.i.a fVD;
  private ab<String, JSONObject> fVE;
  
  public c()
  {
    HandlerThread localHandlerThread = new HandlerThread("JsApiExecutor-Thread:" + hashCode());
    localHandlerThread.start();
    this.bhG = new Handler(localHandlerThread.getLooper());
    this.fVE = new c.1(this);
  }
  
  public final String K(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errMsg", paramString1 + ":" + paramString2);
    return new JSONObject(localHashMap).toString();
  }
  
  public final String a(com.tencent.mm.aa.c.a parama, com.tencent.mm.aa.d.a parama1, com.tencent.mm.aa.b.b paramb, String paramString, b.a parama2)
  {
    String str = paramb.name;
    if (!parama1.hi(paramb.index))
    {
      u.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", new Object[] { str });
      parama1 = K(str, "fail:access denied");
      return parama1;
    }
    parama1 = o.cF(System.nanoTime());
    boolean bool = d.rZ(str);
    com.tencent.mm.plugin.appbrand.collector.c.c("jsapi_draw_canvas", parama1, "start_jsapi_invoke", bool);
    com.tencent.mm.plugin.appbrand.collector.c.bg(parama1, "after_draw_actions");
    if ((paramb instanceof b))
    {
      parama1 = tg(paramString);
      if (parama1 == null) {
        return K(str, "fail:invalid data");
      }
    }
    for (parama = paramb.a(parama, parama1, parama2);; parama = "")
    {
      parama1 = parama;
      if (this.fVD == null) {
        break;
      }
      this.fVD.tk(str);
      return parama;
      this.bhG.post(new c.2(this, parama1, bool, paramString, parama2, str, paramb, parama));
    }
  }
  
  public final String fN(String paramString)
  {
    y.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", new Object[] { paramString });
    return K(paramString, "fail:not supported");
  }
  
  public final void quit()
  {
    this.bhG.getLooper().quit();
    if (this.fVD != null) {
      this.fVD.wn();
    }
    Object localObject = this.dIX;
    if (com.tencent.mm.plugin.appbrand.dynamic.d.b.a.fVL != null)
    {
      localObject = (Map)com.tencent.mm.plugin.appbrand.dynamic.d.b.a.fVL.get(localObject);
      if (localObject != null)
      {
        Iterator localIterator = ((Map)localObject).values().iterator();
        while (localIterator.hasNext()) {
          ((e)localIterator.next()).reset();
        }
        ((Map)localObject).clear();
      }
    }
    u.v("MicroMsg.DefaultJsApiExecutor", "cache perf hit %d, miss %d, hit rate  " + (float)(this.fVE.hitCount() * 1.0D / (this.fVE.hitCount() + this.fVE.missCount())), new Object[] { Integer.valueOf(this.fVE.hitCount()), Integer.valueOf(this.fVE.missCount()) });
  }
  
  final JSONObject tg(String paramString)
  {
    return (JSONObject)this.fVE.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c
 * JD-Core Version:    0.7.0.1
 */