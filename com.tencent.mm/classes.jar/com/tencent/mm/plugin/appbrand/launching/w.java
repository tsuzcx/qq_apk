package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.b.p;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "mPreGetDownloadUrlResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "addPreGetDownloadUrlResult", "", "map", "", "removePreGetDownloadUrlResult", "request", "waitForBatchGetDownloadUrl", "inRequestList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "waitForDownloadUrl", "wormholeForLegacyReleaseCode", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "cgi", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "wormholeForLegacyTestCode", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetTestCodeDownloadInfo;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "RouterController", "plugin-appbrand-integration_release"})
public final class w
  implements z
{
  private static final ConcurrentHashMap<z.b, awj[]> lkm;
  public static final w lkn;
  
  static
  {
    AppMethodBeat.i(180554);
    lkn = new w();
    lkm = new ConcurrentHashMap();
    AppMethodBeat.o(180554);
  }
  
  public static void M(Map<z.b, awj[]> paramMap)
  {
    AppMethodBeat.i(180547);
    k.h(paramMap, "map");
    lkm.putAll(paramMap);
    AppMethodBeat.o(180547);
  }
  
  public static final f<c.a<bex>> a(com.tencent.mm.plugin.appbrand.appcache.i parami)
  {
    AppMethodBeat.i(180549);
    k.h(parami, "cgi");
    Object localObject1 = a.lko;
    if (!w.a.a.bns())
    {
      AppMethodBeat.o(180549);
      return null;
    }
    localObject1 = k.lky;
    localObject1 = new StringBuilder("wormholeForLegacyTestCode with ");
    Object localObject2 = parami.aVZ();
    k.g(localObject2, "cgi.request");
    ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", k.a((bew)localObject2) + " intercepted");
    localObject1 = new awi();
    ((awi)localObject1).EOl = new cpw();
    ((awi)localObject1).EOl.djj = parami.aVZ().djj;
    ((awi)localObject1).EOl.EUn = parami.aVZ().EUn;
    ((awi)localObject1).EOl.EUq = parami.aVZ().EUq;
    ((awi)localObject1).EOl.Een = parami.aVZ().Eif;
    ((awi)localObject1).EOn = 0;
    ((awi)localObject1).EOq = parami.aVZ().EUp;
    localObject2 = new jo();
    ((jo)localObject2).DXf.add(localObject1);
    parami = new com.tencent.mm.plugin.appbrand.appcache.g((jo)localObject2).aBB().b((com.tencent.mm.vending.c.a)new l(parami));
    AppMethodBeat.o(180549);
    return parami;
  }
  
  public static void a(z.b paramb)
  {
    AppMethodBeat.i(180548);
    k.h(paramb, "request");
    lkm.remove(paramb);
    AppMethodBeat.o(180548);
  }
  
  public static final f<c.a<bhi>> b(com.tencent.mm.plugin.appbrand.appcache.h paramh)
  {
    Object localObject1 = null;
    AppMethodBeat.i(180550);
    k.h(paramh, "cgi");
    Object localObject2 = a.lko;
    if (!w.a.a.bns())
    {
      AppMethodBeat.o(180550);
      return null;
    }
    localObject2 = h.lkw;
    localObject2 = new StringBuilder("wormholeForLegacyReleaseCode with ");
    Object localObject3 = paramh.aVX();
    k.g(localObject3, "cgi.request");
    ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", h.a((bhh)localObject3) + " intercepted");
    localObject3 = new i(paramh);
    localObject2 = new jo();
    ((jo)localObject2).DXf.add(((i)localObject3).bnt());
    Object localObject4 = ((jo)localObject2).DXf;
    awi localawi = ((i)localObject3).bnt();
    localawi.EOp = true;
    ((LinkedList)localObject4).add(localawi);
    ((jo)localObject2).scene = paramh.aVX().scene;
    ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "CgiBatchGetPkgDownloadInfo scene:%d", new Object[] { Integer.valueOf(((jo)localObject2).scene) });
    int i;
    if (paramh.aVX().EWh > 0)
    {
      localObject4 = com.tencent.mm.plugin.appbrand.app.j.aVC().a(new ab(paramh.aVX().djj, paramh.aVX().EUn, paramh.aVX().EUq).toString(), paramh.aVX().EWh, 0, new String[] { "pkgPath" });
      if (localObject4 != null) {
        localObject1 = ((bb)localObject4).field_pkgPath;
      }
      if (!com.tencent.mm.vfs.i.eA((String)localObject1)) {
        break label403;
      }
      i = WxaPkg.Ic((String)localObject1);
      localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
      localObject4 = h.lkw;
      localObject4 = paramh.aVX();
      k.g(localObject4, "cgi.request");
      ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", h.a((bhh)localObject4) + ", intercepted, oldPkg.innerVersion=" + i);
      if (i != 0) {
        break label408;
      }
      localObject1 = ((jo)localObject2).DXf;
      localObject3 = ((i)localObject3).bnt();
      ((awi)localObject3).EOm = new bqz();
      ((awi)localObject3).EOm.Eeo = paramh.aVX().EWh;
      ((LinkedList)localObject1).add(localObject3);
    }
    for (;;)
    {
      paramh = new com.tencent.mm.plugin.appbrand.appcache.g((jo)localObject2).aBB().b((com.tencent.mm.vending.c.a)new j(paramh));
      AppMethodBeat.o(180550);
      return paramh;
      label403:
      i = -1;
      break;
      label408:
      com.tencent.mm.plugin.report.service.h.wUl.dB(697, 20);
    }
  }
  
  private static cpw b(z.b paramb)
  {
    AppMethodBeat.i(187299);
    cpw localcpw = new cpw();
    localcpw.djj = paramb.appId;
    int i = paramb.dcj;
    int[] arrayOfInt = com.tencent.mm.co.a.JHX;
    k.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (d.a.e.contains(arrayOfInt, i)) {
      localcpw.EUn = null;
    }
    for (;;)
    {
      localcpw.EUq = paramb.dcj;
      localcpw.Een = paramb.hxM;
      AppMethodBeat.o(187299);
      return localcpw;
      arrayOfInt = com.tencent.mm.co.a.JHW;
      k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (d.a.e.contains(arrayOfInt, i)) {
        localcpw.EUn = null;
      } else {
        localcpw.EUn = paramb.ceF;
      }
    }
  }
  
  private static List<awi> c(z.b paramb)
  {
    AppMethodBeat.i(180553);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new b(paramb);
    awi localawi = ((b)localObject).bnt();
    localawi.EOm = null;
    localawi.EOp = false;
    localLinkedList.add(localawi);
    localawi = ((b)localObject).bnt();
    localawi.EOm = null;
    localawi.EOp = true;
    localLinkedList.add(localawi);
    if (paramb.lkf > 0)
    {
      localObject = ((b)localObject).bnt();
      ((awi)localObject).EOm = new bqz();
      ((awi)localObject).EOm.Eeo = paramb.lkf;
      ((awi)localObject).EOm.EWm = paramb.lld;
      ((awi)localObject).EOp = false;
      localLinkedList.add(localObject);
    }
    paramb = (List)localLinkedList;
    AppMethodBeat.o(180553);
    return paramb;
  }
  
  public final void a(final z.b paramb, final d.g.a.b<? super awj[], y> paramb1, final q<? super Integer, ? super Integer, ? super String, y> paramq, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(180551);
    k.h(paramb, "request");
    k.h(paramb1, "onSuccess");
    k.h(paramq, "onError");
    Object localObject3 = (awj[])lkm.remove(paramb);
    if (localObject3 != null)
    {
      ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(paramb)));
      k.g(localObject3, "preGetResp");
      if (d.a.e.f((Object[])localObject3, 0) != null)
      {
        paramb1.ay(localObject3);
        AppMethodBeat.o(180551);
        return;
      }
    }
    if (!paramb.lle)
    {
      localObject3 = com.tencent.mm.co.a.JHV;
      k.g(localObject3, "ConstantsWxaPackageProto…CGI_SUPPORT_PACKAGE_TYPES");
      if (d.a.e.contains((int[])localObject3, paramb.dcj))
      {
        localObject3 = a.lko;
        if (!w.a.a.bns()) {
          break label236;
        }
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "goNewCgi: %b,appId: %s", new Object[] { Boolean.valueOf(bool), paramb.appId });
      if (!bool) {
        break;
      }
      localObject1 = new jo();
      ((jo)localObject1).DXf.addAll((Collection)c(paramb));
      new com.tencent.mm.plugin.appbrand.appcache.g((jo)localObject1).aBB().j((com.tencent.mm.vending.c.a)new e(paramb1, paramb, paramq));
      AppMethodBeat.o(180551);
      return;
    }
    if (j.a.rq(paramb.hxM))
    {
      localObject1 = com.tencent.mm.plugin.appbrand.app.j.aVC();
      if (localObject1 != null)
      {
        localObject1 = ((bf)localObject1).a(new ab(paramb.appId, paramb.ceF, paramb.dcj).toString(), paramb.aBM, paramb.hxM, new String[] { "versionMd5" });
        if (localObject1 == null) {}
      }
      for (localObject1 = ((bb)localObject1).field_versionMd5;; localObject1 = null)
      {
        localObject2 = new bhh();
        ((bhh)localObject2).djj = paramb.appId;
        ((bhh)localObject2).Eeo = paramb.aBM;
        ((bhh)localObject2).EUq = paramb.dcj;
        ((bhh)localObject2).EWh = paramb.lkf;
        if (((bhh)localObject2).EUq != 0)
        {
          localObject3 = com.tencent.mm.co.a.JHW;
          k.g(localObject3, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
          if (!d.a.e.contains((int[])localObject3, ((bhh)localObject2).EUq)) {
            ((bhh)localObject2).EUn = paramb.ceF;
          }
        }
        ((bhh)localObject2).scene = paramInt;
        new com.tencent.mm.plugin.appbrand.appcache.h((bhh)localObject2).aBB().j((com.tencent.mm.vending.c.a)new f(paramq, paramb1, (String)localObject1, paramb));
        AppMethodBeat.o(180551);
        return;
      }
    }
    if (paramb.dcj == 0)
    {
      ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode packageType=0, use record, request=".concat(String.valueOf(paramb)));
      localObject2 = com.tencent.mm.plugin.appbrand.app.j.aVC();
      if (localObject2 != null) {
        localObject1 = ((bf)localObject2).a(new ab(paramb.appId, paramb.ceF, paramb.dcj).toString(), 0, paramb.hxM, new String[] { "versionMd5", "downloadURL" });
      }
      if (localObject1 == null)
      {
        paramq.d(Integer.valueOf(-1), Integer.valueOf(-1), ai.getResources().getString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.rp(paramb.hxM) }));
        AppMethodBeat.o(180551);
        return;
      }
      paramq = new awj[3];
      localObject2 = new awj();
      ((awj)localObject2).url = ((bb)localObject1).field_downloadURL;
      ((awj)localObject2).md5 = ((bb)localObject1).field_versionMd5;
      ((awj)localObject2).EOs = false;
      ((awj)localObject2).EOl = b(paramb);
      paramq[0] = localObject2;
      paramb1.ay(paramq);
      AppMethodBeat.o(180551);
      return;
    }
    ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode with request=".concat(String.valueOf(paramb)));
    localObject3 = com.tencent.mm.plugin.appbrand.app.j.aVC();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((bf)localObject3).a(new ab(paramb.appId, paramb.ceF, paramb.dcj).toString(), 0, paramb.hxM, new String[] { "versionMd5" });
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((bb)localObject3).field_versionMd5;
      }
    }
    new com.tencent.mm.plugin.appbrand.appcache.i(paramb.appId, paramb.ceF, (String)localObject1, paramb.hxM, paramb.dcj).aBB().j((com.tencent.mm.vending.c.a)new g(paramq, paramb, paramb1, (String)localObject1));
    AppMethodBeat.o(180551);
  }
  
  public final void a(List<z.b> paramList, final d.g.a.b<? super jp, y> paramb, final q<? super Integer, ? super Integer, ? super String, y> paramq, int paramInt)
  {
    AppMethodBeat.i(180552);
    k.h(paramList, "inRequestList");
    k.h(paramb, "onSuccess");
    k.h(paramq, "onError");
    if (paramList.size() == 1)
    {
      ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, use single routine instead, with " + (z.b)d.a.j.iO(paramList));
      a((z.b)paramList.get(0), (d.g.a.b)new c(paramb), paramq, paramInt);
      AppMethodBeat.o(180552);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList((Collection)paramList);
    Object localObject2 = ((LinkedList)localObject1).iterator();
    k.g(localObject2, "realRequestList.iterator()");
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      k.g(localObject3, "iterator.next()");
      z.b localb = (z.b)localObject3;
      localObject3 = (awj[])lkm.remove(localb);
      if (localObject3 != null)
      {
        k.g(localObject3, "preGetResp");
        if (d.a.e.f((Object[])localObject3, 0) != null)
        {
          ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(localb)));
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
    ac.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, inRequestList.size=" + paramList.size() + ", realRequestList.size=" + ((LinkedList)localObject1).size() + ", preGetRespItemList.size=" + localLinkedList.size());
    paramList = new jo();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (z.b)((Iterator)localObject1).next();
      paramList.DXf.addAll((Collection)c((z.b)localObject2));
    }
    new com.tencent.mm.plugin.appbrand.appcache.g(paramList).aBB().j((com.tencent.mm.vending.c.a)new d(localLinkedList, paramb, paramq));
    AppMethodBeat.o(180552);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "", "useEncryptPkg", "", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "Factory", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public static final a lko = a.lkq;
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "TEST_SWITCH_MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "resetTestSwitch", "", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "useEncryptPkg", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "plugin-appbrand-integration_release"})
    public static final class a
      implements w.a
    {
      private static final aw lkp;
      
      static
      {
        AppMethodBeat.i(180531);
        lkq = new a();
        lkp = aw.fK("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE.TEST_SWITCH_MMKV", 2);
        AppMethodBeat.o(180531);
      }
      
      private static boolean a(b.a parama)
      {
        AppMethodBeat.i(187294);
        if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
        {
          ac.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", INTERNAL BUILD, defBool:true");
          AppMethodBeat.o(187294);
          return true;
        }
        if (!d.DIf)
        {
          ac.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", !ALPHA, defBool:false");
          AppMethodBeat.o(187294);
          return false;
        }
        if (ai.cin()) {
          k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
        }
        String str;
        for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.afF())
        {
          str = p.getString(i) + '_' + parama.name();
          if (!lkp.containsKey(str)) {
            break;
          }
          bool = lkp.getBoolean(str, false);
          ac.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", IS_ALPHA, defBool:" + bool);
          AppMethodBeat.o(187294);
          return bool;
        }
        if (com.tencent.mm.b.i.cc(i, 101) > 50) {}
        for (boolean bool = true;; bool = false)
        {
          lkp.putBoolean(str, bool);
          break;
        }
      }
      
      public static boolean bns()
      {
        AppMethodBeat.i(180528);
        boolean bool1 = a(b.a.pQH);
        boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQH, bool1);
        ac.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewCgi exptVal[" + bool2 + "] defVal[" + bool1 + ']');
        AppMethodBeat.o(180528);
        return bool2;
      }
      
      public static boolean gQ(boolean paramBoolean)
      {
        AppMethodBeat.i(180529);
        boolean bool2;
        if (paramBoolean) {
          bool2 = a(b.a.pQK);
        }
        for (boolean bool1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQK, bool2);; bool1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQJ, bool2))
        {
          ac.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg isGame[" + paramBoolean + "] exptVal[" + bool1 + "] defVal[" + bool2 + ']');
          AppMethodBeat.o(180529);
          return bool1;
          bool2 = a(b.a.pQJ);
        }
      }
      
      public static boolean gR(boolean paramBoolean)
      {
        AppMethodBeat.i(180530);
        if (paramBoolean)
        {
          bool1 = a(b.a.pQL);
          bool2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQL, bool1);
          ac.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewSeparatedPluginCompatibleLogic isGame[" + paramBoolean + "] exptVal[" + bool2 + "] defVal[" + bool1 + ']');
          AppMethodBeat.o(180530);
          return bool2;
        }
        boolean bool1 = a(b.a.pQI);
        boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQI, bool1);
        ac.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewSeparatedPluginCompatibleLogic isGame[" + paramBoolean + "] exptVal[" + bool2 + "] defVal[" + bool1 + ']');
        AppMethodBeat.o(180530);
        return bool2;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"buildBasicItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<awi>
  {
    b(z.b paramb)
    {
      super();
    }
    
    public final awi bnt()
    {
      AppMethodBeat.i(180533);
      awi localawi = new awi();
      w localw = w.lkn;
      localawi.EOl = w.d(this.lkr);
      localawi.EOn = this.lkr.llc;
      if (this.lkr.lle) {
        localawi.EOo = true;
      }
      for (;;)
      {
        o.a(localawi);
        AppMethodBeat.o(180533);
        return localawi;
        localawi.Eeo = this.lkr.aBM;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<awj[], y>
  {
    c(d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(LinkedList paramLinkedList, d.g.a.b paramb, q paramq) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d.g.a.b paramb, z.b paramb1, q paramq) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(q paramq, d.g.a.b paramb, String paramString, z.b paramb1) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(q paramq, z.b paramb, d.g.a.b paramb1, String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<bhh, String>
  {
    public static final h lkw;
    
    static
    {
      AppMethodBeat.i(180541);
      lkw = new h();
      AppMethodBeat.o(180541);
    }
    
    h()
    {
      super();
    }
    
    public static String a(bhh parambhh)
    {
      AppMethodBeat.i(180540);
      k.h(parambhh, "$this$info");
      parambhh = "GetWxaAppCDNDownloadUrlRequest(appId:" + parambhh.djj + " version:" + parambhh.Eeo + " moduleName:" + parambhh.EUn + " pacakgeType:" + parambhh.EUq + " scene:" + parambhh.scene + ')';
      AppMethodBeat.o(180540);
      return parambhh;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"makeReqItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<awi>
  {
    i(com.tencent.mm.plugin.appbrand.appcache.h paramh)
    {
      super();
    }
    
    public final awi bnt()
    {
      AppMethodBeat.i(187297);
      awi localawi = new awi();
      localawi.EOl = new cpw();
      localawi.EOl.djj = this.lkx.aVX().djj;
      localawi.Eeo = this.lkx.aVX().Eeo;
      localawi.EOl.EUq = this.lkx.aVX().EUq;
      localawi.EOl.EUn = this.lkx.aVX().EUn;
      localawi.EOn = 0;
      AppMethodBeat.o(187297);
      return localawi;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class j<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    j(com.tencent.mm.plugin.appbrand.appcache.h paramh) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoRequest;", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.b<bew, String>
  {
    public static final k lky;
    
    static
    {
      AppMethodBeat.i(180545);
      lky = new k();
      AppMethodBeat.o(180545);
    }
    
    k()
    {
      super();
    }
    
    public static String a(bew parambew)
    {
      AppMethodBeat.i(180544);
      k.h(parambew, "$this$info");
      parambew = "GetTestCodeDownloadInfoRequest(appId:" + parambew.djj + " versionType:" + parambew.Eif + " moduleName:" + parambew.EUn + " packageType:" + parambew.EUq + ')';
      AppMethodBeat.o(180544);
      return parambew;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
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