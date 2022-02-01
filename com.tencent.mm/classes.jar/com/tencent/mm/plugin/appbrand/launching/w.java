package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "mPreGetDownloadUrlResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "addPreGetDownloadUrlResult", "", "map", "", "removePreGetDownloadUrlResult", "request", "waitForBatchGetDownloadUrl", "inRequestList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "waitForDownloadUrl", "wormholeForLegacyReleaseCode", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "cgi", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "wormholeForLegacyTestCode", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetTestCodeDownloadInfo;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "RouterController", "plugin-appbrand-integration_release"})
public final class w
  implements z
{
  private static final ConcurrentHashMap<z.b, bax[]> lLU;
  public static final w lLV;
  
  static
  {
    AppMethodBeat.i(180554);
    lLV = new w();
    lLU = new ConcurrentHashMap();
    AppMethodBeat.o(180554);
  }
  
  public static void T(Map<z.b, bax[]> paramMap)
  {
    AppMethodBeat.i(180547);
    d.g.b.p.h(paramMap, "map");
    lLU.putAll(paramMap);
    AppMethodBeat.o(180547);
  }
  
  public static final f<a.a<bjx>> a(com.tencent.mm.plugin.appbrand.appcache.i parami)
  {
    AppMethodBeat.i(180549);
    d.g.b.p.h(parami, "cgi");
    Object localObject1 = a.lLW;
    if (!w.a.a.brO())
    {
      AppMethodBeat.o(180549);
      return null;
    }
    localObject1 = k.lMg;
    localObject1 = new StringBuilder("wormholeForLegacyTestCode with ");
    Object localObject2 = parami.aZR();
    d.g.b.p.g(localObject2, "cgi.request");
    ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", k.a((bjw)localObject2) + " intercepted");
    localObject1 = new baw();
    ((baw)localObject1).GQP = new cvv();
    ((baw)localObject1).GQP.dwb = parami.aZR().dwb;
    ((baw)localObject1).GQP.GXn = parami.aZR().GXn;
    ((baw)localObject1).GQP.GXq = parami.aZR().GXq;
    ((baw)localObject1).GQP.Gdl = parami.aZR().GhO;
    ((baw)localObject1).GQR = 0;
    ((baw)localObject1).GQU = parami.aZR().GXp;
    localObject2 = new jx();
    ((jx)localObject2).FUW.add(localObject1);
    parami = new com.tencent.mm.plugin.appbrand.appcache.g((jx)localObject2).aET().b((com.tencent.mm.vending.c.a)new l(parami));
    AppMethodBeat.o(180549);
    return parami;
  }
  
  public static void a(z.b paramb)
  {
    AppMethodBeat.i(180548);
    d.g.b.p.h(paramb, "request");
    lLU.remove(paramb);
    AppMethodBeat.o(180548);
  }
  
  public static final f<a.a<bmi>> b(h paramh)
  {
    Object localObject1 = null;
    AppMethodBeat.i(180550);
    d.g.b.p.h(paramh, "cgi");
    Object localObject2 = a.lLW;
    if (!w.a.a.brO())
    {
      AppMethodBeat.o(180550);
      return null;
    }
    localObject2 = h.lMe;
    localObject2 = new StringBuilder("wormholeForLegacyReleaseCode with ");
    Object localObject3 = paramh.aZP();
    d.g.b.p.g(localObject3, "cgi.request");
    ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", h.a((bmh)localObject3) + " intercepted");
    localObject3 = new i(paramh);
    localObject2 = new jx();
    ((jx)localObject2).FUW.add(((i)localObject3).brP());
    Object localObject4 = ((jx)localObject2).FUW;
    baw localbaw = ((i)localObject3).brP();
    localbaw.GQT = true;
    ((LinkedList)localObject4).add(localbaw);
    ((jx)localObject2).scene = paramh.aZP().scene;
    ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "CgiBatchGetPkgDownloadInfo scene:%d", new Object[] { Integer.valueOf(((jx)localObject2).scene) });
    int i;
    if (paramh.aZP().GZg > 0)
    {
      localObject4 = com.tencent.mm.plugin.appbrand.app.j.aZu().a(new ad(paramh.aZP().dwb, paramh.aZP().GXn, paramh.aZP().GXq).toString(), paramh.aZP().GZg, 0, new String[] { "pkgPath" });
      if (localObject4 != null) {
        localObject1 = ((bd)localObject4).field_pkgPath;
      }
      if (!com.tencent.mm.vfs.o.fB((String)localObject1)) {
        break label403;
      }
      i = WxaPkg.LX((String)localObject1);
      localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
      localObject4 = h.lMe;
      localObject4 = paramh.aZP();
      d.g.b.p.g(localObject4, "cgi.request");
      ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", h.a((bmh)localObject4) + ", intercepted, oldPkg.innerVersion=" + i);
      if (i != 0) {
        break label408;
      }
      localObject1 = ((jx)localObject2).FUW;
      localObject3 = ((i)localObject3).brP();
      ((baw)localObject3).GQQ = new bwg();
      ((baw)localObject3).GQQ.Gdm = paramh.aZP().GZg;
      ((LinkedList)localObject1).add(localObject3);
    }
    for (;;)
    {
      paramh = new com.tencent.mm.plugin.appbrand.appcache.g((jx)localObject2).aET().b((com.tencent.mm.vending.c.a)new j(paramh));
      AppMethodBeat.o(180550);
      return paramh;
      label403:
      i = -1;
      break;
      label408:
      com.tencent.mm.plugin.report.service.g.yxI.dD(697, 20);
    }
  }
  
  private static cvv b(z.b paramb)
  {
    AppMethodBeat.i(223519);
    cvv localcvv = new cvv();
    localcvv.dwb = paramb.appId;
    int i = paramb.doK;
    int[] arrayOfInt = com.tencent.mm.cn.a.LYb;
    d.g.b.p.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (d.a.e.contains(arrayOfInt, i)) {
      localcvv.GXn = null;
    }
    for (;;)
    {
      localcvv.GXq = paramb.doK;
      localcvv.Gdl = paramb.hSZ;
      AppMethodBeat.o(223519);
      return localcvv;
      arrayOfInt = com.tencent.mm.cn.a.LYa;
      d.g.b.p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (d.a.e.contains(arrayOfInt, i)) {
        localcvv.GXn = null;
      } else {
        localcvv.GXn = paramb.coY;
      }
    }
  }
  
  private static List<baw> c(z.b paramb)
  {
    AppMethodBeat.i(180553);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new b(paramb);
    baw localbaw = ((b)localObject).brP();
    localbaw.GQQ = null;
    localbaw.GQT = false;
    localLinkedList.add(localbaw);
    localbaw = ((b)localObject).brP();
    localbaw.GQQ = null;
    localbaw.GQT = true;
    localLinkedList.add(localbaw);
    if (paramb.lLN > 0)
    {
      localObject = ((b)localObject).brP();
      ((baw)localObject).GQQ = new bwg();
      ((baw)localObject).GQQ.Gdm = paramb.lLN;
      ((baw)localObject).GQQ.GZl = paramb.lML;
      ((baw)localObject).GQT = false;
      localLinkedList.add(localObject);
    }
    paramb = (List)localLinkedList;
    AppMethodBeat.o(180553);
    return paramb;
  }
  
  public final void a(final z.b paramb, final d.g.a.b<? super bax[], d.z> paramb1, final d.g.a.q<? super Integer, ? super Integer, ? super String, d.z> paramq, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(180551);
    d.g.b.p.h(paramb, "request");
    d.g.b.p.h(paramb1, "onSuccess");
    d.g.b.p.h(paramq, "onError");
    Object localObject3 = (bax[])lLU.remove(paramb);
    if (localObject3 != null)
    {
      ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(paramb)));
      d.g.b.p.g(localObject3, "preGetResp");
      if (d.a.e.f((Object[])localObject3, 0) != null)
      {
        paramb1.invoke(localObject3);
        AppMethodBeat.o(180551);
        return;
      }
    }
    if (!paramb.lMM)
    {
      localObject3 = com.tencent.mm.cn.a.LXZ;
      d.g.b.p.g(localObject3, "ConstantsWxaPackageProto…CGI_SUPPORT_PACKAGE_TYPES");
      if (d.a.e.contains((int[])localObject3, paramb.doK))
      {
        localObject3 = a.lLW;
        if (!w.a.a.brO()) {
          break label236;
        }
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "goNewCgi: %b,appId: %s", new Object[] { Boolean.valueOf(bool), paramb.appId });
      if (!bool) {
        break;
      }
      localObject1 = new jx();
      ((jx)localObject1).FUW.addAll((Collection)c(paramb));
      new com.tencent.mm.plugin.appbrand.appcache.g((jx)localObject1).aET().j((com.tencent.mm.vending.c.a)new e(paramb1, paramb, paramq));
      AppMethodBeat.o(180551);
      return;
    }
    if (j.a.rT(paramb.hSZ))
    {
      localObject1 = com.tencent.mm.plugin.appbrand.app.j.aZu();
      if (localObject1 != null)
      {
        localObject1 = ((bh)localObject1).a(new ad(paramb.appId, paramb.coY, paramb.doK).toString(), paramb.aDD, paramb.hSZ, new String[] { "versionMd5" });
        if (localObject1 == null) {}
      }
      for (localObject1 = ((bd)localObject1).field_versionMd5;; localObject1 = null)
      {
        localObject2 = new bmh();
        ((bmh)localObject2).dwb = paramb.appId;
        ((bmh)localObject2).Gdm = paramb.aDD;
        ((bmh)localObject2).GXq = paramb.doK;
        ((bmh)localObject2).GZg = paramb.lLN;
        if (((bmh)localObject2).GXq != 0)
        {
          localObject3 = com.tencent.mm.cn.a.LYa;
          d.g.b.p.g(localObject3, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
          if (!d.a.e.contains((int[])localObject3, ((bmh)localObject2).GXq)) {
            ((bmh)localObject2).GXn = paramb.coY;
          }
        }
        ((bmh)localObject2).scene = paramInt;
        new h((bmh)localObject2).aET().j((com.tencent.mm.vending.c.a)new f(paramq, paramb1, (String)localObject1, paramb));
        AppMethodBeat.o(180551);
        return;
      }
    }
    if (paramb.doK == 0)
    {
      ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode packageType=0, use record, request=".concat(String.valueOf(paramb)));
      localObject2 = com.tencent.mm.plugin.appbrand.app.j.aZu();
      if (localObject2 != null) {
        localObject1 = ((bh)localObject2).a(new ad(paramb.appId, paramb.coY, paramb.doK).toString(), 0, paramb.hSZ, new String[] { "versionMd5", "downloadURL" });
      }
      if (localObject1 == null)
      {
        paramq.d(Integer.valueOf(-1), Integer.valueOf(-1), ak.getResources().getString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.rS(paramb.hSZ) }));
        AppMethodBeat.o(180551);
        return;
      }
      paramq = new bax[3];
      localObject2 = new bax();
      ((bax)localObject2).url = ((bd)localObject1).field_downloadURL;
      ((bax)localObject2).md5 = ((bd)localObject1).field_versionMd5;
      ((bax)localObject2).GQW = false;
      ((bax)localObject2).GQP = b(paramb);
      paramq[0] = localObject2;
      paramb1.invoke(paramq);
      AppMethodBeat.o(180551);
      return;
    }
    ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode with request=".concat(String.valueOf(paramb)));
    localObject3 = com.tencent.mm.plugin.appbrand.app.j.aZu();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((bh)localObject3).a(new ad(paramb.appId, paramb.coY, paramb.doK).toString(), 0, paramb.hSZ, new String[] { "versionMd5" });
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((bd)localObject3).field_versionMd5;
      }
    }
    new com.tencent.mm.plugin.appbrand.appcache.i(paramb.appId, paramb.coY, (String)localObject1, paramb.hSZ, paramb.doK).aET().j((com.tencent.mm.vending.c.a)new g(paramq, paramb, paramb1, (String)localObject1));
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
      ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, use single routine instead, with " + (z.b)d.a.j.jl(paramList));
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
      localObject3 = (bax[])lLU.remove(localb);
      if (localObject3 != null)
      {
        d.g.b.p.g(localObject3, "preGetResp");
        if (d.a.e.f((Object[])localObject3, 0) != null)
        {
          ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(localb)));
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
    ae.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, inRequestList.size=" + paramList.size() + ", realRequestList.size=" + ((LinkedList)localObject1).size() + ", preGetRespItemList.size=" + localLinkedList.size());
    if (((LinkedList)localObject1).size() <= 0)
    {
      paramList = new jy();
      paramList.FUX.addAll((Collection)localLinkedList);
      paramb.invoke(paramList);
      AppMethodBeat.o(180552);
      return;
    }
    paramList = new jx();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (z.b)((Iterator)localObject1).next();
      paramList.FUW.addAll((Collection)c((z.b)localObject2));
    }
    new com.tencent.mm.plugin.appbrand.appcache.g(paramList).aET().j((com.tencent.mm.vending.c.a)new d(localLinkedList, paramb, paramq));
    AppMethodBeat.o(180552);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "", "useEncryptPkg", "", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "Factory", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public static final a lLW = a.lLY;
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "TEST_SWITCH_MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "resetTestSwitch", "", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "useEncryptPkg", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "plugin-appbrand-integration_release"})
    public static final class a
      implements w.a
    {
      private static final ay lLX;
      
      static
      {
        AppMethodBeat.i(180531);
        lLY = new a();
        lLX = ay.gq("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE.TEST_SWITCH_MMKV", 2);
        AppMethodBeat.o(180531);
      }
      
      private static boolean a(b.a parama)
      {
        AppMethodBeat.i(223513);
        if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE))
        {
          ae.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", INTERNAL BUILD, defBool:true");
          AppMethodBeat.o(223513);
          return true;
        }
        if (!d.FFK)
        {
          ae.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", !ALPHA, defBool:false");
          AppMethodBeat.o(223513);
          return false;
        }
        if (ak.coh()) {
          d.g.b.p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
        }
        String str;
        for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.aiG())
        {
          str = com.tencent.mm.b.p.getString(i) + '_' + parama.name();
          if (!lLX.containsKey(str)) {
            break;
          }
          bool = lLX.getBoolean(str, false);
          ae.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", IS_ALPHA, defBool:" + bool);
          AppMethodBeat.o(223513);
          return bool;
        }
        if (com.tencent.mm.b.i.cf(i, 101) > 50) {}
        for (boolean bool = true;; bool = false)
        {
          lLX.putBoolean(str, bool);
          break;
        }
      }
      
      public static boolean brO()
      {
        AppMethodBeat.i(180528);
        boolean bool1 = a(b.a.qBW);
        boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBW, bool1);
        ae.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewCgi exptVal[" + bool2 + "] defVal[" + bool1 + ']');
        AppMethodBeat.o(180528);
        return bool2;
      }
      
      public static boolean gX(boolean paramBoolean)
      {
        AppMethodBeat.i(180529);
        boolean bool2;
        if (paramBoolean) {
          bool2 = a(b.a.qBZ);
        }
        for (boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBZ, bool2);; bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBY, bool2))
        {
          ae.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg isGame[" + paramBoolean + "] exptVal[" + bool1 + "] defVal[" + bool2 + ']');
          AppMethodBeat.o(180529);
          return bool1;
          bool2 = a(b.a.qBY);
        }
      }
      
      public static boolean gY(boolean paramBoolean)
      {
        AppMethodBeat.i(180530);
        if (paramBoolean)
        {
          bool1 = a(b.a.qCa);
          bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCa, bool1);
          ae.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewSeparatedPluginCompatibleLogic isGame[" + paramBoolean + "] exptVal[" + bool2 + "] defVal[" + bool1 + ']');
          AppMethodBeat.o(180530);
          return bool2;
        }
        boolean bool1 = a(b.a.qBX);
        boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBX, bool1);
        ae.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewSeparatedPluginCompatibleLogic isGame[" + paramBoolean + "] exptVal[" + bool2 + "] defVal[" + bool1 + ']');
        AppMethodBeat.o(180530);
        return bool2;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"buildBasicItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<baw>
  {
    b(z.b paramb)
    {
      super();
    }
    
    public final baw brP()
    {
      AppMethodBeat.i(180533);
      baw localbaw = new baw();
      w localw = w.lLV;
      localbaw.GQP = w.d(this.lLZ);
      localbaw.GQR = this.lLZ.lMK;
      if (this.lLZ.lMM) {
        localbaw.GQS = true;
      }
      localbaw.Gdm = this.lLZ.aDD;
      o.a(localbaw);
      AppMethodBeat.o(180533);
      return localbaw;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class c
    extends d.g.b.q
    implements d.g.a.b<bax[], d.z>
  {
    c(d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(LinkedList paramLinkedList, d.g.a.b paramb, d.g.a.q paramq) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d.g.a.b paramb, z.b paramb1, d.g.a.q paramq) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(d.g.a.q paramq, d.g.a.b paramb, String paramString, z.b paramb1) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(d.g.a.q paramq, z.b paramb, d.g.a.b paramb1, String paramString) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<bmh, String>
  {
    public static final h lMe;
    
    static
    {
      AppMethodBeat.i(180541);
      lMe = new h();
      AppMethodBeat.o(180541);
    }
    
    h()
    {
      super();
    }
    
    public static String a(bmh parambmh)
    {
      AppMethodBeat.i(180540);
      d.g.b.p.h(parambmh, "$this$info");
      parambmh = "GetWxaAppCDNDownloadUrlRequest(appId:" + parambmh.dwb + " version:" + parambmh.Gdm + " moduleName:" + parambmh.GXn + " pacakgeType:" + parambmh.GXq + " scene:" + parambmh.scene + ')';
      AppMethodBeat.o(180540);
      return parambmh;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"makeReqItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<baw>
  {
    i(h paramh)
    {
      super();
    }
    
    public final baw brP()
    {
      AppMethodBeat.i(223517);
      baw localbaw = new baw();
      localbaw.GQP = new cvv();
      localbaw.GQP.dwb = this.lMf.aZP().dwb;
      localbaw.Gdm = this.lMf.aZP().Gdm;
      localbaw.GQP.GXq = this.lMf.aZP().GXq;
      localbaw.GQP.GXn = this.lMf.aZP().GXn;
      localbaw.GQR = 0;
      AppMethodBeat.o(223517);
      return localbaw;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class j<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    j(h paramh) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoRequest;", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.b<bjw, String>
  {
    public static final k lMg;
    
    static
    {
      AppMethodBeat.i(180545);
      lMg = new k();
      AppMethodBeat.o(180545);
    }
    
    k()
    {
      super();
    }
    
    public static String a(bjw parambjw)
    {
      AppMethodBeat.i(180544);
      d.g.b.p.h(parambjw, "$this$info");
      parambjw = "GetTestCodeDownloadInfoRequest(appId:" + parambjw.dwb + " versionType:" + parambjw.GhO + " moduleName:" + parambjw.GXn + " packageType:" + parambjw.GXq + ')';
      AppMethodBeat.o(180544);
      return parambjw;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
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