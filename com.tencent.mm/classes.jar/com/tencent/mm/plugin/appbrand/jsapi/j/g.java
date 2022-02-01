package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.ab.e.f;
import com.tencent.mm.plugin.appbrand.ab.e.h;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.appbrand.q.k.a;
import com.tencent.mm.plugin.appbrand.q.k.c;
import com.tencent.mm.plugin.appbrand.q.l;
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

public final class g
  extends c
{
  public static final int CTRL_INDEX = 346;
  public static final String NAME = "createSocketTask";
  private static k.a kam;
  public static int kao = 0;
  public static int kap = 1;
  private k.c kan;
  private int kaq;
  private boolean kar;
  private boolean kas;
  private final AtomicBoolean kat;
  
  public g(int paramInt, k.c paramc)
  {
    AppMethodBeat.i(144211);
    this.kaq = kao;
    this.kar = false;
    this.kas = false;
    this.kat = new AtomicBoolean(false);
    ad.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kaq = paramInt;
    this.kan = paramc;
    AppMethodBeat.o(144211);
  }
  
  private static JSONObject a(f paramf)
  {
    AppMethodBeat.i(144215);
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.bqL();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.Nv(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      ad.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
      AppMethodBeat.o(144215);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, b paramb, String paramString2, g paramg)
  {
    AppMethodBeat.i(190823);
    if ((paramb == b.iQM) || (paramb == b.iQN))
    {
      paramString1 = l.biu().Li(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(190823);
        return;
      }
      paramString1.a(paramString1.JE(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new a().h(paramc).HK(paramString1).a(paramg.kaj.II(paramString2));
      paramg.kaj.remove(paramString2);
    }
    AppMethodBeat.o(190823);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
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
      new a().h(paramc).HK(paramString2).a(this.kaj.II(paramString1));
      this.kaj.remove(paramString1);
      ad.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString2 });
      ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(972L, 3L, 1L, false);
      AppMethodBeat.o(144216);
      return;
    }
  }
  
  public static void a(k.a parama)
  {
    kam = parama;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179501);
    if (!this.kat.getAndSet(true))
    {
      if (this.kan != null)
      {
        this.kar = this.kan.Dx(paramc.getAppId());
        this.kas = this.kan.aNR();
      }
      WcWss.bet();
    }
    Object localObject1 = l.biu().Li(paramc.getAppId());
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (((this.kaq != kao) || (!this.kar)) && ((this.kaq != kap) || (!this.kas) || ((this.kaj.II(paramString) != null) && (!(this.kaj.II(paramString) instanceof i))))) {
        break label274;
      }
    }
    Object localObject3;
    for (localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class));; localObject1 = new k((com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class)))
    {
      localObject3 = l.biu();
      localObject4 = paramc.getAppId();
      localObject2 = localObject1;
      if (!((l)localObject3).kUJ.containsKey(localObject4))
      {
        ((l)localObject3).kUJ.put(localObject4, localObject1);
        localObject2 = localObject1;
      }
      bool = paramJSONObject.optBoolean("enableProfile", true);
      localObject1 = new d.a()
      {
        boolean kau = false;
        
        public final void GD(String paramAnonymousString)
        {
          AppMethodBeat.i(144206);
          if (this.kau)
          {
            ad.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
            AppMethodBeat.o(144206);
            return;
          }
          this.kau = true;
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "error");
          localHashMap.put("errMsg", paramAnonymousString);
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new g.a().h(paramc).HK(paramAnonymousString).a(g.this.kaj.II(paramString));
          g.this.kaj.remove(paramString);
          if ((g.a(g.this)) || (g.b(g.this)))
          {
            ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(972L, 2L, 1L, false);
            AppMethodBeat.o(144206);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(972L, 1L, 1L, false);
          AppMethodBeat.o(144206);
        }
        
        public final void GE(String paramAnonymousString)
        {
          AppMethodBeat.i(144210);
          g.a(g.this, paramc, paramString, paramAnonymousString);
          AppMethodBeat.o(144210);
        }
        
        public final void IJ(String paramAnonymousString)
        {
          AppMethodBeat.i(144207);
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", w.Nm(paramAnonymousString));
          localHashMap.put("isBuffer", Boolean.FALSE);
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "message");
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new g.a().h(paramc).HK(paramAnonymousString).a(g.this.kaj.II(paramString));
          AppMethodBeat.o(144207);
        }
        
        public final void X(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(144209);
          if (g.baW() != null) {
            g.baW().d(paramc, paramString);
          }
          HashMap localHashMap = new HashMap();
          if (j.b(paramc.aLA())) {
            localHashMap.put("reason", "interrupted");
          }
          for (;;)
          {
            localHashMap.put("code", Integer.valueOf(paramAnonymousInt));
            localHashMap.put("socketTaskId", paramString);
            localHashMap.put("state", "close");
            paramAnonymousString = new JSONObject(localHashMap).toString();
            new g.a().h(paramc).HK(paramAnonymousString).a(g.this.kaj.II(paramString));
            g.this.kaj.remove(paramString);
            AppMethodBeat.o(144209);
            return;
            if (!bt.isNullOrNil(paramAnonymousString)) {
              localHashMap.put("reason", paramAnonymousString);
            }
          }
        }
        
        public final void a(com.tencent.mm.plugin.appbrand.ab.e.a paramAnonymousa)
        {
          AppMethodBeat.i(144205);
          if ((paramAnonymousa == null) || (!((com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class)).cfe))
          {
            AppMethodBeat.o(144205);
            return;
          }
          m localm = new m();
          localm.dbl.dbm = "socket";
          localm.dbl.dbo = g.b(paramAnonymousa);
          localm.dbl.dbn = paramString;
          com.tencent.mm.sdk.b.a.ESL.l(localm);
          AppMethodBeat.o(144205);
        }
        
        public final void a(h paramAnonymoush, Map<String, Long> paramAnonymousMap)
        {
          AppMethodBeat.i(175385);
          if (g.baW() != null) {
            g.baW().a(paramc, paramString, g.this);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "open");
          localHashMap.put("header", g.b(paramAnonymoush));
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0) && (bool)) {
            localHashMap.put("profile", paramAnonymousMap);
          }
          paramAnonymoush = new JSONObject(localHashMap).toString();
          new g.a().h(paramc).HK(paramAnonymoush).a(g.this.kaj.II(paramString));
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
          paramAnonymousByteBuffer = v.a(paramc.aOf(), localHashMap, paramAnonymousByteBuffer);
          if (paramAnonymousByteBuffer == v.b.lMJ)
          {
            paramAnonymousByteBuffer = new JSONObject(localHashMap).toString();
            new g.a().h(paramc).HK(paramAnonymousByteBuffer).a(g.this.kaj.II(paramString));
            AppMethodBeat.o(144208);
            return;
          }
          if (paramAnonymousByteBuffer == v.b.lMK) {
            v.k(paramc, "onSocketTaskStateChange");
          }
          AppMethodBeat.o(144208);
        }
      };
      localObject3 = paramJSONObject.optString("url");
      if (!bt.isNullOrNil((String)localObject3)) {
        break;
      }
      ad.i("MicroMsg.JsApiCreateSocketTask", "url is null");
      a(paramc, paramString, "url is null");
      AppMethodBeat.o(179501);
      return;
      label274:
      ad.d("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
    }
    ad.i("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", new Object[] { Boolean.valueOf(bool), localObject3 });
    Object localObject4 = (com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class);
    Map localMap = j.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.q.a)localObject4);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (final boolean bool = false; (bool) && (!j.a(((com.tencent.mm.plugin.appbrand.q.a)localObject4).cfI, (String)localObject3, ((com.tencent.mm.plugin.appbrand.q.a)localObject4).cfD)); bool = ((com.tencent.mm.plugin.appbrand.q.a)localObject4).kUo)
    {
      ad.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { localObject3 });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179501);
      return;
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a((com.tencent.mm.plugin.appbrand.q.a)localObject4, 1);
    }
    if (i > 0) {}
    for (;;)
    {
      localObject2.a(paramc.getAppId(), paramString, this.kaq, i, paramJSONObject, localMap, (d.a)localObject1);
      if ((this.kar) || (this.kas)) {
        ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(972L, 10L, 1L, false);
      }
      for (;;)
      {
        ad.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { localObject3, Integer.valueOf(paramc.aOd()) });
        AppMethodBeat.o(179501);
        return;
        ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(972L, 0L, 1L, false);
      }
      i = 60000;
    }
  }
  
  public final String aEB()
  {
    AppMethodBeat.i(144212);
    Object localObject = new StringBuilder();
    l.biu();
    localObject = l.bil();
    AppMethodBeat.o(144212);
    return localObject;
  }
  
  public final String abh()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.g
 * JD-Core Version:    0.7.0.1
 */