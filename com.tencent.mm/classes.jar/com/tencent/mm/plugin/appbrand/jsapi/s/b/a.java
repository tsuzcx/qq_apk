package com.tencent.mm.plugin.appbrand.jsapi.s.b;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.q;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.t.d;
import com.tencent.mm.plugin.appbrand.t.d.a;
import com.tencent.mm.plugin.appbrand.t.d.b;
import com.tencent.mm.plugin.appbrand.t.i;
import com.tencent.mm.plugin.appbrand.t.n;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.plugin.appbrand.utils.ae.a;
import com.tencent.mm.plugin.appbrand.utils.ae.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a
  implements h
{
  public static int sjD = 0;
  public static int sjE = 1;
  private int sjF;
  private final AtomicBoolean sjI;
  private com.tencent.mm.plugin.appbrand.jsapi.base.a sjy;
  private d.b skd;
  private boolean ske;
  private boolean skf;
  private boolean skg;
  
  public a(int paramInt, d.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(327294);
    this.sjF = sjD;
    this.ske = false;
    this.skf = false;
    this.skg = false;
    this.sjI = new AtomicBoolean(false);
    Log.i("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.sjF = paramInt;
    this.skd = paramb;
    this.sjy = parama;
    AppMethodBeat.o(327294);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179525);
    Log.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    if (!this.sjI.getAndSet(true))
    {
      if (this.skd != null)
      {
        localObject = this.skd;
        paramf.getAppId();
        this.ske = ((d.b)localObject).cdJ();
        localObject = this.skd;
        paramf.getAppId();
        this.skf = ((d.b)localObject).cdI();
        localObject = this.skd;
        paramf.getAppId();
        this.skg = ((d.b)localObject).cdK();
      }
      if ((this.ske) || (this.skf))
      {
        localObject = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
        if (localObject != null) {
          break label254;
        }
        Log.e("MicroMsg.BaseCreateRequestTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramf.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    d.a local1;
    String str1;
    for (;;)
    {
      if (this.skg)
      {
        Log.i("MicroMsg.BaseCreateRequestTask", "setUseHttpdns(%b),appId(%s)", new Object[] { Boolean.TRUE, paramf.getAppId() });
        CronetLogic.setUseHttpdns(true);
      }
      local1 = new d.a()
      {
        public final void a(String paramAnonymousString, Object paramAnonymousObject, int paramAnonymousInt, JSONObject paramAnonymousJSONObject, Map paramAnonymousMap1, Map paramAnonymousMap2)
        {
          AppMethodBeat.i(327300);
          int i;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ByteBuffer))) {
            i = ((ByteBuffer)paramAnonymousObject).array().length;
          }
          for (;;)
          {
            com.tencent.mm.plugin.appbrand.jsapi.f localf = (com.tencent.mm.plugin.appbrand.jsapi.f)this.sgS.get();
            Log.i("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.skh), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt), this.ski, localf });
            if (localf == null)
            {
              AppMethodBeat.o(327300);
              return;
              if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String))) {
                i = ((String)paramAnonymousObject).length();
              }
            }
            else
            {
              Object localObject = com.tencent.mm.plugin.appbrand.t.f.cCk().aea(localf.getAppId());
              if ((localObject != null) && (((d)localObject).adU(this.ski)))
              {
                Log.d("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.ski });
                AppMethodBeat.o(327300);
                return;
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestTaskId", this.ski);
              if (paramAnonymousString.equalsIgnoreCase("ok"))
              {
                ((Map)localObject).put("state", "success");
                ((Map)localObject).put("data", paramAnonymousObject);
                if ((paramAnonymousMap1 != null) && (paramAnonymousMap1.size() > 0)) {
                  ((Map)localObject).put("profile", paramAnonymousMap1);
                }
                ((Map)localObject).put("statusCode", Integer.valueOf(paramAnonymousInt));
                if (paramAnonymousJSONObject != null) {
                  ((Map)localObject).put("header", paramAnonymousJSONObject);
                }
                if ((paramAnonymousMap2 != null) && (paramAnonymousMap2.size() > 0))
                {
                  paramAnonymousMap2.put("invokeTime", Long.valueOf(this.skh));
                  paramAnonymousMap2.put("wxlibCallbackTimestamp", Long.valueOf(System.currentTimeMillis()));
                  ((Map)localObject).put("clientInfo", paramAnonymousMap2);
                }
                paramAnonymousString = new a.a();
                paramAnonymousJSONObject = ae.a(localf.getJsRuntime(), (Map)localObject, (ae.a)localf.aN(ae.a.class));
                if (((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String))) && (paramAnonymousJSONObject != ae.b.urr)) {
                  break label481;
                }
                paramAnonymousObject = new JSONObject((Map)localObject).toString();
                paramAnonymousString.i(localf).ZR(paramAnonymousObject).b(a.a(a.this).aak(this.ski));
              }
              for (;;)
              {
                a.a(a.this).remove(this.ski);
                AppMethodBeat.o(327300);
                return;
                ((Map)localObject).put("state", "fail");
                break;
                label481:
                if (paramAnonymousJSONObject == ae.b.urs) {
                  ae.m(localf, "onRequestTaskStateChange");
                }
              }
            }
            i = 0;
          }
        }
        
        public final void b(JSONObject paramAnonymousJSONObject, int paramAnonymousInt)
        {
          AppMethodBeat.i(327302);
          if (paramAnonymousJSONObject == null)
          {
            AppMethodBeat.o(327302);
            return;
          }
          Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.f)this.sgS.get();
          if (localObject1 == null)
          {
            AppMethodBeat.o(327302);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.t.a)((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).aN(com.tencent.mm.plugin.appbrand.t.a.class)).eoX)
            {
              AppMethodBeat.o(327302);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            localObject1 = new q();
            ((q)localObject1).hzo.hzp = "request";
            ((q)localObject1).hzo.hzr = paramAnonymousJSONObject;
            ((q)localObject1).hzo.hzq = this.ski;
            ((q)localObject1).publish();
            AppMethodBeat.o(327302);
            return;
          }
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("requestTaskId", this.ski);
          ((Map)localObject2).put("state", "headersReceived");
          ((Map)localObject2).put("header", paramAnonymousJSONObject);
          ((Map)localObject2).put("statusCode", Integer.valueOf(paramAnonymousInt));
          paramAnonymousJSONObject = new a.a();
          localObject2 = new JSONObject((Map)localObject2).toString();
          paramAnonymousJSONObject.i((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).ZR((String)localObject2).b(a.a(a.this).aak(this.ski));
          AppMethodBeat.o(327302);
        }
        
        public final void eg(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(179520);
          com.tencent.mm.plugin.appbrand.jsapi.f localf = (com.tencent.mm.plugin.appbrand.jsapi.f)this.sgS.get();
          long l1 = System.currentTimeMillis();
          long l2 = this.skh;
          if (paramAnonymousString2 == null) {}
          for (int i = 0;; i = paramAnonymousString2.length())
          {
            Log.i("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i), this.ski, localf });
            if (localf != null) {
              break;
            }
            AppMethodBeat.o(179520);
            return;
          }
          if ("fail".equals(paramAnonymousString1)) {
            Log.e("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", new Object[] { this.ski, paramAnonymousString1, paramAnonymousString2 });
          }
          paramAnonymousString1 = com.tencent.mm.plugin.appbrand.t.f.cCk().aea(localf.getAppId());
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.adU(this.ski)))
          {
            Log.e("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.ski });
            AppMethodBeat.o(179520);
            return;
          }
          a.this.b(localf, this.ski, paramAnonymousString2);
          ((n)e.U(n.class)).YV(localf.getAppId());
          AppMethodBeat.o(179520);
        }
        
        public final void q(Object paramAnonymousObject, long paramAnonymousLong)
        {
          AppMethodBeat.i(327306);
          com.tencent.mm.plugin.appbrand.jsapi.f localf = (com.tencent.mm.plugin.appbrand.jsapi.f)this.sgS.get();
          Log.d("MicroMsg.BaseCreateRequestTask", "onChunkResult, data size: %d, requestTaskId %s, service:%s", new Object[] { Long.valueOf(paramAnonymousLong), this.ski, localf });
          if (localf == null)
          {
            AppMethodBeat.o(327306);
            return;
          }
          Object localObject = com.tencent.mm.plugin.appbrand.t.f.cCk().aea(localf.getAppId());
          if ((localObject != null) && (((d)localObject).adU(this.ski)))
          {
            Log.d("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.ski });
            AppMethodBeat.o(327306);
            return;
          }
          localObject = new HashMap();
          ((Map)localObject).put("requestTaskId", this.ski);
          ((Map)localObject).put("state", "chunked");
          ((Map)localObject).put("data", paramAnonymousObject);
          paramAnonymousObject = new a.a();
          ae.b localb = ae.a(localf.getJsRuntime(), (Map)localObject, (ae.a)localf.aN(ae.a.class));
          if (localb == ae.b.urr)
          {
            localObject = new JSONObject((Map)localObject).toString();
            paramAnonymousObject.i(localf).ZR((String)localObject).b(a.a(a.this).aak(this.ski));
            AppMethodBeat.o(327306);
            return;
          }
          if (localb == ae.b.urs) {
            ae.m(localf, "onRequestTaskStateChange");
          }
          AppMethodBeat.o(327306);
        }
      };
      str1 = paramJSONObject.optString("url");
      if (!Util.isNullOrNil(str1)) {
        break;
      }
      Log.e("MicroMsg.BaseCreateRequestTask", "url is null");
      b(paramf, paramString, "url is null or nil");
      AppMethodBeat.o(179525);
      return;
      label254:
      Log.i("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).tnj), paramf.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.t.a)localObject).tnj);
    }
    com.tencent.mm.plugin.appbrand.t.a locala = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    Log.i("MicroMsg.BaseCreateRequestTask", "lm:data configTimeout %d", new Object[] { Integer.valueOf(k) });
    int i = k;
    if (k <= 0)
    {
      i = i.a(locala, 0);
      Log.i("MicroMsg.BaseCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", new Object[] { Integer.valueOf(i) });
    }
    if (i > 0) {
      j = i;
    }
    Log.i("MicroMsg.BaseCreateRequestTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (locala.epH <= 0) {
      Log.i("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = i.a(paramJSONObject, locala);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!i.c(locala.epU, str1)); bool = locala.tmY)
    {
      Log.i("MicroMsg.BaseCreateRequestTask", "not in domain url %s", new Object[] { str1 });
      b(paramf, paramString, "url not in domain list");
      AppMethodBeat.o(179525);
      return;
    }
    d locald;
    if (com.tencent.mm.plugin.appbrand.t.f.cCk().aea(paramf.getAppId()) == null)
    {
      locald = new d(paramf, this.sjF, this.ske, this.skf);
      com.tencent.mm.plugin.appbrand.t.f localf = com.tencent.mm.plugin.appbrand.t.f.cCk();
      String str2 = paramf.getAppId();
      localObject = locald;
      if (!localf.tnt.containsKey(str2)) {
        localf.tnt.put(str2, locald);
      }
    }
    for (Object localObject = locald;; localObject = com.tencent.mm.plugin.appbrand.t.f.cCk().aea(paramf.getAppId()))
    {
      Log.i("MicroMsg.BaseCreateRequestTask", "request url: %s", new Object[] { str1 });
      if (localObject == null) {
        break label694;
      }
      if (bool) {
        break;
      }
      Log.i("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
      ((d)localObject).a(paramf, j, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
      AppMethodBeat.o(179525);
      return;
    }
    ((d)localObject).a(paramf, j, paramJSONObject, localMap, locala.epU, local1, paramString, "createRequestTask");
    AppMethodBeat.o(179525);
    return;
    label694:
    b(paramf, paramString, "create request error");
    AppMethodBeat.o(179525);
  }
  
  public final String aUD()
  {
    return "requestTaskId";
  }
  
  final void b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179526);
    Log.w("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().i(paramf).ZR(paramString2).b(this.sjy.aak(paramString1));
    AppMethodBeat.o(179526);
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179524);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.t.f.cCk();
    localObject = com.tencent.mm.plugin.appbrand.t.f.cCg();
    AppMethodBeat.o(179524);
    return localObject;
  }
  
  public static final class a
    extends bc
  {
    public static final int CTRL_INDEX = 244;
    public static final String NAME = "onRequestTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.a
 * JD-Core Version:    0.7.0.1
 */