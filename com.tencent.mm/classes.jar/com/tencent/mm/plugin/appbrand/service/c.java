package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.sdk.b.a.a.e.b;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.n.f;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.sdk.b.a.c.c
  implements f
{
  protected com.tencent.mm.plugin.appbrand.o jez;
  private final com.tencent.mm.plugin.appbrand.r.a.a.o lDe;
  private JSONObject lWy;
  
  static
  {
    AppMethodBeat.i(48309);
    com.tencent.mm.plugin.appbrand.jsruntime.w.bmA();
    AppMethodBeat.o(48309);
  }
  
  public c()
  {
    this(new com.tencent.luggage.sdk.b.a.c.b.a());
    AppMethodBeat.i(48285);
    AppMethodBeat.o(48285);
  }
  
  public c(com.tencent.luggage.sdk.b.a.b.a parama)
  {
    super(parama);
    AppMethodBeat.i(48286);
    this.lWy = null;
    this.lDe = new com.tencent.mm.plugin.appbrand.r.a.a.o();
    if ((bt.eWo()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdX = bool;
      a(e.b.class, new com.tencent.mm.plugin.appbrand.jsapi.j.l());
      a(com.tencent.luggage.sdk.b.a.a.b.class, new com.tencent.mm.plugin.appbrand.jsapi.j.k());
      AppMethodBeat.o(48286);
      return;
    }
  }
  
  private String btY()
  {
    AppMethodBeat.i(48297);
    String str = null;
    if (AppBrandPerformanceManager.d(getRuntime())) {
      str = aSt().HL("WAPerf.js");
    }
    AppMethodBeat.o(48297);
    return str;
  }
  
  public void BE()
  {
    AppMethodBeat.i(48299);
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.QN(getAppId());
    if (localQualitySessionRuntime != null) {
      localQualitySessionRuntime.lVL = bs.eWj();
    }
    super.BE();
    AppMethodBeat.o(48299);
  }
  
  public final boolean Bl()
  {
    AppMethodBeat.i(210160);
    boolean bool = this.ceD.Bl();
    AppMethodBeat.o(210160);
    return bool;
  }
  
  public final void Bz()
  {
    AppMethodBeat.i(48292);
    ac.i("MicroMsg.AppBrandServiceWC", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
    new com.tencent.mm.plugin.appbrand.page.l()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.p A(Map<String, Object> paramAnonymousMap)
      {
        AppMethodBeat.i(48279);
        paramAnonymousMap = new JSONObject(paramAnonymousMap);
        com.tencent.mm.plugin.appbrand.o localo = c.this.getRuntime();
        try
        {
          Object localObject = com.tencent.mm.plugin.appbrand.report.model.d.r((ae)localo.aSA().getCurrentPage().getCurrentPageView());
          int i = ((Integer)((Pair)localObject).first).intValue();
          localObject = (String)((Pair)localObject).second;
          paramAnonymousMap.put("targetAction", i);
          paramAnonymousMap.put("targetPagePath", localObject);
          paramAnonymousMap.put("usedState", ((com.tencent.mm.plugin.appbrand.o)localo).DC().ccl.lRH);
          super.LN(paramAnonymousMap.toString());
          AppMethodBeat.o(48279);
          return this;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", new Object[] { localException });
          }
        }
      }
    }.ak(getRuntime());
    this.ceD.Bz();
    AppMethodBeat.o(48292);
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.p DH()
  {
    AppMethodBeat.i(48303);
    if (!isRunning())
    {
      localp = com.tencent.mm.plugin.appbrand.ad.d.aUO();
      AppMethodBeat.o(48303);
      return localp;
    }
    com.tencent.mm.plugin.appbrand.appstorage.p localp = super.DH();
    AppMethodBeat.o(48303);
    return localp;
  }
  
  public final JSONObject Do()
  {
    AppMethodBeat.i(48295);
    if (this.lWy == null) {
      this.lWy = super.Do();
    }
    JSONObject localJSONObject = com.tencent.luggage.sdk.g.b.f(this.lWy);
    AppMethodBeat.o(48295);
    return localJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.ac.a Ds()
  {
    AppMethodBeat.i(48289);
    com.tencent.mm.plugin.appbrand.ac.a local1 = new com.tencent.mm.plugin.appbrand.ac.a(this)
    {
      public final v aUx()
      {
        AppMethodBeat.i(48278);
        com.tencent.mm.plugin.appbrand.ac.c localc = new com.tencent.mm.plugin.appbrand.ac.c(this.cOi);
        AppMethodBeat.o(48278);
        return localc;
      }
    };
    AppMethodBeat.o(48289);
    return local1;
  }
  
  public final c.b Dt()
  {
    AppMethodBeat.i(48291);
    com.tencent.mm.plugin.appbrand.permission.a locala = new com.tencent.mm.plugin.appbrand.permission.a(getRuntime(), this);
    AppMethodBeat.o(48291);
    return locala;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175077);
    String str = parama.scriptName;
    ac.d("MicroMsg.AppBrandServiceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { getAppId(), str, Boolean.valueOf(paramBoolean) });
    i locali = i.lRE;
    i.a(this, parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if ("WAService.js".equals(str)) {
      if (!isRunning()) {
        break label108;
      }
    }
    label108:
    for (parama = btY();; parama = null)
    {
      if (!bs.isNullOrNil(parama)) {
        com.tencent.mm.plugin.appbrand.utils.q.a(aUV(), parama, new q.a()
        {
          public final void bZ(String paramAnonymousString)
          {
            AppMethodBeat.i(48284);
            ac.e("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Failed");
            AppMethodBeat.o(48284);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            AppMethodBeat.i(48283);
            ac.i("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Success");
            AppMethodBeat.o(48283);
          }
        });
      }
      AppMethodBeat.o(175077);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    AppMethodBeat.i(175079);
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrandServiceWC", "setWindowAndroid, impl==null, appId:%s", new Object[] { getAppId() });
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ca;
      this.lDe.aw(paramc);
      super.a(this.lDe);
      AppMethodBeat.o(175079);
      return;
    }
    if (paramc.compareTo(this.jgX) != 0)
    {
      ac.i("MicroMsg.AppBrandServiceWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, stack:%s", new Object[] { this.jgX, paramc, getAppId(), Log.getStackTraceString(new Throwable()) });
      super.a(paramc);
    }
    AppMethodBeat.o(175079);
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(48298);
    long l3 = 0L;
    long l1;
    long l2;
    if ((paramObject instanceof m.c))
    {
      paramObject = (m.c)paramObject;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramObject.cNs > 0L)
      {
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramObject.cNt > 0L)
        {
          l1 = paramObject.cNs;
          l2 = paramObject.cNt;
        }
      }
    }
    for (paramLong1 = paramObject.flatJSCompileCost;; paramLong1 = l3)
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.btI();
      com.tencent.mm.plugin.appbrand.report.quality.b.a(this, paramString, l1, l2, this.ceD.Bl(), paramLong1);
      AppMethodBeat.o(48298);
      return;
      l1 = paramLong1;
      l2 = paramLong2;
    }
  }
  
  public final ae aTP()
  {
    AppMethodBeat.i(48288);
    ae localae = (ae)super.at(ae.class);
    AppMethodBeat.o(48288);
    return localae;
  }
  
  public final m aUn()
  {
    AppMethodBeat.i(175076);
    m local3 = new m()
    {
      /* Error */
      public final void a(AppBrandRuntime paramAnonymousAppBrandRuntime, boolean paramAnonymousBoolean, JSONObject paramAnonymousJSONObject)
      {
        // Byte code:
        //   0: ldc 26
        //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: aload_1
        //   7: iload_2
        //   8: aload_3
        //   9: invokespecial 34	com/tencent/mm/plugin/appbrand/page/m:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;ZLorg/json/JSONObject;)V
        //   12: aload_3
        //   13: ldc 36
        //   15: aload_0
        //   16: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:lWz	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   19: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/o;
        //   22: invokevirtual 46	com/tencent/luggage/sdk/d/c:DC	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
        //   25: getfield 52	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:ccl	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
        //   28: getfield 57	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
        //   31: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   34: pop
        //   35: aload_0
        //   36: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:lWz	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   39: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/o;
        //   42: invokevirtual 69	com/tencent/mm/plugin/appbrand/o:aTS	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   45: invokevirtual 75	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:CE	()Lorg/json/JSONObject;
        //   48: astore_1
        //   49: aload_1
        //   50: ifnull +11 -> 61
        //   53: aload_3
        //   54: ldc 77
        //   56: aload_1
        //   57: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   60: pop
        //   61: aload_0
        //   62: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:lWz	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   65: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/o;
        //   68: astore 4
        //   70: iload_2
        //   71: ifeq +21 -> 92
        //   74: aload 4
        //   76: aload_3
        //   77: invokestatic 86	com/tencent/mm/plugin/appbrand/report/model/d:b	(Lcom/tencent/mm/plugin/appbrand/o;Lorg/json/JSONObject;)V
        //   80: aload 4
        //   82: aload_3
        //   83: invokestatic 88	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/o;Lorg/json/JSONObject;)V
        //   86: ldc 26
        //   88: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   91: return
        //   92: aload 4
        //   94: aload_3
        //   95: invokestatic 94	com/tencent/mm/plugin/appbrand/report/model/d:c	(Lcom/tencent/mm/plugin/appbrand/o;Lorg/json/JSONObject;)V
        //   98: aload 4
        //   100: aload_3
        //   101: invokestatic 88	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/o;Lorg/json/JSONObject;)V
        //   104: aload 4
        //   106: invokevirtual 98	com/tencent/mm/plugin/appbrand/o:aTT	()Lcom/tencent/mm/plugin/appbrand/page/v;
        //   109: invokevirtual 104	com/tencent/mm/plugin/appbrand/page/v:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/f;
        //   112: invokeinterface 110 1 0
        //   117: invokeinterface 116 1 0
        //   122: getfield 122	com/tencent/mm/plugin/appbrand/report/model/h$a:lSR	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
        //   125: astore_1
        //   126: aload_1
        //   127: ifnonnull +34 -> 161
        //   130: aconst_null
        //   131: astore_1
        //   132: aload_3
        //   133: ldc 124
        //   135: aload_1
        //   136: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   139: pop
        //   140: aload_3
        //   141: ldc 126
        //   143: aload 4
        //   145: invokevirtual 69	com/tencent/mm/plugin/appbrand/o:aTS	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   148: getfield 130	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
        //   151: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
        //   154: pop
        //   155: ldc 26
        //   157: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   160: return
        //   161: aload_1
        //   162: getfield 139	com/tencent/mm/plugin/appbrand/report/model/h$b:path	Ljava/lang/String;
        //   165: astore_1
        //   166: goto -34 -> 132
        //   169: astore_1
        //   170: ldc 141
        //   172: ldc 143
        //   174: iconst_1
        //   175: anewarray 145	java/lang/Object
        //   178: dup
        //   179: iconst_0
        //   180: aload_1
        //   181: aastore
        //   182: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   185: ldc 26
        //   187: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   190: return
        //   191: astore_1
        //   192: goto -131 -> 61
        //   195: astore_1
        //   196: goto -161 -> 35
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	199	0	this	3
        //   0	199	1	paramAnonymousAppBrandRuntime	AppBrandRuntime
        //   0	199	2	paramAnonymousBoolean	boolean
        //   0	199	3	paramAnonymousJSONObject	JSONObject
        //   68	76	4	localo	com.tencent.mm.plugin.appbrand.o
        // Exception table:
        //   from	to	target	type
        //   92	126	169	java/lang/Exception
        //   132	155	169	java/lang/Exception
        //   161	166	169	java/lang/Exception
        //   35	49	191	org/json/JSONException
        //   53	61	191	org/json/JSONException
        //   12	35	195	org/json/JSONException
      }
    };
    AppMethodBeat.o(175076);
    return local3;
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48290);
    this.jez = ((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime);
    if (aSt() == null) {
      a(((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aSt());
    }
    bey();
    super.d(paramAppBrandRuntime);
    AppMethodBeat.o(48290);
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48294);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.DIc));
    c(paramJSONObject, "JSEngineName", com.tencent.mm.plugin.appbrand.jsruntime.w.c(aUV()));
    com.tencent.mm.plugin.appbrand.i.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBN(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBT(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBP(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBS(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBR(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBZ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBV(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBW(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bBX()));
    AppMethodBeat.o(48294);
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48296);
    c(paramJSONObject, "debug", Boolean.valueOf(this.jez.aTR().ccn));
    if (com.tencent.mm.plugin.appbrand.report.quality.a.QN(getAppId()) != null) {
      c(paramJSONObject, "preloadType", Long.valueOf(com.tencent.mm.plugin.appbrand.report.quality.a.QN(getAppId()).btP()));
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject1 = this.jez.aSI();
    c(localJSONObject1, "path", com.tencent.luggage.h.k.cp((String)localObject1));
    c(localJSONObject1, "query", new JSONObject(com.tencent.luggage.h.k.cq((String)localObject1)));
    c(localJSONObject1, "referrerInfo", this.jez.aTS().CG());
    c(localJSONObject1, "shareInfo", this.jez.aTS().CE());
    if (ao.w(this.jez)) {
      localObject1 = "singlePage";
    }
    for (;;)
    {
      c(localJSONObject1, "mode", localObject1);
      com.tencent.mm.plugin.appbrand.report.model.d.b(this.jez, localJSONObject1);
      com.tencent.mm.plugin.appbrand.report.model.d.a(this.jez, paramJSONObject);
      AppBrandSysConfigWC localAppBrandSysConfigWC = this.jez.aTR();
      JSONObject localJSONObject2 = new JSONObject();
      c(localJSONObject2, "maxRequestConcurrent", Integer.valueOf(localAppBrandSysConfigWC.ccv));
      c(localJSONObject2, "maxUploadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.ccw));
      c(localJSONObject2, "maxDownloadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.ccx));
      c(localJSONObject2, "maxWebsocketConnect", Integer.valueOf(localAppBrandSysConfigWC.ccy));
      c(localJSONObject2, "maxWorkerConcurrent", Integer.valueOf(localAppBrandSysConfigWC.ccz));
      try
      {
        localObject1 = paramJSONObject.optJSONObject("env");
        if (localObject1 != null) {
          break label712;
        }
        localObject1 = new JSONObject();
        paramJSONObject.put("env", localObject1);
      }
      catch (Exception localException1)
      {
        label390:
        for (;;)
        {
          Object localObject2;
          label334:
          int i;
        }
      }
      if (ao.w(this.jez))
      {
        localObject2 = "wxfile://singlepage";
        ((JSONObject)localObject1).put("USER_DATA_PATH", localObject2);
        ((JSONObject)localObject1).put("OPEN_DATA_PATH", "wxfile://opendata");
        ((JSONObject)localObject1).put("CLIENT_DATA_PATH", "wxfile://clientdata");
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUF, false) != true) {
          break label654;
        }
        i = 1;
        ((JSONObject)localObject1).put("HAS_SPLASHSCREEN", i);
        c(paramJSONObject, "appLaunchInfo", localJSONObject1);
        c(paramJSONObject, "wxAppInfo", localJSONObject2);
        c(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().aTJ()));
        c(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.sH(this.jez.aTS().joY).name().toLowerCase());
        localObject1 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(this.jez.aTS().cch.jFU);
          localObject1 = localObject2;
        }
        catch (Exception localException3)
        {
          label654:
          continue;
        }
        try
        {
          if (!bs.isNullOrNil(localAppBrandSysConfigWC.cct))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("jsonInfo", new JSONObject(localAppBrandSysConfigWC.cct));
            c((JSONObject)localObject1, "operationInfo", localObject2);
          }
          if (TextUtils.isEmpty(getRuntime().aTS().cci)) {}
        }
        catch (Exception localException2)
        {
          try
          {
            ((JSONObject)localObject1).put("passThroughInfo", new JSONObject(getRuntime().aTS().cci));
            c(paramJSONObject, "appContactInfo", localObject1);
            c(paramJSONObject, "accountInfo", this.jez.aTS().CF());
            c(paramJSONObject, "supportAsyncAudio", Boolean.TRUE);
            super.e(paramJSONObject);
            AppMethodBeat.o(48296);
            return;
            localObject1 = "default";
            break;
            localObject2 = "wxfile://usr";
            break label334;
            i = 0;
            break label390;
            localException2 = localException2;
            ac.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException2 });
          }
          catch (JSONException localJSONException)
          {
            ac.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put passThroughInfo get exception:%s", new Object[] { localJSONException });
          }
        }
      }
    }
  }
  
  public com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(48287);
    Object localObject = this.ceD;
    if ((localObject instanceof b))
    {
      localObject = ((b)localObject).lWv;
      if (localObject != null)
      {
        localObject = ((com.tencent.luggage.game.a.d)localObject).getMagicBrush();
        AppMethodBeat.o(48287);
        return localObject;
      }
      AppMethodBeat.o(48287);
      return null;
    }
    AppMethodBeat.o(48287);
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.o getRuntime()
  {
    AppMethodBeat.i(48302);
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)super.CO();
    AppMethodBeat.o(48302);
    return localo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c
 * JD-Core Version:    0.7.0.1
 */