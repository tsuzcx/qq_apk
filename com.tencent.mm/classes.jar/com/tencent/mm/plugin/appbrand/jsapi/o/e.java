package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.plugin.appbrand.s.k.a;
import com.tencent.mm.plugin.appbrand.s.k.c;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.plugin.appbrand.utils.x.b;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 346;
  public static final String NAME = "createSocketTask";
  private static k.a mge;
  public static int mgg = 0;
  public static int mgh = 1;
  private k.c mgf;
  private int mgi;
  private boolean mgj;
  private boolean mgk;
  private final AtomicBoolean mgl;
  
  public e(int paramInt, k.c paramc)
  {
    AppMethodBeat.i(144211);
    this.mgi = mgg;
    this.mgj = false;
    this.mgk = false;
    this.mgl = new AtomicBoolean(false);
    Log.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.mgi = paramInt;
    this.mgf = paramc;
    AppMethodBeat.o(144211);
  }
  
  private static JSONObject a(com.tencent.mm.plugin.appbrand.ae.e.f paramf)
  {
    AppMethodBeat.i(144215);
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.bZO();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.afQ(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      Log.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
      AppMethodBeat.o(144215);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, com.tencent.mm.plugin.appbrand.a.b paramb, String paramString2, e parame)
  {
    AppMethodBeat.i(207091);
    if ((paramb == com.tencent.mm.plugin.appbrand.a.b.kQJ) || (paramb == com.tencent.mm.plugin.appbrand.a.b.kQK))
    {
      paramString1 = l.bPF().adh(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(207091);
        return;
      }
      paramString1.a(paramString1.aby(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new a().h(paramf).Zh(paramString1).a(parame.mgb.Zz(paramString2));
      parame.mgb.remove(paramString2);
    }
    AppMethodBeat.o(207091);
  }
  
  public static void a(k.a parama)
  {
    mge = parama;
  }
  
  private void b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(144216);
    if (Util.isNullOrNil(paramString2)) {}
    for (paramString2 = "fail";; paramString2 = "fail:".concat(String.valueOf(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("socketTaskId", paramString1);
      localHashMap.put("state", "error");
      localHashMap.put("errMsg", paramString2);
      paramString2 = new JSONObject(localHashMap).toString();
      new a().h(paramf).Zh(paramString2).a(this.mgb.Zz(paramString1));
      this.mgb.remove(paramString1);
      Log.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString2 });
      ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 3L, 1L, false);
      AppMethodBeat.o(144216);
      return;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179501);
    if (!this.mgl.getAndSet(true))
    {
      if (this.mgf != null)
      {
        this.mgj = this.mgf.Uw(paramf.getAppId());
        localObject1 = this.mgf;
        paramf.getAppId();
        this.mgk = ((k.c)localObject1).btz();
      }
      WcWss.bLo();
    }
    Object localObject1 = l.bPF().adh(paramf.getAppId());
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (((this.mgi != mgg) || (!this.mgj)) && ((this.mgi != mgh) || (!this.mgk) || ((this.mgb.Zz(paramString) != null) && (!(this.mgb.Zz(paramString) instanceof i))))) {
        break label285;
      }
    }
    Object localObject3;
    for (localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class));; localObject1 = new k((com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class)))
    {
      localObject3 = l.bPF();
      localObject4 = paramf.getAppId();
      localObject2 = localObject1;
      if (!((l)localObject3).nhY.containsKey(localObject4))
      {
        ((l)localObject3).nhY.put(localObject4, localObject1);
        localObject2 = localObject1;
      }
      bool = paramJSONObject.optBoolean("enableProfile", true);
      localObject1 = new d.a()
      {
        boolean mgm = false;
        
        public final void XT(String paramAnonymousString)
        {
          AppMethodBeat.i(144206);
          if (this.mgm)
          {
            Log.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
            AppMethodBeat.o(144206);
            return;
          }
          this.mgm = true;
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "error");
          localHashMap.put("errMsg", paramAnonymousString);
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().h(paramf).Zh(paramAnonymousString).a(e.this.mgb.Zz(paramString));
          e.this.mgb.remove(paramString);
          if ((e.a(e.this)) || (e.b(e.this)))
          {
            ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 2L, 1L, false);
            AppMethodBeat.o(144206);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 1L, 1L, false);
          AppMethodBeat.o(144206);
        }
        
        public final void XU(String paramAnonymousString)
        {
          AppMethodBeat.i(144210);
          e.a(e.this, paramf, paramString, paramAnonymousString);
          AppMethodBeat.o(144210);
        }
        
        public final void a(com.tencent.mm.plugin.appbrand.ae.e.a paramAnonymousa)
        {
          AppMethodBeat.i(144205);
          if ((paramAnonymousa == null) || (!((com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class)).cyp))
          {
            AppMethodBeat.o(144205);
            return;
          }
          n localn = new n();
          localn.dCn.dCo = "socket";
          localn.dCn.dCq = e.b(paramAnonymousa);
          localn.dCn.dCp = paramString;
          EventCenter.instance.publish(localn);
          AppMethodBeat.o(144205);
        }
        
        public final void a(h paramAnonymoush, Map<String, Long> paramAnonymousMap)
        {
          AppMethodBeat.i(175385);
          if (e.bHD() != null) {
            e.bHD().a(paramf, paramString, e.this);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "open");
          localHashMap.put("header", e.b(paramAnonymoush));
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0) && (bool)) {
            localHashMap.put("profile", paramAnonymousMap);
          }
          paramAnonymoush = new JSONObject(localHashMap).toString();
          new e.a().h(paramf).Zh(paramAnonymoush).a(e.this.mgb.Zz(paramString));
          AppMethodBeat.o(175385);
        }
        
        public final void aar(String paramAnonymousString)
        {
          AppMethodBeat.i(144207);
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", y.afI(paramAnonymousString));
          localHashMap.put("isBuffer", Boolean.FALSE);
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "message");
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().h(paramf).Zh(paramAnonymousString).a(e.this.mgb.Zz(paramString));
          AppMethodBeat.o(144207);
        }
        
        public final void ae(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(144209);
          if (e.bHD() != null) {
            e.bHD().d(paramf, paramString);
          }
          HashMap localHashMap = new HashMap();
          if (j.b(paramf.getAppState())) {
            localHashMap.put("reason", "interrupted");
          }
          for (;;)
          {
            localHashMap.put("code", Integer.valueOf(paramAnonymousInt));
            localHashMap.put("socketTaskId", paramString);
            localHashMap.put("state", "close");
            paramAnonymousString = new JSONObject(localHashMap).toString();
            new e.a().h(paramf).Zh(paramAnonymousString).a(e.this.mgb.Zz(paramString));
            e.this.mgb.remove(paramString);
            AppMethodBeat.o(144209);
            return;
            if (!Util.isNullOrNil(paramAnonymousString)) {
              localHashMap.put("reason", paramAnonymousString);
            }
          }
        }
        
        public final void k(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(144208);
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("data", paramAnonymousByteBuffer);
          localHashMap.put("isBuffer", Boolean.TRUE);
          localHashMap.put("state", "message");
          paramAnonymousByteBuffer = (x.a)paramf.av(x.a.class);
          paramAnonymousByteBuffer = x.a(paramf.getJsRuntime(), localHashMap, paramAnonymousByteBuffer);
          if (paramAnonymousByteBuffer == x.b.oho)
          {
            paramAnonymousByteBuffer = new JSONObject(localHashMap).toString();
            new e.a().h(paramf).Zh(paramAnonymousByteBuffer).a(e.this.mgb.Zz(paramString));
            AppMethodBeat.o(144208);
            return;
          }
          if (paramAnonymousByteBuffer == x.b.ohp) {
            x.m(paramf, "onSocketTaskStateChange");
          }
          AppMethodBeat.o(144208);
        }
      };
      localObject3 = paramJSONObject.optString("url");
      if (!Util.isNullOrNil((String)localObject3)) {
        break;
      }
      Log.i("MicroMsg.JsApiCreateSocketTask", "url is null");
      b(paramf, paramString, "url is null");
      AppMethodBeat.o(179501);
      return;
      label285:
      Log.d("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
    }
    Log.i("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", new Object[] { Boolean.valueOf(bool), localObject3 });
    Object localObject4 = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
    Map localMap = j.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.s.a)localObject4);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (final boolean bool = false; (bool) && (!j.a(((com.tencent.mm.plugin.appbrand.s.a)localObject4).cyU, (String)localObject3, ((com.tencent.mm.plugin.appbrand.s.a)localObject4).cyP)); bool = ((com.tencent.mm.plugin.appbrand.s.a)localObject4).nhD)
    {
      Log.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { localObject3 });
      b(paramf, paramString, "url not in domain list");
      AppMethodBeat.o(179501);
      return;
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a((com.tencent.mm.plugin.appbrand.s.a)localObject4, 1);
    }
    if (i > 0) {}
    for (;;)
    {
      localObject2.a(paramf.getAppId(), paramString, this.mgi, i, paramJSONObject, localMap, (d.a)localObject1);
      if ((this.mgj) || (this.mgk)) {
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 10L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { localObject3, Integer.valueOf(paramf.getComponentId()) });
        AppMethodBeat.o(179501);
        return;
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 0L, 1L, false);
      }
      i = 60000;
    }
  }
  
  public final String auJ()
  {
    return "socketTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(144212);
    Object localObject = new StringBuilder();
    l.bPF();
    localObject = l.bPw();
    AppMethodBeat.o(144212);
    return localObject;
  }
  
  public static class a
    extends bc
  {
    public static final int CTRL_INDEX = 348;
    public static final String NAME = "onSocketTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.e
 * JD-Core Version:    0.7.0.1
 */