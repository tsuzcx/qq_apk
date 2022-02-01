package com.tencent.mm.plugin.appbrand.jsapi.j.b;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.d.a;
import com.tencent.mm.plugin.appbrand.q.d.b;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.o;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.appbrand.jsapi.j.e
{
  public static int kao = 0;
  public static int kap = 1;
  private d.b kaN;
  private boolean kaO;
  private boolean kaP;
  private com.tencent.mm.plugin.appbrand.jsapi.j.a kaj;
  private int kaq;
  private final AtomicBoolean kat;
  
  public a(int paramInt, d.b paramb, com.tencent.mm.plugin.appbrand.jsapi.j.a parama)
  {
    AppMethodBeat.i(190827);
    this.kaq = kao;
    this.kaO = false;
    this.kaP = false;
    this.kat = new AtomicBoolean(false);
    ad.i("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kaq = paramInt;
    this.kaN = paramb;
    this.kaj = parama;
    AppMethodBeat.o(190827);
  }
  
  private final void a(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179526);
    ad.w("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).HK(paramString2).a(this.kaj.II(paramString1));
    this.kaj.remove(paramString1);
    AppMethodBeat.o(179526);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179525);
    ad.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    if (!this.kat.getAndSet(true))
    {
      if (this.kaN != null)
      {
        this.kaO = this.kaN.aNS();
        this.kaP = this.kaN.aNR();
      }
      if ((this.kaO) || (this.kaP))
      {
        localObject = (com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class);
        if (localObject != null) {
          break label171;
        }
        ad.e("MicroMsg.BaseCreateRequestTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    d.a local1;
    String str1;
    for (;;)
    {
      local1 = new d.a()
      {
        public final void C(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(179522);
          if (paramAnonymousJSONObject == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject1 = (c)this.jXY.get();
          if (localObject1 == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.q.a)((c)localObject1).ar(com.tencent.mm.plugin.appbrand.q.a.class)).cfe)
            {
              AppMethodBeat.o(179522);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            localObject1 = new m();
            ((m)localObject1).dbl.dbm = "request";
            ((m)localObject1).dbl.dbo = paramAnonymousJSONObject;
            ((m)localObject1).dbl.dbn = this.kaR;
            com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("requestTaskId", this.kaR);
          ((Map)localObject2).put("state", "headersReceived");
          ((Map)localObject2).put("header", paramAnonymousJSONObject);
          paramAnonymousJSONObject = new a.a();
          localObject2 = new JSONObject((Map)localObject2).toString();
          paramAnonymousJSONObject.h((c)localObject1).HK((String)localObject2).a(a.a(a.this).II(this.kaR));
          AppMethodBeat.o(179522);
        }
        
        public final void a(String paramAnonymousString, Object paramAnonymousObject, int paramAnonymousInt, JSONObject paramAnonymousJSONObject, Map paramAnonymousMap)
        {
          AppMethodBeat.i(179521);
          int i;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ByteBuffer))) {
            i = ((ByteBuffer)paramAnonymousObject).array().length;
          }
          for (;;)
          {
            c localc = (c)this.jXY.get();
            ad.i("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.kaQ), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt), this.kaR, localc });
            if (localc == null)
            {
              AppMethodBeat.o(179521);
              return;
              if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String))) {
                i = ((String)paramAnonymousObject).length();
              }
            }
            else
            {
              Object localObject = f.bip().Lb(localc.getAppId());
              if ((localObject != null) && (((d)localObject).KW(this.kaR)))
              {
                ad.d("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.kaR });
                AppMethodBeat.o(179521);
                return;
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestTaskId", this.kaR);
              if (paramAnonymousString.equalsIgnoreCase("ok"))
              {
                ((Map)localObject).put("state", "success");
                ((Map)localObject).put("data", paramAnonymousObject);
                if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0)) {
                  ((Map)localObject).put("profile", paramAnonymousMap);
                }
                ((Map)localObject).put("statusCode", Integer.valueOf(paramAnonymousInt));
                if (paramAnonymousJSONObject != null) {
                  ((Map)localObject).put("header", paramAnonymousJSONObject);
                }
                paramAnonymousString = new a.a();
                paramAnonymousJSONObject = v.a(localc.aOf(), (Map)localObject, (v.a)localc.ar(v.a.class));
                if (((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String))) && (paramAnonymousJSONObject != v.b.lMJ)) {
                  break label422;
                }
                paramAnonymousObject = new JSONObject((Map)localObject).toString();
                paramAnonymousString.h(localc).HK(paramAnonymousObject).a(a.a(a.this).II(this.kaR));
              }
              for (;;)
              {
                a.a(a.this).remove(this.kaR);
                AppMethodBeat.o(179521);
                return;
                ((Map)localObject).put("state", "fail");
                break;
                label422:
                if (paramAnonymousJSONObject == v.b.lMK) {
                  v.k(localc, "onRequestTaskStateChange");
                }
              }
            }
            i = 0;
          }
        }
        
        public final void cX(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(179520);
          c localc = (c)this.jXY.get();
          long l1 = System.currentTimeMillis();
          long l2 = this.kaQ;
          if (paramAnonymousString2 == null) {}
          for (int i = 0;; i = paramAnonymousString2.length())
          {
            ad.i("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i), this.kaR, localc });
            if (localc != null) {
              break;
            }
            AppMethodBeat.o(179520);
            return;
          }
          if ("fail".equals(paramAnonymousString1)) {
            ad.e("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", new Object[] { this.kaR, paramAnonymousString1, paramAnonymousString2 });
          }
          paramAnonymousString1 = f.bip().Lb(localc.getAppId());
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.KW(this.kaR)))
          {
            ad.e("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.kaR });
            AppMethodBeat.o(179520);
            return;
          }
          a.a(a.this, localc, this.kaR, paramAnonymousString2);
          ((o)com.tencent.luggage.a.e.L(o.class)).GU(localc.getAppId());
          AppMethodBeat.o(179520);
        }
      };
      str1 = paramJSONObject.optString("url");
      if (!bt.isNullOrNil(str1)) {
        break;
      }
      ad.e("MicroMsg.BaseCreateRequestTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179525);
      return;
      label171:
      ad.i("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.q.a)localObject).kUz), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.q.a)localObject).kUz);
    }
    com.tencent.mm.plugin.appbrand.q.a locala = (com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class);
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    ad.i("MicroMsg.BaseCreateRequestTask", "lm:data configTimeout %d", new Object[] { Integer.valueOf(k) });
    int i = k;
    if (k <= 0)
    {
      i = j.a(locala, 0);
      ad.i("MicroMsg.BaseCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", new Object[] { Integer.valueOf(i) });
    }
    if (i > 0) {
      j = i;
    }
    ad.i("MicroMsg.BaseCreateRequestTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (locala.cfy <= 0) {
      ad.i("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = j.a(paramJSONObject, locala);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cfH, str1)); bool = locala.kUo)
    {
      ad.i("MicroMsg.BaseCreateRequestTask", "not in domain url %s", new Object[] { str1 });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179525);
      return;
    }
    d locald;
    if (f.bip().Lb(paramc.getAppId()) == null)
    {
      locald = new d(paramc, this.kaq, this.kaO, this.kaP);
      f localf = f.bip();
      String str2 = paramc.getAppId();
      localObject = locald;
      if (!localf.kUJ.containsKey(str2)) {
        localf.kUJ.put(str2, locald);
      }
    }
    for (Object localObject = locald;; localObject = f.bip().Lb(paramc.getAppId()))
    {
      ad.i("MicroMsg.BaseCreateRequestTask", "request url: %s", new Object[] { str1 });
      if (localObject == null) {
        break label613;
      }
      if (bool) {
        break;
      }
      ad.i("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
      ((d)localObject).a(paramc, j, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
      AppMethodBeat.o(179525);
      return;
    }
    ((d)localObject).a(paramc, j, paramJSONObject, localMap, locala.cfH, local1, paramString, "createRequestTask");
    AppMethodBeat.o(179525);
    return;
    label613:
    a(paramc, paramString, "create request error");
    AppMethodBeat.o(179525);
  }
  
  public final String aEB()
  {
    AppMethodBeat.i(179524);
    Object localObject = new StringBuilder();
    f.bip();
    localObject = f.bil();
    AppMethodBeat.o(179524);
    return localObject;
  }
  
  public final String abh()
  {
    return "requestTaskId";
  }
  
  public static final class a
    extends ar
  {
    public static final int CTRL_INDEX = 244;
    public static final String NAME = "onRequestTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.b.a
 * JD-Core Version:    0.7.0.1
 */