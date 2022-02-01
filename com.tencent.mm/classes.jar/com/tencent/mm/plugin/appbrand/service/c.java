package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.h.k;
import com.tencent.luggage.sdk.b.a.a.d.b;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.sdk.b.a.c.c
  implements f
{
  protected com.tencent.mm.plugin.appbrand.o jxG;
  private final com.tencent.mm.plugin.appbrand.r.a.a.o mcG;
  private JSONObject mwn;
  
  static
  {
    AppMethodBeat.i(48309);
    com.tencent.mm.plugin.appbrand.jsruntime.w.bql();
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
    this.mwn = null;
    this.mcG = new com.tencent.mm.plugin.appbrand.r.a.a.o();
    if ((bu.flY()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jxf = bool;
      a(d.b.class, new com.tencent.mm.plugin.appbrand.jsapi.m.j());
      a(com.tencent.luggage.sdk.b.a.a.b.class, new com.tencent.mm.plugin.appbrand.jsapi.m.i());
      AppMethodBeat.o(48286);
      return;
    }
  }
  
  private String byd()
  {
    AppMethodBeat.i(48297);
    String str = null;
    if (AppBrandPerformanceManager.e(getRuntime())) {
      str = aVF().Ld("WAPerf.js");
    }
    AppMethodBeat.o(48297);
    return str;
  }
  
  public final boolean CK()
  {
    AppMethodBeat.i(221310);
    boolean bool = this.coU.CK();
    AppMethodBeat.o(221310);
    return bool;
  }
  
  public final void CY()
  {
    AppMethodBeat.i(48292);
    ad.i("MicroMsg.AppBrandServiceWC", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
    new l()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.p A(Map<String, Object> paramAnonymousMap)
      {
        AppMethodBeat.i(48279);
        paramAnonymousMap = new JSONObject(paramAnonymousMap);
        com.tencent.mm.plugin.appbrand.o localo = c.this.getRuntime();
        try
        {
          Object localObject = com.tencent.mm.plugin.appbrand.report.model.d.s((ae)localo.aVN().getCurrentPage().getCurrentPageView());
          int i = ((Integer)((Pair)localObject).first).intValue();
          localObject = (String)((Pair)localObject).second;
          paramAnonymousMap.put("targetAction", i);
          paramAnonymousMap.put("targetPagePath", localObject);
          paramAnonymousMap.put("usedState", ((com.tencent.mm.plugin.appbrand.o)localo).Fb().cmC.mrx);
          super.Ph(paramAnonymousMap.toString());
          AppMethodBeat.o(48279);
          return this;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", new Object[] { localException });
          }
        }
      }
    }.ae(getRuntime());
    this.coU.CY();
    AppMethodBeat.o(48292);
  }
  
  public void Dd()
  {
    AppMethodBeat.i(48299);
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(getAppId());
    if (localQualitySessionRuntime != null) {
      localQualitySessionRuntime.mvB = bt.flT();
    }
    super.Dd();
    AppMethodBeat.o(48299);
  }
  
  public final JSONObject EN()
  {
    AppMethodBeat.i(48295);
    if (this.mwn != null)
    {
      localJSONObject = com.tencent.luggage.sdk.g.b.f(this.mwn);
      AppMethodBeat.o(48295);
      return localJSONObject;
    }
    JSONObject localJSONObject = super.EN();
    if (getRuntime().getAppConfig().jVy.booleanValue()) {
      this.mwn = com.tencent.luggage.sdk.g.b.f(localJSONObject);
    }
    AppMethodBeat.o(48295);
    return localJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.ac.a ER()
  {
    AppMethodBeat.i(48289);
    com.tencent.mm.plugin.appbrand.ac.a local1 = new com.tencent.mm.plugin.appbrand.ac.a(this)
    {
      public final v aXJ()
      {
        AppMethodBeat.i(48278);
        com.tencent.mm.plugin.appbrand.ac.c localc = new com.tencent.mm.plugin.appbrand.ac.c(this.cZy);
        AppMethodBeat.o(48278);
        return localc;
      }
    };
    AppMethodBeat.o(48289);
    return local1;
  }
  
  public final c.b ES()
  {
    AppMethodBeat.i(48291);
    com.tencent.mm.plugin.appbrand.permission.a locala = new com.tencent.mm.plugin.appbrand.permission.a(getRuntime(), this);
    AppMethodBeat.o(48291);
    return locala;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.p Fg()
  {
    AppMethodBeat.i(48303);
    if (!isRunning())
    {
      localp = com.tencent.mm.plugin.appbrand.ad.d.aYb();
      AppMethodBeat.o(48303);
      return localp;
    }
    com.tencent.mm.plugin.appbrand.appstorage.p localp = super.Fg();
    AppMethodBeat.o(48303);
    return localp;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175077);
    String str = parama.scriptName;
    ad.d("MicroMsg.AppBrandServiceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { getAppId(), str, Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.appbrand.report.j localj = com.tencent.mm.plugin.appbrand.report.j.mru;
    com.tencent.mm.plugin.appbrand.report.j.a(this, parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if ("WAService.js".equals(str)) {
      if (!isRunning()) {
        break label109;
      }
    }
    label109:
    for (parama = byd();; parama = null)
    {
      if (!bt.isNullOrNil(parama)) {
        com.tencent.mm.plugin.appbrand.utils.q.a(aYh(), parama, new q.a()
        {
          public final void cT(String paramAnonymousString)
          {
            AppMethodBeat.i(48284);
            ad.e("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Failed");
            AppMethodBeat.o(48284);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            AppMethodBeat.i(48283);
            ad.i("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Success");
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
      ad.w("MicroMsg.AppBrandServiceWC", "setWindowAndroid, impl==null, appId:%s", new Object[] { getAppId() });
      paramc = ((h)com.tencent.mm.kernel.g.ajz().ajb()).ca;
      this.mcG.aw(paramc);
      super.a(this.mcG);
      AppMethodBeat.o(175079);
      return;
    }
    if (paramc.compareTo(this.jzX) != 0)
    {
      ad.i("MicroMsg.AppBrandServiceWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, stack:%s", new Object[] { this.jzX, paramc, getAppId(), Log.getStackTraceString(new Throwable()) });
      super.a(paramc);
    }
    AppMethodBeat.o(175079);
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(188755);
    long l3 = 0L;
    long l1;
    long l2;
    if ((paramObject instanceof m.c))
    {
      paramObject = (m.c)paramObject;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramObject.cYI > 0L)
      {
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramObject.cYJ > 0L)
        {
          l1 = paramObject.cYI;
          l2 = paramObject.cYJ;
        }
      }
    }
    for (paramLong1 = paramObject.flatJSCompileCost;; paramLong1 = l3)
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
      com.tencent.mm.plugin.appbrand.report.quality.b.a(this, paramString, l1, l2, this.coU.CK(), paramLong1);
      AppMethodBeat.o(188755);
      return;
      l1 = paramLong1;
      l2 = paramLong2;
    }
  }
  
  public final ae aWZ()
  {
    AppMethodBeat.i(48288);
    ae localae = (ae)super.at(ae.class);
    AppMethodBeat.o(48288);
    return localae;
  }
  
  public final m aXw()
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
        //   16: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:mwo	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   19: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/o;
        //   22: invokevirtual 46	com/tencent/luggage/sdk/d/c:Fb	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
        //   25: getfield 52	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:cmC	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
        //   28: getfield 57	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
        //   31: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   34: pop
        //   35: aload_0
        //   36: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:mwo	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   39: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/o;
        //   42: invokevirtual 69	com/tencent/mm/plugin/appbrand/o:aXc	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   45: invokevirtual 75	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:Ed	()Lorg/json/JSONObject;
        //   48: astore_1
        //   49: aload_1
        //   50: ifnull +11 -> 61
        //   53: aload_3
        //   54: ldc 77
        //   56: aload_1
        //   57: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   60: pop
        //   61: aload_0
        //   62: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:mwo	Lcom/tencent/mm/plugin/appbrand/service/c;
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
        //   106: invokevirtual 98	com/tencent/mm/plugin/appbrand/o:aXd	()Lcom/tencent/mm/plugin/appbrand/page/v;
        //   109: invokevirtual 104	com/tencent/mm/plugin/appbrand/page/v:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/f;
        //   112: invokeinterface 110 1 0
        //   117: invokeinterface 116 1 0
        //   122: getfield 122	com/tencent/mm/plugin/appbrand/report/model/h$a:msH	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
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
        //   145: invokevirtual 69	com/tencent/mm/plugin/appbrand/o:aXc	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
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
        //   182: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    this.jxG = ((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime);
    if (aVF() == null) {
      a(((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aVF());
    }
    bic();
    super.d(paramAppBrandRuntime);
    AppMethodBeat.o(48290);
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48294);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.Fnj));
    c(paramJSONObject, "JSEngineName", com.tencent.mm.plugin.appbrand.jsruntime.w.c(aYh()));
    com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFQ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFX(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFT(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFW(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFV(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGd(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFZ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGa(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bGb()));
    c(paramJSONObject, "useSkiaCanvasRaf", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bFS()));
    AppMethodBeat.o(48294);
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48296);
    c(paramJSONObject, "debug", Boolean.valueOf(this.jxG.aXb().cmE));
    if (com.tencent.mm.plugin.appbrand.report.quality.a.Ut(getAppId()) != null) {
      c(paramJSONObject, "preloadType", Long.valueOf(com.tencent.mm.plugin.appbrand.report.quality.a.Ut(getAppId()).bxU()));
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject1 = this.jxG.aVW();
    c(localJSONObject1, "path", k.dr((String)localObject1));
    c(localJSONObject1, "query", new JSONObject(k.ds((String)localObject1)));
    c(localJSONObject1, "referrerInfo", this.jxG.aXc().Ef());
    c(localJSONObject1, "shareInfo", this.jxG.aXc().Ed());
    if (ap.n(this.jxG)) {
      localObject1 = "singlePage";
    }
    for (;;)
    {
      c(localJSONObject1, "mode", localObject1);
      com.tencent.mm.plugin.appbrand.report.model.d.b(this.jxG, localJSONObject1);
      com.tencent.mm.plugin.appbrand.report.model.d.a(this.jxG, paramJSONObject);
      AppBrandSysConfigWC localAppBrandSysConfigWC = this.jxG.aXb();
      JSONObject localJSONObject2 = new JSONObject();
      c(localJSONObject2, "maxRequestConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cmM));
      c(localJSONObject2, "maxUploadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cmN));
      c(localJSONObject2, "maxDownloadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cmO));
      c(localJSONObject2, "maxWebsocketConnect", Integer.valueOf(localAppBrandSysConfigWC.cmP));
      c(localJSONObject2, "maxWorkerConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cmQ));
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
      if (ap.n(this.jxG))
      {
        localObject2 = "wxfile://singlepage";
        ((JSONObject)localObject1).put("USER_DATA_PATH", localObject2);
        ((JSONObject)localObject1).put("OPEN_DATA_PATH", "wxfile://opendata");
        ((JSONObject)localObject1).put("CLIENT_DATA_PATH", "wxfile://clientdata");
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzl, false) != true) {
          break label654;
        }
        i = 1;
        ((JSONObject)localObject1).put("HAS_SPLASHSCREEN", i);
        c(paramJSONObject, "appLaunchInfo", localJSONObject1);
        c(paramJSONObject, "wxAppInfo", localJSONObject2);
        c(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().aWT()));
        c(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.tk(this.jxG.aXc().dPf).name().toLowerCase());
        localObject1 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(this.jxG.aXc().cmy.kad);
          localObject1 = localObject2;
        }
        catch (Exception localException3)
        {
          label654:
          continue;
        }
        try
        {
          if (!bt.isNullOrNil(localAppBrandSysConfigWC.cmK))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("jsonInfo", new JSONObject(localAppBrandSysConfigWC.cmK));
            c((JSONObject)localObject1, "operationInfo", localObject2);
          }
          if (TextUtils.isEmpty(getRuntime().aXc().cmz)) {}
        }
        catch (Exception localException2)
        {
          try
          {
            ((JSONObject)localObject1).put("passThroughInfo", new JSONObject(getRuntime().aXc().cmz));
            c(paramJSONObject, "appContactInfo", localObject1);
            c(paramJSONObject, "accountInfo", this.jxG.aXc().Ee());
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
            ad.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException2 });
          }
          catch (JSONException localJSONException)
          {
            ad.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put passThroughInfo get exception:%s", new Object[] { localJSONException });
          }
        }
      }
    }
  }
  
  public com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(48287);
    Object localObject = this.coU;
    if ((localObject instanceof b))
    {
      localObject = ((b)localObject).mwk;
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
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)super.En();
    AppMethodBeat.o(48302);
    return localo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c
 * JD-Core Version:    0.7.0.1
 */