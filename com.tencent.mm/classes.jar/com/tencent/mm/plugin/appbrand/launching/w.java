package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "mPreGetDownloadUrlResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "addPreGetDownloadUrlResult", "", "map", "", "removePreGetDownloadUrlResult", "request", "waitForBatchGetDownloadUrl", "inRequestList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "waitForDownloadUrl", "wormholeForLegacyReleaseCode", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "cgi", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "wormholeForLegacyTestCode", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetTestCodeDownloadInfo;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "RouterController", "plugin-appbrand-integration_release"})
public final class w
  implements z
{
  private static final ConcurrentHashMap<z.b, bah[]> lHu;
  public static final w lHv;
  
  static
  {
    AppMethodBeat.i(180554);
    lHv = new w();
    lHu = new ConcurrentHashMap();
    AppMethodBeat.o(180554);
  }
  
  public static void M(Map<z.b, bah[]> paramMap)
  {
    AppMethodBeat.i(180547);
    d.g.b.p.h(paramMap, "map");
    lHu.putAll(paramMap);
    AppMethodBeat.o(180547);
  }
  
  public static final f<a.a<bjf>> a(com.tencent.mm.plugin.appbrand.appcache.i parami)
  {
    AppMethodBeat.i(180549);
    d.g.b.p.h(parami, "cgi");
    Object localObject1 = a.lHw;
    if (!w.a.a.bre())
    {
      AppMethodBeat.o(180549);
      return null;
    }
    localObject1 = k.lHG;
    localObject1 = new StringBuilder("wormholeForLegacyTestCode with ");
    Object localObject2 = parami.aZu();
    d.g.b.p.g(localObject2, "cgi.request");
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", k.a((bje)localObject2) + " intercepted");
    localObject1 = new bag();
    ((bag)localObject1).Gxp = new cvb();
    ((bag)localObject1).Gxp.duW = parami.aZu().duW;
    ((bag)localObject1).Gxp.GDK = parami.aZu().GDK;
    ((bag)localObject1).Gxp.GDN = parami.aZu().GDN;
    ((bag)localObject1).Gxp.FKM = parami.aZu().FPp;
    ((bag)localObject1).Gxr = 0;
    ((bag)localObject1).Gxu = parami.aZu().GDM;
    localObject2 = new jx();
    ((jx)localObject2).FCB.add(localObject1);
    parami = new com.tencent.mm.plugin.appbrand.appcache.g((jx)localObject2).aED().b((com.tencent.mm.vending.c.a)new l(parami));
    AppMethodBeat.o(180549);
    return parami;
  }
  
  public static void a(z.b paramb)
  {
    AppMethodBeat.i(180548);
    d.g.b.p.h(paramb, "request");
    lHu.remove(paramb);
    AppMethodBeat.o(180548);
  }
  
  public static final f<a.a<blq>> b(h paramh)
  {
    Object localObject1 = null;
    AppMethodBeat.i(180550);
    d.g.b.p.h(paramh, "cgi");
    Object localObject2 = a.lHw;
    if (!w.a.a.bre())
    {
      AppMethodBeat.o(180550);
      return null;
    }
    localObject2 = h.lHE;
    localObject2 = new StringBuilder("wormholeForLegacyReleaseCode with ");
    Object localObject3 = paramh.aZs();
    d.g.b.p.g(localObject3, "cgi.request");
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", h.a((blp)localObject3) + " intercepted");
    localObject3 = new i(paramh);
    localObject2 = new jx();
    ((jx)localObject2).FCB.add(((i)localObject3).brf());
    Object localObject4 = ((jx)localObject2).FCB;
    bag localbag = ((i)localObject3).brf();
    localbag.Gxt = true;
    ((LinkedList)localObject4).add(localbag);
    ((jx)localObject2).scene = paramh.aZs().scene;
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "CgiBatchGetPkgDownloadInfo scene:%d", new Object[] { Integer.valueOf(((jx)localObject2).scene) });
    int i;
    if (paramh.aZs().GFE > 0)
    {
      localObject4 = com.tencent.mm.plugin.appbrand.app.j.aYX().a(new ac(paramh.aZs().duW, paramh.aZs().GDK, paramh.aZs().GDN).toString(), paramh.aZs().GFE, 0, new String[] { "pkgPath" });
      if (localObject4 != null) {
        localObject1 = ((bc)localObject4).field_pkgPath;
      }
      if (!com.tencent.mm.vfs.i.fv((String)localObject1)) {
        break label403;
      }
      i = WxaPkg.Lu((String)localObject1);
      localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
      localObject4 = h.lHE;
      localObject4 = paramh.aZs();
      d.g.b.p.g(localObject4, "cgi.request");
      ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", h.a((blp)localObject4) + ", intercepted, oldPkg.innerVersion=" + i);
      if (i != 0) {
        break label408;
      }
      localObject1 = ((jx)localObject2).FCB;
      localObject3 = ((i)localObject3).brf();
      ((bag)localObject3).Gxq = new bvm();
      ((bag)localObject3).Gxq.FKN = paramh.aZs().GFE;
      ((LinkedList)localObject1).add(localObject3);
    }
    for (;;)
    {
      paramh = new com.tencent.mm.plugin.appbrand.appcache.g((jx)localObject2).aED().b((com.tencent.mm.vending.c.a)new j(paramh));
      AppMethodBeat.o(180550);
      return paramh;
      label403:
      i = -1;
      break;
      label408:
      com.tencent.mm.plugin.report.service.g.yhR.dD(697, 20);
    }
  }
  
  private static cvb b(z.b paramb)
  {
    AppMethodBeat.i(189262);
    cvb localcvb = new cvb();
    localcvb.duW = paramb.appId;
    int i = paramb.dnF;
    int[] arrayOfInt = com.tencent.mm.co.a.LBb;
    d.g.b.p.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (d.a.e.contains(arrayOfInt, i)) {
      localcvb.GDK = null;
    }
    for (;;)
    {
      localcvb.GDN = paramb.dnF;
      localcvb.FKM = paramb.hQh;
      AppMethodBeat.o(189262);
      return localcvb;
      arrayOfInt = com.tencent.mm.co.a.LBa;
      d.g.b.p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (d.a.e.contains(arrayOfInt, i)) {
        localcvb.GDK = null;
      } else {
        localcvb.GDK = paramb.coW;
      }
    }
  }
  
  private static List<bag> c(z.b paramb)
  {
    AppMethodBeat.i(180553);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new b(paramb);
    bag localbag = ((b)localObject).brf();
    localbag.Gxq = null;
    localbag.Gxt = false;
    localLinkedList.add(localbag);
    localbag = ((b)localObject).brf();
    localbag.Gxq = null;
    localbag.Gxt = true;
    localLinkedList.add(localbag);
    if (paramb.lHn > 0)
    {
      localObject = ((b)localObject).brf();
      ((bag)localObject).Gxq = new bvm();
      ((bag)localObject).Gxq.FKN = paramb.lHn;
      ((bag)localObject).Gxq.GFJ = paramb.lIl;
      ((bag)localObject).Gxt = false;
      localLinkedList.add(localObject);
    }
    paramb = (List)localLinkedList;
    AppMethodBeat.o(180553);
    return paramb;
  }
  
  public final void a(final z.b paramb, final d.g.a.b<? super bah[], d.z> paramb1, final d.g.a.q<? super Integer, ? super Integer, ? super String, d.z> paramq, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(180551);
    d.g.b.p.h(paramb, "request");
    d.g.b.p.h(paramb1, "onSuccess");
    d.g.b.p.h(paramq, "onError");
    Object localObject3 = (bah[])lHu.remove(paramb);
    if (localObject3 != null)
    {
      ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(paramb)));
      d.g.b.p.g(localObject3, "preGetResp");
      if (d.a.e.f((Object[])localObject3, 0) != null)
      {
        paramb1.invoke(localObject3);
        AppMethodBeat.o(180551);
        return;
      }
    }
    if (!paramb.lIm)
    {
      localObject3 = com.tencent.mm.co.a.LAZ;
      d.g.b.p.g(localObject3, "ConstantsWxaPackageProto…CGI_SUPPORT_PACKAGE_TYPES");
      if (d.a.e.contains((int[])localObject3, paramb.dnF))
      {
        localObject3 = a.lHw;
        if (!w.a.a.bre()) {
          break label236;
        }
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "goNewCgi: %b,appId: %s", new Object[] { Boolean.valueOf(bool), paramb.appId });
      if (!bool) {
        break;
      }
      localObject1 = new jx();
      ((jx)localObject1).FCB.addAll((Collection)c(paramb));
      new com.tencent.mm.plugin.appbrand.appcache.g((jx)localObject1).aED().j((com.tencent.mm.vending.c.a)new e(paramb1, paramb, paramq));
      AppMethodBeat.o(180551);
      return;
    }
    if (j.a.rQ(paramb.hQh))
    {
      localObject1 = com.tencent.mm.plugin.appbrand.app.j.aYX();
      if (localObject1 != null)
      {
        localObject1 = ((bg)localObject1).a(new ac(paramb.appId, paramb.coW, paramb.dnF).toString(), paramb.aDD, paramb.hQh, new String[] { "versionMd5" });
        if (localObject1 == null) {}
      }
      for (localObject1 = ((bc)localObject1).field_versionMd5;; localObject1 = null)
      {
        localObject2 = new blp();
        ((blp)localObject2).duW = paramb.appId;
        ((blp)localObject2).FKN = paramb.aDD;
        ((blp)localObject2).GDN = paramb.dnF;
        ((blp)localObject2).GFE = paramb.lHn;
        if (((blp)localObject2).GDN != 0)
        {
          localObject3 = com.tencent.mm.co.a.LBa;
          d.g.b.p.g(localObject3, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
          if (!d.a.e.contains((int[])localObject3, ((blp)localObject2).GDN)) {
            ((blp)localObject2).GDK = paramb.coW;
          }
        }
        ((blp)localObject2).scene = paramInt;
        new h((blp)localObject2).aED().j((com.tencent.mm.vending.c.a)new f(paramq, paramb1, (String)localObject1, paramb));
        AppMethodBeat.o(180551);
        return;
      }
    }
    if (paramb.dnF == 0)
    {
      ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode packageType=0, use record, request=".concat(String.valueOf(paramb)));
      localObject2 = com.tencent.mm.plugin.appbrand.app.j.aYX();
      if (localObject2 != null) {
        localObject1 = ((bg)localObject2).a(new ac(paramb.appId, paramb.coW, paramb.dnF).toString(), 0, paramb.hQh, new String[] { "versionMd5", "downloadURL" });
      }
      if (localObject1 == null)
      {
        paramq.d(Integer.valueOf(-1), Integer.valueOf(-1), aj.getResources().getString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.rP(paramb.hQh) }));
        AppMethodBeat.o(180551);
        return;
      }
      paramq = new bah[3];
      localObject2 = new bah();
      ((bah)localObject2).url = ((bc)localObject1).field_downloadURL;
      ((bah)localObject2).md5 = ((bc)localObject1).field_versionMd5;
      ((bah)localObject2).Gxw = false;
      ((bah)localObject2).Gxp = b(paramb);
      paramq[0] = localObject2;
      paramb1.invoke(paramq);
      AppMethodBeat.o(180551);
      return;
    }
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode with request=".concat(String.valueOf(paramb)));
    localObject3 = com.tencent.mm.plugin.appbrand.app.j.aYX();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((bg)localObject3).a(new ac(paramb.appId, paramb.coW, paramb.dnF).toString(), 0, paramb.hQh, new String[] { "versionMd5" });
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((bc)localObject3).field_versionMd5;
      }
    }
    new com.tencent.mm.plugin.appbrand.appcache.i(paramb.appId, paramb.coW, (String)localObject1, paramb.hQh, paramb.dnF).aED().j((com.tencent.mm.vending.c.a)new g(paramq, paramb, paramb1, (String)localObject1));
    AppMethodBeat.o(180551);
  }
  
  public final void a(List<z.b> paramList, final d.g.a.b<? super jy, d.z> paramb, final d.g.a.q<? super Integer, ? super Integer, ? super String, d.z> paramq, int paramInt)
  {
    AppMethodBeat.i(180552);
    d.g.b.p.h(paramList, "inRequestList");
    d.g.b.p.h(paramb, "onSuccess");
    d.g.b.p.h(paramq, "onError");
    if (paramList.size() == 1)
    {
      ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, use single routine instead, with " + (z.b)d.a.j.jc(paramList));
      a((z.b)paramList.get(0), (d.g.a.b)new c(paramb), paramq, paramInt);
      AppMethodBeat.o(180552);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList((Collection)paramList);
    Object localObject2 = ((LinkedList)localObject1).iterator();
    d.g.b.p.g(localObject2, "realRequestList.iterator()");
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      d.g.b.p.g(localObject3, "iterator.next()");
      z.b localb = (z.b)localObject3;
      localObject3 = (bah[])lHu.remove(localb);
      if (localObject3 != null)
      {
        d.g.b.p.g(localObject3, "preGetResp");
        if (d.a.e.f((Object[])localObject3, 0) != null)
        {
          ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(localb)));
          ((Iterator)localObject2).remove();
          int i = localObject3.length;
          paramInt = 0;
          while (paramInt < i)
          {
            localb = localObject3[paramInt];
            if (localb != null) {
              localLinkedList.add(localb);
            }
            paramInt += 1;
          }
        }
      }
    }
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, inRequestList.size=" + paramList.size() + ", realRequestList.size=" + ((LinkedList)localObject1).size() + ", preGetRespItemList.size=" + localLinkedList.size());
    if (((LinkedList)localObject1).size() <= 0)
    {
      paramList = new jy();
      paramList.FCC.addAll((Collection)localLinkedList);
      paramb.invoke(paramList);
      AppMethodBeat.o(180552);
      return;
    }
    paramList = new jx();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (z.b)((Iterator)localObject1).next();
      paramList.FCB.addAll((Collection)c((z.b)localObject2));
    }
    new com.tencent.mm.plugin.appbrand.appcache.g(paramList).aED().j((com.tencent.mm.vending.c.a)new d(localLinkedList, paramb, paramq));
    AppMethodBeat.o(180552);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "", "useEncryptPkg", "", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "Factory", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public static final a lHw = a.lHy;
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "TEST_SWITCH_MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "resetTestSwitch", "", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "useEncryptPkg", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "plugin-appbrand-integration_release"})
    public static final class a
      implements w.a
    {
      private static final ax lHx;
      
      static
      {
        AppMethodBeat.i(180531);
        lHy = new a();
        lHx = ax.gh("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE.TEST_SWITCH_MMKV", 2);
        AppMethodBeat.o(180531);
      }
      
      private static boolean a(b.a parama)
      {
        AppMethodBeat.i(189256);
        if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE))
        {
          ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", INTERNAL BUILD, defBool:true");
          AppMethodBeat.o(189256);
          return true;
        }
        if (!d.Fnm)
        {
          ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", !ALPHA, defBool:false");
          AppMethodBeat.o(189256);
          return false;
        }
        if (aj.cmR()) {
          d.g.b.p.g(com.tencent.mm.kernel.g.ajA(), "MMKernel.account()");
        }
        String str;
        for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.air())
        {
          str = com.tencent.mm.b.p.getString(i) + '_' + parama.name();
          if (!lHx.containsKey(str)) {
            break;
          }
          bool = lHx.getBoolean(str, false);
          ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", IS_ALPHA, defBool:" + bool);
          AppMethodBeat.o(189256);
          return bool;
        }
        if (com.tencent.mm.b.i.ce(i, 101) > 50) {}
        for (boolean bool = true;; bool = false)
        {
          lHx.putBoolean(str, bool);
          break;
        }
      }
      
      public static boolean bre()
      {
        AppMethodBeat.i(180528);
        boolean bool1 = a(b.a.quY);
        boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quY, bool1);
        ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewCgi exptVal[" + bool2 + "] defVal[" + bool1 + ']');
        AppMethodBeat.o(180528);
        return bool2;
      }
      
      public static boolean gX(boolean paramBoolean)
      {
        AppMethodBeat.i(180529);
        boolean bool2;
        if (paramBoolean) {
          bool2 = a(b.a.qvb);
        }
        for (boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qvb, bool2);; bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qva, bool2))
        {
          ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg isGame[" + paramBoolean + "] exptVal[" + bool1 + "] defVal[" + bool2 + ']');
          AppMethodBeat.o(180529);
          return bool1;
          bool2 = a(b.a.qva);
        }
      }
      
      public static boolean gY(boolean paramBoolean)
      {
        AppMethodBeat.i(180530);
        if (paramBoolean)
        {
          bool1 = a(b.a.qvc);
          bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qvc, bool1);
          ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewSeparatedPluginCompatibleLogic isGame[" + paramBoolean + "] exptVal[" + bool2 + "] defVal[" + bool1 + ']');
          AppMethodBeat.o(180530);
          return bool2;
        }
        boolean bool1 = a(b.a.quZ);
        boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quZ, bool1);
        ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewSeparatedPluginCompatibleLogic isGame[" + paramBoolean + "] exptVal[" + bool2 + "] defVal[" + bool1 + ']');
        AppMethodBeat.o(180530);
        return bool2;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"buildBasicItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<bag>
  {
    b(z.b paramb)
    {
      super();
    }
    
    public final bag brf()
    {
      AppMethodBeat.i(180533);
      bag localbag = new bag();
      w localw = w.lHv;
      localbag.Gxp = w.d(this.lHz);
      localbag.Gxr = this.lHz.lIk;
      if (this.lHz.lIm) {
        localbag.Gxs = true;
      }
      localbag.FKN = this.lHz.aDD;
      o.a(localbag);
      AppMethodBeat.o(180533);
      return localbag;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class c
    extends d.g.b.q
    implements d.g.a.b<bah[], d.z>
  {
    c(d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(LinkedList paramLinkedList, d.g.a.b paramb, d.g.a.q paramq) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d.g.a.b paramb, z.b paramb1, d.g.a.q paramq) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(d.g.a.q paramq, d.g.a.b paramb, String paramString, z.b paramb1) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(d.g.a.q paramq, z.b paramb, d.g.a.b paramb1, String paramString) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<blp, String>
  {
    public static final h lHE;
    
    static
    {
      AppMethodBeat.i(180541);
      lHE = new h();
      AppMethodBeat.o(180541);
    }
    
    h()
    {
      super();
    }
    
    public static String a(blp paramblp)
    {
      AppMethodBeat.i(180540);
      d.g.b.p.h(paramblp, "$this$info");
      paramblp = "GetWxaAppCDNDownloadUrlRequest(appId:" + paramblp.duW + " version:" + paramblp.FKN + " moduleName:" + paramblp.GDK + " pacakgeType:" + paramblp.GDN + " scene:" + paramblp.scene + ')';
      AppMethodBeat.o(180540);
      return paramblp;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"makeReqItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<bag>
  {
    i(h paramh)
    {
      super();
    }
    
    public final bag brf()
    {
      AppMethodBeat.i(189260);
      bag localbag = new bag();
      localbag.Gxp = new cvb();
      localbag.Gxp.duW = this.lHF.aZs().duW;
      localbag.FKN = this.lHF.aZs().FKN;
      localbag.Gxp.GDN = this.lHF.aZs().GDN;
      localbag.Gxp.GDK = this.lHF.aZs().GDK;
      localbag.Gxr = 0;
      AppMethodBeat.o(189260);
      return localbag;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class j<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    j(h paramh) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoRequest;", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.b<bje, String>
  {
    public static final k lHG;
    
    static
    {
      AppMethodBeat.i(180545);
      lHG = new k();
      AppMethodBeat.o(180545);
    }
    
    k()
    {
      super();
    }
    
    public static String a(bje parambje)
    {
      AppMethodBeat.i(180544);
      d.g.b.p.h(parambje, "$this$info");
      parambje = "GetTestCodeDownloadInfoRequest(appId:" + parambje.duW + " versionType:" + parambje.FPp + " moduleName:" + parambje.GDK + " packageType:" + parambje.GDN + ')';
      AppMethodBeat.o(180544);
      return parambje;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class l<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    l(com.tencent.mm.plugin.appbrand.appcache.i parami) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w
 * JD-Core Version:    0.7.0.1
 */