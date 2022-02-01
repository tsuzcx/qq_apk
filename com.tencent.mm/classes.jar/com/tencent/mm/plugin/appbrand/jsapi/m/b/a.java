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
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.plugin.appbrand.utils.x.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a
  implements h
{
  public static int laR = 0;
  public static int laS = 1;
  private com.tencent.mm.plugin.appbrand.jsapi.base.a laM;
  private int laT;
  private final AtomicBoolean laW;
  private d.b lbq;
  private boolean lbr;
  private boolean lbs;
  
  public a(int paramInt, d.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(193477);
    this.laT = laR;
    this.lbr = false;
    this.lbs = false;
    this.laW = new AtomicBoolean(false);
    ae.i("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.laT = paramInt;
    this.lbq = paramb;
    this.laM = parama;
    AppMethodBeat.o(193477);
  }
  
  private final void b(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179526);
    ae.w("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramc).PQ(paramString2).a(this.laM.PY(paramString1));
    this.laM.remove(paramString1);
    AppMethodBeat.o(179526);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179525);
    ae.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    if (!this.laW.getAndSet(true))
    {
      if (this.lbq != null)
      {
        this.lbr = this.lbq.aYn();
        this.lbs = this.lbq.aYm();
      }
      if ((this.lbr) || (this.lbs))
      {
        localObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
        if (localObject != null) {
          break label171;
        }
        ae.e("MicroMsg.BaseCreateRequestTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
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
          Object localObject1 = (c)this.kYC.get();
          if (localObject1 == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.o.a)((c)localObject1).ar(com.tencent.mm.plugin.appbrand.o.a.class)).cmu)
            {
              AppMethodBeat.o(179522);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            localObject1 = new m();
            ((m)localObject1).dlb.dlc = "request";
            ((m)localObject1).dlb.dle = paramAnonymousJSONObject;
            ((m)localObject1).dlb.dld = this.lbu;
            com.tencent.mm.sdk.b.a.IvT.l((b)localObject1);
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("requestTaskId", this.lbu);
          ((Map)localObject2).put("state", "headersReceived");
          ((Map)localObject2).put("header", paramAnonymousJSONObject);
          paramAnonymousJSONObject = new a.a();
          localObject2 = new JSONObject((Map)localObject2).toString();
          paramAnonymousJSONObject.h((c)localObject1).PQ((String)localObject2).a(a.a(a.this).PY(this.lbu));
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
            c localc = (c)this.kYC.get();
            ae.i("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.lbt), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt), this.lbu, localc });
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
              Object localObject = f.btT().Tv(localc.getAppId());
              if ((localObject != null) && (((d)localObject).Tp(this.lbu)))
              {
                ae.d("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.lbu });
                AppMethodBeat.o(179521);
                return;
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestTaskId", this.lbu);
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
                paramAnonymousJSONObject = x.a(localc.aYB(), (Map)localObject, (x.a)localc.ar(x.a.class));
                if (((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String))) && (paramAnonymousJSONObject != x.b.mUn)) {
                  break label422;
                }
                paramAnonymousObject = new JSONObject((Map)localObject).toString();
                paramAnonymousString.h(localc).PQ(paramAnonymousObject).a(a.a(a.this).PY(this.lbu));
              }
              for (;;)
              {
                a.a(a.this).remove(this.lbu);
                AppMethodBeat.o(179521);
                return;
                ((Map)localObject).put("state", "fail");
                break;
                label422:
                if (paramAnonymousJSONObject == x.b.mUo) {
                  x.l(localc, "onRequestTaskStateChange");
                }
              }
            }
            i = 0;
          }
        }
        
        public final void dn(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(179520);
          c localc = (c)this.kYC.get();
          long l1 = System.currentTimeMillis();
          long l2 = this.lbt;
          if (paramAnonymousString2 == null) {}
          for (int i = 0;; i = paramAnonymousString2.length())
          {
            ae.i("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i), this.lbu, localc });
            if (localc != null) {
              break;
            }
            AppMethodBeat.o(179520);
            return;
          }
          if ("fail".equals(paramAnonymousString1)) {
            ae.e("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", new Object[] { this.lbu, paramAnonymousString1, paramAnonymousString2 });
          }
          paramAnonymousString1 = f.btT().Tv(localc.getAppId());
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.Tp(this.lbu)))
          {
            ae.e("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.lbu });
            AppMethodBeat.o(179520);
            return;
          }
          a.a(a.this, localc, this.lbu, paramAnonymousString2);
          ((o)e.L(o.class)).Pa(localc.getAppId());
          AppMethodBeat.o(179520);
        }
      };
      str1 = paramJSONObject.optString("url");
      if (!bu.isNullOrNil(str1)) {
        break;
      }
      ae.e("MicroMsg.BaseCreateRequestTask", "url is null");
      b(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(179525);
      return;
      label171:
      ae.i("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).lZZ), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.o.a)localObject).lZZ);
    }
    com.tencent.mm.plugin.appbrand.o.a locala = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    ae.i("MicroMsg.BaseCreateRequestTask", "lm:data configTimeout %d", new Object[] { Integer.valueOf(k) });
    int i = k;
    if (k <= 0)
    {
      i = j.a(locala, 0);
      ae.i("MicroMsg.BaseCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", new Object[] { Integer.valueOf(i) });
    }
    if (i > 0) {
      j = i;
    }
    ae.i("MicroMsg.BaseCreateRequestTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (locala.cmO <= 0) {
      ae.i("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = j.a(paramJSONObject, locala);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cmX, str1)); bool = locala.lZO)
    {
      ae.i("MicroMsg.BaseCreateRequestTask", "not in domain url %s", new Object[] { str1 });
      b(paramc, paramString, "url not in domain list");
      AppMethodBeat.o(179525);
      return;
    }
    d locald;
    if (f.btT().Tv(paramc.getAppId()) == null)
    {
      locald = new d(paramc, this.laT, this.lbr, this.lbs);
      f localf = f.btT();
      String str2 = paramc.getAppId();
      localObject = locald;
      if (!localf.mak.containsKey(str2)) {
        localf.mak.put(str2, locald);
      }
    }
    for (Object localObject = locald;; localObject = f.btT().Tv(paramc.getAppId()))
    {
      ae.i("MicroMsg.BaseCreateRequestTask", "request url: %s", new Object[] { str1 });
      if (localObject == null) {
        break label613;
      }
      if (bool) {
        break;
      }
      ae.i("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
      ((d)localObject).a(paramc, j, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
      AppMethodBeat.o(179525);
      return;
    }
    ((d)localObject).a(paramc, j, paramJSONObject, localMap, locala.cmX, local1, paramString, "createRequestTask");
    AppMethodBeat.o(179525);
    return;
    label613:
    b(paramc, paramString, "create request error");
    AppMethodBeat.o(179525);
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(179524);
    Object localObject = new StringBuilder();
    f.btT();
    localObject = f.btP();
    AppMethodBeat.o(179524);
    return localObject;
  }
  
  public final String aeV()
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