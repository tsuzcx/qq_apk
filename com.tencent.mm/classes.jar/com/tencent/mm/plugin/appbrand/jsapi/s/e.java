package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.q;
import com.tencent.mm.plugin.appbrand.ah.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.t.j;
import com.tencent.mm.plugin.appbrand.t.j.a;
import com.tencent.mm.plugin.appbrand.t.j.c;
import com.tencent.mm.plugin.appbrand.t.k;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.plugin.appbrand.utils.ae.a;
import com.tencent.mm.plugin.appbrand.utils.ae.b;
import com.tencent.mm.plugin.appbrand.utils.af;
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
  private static j.a sjB;
  public static int sjD = 0;
  public static int sjE = 1;
  private j.c sjC;
  private int sjF;
  private boolean sjG;
  private boolean sjH;
  private final AtomicBoolean sjI;
  
  public e(int paramInt, j.c paramc)
  {
    AppMethodBeat.i(144211);
    this.sjF = sjD;
    this.sjG = false;
    this.sjH = false;
    this.sjI = new AtomicBoolean(false);
    Log.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.sjF = paramInt;
    this.sjC = paramc;
    AppMethodBeat.o(144211);
  }
  
  private static JSONObject a(com.tencent.mm.plugin.appbrand.ah.e.f paramf)
  {
    AppMethodBeat.i(144215);
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.cOu();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.agT(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      Log.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
      AppMethodBeat.o(144215);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, com.tencent.mm.plugin.appbrand.b.b paramb, String paramString2, e parame)
  {
    AppMethodBeat.i(327281);
    if ((paramb == com.tencent.mm.plugin.appbrand.b.b.qKy) || (paramb == com.tencent.mm.plugin.appbrand.b.b.qKz))
    {
      paramString1 = k.cCp().aeh(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(327281);
        return;
      }
      paramString1.a(paramString1.act(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new a().i(paramf).ZR(paramString1).b(parame.sjy.aak(paramString2));
      parame.sjy.remove(paramString2);
    }
    AppMethodBeat.o(327281);
  }
  
  public static void a(j.a parama)
  {
    sjB = parama;
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
      new a().i(paramf).ZR(paramString2).b(this.sjy.aak(paramString1));
      Log.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString2 });
      ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 3L, 1L, false);
      AppMethodBeat.o(144216);
      return;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(179501);
    if (!this.sjI.getAndSet(true))
    {
      if (this.sjC != null)
      {
        this.sjG = this.sjC.UG(paramf.getAppId());
        localObject1 = this.sjC;
        paramf.getAppId();
        this.sjH = ((j.c)localObject1).cdI();
      }
      WcWss.cxB();
    }
    Object localObject1 = k.cCp().aeh(paramf.getAppId());
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (((this.sjF != sjD) || (!this.sjG)) && ((this.sjF != sjE) || (!this.sjH) || ((this.sjy.aak(paramString) != null) && (!(this.sjy.aak(paramString) instanceof com.tencent.mm.plugin.appbrand.n.i))))) {
        break label285;
      }
    }
    Object localObject3;
    for (localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class));; localObject1 = new j((com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class)))
    {
      localObject3 = k.cCp();
      localObject4 = paramf.getAppId();
      localObject2 = localObject1;
      if (!((k)localObject3).tnt.containsKey(localObject4))
      {
        ((k)localObject3).tnt.put(localObject4, localObject1);
        localObject2 = localObject1;
      }
      bool = paramJSONObject.optBoolean("enableProfile", true);
      localObject1 = new d.a()
      {
        boolean sjJ = false;
        
        public final void Yf(String paramAnonymousString)
        {
          AppMethodBeat.i(144206);
          if (this.sjJ)
          {
            Log.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
            AppMethodBeat.o(144206);
            return;
          }
          this.sjJ = true;
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "error");
          localHashMap.put("errMsg", paramAnonymousString);
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().i(paramf).ZR(paramAnonymousString).b(e.this.sjy.aak(paramString));
          e.this.sjy.remove(paramString);
          if ((e.a(e.this)) || (e.b(e.this)))
          {
            ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 2L, 1L, false);
            AppMethodBeat.o(144206);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 1L, 1L, false);
          AppMethodBeat.o(144206);
        }
        
        public final void Yg(String paramAnonymousString)
        {
          AppMethodBeat.i(144210);
          e.a(e.this, paramf, paramString, paramAnonymousString);
          AppMethodBeat.o(144210);
        }
        
        public final void a(com.tencent.mm.plugin.appbrand.ah.e.a paramAnonymousa)
        {
          AppMethodBeat.i(144205);
          if ((paramAnonymousa == null) || (!((com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class)).eoX))
          {
            AppMethodBeat.o(144205);
            return;
          }
          q localq = new q();
          localq.hzo.hzp = "socket";
          localq.hzo.hzr = e.b(paramAnonymousa);
          localq.hzo.hzq = paramString;
          localq.publish();
          AppMethodBeat.o(144205);
        }
        
        public final void a(h paramAnonymoush, Map<String, String> paramAnonymousMap)
        {
          AppMethodBeat.i(175385);
          if (e.ctr() != null) {
            e.ctr().a(paramf, paramString, e.this);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "open");
          localHashMap.put("header", e.b(paramAnonymoush));
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0) && (bool)) {
            localHashMap.put("profile", paramAnonymousMap);
          }
          paramAnonymoush = new JSONObject(localHashMap).toString();
          new e.a().i(paramf).ZR(paramAnonymoush).b(e.this.sjy.aak(paramString));
          AppMethodBeat.o(175385);
        }
        
        public final void abg(String paramAnonymousString)
        {
          AppMethodBeat.i(144207);
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", af.agE(paramAnonymousString));
          localHashMap.put("isBuffer", Boolean.FALSE);
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("state", "message");
          paramAnonymousString = new JSONObject(localHashMap).toString();
          new e.a().i(paramf).ZR(paramAnonymousString).b(e.this.sjy.aak(paramString));
          AppMethodBeat.o(144207);
        }
        
        public final void ap(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(144209);
          if (e.ctr() != null) {
            e.ctr().d(paramf, paramString);
          }
          HashMap localHashMap = new HashMap();
          if (com.tencent.mm.plugin.appbrand.t.i.b(paramf.getAppState())) {
            localHashMap.put("reason", "interrupted");
          }
          for (;;)
          {
            localHashMap.put("code", Integer.valueOf(paramAnonymousInt));
            localHashMap.put("socketTaskId", paramString);
            localHashMap.put("state", "close");
            paramAnonymousString = new JSONObject(localHashMap).toString();
            new e.a().i(paramf).ZR(paramAnonymousString).b(e.this.sjy.aak(paramString));
            e.this.sjy.remove(paramString);
            AppMethodBeat.o(144209);
            return;
            if (!Util.isNullOrNil(paramAnonymousString)) {
              localHashMap.put("reason", paramAnonymousString);
            }
          }
        }
        
        public final void n(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(144208);
          HashMap localHashMap = new HashMap();
          localHashMap.put("socketTaskId", paramString);
          localHashMap.put("data", paramAnonymousByteBuffer);
          localHashMap.put("isBuffer", Boolean.TRUE);
          localHashMap.put("state", "message");
          paramAnonymousByteBuffer = (ae.a)paramf.aN(ae.a.class);
          paramAnonymousByteBuffer = ae.a(paramf.getJsRuntime(), localHashMap, paramAnonymousByteBuffer);
          if (paramAnonymousByteBuffer == ae.b.urr)
          {
            paramAnonymousByteBuffer = new JSONObject(localHashMap).toString();
            new e.a().i(paramf).ZR(paramAnonymousByteBuffer).b(e.this.sjy.aak(paramString));
            AppMethodBeat.o(144208);
            return;
          }
          if (paramAnonymousByteBuffer == ae.b.urs) {
            ae.m(paramf, "onSocketTaskStateChange");
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
    Object localObject4 = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
    Map localMap = com.tencent.mm.plugin.appbrand.t.i.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.t.a)localObject4);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (final boolean bool = false; (bool) && (!com.tencent.mm.plugin.appbrand.t.i.a(((com.tencent.mm.plugin.appbrand.t.a)localObject4).epV, (String)localObject3, ((com.tencent.mm.plugin.appbrand.t.a)localObject4).epM)); bool = ((com.tencent.mm.plugin.appbrand.t.a)localObject4).tmY)
    {
      Log.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { localObject3 });
      b(paramf, paramString, "url not in domain list");
      AppMethodBeat.o(179501);
      return;
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = com.tencent.mm.plugin.appbrand.t.i.a((com.tencent.mm.plugin.appbrand.t.a)localObject4, 1);
    }
    if (i > 0) {}
    for (;;)
    {
      localObject2.a(paramf.getAppId(), paramString, this.sjF, i, paramJSONObject, localMap, (d.a)localObject1);
      if ((this.sjG) || (this.sjH)) {
        ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 10L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { localObject3, Integer.valueOf(paramf.getComponentId()) });
        AppMethodBeat.o(179501);
        return;
        ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 0L, 1L, false);
      }
      i = 60000;
    }
  }
  
  public final String aUD()
  {
    return "socketTaskId";
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(144212);
    Object localObject = new StringBuilder();
    k.cCp();
    localObject = k.cCg();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.e
 * JD-Core Version:    0.7.0.1
 */