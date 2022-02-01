package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.autogen.mmdata.rpt.ta;
import com.tencent.mm.plugin.appbrand.ac.b.a;
import com.tencent.mm.plugin.appbrand.ac.b.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.n.t;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class e
  extends com.tencent.luggage.game.d.a.a.e
{
  e(com.tencent.luggage.sdk.b.a.d.d paramd, t paramt)
  {
    super(paramd, paramt);
  }
  
  private void b(e.a parama, String paramString)
  {
    AppMethodBeat.i(45086);
    com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.d.d)ari()).aa(com.tencent.luggage.game.d.a.a.b.class);
    if (localb != null) {
      localb.apg().a(parama, paramString);
    }
    AppMethodBeat.o(45086);
  }
  
  private static void iS(boolean paramBoolean)
  {
    AppMethodBeat.i(45087);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(370L, 40L, 1L, false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(370L, 49L, 1L, false);
      AppMethodBeat.o(45087);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(370L, 50L, 1L, false);
    AppMethodBeat.o(45087);
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.n.g paramg, String paramString)
  {
    AppMethodBeat.i(174724);
    Log.i("MicroMsg.WAGameJsContextInterfaceWC", "hy: injectWxaScript from js context interface: %s %d", new Object[] { paramString, Integer.valueOf(paramg.czh()) });
    a(paramg);
    boolean bool = Boolean.parseBoolean(((com.tencent.luggage.sdk.b.a.d.d)this.esk).cbl().UX("injectGameContextPlugin"));
    Log.i("MicroMsg.WAGameJsContextInterfaceWC", "injectGameContextPlugin :%b, abtest:%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(y.cgm()) });
    if ((!y.cgm()) || (!bool))
    {
      Log.i("MicroMsg.WAGameJsContextInterfaceWC", "injectPluginCodeNewLogic");
      if (paramString.equals("game.js"))
      {
        Object localObject2 = ((com.tencent.luggage.sdk.b.a.d.d)this.esk).aqZ().asz().qYY.qHT;
        Object localObject1 = null;
        if (localObject2 != null) {
          localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).VE("__APP__");
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
        if ((((com.tencent.luggage.sdk.b.a.d.d)ari()).cdi()) || (((com.tencent.luggage.sdk.b.a.d.d)ari()).isRunning()))
        {
          int k;
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject1 = ((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ();
            localObject2 = parama.scriptName;
            if (localObject1 == null) {
              break label233;
            }
            i = localObject1.hashCode();
            Log.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d]", new Object[] { localObject2, Integer.valueOf(i) });
            localObject2 = this.esk;
            localObject3 = parama.scriptName;
            j = parama.eqQ;
            str = parama.qEr;
            k = parama.appVersion;
            if (localObject1 == null) {
              break label239;
            }
          }
          label233:
          label239:
          for (i = localObject1.hashCode();; i = -1)
          {
            com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.g)localObject2, (String)localObject3, j, str, k, paramLong1, i, paramObject);
            b(e.a.elw, "plugin " + parama.qEr + " inject success!");
            iS(true);
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
        b(e.a.ely, "plugin " + parama.qEr + " inject fail!");
        iS(false);
        AppMethodBeat.o(174726);
      }
    }
    else
    {
      if ("WAGameSubContext.js".equals(localObject1))
      {
        long l;
        if ((paramBoolean) && ((((com.tencent.luggage.sdk.b.a.d.d)ari()).cdi()) || (((com.tencent.luggage.sdk.b.a.d.d)ari()).isRunning())))
        {
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.cJb().k(ari()).zt((String)localObject1);
            ((ta)localObject1).jAh = parama.eqQ;
            if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.sTm.length)) {
              break label583;
            }
            l = v.sTm[paramObject.codeCacheStatus];
            label409:
            ((ta)localObject1).jAk = l;
            ((ta)localObject1).jAl = 1L;
            if (paramObject == null) {
              break label591;
            }
            l = paramObject.flatJSCompileCost;
            label434:
            ((ta)localObject1).jAm = l;
            if (paramObject == null) {
              break label597;
            }
            l = paramObject.hng;
            label454:
            ((ta)localObject1).jAF = l;
            ((ta)localObject1).fZ(paramLong1);
            ((ta)localObject1).ga(paramLong2);
            ((ta)localObject1).fY(((ta)localObject1).jyJ - ((ta)localObject1).jyI);
            ((ta)localObject1).bMH();
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(778L, 17L, 1L, false);
          if (!paramBoolean) {
            break label603;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(778L, 19L, 1L, false);
        }
        for (;;)
        {
          if (((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ() == null) {
            break label1148;
          }
          if (!paramBoolean) {
            break label691;
          }
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), KSProcessWeAppLaunch.stepInjectWAGameSubContext, "WAGameSubContext.js", paramLong1, paramLong2);
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(778L, 18L, 1L, false);
          j.de(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), 24);
          j.b(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), ((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ().asz().qYY.pkgVersion, ((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ().asz().qYY.qHO, 778, 18);
        }
        label691:
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WAGameSubContext.js", paramLong1, paramLong2);
        AppMethodBeat.o(174726);
        return;
      }
      if (((String)localObject1).endsWith("game.js"))
      {
        if ((((com.tencent.luggage.sdk.b.a.d.d)ari()).cdi()) || (((com.tencent.luggage.sdk.b.a.d.d)ari()).isRunning()))
        {
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject2 = ((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ();
            if (localObject2 == null) {
              break label1008;
            }
            i = localObject2.hashCode();
            label798:
            Log.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
            localObject3 = this.esk;
            str = parama.scriptName;
            j = parama.eqQ;
            if (localObject2 == null) {
              break label1014;
            }
            i = localObject2.hashCode();
            label848:
            com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.g)localObject3, str, j, "", 0, paramLong1, i, paramObject);
          }
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(778L, 21L, 1L, false);
          if (!paramBoolean) {
            break label1020;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(778L, 23L, 1L, false);
        }
        for (;;)
        {
          b.a.cJD();
          com.tencent.mm.plugin.appbrand.ac.b.b("WeAppLaunch", ((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), b.b.tVv);
          if (((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ() == null) {
            break label1148;
          }
          AppBrandPerformanceManager.a(((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ(), 204, paramLong2 - paramLong1);
          if (!paramBoolean) {
            break label1108;
          }
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), KSProcessWeAppLaunch.stepInjectJSGame, (String)localObject1, paramLong1, paramLong2);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), KSProcessWeAppLaunch.stepServiceInit_Game);
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(778L, 22L, 1L, false);
          j.de(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), 24);
          j.b(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), ((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ().asz().qYY.pkgVersion, ((com.tencent.luggage.sdk.b.a.d.d)ari()).aqZ().asz().qYY.qHO, 778, 22);
        }
        label1108:
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), KSProcessWeAppLaunch.stepInjectJSGame, "", (String)localObject1, paramLong1, paramLong2);
        com.tencent.mm.plugin.appbrand.keylogger.c.c(((com.tencent.luggage.sdk.b.a.d.d)ari()).getAppId(), KSProcessWeAppLaunch.stepServiceInit_Game);
      }
    }
    label1148:
    AppMethodBeat.o(174726);
  }
  
  public final int apz()
  {
    AppMethodBeat.i(45089);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkj, 0);
    AppMethodBeat.o(45089);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e
 * JD-Core Version:    0.7.0.1
 */