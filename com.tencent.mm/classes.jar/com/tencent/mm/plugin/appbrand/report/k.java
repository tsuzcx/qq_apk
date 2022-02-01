package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.nj;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.r;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceWCScriptReporter;", "", "()V", "TAG", "", "reportEvaluateResult", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "scriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportJSError", "message", "stackTrace", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k nHq;
  
  static
  {
    AppMethodBeat.i(51009);
    nHq = new k();
    AppMethodBeat.o(51009);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.service.c paramc, d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175210);
    p.h(paramc, "service");
    p.h(parama, "scriptInfo");
    Object localObject1 = parama.scriptName;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(175210);
      return;
    }
    if (!paramBoolean)
    {
      Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, !succeed name[" + (String)localObject1 + "], appId[" + paramc.getAppId() + ']');
      if ((parama.czA <= 0) && (localObject1 != null)) {}
    }
    else
    {
      if (localObject1 != null) {
        break label251;
      }
    }
    label251:
    int k;
    label313:
    label375:
    int j;
    for (;;)
    {
      if (n.K((String)localObject1, "/app-service.js", false))
      {
        h.CyF.dN(370, 30);
        if (paramBoolean)
        {
          h.CyF.dN(370, 31);
          AppMethodBeat.o(175210);
          return;
          switch (((String)localObject1).hashCode())
          {
          default: 
            break;
          case -979125780: 
            if (!((String)localObject1).equals("WAServiceMainContext.js")) {
              break;
            }
            h.CyF.dN(370, 73);
            break;
          case 2071195020: 
            if (!((String)localObject1).equals("WAService.js")) {
              break;
            }
            h.CyF.dN(370, 72);
            break;
            switch (((String)localObject1).hashCode())
            {
            default: 
              break;
            case -979125780: 
              if (((String)localObject1).equals("WAServiceMainContext.js"))
              {
                Log.i("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, service_lib_script[" + (String)localObject1 + "], succeed[" + paramBoolean + ']');
                if (paramc.getRuntime() != null)
                {
                  if (paramBoolean) {
                    com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", paramLong1, paramLong2);
                  }
                }
                else
                {
                  b.bUZ();
                  com.tencent.mm.plugin.appbrand.report.quality.c.a(paramc, (String)localObject1, parama.czA, paramLong1, paramLong2, paramObject);
                  switch (((String)localObject1).hashCode())
                  {
                  default: 
                    parama = new r(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    i = ((Number)parama.first).intValue();
                    k = ((Number)parama.second).intValue();
                    j = ((Number)parama.SWY).intValue();
                    h.CyF.dN(370, i);
                    if (paramBoolean)
                    {
                      h.CyF.dN(370, j);
                      AppMethodBeat.o(175210);
                      return;
                    }
                    break;
                  }
                }
              }
              break;
            case 452806299: 
              if (((String)localObject1).equals("WAGame.js")) {
                if (!paramBoolean)
                {
                  i.cf(paramc.getAppId(), 24);
                  parama = paramc.getAppId();
                  paramObject = paramc.getRuntime();
                  p.g(paramObject, "service.runtime");
                  i = paramObject.OJ();
                  paramObject = paramc.getRuntime();
                  p.g(paramObject, "service.runtime");
                  i.b(parama, i, paramObject.brf(), 778, 14);
                  if (paramc.getRuntime() == null) {
                    break label1215;
                  }
                  if (!paramBoolean) {
                    break label1152;
                  }
                  com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectWAGameContext, "WAGame.js", paramLong1, paramLong2);
                  AppMethodBeat.o(175210);
                }
              }
              break;
            case 293174862: 
              label424:
              label444:
              label589:
              if (((String)localObject1).equals("app-service.js"))
              {
                h.CyF.dN(370, 9);
                if (paramBoolean) {
                  if ((paramc.bsW()) || (paramc.isRunning()))
                  {
                    localObject2 = (AppBrandRuntime)paramc.getRuntime();
                    if ((paramObject instanceof m.c)) {
                      break label1221;
                    }
                    paramObject = null;
                  }
                }
              }
              break;
            }
            break;
          }
        }
      }
    }
    label698:
    label1215:
    label1221:
    for (;;)
    {
      m.c localc = (m.c)paramObject;
      if (localc != null)
      {
        paramLong1 = localc.dqk;
        if (localObject2 == null) {
          break label1022;
        }
        paramObject = ((AppBrandRuntime)localObject2).getAppId();
        label710:
        if (localObject2 == null) {
          break label1028;
        }
        localObject1 = Integer.valueOf(((AppBrandRuntime)localObject2).hashCode());
        label725:
        Log.i("MicroMsg.AppBrandServiceWCScriptReporter", "[QualitySystem] app-service.js runtime.appId=[%s], runtime.hashCode = [%d]", new Object[] { paramObject, localObject1 });
        paramc = (d)paramc;
        j = parama.czA;
        if (localObject2 == null) {
          break label1037;
        }
      }
      for (i = ((AppBrandRuntime)localObject2).hashCode();; i = -1)
      {
        b.a(paramc, "app-service.js", j, "", 0, paramLong1, i, localc);
        h.CyF.dN(370, 11);
        AppMethodBeat.o(175210);
        return;
        if (!((String)localObject1).equals("WAService.js")) {
          break;
        }
        break label313;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", "", paramLong1, paramLong2);
        break label375;
        if (!((String)localObject1).equals("WAService.js")) {
          break label424;
        }
        parama = new r(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7));
        break label444;
        if (!((String)localObject1).equals("WAServiceMainContext.js")) {
          break label424;
        }
        parama = new r(Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63));
        break label444;
        h.CyF.dN(370, k);
        i.cf(paramc.getAppId(), 24);
        if (paramc.getRuntime() != null)
        {
          parama = paramc.getRuntime();
          p.g(parama, "runtime");
          i = parama.bsB().leE.pkgVersion;
          if (paramc.getRuntime() == null) {
            break label1013;
          }
          parama = paramc.getRuntime();
          p.g(parama, "runtime");
        }
        label1013:
        for (j = parama.bsB().bAb();; j = -1)
        {
          i.b(paramc.getAppId(), i, j, 370, k);
          AppMethodBeat.o(175210);
          return;
          i = 0;
          break;
        }
        break label698;
        label1022:
        paramObject = null;
        break label710;
        localObject1 = Integer.valueOf(-1);
        break label725;
      }
      try
      {
        h.CyF.dN(370, 10);
        i.cf(paramc.getAppId(), 24);
        i.b(paramc.getAppId(), paramc.getRuntime().bsB().leE.pkgVersion, paramc.getRuntime().bsB().leE.kNW, 370, 10);
        AppMethodBeat.o(175210);
        return;
      }
      catch (NullPointerException paramc)
      {
        Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "Inject External Service Script Failed, report npe = %s", new Object[] { paramc });
        AppMethodBeat.o(175210);
        return;
      }
      b.bUZ();
      com.tencent.mm.plugin.appbrand.report.quality.c.a(paramc, (String)localObject1, parama.czA, paramLong1, paramLong2, paramObject);
      break label589;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectWAGameContext, "", "WAGame.js", paramLong1, paramLong2);
      AppMethodBeat.o(175210);
      return;
      Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "inject module(" + (String)localObject1 + ") script failed");
      h.CyF.dN(370, 32);
      AppMethodBeat.o(175210);
      return;
    }
  }
  
  public static final void b(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51008);
    p.h(paramc, "service");
    QualitySessionRuntime localQualitySessionRuntime = b.aeU(paramc.getAppId());
    if (localQualitySessionRuntime != null)
    {
      nj localnj = new nj();
      localnj.At(localQualitySessionRuntime.appId);
      localnj.xI(localQualitySessionRuntime.nLk);
      localnj.xJ(localQualitySessionRuntime.nJE);
      localnj.ajp();
      localnj.Au(paramString1);
      localnj.Av(paramString2);
      paramString1 = paramc.bqZ();
      if (paramString1 == null) {
        p.hyc();
      }
      localnj.Aw(paramString1.bvb());
      localnj.xK(localQualitySessionRuntime.apptype);
      localnj.xL(localQualitySessionRuntime.nLx.get());
      paramString1 = paramc.bsz();
      p.g(paramString1, "page");
      paramc = paramString1.getURL();
      paramString1 = paramString1.bRm();
      p.g(paramString1, "page.urlWithQuery");
      int i = paramc.length();
      if (paramString1 == null)
      {
        paramc = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(51008);
        throw paramc;
      }
      paramString1 = paramString1.substring(i);
      p.g(paramString1, "(this as java.lang.String).substring(startIndex)");
      localnj.Ax(paramc);
      localnj.Ay(paramString1);
      localnj.bfK();
      AppMethodBeat.o(51008);
      return;
    }
    AppMethodBeat.o(51008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.k
 * JD-Core Version:    0.7.0.1
 */