package com.tencent.mm.plugin.appbrand.jsapi.m.b;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.d;
import com.tencent.mm.plugin.appbrand.o.d.a;
import com.tencent.mm.plugin.appbrand.o.d.b;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.o.o;
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
  implements h
{
  public static int kXi = 0;
  public static int kXj = 1;
  private d.b kXH;
  private boolean kXI;
  private boolean kXJ;
  private com.tencent.mm.plugin.appbrand.jsapi.base.a kXd;
  private int kXk;
  private final AtomicBoolean kXn;
  
  public a(int paramInt, d.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(187748);
    this.kXk = kXi;
    this.kXI = false;
    this.kXJ = false;
    this.kXn = new AtomicBoolean(false);
    ad.i("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kXk = paramInt;
    this.kXH = paramb;
    this.kXd = parama;
    AppMethodBeat.o(187748);
  }
  
  private final void b(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179526);
    ad.w("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).Pi(paramString2).a(this.kXd.Pq(paramString1));
    this.kXd.remove(paramString1);
    AppMethodBeat.o(179526);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179525);
    ad.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    if (!this.kXn.getAndSet(true))
    {
      if (this.kXH != null)
      {
        this.kXI = this.kXH.aXU();
        this.kXJ = this.kXH.aXT();
      }
      if ((this.kXI) || (this.kXJ))
      {
        localObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
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
          Object localObject1 = (c)this.kUU.get();
          if (localObject1 == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.o.a)((c)localObject1).ar(com.tencent.mm.plugin.appbrand.o.a.class)).cms)
            {
              AppMethodBeat.o(179522);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            localObject1 = new m();
            ((m)localObject1).djZ.dka = "request";
            ((m)localObject1).djZ.dkc = paramAnonymousJSONObject;
            ((m)localObject1).djZ.dkb = this.kXL;
            com.tencent.mm.sdk.b.a.IbL.l((b)localObject1);
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("requestTaskId", this.kXL);
          ((Map)localObject2).put("state", "headersReceived");
          ((Map)localObject2).put("header", paramAnonymousJSONObject);
          paramAnonymousJSONObject = new a.a();
          localObject2 = new JSONObject((Map)localObject2).toString();
          paramAnonymousJSONObject.h((c)localObject1).Pi((String)localObject2).a(a.a(a.this).Pq(this.kXL));
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
            c localc = (c)this.kUU.get();
            ad.i("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.kXK), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt), this.kXL, localc });
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
              Object localObject = f.bti().SM(localc.getAppId());
              if ((localObject != null) && (((d)localObject).SG(this.kXL)))
              {
                ad.d("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.kXL });
                AppMethodBeat.o(179521);
                return;
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestTaskId", this.kXL);
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
                paramAnonymousJSONObject = v.a(localc.aYh(), (Map)localObject, (v.a)localc.ar(v.a.class));
                if (((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String))) && (paramAnonymousJSONObject != v.b.mPi)) {
                  break label422;
                }
                paramAnonymousObject = new JSONObject((Map)localObject).toString();
                paramAnonymousString.h(localc).Pi(paramAnonymousObject).a(a.a(a.this).Pq(this.kXL));
              }
              for (;;)
              {
                a.a(a.this).remove(this.kXL);
                AppMethodBeat.o(179521);
                return;
                ((Map)localObject).put("state", "fail");
                break;
                label422:
                if (paramAnonymousJSONObject == v.b.mPj) {
                  v.l(localc, "onRequestTaskStateChange");
                }
              }
            }
            i = 0;
          }
        }
        
        public final void dl(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(179520);
          c localc = (c)this.kUU.get();
          long l1 = System.currentTimeMillis();
          long l2 = this.kXK;
          if (paramAnonymousString2 == null) {}
          for (int i = 0;; i = paramAnonymousString2.length())
          {
            ad.i("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i), this.kXL, localc });
            if (localc != null) {
              break;
            }
            AppMethodBeat.o(179520);
            return;
          }
          if ("fail".equals(paramAnonymousString1)) {
            ad.e("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", new Object[] { this.kXL, paramAnonymousString1, paramAnonymousString2 });
          }
          paramAnonymousString1 = f.bti().SM(localc.getAppId());
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.SG(this.kXL)))
          {
            ad.e("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.kXL });
            AppMethodBeat.o(179520);
            return;
          }
          a.a(a.this, localc, this.kXL, paramAnonymousString2);
          ((o)e.L(o.class)).Os(localc.getAppId());
          AppMethodBeat.o(179520);
        }
      };
      str1 = paramJSONObject.optString("url");
      if (!bt.isNullOrNil(str1)) {
        break;
      }
      ad.e("MicroMsg.BaseCreateRequestTask", "url is null");
      b(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179525);
      return;
      label171:
      ad.i("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).lVw), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.o.a)localObject).lVw);
    }
    com.tencent.mm.plugin.appbrand.o.a locala = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
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
    if (locala.cmM <= 0) {
      ad.i("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = j.a(paramJSONObject, locala);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cmV, str1)); bool = locala.lVl)
    {
      ad.i("MicroMsg.BaseCreateRequestTask", "not in domain url %s", new Object[] { str1 });
      b(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179525);
      return;
    }
    d locald;
    if (f.bti().SM(paramc.getAppId()) == null)
    {
      locald = new d(paramc, this.kXk, this.kXI, this.kXJ);
      f localf = f.bti();
      String str2 = paramc.getAppId();
      localObject = locald;
      if (!localf.lVG.containsKey(str2)) {
        localf.lVG.put(str2, locald);
      }
    }
    for (Object localObject = locald;; localObject = f.bti().SM(paramc.getAppId()))
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
    ((d)localObject).a(paramc, j, paramJSONObject, localMap, locala.cmV, local1, paramString, "createRequestTask");
    AppMethodBeat.o(179525);
    return;
    label613:
    b(paramc, paramString, "create request error");
    AppMethodBeat.o(179525);
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(179524);
    Object localObject = new StringBuilder();
    f.bti();
    localObject = f.bte();
    AppMethodBeat.o(179524);
    return localObject;
  }
  
  public final String aeJ()
  {
    return "requestTaskId";
  }
  
  public static final class a
    extends at
  {
    public static final int CTRL_INDEX = 244;
    public static final String NAME = "onRequestTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b.a
 * JD-Core Version:    0.7.0.1
 */