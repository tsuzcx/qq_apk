package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.utils.s.b;
import com.tencent.mm.plugin.appbrand.utils.t.a;
import com.tencent.mm.plugin.appbrand.w.b.b;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class e
  extends com.tencent.luggage.game.d.a.a.d
{
  e(c paramc, com.tencent.mm.plugin.appbrand.jsruntime.t paramt)
  {
    super(paramc, paramt);
  }
  
  private int a(String paramString, com.tencent.mm.plugin.appbrand.jsruntime.g paramg)
  {
    AppMethodBeat.i(222344);
    ae.i("MicroMsg.WAGameJsContextInterfaceWC", "injectPluginCodeNewLogic");
    if (paramString.equals("game.js"))
    {
      Object localObject = ((c)this.coz).Eq().Ff().kbw.jMa;
      paramString = null;
      if (localObject != null) {
        paramString = ((WxaRuntimeModulePluginListMap)localObject).Mq("__APP__");
      }
      while ((paramString != null) && (paramString.size() > 0))
      {
        ae.i("MicroMsg.WAGameJsContextInterfaceWC", "client inject pluginCode size:%s", new Object[] { Integer.valueOf(paramString.size()) });
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (WxaPluginPkgInfo)paramString.next();
          List localList = ((WxaPluginPkgInfo)localObject).contexts;
          if (localList != null) {
            ae.d("MicroMsg.WAGameJsContextInterfaceWC", "multiPkg contexts size:%d,contexts:%s", new Object[] { Integer.valueOf(localList.size()), Arrays.toString(localList.toArray()) });
          }
          if ((localList != null) && (localList.contains(Integer.valueOf(0))))
          {
            localObject = ((WxaPluginPkgInfo)localObject).prefixPath + "/plugin.js";
            ae.d("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodefilePath:%s", new Object[] { localObject });
            super.a(paramg, (String)localObject);
          }
        }
        ae.e("MicroMsg.WAGameJsContextInterfaceWC", "pluginCodeList wxaRuntimeModulePluginListMap null");
      }
    }
    AppMethodBeat.o(222344);
    return 1;
  }
  
  private boolean a(String paramString1, int paramInt, String paramString2, com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString3)
  {
    AppMethodBeat.i(174725);
    String str2 = "plugin.js_".concat(String.valueOf(paramString1));
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(174725);
      return false;
    }
    ae.i("MicroMsg.WAGameJsContextInterfaceWC", "provider:%s,version:%s,pluginCodePath:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3 });
    long l = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final i locali = new i();
    final PInt localPInt = new PInt();
    Object localObject = ((c)this.coz).Eq().Ff().kbw.jLY;
    String str1 = "";
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
      if ((localModulePkgInfo.name != null) && (paramString3.startsWith(localModulePkgInfo.name))) {
        str1 = localModulePkgInfo.pkgPath;
      }
    }
    com.tencent.mm.plugin.appbrand.utils.t.a(((c)Ey()).Eq(), paramg, str1, "plugin.js", str2, paramString2, t.a.mUc, new s.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        locali.value = paramAnonymousc;
        localPInt.value = paramAnonymousc.sourceLength;
      }
      
      public final void cV(String paramAnonymousString)
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
      if ((((c)Ey()).aXP()) || (((c)Ey()).isRunning()))
      {
        paramString2 = ((c)Ey()).Eq();
        if (paramString2 != null)
        {
          i = paramString2.hashCode();
          ae.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d], scriptLen = [%d]", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(localPInt.value) });
          paramg = this.coz;
          int j = localPInt.value;
          if (paramString2 == null) {
            break label402;
          }
          i = paramString2.hashCode();
          label332:
          a.a(paramg, paramString3, j, paramString1, paramInt, l, i, (m.c)locali.value);
          b(e.a.cjr, "plugin " + paramString1 + " inject success!");
        }
      }
      else
      {
        gf(true);
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
      b(e.a.cjt, "plugin " + paramString1 + " inject fail!");
      gf(false);
    }
  }
  
  private void b(e.a parama, String paramString)
  {
    AppMethodBeat.i(45086);
    com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((c)Ey()).Q(com.tencent.luggage.game.d.a.a.b.class);
    if (localb != null) {
      localb.CK().a(parama, paramString);
    }
    AppMethodBeat.o(45086);
  }
  
  private static void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(45087);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 40L, 1L, false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 49L, 1L, false);
      AppMethodBeat.o(45087);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 50L, 1L, false);
    AppMethodBeat.o(45087);
  }
  
  public final int Dd()
  {
    AppMethodBeat.i(45089);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qLp, 0);
    AppMethodBeat.o(45089);
    return i;
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString)
  {
    AppMethodBeat.i(174724);
    ae.i("MicroMsg.WAGameJsContextInterfaceWC", "hy: injectWxaScript from js context interface: %s %d", new Object[] { paramString, Integer.valueOf(paramg.bqQ()) });
    boolean bool = Boolean.parseBoolean(((c)this.coz).aWe().LE("injectGameContextPlugin"));
    ae.i("MicroMsg.WAGameJsContextInterfaceWC", "injectGameContextPlugin :%b, abtest:%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.plugin.appbrand.appcache.v.bat()) });
    Object localObject3 = ((c)this.coz).Eq().Ff().cnk;
    Object localObject1;
    Object localObject2;
    int i;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      Object localObject4;
      if (((!com.tencent.mm.plugin.appbrand.appcache.v.bat()) || (!bool)) && (paramString.equals("game.js")))
      {
        ae.i("MicroMsg.WAGameJsContextInterfaceWC", "client inject pluginCode size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject1).next();
          localObject4 = ((WxaAttributes.WxaPluginCodeInfo)localObject2).contexts;
          if (localObject4 != null) {
            ae.d("MicroMsg.WAGameJsContextInterfaceWC", "multiPkg contexts size:%d,contexts:%s", new Object[] { Integer.valueOf(((List)localObject4).size()), Arrays.toString(((List)localObject4).toArray()) });
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
        if ((!com.tencent.mm.plugin.appbrand.appcache.v.bat()) || (!bool)) {
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
        if ((((c)Ey()).aXP()) || (((c)Ey()).isRunning()))
        {
          String str2;
          int k;
          if ((paramObject instanceof m.c))
          {
            paramObject = (m.c)paramObject;
            localObject1 = ((c)Ey()).Eq();
            localObject2 = parama.scriptName;
            if (localObject1 == null) {
              break label232;
            }
            i = localObject1.hashCode();
            ae.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] %s runtime.hashCode = [%d]", new Object[] { localObject2, Integer.valueOf(i) });
            localObject2 = this.coz;
            str1 = parama.scriptName;
            j = parama.cny;
            str2 = parama.jIJ;
            k = parama.aDD;
            if (localObject1 == null) {
              break label238;
            }
          }
          label232:
          label238:
          for (i = localObject1.hashCode();; i = -1)
          {
            a.a((com.tencent.mm.plugin.appbrand.d)localObject2, str1, j, str2, k, paramLong1, i, paramObject);
            b(e.a.cjr, "plugin " + parama.jIJ + " inject success!");
            gf(true);
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
        b(e.a.cjt, "plugin " + parama.jIJ + " inject fail!");
        gf(false);
        AppMethodBeat.o(174726);
      }
    }
    else
    {
      if ("WAGameSubContext.js".equals(localObject1))
      {
        if ((paramBoolean) && ((((c)Ey()).aXP()) || (((c)Ey()).isRunning())))
        {
          if (!(paramObject instanceof m.c)) {
            break label538;
          }
          paramObject = (m.c)paramObject;
          a.byG();
          localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.l(Ey()).rt((String)localObject1);
          ((in)localObject1).exi = parama.cny;
          if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= com.tencent.mm.plugin.appbrand.jsruntime.v.lGl.length)) {
            break label544;
          }
          l = com.tencent.mm.plugin.appbrand.jsruntime.v.lGl[paramObject.codeCacheStatus];
          label409:
          ((in)localObject1).exl = l;
          ((in)localObject1).exm = 1L;
          if (paramObject == null) {
            break label552;
          }
          l = paramObject.flatJSCompileCost;
          label434:
          ((in)localObject1).exn = l;
          if (paramObject == null) {
            break label558;
          }
        }
        label538:
        label544:
        label552:
        label558:
        for (long l = paramObject.cZI;; l = 0L)
        {
          ((in)localObject1).exE = l;
          ((in)localObject1).on(paramLong1);
          ((in)localObject1).oo(paramLong2);
          ((in)localObject1).om(((in)localObject1).evJ - ((in)localObject1).evI);
          ((in)localObject1).aLH();
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(778L, 17L, 1L, false);
          if (!paramBoolean) {
            break label564;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(778L, 19L, 1L, false);
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
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(778L, 18L, 1L, false);
        h.bW(((c)Ey()).getAppId(), 24);
        h.b(((c)Ey()).getAppId(), ((c)Ey()).Eq().Ff().kbw.pkgVersion, ((c)Ey()).Eq().Ff().kbw.jLV, 778, 18);
        AppMethodBeat.o(174726);
        return;
      }
      if (((String)localObject1).endsWith("game.js"))
      {
        if ((((c)Ey()).aXP()) || (((c)Ey()).isRunning()))
        {
          if (!(paramObject instanceof m.c)) {
            break label860;
          }
          paramObject = (m.c)paramObject;
          localObject1 = ((c)Ey()).Eq();
          if (localObject1 == null) {
            break label866;
          }
          i = localObject1.hashCode();
          label731:
          ae.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
          localObject2 = this.coz;
          str1 = parama.scriptName;
          j = parama.cny;
          if (localObject1 == null) {
            break label872;
          }
          i = localObject1.hashCode();
          label781:
          a.a((com.tencent.mm.plugin.appbrand.d)localObject2, str1, j, "", 0, paramLong1, i, paramObject);
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(778L, 21L, 1L, false);
        if (!paramBoolean) {
          break label878;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(778L, 23L, 1L, false);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.w.b.a.bze();
      com.tencent.mm.plugin.appbrand.w.b.b("WeAppLaunch", ((c)Ey()).getAppId(), b.b.mBZ);
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
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(778L, 22L, 1L, false);
      h.bW(((c)Ey()).getAppId(), 24);
      h.b(((c)Ey()).getAppId(), ((c)Ey()).Eq().Ff().kbw.pkgVersion, ((c)Ey()).Eq().Ff().kbw.jLV, 778, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e
 * JD-Core Version:    0.7.0.1
 */