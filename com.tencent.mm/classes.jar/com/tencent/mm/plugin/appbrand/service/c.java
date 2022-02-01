package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.l.m;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.b.e.b;
import com.tencent.luggage.sdk.b.a.d.f;
import com.tencent.luggage.sdk.b.a.e.b.b;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bj;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.j;
import com.tencent.mm.plugin.appbrand.jsapi.s.k;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.sdk.b.a.d.d
{
  protected com.tencent.mm.plugin.appbrand.w qts;
  public boolean tTr;
  public com.tencent.mm.plugin.appbrand.ad.g tTs;
  private JSONObject tTt;
  private final com.tencent.mm.plugin.appbrand.platform.window.a.o txW;
  
  static
  {
    AppMethodBeat.i(48309);
    com.tencent.mm.plugin.appbrand.n.w.czm();
    AppMethodBeat.o(48309);
  }
  
  public c()
  {
    this(b.class);
    AppMethodBeat.i(48285);
    AppMethodBeat.o(48285);
  }
  
  public c(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(48286);
    this.tTr = false;
    if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.qsQ = bool;
    a(e.b.class, new k());
    a(com.tencent.luggage.sdk.b.a.b.b.class, new j());
    a(b.b.class, new com.tencent.mm.plugin.appbrand.jsapi.audio.s());
    a(com.tencent.mm.plugin.appbrand.jsapi.audio.d.a.class, new com.tencent.mm.plugin.appbrand.jsapi.audio.e());
    this.tTt = null;
    this.txW = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    AppMethodBeat.o(48286);
  }
  
  public c(Class<? extends f<? extends com.tencent.luggage.sdk.b.a.d.d>> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(321552);
    this.tTr = false;
    if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.qsQ = bool;
    a(e.b.class, new k());
    a(com.tencent.luggage.sdk.b.a.b.b.class, new j());
    a(b.b.class, new com.tencent.mm.plugin.appbrand.jsapi.audio.s());
    a(com.tencent.mm.plugin.appbrand.jsapi.audio.d.a.class, new com.tencent.mm.plugin.appbrand.jsapi.audio.e());
    this.tTt = null;
    this.txW = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    AppMethodBeat.o(321552);
  }
  
  private void cJr()
  {
    AppMethodBeat.i(321559);
    if (com.tencent.mm.plugin.appbrand.ad.e.cdT()) {
      setEvalInterceptor(new f.a()
      {
        public final boolean a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.n.o paramAnonymouso)
        {
          AppMethodBeat.i(321539);
          if (com.tencent.mm.plugin.appbrand.ad.e.a(paramAnonymouso))
          {
            AppMethodBeat.o(321539);
            return true;
          }
          if ("loadLibFiles".equals(paramAnonymousString))
          {
            AppMethodBeat.o(321539);
            return false;
          }
          boolean bool = c.this.isRunning();
          AppMethodBeat.o(321539);
          return bool;
        }
      });
    }
    AppMethodBeat.o(321559);
  }
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.p paramp, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt, com.tencent.mm.plugin.appbrand.n.o paramo)
  {
    AppMethodBeat.i(321653);
    if ((paramJSONObject1.has("__invoke_webviewId")) && (getRuntime() != null) && (getRuntime().ccN() != null) && ((this.esM instanceof b)) && (((b)this.esM).tTl))
    {
      int i = paramJSONObject1.optInt("__invoke_webviewId", 0);
      ad localad = getRuntime().ccN().L(i, true);
      if (localad != null)
      {
        paramp = localad.a(paramp, paramJSONObject1, paramJSONObject2, paramInt, paramo);
        AppMethodBeat.o(321653);
        return paramp;
      }
    }
    paramp = super.a(paramp, paramJSONObject1, paramJSONObject2, paramInt, paramo);
    AppMethodBeat.o(321653);
    return paramp;
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.appbrand.n.o paramo)
  {
    AppMethodBeat.i(321644);
    if ((getInterceptor() instanceof com.tencent.mm.plugin.appbrand.permission.a))
    {
      locala = (com.tencent.mm.plugin.appbrand.permission.a)getInterceptor();
      if ((locala == null) || (!locala.da(paramString1, paramInt))) {
        break label83;
      }
    }
    for (i = 1;; i = 0)
    {
      try
      {
        paramString2 = super.a(paramString1, paramString2, paramString3, paramInt, paramBoolean, paramo);
        return paramString2;
      }
      finally
      {
        label83:
        if (i == 0) {
          break label103;
        }
        locala.db(paramString1, paramInt);
        AppMethodBeat.o(321644);
      }
      locala = null;
      break;
    }
  }
  
  public final void a(com.tencent.luggage.sdk.b.a.d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(175077);
    String str = parama.scriptName;
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandServiceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { getAppId(), str, Boolean.valueOf(paramBoolean) });
    l locall = l.tOg;
    l.a(this, parama, paramBoolean, paramLong1, paramLong2, paramObject);
    if ("WAService.js".equals(str))
    {
      parama = localObject;
      if (isRunning())
      {
        parama = localObject;
        if (AppBrandPerformanceManager.k(getRuntime())) {
          parama = cbl().UW("WAPerf.js");
        }
      }
      if (!Util.isNullOrNil(parama)) {
        z.a(getJsRuntime(), parama, new c.5(this));
      }
    }
    AppMethodBeat.o(175077);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(175079);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandServiceWC", "setWindowAndroid, impl==null, appId:%s", new Object[] { getAppId() });
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP;
      this.txW.bm(paramc);
      super.a(this.txW);
      AppMethodBeat.o(175079);
      return;
    }
    if (paramc.compareTo(this.qwF) != 0)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, stack:%s", new Object[] { this.qwF, paramc, getAppId(), android.util.Log.getStackTraceString(new Throwable()) });
      super.a(paramc);
    }
    AppMethodBeat.o(175079);
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(321596);
    if (!isRunning())
    {
      AppMethodBeat.o(321596);
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
      if (paramObject.hne > 0L)
      {
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramObject.hnf > 0L)
        {
          l1 = paramObject.hne;
          l2 = paramObject.hnf;
        }
      }
    }
    for (paramLong1 = paramObject.flatJSCompileCost;; paramLong1 = l3)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      com.tencent.mm.plugin.appbrand.report.quality.c.a(this, paramString, l1, l2, this.esM.apj(), paramLong1);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getRuntime().mAppId, KSProcessWeAppLaunch.stepInjectWxConfig, "wxConfig", l1, l2);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(getRuntime().mAppId, KSProcessWeAppLaunch.stepInjectWxConfig_Game, "wxConfig", l1, l2);
      AppMethodBeat.o(321596);
      return;
      l1 = paramLong1;
      l2 = paramLong2;
    }
  }
  
  public final void aI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(321637);
    JSONObject localJSONObject1 = new JSONObject();
    d(localJSONObject1, "isTeenMode", Boolean.valueOf(getRuntime().getInitConfig().epi));
    d(localJSONObject1, "isCareMode", Boolean.valueOf(getRuntime().getInitConfig().epk));
    d(localJSONObject1, "isAccessibilityMode", Boolean.valueOf(a.a.jlv().jls()));
    JSONObject localJSONObject2 = new JSONObject();
    d(localJSONObject2, "labelColor_light", "rgba(0,0,0,0.90)");
    d(localJSONObject2, "labelColor_dark", "rgba(255,255,255,0.80)");
    d(localJSONObject2, "tertiaryLabelColor_light", "rgba(0,0,0,0.30)");
    d(localJSONObject2, "secondaryLabelColor_light", "rgba(0,0,0,0.50)");
    d(localJSONObject2, "tertiaryLabelColor_dark", "rgba(255,255,255,0.30)");
    d(localJSONObject2, "secondaryLabelColor_dark", "rgba(255,255,255,0.50)");
    d(localJSONObject1, "commonColor", localJSONObject2);
    d(paramJSONObject, "userConfig", localJSONObject1);
    AppMethodBeat.o(321637);
  }
  
  public void apC()
  {
    AppMethodBeat.i(48299);
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(getAppId());
    if (localQualitySessionRuntime != null) {
      localQualitySessionRuntime.tSA = Util.nowMilliSecond();
    }
    cJr();
    this.tTr = false;
    super.apC();
    AppMethodBeat.o(48299);
  }
  
  public final void apD()
  {
    AppMethodBeat.i(321604);
    cJr();
    super.apD();
    if (cdn().cds() == null)
    {
      String str = MultiProcessMMKV.getMMKV("paramsCache").decodeString("paramsCache", null);
      if ((str != null) && (str.startsWith(String.valueOf(cbl().cfG()))))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "preload: createWXLibWorker");
        str = str.substring(str.indexOf("#@#") + 3);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "preload: params cache:".concat(String.valueOf(str)));
        cdn().createWXLibWorker("WASplashadWorker.js", str);
      }
    }
    AppMethodBeat.o(321604);
  }
  
  public final void apx()
  {
    AppMethodBeat.i(48292);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWC", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
    new com.tencent.mm.plugin.appbrand.page.o()
    {
      public final com.tencent.mm.plugin.appbrand.jsapi.s K(Map<String, Object> paramAnonymousMap)
      {
        AppMethodBeat.i(48279);
        paramAnonymousMap = new JSONObject(paramAnonymousMap);
        com.tencent.mm.plugin.appbrand.w localw = c.this.getRuntime();
        try
        {
          Object localObject = com.tencent.mm.plugin.appbrand.report.model.e.t((ah)localw.getPageContainer().getCurrentPage().getCurrentPageView());
          int i = ((Integer)((Pair)localObject).first).intValue();
          localObject = (String)((Pair)localObject).second;
          paramAnonymousMap.put("targetAction", i);
          paramAnonymousMap.put("targetPagePath", localObject);
          paramAnonymousMap.put("usedState", ((com.tencent.mm.plugin.appbrand.w)localw).asA().epn.tOj);
          super.ZQ(paramAnonymousMap.toString());
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
    }.as(getRuntime());
    this.esM.apx();
    AppMethodBeat.o(48292);
  }
  
  public final JSONObject arC()
  {
    AppMethodBeat.i(48295);
    if (this.tTt != null)
    {
      localJSONObject = com.tencent.luggage.sdk.h.c.h(this.tTt);
      AppMethodBeat.o(48295);
      return localJSONObject;
    }
    JSONObject localJSONObject = super.arC();
    if (getRuntime().getAppConfig().qVK.booleanValue()) {
      this.tTt = com.tencent.luggage.sdk.h.c.h(localJSONObject);
    }
    AppMethodBeat.o(48295);
    return localJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.ai.a arI()
  {
    AppMethodBeat.i(48289);
    com.tencent.mm.plugin.appbrand.ai.a local1 = new com.tencent.mm.plugin.appbrand.ai.a(this)
    {
      public final v cdq()
      {
        AppMethodBeat.i(48278);
        com.tencent.mm.plugin.appbrand.ai.e locale = new com.tencent.mm.plugin.appbrand.ai.e(cdt());
        AppMethodBeat.o(48278);
        return locale;
      }
    };
    AppMethodBeat.o(48289);
    return local1;
  }
  
  public final f.c arJ()
  {
    AppMethodBeat.i(48291);
    com.tencent.mm.plugin.appbrand.permission.a locala = new com.tencent.mm.plugin.appbrand.permission.a(getRuntime(), this);
    AppMethodBeat.o(48291);
    return locala;
  }
  
  public final void cJq()
  {
    AppMethodBeat.i(321563);
    if ((this.esM instanceof b)) {
      ((b)this.esM).cJq();
    }
    AppMethodBeat.o(321563);
  }
  
  public final ah ccK()
  {
    AppMethodBeat.i(48288);
    ah localah = (ah)super.aP(ah.class);
    AppMethodBeat.o(48288);
    return localah;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.p cdj()
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
        //   12: aload_0
        //   13: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:tTu	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   16: aload_3
        //   17: invokevirtual 38	com/tencent/mm/plugin/appbrand/service/c:aI	(Lorg/json/JSONObject;)V
        //   20: aload_3
        //   21: ldc 40
        //   23: aload_0
        //   24: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:tTu	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   27: invokevirtual 44	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/w;
        //   30: invokevirtual 50	com/tencent/luggage/sdk/e/d:asA	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
        //   33: getfield 56	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:epn	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
        //   36: getfield 61	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject:scene	I
        //   39: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   42: pop
        //   43: aload_0
        //   44: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:tTu	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   47: invokevirtual 44	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/w;
        //   50: invokevirtual 73	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   53: invokevirtual 79	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:aqK	()Lorg/json/JSONObject;
        //   56: astore_1
        //   57: aload_1
        //   58: ifnull +11 -> 69
        //   61: aload_3
        //   62: ldc 81
        //   64: aload_1
        //   65: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   68: pop
        //   69: aload_0
        //   70: getfield 15	com/tencent/mm/plugin/appbrand/service/c$3:tTu	Lcom/tencent/mm/plugin/appbrand/service/c;
        //   73: invokevirtual 44	com/tencent/mm/plugin/appbrand/service/c:getRuntime	()Lcom/tencent/mm/plugin/appbrand/w;
        //   76: astore 4
        //   78: iload_2
        //   79: ifeq +21 -> 100
        //   82: aload 4
        //   84: aload_3
        //   85: invokestatic 90	com/tencent/mm/plugin/appbrand/report/model/e:b	(Lcom/tencent/mm/plugin/appbrand/w;Lorg/json/JSONObject;)V
        //   88: aload 4
        //   90: aload_3
        //   91: invokestatic 92	com/tencent/mm/plugin/appbrand/report/model/e:a	(Lcom/tencent/mm/plugin/appbrand/w;Lorg/json/JSONObject;)V
        //   94: ldc 26
        //   96: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   99: return
        //   100: aload 4
        //   102: aload_3
        //   103: invokestatic 98	com/tencent/mm/plugin/appbrand/report/model/e:c	(Lcom/tencent/mm/plugin/appbrand/w;Lorg/json/JSONObject;)V
        //   106: aload 4
        //   108: aload_3
        //   109: invokestatic 92	com/tencent/mm/plugin/appbrand/report/model/e:a	(Lcom/tencent/mm/plugin/appbrand/w;Lorg/json/JSONObject;)V
        //   112: aload 4
        //   114: invokevirtual 102	com/tencent/mm/plugin/appbrand/w:ccN	()Lcom/tencent/mm/plugin/appbrand/page/y;
        //   117: invokevirtual 108	com/tencent/mm/plugin/appbrand/page/y:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/h;
        //   120: invokeinterface 114 1 0
        //   125: invokeinterface 120 1 0
        //   130: getfield 126	com/tencent/mm/plugin/appbrand/report/model/j$a:tPz	Lcom/tencent/mm/plugin/appbrand/report/model/j$b;
        //   133: astore_1
        //   134: aload_1
        //   135: ifnonnull +34 -> 169
        //   138: aconst_null
        //   139: astore_1
        //   140: aload_3
        //   141: ldc 128
        //   143: aload_1
        //   144: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   147: pop
        //   148: aload_3
        //   149: ldc 130
        //   151: aload 4
        //   153: invokevirtual 73	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
        //   156: getfield 134	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
        //   159: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
        //   162: pop
        //   163: ldc 26
        //   165: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   168: return
        //   169: aload_1
        //   170: getfield 143	com/tencent/mm/plugin/appbrand/report/model/j$b:path	Ljava/lang/String;
        //   173: astore_1
        //   174: goto -34 -> 140
        //   177: astore_1
        //   178: ldc 145
        //   180: ldc 147
        //   182: iconst_1
        //   183: anewarray 149	java/lang/Object
        //   186: dup
        //   187: iconst_0
        //   188: aload_1
        //   189: aastore
        //   190: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   193: ldc 26
        //   195: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   198: return
        //   199: astore_1
        //   200: goto -131 -> 69
        //   203: astore_1
        //   204: goto -161 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	207	0	this	3
        //   0	207	1	paramAnonymousAppBrandRuntime	AppBrandRuntime
        //   0	207	2	paramAnonymousBoolean	boolean
        //   0	207	3	paramAnonymousJSONObject	JSONObject
        //   76	76	4	localw	com.tencent.mm.plugin.appbrand.w
        // Exception table:
        //   from	to	target	type
        //   100	134	177	java/lang/Exception
        //   140	163	177	java/lang/Exception
        //   169	174	177	java/lang/Exception
        //   43	57	199	org/json/JSONException
        //   61	69	199	org/json/JSONException
        //   12	43	203	org/json/JSONException
      }
    };
    AppMethodBeat.o(175076);
    return local3;
  }
  
  public final void ceh()
  {
    AppMethodBeat.i(321570);
    if (this.tTs != null)
    {
      this.tTs.destroy();
      this.tTs = null;
    }
    AppMethodBeat.o(321570);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48290);
    this.qts = ((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime);
    if (cbl() == null) {
      b(((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime).cbl());
    }
    cpF();
    super.d(paramAppBrandRuntime);
    AppMethodBeat.o(48290);
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48294);
    super.f(paramJSONObject);
    d(paramJSONObject, "useClipboardWithPermissionNotify", Boolean.valueOf(MMEditText.jEE()));
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject, "env", "WeChat");
    d(localJSONObject, "version", Integer.valueOf(com.tencent.mm.protocal.d.Yxh));
    d(paramJSONObject, "host", localJSONObject);
    AppMethodBeat.o(48294);
  }
  
  public final void g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48296);
    d(paramJSONObject, "debug", Boolean.valueOf(this.qts.ccM().epz));
    if (com.tencent.mm.plugin.appbrand.report.quality.b.afZ(getAppId()) != null) {
      d(paramJSONObject, "preloadType", Long.valueOf(com.tencent.mm.plugin.appbrand.report.quality.b.afZ(getAppId()).cJi()));
    }
    Object localObject1 = paramJSONObject.optJSONObject("appLaunchInfo");
    if (localObject1 == null)
    {
      localObject1 = new JSONObject();
      d(paramJSONObject, "appLaunchInfo", localObject1);
    }
    label540:
    label861:
    for (;;)
    {
      Object localObject3 = this.qts.cby();
      String str = m.fL((String)localObject3).trim();
      Object localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = this.qts.getAppConfig().ckv();
      }
      d((JSONObject)localObject1, "path", localObject2);
      d((JSONObject)localObject1, "query", new JSONObject(m.fM((String)localObject3)));
      d((JSONObject)localObject1, "referrerInfo", this.qts.getInitConfig().eoV.ckI());
      d((JSONObject)localObject1, "shareInfo", this.qts.getInitConfig().aqK());
      int i = this.qts.getInitConfig().epn.chatType;
      if (i != -1) {
        d((JSONObject)localObject1, "chatType", Integer.valueOf(i));
      }
      i = this.qts.getInitConfig().epn.tOn;
      if (com.tencent.mm.plugin.appbrand.launching.d.a.uB(i)) {
        d((JSONObject)localObject1, "codeScene", Integer.valueOf(i));
      }
      localObject2 = this.qts.getInitConfig().qAX;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        d((JSONObject)localObject1, "shortLink", localObject2);
      }
      d((JSONObject)localObject1, "secFlagForSinglePageMode", Integer.valueOf(this.qts.getInitConfig().opX));
      com.tencent.mm.plugin.appbrand.report.model.e.b(this.qts, (JSONObject)localObject1);
      com.tencent.mm.plugin.appbrand.report.model.e.a(this.qts, paramJSONObject);
      localObject3 = this.qts.ccM();
      JSONObject localJSONObject = new JSONObject();
      d(localJSONObject, "maxRequestConcurrent", Integer.valueOf(((AppBrandSysConfigLU)localObject3).epH));
      d(localJSONObject, "maxUploadConcurrent", Integer.valueOf(((AppBrandSysConfigLU)localObject3).epI));
      d(localJSONObject, "maxDownloadConcurrent", Integer.valueOf(((AppBrandSysConfigLU)localObject3).epJ));
      d(localJSONObject, "maxWebsocketConnect", Integer.valueOf(((AppBrandSysConfigLU)localObject3).epK));
      d(localJSONObject, "maxWorkerConcurrent", Integer.valueOf(((AppBrandSysConfigLU)localObject3).epL));
      try
      {
        localObject2 = paramJSONObject.optJSONObject("env");
        if (localObject2 != null) {
          break label861;
        }
        localObject2 = new JSONObject();
        paramJSONObject.put("env", localObject2);
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
      if (bj.x(this.qts)) {
        str = "wxfile://singlepage";
      }
      for (;;)
      {
        ((JSONObject)localObject2).put("USER_DATA_PATH", str);
        ((JSONObject)localObject2).put("OPEN_DATA_PATH", "wxfile://opendata");
        ((JSONObject)localObject2).put("CLIENT_DATA_PATH", "wxfile://clientdata");
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWA, false) == true)
        {
          i = 1;
          ((JSONObject)localObject2).put("HAS_SPLASHSCREEN", i);
          aI(paramJSONObject);
          d(paramJSONObject, "appLaunchInfo", localObject1);
          d(paramJSONObject, "wxAppInfo", localJSONObject);
          d(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().ccB()));
          d(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.AS(this.qts.getInitConfig().eul).name().toLowerCase());
          localObject1 = new JSONObject();
        }
        for (;;)
        {
          try
          {
            localObject2 = new JSONObject(this.qts.getInitConfig().epa.rcs);
            localObject1 = localObject2;
          }
          catch (Exception localException2)
          {
            continue;
          }
          try
          {
            if (!Util.isNullOrNil(((AppBrandSysConfigLU)localObject3).epF))
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("jsonInfo", new JSONObject(((AppBrandSysConfigLU)localObject3).epF));
              d((JSONObject)localObject1, "operationInfo", localObject2);
            }
            if (TextUtils.isEmpty(getRuntime().getInitConfig().epb)) {}
          }
          catch (Exception localException1)
          {
            try
            {
              ((JSONObject)localObject1).put("passThroughInfo", new JSONObject(getRuntime().getInitConfig().epb));
              d(paramJSONObject, "appContactInfo", localObject1);
              d(paramJSONObject, "accountInfo", this.qts.getInitConfig().aqL());
              d(paramJSONObject, "supportAsyncAudio", Boolean.TRUE);
              super.g(paramJSONObject);
              AppMethodBeat.o(48296);
              return;
              str = "wxfile://usr";
              break;
              i = 0;
              break label540;
              localException1 = localException1;
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException1 });
            }
            catch (JSONException localJSONException)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put passThroughInfo get exception:%s", new Object[] { localJSONException });
            }
          }
        }
      }
    }
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.w getFileSystem()
  {
    AppMethodBeat.i(48303);
    if (!isRunning())
    {
      localw = com.tencent.mm.plugin.appbrand.ad.e.cdS();
      AppMethodBeat.o(48303);
      return localw;
    }
    com.tencent.mm.plugin.appbrand.appstorage.w localw = super.getFileSystem();
    AppMethodBeat.o(48303);
    return localw;
  }
  
  public com.tencent.mm.plugin.appbrand.w getRuntime()
  {
    AppMethodBeat.i(48302);
    com.tencent.mm.plugin.appbrand.w localw = (com.tencent.mm.plugin.appbrand.w)super.aqZ();
    if (localw != null)
    {
      AppMethodBeat.o(48302);
      return localw;
    }
    localw = this.qts;
    AppMethodBeat.o(48302);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c
 * JD-Core Version:    0.7.0.1
 */