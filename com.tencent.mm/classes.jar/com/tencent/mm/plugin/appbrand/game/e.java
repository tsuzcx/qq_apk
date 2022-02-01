package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.plugin.appbrand.y.b.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class e
  extends com.tencent.luggage.game.d.a.a.d
{
  e(com.tencent.luggage.sdk.b.a.c.c paramc, t paramt)
  {
    super(paramc, paramt);
  }
  
  private int a(String paramString, com.tencent.mm.plugin.appbrand.jsruntime.g paramg)
  {
    AppMethodBeat.i(195767);
    ad.i("MicroMsg.WAGameJsContextInterfaceWC", "injectPluginCodeNewLogic");
    if (paramString.equals("game.js"))
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)this.chm).Dl().DY().jdS.iOV;
      paramString = null;
      if (localObject != null) {
        paramString = ((WxaRuntimeModulePluginListMap)localObject).Et("__APP__");
      }
      while ((paramString != null) && (paramString.size() > 0))
      {
        ad.i("MicroMsg.WAGameJsContextInterfaceWC", "client inject pluginCode size:%s", new Object[] { Integer.valueOf(paramString.size()) });
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (WxaPluginPkgInfo)paramString.next();
          List localList = ((WxaPluginPkgInfo)localObject).contexts;
          if (localList != null) {
            ad.d("MicroMsg.WAGameJsContextInterfaceWC", "multiPkg contexts size:%d,contexts:%s", new Object[] { Integer.valueOf(localList.size()), Arrays.toString(localList.toArray()) });
          }
          if ((localList != null) && (localList.contains(Integer.valueOf(0))))
          {
            localObject = ((WxaPluginPkgInfo)localObject).prefixPath + "/plugin.js";
            ad.d("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodefilePath:%s", new Object[] { localObject });
            super.a(paramg, (String)localObject);
          }
        }
        ad.e("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodeList wxaRuntimeModulePluginListMap null");
      }
    }
    AppMethodBeat.o(195767);
    return 1;
  }
  
  private boolean a(String paramString1, int paramInt, String paramString2, com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString3)
  {
    AppMethodBeat.i(174725);
    String str2 = "plugin.js_".concat(String.valueOf(paramString1));
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(174725);
      return false;
    }
    ad.i("MicroMsg.WAGameJsContextInterfaceWC", "provider:%s,version:%s,pluginCodePath:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3 });
    long l = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final i locali = new i();
    final PInt localPInt = new PInt();
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)this.chm).Dl().DY().jdS.iOT;
    String str1 = "";
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
      if ((localModulePkgInfo.name != null) && (paramString3.startsWith(localModulePkgInfo.name))) {
        str1 = localModulePkgInfo.pkgPath;
      }
    }
    r.a(((com.tencent.luggage.sdk.b.a.c.c)Du()).Dl(), paramg, str1, "plugin.js", str2, paramString2, r.a.lMy, new q.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        locali.value = paramAnonymousc;
        localPInt.value = paramAnonymousc.sourceLength;
      }
      
      public final void cj(String paramAnonymousString)
      {
        localPBool.value = false;
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        localPBool.value = true;
      }
    });
    int i;
    if (localPBool.value) {
      if ((((com.tencent.luggage.sdk.b.a.c.c)Du()).aNv()) || (((com.tencent.luggage.sdk.b.a.c.c)Du()).isRunning()))
      {
        paramString2 = ((com.tencent.luggage.sdk.b.a.c.c)Du()).Dl();
        if (paramString2 != null)
        {
          i = paramString2.hashCode();
          ad.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d], scriptLen = [%d]", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(localPInt.value) });
          paramg = this.chm;
          int j = localPInt.value;
          if (paramString2 == null) {
            break label402;
          }
          i = paramString2.hashCode();
          label332:
          a.a(paramg, paramString3, j, paramString1, paramInt, l, i, (m.c)locali.value);
          b(e.a.cca, "plugin " + paramString1 + " inject success!");
        }
      }
      else
      {
        fG(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(174725);
      return true;
      i = -1;
      break;
      label402:
      i = -1;
      break label332;
      b(e.a.ccc, "plugin " + paramString1 + " inject fail!");
      fG(false);
    }
  }
  
  private void b(e.a parama, String paramString)
  {
    AppMethodBeat.i(45086);
    com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c.c)Du()).Q(com.tencent.luggage.game.d.a.a.b.class);
    if (localb != null) {
      localb.BE().a(parama, paramString);
    }
    AppMethodBeat.o(45086);
  }
  
  private static void fG(boolean paramBoolean)
  {
    AppMethodBeat.i(45087);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(370L, 40L, 1L, false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(370L, 49L, 1L, false);
      AppMethodBeat.o(45087);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(370L, 50L, 1L, false);
    AppMethodBeat.o(45087);
  }
  
  public final int BX()
  {
    AppMethodBeat.i(45089);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pul, 0);
    AppMethodBeat.o(45089);
    return i;
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString)
  {
    AppMethodBeat.i(174724);
    ad.i("MicroMsg.WAGameJsContextInterfaceWC", "hy: injectWxaScript from js context interface: %s %d", new Object[] { paramString, Integer.valueOf(paramg.bfC()) });
    boolean bool = Boolean.parseBoolean(((com.tencent.luggage.sdk.b.a.c.c)this.chm).aLC().DI("injectGameContextPlugin"));
    ad.i("MicroMsg.WAGameJsContextInterfaceWC", "injectGameContextPlugin :%b, abtest:%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(u.aPH()) });
    Object localObject3 = ((com.tencent.luggage.sdk.b.a.c.c)this.chm).Dl().DY().cfV;
    Object localObject1;
    Object localObject2;
    int i;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      Object localObject4;
      if (((!u.aPH()) || (!bool)) && (paramString.equals("game.js")))
      {
        ad.i("MicroMsg.WAGameJsContextInterfaceWC", "client inject pluginCode size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject1).next();
          localObject4 = ((WxaAttributes.WxaPluginCodeInfo)localObject2).contexts;
          if (localObject4 != null) {
            ad.d("MicroMsg.WAGameJsContextInterfaceWC", "multiPkg contexts size:%d,contexts:%s", new Object[] { Integer.valueOf(((List)localObject4).size()), Arrays.toString(((List)localObject4).toArray()) });
          }
          if ((localObject4 != null) && (((List)localObject4).contains(Integer.valueOf(0))))
          {
            localObject4 = ((WxaAttributes.WxaPluginCodeInfo)localObject2).provider;
            localObject4 = "/__plugin__/" + (String)localObject4 + "/plugin.js";
            a(((WxaAttributes.WxaPluginCodeInfo)localObject2).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject2).version, ((WxaAttributes.WxaPluginCodeInfo)localObject2).md5, paramg, (String)localObject4);
          }
        }
      }
      if ((paramString != null) && (paramString.startsWith("__plugin__/")))
      {
        localObject2 = "";
        localObject4 = paramString.split("/");
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject2;
          if (localObject4.length == 3) {
            localObject1 = localObject4[1];
          }
        }
        localObject2 = "";
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject3).next();
          if ((((WxaAttributes.WxaPluginCodeInfo)localObject4).provider != null) && (((WxaAttributes.WxaPluginCodeInfo)localObject4).provider.equals(localObject1)))
          {
            i = ((WxaAttributes.WxaPluginCodeInfo)localObject4).version;
            localObject2 = ((WxaAttributes.WxaPluginCodeInfo)localObject4).md5;
          }
        }
      }
    }
    for (;;)
    {
      a((String)localObject1, i, (String)localObject2, paramg, "/".concat(String.valueOf(paramString)));
      for (;;)
      {
        AppMethodBeat.o(174724);
        return 1;
        super.a(paramg, paramString);
        continue;
        if ((!u.aPH()) || (!bool)) {
          a(paramString, paramg);
        }
        super.a(paramg, paramString);
      }
      i = 0;
    }
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(174726);
    Object localObject1 = parama.scriptName;
    Object localObject2;
    int i;
    label97:
    String str1;
    int j;
    if (((String)localObject1).endsWith("plugin.js"))
    {
      if (paramBoolean)
      {
        if ((((com.tencent.luggage.sdk.b.a.c.c)Du()).aNv()) || (((com.tencent.luggage.sdk.b.a.c.c)Du()).isRunning()))
        {
          String str2;
          int k;
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject1 = ((com.tencent.luggage.sdk.b.a.c.c)Du()).Dl();
            localObject2 = parama.scriptName;
            if (localObject1 == null) {
              break label232;
            }
            i = localObject1.hashCode();
            ad.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d]", new Object[] { localObject2, Integer.valueOf(i) });
            localObject2 = this.chm;
            str1 = parama.scriptName;
            j = parama.cgj;
            str2 = parama.iLN;
            k = parama.aAS;
            if (localObject1 == null) {
              break label238;
            }
          }
          label232:
          label238:
          for (i = localObject1.hashCode();; i = -1)
          {
            a.a((com.tencent.mm.plugin.appbrand.d)localObject2, str1, j, str2, k, paramLong1, i, paramObject);
            b(e.a.cca, "plugin " + parama.iLN + " inject success!");
            fG(true);
            AppMethodBeat.o(174726);
            return;
            paramObject = null;
            break;
            i = -1;
            break label97;
          }
        }
      }
      else
      {
        b(e.a.ccc, "plugin " + parama.iLN + " inject fail!");
        fG(false);
        AppMethodBeat.o(174726);
      }
    }
    else
    {
      if ("WAGameSubContext.js".equals(localObject1))
      {
        if ((paramBoolean) && ((((com.tencent.luggage.sdk.b.a.c.c)Du()).aNv()) || (((com.tencent.luggage.sdk.b.a.c.c)Du()).isRunning())))
        {
          if (!(paramObject instanceof m.c)) {
            break label538;
          }
          paramObject = (m.c)paramObject;
          a.bmM();
          localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.g(Du()).lp((String)localObject1);
          ((fp)localObject1).ecI = parama.cgj;
          if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.kDv.length)) {
            break label544;
          }
          l = v.kDv[paramObject.codeCacheStatus];
          label409:
          ((fp)localObject1).ecL = l;
          ((fp)localObject1).ecM = 1L;
          if (paramObject == null) {
            break label552;
          }
          l = paramObject.flatJSCompileCost;
          label434:
          ((fp)localObject1).ecN = l;
          if (paramObject == null) {
            break label558;
          }
        }
        label538:
        label544:
        label552:
        label558:
        for (long l = paramObject.cPZ;; l = 0L)
        {
          ((fp)localObject1).edf = l;
          ((fp)localObject1).iB(paramLong1);
          ((fp)localObject1).iC(paramLong2);
          ((fp)localObject1).iA(((fp)localObject1).ebr - ((fp)localObject1).ebq);
          ((fp)localObject1).aBj();
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(778L, 17L, 1L, false);
          if (!paramBoolean) {
            break label564;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(778L, 19L, 1L, false);
          AppMethodBeat.o(174726);
          return;
          paramObject = null;
          break;
          l = 4L;
          break label409;
          l = 0L;
          break label434;
        }
        label564:
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(778L, 18L, 1L, false);
        com.tencent.mm.plugin.appbrand.report.h.bL(((com.tencent.luggage.sdk.b.a.c.c)Du()).getAppId(), 24);
        com.tencent.mm.plugin.appbrand.report.h.b(((com.tencent.luggage.sdk.b.a.c.c)Du()).getAppId(), ((com.tencent.luggage.sdk.b.a.c.c)Du()).Dl().DY().jdS.pkgVersion, ((com.tencent.luggage.sdk.b.a.c.c)Du()).Dl().DY().jdS.iOQ, 778, 18);
        AppMethodBeat.o(174726);
        return;
      }
      if (((String)localObject1).endsWith("game.js"))
      {
        if ((((com.tencent.luggage.sdk.b.a.c.c)Du()).aNv()) || (((com.tencent.luggage.sdk.b.a.c.c)Du()).isRunning()))
        {
          if (!(paramObject instanceof m.c)) {
            break label860;
          }
          paramObject = (m.c)paramObject;
          localObject1 = ((com.tencent.luggage.sdk.b.a.c.c)Du()).Dl();
          if (localObject1 == null) {
            break label866;
          }
          i = localObject1.hashCode();
          label731:
          ad.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
          localObject2 = this.chm;
          str1 = parama.scriptName;
          j = parama.cgj;
          if (localObject1 == null) {
            break label872;
          }
          i = localObject1.hashCode();
          label781:
          a.a((com.tencent.mm.plugin.appbrand.d)localObject2, str1, j, "", 0, paramLong1, i, paramObject);
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(778L, 21L, 1L, false);
        if (!paramBoolean) {
          break label878;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(778L, 23L, 1L, false);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.y.b.a.bnk();
      com.tencent.mm.plugin.appbrand.y.b.b("WeAppLaunch", ((com.tencent.luggage.sdk.b.a.c.c)Du()).getAppId(), b.b.lvt);
      AppMethodBeat.o(174726);
      return;
      label860:
      paramObject = null;
      break;
      label866:
      i = -1;
      break label731;
      label872:
      i = -1;
      break label781;
      label878:
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(778L, 22L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.h.bL(((com.tencent.luggage.sdk.b.a.c.c)Du()).getAppId(), 24);
      com.tencent.mm.plugin.appbrand.report.h.b(((com.tencent.luggage.sdk.b.a.c.c)Du()).getAppId(), ((com.tencent.luggage.sdk.b.a.c.c)Du()).Dl().DY().jdS.pkgVersion, ((com.tencent.luggage.sdk.b.a.c.c)Du()).Dl().DY().jdS.iOQ, 778, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e
 * JD-Core Version:    0.7.0.1
 */