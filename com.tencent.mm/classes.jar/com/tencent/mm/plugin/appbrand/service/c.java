package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.sdk.b.a.a.d.b;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.m.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.sdk.b.a.c.c
  implements com.tencent.mm.plugin.appbrand.m.f
{
  protected com.tencent.mm.plugin.appbrand.p jAF;
  private JSONObject mBk;
  private final o mgY;
  
  static
  {
    AppMethodBeat.i(48309);
    com.tencent.mm.plugin.appbrand.jsruntime.w.bqV();
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
    this.mBk = null;
    this.mgY = new o();
    if ((bv.fpT()) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jAe = bool;
      a(d.b.class, new com.tencent.mm.plugin.appbrand.jsapi.m.j());
      a(com.tencent.luggage.sdk.b.a.a.b.class, new i());
      AppMethodBeat.o(48286);
      return;
    }
  }
  
  private String byW()
  {
    AppMethodBeat.i(48297);
    String str = null;
    if (AppBrandPerformanceManager.e(getRuntime())) {
      str = aWe().LD("WAPerf.js");
    }
    AppMethodBeat.o(48297);
    return str;
  }
  
  public final boolean CN()
  {
    AppMethodBeat.i(224371);
    boolean bool = this.coW.CN();
    AppMethodBeat.o(224371);
    return bool;
  }
  
  public final void Db()
  {
    AppMethodBeat.i(48292);
    ae.i("MicroMsg.AppBrandServiceWC", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
    new com.tencent.mm.plugin.appbrand.page.k()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.p H(Map<String, Object> paramAnonymousMap)
      {
        AppMethodBeat.i(48279);
        paramAnonymousMap = new JSONObject(paramAnonymousMap);
        com.tencent.mm.plugin.appbrand.p localp = c.this.getRuntime();
        try
        {
          Object localObject = com.tencent.mm.plugin.appbrand.report.model.d.t((ad)localp.aWm().getCurrentPage().getCurrentPageView());
          int i = ((Integer)((Pair)localObject).first).intValue();
          localObject = (String)((Pair)localObject).second;
          paramAnonymousMap.put("targetAction", i);
          paramAnonymousMap.put("targetPagePath", localObject);
          paramAnonymousMap.put("usedState", ((com.tencent.mm.plugin.appbrand.p)localp).Fg().cmE.mwv);
          super.PP(paramAnonymousMap.toString());
          AppMethodBeat.o(48279);
          return this;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", new Object[] { localException });
          }
        }
      }
    }.ad(getRuntime());
    this.coW.Db();
    AppMethodBeat.o(48292);
  }
  
  public void Dg()
  {
    AppMethodBeat.i(48299);
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(getAppId());
    if (localQualitySessionRuntime != null) {
      localQualitySessionRuntime.mAy = bu.fpO();
    }
    super.Dg();
    AppMethodBeat.o(48299);
  }
  
  public final JSONObject EP()
  {
    AppMethodBeat.i(48295);
    if (this.mBk != null)
    {
      localJSONObject = com.tencent.luggage.sdk.g.b.f(this.mBk);
      AppMethodBeat.o(48295);
      return localJSONObject;
    }
    JSONObject localJSONObject = super.EP();
    if (getRuntime().getAppConfig().jYP.booleanValue()) {
      this.mBk = com.tencent.luggage.sdk.g.b.f(localJSONObject);
    }
    AppMethodBeat.o(48295);
    return localJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.ab.a ET()
  {
    AppMethodBeat.i(48289);
    com.tencent.mm.plugin.appbrand.ab.a local1 = new com.tencent.mm.plugin.appbrand.ab.a(this)
    {
      public final v aYc()
      {
        AppMethodBeat.i(48278);
        com.tencent.mm.plugin.appbrand.ab.d locald = new com.tencent.mm.plugin.appbrand.ab.d(this.daw);
        AppMethodBeat.o(48278);
        return locald;
      }
    };
    AppMethodBeat.o(48289);
    return local1;
  }
  
  public final c.b EU()
  {
    AppMethodBeat.i(48291);
    com.tencent.mm.plugin.appbrand.permission.a locala = new com.tencent.mm.plugin.appbrand.permission.a(getRuntime(), this);
    AppMethodBeat.o(48291);
    return locala;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.q Fl()
  {
    AppMethodBeat.i(48303);
    if (!isRunning())
    {
      localq = com.tencent.mm.plugin.appbrand.ad.e.aYv();
      AppMethodBeat.o(48303);
      return localq;
    }
    com.tencent.mm.plugin.appbrand.appstorage.q localq = super.Fl();
    AppMethodBeat.o(48303);
    return localq;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175077);
    String str = parama.scriptName;
    ae.d("MicroMsg.AppBrandServiceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { getAppId(), str, Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.appbrand.report.j localj = com.tencent.mm.plugin.appbrand.report.j.mws;
    com.tencent.mm.plugin.appbrand.report.j.a(this, parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if ("WAService.js".equals(str)) {
      if (!isRunning()) {
        break label109;
      }
    }
    label109:
    for (parama = byW();; parama = null)
    {
      if (!bu.isNullOrNil(parama)) {
        s.a(aYB(), parama, new s.a()
        {
          public final void cV(String paramAnonymousString)
          {
            AppMethodBeat.i(48284);
            ae.e("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Failed");
            AppMethodBeat.o(48284);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            AppMethodBeat.i(48283);
            ae.i("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Success");
            AppMethodBeat.o(48283);
          }
        });
      }
      AppMethodBeat.o(175077);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(175079);
    if (paramc == null)
    {
      ae.w("MicroMsg.AppBrandServiceWC", "setWindowAndroid, impl==null, appId:%s", new Object[] { getAppId() });
      paramc = ((h)com.tencent.mm.kernel.g.ajO().ajq()).ca;
      this.mgY.ax(paramc);
      super.a(this.mgY);
      AppMethodBeat.o(175079);
      return;
    }
    if (paramc.compareTo(this.jDa) != 0)
    {
      ae.i("MicroMsg.AppBrandServiceWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, stack:%s", new Object[] { this.jDa, paramc, getAppId(), Log.getStackTraceString(new Throwable()) });
      super.a(paramc);
    }
    AppMethodBeat.o(175079);
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(222974);
    long l3 = 0L;
    long l1;
    long l2;
    if ((paramObject instanceof m.c))
    {
      paramObject = (m.c)paramObject;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramObject.cZG > 0L)
      {
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramObject.cZH > 0L)
        {
          l1 = paramObject.cZG;
          l2 = paramObject.cZH;
        }
      }
    }
    for (paramLong1 = paramObject.flatJSCompileCost;; paramLong1 = l3)
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.byG();
      com.tencent.mm.plugin.appbrand.report.quality.b.a(this, paramString, l1, l2, this.coW.CN(), paramLong1);
      AppMethodBeat.o(222974);
      return;
      l1 = paramLong1;
      l2 = paramLong2;
    }
  }
  
  public final l aXR()
  {
    AppMethodBeat.i(175076);
    l local3 = new l()
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
        //   9: invokespecial 34	com/tencent/mm/plugin/appbrand/page/l:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;ZLorg/json/JSONObject;)V
        //   12: aload_3
        //   13: ldc 36
        //   15: aload_0
        //   16: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:mBl	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   19: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/p;
        //   22: invokevirtual 46	com/tencent/luggage/sdk/d/d:Fg	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
        //   25: getfield 52	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:cmE	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
        //   28: getfield 57	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
        //   31: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   34: pop
        //   35: aload_0
        //   36: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:mBl	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   39: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/p;
        //   42: invokevirtual 69	com/tencent/mm/plugin/appbrand/p:aXx	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   45: invokevirtual 75	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:Eg	()Lorg/json/JSONObject;
        //   48: astore_1
        //   49: aload_1
        //   50: ifnull +11 -> 61
        //   53: aload_3
        //   54: ldc 77
        //   56: aload_1
        //   57: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   60: pop
        //   61: aload_0
        //   62: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:mBl	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   65: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/p;
        //   68: astore 4
        //   70: iload_2
        //   71: ifeq +21 -> 92
        //   74: aload 4
        //   76: aload_3
        //   77: invokestatic 86	com/tencent/mm/plugin/appbrand/report/model/d:b	(Lcom/tencent/mm/plugin/appbrand/p;Lorg/json/JSONObject;)V
        //   80: aload 4
        //   82: aload_3
        //   83: invokestatic 88	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/p;Lorg/json/JSONObject;)V
        //   86: ldc 26
        //   88: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   91: return
        //   92: aload 4
        //   94: aload_3
        //   95: invokestatic 94	com/tencent/mm/plugin/appbrand/report/model/d:c	(Lcom/tencent/mm/plugin/appbrand/p;Lorg/json/JSONObject;)V
        //   98: aload 4
        //   100: aload_3
        //   101: invokestatic 88	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/p;Lorg/json/JSONObject;)V
        //   104: aload 4
        //   106: invokevirtual 98	com/tencent/mm/plugin/appbrand/p:aXy	()Lcom/tencent/mm/plugin/appbrand/page/u;
        //   109: invokevirtual 104	com/tencent/mm/plugin/appbrand/page/u:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/f;
        //   112: invokeinterface 110 1 0
        //   117: invokeinterface 116 1 0
        //   122: getfield 122	com/tencent/mm/plugin/appbrand/report/model/h$a:mxE	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
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
        //   145: invokevirtual 69	com/tencent/mm/plugin/appbrand/p:aXx	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
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
        //   182: invokestatic 151	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   68	76	4	localp	com.tencent.mm.plugin.appbrand.p
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
  
  public final ad aXu()
  {
    AppMethodBeat.i(48288);
    ad localad = (ad)super.at(ad.class);
    AppMethodBeat.o(48288);
    return localad;
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48290);
    this.jAF = ((com.tencent.mm.plugin.appbrand.p)paramAppBrandRuntime);
    if (aWe() == null) {
      a(((com.tencent.mm.plugin.appbrand.p)paramAppBrandRuntime).aWe());
    }
    biL();
    super.d(paramAppBrandRuntime);
    AppMethodBeat.o(48290);
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48294);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.FFH));
    c(paramJSONObject, "JSEngineName", com.tencent.mm.plugin.appbrand.jsruntime.w.c(aYB()));
    com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGM(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGT(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGP(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGS(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGR(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGZ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGV(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGW(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGX()));
    c(paramJSONObject, "useSkiaCanvasRaf", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGO()));
    AppMethodBeat.o(48294);
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48296);
    c(paramJSONObject, "debug", Boolean.valueOf(this.jAF.aXw().cmG));
    if (com.tencent.mm.plugin.appbrand.report.quality.a.Ve(getAppId()) != null) {
      c(paramJSONObject, "preloadType", Long.valueOf(com.tencent.mm.plugin.appbrand.report.quality.a.Ve(getAppId()).byN()));
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject1 = this.jAF.aWx();
    c(localJSONObject1, "path", com.tencent.luggage.h.k.dt((String)localObject1));
    c(localJSONObject1, "query", new JSONObject(com.tencent.luggage.h.k.du((String)localObject1)));
    c(localJSONObject1, "referrerInfo", this.jAF.aXx().Ei());
    c(localJSONObject1, "shareInfo", this.jAF.aXx().Eg());
    if (aq.o(this.jAF)) {
      localObject1 = "singlePage";
    }
    for (;;)
    {
      c(localJSONObject1, "mode", localObject1);
      com.tencent.mm.plugin.appbrand.report.model.d.b(this.jAF, localJSONObject1);
      com.tencent.mm.plugin.appbrand.report.model.d.a(this.jAF, paramJSONObject);
      AppBrandSysConfigWC localAppBrandSysConfigWC = this.jAF.aXw();
      JSONObject localJSONObject2 = new JSONObject();
      c(localJSONObject2, "maxRequestConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cmO));
      c(localJSONObject2, "maxUploadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cmP));
      c(localJSONObject2, "maxDownloadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cmQ));
      c(localJSONObject2, "maxWebsocketConnect", Integer.valueOf(localAppBrandSysConfigWC.cmR));
      c(localJSONObject2, "maxWorkerConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cmS));
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
      if (aq.o(this.jAF))
      {
        localObject2 = "wxfile://singlepage";
        ((JSONObject)localObject1).put("USER_DATA_PATH", localObject2);
        ((JSONObject)localObject1).put("OPEN_DATA_PATH", "wxfile://opendata");
        ((JSONObject)localObject1).put("CLIENT_DATA_PATH", "wxfile://clientdata");
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGr, false) != true) {
          break label654;
        }
        i = 1;
        ((JSONObject)localObject1).put("HAS_SPLASHSCREEN", i);
        c(paramJSONObject, "appLaunchInfo", localJSONObject1);
        c(paramJSONObject, "wxAppInfo", localJSONObject2);
        c(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().aXo()));
        c(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.tn(this.jAF.aXx().dQv).name().toLowerCase());
        localObject1 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(this.jAF.aXx().cmA.kdu);
          localObject1 = localObject2;
        }
        catch (Exception localException3)
        {
          label654:
          continue;
        }
        try
        {
          if (!bu.isNullOrNil(localAppBrandSysConfigWC.cmM))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("jsonInfo", new JSONObject(localAppBrandSysConfigWC.cmM));
            c((JSONObject)localObject1, "operationInfo", localObject2);
          }
          if (TextUtils.isEmpty(getRuntime().aXx().cmB)) {}
        }
        catch (Exception localException2)
        {
          try
          {
            ((JSONObject)localObject1).put("passThroughInfo", new JSONObject(getRuntime().aXx().cmB));
            c(paramJSONObject, "appContactInfo", localObject1);
            c(paramJSONObject, "accountInfo", this.jAF.aXx().Eh());
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
            ae.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException2 });
          }
          catch (JSONException localJSONException)
          {
            ae.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put passThroughInfo get exception:%s", new Object[] { localJSONException });
          }
        }
      }
    }
  }
  
  public com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(48287);
    Object localObject = this.coW;
    if ((localObject instanceof b))
    {
      localObject = ((b)localObject).mBh;
      if (localObject != null)
      {
        localObject = ((com.tencent.luggage.game.a.f)localObject).getMagicBrush();
        AppMethodBeat.o(48287);
        return localObject;
      }
      AppMethodBeat.o(48287);
      return null;
    }
    AppMethodBeat.o(48287);
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.p getRuntime()
  {
    AppMethodBeat.i(48302);
    com.tencent.mm.plugin.appbrand.p localp = (com.tencent.mm.plugin.appbrand.p)super.Eq();
    AppMethodBeat.o(48302);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c
 * JD-Core Version:    0.7.0.1
 */