package com.tencent.mm.plugin.appbrand.jsapi.o.b;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.d.a;
import com.tencent.mm.plugin.appbrand.s.d.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.plugin.appbrand.utils.x.b;
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
  public static int mgg = 0;
  public static int mgh = 1;
  private d.b mgG;
  private boolean mgH;
  private boolean mgI;
  private boolean mgJ;
  private com.tencent.mm.plugin.appbrand.jsapi.base.a mgb;
  private int mgi;
  private final AtomicBoolean mgl;
  
  public a(int paramInt, d.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
  {
    AppMethodBeat.i(207096);
    this.mgi = mgg;
    this.mgH = false;
    this.mgI = false;
    this.mgJ = false;
    this.mgl = new AtomicBoolean(false);
    Log.i("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.mgi = paramInt;
    this.mgG = paramb;
    this.mgb = parama;
    AppMethodBeat.o(207096);
  }
  
  private final void b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(179526);
    Log.w("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a().h(paramf).Zh(paramString2).a(this.mgb.Zz(paramString1));
    this.mgb.remove(paramString1);
    AppMethodBeat.o(179526);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179525);
    Log.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    if (!this.mgl.getAndSet(true))
    {
      if (this.mgG != null)
      {
        localObject = this.mgG;
        paramf.getAppId();
        this.mgH = ((d.b)localObject).btA();
        localObject = this.mgG;
        paramf.getAppId();
        this.mgI = ((d.b)localObject).btz();
        localObject = this.mgG;
        paramf.getAppId();
        this.mgJ = ((d.b)localObject).btB();
      }
      if ((this.mgH) || (this.mgI))
      {
        localObject = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
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
      if (this.mgJ)
      {
        Log.i("MicroMsg.BaseCreateRequestTask", "setUseHttpdns(%b),appId(%s)", new Object[] { Boolean.TRUE, paramf.getAppId() });
        CronetLogic.setUseHttpdns(true);
      }
      local1 = new d.a()
      {
        public final void J(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(179522);
          if (paramAnonymousJSONObject == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.f)this.mdM.get();
          if (localObject1 == null)
          {
            AppMethodBeat.o(179522);
            return;
          }
          if (paramAnonymousJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
          {
            if (!((com.tencent.mm.plugin.appbrand.s.a)((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).av(com.tencent.mm.plugin.appbrand.s.a.class)).cyp)
            {
              AppMethodBeat.o(179522);
              return;
            }
            paramAnonymousJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
            localObject1 = new n();
            ((n)localObject1).dCn.dCo = "request";
            ((n)localObject1).dCn.dCq = paramAnonymousJSONObject;
            ((n)localObject1).dCn.dCp = this.mgL;
            EventCenter.instance.publish((IEvent)localObject1);
            AppMethodBeat.o(179522);
            return;
          }
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("requestTaskId", this.mgL);
          ((Map)localObject2).put("state", "headersReceived");
          ((Map)localObject2).put("header", paramAnonymousJSONObject);
          paramAnonymousJSONObject = new a.a();
          localObject2 = new JSONObject((Map)localObject2).toString();
          paramAnonymousJSONObject.h((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).Zh((String)localObject2).a(a.a(a.this).Zz(this.mgL));
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
            com.tencent.mm.plugin.appbrand.jsapi.f localf = (com.tencent.mm.plugin.appbrand.jsapi.f)this.mdM.get();
            Log.i("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.mgK), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt), this.mgL, localf });
            if (localf == null)
            {
              AppMethodBeat.o(179521);
              return;
              if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String))) {
                i = ((String)paramAnonymousObject).length();
              }
            }
            else
            {
              Object localObject = com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(localf.getAppId());
              if ((localObject != null) && (((d)localObject).acT(this.mgL)))
              {
                Log.d("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.mgL });
                AppMethodBeat.o(179521);
                return;
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestTaskId", this.mgL);
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
                paramAnonymousJSONObject = x.a(localf.getJsRuntime(), (Map)localObject, (x.a)localf.av(x.a.class));
                if (((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String))) && (paramAnonymousJSONObject != x.b.oho)) {
                  break label421;
                }
                paramAnonymousObject = new JSONObject((Map)localObject).toString();
                paramAnonymousString.h(localf).Zh(paramAnonymousObject).a(a.a(a.this).Zz(this.mgL));
              }
              for (;;)
              {
                a.a(a.this).remove(this.mgL);
                AppMethodBeat.o(179521);
                return;
                ((Map)localObject).put("state", "fail");
                break;
                label421:
                if (paramAnonymousJSONObject == x.b.ohp) {
                  x.m(localf, "onRequestTaskStateChange");
                }
              }
            }
            i = 0;
          }
        }
        
        public final void dC(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(179520);
          com.tencent.mm.plugin.appbrand.jsapi.f localf = (com.tencent.mm.plugin.appbrand.jsapi.f)this.mdM.get();
          long l1 = System.currentTimeMillis();
          long l2 = this.mgK;
          if (paramAnonymousString2 == null) {}
          for (int i = 0;; i = paramAnonymousString2.length())
          {
            Log.i("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i), this.mgL, localf });
            if (localf != null) {
              break;
            }
            AppMethodBeat.o(179520);
            return;
          }
          if ("fail".equals(paramAnonymousString1)) {
            Log.e("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", new Object[] { this.mgL, paramAnonymousString1, paramAnonymousString2 });
          }
          paramAnonymousString1 = com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(localf.getAppId());
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.acT(this.mgL)))
          {
            Log.e("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.mgL });
            AppMethodBeat.o(179520);
            return;
          }
          a.a(a.this, localf, this.mgL, paramAnonymousString2);
          ((o)e.N(o.class)).Yl(localf.getAppId());
          AppMethodBeat.o(179520);
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
      Log.i("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).nhO), paramf.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.mm.plugin.appbrand.s.a)localObject).nhO);
    }
    com.tencent.mm.plugin.appbrand.s.a locala = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
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
    if (locala.cyK <= 0) {
      Log.i("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = j.a(paramJSONObject, locala);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {}
    for (boolean bool = false; (bool) && (!j.c(locala.cyT, str1)); bool = locala.nhD)
    {
      Log.i("MicroMsg.BaseCreateRequestTask", "not in domain url %s", new Object[] { str1 });
      b(paramf, paramString, "url not in domain list");
      AppMethodBeat.o(179525);
      return;
    }
    d locald;
    if (com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(paramf.getAppId()) == null)
    {
      locald = new d(paramf, this.mgi, this.mgH, this.mgI);
      com.tencent.mm.plugin.appbrand.s.f localf = com.tencent.mm.plugin.appbrand.s.f.bPA();
      String str2 = paramf.getAppId();
      localObject = locald;
      if (!localf.nhY.containsKey(str2)) {
        localf.nhY.put(str2, locald);
      }
    }
    for (Object localObject = locald;; localObject = com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(paramf.getAppId()))
    {
      Log.i("MicroMsg.BaseCreateRequestTask", "request url: %s", new Object[] { str1 });
      if (localObject == null) {
        break label699;
      }
      if (bool) {
        break;
      }
      Log.i("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
      ((d)localObject).a(paramf, j, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
      AppMethodBeat.o(179525);
      return;
    }
    ((d)localObject).a(paramf, j, paramJSONObject, localMap, locala.cyT, local1, paramString, "createRequestTask");
    AppMethodBeat.o(179525);
    return;
    label699:
    b(paramf, paramString, "create request error");
    AppMethodBeat.o(179525);
  }
  
  public final String auJ()
  {
    return "requestTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179524);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.s.f.bPA();
    localObject = com.tencent.mm.plugin.appbrand.s.f.bPw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b.a
 * JD-Core Version:    0.7.0.1
 */