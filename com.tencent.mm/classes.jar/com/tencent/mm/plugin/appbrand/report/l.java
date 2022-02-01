package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.autogen.mmdata.rpt.ud;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.u;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceWCScriptReporter;", "", "()V", "TAG", "", "reportEvaluateResult", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "scriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportJSError", "message", "stackTrace", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l tOg;
  
  static
  {
    AppMethodBeat.i(51009);
    tOg = new l();
    AppMethodBeat.o(51009);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.service.c paramc, d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175210);
    s.u(paramc, "service");
    s.u(parama, "scriptInfo");
    String str = parama.scriptName;
    Object localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(175210);
      return;
    }
    if (!paramBoolean)
    {
      Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, !succeed name[" + str + "], appId[" + paramc.getAppId() + ']');
      if (parama.eqQ <= 0)
      {
        s.s(str, "name");
        if (!s.p(str, "WAService.js")) {
          break label238;
        }
        h.OAn.kJ(370, 72);
      }
    }
    s.s(str, "name");
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      if (kotlin.n.n.rs(str, "/app-service.js"))
      {
        h.OAn.kJ(370, 30);
        if (paramBoolean)
        {
          h.OAn.kJ(370, 31);
          AppMethodBeat.o(175210);
          return;
          label238:
          if (!s.p(str, "WAServiceMainContext.js")) {
            break;
          }
          h.OAn.kJ(370, 73);
          break;
          if (!str.equals("WAGame.js")) {
            continue;
          }
          if (!paramBoolean)
          {
            j.de(paramc.getAppId(), 24);
            j.b(paramc.getAppId(), paramc.getRuntime().asw(), paramc.getRuntime().qsh.eul, 778, 14);
          }
          for (;;)
          {
            if (paramc.getRuntime() == null) {
              break label1104;
            }
            if (!paramBoolean) {
              break label1041;
            }
            com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectWAGameContext, "WAGame.js", paramLong1, paramLong2);
            AppMethodBeat.o(175210);
            return;
            if (!str.equals("app-service.js")) {
              break;
            }
            h.OAn.kJ(370, 9);
            label516:
            label902:
            label912:
            if (paramBoolean)
            {
              label409:
              label414:
              label422:
              label430:
              int j;
              if ((paramc.cdi()) || (paramc.isRunning()))
              {
                localObject = (AppBrandRuntime)paramc.getRuntime();
                if (!(paramObject instanceof m.c)) {
                  break label887;
                }
                paramObject = (m.c)paramObject;
                if (paramObject != null) {
                  break label893;
                }
                if (localObject != null) {
                  break label902;
                }
                str = null;
                if (localObject != null) {
                  break label912;
                }
                i = -1;
                Log.i("MicroMsg.AppBrandServiceWCScriptReporter", "[QualitySystem] app-service.js runtime.appId=[%s], runtime.hashCode = [%d]", new Object[] { str, Integer.valueOf(i) });
                paramc = (g)paramc;
                j = parama.eqQ;
                if (localObject != null) {
                  break label922;
                }
              }
              label789:
              label922:
              for (i = -1;; i = ((AppBrandRuntime)localObject).hashCode())
              {
                b.a(paramc, "app-service.js", j, "", 0, paramLong1, i, paramObject);
                h.OAn.kJ(370, 11);
                AppMethodBeat.o(175210);
                return;
                if (!str.equals("WAService.js")) {
                  break;
                }
                Log.i("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, service_lib_script[" + str + "], succeed[" + paramBoolean + ']');
                if (paramc.getRuntime() != null)
                {
                  if (paramBoolean) {
                    com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", paramLong1, paramLong2);
                  }
                }
                else
                {
                  label578:
                  b.cJb();
                  com.tencent.mm.plugin.appbrand.report.quality.c.a(paramc, str, parama.eqQ, paramLong1, paramLong2, paramObject);
                  if (!s.p(str, "WAService.js")) {
                    break label730;
                  }
                  parama = new u(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7));
                }
                int k;
                for (;;)
                {
                  i = ((Number)parama.bsC).intValue();
                  k = ((Number)parama.bsD).intValue();
                  j = ((Number)parama.aiuN).intValue();
                  h.OAn.kJ(370, i);
                  if (!paramBoolean) {
                    break label789;
                  }
                  h.OAn.kJ(370, j);
                  AppMethodBeat.o(175210);
                  return;
                  if (!str.equals("WAServiceMainContext.js")) {
                    break;
                  }
                  break label516;
                  com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", "", paramLong1, paramLong2);
                  break label578;
                  label730:
                  if (s.p(str, "WAServiceMainContext.js")) {
                    parama = new u(Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63));
                  } else {
                    parama = new u(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                  }
                }
                h.OAn.kJ(370, k);
                j.de(paramc.getAppId(), 24);
                if (paramc.getRuntime() != null)
                {
                  i = paramc.getRuntime().ccM().qYY.pkgVersion;
                  if (paramc.getRuntime() == null) {
                    break label881;
                  }
                }
                label881:
                for (j = paramc.getRuntime().ccM().qYY.qHO;; j = -1)
                {
                  j.b(paramc.getAppId(), i, j, 370, k);
                  AppMethodBeat.o(175210);
                  return;
                  i = 0;
                  break;
                }
                label887:
                paramObject = null;
                break label409;
                label893:
                paramLong1 = paramObject.hne;
                break label414;
                str = ((AppBrandRuntime)localObject).mAppId;
                break label422;
                i = ((AppBrandRuntime)localObject).hashCode();
                break label430;
              }
            }
            try
            {
              h.OAn.kJ(370, 10);
              j.de(paramc.getAppId(), 24);
              j.b(paramc.getAppId(), paramc.getRuntime().ccM().qYY.pkgVersion, paramc.getRuntime().ccM().qYY.qHO, 370, 10);
              AppMethodBeat.o(175210);
              return;
            }
            catch (NullPointerException paramc)
            {
              Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "Inject External Service Script Failed, report npe = %s", new Object[] { paramc });
              AppMethodBeat.o(175210);
              return;
            }
            b.cJb();
            com.tencent.mm.plugin.appbrand.report.quality.c.a(paramc, str, parama.eqQ, paramLong1, paramLong2, paramObject);
          }
          label1041:
          com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectWAGameContext, "", "WAGame.js", paramLong1, paramLong2);
          AppMethodBeat.o(175210);
          return;
        }
        Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "inject module(" + str + ") script failed");
        h.OAn.kJ(370, 32);
      }
    }
    label1104:
    AppMethodBeat.o(175210);
  }
  
  public static final void b(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51008);
    s.u(paramc, "service");
    QualitySessionRuntime localQualitySessionRuntime = b.afZ(paramc.getAppId());
    if (localQualitySessionRuntime != null)
    {
      ud localud = new ud();
      localud.ipx = localud.F("appid", localQualitySessionRuntime.appId, true);
      localud.iFA = localQualitySessionRuntime.tSh;
      localud.jFA = localQualitySessionRuntime.tQx;
      localud.jFB = 9;
      localud.jFD = localud.F("errorMessage", paramString1, true);
      localud.jFE = localud.F("errorStack", paramString2, true);
      paramString1 = paramc.cbl();
      s.checkNotNull(paramString1);
      localud.jFF = localud.F("sdkversion", paramString1.cfD(), true);
      paramString1 = paramc.cbl();
      s.checkNotNull(paramString1);
      localud.jFI = localud.F("sdkupdatetime", paramString1.cfF(), true);
      localud.jFG = localQualitySessionRuntime.apptype;
      localud.jBN = localQualitySessionRuntime.tSu.get();
      paramc = paramc.ccK();
      paramString2 = paramc.cgR();
      paramString1 = i.jZ(paramc.cEE(), paramString2.length());
      paramc = paramString1;
      if (paramString1 == null) {
        paramc = "";
      }
      localud.jFH = localud.F("route", r.cg(paramString2), true);
      localud.iKB = localud.F("query", r.cg(paramc), true);
      localud.iEy = localud.F("networkType", w.cID(), true);
      localud.bMH();
    }
    AppMethodBeat.o(51008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.l
 * JD-Core Version:    0.7.0.1
 */