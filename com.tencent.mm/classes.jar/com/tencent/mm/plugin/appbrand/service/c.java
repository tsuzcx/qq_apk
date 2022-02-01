package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.b.a.a.e.b;
import com.tencent.luggage.sdk.b.a.c.c.a;
import com.tencent.luggage.sdk.b.a.c.f;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.b.a.d.b.b;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bd;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.p.i;
import com.tencent.mm.plugin.appbrand.jsapi.p.j;
import com.tencent.mm.plugin.appbrand.m.w;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.utils.u.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.sdk.b.a.c.d
{
  protected t nuJ;
  public boolean qOE;
  public com.tencent.mm.plugin.appbrand.ad.g qOF;
  private JSONObject qOG;
  private final com.tencent.mm.plugin.appbrand.platform.window.a.o qtq;
  
  static
  {
    AppMethodBeat.i(48309);
    w.bYY();
    AppMethodBeat.o(48309);
  }
  
  public c()
  {
    this(new c.a());
    AppMethodBeat.i(48285);
    AppMethodBeat.o(48285);
  }
  
  public c(com.tencent.luggage.sdk.b.a.b.a parama)
  {
    super(parama);
    AppMethodBeat.i(48286);
    this.qOE = false;
    this.qOG = null;
    this.qtq = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.nug = bool;
    a(e.b.class, new j());
    a(com.tencent.luggage.sdk.b.a.a.b.class, new i());
    a(b.b.class, new com.tencent.mm.plugin.appbrand.jsapi.audio.p());
    AppMethodBeat.o(48286);
  }
  
  private void ciB()
  {
    AppMethodBeat.i(274724);
    com.tencent.mm.plugin.appbrand.ad.e.bEI();
    setEvalInterceptor(new e.a()
    {
      public final boolean a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.m.o paramAnonymouso)
      {
        AppMethodBeat.i(276968);
        if (com.tencent.mm.plugin.appbrand.ad.e.a(paramAnonymouso))
        {
          AppMethodBeat.o(276968);
          return true;
        }
        if ("loadLibFiles".equals(paramAnonymousString))
        {
          AppMethodBeat.o(276968);
          return false;
        }
        boolean bool = c.this.isRunning();
        AppMethodBeat.o(276968);
        return bool;
      }
    });
    AppMethodBeat.o(274724);
  }
  
  public final boolean Pb()
  {
    AppMethodBeat.i(293263);
    boolean bool = this.cAr.Pb();
    AppMethodBeat.o(293263);
    return bool;
  }
  
  public final void Pp()
  {
    AppMethodBeat.i(48292);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
    new com.tencent.mm.plugin.appbrand.page.o()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.r D(Map<String, Object> paramAnonymousMap)
      {
        AppMethodBeat.i(48279);
        paramAnonymousMap = new JSONObject(paramAnonymousMap);
        t localt = c.this.getRuntime();
        try
        {
          Object localObject = com.tencent.mm.plugin.appbrand.report.model.d.r((ah)localt.bBX().getCurrentPage().getCurrentPageView());
          int i = ((Integer)((Pair)localObject).first).intValue();
          localObject = (String)((Pair)localObject).second;
          paramAnonymousMap.put("targetAction", i);
          paramAnonymousMap.put("targetPagePath", localObject);
          paramAnonymousMap.put("usedState", ((t)localt).Sk().cxf.qJF);
          super.agT(paramAnonymousMap.toString());
          AppMethodBeat.o(48279);
          return this;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", new Object[] { localException });
          }
        }
      }
    }.ae(getRuntime());
    this.cAr.Pp();
    AppMethodBeat.o(48292);
  }
  
  public void Pu()
  {
    AppMethodBeat.i(48299);
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.amO(getAppId());
    if (localQualitySessionRuntime != null) {
      localQualitySessionRuntime.qNQ = Util.nowMilliSecond();
    }
    ciB();
    this.qOE = false;
    super.Pu();
    AppMethodBeat.o(48299);
  }
  
  public final void Pv()
  {
    AppMethodBeat.i(274725);
    ciB();
    super.Pv();
    AppMethodBeat.o(274725);
  }
  
  public final JSONObject Ro()
  {
    AppMethodBeat.i(48295);
    if (this.qOG != null)
    {
      localJSONObject = com.tencent.luggage.sdk.h.c.i(this.qOG);
      AppMethodBeat.o(48295);
      return localJSONObject;
    }
    JSONObject localJSONObject = super.Ro();
    if (getRuntime().getAppConfig().nWa.booleanValue()) {
      this.qOG = com.tencent.luggage.sdk.h.c.i(localJSONObject);
    }
    AppMethodBeat.o(48295);
    return localJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.ah.a Ru()
  {
    AppMethodBeat.i(48289);
    com.tencent.mm.plugin.appbrand.ah.a local1 = new com.tencent.mm.plugin.appbrand.ah.a(this)
    {
      public final com.tencent.mm.appbrand.v8.v bEe()
      {
        AppMethodBeat.i(48278);
        com.tencent.mm.plugin.appbrand.ah.e locale = new com.tencent.mm.plugin.appbrand.ah.e(bEg());
        AppMethodBeat.o(48278);
        return locale;
      }
    };
    AppMethodBeat.o(48289);
    return local1;
  }
  
  public final e.c Rv()
  {
    AppMethodBeat.i(48291);
    com.tencent.mm.plugin.appbrand.permission.a locala = new com.tencent.mm.plugin.appbrand.permission.a(getRuntime(), this);
    AppMethodBeat.o(48291);
    return locala;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(175077);
    String str = parama.scriptName;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandServiceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { getAppId(), str, Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.appbrand.report.l locall = com.tencent.mm.plugin.appbrand.report.l.qJC;
    com.tencent.mm.plugin.appbrand.report.l.a(this, parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if ("WAService.js".equals(str))
    {
      parama = localObject;
      if (isRunning())
      {
        parama = localObject;
        if (AppBrandPerformanceManager.k(getRuntime())) {
          parama = bBP().acw("WAPerf.js");
        }
      }
      if (!Util.isNullOrNil(parama)) {
        com.tencent.mm.plugin.appbrand.utils.u.a(getJsRuntime(), parama, new u.a()
        {
          public final void dL(String paramAnonymousString)
          {
            AppMethodBeat.i(280342);
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Failed");
            AppMethodBeat.o(280342);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            AppMethodBeat.i(280341);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Success");
            AppMethodBeat.o(280341);
          }
        });
      }
    }
    AppMethodBeat.o(175077);
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(274723);
    if (!isRunning())
    {
      AppMethodBeat.o(274723);
      return;
    }
    long l3 = 0L;
    long l1;
    long l2;
    if ((paramObject instanceof m.c))
    {
      paramObject = (m.c)paramObject;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramObject.fiR > 0L)
      {
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramObject.fiS > 0L)
        {
          l1 = paramObject.fiR;
          l2 = paramObject.fiS;
        }
      }
    }
    for (paramLong1 = paramObject.flatJSCompileCost;; paramLong1 = l3)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      com.tencent.mm.plugin.appbrand.report.quality.c.a(this, paramString, l1, l2, this.cAr.Pb(), paramLong1);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getRuntime().mAppId, KSProcessWeAppLaunch.stepInjectWxConfig, "wxConfig", l1, l2);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getRuntime().mAppId, KSProcessWeAppLaunch.stepInjectWxConfig_Game, "wxConfig", l1, l2);
      AppMethodBeat.o(274723);
      return;
      l1 = paramLong1;
      l2 = paramLong2;
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(175079);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandServiceWC", "setWindowAndroid, impl==null, appId:%s", new Object[] { getAppId() });
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw;
      this.qtq.aD(paramc);
      super.b(this.qtq);
      AppMethodBeat.o(175079);
      return;
    }
    if (paramc.compareTo(this.nxr) != 0)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, stack:%s", new Object[] { this.nxr, paramc, getAppId(), android.util.Log.getStackTraceString(new Throwable()) });
      super.b(paramc);
    }
    AppMethodBeat.o(175079);
  }
  
  public final com.tencent.mm.plugin.appbrand.page.p bDW()
  {
    AppMethodBeat.i(175076);
    com.tencent.mm.plugin.appbrand.page.p local3 = new com.tencent.mm.plugin.appbrand.page.p()
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
        //   9: invokespecial 34	com/tencent/mm/plugin/appbrand/page/p:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;ZLorg/json/JSONObject;)V
        //   12: aload_3
        //   13: ldc 36
        //   15: aload_0
        //   16: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:qOH	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   19: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/t;
        //   22: invokevirtual 46	com/tencent/luggage/sdk/e/d:Sk	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
        //   25: getfield 52	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:cxf	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
        //   28: getfield 57	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
        //   31: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   34: pop
        //   35: aload_0
        //   36: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:qOH	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   39: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/t;
        //   42: invokevirtual 69	com/tencent/mm/plugin/appbrand/t:bDy	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   45: invokevirtual 75	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:Qy	()Lorg/json/JSONObject;
        //   48: astore_1
        //   49: aload_1
        //   50: ifnull +11 -> 61
        //   53: aload_3
        //   54: ldc 77
        //   56: aload_1
        //   57: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   60: pop
        //   61: aload_0
        //   62: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:qOH	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   65: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/t;
        //   68: astore 4
        //   70: iload_2
        //   71: ifeq +21 -> 92
        //   74: aload 4
        //   76: aload_3
        //   77: invokestatic 86	com/tencent/mm/plugin/appbrand/report/model/d:b	(Lcom/tencent/mm/plugin/appbrand/t;Lorg/json/JSONObject;)V
        //   80: aload 4
        //   82: aload_3
        //   83: invokestatic 88	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/t;Lorg/json/JSONObject;)V
        //   86: ldc 26
        //   88: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   91: return
        //   92: aload 4
        //   94: aload_3
        //   95: invokestatic 94	com/tencent/mm/plugin/appbrand/report/model/d:c	(Lcom/tencent/mm/plugin/appbrand/t;Lorg/json/JSONObject;)V
        //   98: aload 4
        //   100: aload_3
        //   101: invokestatic 88	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/t;Lorg/json/JSONObject;)V
        //   104: aload 4
        //   106: invokevirtual 98	com/tencent/mm/plugin/appbrand/t:bDz	()Lcom/tencent/mm/plugin/appbrand/page/y;
        //   109: invokevirtual 104	com/tencent/mm/plugin/appbrand/page/y:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/f;
        //   112: invokeinterface 110 1 0
        //   117: invokeinterface 116 1 0
        //   122: getfield 122	com/tencent/mm/plugin/appbrand/report/model/h$a:qKU	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
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
        //   145: invokevirtual 69	com/tencent/mm/plugin/appbrand/t:bDy	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
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
        //   182: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   68	76	4	localt	t
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
  
  public final ah bDv()
  {
    AppMethodBeat.i(48288);
    ah localah = (ah)super.aw(ah.class);
    AppMethodBeat.o(48288);
    return localah;
  }
  
  public final void bEU()
  {
    AppMethodBeat.i(274719);
    if (this.qOF != null)
    {
      this.qOF.destroy();
      this.qOF = null;
    }
    AppMethodBeat.o(274719);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48290);
    this.nuJ = ((t)paramAppBrandRuntime);
    if (bBP() == null) {
      a(((t)paramAppBrandRuntime).bBP());
    }
    bPz();
    super.d(paramAppBrandRuntime);
    AppMethodBeat.o(48290);
  }
  
  public final void g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48294);
    super.g(paramJSONObject);
    c(paramJSONObject, "useClipboardWithPermissionNotify", Boolean.valueOf(MMEditText.hZv()));
    JSONObject localJSONObject = new JSONObject();
    c(localJSONObject, "env", "WeChat");
    c(localJSONObject, "version", Integer.valueOf(com.tencent.mm.protocal.d.RAD));
    c(paramJSONObject, "host", localJSONObject);
    AppMethodBeat.o(48294);
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.r getFileSystem()
  {
    AppMethodBeat.i(48303);
    if (!isRunning())
    {
      localr = com.tencent.mm.plugin.appbrand.ad.e.bEH();
      AppMethodBeat.o(48303);
      return localr;
    }
    com.tencent.mm.plugin.appbrand.appstorage.r localr = super.getFileSystem();
    AppMethodBeat.o(48303);
    return localr;
  }
  
  public t getRuntime()
  {
    AppMethodBeat.i(48302);
    t localt = (t)super.QM();
    if (localt != null)
    {
      AppMethodBeat.o(48302);
      return localt;
    }
    localt = this.nuJ;
    AppMethodBeat.o(48302);
    return localt;
  }
  
  public final void h(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48296);
    c(paramJSONObject, "debug", Boolean.valueOf(this.nuJ.bDx().cxh));
    if (com.tencent.mm.plugin.appbrand.report.quality.b.amO(getAppId()) != null) {
      c(paramJSONObject, "preloadType", Long.valueOf(com.tencent.mm.plugin.appbrand.report.quality.b.amO(getAppId()).cir()));
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject1 = this.nuJ.bCi();
    c(localJSONObject1, "path", com.tencent.luggage.k.l.eo((String)localObject1));
    c(localJSONObject1, "query", new JSONObject(com.tencent.luggage.k.l.ep((String)localObject1)));
    c(localJSONObject1, "referrerInfo", this.nuJ.bDy().QA());
    c(localJSONObject1, "shareInfo", this.nuJ.bDy().Qy());
    int i = this.nuJ.bDy().cxf.chatType;
    if (i != -1) {
      c(localJSONObject1, "chatType", Integer.valueOf(i));
    }
    localObject1 = this.nuJ.bDy().nBJ;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      c(localJSONObject1, "shortLink", localObject1);
    }
    c(localJSONObject1, "secFlagForSinglePageMode", Integer.valueOf(this.nuJ.bDy().lyw));
    com.tencent.mm.plugin.appbrand.report.model.d.b(this.nuJ, localJSONObject1);
    com.tencent.mm.plugin.appbrand.report.model.d.a(this.nuJ, paramJSONObject);
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.nuJ.bDx();
    JSONObject localJSONObject2 = new JSONObject();
    c(localJSONObject2, "maxRequestConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cxp));
    c(localJSONObject2, "maxUploadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cxq));
    c(localJSONObject2, "maxDownloadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cxr));
    c(localJSONObject2, "maxWebsocketConnect", Integer.valueOf(localAppBrandSysConfigWC.cxs));
    c(localJSONObject2, "maxWorkerConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cxt));
    try
    {
      localObject1 = paramJSONObject.optJSONObject("env");
      if (localObject1 != null) {
        break label818;
      }
      localObject1 = new JSONObject();
      paramJSONObject.put("env", localObject1);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
      }
    }
    if (bd.s(this.nuJ)) {
      localObject2 = "wxfile://singlepage";
    }
    for (;;)
    {
      ((JSONObject)localObject1).put("USER_DATA_PATH", localObject2);
      ((JSONObject)localObject1).put("OPEN_DATA_PATH", "wxfile://opendata");
      ((JSONObject)localObject1).put("CLIENT_DATA_PATH", "wxfile://clientdata");
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGF, false) == true)
      {
        i = 1;
        label461:
        ((JSONObject)localObject1).put("HAS_SPLASHSCREEN", i);
        c(paramJSONObject, "appLaunchInfo", localJSONObject1);
        c(paramJSONObject, "wxAppInfo", localJSONObject2);
        c(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().bDl()));
        c(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.AF(this.nuJ.bDy().cBI).name().toLowerCase());
        localObject1 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(this.nuJ.bDy().cwY.obF);
          localObject1 = localObject2;
        }
        catch (Exception localException3)
        {
          boolean bool;
          continue;
        }
        try
        {
          if (!Util.isNullOrNil(localAppBrandSysConfigWC.cxn))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("jsonInfo", new JSONObject(localAppBrandSysConfigWC.cxn));
            c((JSONObject)localObject1, "operationInfo", localObject2);
          }
          if (TextUtils.isEmpty(getRuntime().bDy().cwZ)) {}
        }
        catch (Exception localException2)
        {
          try
          {
            ((JSONObject)localObject1).put("passThroughInfo", new JSONObject(getRuntime().bDy().cwZ));
            c(paramJSONObject, "appContactInfo", localObject1);
            c(paramJSONObject, "accountInfo", this.nuJ.bDy().Qz());
            c(paramJSONObject, "supportAsyncAudio", Boolean.TRUE);
            if (this.nuJ.bDy().cxe == com.tencent.luggage.sdk.launching.b.cBf)
            {
              bool = true;
              c(paramJSONObject, "prerender", Boolean.valueOf(bool));
              super.h(paramJSONObject);
              AppMethodBeat.o(48296);
              return;
              localObject2 = "wxfile://usr";
              break;
              i = 0;
              break label461;
              localException2 = localException2;
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException2 });
            }
          }
          catch (JSONException localJSONException)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put passThroughInfo get exception:%s", new Object[] { localJSONException });
            continue;
            bool = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c
 * JD-Core Version:    0.7.0.1
 */