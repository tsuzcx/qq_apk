package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
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
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.plugin.appbrand.utils.x.b;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.plugin.appbrand.z.e.f;
import com.tencent.mm.plugin.appbrand.z.e.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static k.a laP;
  public static int laR = 0;
  public static int laS = 1;
  private k.c laQ;
  private int laT;
  private boolean laU;
  private boolean laV;
  private final AtomicBoolean laW;
  
  public e(int paramInt, k.c paramc)
  {
    AppMethodBeat.i(144211);
    this.laT = laR;
    this.laU = false;
    this.laV = false;
    this.laW = new AtomicBoolean(false);
    ae.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.laT = paramInt;
    this.laQ = paramc;
    AppMethodBeat.o(144211);
  }
  
  private static JSONObject a(f paramf)
  {
    AppMethodBeat.i(144215);
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.bCK();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.VU(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      ae.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
      AppMethodBeat.o(144215);
    }
  }
  
  public static void a(c paramc, String paramString1, com.tencent.mm.plugin.appbrand.a.b paramb, String paramString2, e parame)
  {
    AppMethodBeat.i(193472);
    if ((paramb == com.tencent.mm.plugin.appbrand.a.b.jOc) || (paramb == com.tencent.mm.plugin.appbrand.a.b.jOd))
    {
      paramString1 = l.btY().TC(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(193472);
        return;
      }
      paramString1.a(paramString1.RT(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new a().h(paramc).PQ(paramString1).a(parame.laM.PY(paramString2));
      parame.laM.remove(paramString2);
    }
    AppMethodBeat.o(193472);
  }
  
  public static void a(k.a parama)
  {
    laP = parama;
  }
  
  private void b(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(144216);
    if (bu.isNullOrNil(paramString2)) {}
    for (paramString2 = "fail";; paramString2 = "fail:".concat(String.valueOf(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("socketTaskId", paramString1);
      localHashMap.put("state", "error");
      localHashMap.put("errMsg", paramString2);
      paramString2 = new JSONObject(localHashMap).toString();
      new a().h(paramc).PQ(paramString2).a(this.laM.PY(paramString1));
      this.laM.remove(paramString1);
      ae.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString2 });
      ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 3L, 1L, false);
      AppMethodBeat.o(144216);
      return;
    }
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179501);
    if (!this.laW.getAndSet(true))
    {
      if (this.laQ != null)
      {
        this.laU = this.laQ.Ln(paramc.getAppId());
        this.laV = this.laQ.aYm();
      }
      WcWss.bpI();
    }
    Object localObject1 = l.btY().TC(paramc.getAppId());
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (((this.laT != laR) || (!this.laU)) && ((this.laT != laS) || (!this.laV) || ((this.laM.PY(paramString) != null) && (!(this.laM.PY(paramString) instanceof i))))) {
        break label274;
      }
    }
    Object localObject3;
    for (localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class));; localObject1 = new k((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class)))
    {
      localObject3 = l.btY();
      localObject4 = paramc.getAppId();
      localObject2 = localObject1;
      if (!((l)localObject3).mak.containsKey(localObject4))
      {
        ((l)localObject3).mak.put(localObject4, localObject1);
        localObject2 = localObject1;
      }
      bool = paramJSONObject.optBoolean("enableProfile", true);
      localObject1 = new d.a()
      {
        boolean laX = false;
        
        public final void OI(String paramAnonymousString)
        {
          AppMethodBeat.i(144206);
          if (this.laX)
          {
            ae.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
            AppMethodBeat.o(144206);
            return;
          }
          this.laX = true;
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "error");
          localHashMap.put("errMsg", paramAnonymousString);
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().h(paramc).PQ(paramAnonymousString).a(e.this.laM.PY(paramString));
          e.this.laM.remove(paramString);
          if ((e.a(e.this)) || (e.b(e.this)))
          {
            ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 2L, 1L, false);
            AppMethodBeat.o(144206);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 1L, 1L, false);
          AppMethodBeat.o(144206);
        }
        
        public final void OJ(String paramAnonymousString)
        {
          AppMethodBeat.i(144210);
          e.a(e.this, paramc, paramString, paramAnonymousString);
          AppMethodBeat.o(144210);
        }
        
        public final void QQ(String paramAnonymousString)
        {
          AppMethodBeat.i(144207);
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", y.VM(paramAnonymousString));
          localHashMap.put("isBuffer", Boolean.FALSE);
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "message");
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().h(paramc).PQ(paramAnonymousString).a(e.this.laM.PY(paramString));
          AppMethodBeat.o(144207);
        }
        
        public final void a(com.tencent.mm.plugin.appbrand.z.e.a paramAnonymousa)
        {
          AppMethodBeat.i(144205);
          if ((paramAnonymousa == null) || (!((com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class)).cmu))
          {
            AppMethodBeat.o(144205);
            return;
          }
          m localm = new m();
          localm.dlb.dlc = "socket";
          localm.dlb.dle = e.b(paramAnonymousa);
          localm.dlb.dld = paramString;
          com.tencent.mm.sdk.b.a.IvT.l(localm);
          AppMethodBeat.o(144205);
        }
        
        public final void a(h paramAnonymoush, Map<String, Long> paramAnonymousMap)
        {
          AppMethodBeat.i(175385);
          if (e.bme() != null) {
            e.bme().a(paramc, paramString, e.this);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "open");
          localHashMap.put("header", e.b(paramAnonymoush));
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0) && (bool)) {
            localHashMap.put("profile", paramAnonymousMap);
          }
          paramAnonymoush = new JSONObject(localHashMap).toString();
          new e.a().h(paramc).PQ(paramAnonymoush).a(e.this.laM.PY(paramString));
          AppMethodBeat.o(175385);
        }
        
        public final void aa(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(144209);
          if (e.bme() != null) {
            e.bme().d(paramc, paramString);
          }
          HashMap localHashMap = new HashMap();
          if (j.b(paramc.aWc())) {
            localHashMap.put("reason", "interrupted");
          }
          for (;;)
          {
            localHashMap.put("code", Integer.valueOf(paramAnonymousInt));
            localHashMap.put("socketTaskId", paramString);
            localHashMap.put("state", "close");
            paramAnonymousString = new JSONObject(localHashMap).toString();
            new e.a().h(paramc).PQ(paramAnonymousString).a(e.this.laM.PY(paramString));
            e.this.laM.remove(paramString);
            AppMethodBeat.o(144209);
            return;
            if (!bu.isNullOrNil(paramAnonymousString)) {
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
          paramAnonymousByteBuffer = (x.a)paramc.ar(x.a.class);
          paramAnonymousByteBuffer = x.a(paramc.aYB(), localHashMap, paramAnonymousByteBuffer);
          if (paramAnonymousByteBuffer == x.b.mUn)
          {
            paramAnonymousByteBuffer = new JSONObject(localHashMap).toString();
            new e.a().h(paramc).PQ(paramAnonymousByteBuffer).a(e.this.laM.PY(paramString));
            AppMethodBeat.o(144208);
            return;
          }
          if (paramAnonymousByteBuffer == x.b.mUo) {
            x.l(paramc, "onSocketTaskStateChange");
          }
          AppMethodBeat.o(144208);
        }
      };
      localObject3 = paramJSONObject.optString("url");
      if (!bu.isNullOrNil((String)localObject3)) {
        break;
      }
      ae.i("MicroMsg.JsApiCreateSocketTask", "url is null");
      b(paramc, paramString, "url is null");
      AppMethodBeat.o(179501);
      return;
      label274:
      ae.d("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
    }
    ae.i("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", new Object[] { Boolean.valueOf(bool), localObject3 });
    Object localObject4 = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    Map localMap = j.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.o.a)localObject4);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (final boolean bool = false; (bool) && (!j.a(((com.tencent.mm.plugin.appbrand.o.a)localObject4).cmY, (String)localObject3, ((com.tencent.mm.plugin.appbrand.o.a)localObject4).cmT)); bool = ((com.tencent.mm.plugin.appbrand.o.a)localObject4).lZO)
    {
      ae.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { localObject3 });
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
      localObject2.a(paramc.getAppId(), paramString, this.laT, i, paramJSONObject, localMap, (d.a)localObject1);
      if ((this.laU) || (this.laV)) {
        ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 10L, 1L, false);
      }
      for (;;)
      {
        ae.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { localObject3, Integer.valueOf(paramc.aXX()) });
        AppMethodBeat.o(179501);
        return;
        ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 0L, 1L, false);
      }
      i = 60000;
    }
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(144212);
    Object localObject = new StringBuilder();
    l.btY();
    localObject = l.btP();
    AppMethodBeat.o(144212);
    return localObject;
  }
  
  public final String aeV()
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