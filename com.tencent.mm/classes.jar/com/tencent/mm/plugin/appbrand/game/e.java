package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.plugin.appbrand.aa.b.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class e
  extends com.tencent.luggage.game.d.a.a.e
{
  e(com.tencent.luggage.sdk.b.a.c.d paramd, t paramt)
  {
    super(paramd, paramt);
  }
  
  private void b(e.a parama, String paramString)
  {
    AppMethodBeat.i(45086);
    com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c.d)NY()).S(com.tencent.luggage.game.d.a.a.b.class);
    if (localb != null) {
      localb.Mg().a(parama, paramString);
    }
    AppMethodBeat.o(45086);
  }
  
  private static void hc(boolean paramBoolean)
  {
    AppMethodBeat.i(45087);
    h.CyF.idkeyStat(370L, 40L, 1L, false);
    if (paramBoolean)
    {
      h.CyF.idkeyStat(370L, 49L, 1L, false);
      AppMethodBeat.o(45087);
      return;
    }
    h.CyF.idkeyStat(370L, 50L, 1L, false);
    AppMethodBeat.o(45087);
  }
  
  public final int Mz()
  {
    AppMethodBeat.i(45089);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.shG, 0);
    AppMethodBeat.o(45089);
    return i;
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.m.g paramg, String paramString)
  {
    AppMethodBeat.i(174724);
    Log.i("MicroMsg.WAGameJsContextInterfaceWC", "hy: injectWxaScript from js context interface: %s %d", new Object[] { paramString, Integer.valueOf(paramg.bMC()) });
    boolean bool = Boolean.parseBoolean(((com.tencent.luggage.sdk.b.a.c.d)this.cAJ).bqZ().UN("injectGameContextPlugin"));
    Log.i("MicroMsg.WAGameJsContextInterfaceWC", "injectGameContextPlugin :%b, abtest:%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.plugin.appbrand.appcache.v.bvH()) });
    if ((!com.tencent.mm.plugin.appbrand.appcache.v.bvH()) || (!bool))
    {
      Log.i("MicroMsg.WAGameJsContextInterfaceWC", "injectPluginCodeNewLogic");
      if (paramString.equals("game.js"))
      {
        Object localObject2 = ((com.tencent.luggage.sdk.b.a.c.d)this.cAJ).NP().OM().leE.kOb;
        Object localObject1 = null;
        if (localObject2 != null) {
          localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).Vz("__APP__");
        }
        while ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          Log.i("MicroMsg.WAGameJsContextInterfaceWC", "client inject pluginCode size:%s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
            List localList = ((WxaPluginPkgInfo)localObject2).contexts;
            if (localList != null) {
              Log.d("MicroMsg.WAGameJsContextInterfaceWC", "multiPkg contexts size:%d,contexts:%s", new Object[] { Integer.valueOf(localList.size()), Arrays.toString(localList.toArray()) });
            }
            if ((localList != null) && (localList.contains(Integer.valueOf(0))))
            {
              localObject2 = ((WxaPluginPkgInfo)localObject2).prefixPath + "/plugin.js";
              Log.d("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodefilePath:%s", new Object[] { localObject2 });
              super.a(paramg, (String)localObject2);
            }
          }
          Log.e("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodeList wxaRuntimeModulePluginListMap null");
        }
      }
    }
    super.a(paramg, paramString);
    AppMethodBeat.o(174724);
    return 1;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(174726);
    Object localObject1 = parama.scriptName;
    Object localObject2;
    int i;
    label98:
    Object localObject3;
    int j;
    String str;
    if (((String)localObject1).endsWith("plugin.js"))
    {
      if (paramBoolean)
      {
        if ((((com.tencent.luggage.sdk.b.a.c.d)NY()).bsW()) || (((com.tencent.luggage.sdk.b.a.c.d)NY()).isRunning()))
        {
          int k;
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject1 = ((com.tencent.luggage.sdk.b.a.c.d)NY()).NP();
            localObject2 = parama.scriptName;
            if (localObject1 == null) {
              break label233;
            }
            i = localObject1.hashCode();
            Log.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d]", new Object[] { localObject2, Integer.valueOf(i) });
            localObject2 = this.cAJ;
            localObject3 = parama.scriptName;
            j = parama.czA;
            str = parama.kKF;
            k = parama.appVersion;
            if (localObject1 == null) {
              break label239;
            }
          }
          label233:
          label239:
          for (i = localObject1.hashCode();; i = -1)
          {
            com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.d)localObject2, (String)localObject3, j, str, k, paramLong1, i, paramObject);
            b(e.a.cvn, "plugin " + parama.kKF + " inject success!");
            hc(true);
            AppMethodBeat.o(174726);
            return;
            paramObject = null;
            break;
            i = -1;
            break label98;
          }
        }
      }
      else
      {
        b(e.a.cvp, "plugin " + parama.kKF + " inject fail!");
        hc(false);
        AppMethodBeat.o(174726);
      }
    }
    else
    {
      if ("WAGameSubContext.js".equals(localObject1))
      {
        long l;
        if ((paramBoolean) && ((((com.tencent.luggage.sdk.b.a.c.d)NY()).bsW()) || (((com.tencent.luggage.sdk.b.a.c.d)NY()).isRunning())))
        {
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.bUZ().l(NY()).zy((String)localObject1);
            ((mj)localObject1).fbD = parama.czA;
            if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= com.tencent.mm.plugin.appbrand.m.v.mNV.length)) {
              break label583;
            }
            l = com.tencent.mm.plugin.appbrand.m.v.mNV[paramObject.codeCacheStatus];
            label409:
            ((mj)localObject1).fbG = l;
            ((mj)localObject1).fbH = 1L;
            if (paramObject == null) {
              break label591;
            }
            l = paramObject.flatJSCompileCost;
            label434:
            ((mj)localObject1).fbI = l;
            if (paramObject == null) {
              break label597;
            }
            l = paramObject.dqm;
            label454:
            ((mj)localObject1).fca = l;
            ((mj)localObject1).vX(paramLong1);
            ((mj)localObject1).vY(paramLong2);
            ((mj)localObject1).vW(((mj)localObject1).fae - ((mj)localObject1).fad);
            ((mj)localObject1).bfK();
          }
        }
        else
        {
          h.CyF.idkeyStat(778L, 17L, 1L, false);
          if (!paramBoolean) {
            break label603;
          }
          h.CyF.idkeyStat(778L, 19L, 1L, false);
        }
        for (;;)
        {
          if (((com.tencent.luggage.sdk.b.a.c.d)NY()).NP() == null) {
            break label1148;
          }
          if (!paramBoolean) {
            break label691;
          }
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), KSProcessWeAppLaunch.stepInjectWAGameSubContext, "WAGameSubContext.js", paramLong1, paramLong2);
          AppMethodBeat.o(174726);
          return;
          paramObject = null;
          break;
          label583:
          l = 4L;
          break label409;
          label591:
          l = 0L;
          break label434;
          label597:
          l = 0L;
          break label454;
          label603:
          h.CyF.idkeyStat(778L, 18L, 1L, false);
          i.cf(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), 24);
          i.b(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), ((com.tencent.luggage.sdk.b.a.c.d)NY()).NP().OM().leE.pkgVersion, ((com.tencent.luggage.sdk.b.a.c.d)NY()).NP().OM().leE.kNW, 778, 18);
        }
        label691:
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WAGameSubContext.js", paramLong1, paramLong2);
        AppMethodBeat.o(174726);
        return;
      }
      if (((String)localObject1).endsWith("game.js"))
      {
        if ((((com.tencent.luggage.sdk.b.a.c.d)NY()).bsW()) || (((com.tencent.luggage.sdk.b.a.c.d)NY()).isRunning()))
        {
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject2 = ((com.tencent.luggage.sdk.b.a.c.d)NY()).NP();
            if (localObject2 == null) {
              break label1008;
            }
            i = localObject2.hashCode();
            label798:
            Log.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
            localObject3 = this.cAJ;
            str = parama.scriptName;
            j = parama.czA;
            if (localObject2 == null) {
              break label1014;
            }
            i = localObject2.hashCode();
            label848:
            com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.d)localObject3, str, j, "", 0, paramLong1, i, paramObject);
          }
        }
        else
        {
          h.CyF.idkeyStat(778L, 21L, 1L, false);
          if (!paramBoolean) {
            break label1020;
          }
          h.CyF.idkeyStat(778L, 23L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.aa.b.a.bVD();
          com.tencent.mm.plugin.appbrand.aa.b.b("WeAppLaunch", ((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), b.b.nOi);
          if (((com.tencent.luggage.sdk.b.a.c.d)NY()).NP() == null) {
            break label1148;
          }
          AppBrandPerformanceManager.a(((com.tencent.luggage.sdk.b.a.c.d)NY()).NP(), 204, paramLong2 - paramLong1);
          if (!paramBoolean) {
            break label1108;
          }
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSGame, (String)localObject1, paramLong1, paramLong2);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), KSProcessWeAppLaunch.stepServiceInit_Game);
          AppMethodBeat.o(174726);
          return;
          paramObject = null;
          break;
          label1008:
          i = -1;
          break label798;
          label1014:
          i = -1;
          break label848;
          label1020:
          h.CyF.idkeyStat(778L, 22L, 1L, false);
          i.cf(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), 24);
          i.b(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), ((com.tencent.luggage.sdk.b.a.c.d)NY()).NP().OM().leE.pkgVersion, ((com.tencent.luggage.sdk.b.a.c.d)NY()).NP().OM().leE.kNW, 778, 22);
        }
        label1108:
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSGame, "", (String)localObject1, paramLong1, paramLong2);
        com.tencent.mm.plugin.appbrand.keylogger.c.c(((com.tencent.luggage.sdk.b.a.c.d)NY()).getAppId(), KSProcessWeAppLaunch.stepServiceInit_Game);
      }
    }
    label1148:
    AppMethodBeat.o(174726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e
 * JD-Core Version:    0.7.0.1
 */