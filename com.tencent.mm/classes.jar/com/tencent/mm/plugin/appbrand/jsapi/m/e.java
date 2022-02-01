package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.aa.e.f;
import com.tencent.mm.plugin.appbrand.aa.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.o.k;
import com.tencent.mm.plugin.appbrand.o.k.a;
import com.tencent.mm.plugin.appbrand.o.k.c;
import com.tencent.mm.plugin.appbrand.o.l;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.plugin.appbrand.utils.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static k.a kXg;
  public static int kXi = 0;
  public static int kXj = 1;
  private k.c kXh;
  private int kXk;
  private boolean kXl;
  private boolean kXm;
  private final AtomicBoolean kXn;
  
  public e(int paramInt, k.c paramc)
  {
    AppMethodBeat.i(144211);
    this.kXk = kXi;
    this.kXl = false;
    this.kXm = false;
    this.kXn = new AtomicBoolean(false);
    ad.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kXk = paramInt;
    this.kXh = paramc;
    AppMethodBeat.o(144211);
  }
  
  private static JSONObject a(f paramf)
  {
    AppMethodBeat.i(144215);
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.bBQ();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.Vj(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      ad.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
      AppMethodBeat.o(144215);
    }
  }
  
  public static void a(c paramc, String paramString1, com.tencent.mm.plugin.appbrand.a.b paramb, String paramString2, e parame)
  {
    AppMethodBeat.i(187743);
    if ((paramb == com.tencent.mm.plugin.appbrand.a.b.jKQ) || (paramb == com.tencent.mm.plugin.appbrand.a.b.jKR))
    {
      paramString1 = l.btn().ST(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(187743);
        return;
      }
      paramString1.a(paramString1.Rk(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new a().h(paramc).Pi(paramString1).a(parame.kXd.Pq(paramString2));
      parame.kXd.remove(paramString2);
    }
    AppMethodBeat.o(187743);
  }
  
  public static void a(k.a parama)
  {
    kXg = parama;
  }
  
  private void b(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(144216);
    if (bt.isNullOrNil(paramString2)) {}
    for (paramString2 = "fail";; paramString2 = "fail:".concat(String.valueOf(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("socketTaskId", paramString1);
      localHashMap.put("state", "error");
      localHashMap.put("errMsg", paramString2);
      paramString2 = new JSONObject(localHashMap).toString();
      new a().h(paramc).Pi(paramString2).a(this.kXd.Pq(paramString1));
      this.kXd.remove(paramString1);
      ad.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString2 });
      ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 3L, 1L, false);
      AppMethodBeat.o(144216);
      return;
    }
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179501);
    if (!this.kXn.getAndSet(true))
    {
      if (this.kXh != null)
      {
        this.kXl = this.kXh.KN(paramc.getAppId());
        this.kXm = this.kXh.aXT();
      }
      WcWss.boY();
    }
    Object localObject1 = l.btn().ST(paramc.getAppId());
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (((this.kXk != kXi) || (!this.kXl)) && ((this.kXk != kXj) || (!this.kXm) || ((this.kXd.Pq(paramString) != null) && (!(this.kXd.Pq(paramString) instanceof i))))) {
        break label274;
      }
    }
    Object localObject3;
    for (localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class));; localObject1 = new k((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class)))
    {
      localObject3 = l.btn();
      localObject4 = paramc.getAppId();
      localObject2 = localObject1;
      if (!((l)localObject3).lVG.containsKey(localObject4))
      {
        ((l)localObject3).lVG.put(localObject4, localObject1);
        localObject2 = localObject1;
      }
      bool = paramJSONObject.optBoolean("enableProfile", true);
      localObject1 = new d.a()
      {
        boolean kXo = false;
        
        public final void Ob(String paramAnonymousString)
        {
          AppMethodBeat.i(144206);
          if (this.kXo)
          {
            ad.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
            AppMethodBeat.o(144206);
            return;
          }
          this.kXo = true;
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "error");
          localHashMap.put("errMsg", paramAnonymousString);
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().h(paramc).Pi(paramAnonymousString).a(e.this.kXd.Pq(paramString));
          e.this.kXd.remove(paramString);
          if ((e.a(e.this)) || (e.b(e.this)))
          {
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 2L, 1L, false);
            AppMethodBeat.o(144206);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 1L, 1L, false);
          AppMethodBeat.o(144206);
        }
        
        public final void Oc(String paramAnonymousString)
        {
          AppMethodBeat.i(144210);
          e.a(e.this, paramc, paramString, paramAnonymousString);
          AppMethodBeat.o(144210);
        }
        
        public final void Qh(String paramAnonymousString)
        {
          AppMethodBeat.i(144207);
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", w.Vb(paramAnonymousString));
          localHashMap.put("isBuffer", Boolean.FALSE);
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "message");
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().h(paramc).Pi(paramAnonymousString).a(e.this.kXd.Pq(paramString));
          AppMethodBeat.o(144207);
        }
        
        public final void a(com.tencent.mm.plugin.appbrand.aa.e.a paramAnonymousa)
        {
          AppMethodBeat.i(144205);
          if ((paramAnonymousa == null) || (!((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class)).cms))
          {
            AppMethodBeat.o(144205);
            return;
          }
          m localm = new m();
          localm.djZ.dka = "socket";
          localm.djZ.dkc = e.b(paramAnonymousa);
          localm.djZ.dkb = paramString;
          com.tencent.mm.sdk.b.a.IbL.l(localm);
          AppMethodBeat.o(144205);
        }
        
        public final void a(h paramAnonymoush, Map<String, Long> paramAnonymousMap)
        {
          AppMethodBeat.i(175385);
          if (e.blv() != null) {
            e.blv().a(paramc, paramString, e.this);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "open");
          localHashMap.put("header", e.b(paramAnonymoush));
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0) && (bool)) {
            localHashMap.put("profile", paramAnonymousMap);
          }
          paramAnonymoush = new JSONObject(localHashMap).toString();
          new e.a().h(paramc).Pi(paramAnonymoush).a(e.this.kXd.Pq(paramString));
          AppMethodBeat.o(175385);
        }
        
        public final void aa(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(144209);
          if (e.blv() != null) {
            e.blv().d(paramc, paramString);
          }
          HashMap localHashMap = new HashMap();
          if (j.b(paramc.aVD())) {
            localHashMap.put("reason", "interrupted");
          }
          for (;;)
          {
            localHashMap.put("code", Integer.valueOf(paramAnonymousInt));
            localHashMap.put("socketTaskId", paramString);
            localHashMap.put("state", "close");
            paramAnonymousString = new JSONObject(localHashMap).toString();
            new e.a().h(paramc).Pi(paramAnonymousString).a(e.this.kXd.Pq(paramString));
            e.this.kXd.remove(paramString);
            AppMethodBeat.o(144209);
            return;
            if (!bt.isNullOrNil(paramAnonymousString)) {
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
          paramAnonymousByteBuffer = (v.a)paramc.ar(v.a.class);
          paramAnonymousByteBuffer = v.a(paramc.aYh(), localHashMap, paramAnonymousByteBuffer);
          if (paramAnonymousByteBuffer == v.b.mPi)
          {
            paramAnonymousByteBuffer = new JSONObject(localHashMap).toString();
            new e.a().h(paramc).Pi(paramAnonymousByteBuffer).a(e.this.kXd.Pq(paramString));
            AppMethodBeat.o(144208);
            return;
          }
          if (paramAnonymousByteBuffer == v.b.mPj) {
            v.l(paramc, "onSocketTaskStateChange");
          }
          AppMethodBeat.o(144208);
        }
      };
      localObject3 = paramJSONObject.optString("url");
      if (!bt.isNullOrNil((String)localObject3)) {
        break;
      }
      ad.i("MicroMsg.JsApiCreateSocketTask", "url is null");
      b(paramc, paramString, "url is null");
      AppMethodBeat.o(179501);
      return;
      label274:
      ad.d("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
    }
    ad.i("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", new Object[] { Boolean.valueOf(bool), localObject3 });
    Object localObject4 = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    Map localMap = j.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.o.a)localObject4);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (final boolean bool = false; (bool) && (!j.a(((com.tencent.mm.plugin.appbrand.o.a)localObject4).cmW, (String)localObject3, ((com.tencent.mm.plugin.appbrand.o.a)localObject4).cmR)); bool = ((com.tencent.mm.plugin.appbrand.o.a)localObject4).lVl)
    {
      ad.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { localObject3 });
      b(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179501);
      return;
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a((com.tencent.mm.plugin.appbrand.o.a)localObject4, 1);
    }
    if (i > 0) {}
    for (;;)
    {
      localObject2.a(paramc.getAppId(), paramString, this.kXk, i, paramJSONObject, localMap, (d.a)localObject1);
      if ((this.kXl) || (this.kXm)) {
        ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 10L, 1L, false);
      }
      for (;;)
      {
        ad.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { localObject3, Integer.valueOf(paramc.aXC()) });
        AppMethodBeat.o(179501);
        return;
        ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 0L, 1L, false);
      }
      i = 60000;
    }
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(144212);
    Object localObject = new StringBuilder();
    l.btn();
    localObject = l.bte();
    AppMethodBeat.o(144212);
    return localObject;
  }
  
  public final String aeJ()
  {
    return "socketTaskId";
  }
  
  public static class a
    extends at
  {
    public static final int CTRL_INDEX = 348;
    public static final String NAME = "onSocketTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.e
 * JD-Core Version:    0.7.0.1
 */