package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.b.a.a.d.b;
import com.tencent.luggage.sdk.b.a.c.c.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.o.i;
import com.tencent.mm.plugin.appbrand.jsapi.o.j;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.sdk.b.a.c.d
  implements com.tencent.mm.plugin.appbrand.p.f
{
  protected com.tencent.mm.plugin.appbrand.q kBw;
  private JSONObject nMo;
  private final com.tencent.mm.plugin.appbrand.platform.window.a.o nrx;
  
  static
  {
    AppMethodBeat.i(48309);
    com.tencent.mm.plugin.appbrand.m.w.bMH();
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
    this.nMo = null;
    this.nrx = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.kAU = bool;
      a(d.b.class, new j());
      a(com.tencent.luggage.sdk.b.a.a.b.class, new i());
      AppMethodBeat.o(48286);
      return;
    }
  }
  
  private String bVq()
  {
    AppMethodBeat.i(48297);
    String str = null;
    if (AppBrandPerformanceManager.e(getRuntime())) {
      str = bqZ().UM("WAPerf.js");
    }
    AppMethodBeat.o(48297);
    return str;
  }
  
  public void MC()
  {
    AppMethodBeat.i(48299);
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
    if (localQualitySessionRuntime != null) {
      localQualitySessionRuntime.nLD = Util.nowMilliSecond();
    }
    super.MC();
    AppMethodBeat.o(48299);
  }
  
  public final boolean Mj()
  {
    AppMethodBeat.i(258365);
    boolean bool = this.cBj.Mj();
    AppMethodBeat.o(258365);
    return bool;
  }
  
  public final void Mx()
  {
    AppMethodBeat.i(48292);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
    new n()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.s K(Map<String, Object> paramAnonymousMap)
      {
        AppMethodBeat.i(48279);
        paramAnonymousMap = new JSONObject(paramAnonymousMap);
        com.tencent.mm.plugin.appbrand.q localq = c.this.getRuntime();
        try
        {
          Object localObject = com.tencent.mm.plugin.appbrand.report.model.d.t((ag)localq.brh().getCurrentPage().getCurrentPageView());
          int i = ((Integer)((Pair)localObject).first).intValue();
          localObject = (String)((Pair)localObject).second;
          paramAnonymousMap.put("targetAction", i);
          paramAnonymousMap.put("targetPagePath", localObject);
          paramAnonymousMap.put("usedState", ((com.tencent.mm.plugin.appbrand.q)localq).ON().cyA.nHt);
          super.Zg(paramAnonymousMap.toString());
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
    this.cBj.Mx();
    AppMethodBeat.o(48292);
  }
  
  public final JSONObject Or()
  {
    AppMethodBeat.i(48295);
    if (this.nMo != null)
    {
      localJSONObject = com.tencent.luggage.sdk.g.b.f(this.nMo);
      AppMethodBeat.o(48295);
      return localJSONObject;
    }
    JSONObject localJSONObject = super.Or();
    if (getRuntime().getAppConfig().lbR.booleanValue()) {
      this.nMo = com.tencent.luggage.sdk.g.b.f(localJSONObject);
    }
    AppMethodBeat.o(48295);
    return localJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.ag.a Ov()
  {
    AppMethodBeat.i(48289);
    com.tencent.mm.plugin.appbrand.ag.a local1 = new com.tencent.mm.plugin.appbrand.ag.a(this)
    {
      public final v bti()
      {
        AppMethodBeat.i(48278);
        com.tencent.mm.plugin.appbrand.ag.d locald = new com.tencent.mm.plugin.appbrand.ag.d(this.dra);
        AppMethodBeat.o(48278);
        return locald;
      }
    };
    AppMethodBeat.o(48289);
    return local1;
  }
  
  public final f.b Ow()
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
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandServiceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { getAppId(), str, Boolean.valueOf(paramBoolean) });
    k localk = k.nHq;
    k.a(this, parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if ("WAService.js".equals(str)) {
      if (!isRunning()) {
        break label108;
      }
    }
    label108:
    for (parama = bVq();; parama = null)
    {
      if (!Util.isNullOrNil(parama)) {
        com.tencent.mm.plugin.appbrand.utils.s.a(getJsRuntime(), parama, new s.a()
        {
          public final void du(String paramAnonymousString)
          {
            AppMethodBeat.i(48284);
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Failed");
            AppMethodBeat.o(48284);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            AppMethodBeat.i(48283);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Success");
            AppMethodBeat.o(48283);
          }
        });
      }
      AppMethodBeat.o(175077);
      return;
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(227431);
    if (!isRunning())
    {
      AppMethodBeat.o(227431);
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
      if (paramObject.dqk > 0L)
      {
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramObject.dql > 0L)
        {
          l1 = paramObject.dqk;
          l2 = paramObject.dql;
        }
      }
    }
    for (paramLong1 = paramObject.flatJSCompileCost;; paramLong1 = l3)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      com.tencent.mm.plugin.appbrand.report.quality.c.a(this, paramString, l1, l2, this.cBj.Mj(), paramLong1);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getRuntime().mAppId, KSProcessWeAppLaunch.stepInjectWxConfig, "wxConfig", l1, l2);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getRuntime().mAppId, KSProcessWeAppLaunch.stepInjectWxConfig_Game, "wxConfig", l1, l2);
      AppMethodBeat.o(227431);
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
      paramc = ((h)com.tencent.mm.kernel.g.aAe().azG()).ca;
      this.nrx.aG(paramc);
      super.b(this.nrx);
      AppMethodBeat.o(175079);
      return;
    }
    if (paramc.compareTo(this.kEb) != 0)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, stack:%s", new Object[] { this.kEb, paramc, getAppId(), android.util.Log.getStackTraceString(new Throwable()) });
      super.b(paramc);
    }
    AppMethodBeat.o(175079);
  }
  
  public final com.tencent.mm.plugin.appbrand.page.o bsY()
  {
    AppMethodBeat.i(175076);
    com.tencent.mm.plugin.appbrand.page.o local3 = new com.tencent.mm.plugin.appbrand.page.o()
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
        //   9: invokespecial 34	com/tencent/mm/plugin/appbrand/page/o:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;ZLorg/json/JSONObject;)V
        //   12: aload_3
        //   13: ldc 36
        //   15: aload_0
        //   16: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:nMp	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   19: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/q;
        //   22: invokevirtual 46	com/tencent/luggage/sdk/d/d:ON	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
        //   25: getfield 52	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:cyA	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
        //   28: getfield 57	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
        //   31: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   34: pop
        //   35: aload_0
        //   36: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:nMp	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   39: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/q;
        //   42: invokevirtual 69	com/tencent/mm/plugin/appbrand/q:bsC	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   45: invokevirtual 75	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:ND	()Lorg/json/JSONObject;
        //   48: astore_1
        //   49: aload_1
        //   50: ifnull +11 -> 61
        //   53: aload_3
        //   54: ldc 77
        //   56: aload_1
        //   57: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   60: pop
        //   61: aload_0
        //   62: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:nMp	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   65: invokevirtual 40	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/q;
        //   68: astore 4
        //   70: iload_2
        //   71: ifeq +21 -> 92
        //   74: aload 4
        //   76: aload_3
        //   77: invokestatic 86	com/tencent/mm/plugin/appbrand/report/model/d:b	(Lcom/tencent/mm/plugin/appbrand/q;Lorg/json/JSONObject;)V
        //   80: aload 4
        //   82: aload_3
        //   83: invokestatic 88	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/q;Lorg/json/JSONObject;)V
        //   86: ldc 26
        //   88: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   91: return
        //   92: aload 4
        //   94: aload_3
        //   95: invokestatic 94	com/tencent/mm/plugin/appbrand/report/model/d:c	(Lcom/tencent/mm/plugin/appbrand/q;Lorg/json/JSONObject;)V
        //   98: aload 4
        //   100: aload_3
        //   101: invokestatic 88	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/q;Lorg/json/JSONObject;)V
        //   104: aload 4
        //   106: invokevirtual 98	com/tencent/mm/plugin/appbrand/q:bsD	()Lcom/tencent/mm/plugin/appbrand/page/x;
        //   109: invokevirtual 104	com/tencent/mm/plugin/appbrand/page/x:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/f;
        //   112: invokeinterface 110 1 0
        //   117: invokeinterface 116 1 0
        //   122: getfield 122	com/tencent/mm/plugin/appbrand/report/model/h$a:nII	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
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
        //   145: invokevirtual 69	com/tencent/mm/plugin/appbrand/q:bsC	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
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
        //   68	76	4	localq	com.tencent.mm.plugin.appbrand.q
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
  
  public final ag bsz()
  {
    AppMethodBeat.i(48288);
    ag localag = (ag)super.ax(ag.class);
    AppMethodBeat.o(48288);
    return localag;
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48290);
    this.kBw = ((com.tencent.mm.plugin.appbrand.q)paramAppBrandRuntime);
    if (bqZ() == null) {
      a(((com.tencent.mm.plugin.appbrand.q)paramAppBrandRuntime).bqZ());
    }
    bEb();
    super.d(paramAppBrandRuntime);
    AppMethodBeat.o(48290);
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48294);
    super.d(paramJSONObject);
    c(paramJSONObject, "useClipboardWithPermissionNotify", Boolean.valueOf(MMEditText.gYE()));
    JSONObject localJSONObject = new JSONObject();
    c(localJSONObject, "env", "WeChat");
    c(localJSONObject, "version", Integer.valueOf(com.tencent.mm.protocal.d.KyO));
    c(paramJSONObject, "host", localJSONObject);
    AppMethodBeat.o(48294);
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48296);
    c(paramJSONObject, "debug", Boolean.valueOf(this.kBw.bsB().cyC));
    if (com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId()) != null) {
      c(paramJSONObject, "preloadType", Long.valueOf(com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId()).bVg()));
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject1 = this.kBw.brs();
    c(localJSONObject1, "path", l.dM((String)localObject1));
    c(localJSONObject1, "query", new JSONObject(l.dN((String)localObject1)));
    c(localJSONObject1, "referrerInfo", this.kBw.bsC().NF());
    c(localJSONObject1, "shareInfo", this.kBw.bsC().ND());
    localObject1 = this.kBw.bsC().kHQ;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      c(localJSONObject1, "shortLink", localObject1);
    }
    com.tencent.mm.plugin.appbrand.report.model.d.b(this.kBw, localJSONObject1);
    com.tencent.mm.plugin.appbrand.report.model.d.a(this.kBw, paramJSONObject);
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.kBw.bsB();
    JSONObject localJSONObject2 = new JSONObject();
    c(localJSONObject2, "maxRequestConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cyK));
    c(localJSONObject2, "maxUploadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cyL));
    c(localJSONObject2, "maxDownloadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cyM));
    c(localJSONObject2, "maxWebsocketConnect", Integer.valueOf(localAppBrandSysConfigWC.cyN));
    c(localJSONObject2, "maxWorkerConcurrent", Integer.valueOf(localAppBrandSysConfigWC.cyO));
    try
    {
      localObject1 = paramJSONObject.optJSONObject("env");
      if (localObject1 != null) {
        break label764;
      }
      localObject1 = new JSONObject();
      paramJSONObject.put("env", localObject1);
    }
    catch (Exception localException1)
    {
      label407:
      for (;;)
      {
        Object localObject2;
      }
    }
    if (bb.r(this.kBw)) {
      localObject2 = "wxfile://singlepage";
    }
    for (;;)
    {
      ((JSONObject)localObject1).put("USER_DATA_PATH", localObject2);
      ((JSONObject)localObject1).put("OPEN_DATA_PATH", "wxfile://opendata");
      ((JSONObject)localObject1).put("CLIENT_DATA_PATH", "wxfile://clientdata");
      int i;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZF, false) == true)
      {
        i = 1;
        ((JSONObject)localObject1).put("HAS_SPLASHSCREEN", i);
        c(paramJSONObject, "appLaunchInfo", localJSONObject1);
        c(paramJSONObject, "wxAppInfo", localJSONObject2);
        c(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().bsr()));
        c(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.xj(this.kBw.bsC().eix).name().toLowerCase());
        localObject1 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(this.kBw.bsC().cyv.lgZ);
          localObject1 = localObject2;
        }
        catch (Exception localException3)
        {
          boolean bool;
          continue;
        }
        try
        {
          if (!Util.isNullOrNil(localAppBrandSysConfigWC.cyI))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("jsonInfo", new JSONObject(localAppBrandSysConfigWC.cyI));
            c((JSONObject)localObject1, "operationInfo", localObject2);
          }
          if (TextUtils.isEmpty(getRuntime().bsC().cyw)) {}
        }
        catch (Exception localException2)
        {
          try
          {
            ((JSONObject)localObject1).put("passThroughInfo", new JSONObject(getRuntime().bsC().cyw));
            c(paramJSONObject, "appContactInfo", localObject1);
            c(paramJSONObject, "accountInfo", this.kBw.bsC().NE());
            c(paramJSONObject, "supportAsyncAudio", Boolean.TRUE);
            if (this.kBw.bsC().cyz == com.tencent.luggage.sdk.launching.b.cBC)
            {
              bool = true;
              c(paramJSONObject, "prerender", Boolean.valueOf(bool));
              super.e(paramJSONObject);
              AppMethodBeat.o(48296);
              return;
              localObject2 = "wxfile://usr";
              break;
              i = 0;
              break label407;
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
  
  public com.tencent.mm.plugin.appbrand.appstorage.q getFileSystem()
  {
    AppMethodBeat.i(48303);
    if (!isRunning())
    {
      localq = e.btJ();
      AppMethodBeat.o(48303);
      return localq;
    }
    com.tencent.mm.plugin.appbrand.appstorage.q localq = super.getFileSystem();
    AppMethodBeat.o(48303);
    return localq;
  }
  
  public com.tencent.mm.plugin.appbrand.q getRuntime()
  {
    AppMethodBeat.i(48302);
    com.tencent.mm.plugin.appbrand.q localq = (com.tencent.mm.plugin.appbrand.q)super.NP();
    AppMethodBeat.o(48302);
    return localq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c
 * JD-Core Version:    0.7.0.1
 */