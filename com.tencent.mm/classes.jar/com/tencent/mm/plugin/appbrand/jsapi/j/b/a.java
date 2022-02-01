package com.tencent.mm.plugin.appbrand.jsapi.j.b;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.p.d;
import com.tencent.mm.plugin.appbrand.p.d.a;
import com.tencent.mm.plugin.appbrand.p.d.b;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.p.j;
import com.tencent.mm.plugin.appbrand.p.o;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.appbrand.jsapi.j.e
{
  public static int kBb = 0;
  public static int kBc = 1;
  private com.tencent.mm.plugin.appbrand.jsapi.j.a kAW;
  private d.b kBA;
  private boolean kBB;
  private boolean kBC;
  private int kBd;
  private final AtomicBoolean kBg;
  
  public a(int paramInt, d.b paramb, com.tencent.mm.plugin.appbrand.jsapi.j.a parama)
  {
    AppMethodBeat.i(199906);
    this.kBd = kBb;
    this.kBB = false;
    this.kBC = false;
    this.kBg = new AtomicBoolean(false);
    ac.i("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kBd = paramInt;
    this.kBA = paramb;
    this.kAW = parama;
    AppMethodBeat.o(199906);
  }
  
  private final void a(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179526);
    ac.w("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).LO(paramString2).a(this.kAW.MJ(paramString1));
    this.kAW.remove(paramString1);
    AppMethodBeat.o(179526);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179525);
    ac.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    if (!this.kBg.getAndSet(true))
    {
      if (this.kBA != null)
      {
        this.kBB = this.kBA.aUI();
        this.kBC = this.kBA.aUH();
      }
      if ((this.kBB) || (this.kBC))
      {
        localObject = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
        if (localObject != null) {
          break label171;
        }
        ac.e("MicroMsg.BaseCreateRequestTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
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
          Object localObject1 = (c)this.kyK.get();
          if (localObject1 == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.p.a)((c)localObject1).ar(com.tencent.mm.plugin.appbrand.p.a.class)).ccb)
            {
              AppMethodBeat.o(179522);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            localObject1 = new m();
            ((m)localObject1).cYH.cYI = "request";
            ((m)localObject1).cYH.cYK = paramAnonymousJSONObject;
            ((m)localObject1).cYH.cYJ = this.kBE;
            com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("requestTaskId", this.kBE);
          ((Map)localObject2).put("state", "headersReceived");
          ((Map)localObject2).put("header", paramAnonymousJSONObject);
          paramAnonymousJSONObject = new a.a();
          localObject2 = new JSONObject((Map)localObject2).toString();
          paramAnonymousJSONObject.h((c)localObject1).LO((String)localObject2).a(a.a(a.this).MJ(this.kBE));
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
            c localc = (c)this.kyK.get();
            ac.i("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.kBD), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt), this.kBE, localc });
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
              Object localObject = f.bpj().Pj(localc.getAppId());
              if ((localObject != null) && (((d)localObject).Pe(this.kBE)))
              {
                ac.d("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.kBE });
                AppMethodBeat.o(179521);
                return;
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestTaskId", this.kBE);
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
                paramAnonymousJSONObject = v.a(localc.aUV(), (Map)localObject, (v.a)localc.ar(v.a.class));
                if (((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String))) && (paramAnonymousJSONObject != v.b.moG)) {
                  break label422;
                }
                paramAnonymousObject = new JSONObject((Map)localObject).toString();
                paramAnonymousString.h(localc).LO(paramAnonymousObject).a(a.a(a.this).MJ(this.kBE));
              }
              for (;;)
              {
                a.a(a.this).remove(this.kBE);
                AppMethodBeat.o(179521);
                return;
                ((Map)localObject).put("state", "fail");
                break;
                label422:
                if (paramAnonymousJSONObject == v.b.moH) {
                  v.k(localc, "onRequestTaskStateChange");
                }
              }
            }
            i = 0;
          }
        }
        
        public final void dj(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(179520);
          c localc = (c)this.kyK.get();
          long l1 = System.currentTimeMillis();
          long l2 = this.kBD;
          if (paramAnonymousString2 == null) {}
          for (int i = 0;; i = paramAnonymousString2.length())
          {
            ac.i("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i), this.kBE, localc });
            if (localc != null) {
              break;
            }
            AppMethodBeat.o(179520);
            return;
          }
          if ("fail".equals(paramAnonymousString1)) {
            ac.e("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", new Object[] { this.kBE, paramAnonymousString1, paramAnonymousString2 });
          }
          paramAnonymousString1 = f.bpj().Pj(localc.getAppId());
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.Pe(this.kBE)))
          {
            ac.e("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.kBE });
            AppMethodBeat.o(179520);
            return;
          }
          a.a(a.this, localc, this.kBE, paramAnonymousString2);
          ((o)com.tencent.luggage.a.e.L(o.class)).KY(localc.getAppId());
          AppMethodBeat.o(179520);
        }
      };
      str1 = paramJSONObject.optString("url");
      if (!bs.isNullOrNil(str1)) {
        break;
      }
      ac.e("MicroMsg.BaseCreateRequestTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179525);
      return;
      label171:
      ac.i("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.p.a)localObject).lwj), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.p.a)localObject).lwj);
    }
    com.tencent.mm.plugin.appbrand.p.a locala = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    ac.i("MicroMsg.BaseCreateRequestTask", "lm:data configTimeout %d", new Object[] { Integer.valueOf(k) });
    int i = k;
    if (k <= 0)
    {
      i = j.a(locala, 0);
      ac.i("MicroMsg.BaseCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", new Object[] { Integer.valueOf(i) });
    }
    if (i > 0) {
      j = i;
    }
    ac.i("MicroMsg.BaseCreateRequestTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (locala.ccv <= 0) {
      ac.i("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = j.a(paramJSONObject, locala);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.ccE, str1)); bool = locala.lvY)
    {
      ac.i("MicroMsg.BaseCreateRequestTask", "not in domain url %s", new Object[] { str1 });
      a(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179525);
      return;
    }
    d locald;
    if (f.bpj().Pj(paramc.getAppId()) == null)
    {
      locald = new d(paramc, this.kBd, this.kBB, this.kBC);
      f localf = f.bpj();
      String str2 = paramc.getAppId();
      localObject = locald;
      if (!localf.lwt.containsKey(str2)) {
        localf.lwt.put(str2, locald);
      }
    }
    for (Object localObject = locald;; localObject = f.bpj().Pj(paramc.getAppId()))
    {
      ac.i("MicroMsg.BaseCreateRequestTask", "request url: %s", new Object[] { str1 });
      if (localObject == null) {
        break label613;
      }
      if (bool) {
        break;
      }
      ac.i("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
      ((d)localObject).a(paramc, j, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
      AppMethodBeat.o(179525);
      return;
    }
    ((d)localObject).a(paramc, j, paramJSONObject, localMap, locala.ccE, local1, paramString, "createRequestTask");
    AppMethodBeat.o(179525);
    return;
    label613:
    a(paramc, paramString, "create request error");
    AppMethodBeat.o(179525);
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(179524);
    Object localObject = new StringBuilder();
    f.bpj();
    localObject = f.bpf();
    AppMethodBeat.o(179524);
    return localObject;
  }
  
  public final String acf()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.b.a
 * JD-Core Version:    0.7.0.1
 */