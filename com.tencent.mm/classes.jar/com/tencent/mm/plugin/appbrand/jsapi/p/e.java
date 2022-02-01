package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.o;
import com.tencent.mm.plugin.appbrand.af.e.f;
import com.tencent.mm.plugin.appbrand.af.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.plugin.appbrand.s.k.a;
import com.tencent.mm.plugin.appbrand.s.k.c;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
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
  private static k.a pel;
  public static int pen = 0;
  public static int peo = 1;
  private k.c pem;
  private int pep;
  private boolean peq;
  private boolean per;
  private final AtomicBoolean pes;
  
  public e(int paramInt, k.c paramc)
  {
    AppMethodBeat.i(144211);
    this.pep = pen;
    this.peq = false;
    this.per = false;
    this.pes = new AtomicBoolean(false);
    Log.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.pep = paramInt;
    this.pem = paramc;
    AppMethodBeat.o(144211);
  }
  
  private static JSONObject a(f paramf)
  {
    AppMethodBeat.i(144215);
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.cmJ();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.anv(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      Log.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
      AppMethodBeat.o(144215);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString1, com.tencent.mm.plugin.appbrand.a.b paramb, String paramString2, e parame1)
  {
    AppMethodBeat.i(186714);
    if ((paramb == com.tencent.mm.plugin.appbrand.a.b.nKR) || (paramb == com.tencent.mm.plugin.appbrand.a.b.nKS))
    {
      paramString1 = l.cbW().ala(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(186714);
        return;
      }
      paramString1.a(paramString1.ajs(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new a().j(parame).agU(paramString1).b(parame1.pei.ahn(paramString2));
      parame1.pei.remove(paramString2);
    }
    AppMethodBeat.o(186714);
  }
  
  public static void a(k.a parama)
  {
    pel = parama;
  }
  
  private void b(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString1, String paramString2)
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
      new a().j(parame).agU(paramString2).b(this.pei.ahn(paramString1));
      this.pei.remove(paramString1);
      Log.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString2 });
      ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 3L, 1L, false);
      AppMethodBeat.o(144216);
      return;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179501);
    if (!this.pes.getAndSet(true))
    {
      if (this.pem != null)
      {
        this.peq = this.pem.acg(parame.getAppId());
        localObject1 = this.pem;
        parame.getAppId();
        this.per = ((k.c)localObject1).bEw();
      }
      WcWss.bXp();
    }
    Object localObject1 = l.cbW().ala(parame.getAppId());
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (((this.pep != pen) || (!this.peq)) && ((this.pep != peo) || (!this.per) || ((this.pei.ahn(paramString) != null) && (!(this.pei.ahn(paramString) instanceof i))))) {
        break label285;
      }
    }
    Object localObject3;
    for (localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class));; localObject1 = new k((com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class)))
    {
      localObject3 = l.cbW();
      localObject4 = parame.getAppId();
      localObject2 = localObject1;
      if (!((l)localObject3).qiH.containsKey(localObject4))
      {
        ((l)localObject3).qiH.put(localObject4, localObject1);
        localObject2 = localObject1;
      }
      bool = paramJSONObject.optBoolean("enableProfile", true);
      localObject1 = new d.a()
      {
        boolean pet = false;
        
        public final void a(com.tencent.mm.plugin.appbrand.af.e.a paramAnonymousa)
        {
          AppMethodBeat.i(144205);
          if ((paramAnonymousa == null) || (!((com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class)).cwS))
          {
            AppMethodBeat.o(144205);
            return;
          }
          o localo = new o();
          localo.fuU.fuV = "socket";
          localo.fuU.fuX = e.b(paramAnonymousa);
          localo.fuU.fuW = paramString;
          EventCenter.instance.publish(localo);
          AppMethodBeat.o(144205);
        }
        
        public final void a(h paramAnonymoush, Map<String, Long> paramAnonymousMap)
        {
          AppMethodBeat.i(175385);
          if (e.bTm() != null) {
            e.bTm().a(parame, paramString, e.this);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "open");
          localHashMap.put("header", e.b(paramAnonymoush));
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0) && (bool)) {
            localHashMap.put("profile", paramAnonymousMap);
          }
          paramAnonymoush = new JSONObject(localHashMap).toString();
          new e.a().j(parame).agU(paramAnonymoush).b(e.this.pei.ahn(paramString));
          AppMethodBeat.o(175385);
        }
        
        public final void afG(String paramAnonymousString)
        {
          AppMethodBeat.i(144206);
          if (this.pet)
          {
            Log.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
            AppMethodBeat.o(144206);
            return;
          }
          this.pet = true;
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "error");
          localHashMap.put("errMsg", paramAnonymousString);
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().j(parame).agU(paramAnonymousString).b(e.this.pei.ahn(paramString));
          e.this.pei.remove(paramString);
          if ((e.a(e.this)) || (e.b(e.this)))
          {
            ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 2L, 1L, false);
            AppMethodBeat.o(144206);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 1L, 1L, false);
          AppMethodBeat.o(144206);
        }
        
        public final void afH(String paramAnonymousString)
        {
          AppMethodBeat.i(144210);
          e.a(e.this, parame, paramString, paramAnonymousString);
          AppMethodBeat.o(144210);
        }
        
        public final void ag(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(144209);
          if (e.bTm() != null) {
            e.bTm().d(parame, paramString);
          }
          HashMap localHashMap = new HashMap();
          if (j.b(parame.getAppState())) {
            localHashMap.put("reason", "interrupted");
          }
          for (;;)
          {
            localHashMap.put("code", Integer.valueOf(paramAnonymousInt));
            localHashMap.put("socketTaskId", paramString);
            localHashMap.put("state", "close");
            paramAnonymousString = new JSONObject(localHashMap).toString();
            new e.a().j(parame).agU(paramAnonymousString).b(e.this.pei.ahn(paramString));
            e.this.pei.remove(paramString);
            AppMethodBeat.o(144209);
            return;
            if (!Util.isNullOrNil(paramAnonymousString)) {
              localHashMap.put("reason", paramAnonymousString);
            }
          }
        }
        
        public final void aii(String paramAnonymousString)
        {
          AppMethodBeat.i(144207);
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", aa.ank(paramAnonymousString));
          localHashMap.put("isBuffer", Boolean.FALSE);
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "message");
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().j(parame).agU(paramAnonymousString).b(e.this.pei.ahn(paramString));
          AppMethodBeat.o(144207);
        }
        
        public final void h(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(144208);
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("data", paramAnonymousByteBuffer);
          localHashMap.put("isBuffer", Boolean.TRUE);
          localHashMap.put("state", "message");
          paramAnonymousByteBuffer = (z.a)parame.au(z.a.class);
          paramAnonymousByteBuffer = z.a(parame.getJsRuntime(), localHashMap, paramAnonymousByteBuffer);
          if (paramAnonymousByteBuffer == z.b.rjc)
          {
            paramAnonymousByteBuffer = new JSONObject(localHashMap).toString();
            new e.a().j(parame).agU(paramAnonymousByteBuffer).b(e.this.pei.ahn(paramString));
            AppMethodBeat.o(144208);
            return;
          }
          if (paramAnonymousByteBuffer == z.b.rjd) {
            z.n(parame, "onSocketTaskStateChange");
          }
          AppMethodBeat.o(144208);
        }
      };
      localObject3 = paramJSONObject.optString("url");
      if (!Util.isNullOrNil((String)localObject3)) {
        break;
      }
      Log.i("MicroMsg.JsApiCreateSocketTask", "url is null");
      b(parame, paramString, "url is null");
      AppMethodBeat.o(179501);
      return;
      label285:
      Log.d("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
    }
    Log.i("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", new Object[] { Boolean.valueOf(bool), localObject3 });
    Object localObject4 = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
    Map localMap = j.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.s.a)localObject4);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (final boolean bool = false; (bool) && (!j.a(((com.tencent.mm.plugin.appbrand.s.a)localObject4).cxB, (String)localObject3, ((com.tencent.mm.plugin.appbrand.s.a)localObject4).cxu)); bool = ((com.tencent.mm.plugin.appbrand.s.a)localObject4).qim)
    {
      Log.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { localObject3 });
      b(parame, paramString, "url not in domain list");
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
      localObject2.a(parame.getAppId(), paramString, this.pep, i, paramJSONObject, localMap, (d.a)localObject1);
      if ((this.peq) || (this.per)) {
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 10L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { localObject3, Integer.valueOf(parame.getComponentId()) });
        AppMethodBeat.o(179501);
        return;
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 0L, 1L, false);
      }
      i = 60000;
    }
  }
  
  public final String aBF()
  {
    return "socketTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(144212);
    Object localObject = new StringBuilder();
    l.cbW();
    localObject = l.cbN();
    AppMethodBeat.o(144212);
    return localObject;
  }
  
  public static class a
    extends az
  {
    public static final int CTRL_INDEX = 348;
    public static final String NAME = "onSocketTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.e
 * JD-Core Version:    0.7.0.1
 */