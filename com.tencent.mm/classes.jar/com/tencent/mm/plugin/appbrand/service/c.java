package com.tencent.mm.plugin.appbrand.service;

import android.util.Log;
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
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.sdk.b.a.c.c
  implements f
{
  protected com.tencent.mm.plugin.appbrand.o iEx;
  private final com.tencent.mm.plugin.appbrand.s.a.a.o lbF;
  private JSONObject luF;
  
  static
  {
    AppMethodBeat.i(48309);
    com.tencent.mm.plugin.appbrand.jsruntime.w.bfG();
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
    this.luF = null;
    this.lbF = new com.tencent.mm.plugin.appbrand.s.a.a.o();
    if ((bu.eGT()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.iDV = bool;
      a(e.b.class, new com.tencent.mm.plugin.appbrand.jsapi.j.l());
      a(com.tencent.luggage.sdk.b.a.a.b.class, new com.tencent.mm.plugin.appbrand.jsapi.j.k());
      AppMethodBeat.o(48286);
      return;
    }
  }
  
  private String bnc()
  {
    AppMethodBeat.i(48297);
    String str = null;
    if (AppBrandPerformanceManager.d(getRuntime())) {
      str = aLC().DH("WAPerf.js");
    }
    AppMethodBeat.o(48297);
    return str;
  }
  
  public final boolean BH()
  {
    AppMethodBeat.i(205045);
    boolean bool = this.chI.BH();
    AppMethodBeat.o(205045);
    return bool;
  }
  
  public final void BV()
  {
    AppMethodBeat.i(48292);
    ad.i("MicroMsg.AppBrandServiceWC", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
    new c.2(this).ak(getRuntime());
    this.chI.BV();
    AppMethodBeat.o(48292);
  }
  
  public void Ca()
  {
    AppMethodBeat.i(48299);
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.ME(getAppId());
    if (localQualitySessionRuntime != null) {
      localQualitySessionRuntime.ltR = bt.eGO();
    }
    super.Ca();
    AppMethodBeat.o(48299);
  }
  
  public final JSONObject DL()
  {
    AppMethodBeat.i(48295);
    if (this.luF == null) {
      this.luF = super.DL();
    }
    JSONObject localJSONObject = com.tencent.luggage.sdk.g.b.f(this.luF);
    AppMethodBeat.o(48295);
    return localJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.ae.a DP()
  {
    AppMethodBeat.i(48289);
    com.tencent.mm.plugin.appbrand.ae.a local1 = new com.tencent.mm.plugin.appbrand.ae.a(this)
    {
      public final v aNH()
      {
        AppMethodBeat.i(48278);
        com.tencent.mm.plugin.appbrand.ae.c localc = new com.tencent.mm.plugin.appbrand.ae.c(this.cQN);
        AppMethodBeat.o(48278);
        return localc;
      }
    };
    AppMethodBeat.o(48289);
    return local1;
  }
  
  public final c.b DQ()
  {
    AppMethodBeat.i(48291);
    com.tencent.mm.plugin.appbrand.permission.a locala = new com.tencent.mm.plugin.appbrand.permission.a(getRuntime(), this);
    AppMethodBeat.o(48291);
    return locala;
  }
  
  public final p Ee()
  {
    AppMethodBeat.i(48303);
    if (!isRunning())
    {
      localp = com.tencent.mm.plugin.appbrand.ad.d.aNY();
      AppMethodBeat.o(48303);
      return localp;
    }
    p localp = super.Ee();
    AppMethodBeat.o(48303);
    return localp;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175077);
    String str = parama.scriptName;
    ad.d("MicroMsg.AppBrandServiceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { getAppId(), str, Boolean.valueOf(paramBoolean) });
    j localj = j.lpI;
    j.a(this, parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if ("WAService.js".equals(str)) {
      if (!isRunning()) {
        break label108;
      }
    }
    label108:
    for (parama = bnc();; parama = null)
    {
      if (!bt.isNullOrNil(parama)) {
        com.tencent.mm.plugin.appbrand.utils.q.a(aOf(), parama, new q.a()
        {
          public final void cj(String paramAnonymousString)
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
  
  public final void a(com.tencent.mm.plugin.appbrand.s.a.c paramc)
  {
    AppMethodBeat.i(175079);
    if (paramc == null)
    {
      ad.w("MicroMsg.AppBrandServiceWC", "setWindowAndroid, impl==null, appId:%s", new Object[] { getAppId() });
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).ca;
      this.lbF.av(paramc);
      super.a(this.lbF);
      AppMethodBeat.o(175079);
      return;
    }
    if (paramc.compareTo(this.iGU) != 0)
    {
      ad.i("MicroMsg.AppBrandServiceWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, stack:%s", new Object[] { this.iGU, paramc, getAppId(), Log.getStackTraceString(new Throwable()) });
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
      if (paramObject.cPX > 0L)
      {
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramObject.cPY > 0L)
        {
          l1 = paramObject.cPX;
          l2 = paramObject.cPY;
        }
      }
    }
    for (paramLong1 = paramObject.flatJSCompileCost;; paramLong1 = l3)
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
      com.tencent.mm.plugin.appbrand.report.quality.b.a(this, paramString, l1, l2, this.chI.BH(), paramLong1);
      AppMethodBeat.o(48298);
      return;
      l1 = paramLong1;
      l2 = paramLong2;
    }
  }
  
  public final ae aMZ()
  {
    AppMethodBeat.i(48288);
    ae localae = (ae)super.at(ae.class);
    AppMethodBeat.o(48288);
    return localae;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.l aNx()
  {
    AppMethodBeat.i(175076);
    com.tencent.mm.plugin.appbrand.page.l local3 = new com.tencent.mm.plugin.appbrand.page.l()
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
        //   16: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:luG	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   19: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/o;
        //   22: invokevirtual 46	com/tencent/luggage/sdk/d/c:DZ	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
        //   25: getfield 52	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:cfo	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
        //   28: getfield 57	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
        //   31: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   34: pop
        //   35: aload_0
        //   36: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:luG	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   39: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/o;
        //   42: invokevirtual 69	com/tencent/mm/plugin/appbrand/o:aNc	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   45: invokevirtual 75	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:Db	()Lorg/json/JSONObject;
        //   48: astore_1
        //   49: aload_1
        //   50: ifnull +11 -> 61
        //   53: aload_3
        //   54: ldc 77
        //   56: aload_1
        //   57: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   60: pop
        //   61: aload_0
        //   62: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:luG	Lcom/tencent/mm/plugin/appbrand/service/c;
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
        //   106: invokevirtual 98	com/tencent/mm/plugin/appbrand/o:aNd	()Lcom/tencent/mm/plugin/appbrand/page/u;
        //   109: invokevirtual 104	com/tencent/mm/plugin/appbrand/page/u:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/f;
        //   112: invokeinterface 110 1 0
        //   117: invokeinterface 116 1 0
        //   122: getfield 122	com/tencent/mm/plugin/appbrand/report/model/h$a:lqW	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
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
        //   145: invokevirtual 69	com/tencent/mm/plugin/appbrand/o:aNc	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
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
    this.iEx = ((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime);
    if (aLC() == null) {
      a(((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aLC());
    }
    aXB();
    super.d(paramAppBrandRuntime);
    AppMethodBeat.o(48290);
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48294);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.CpK));
    c(paramJSONObject, "JSEngineName", com.tencent.mm.plugin.appbrand.jsruntime.w.c(aOf()));
    com.tencent.mm.plugin.appbrand.i.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.buQ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.buW(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.buS(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.buV(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.buU(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.bvc(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.buY(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.buZ(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bva()));
    AppMethodBeat.o(48294);
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48296);
    c(paramJSONObject, "debug", Boolean.valueOf(this.iEx.aNb().cfq));
    if (com.tencent.mm.plugin.appbrand.report.quality.a.ME(getAppId()) != null) {
      c(paramJSONObject, "preloadType", Long.valueOf(com.tencent.mm.plugin.appbrand.report.quality.a.ME(getAppId()).bmT()));
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject1 = this.iEx.aLS();
    c(localJSONObject1, "path", com.tencent.luggage.h.k.cA((String)localObject1));
    c(localJSONObject1, "query", new JSONObject(com.tencent.luggage.h.k.cB((String)localObject1)));
    c(localJSONObject1, "referrerInfo", this.iEx.aNc().Dd());
    c(localJSONObject1, "shareInfo", this.iEx.aNc().Db());
    if (ao.w(this.iEx)) {
      localObject1 = "singlePage";
    }
    for (;;)
    {
      c(localJSONObject1, "mode", localObject1);
      com.tencent.mm.plugin.appbrand.report.model.d.b(this.iEx, localJSONObject1);
      com.tencent.mm.plugin.appbrand.report.model.d.a(this.iEx, paramJSONObject);
      AppBrandSysConfigWC localAppBrandSysConfigWC = this.iEx.aNb();
      JSONObject localJSONObject2 = new JSONObject();
      c(localJSONObject2, "maxRequestConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cfy));
      c(localJSONObject2, "maxUploadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cfz));
      c(localJSONObject2, "maxDownloadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cfA));
      c(localJSONObject2, "maxWebsocketConnect", Integer.valueOf(localAppBrandSysConfigWC.cfB));
      c(localJSONObject2, "maxWorkerConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cfC));
      try
      {
        localObject1 = paramJSONObject.optJSONObject("env");
        if (localObject1 != null) {
          break label649;
        }
        localObject1 = new JSONObject();
        paramJSONObject.put("env", localObject1);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject2;
          label334:
          int i;
        }
      }
      if (ao.w(this.iEx))
      {
        localObject2 = "wxfile://singlepage";
        ((JSONObject)localObject1).put("USER_DATA_PATH", localObject2);
        ((JSONObject)localObject1).put("OPEN_DATA_PATH", "wxfile://opendata");
        ((JSONObject)localObject1).put("CLIENT_DATA_PATH", "wxfile://clientdata");
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pqS, false) != true) {
          break label613;
        }
        i = 1;
        ((JSONObject)localObject1).put("HAS_SPLASHSCREEN", i);
        c(paramJSONObject, "appLaunchInfo", localJSONObject1);
        c(paramJSONObject, "wxAppInfo", localJSONObject2);
        c(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().aMT()));
        c(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.rR(this.iEx.aNc().iOP).name().toLowerCase());
        localObject1 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(this.iEx.aNc().cfl.jfF);
          localObject1 = localObject2;
        }
        catch (Exception localException3)
        {
          label613:
          continue;
        }
        try
        {
          if (!bt.isNullOrNil(localAppBrandSysConfigWC.cfw))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("jsonInfo", new JSONObject(localAppBrandSysConfigWC.cfw));
            c((JSONObject)localObject1, "operationInfo", localObject2);
          }
          c(paramJSONObject, "appContactInfo", localObject1);
          c(paramJSONObject, "accountInfo", this.iEx.aNc().Dc());
          c(paramJSONObject, "supportAsyncAudio", Boolean.TRUE);
          super.e(paramJSONObject);
          AppMethodBeat.o(48296);
          return;
          localObject1 = "default";
          break;
          localObject2 = "wxfile://usr";
          break label334;
          i = 0;
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException2 });
        }
      }
    }
  }
  
  public com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(48287);
    Object localObject = this.chI;
    if ((localObject instanceof b))
    {
      localObject = ((b)localObject).luC;
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
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)super.Dl();
    AppMethodBeat.o(48302);
    return localo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c
 * JD-Core Version:    0.7.0.1
 */