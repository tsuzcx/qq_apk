package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.hh;
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
import com.tencent.mm.plugin.appbrand.x.b.b;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    AppMethodBeat.i(186519);
    ac.i("MicroMsg.WAGameJsContextInterfaceWC", "injectPluginCodeNewLogic");
    if (paramString.equals("game.js"))
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)this.ceh).CO().DB().jEg.jpf;
      paramString = null;
      if (localObject != null) {
        paramString = ((WxaRuntimeModulePluginListMap)localObject).Iw("__APP__");
      }
      while ((paramString != null) && (paramString.size() > 0))
      {
        ac.i("MicroMsg.WAGameJsContextInterfaceWC", "client inject pluginCode size:%s", new Object[] { Integer.valueOf(paramString.size()) });
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (WxaPluginPkgInfo)paramString.next();
          List localList = ((WxaPluginPkgInfo)localObject).contexts;
          if (localList != null) {
            ac.d("MicroMsg.WAGameJsContextInterfaceWC", "multiPkg contexts size:%d,contexts:%s", new Object[] { Integer.valueOf(localList.size()), Arrays.toString(localList.toArray()) });
          }
          if ((localList != null) && (localList.contains(Integer.valueOf(0))))
          {
            localObject = ((WxaPluginPkgInfo)localObject).prefixPath + "/plugin.js";
            ac.d("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodefilePath:%s", new Object[] { localObject });
            super.a(paramg, (String)localObject);
          }
        }
        ac.e("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodeList wxaRuntimeModulePluginListMap null");
      }
    }
    AppMethodBeat.o(186519);
    return 1;
  }
  
  private boolean a(String paramString1, int paramInt, String paramString2, com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString3)
  {
    AppMethodBeat.i(174725);
    String str2 = "plugin.js_".concat(String.valueOf(paramString1));
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(174725);
      return false;
    }
    ac.i("MicroMsg.WAGameJsContextInterfaceWC", "provider:%s,version:%s,pluginCodePath:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3 });
    long l = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final i locali = new i();
    final PInt localPInt = new PInt();
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)this.ceh).CO().DB().jEg.jpd;
    String str1 = "";
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
      if ((localModulePkgInfo.name != null) && (paramString3.startsWith(localModulePkgInfo.name))) {
        str1 = localModulePkgInfo.pkgPath;
      }
    }
    r.a(((com.tencent.luggage.sdk.b.a.c.c)CX()).CO(), paramg, str1, "plugin.js", str2, paramString2, r.a.mov, new q.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        locali.value = paramAnonymousc;
        localPInt.value = paramAnonymousc.sourceLength;
      }
      
      public final void bZ(String paramAnonymousString)
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
      if ((((com.tencent.luggage.sdk.b.a.c.c)CX()).aUl()) || (((com.tencent.luggage.sdk.b.a.c.c)CX()).isRunning()))
      {
        paramString2 = ((com.tencent.luggage.sdk.b.a.c.c)CX()).CO();
        if (paramString2 != null)
        {
          i = paramString2.hashCode();
          ac.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d], scriptLen = [%d]", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(localPInt.value) });
          paramg = this.ceh;
          int j = localPInt.value;
          if (paramString2 == null) {
            break label402;
          }
          i = paramString2.hashCode();
          label332:
          a.a(paramg, paramString3, j, paramString1, paramInt, l, i, (m.c)locali.value);
          b(e.a.bYX, "plugin " + paramString1 + " inject success!");
        }
      }
      else
      {
        gc(true);
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
      b(e.a.bYZ, "plugin " + paramString1 + " inject fail!");
      gc(false);
    }
  }
  
  private void b(e.a parama, String paramString)
  {
    AppMethodBeat.i(45086);
    com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c.c)CX()).Q(com.tencent.luggage.game.d.a.a.b.class);
    if (localb != null) {
      localb.Bi().a(parama, paramString);
    }
    AppMethodBeat.o(45086);
  }
  
  private static void gc(boolean paramBoolean)
  {
    AppMethodBeat.i(45087);
    h.wUl.idkeyStat(370L, 40L, 1L, false);
    if (paramBoolean)
    {
      h.wUl.idkeyStat(370L, 49L, 1L, false);
      AppMethodBeat.o(45087);
      return;
    }
    h.wUl.idkeyStat(370L, 50L, 1L, false);
    AppMethodBeat.o(45087);
  }
  
  public final int BB()
  {
    AppMethodBeat.i(45089);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pYz, 0);
    AppMethodBeat.o(45089);
    return i;
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString)
  {
    AppMethodBeat.i(174724);
    ac.i("MicroMsg.WAGameJsContextInterfaceWC", "hy: injectWxaScript from js context interface: %s %d", new Object[] { paramString, Integer.valueOf(paramg.bmw()) });
    boolean bool = Boolean.parseBoolean(((com.tencent.luggage.sdk.b.a.c.c)this.ceh).aSt().HM("injectGameContextPlugin"));
    ac.i("MicroMsg.WAGameJsContextInterfaceWC", "injectGameContextPlugin :%b, abtest:%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(u.aWz()) });
    Object localObject3 = ((com.tencent.luggage.sdk.b.a.c.c)this.ceh).CO().DB().ccS;
    Object localObject1;
    Object localObject2;
    int i;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      Object localObject4;
      if (((!u.aWz()) || (!bool)) && (paramString.equals("game.js")))
      {
        ac.i("MicroMsg.WAGameJsContextInterfaceWC", "client inject pluginCode size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject1).next();
          localObject4 = ((WxaAttributes.WxaPluginCodeInfo)localObject2).contexts;
          if (localObject4 != null) {
            ac.d("MicroMsg.WAGameJsContextInterfaceWC", "multiPkg contexts size:%d,contexts:%s", new Object[] { Integer.valueOf(((List)localObject4).size()), Arrays.toString(((List)localObject4).toArray()) });
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
        if ((!u.aWz()) || (!bool)) {
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
        if ((((com.tencent.luggage.sdk.b.a.c.c)CX()).aUl()) || (((com.tencent.luggage.sdk.b.a.c.c)CX()).isRunning()))
        {
          String str2;
          int k;
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject1 = ((com.tencent.luggage.sdk.b.a.c.c)CX()).CO();
            localObject2 = parama.scriptName;
            if (localObject1 == null) {
              break label232;
            }
            i = localObject1.hashCode();
            ac.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d]", new Object[] { localObject2, Integer.valueOf(i) });
            localObject2 = this.ceh;
            str1 = parama.scriptName;
            j = parama.cdf;
            str2 = parama.jlU;
            k = parama.aBM;
            if (localObject1 == null) {
              break label238;
            }
          }
          label232:
          label238:
          for (i = localObject1.hashCode();; i = -1)
          {
            a.a((com.tencent.mm.plugin.appbrand.d)localObject2, str1, j, str2, k, paramLong1, i, paramObject);
            b(e.a.bYX, "plugin " + parama.jlU + " inject success!");
            gc(true);
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
        b(e.a.bYZ, "plugin " + parama.jlU + " inject fail!");
        gc(false);
        AppMethodBeat.o(174726);
      }
    }
    else
    {
      if ("WAGameSubContext.js".equals(localObject1))
      {
        if ((paramBoolean) && ((((com.tencent.luggage.sdk.b.a.c.c)CX()).aUl()) || (((com.tencent.luggage.sdk.b.a.c.c)CX()).isRunning())))
        {
          if (!(paramObject instanceof m.c)) {
            break label538;
          }
          paramObject = (m.c)paramObject;
          a.btI();
          localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.g(CX()).ou((String)localObject1);
          ((hh)localObject1).eeO = parama.cdf;
          if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.leN.length)) {
            break label544;
          }
          l = v.leN[paramObject.codeCacheStatus];
          label409:
          ((hh)localObject1).eeR = l;
          ((hh)localObject1).eeS = 1L;
          if (paramObject == null) {
            break label552;
          }
          l = paramObject.flatJSCompileCost;
          label434:
          ((hh)localObject1).eeT = l;
          if (paramObject == null) {
            break label558;
          }
        }
        label538:
        label544:
        label552:
        label558:
        for (long l = paramObject.cNu;; l = 0L)
        {
          ((hh)localObject1).efl = l;
          ((hh)localObject1).md(paramLong1);
          ((hh)localObject1).me(paramLong2);
          ((hh)localObject1).mc(((hh)localObject1).edx - ((hh)localObject1).edw);
          ((hh)localObject1).aHZ();
          h.wUl.idkeyStat(778L, 17L, 1L, false);
          if (!paramBoolean) {
            break label564;
          }
          h.wUl.idkeyStat(778L, 19L, 1L, false);
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
        h.wUl.idkeyStat(778L, 18L, 1L, false);
        com.tencent.mm.plugin.appbrand.report.g.bP(((com.tencent.luggage.sdk.b.a.c.c)CX()).getAppId(), 24);
        com.tencent.mm.plugin.appbrand.report.g.b(((com.tencent.luggage.sdk.b.a.c.c)CX()).getAppId(), ((com.tencent.luggage.sdk.b.a.c.c)CX()).CO().DB().jEg.pkgVersion, ((com.tencent.luggage.sdk.b.a.c.c)CX()).CO().DB().jEg.jpa, 778, 18);
        AppMethodBeat.o(174726);
        return;
      }
      if (((String)localObject1).endsWith("game.js"))
      {
        if ((((com.tencent.luggage.sdk.b.a.c.c)CX()).aUl()) || (((com.tencent.luggage.sdk.b.a.c.c)CX()).isRunning()))
        {
          if (!(paramObject instanceof m.c)) {
            break label860;
          }
          paramObject = (m.c)paramObject;
          localObject1 = ((com.tencent.luggage.sdk.b.a.c.c)CX()).CO();
          if (localObject1 == null) {
            break label866;
          }
          i = localObject1.hashCode();
          label731:
          ac.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
          localObject2 = this.ceh;
          str1 = parama.scriptName;
          j = parama.cdf;
          if (localObject1 == null) {
            break label872;
          }
          i = localObject1.hashCode();
          label781:
          a.a((com.tencent.mm.plugin.appbrand.d)localObject2, str1, j, "", 0, paramLong1, i, paramObject);
        }
        h.wUl.idkeyStat(778L, 21L, 1L, false);
        if (!paramBoolean) {
          break label878;
        }
        h.wUl.idkeyStat(778L, 23L, 1L, false);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.x.b.a.bug();
      com.tencent.mm.plugin.appbrand.x.b.b("WeAppLaunch", ((com.tencent.luggage.sdk.b.a.c.c)CX()).getAppId(), b.b.lXn);
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
      h.wUl.idkeyStat(778L, 22L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.g.bP(((com.tencent.luggage.sdk.b.a.c.c)CX()).getAppId(), 24);
      com.tencent.mm.plugin.appbrand.report.g.b(((com.tencent.luggage.sdk.b.a.c.c)CX()).getAppId(), ((com.tencent.luggage.sdk.b.a.c.c)CX()).CO().DB().jEg.pkgVersion, ((com.tencent.luggage.sdk.b.a.c.c)CX()).CO().DB().jEg.jpa, 778, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e
 * JD-Core Version:    0.7.0.1
 */