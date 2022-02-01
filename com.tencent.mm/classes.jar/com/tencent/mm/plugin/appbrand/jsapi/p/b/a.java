package com.tencent.mm.plugin.appbrand.jsapi.p.b;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.d.a;
import com.tencent.mm.plugin.appbrand.s.d.b;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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
  public static int pen = 0;
  public static int peo = 1;
  private d.b peM;
  private boolean peN;
  private boolean peO;
  private boolean peP;
  private com.tencent.mm.plugin.appbrand.jsapi.base.a pei;
  private int pep;
  private final AtomicBoolean pes;
  
  public a(int paramInt, d.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(186750);
    this.pep = pen;
    this.peN = false;
    this.peO = false;
    this.peP = false;
    this.pes = new AtomicBoolean(false);
    Log.i("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.pep = paramInt;
    this.peM = paramb;
    this.pei = parama;
    AppMethodBeat.o(186750);
  }
  
  private final void b(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179526);
    Log.w("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().j(parame).agU(paramString2).b(this.pei.ahn(paramString1));
    this.pei.remove(paramString1);
    AppMethodBeat.o(179526);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179525);
    Log.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    if (!this.pes.getAndSet(true))
    {
      if (this.peM != null)
      {
        localObject = this.peM;
        parame.getAppId();
        this.peN = ((d.b)localObject).bEx();
        localObject = this.peM;
        parame.getAppId();
        this.peO = ((d.b)localObject).bEw();
        localObject = this.peM;
        parame.getAppId();
        this.peP = ((d.b)localObject).bEy();
      }
      if ((this.peN) || (this.peO))
      {
        localObject = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
        if (localObject != null) {
          break label254;
        }
        Log.e("MicroMsg.BaseCreateRequestTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { parame.getAppId() });
        CronetLogic.setUserCertVerify(false);
      }
    }
    d.a local1;
    String str1;
    for (;;)
    {
      if (this.peP)
      {
        Log.i("MicroMsg.BaseCreateRequestTask", "setUseHttpdns(%b),appId(%s)", new Object[] { Boolean.TRUE, parame.getAppId() });
        CronetLogic.setUseHttpdns(true);
      }
      local1 = new d.a()
      {
        public final void M(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(179522);
          if (paramAnonymousJSONObject == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.e)this.pbE.get();
          if (localObject1 == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.s.a)((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).au(com.tencent.mm.plugin.appbrand.s.a.class)).cwS)
            {
              AppMethodBeat.o(179522);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            localObject1 = new com.tencent.mm.f.a.o();
            ((com.tencent.mm.f.a.o)localObject1).fuU.fuV = "request";
            ((com.tencent.mm.f.a.o)localObject1).fuU.fuX = paramAnonymousJSONObject;
            ((com.tencent.mm.f.a.o)localObject1).fuU.fuW = this.peR;
            EventCenter.instance.publish((IEvent)localObject1);
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("requestTaskId", this.peR);
          ((Map)localObject2).put("state", "headersReceived");
          ((Map)localObject2).put("header", paramAnonymousJSONObject);
          paramAnonymousJSONObject = new a.a();
          localObject2 = new JSONObject((Map)localObject2).toString();
          paramAnonymousJSONObject.j((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).agU((String)localObject2).b(a.a(a.this).ahn(this.peR));
          AppMethodBeat.o(179522);
        }
        
        public final void a(String paramAnonymousString, Object paramAnonymousObject, int paramAnonymousInt, JSONObject paramAnonymousJSONObject, Map paramAnonymousMap1, Map paramAnonymousMap2)
        {
          AppMethodBeat.i(186844);
          int i;
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ByteBuffer))) {
            i = ((ByteBuffer)paramAnonymousObject).array().length;
          }
          for (;;)
          {
            com.tencent.mm.plugin.appbrand.jsapi.e locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.pbE.get();
            Log.i("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.peQ), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt), this.peR, locale });
            if (locale == null)
            {
              AppMethodBeat.o(186844);
              return;
              if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String))) {
                i = ((String)paramAnonymousObject).length();
              }
            }
            else
            {
              Object localObject = f.cbR().akT(locale.getAppId());
              if ((localObject != null) && (((d)localObject).akN(this.peR)))
              {
                Log.d("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.peR });
                AppMethodBeat.o(186844);
                return;
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestTaskId", this.peR);
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
                  paramAnonymousMap2.put("invokeTime", Long.valueOf(this.peQ));
                  paramAnonymousMap2.put("wxlibCallbackTimestamp", Long.valueOf(System.currentTimeMillis()));
                  ((Map)localObject).put("clientInfo", paramAnonymousMap2);
                }
                paramAnonymousString = new a.a();
                paramAnonymousJSONObject = z.a(locale.getJsRuntime(), (Map)localObject, (z.a)locale.au(z.a.class));
                if (((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String))) && (paramAnonymousJSONObject != z.b.rjc)) {
                  break label482;
                }
                paramAnonymousObject = new JSONObject((Map)localObject).toString();
                paramAnonymousString.j(locale).agU(paramAnonymousObject).b(a.a(a.this).ahn(this.peR));
              }
              for (;;)
              {
                a.a(a.this).remove(this.peR);
                AppMethodBeat.o(186844);
                return;
                ((Map)localObject).put("state", "fail");
                break;
                label482:
                if (paramAnonymousJSONObject == z.b.rjd) {
                  z.n(locale, "onRequestTaskStateChange");
                }
              }
            }
            i = 0;
          }
        }
        
        public final void dN(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(179520);
          com.tencent.mm.plugin.appbrand.jsapi.e locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.pbE.get();
          long l1 = System.currentTimeMillis();
          long l2 = this.peQ;
          if (paramAnonymousString2 == null) {}
          for (int i = 0;; i = paramAnonymousString2.length())
          {
            Log.i("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i), this.peR, locale });
            if (locale != null) {
              break;
            }
            AppMethodBeat.o(179520);
            return;
          }
          if ("fail".equals(paramAnonymousString1)) {
            Log.e("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", new Object[] { this.peR, paramAnonymousString1, paramAnonymousString2 });
          }
          paramAnonymousString1 = f.cbR().akT(locale.getAppId());
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.akN(this.peR)))
          {
            Log.e("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.peR });
            AppMethodBeat.o(179520);
            return;
          }
          a.a(a.this, locale, this.peR, paramAnonymousString2);
          ((com.tencent.mm.plugin.appbrand.s.o)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.o.class)).afZ(locale.getAppId());
          AppMethodBeat.o(179520);
        }
      };
      str1 = paramJSONObject.optString("url");
      if (!Util.isNullOrNil(str1)) {
        break;
      }
      Log.e("MicroMsg.BaseCreateRequestTask", "url is null");
      b(parame, paramString, "url is null or nil");
      AppMethodBeat.o(179525);
      return;
      label254:
      Log.i("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).qix), parame.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.s.a)localObject).qix);
    }
    com.tencent.mm.plugin.appbrand.s.a locala = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    Log.i("MicroMsg.BaseCreateRequestTask", "lm:data configTimeout %d", new Object[] { Integer.valueOf(k) });
    int i = k;
    if (k <= 0)
    {
      i = j.a(locala, 0);
      Log.i("MicroMsg.BaseCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", new Object[] { Integer.valueOf(i) });
    }
    if (i > 0) {
      j = i;
    }
    Log.i("MicroMsg.BaseCreateRequestTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (locala.cxp <= 0) {
      Log.i("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = j.a(paramJSONObject, locala);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.b(locala.cxA, str1)); bool = locala.qim)
    {
      Log.i("MicroMsg.BaseCreateRequestTask", "not in domain url %s", new Object[] { str1 });
      b(parame, paramString, "url not in domain list");
      AppMethodBeat.o(179525);
      return;
    }
    d locald;
    if (f.cbR().akT(parame.getAppId()) == null)
    {
      locald = new d(parame, this.pep, this.peN, this.peO);
      f localf = f.cbR();
      String str2 = parame.getAppId();
      localObject = locald;
      if (!localf.qiH.containsKey(str2)) {
        localf.qiH.put(str2, locald);
      }
    }
    for (Object localObject = locald;; localObject = f.cbR().akT(parame.getAppId()))
    {
      Log.i("MicroMsg.BaseCreateRequestTask", "request url: %s", new Object[] { str1 });
      if (localObject == null) {
        break label699;
      }
      if (bool) {
        break;
      }
      Log.i("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
      ((d)localObject).a(parame, j, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
      AppMethodBeat.o(179525);
      return;
    }
    ((d)localObject).a(parame, j, paramJSONObject, localMap, locala.cxA, local1, paramString, "createRequestTask");
    AppMethodBeat.o(179525);
    return;
    label699:
    b(parame, paramString, "create request error");
    AppMethodBeat.o(179525);
  }
  
  public final String aBF()
  {
    return "requestTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179524);
    Object localObject = new StringBuilder();
    f.cbR();
    localObject = f.cbN();
    AppMethodBeat.o(179524);
    return localObject;
  }
  
  public static final class a
    extends az
  {
    public static final int CTRL_INDEX = 244;
    public static final String NAME = "onRequestTaskStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b.a
 * JD-Core Version:    0.7.0.1
 */