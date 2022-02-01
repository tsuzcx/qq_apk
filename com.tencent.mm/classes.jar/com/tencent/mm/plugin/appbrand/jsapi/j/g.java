package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.aa.e.f;
import com.tencent.mm.plugin.appbrand.aa.e.h;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.p.j;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.plugin.appbrand.p.k.a;
import com.tencent.mm.plugin.appbrand.p.k.c;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.plugin.appbrand.utils.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends c
{
  public static final int CTRL_INDEX = 346;
  public static final String NAME = "createSocketTask";
  private static k.a kAZ;
  public static int kBb = 0;
  public static int kBc = 1;
  private k.c kBa;
  private int kBd;
  private boolean kBe;
  private boolean kBf;
  private final AtomicBoolean kBg;
  
  public g(int paramInt, k.c paramc)
  {
    AppMethodBeat.i(144211);
    this.kBd = kBb;
    this.kBe = false;
    this.kBf = false;
    this.kBg = new AtomicBoolean(false);
    ac.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kBd = paramInt;
    this.kBa = paramc;
    AppMethodBeat.o(144211);
  }
  
  private static JSONObject a(f paramf)
  {
    AppMethodBeat.i(144215);
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.bxL();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.RE(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      ac.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
      AppMethodBeat.o(144215);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, b paramb, String paramString2, g paramg)
  {
    AppMethodBeat.i(199902);
    if ((paramb == b.jqW) || (paramb == b.jqX))
    {
      paramString1 = l.bpo().Pq(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(199902);
        return;
      }
      paramString1.a(paramString1.NL(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new a().h(paramc).LO(paramString1).a(paramg.kAW.MJ(paramString2));
      paramg.kAW.remove(paramString2);
    }
    AppMethodBeat.o(199902);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(144216);
    if (bs.isNullOrNil(paramString2)) {}
    for (paramString2 = "fail";; paramString2 = "fail:".concat(String.valueOf(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("socketTaskId", paramString1);
      localHashMap.put("state", "error");
      localHashMap.put("errMsg", paramString2);
      paramString2 = new JSONObject(localHashMap).toString();
      new a().h(paramc).LO(paramString2).a(this.kAW.MJ(paramString1));
      this.kAW.remove(paramString1);
      ac.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString2 });
      ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 3L, 1L, false);
      AppMethodBeat.o(144216);
      return;
    }
  }
  
  public static void a(k.a parama)
  {
    kAZ = parama;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179501);
    if (!this.kBg.getAndSet(true))
    {
      if (this.kBa != null)
      {
        this.kBe = this.kBa.HA(paramc.getAppId());
        this.kBf = this.kBa.aUH();
      }
      WcWss.bln();
    }
    Object localObject1 = l.bpo().Pq(paramc.getAppId());
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (((this.kBd != kBb) || (!this.kBe)) && ((this.kBd != kBc) || (!this.kBf) || ((this.kAW.MJ(paramString) != null) && (!(this.kAW.MJ(paramString) instanceof i))))) {
        break label274;
      }
    }
    Object localObject3;
    for (localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class));; localObject1 = new k((com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class)))
    {
      localObject3 = l.bpo();
      localObject4 = paramc.getAppId();
      localObject2 = localObject1;
      if (!((l)localObject3).lwt.containsKey(localObject4))
      {
        ((l)localObject3).lwt.put(localObject4, localObject1);
        localObject2 = localObject1;
      }
      bool = paramJSONObject.optBoolean("enableProfile", true);
      localObject1 = new d.a()
      {
        boolean kBh = false;
        
        public final void KH(String paramAnonymousString)
        {
          AppMethodBeat.i(144206);
          if (this.kBh)
          {
            ac.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
            AppMethodBeat.o(144206);
            return;
          }
          this.kBh = true;
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "error");
          localHashMap.put("errMsg", paramAnonymousString);
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new g.a().h(paramc).LO(paramAnonymousString).a(g.this.kAW.MJ(paramString));
          g.this.kAW.remove(paramString);
          if ((g.a(g.this)) || (g.b(g.this)))
          {
            ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 2L, 1L, false);
            AppMethodBeat.o(144206);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 1L, 1L, false);
          AppMethodBeat.o(144206);
        }
        
        public final void KI(String paramAnonymousString)
        {
          AppMethodBeat.i(144210);
          g.a(g.this, paramc, paramString, paramAnonymousString);
          AppMethodBeat.o(144210);
        }
        
        public final void MK(String paramAnonymousString)
        {
          AppMethodBeat.i(144207);
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", w.Rv(paramAnonymousString));
          localHashMap.put("isBuffer", Boolean.FALSE);
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "message");
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new g.a().h(paramc).LO(paramAnonymousString).a(g.this.kAW.MJ(paramString));
          AppMethodBeat.o(144207);
        }
        
        public final void Y(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(144209);
          if (g.bhO() != null) {
            g.bhO().d(paramc, paramString);
          }
          HashMap localHashMap = new HashMap();
          if (j.b(paramc.aSr())) {
            localHashMap.put("reason", "interrupted");
          }
          for (;;)
          {
            localHashMap.put("code", Integer.valueOf(paramAnonymousInt));
            localHashMap.put("socketTaskId", paramString);
            localHashMap.put("state", "close");
            paramAnonymousString = new JSONObject(localHashMap).toString();
            new g.a().h(paramc).LO(paramAnonymousString).a(g.this.kAW.MJ(paramString));
            g.this.kAW.remove(paramString);
            AppMethodBeat.o(144209);
            return;
            if (!bs.isNullOrNil(paramAnonymousString)) {
              localHashMap.put("reason", paramAnonymousString);
            }
          }
        }
        
        public final void a(com.tencent.mm.plugin.appbrand.aa.e.a paramAnonymousa)
        {
          AppMethodBeat.i(144205);
          if ((paramAnonymousa == null) || (!((com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class)).ccb))
          {
            AppMethodBeat.o(144205);
            return;
          }
          m localm = new m();
          localm.cYH.cYI = "socket";
          localm.cYH.cYK = g.b(paramAnonymousa);
          localm.cYH.cYJ = paramString;
          com.tencent.mm.sdk.b.a.GpY.l(localm);
          AppMethodBeat.o(144205);
        }
        
        public final void a(h paramAnonymoush, Map<String, Long> paramAnonymousMap)
        {
          AppMethodBeat.i(175385);
          if (g.bhO() != null) {
            g.bhO().a(paramc, paramString, g.this);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "open");
          localHashMap.put("header", g.b(paramAnonymoush));
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0) && (bool)) {
            localHashMap.put("profile", paramAnonymousMap);
          }
          paramAnonymoush = new JSONObject(localHashMap).toString();
          new g.a().h(paramc).LO(paramAnonymoush).a(g.this.kAW.MJ(paramString));
          AppMethodBeat.o(175385);
        }
        
        public final void l(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(144208);
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("data", paramAnonymousByteBuffer);
          localHashMap.put("isBuffer", Boolean.TRUE);
          localHashMap.put("state", "message");
          paramAnonymousByteBuffer = (v.a)paramc.ar(v.a.class);
          paramAnonymousByteBuffer = v.a(paramc.aUV(), localHashMap, paramAnonymousByteBuffer);
          if (paramAnonymousByteBuffer == v.b.moG)
          {
            paramAnonymousByteBuffer = new JSONObject(localHashMap).toString();
            new g.a().h(paramc).LO(paramAnonymousByteBuffer).a(g.this.kAW.MJ(paramString));
            AppMethodBeat.o(144208);
            return;
          }
          if (paramAnonymousByteBuffer == v.b.moH) {
            v.k(paramc, "onSocketTaskStateChange");
          }
          AppMethodBeat.o(144208);
        }
      };
      localObject3 = paramJSONObject.optString("url");
      if (!bs.isNullOrNil((String)localObject3)) {
        break;
      }
      ac.i("MicroMsg.JsApiCreateSocketTask", "url is null");
      a(paramc, paramString, "url is null");
      AppMethodBeat.o(179501);
      return;
      label274:
      ac.d("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
    }
    ac.i("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", new Object[] { Boolean.valueOf(bool), localObject3 });
    Object localObject4 = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
    Map localMap = j.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.p.a)localObject4);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (final boolean bool = false; (bool) && (!j.a(((com.tencent.mm.plugin.appbrand.p.a)localObject4).ccF, (String)localObject3, ((com.tencent.mm.plugin.appbrand.p.a)localObject4).ccA)); bool = ((com.tencent.mm.plugin.appbrand.p.a)localObject4).lvY)
    {
      ac.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { localObject3 });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179501);
      return;
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a((com.tencent.mm.plugin.appbrand.p.a)localObject4, 1);
    }
    if (i > 0) {}
    for (;;)
    {
      localObject2.a(paramc.getAppId(), paramString, this.kBd, i, paramJSONObject, localMap, (d.a)localObject1);
      if ((this.kBe) || (this.kBf)) {
        ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 10L, 1L, false);
      }
      for (;;)
      {
        ac.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { localObject3, Integer.valueOf(paramc.aUT()) });
        AppMethodBeat.o(179501);
        return;
        ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 0L, 1L, false);
      }
      i = 60000;
    }
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(144212);
    Object localObject = new StringBuilder();
    l.bpo();
    localObject = l.bpf();
    AppMethodBeat.o(144212);
    return localObject;
  }
  
  public final String acf()
  {
    return "socketTaskId";
  }
  
  public static class a
    extends ar
  {
    public static final int CTRL_INDEX = 348;
    public static final String NAME = "onSocketTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.g
 * JD-Core Version:    0.7.0.1
 */