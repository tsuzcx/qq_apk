package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.n.n;
import d.t;
import d.v;
import java.util.concurrent.atomic.AtomicInteger;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceWCScriptReporter;", "", "()V", "TAG", "", "reportEvaluateResult", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "scriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportJSError", "message", "stackTrace", "plugin-appbrand-integration_release"})
public final class i
{
  public static final i lRE;
  
  static
  {
    AppMethodBeat.i(51009);
    lRE = new i();
    AppMethodBeat.o(51009);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.service.c paramc, d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175210);
    k.h(paramc, "service");
    k.h(parama, "scriptInfo");
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
      ac.e("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, !succeed name[" + (String)localObject1 + "], appId[" + paramc.getAppId() + ']');
      if ((parama.cdf <= 0) && (localObject1 != null)) {}
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
      if (n.nc((String)localObject1, "/app-service.js"))
      {
        h.wUl.dB(370, 30);
        if (paramBoolean)
        {
          h.wUl.dB(370, 31);
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
            h.wUl.dB(370, 73);
            break;
          case 2071195020: 
            if (!((String)localObject1).equals("WAService.js")) {
              break;
            }
            h.wUl.dB(370, 72);
            break;
            switch (((String)localObject1).hashCode())
            {
            default: 
              break;
            case -979125780: 
              if (((String)localObject1).equals("WAServiceMainContext.js"))
              {
                ac.i("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, service_lib_script[" + (String)localObject1 + "], succeed[" + paramBoolean + ']');
                if (paramc.getRuntime() != null)
                {
                  if (paramBoolean) {
                    com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", paramLong1, paramLong2);
                  }
                }
                else
                {
                  a.btI();
                  b.a(paramc, (String)localObject1, parama.cdf, paramLong1, paramLong2, paramObject);
                  switch (((String)localObject1).hashCode())
                  {
                  default: 
                    parama = new t(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    i = ((Number)parama.first).intValue();
                    k = ((Number)parama.second).intValue();
                    j = ((Number)parama.KTn).intValue();
                    h.wUl.dB(370, i);
                    if (paramBoolean)
                    {
                      h.wUl.dB(370, j);
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
                  g.bP(paramc.getAppId(), 24);
                  parama = paramc.getAppId();
                  paramObject = paramc.getRuntime();
                  k.g(paramObject, "service.runtime");
                  i = paramObject.Dy();
                  paramc = paramc.getRuntime();
                  k.g(paramc, "service.runtime");
                  g.b(parama, i, paramc.aSy(), 778, 14);
                  AppMethodBeat.o(175210);
                  return;
                }
              }
              break;
            case 293174862: 
              label424:
              label444:
              if (((String)localObject1).equals("app-service.js"))
              {
                h.wUl.dB(370, 9);
                if (paramBoolean) {
                  if ((paramc.aUl()) || (paramc.isRunning()))
                  {
                    localObject2 = (AppBrandRuntime)paramc.getRuntime();
                    if ((paramObject instanceof m.c)) {
                      break label1172;
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
    label1172:
    for (;;)
    {
      m.c localc = (m.c)paramObject;
      if (localc != null)
      {
        paramLong1 = localc.cNs;
        label669:
        if (localObject2 == null) {
          break label993;
        }
        paramObject = ((AppBrandRuntime)localObject2).getAppId();
        label681:
        if (localObject2 == null) {
          break label999;
        }
        localObject1 = Integer.valueOf(((AppBrandRuntime)localObject2).hashCode());
        label696:
        ac.i("MicroMsg.AppBrandServiceWCScriptReporter", "[QualitySystem] app-service.js runtime.appId=[%s], runtime.hashCode = [%d]", new Object[] { paramObject, localObject1 });
        paramc = (d)paramc;
        j = parama.cdf;
        if (localObject2 == null) {
          break label1008;
        }
      }
      label984:
      label993:
      label999:
      label1008:
      for (i = ((AppBrandRuntime)localObject2).hashCode();; i = -1)
      {
        a.a(paramc, "app-service.js", j, "", 0, paramLong1, i, localc);
        h.wUl.dB(370, 11);
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
        parama = new t(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7));
        break label444;
        if (!((String)localObject1).equals("WAServiceMainContext.js")) {
          break label424;
        }
        parama = new t(Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63));
        break label444;
        h.wUl.dB(370, k);
        g.bP(paramc.getAppId(), 24);
        if (paramc.getRuntime() != null)
        {
          parama = paramc.getRuntime();
          k.g(parama, "runtime");
          i = parama.aTR().jEg.pkgVersion;
          if (paramc.getRuntime() == null) {
            break label984;
          }
          parama = paramc.getRuntime();
          k.g(parama, "runtime");
        }
        for (j = parama.aTR().baE();; j = -1)
        {
          g.b(paramc.getAppId(), i, j, 370, k);
          AppMethodBeat.o(175210);
          return;
          i = 0;
          break;
        }
        break label669;
        paramObject = null;
        break label681;
        localObject1 = Integer.valueOf(-1);
        break label696;
      }
      try
      {
        h.wUl.dB(370, 10);
        g.bP(paramc.getAppId(), 24);
        g.b(paramc.getAppId(), paramc.getRuntime().aTR().jEg.pkgVersion, paramc.getRuntime().aTR().jEg.jpa, 370, 10);
        AppMethodBeat.o(175210);
        return;
      }
      catch (NullPointerException paramc)
      {
        ac.e("MicroMsg.AppBrandServiceWCScriptReporter", "Inject External Service Script Failed, report npe = %s", new Object[] { paramc });
        AppMethodBeat.o(175210);
        return;
      }
      a.btI();
      b.a(paramc, (String)localObject1, parama.cdf, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(175210);
      return;
      ac.e("MicroMsg.AppBrandServiceWCScriptReporter", "inject module(" + (String)localObject1 + ") script failed");
      h.wUl.dB(370, 32);
      AppMethodBeat.o(175210);
      return;
    }
  }
  
  public static final void b(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51008);
    k.h(paramc, "service");
    QualitySessionRuntime localQualitySessionRuntime = a.QN(paramc.getAppId());
    if (localQualitySessionRuntime != null)
    {
      if localif = new if();
      localif.pg(localQualitySessionRuntime.appId);
      localif.nI(localQualitySessionRuntime.lVs);
      localif.nJ(localQualitySessionRuntime.lTR);
      localif.Te();
      localif.ph(paramString1);
      localif.pi(paramString2);
      paramString1 = paramc.aSt();
      if (paramString1 == null) {
        k.fOy();
      }
      localif.pj(paramString1.aVS());
      localif.nK(localQualitySessionRuntime.apptype);
      localif.nL(localQualitySessionRuntime.lVF.get());
      paramString1 = paramc.aTP();
      k.g(paramString1, "page");
      paramc = paramString1.getURL();
      paramString1 = paramString1.bqA();
      k.g(paramString1, "page.urlWithQuery");
      int i = paramc.length();
      if (paramString1 == null)
      {
        paramc = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(51008);
        throw paramc;
      }
      paramString1 = paramString1.substring(i);
      k.g(paramString1, "(this as java.lang.String).substring(startIndex)");
      localif.pk(paramc);
      localif.pl(paramString1);
      localif.aHZ();
      AppMethodBeat.o(51008);
      return;
    }
    AppMethodBeat.o(51008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.i
 * JD-Core Version:    0.7.0.1
 */