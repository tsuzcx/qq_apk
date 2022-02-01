package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.ab.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "mPreGetDownloadUrlResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "addPreGetDownloadUrlResult", "", "map", "", "removePreGetDownloadUrlResult", "request", "waitForBatchGetDownloadUrl", "inRequestList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "waitForDownloadUrl", "wormholeForLegacyReleaseCode", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "cgi", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "wormholeForLegacyTestCode", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetTestCodeDownloadInfo;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "RouterController", "plugin-appbrand-integration_release"})
public final class u
  implements x
{
  private static final ConcurrentHashMap<x.a, btv[]> pUG;
  public static final u pUH;
  
  static
  {
    AppMethodBeat.i(180554);
    pUH = new u();
    pUG = new ConcurrentHashMap();
    AppMethodBeat.o(180554);
  }
  
  public static void P(Map<x.a, btv[]> paramMap)
  {
    AppMethodBeat.i(180547);
    p.k(paramMap, "map");
    pUG.putAll(paramMap);
    AppMethodBeat.o(180547);
  }
  
  public static void a(x.a parama)
  {
    AppMethodBeat.i(180548);
    p.k(parama, "request");
    pUG.remove(parama);
    AppMethodBeat.o(180548);
  }
  
  public static final f<c.a<cgt>> b(i parami)
  {
    AppMethodBeat.i(180550);
    p.k(parami, "cgi");
    Object localObject1 = a.pUI;
    localObject1 = f.pUN;
    localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
    Object localObject2 = parami.bGm();
    p.j(localObject2, "cgi.request");
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", f.a((cgs)localObject2) + " intercepted");
    Object localObject3 = new g(parami);
    localObject2 = new kc();
    ((kc)localObject2).RPC.add(((g)localObject3).bZR());
    localObject1 = ((kc)localObject2).RPC;
    Object localObject4 = ((g)localObject3).bZR();
    ((btu)localObject4).TdS = true;
    ((LinkedList)localObject1).add(localObject4);
    ((kc)localObject2).scene = parami.bGm().scene;
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "CgiBatchGetPkgDownloadInfo scene:%d", new Object[] { Integer.valueOf(((kc)localObject2).scene) });
    int i;
    if (parami.bGm().TnH > 0)
    {
      localObject1 = m.bFP().b(new ae(parami.bGm().appid, parami.bGm().TnI, parami.bGm().TnG).toString(), parami.bGm().TnH, 0, new String[] { "pkgPath" });
      if (localObject1 == null) {
        break label391;
      }
      localObject1 = ((bh)localObject1).field_pkgPath;
      if (!com.tencent.mm.vfs.u.agG((String)localObject1)) {
        break label396;
      }
      i = WxaPkg.acQ((String)localObject1);
      label235:
      localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
      localObject4 = f.pUN;
      localObject4 = parami.bGm();
      p.j(localObject4, "cgi.request");
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", f.a((cgs)localObject4) + ", intercepted, oldPkg.innerVersion=" + i);
      if (i != 0) {
        break label401;
      }
      localObject1 = ((kc)localObject2).RPC;
      localObject3 = ((g)localObject3).bZR();
      ((btu)localObject3).TdP = new csp();
      ((btu)localObject3).TdP.RYM = parami.bGm().TnH;
      ((LinkedList)localObject1).add(localObject3);
    }
    for (;;)
    {
      localObject1 = new ack();
      ((ack)localObject1).SnZ = 1;
      ((kc)localObject2).RPD = ((ack)localObject1);
      parami = new com.tencent.mm.plugin.appbrand.appcache.h((kc)localObject2).bhW().b((com.tencent.mm.vending.c.a)new h(parami));
      AppMethodBeat.o(180550);
      return parami;
      label391:
      localObject1 = null;
      break;
      label396:
      i = -1;
      break label235;
      label401:
      com.tencent.mm.plugin.report.service.h.IzE.el(697, 20);
    }
  }
  
  private static List<btu> b(x.a parama)
  {
    AppMethodBeat.i(180553);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new b(parama);
    btu localbtu = ((b)localObject).bZR();
    localbtu.TdP = null;
    localbtu.TdS = false;
    localLinkedList.add(localbtu);
    if (j.a.vB(parama.cBU))
    {
      parama = (List)localLinkedList;
      AppMethodBeat.o(180553);
      return parama;
    }
    localbtu = ((b)localObject).bZR();
    localbtu.TdP = null;
    localbtu.TdS = true;
    localLinkedList.add(localbtu);
    if (parama.pVt > 0)
    {
      localObject = ((b)localObject).bZR();
      ((btu)localObject).TdP = new csp();
      ((btu)localObject).TdP.RYM = parama.pVt;
      ((btu)localObject).TdP.TnN = parama.pVu;
      ((btu)localObject).TdS = false;
      localLinkedList.add(localObject);
    }
    parama = (List)localLinkedList;
    AppMethodBeat.o(180553);
    return parama;
  }
  
  public final void a(final x.a parama, kotlin.g.a.b<? super btv[], kotlin.x> paramb, final kotlin.g.a.q<? super Integer, ? super Integer, ? super String, kotlin.x> paramq, int paramInt, ack paramack)
  {
    AppMethodBeat.i(256875);
    p.k(parama, "request");
    p.k(paramb, "onSuccess");
    p.k(paramq, "onError");
    p.k(paramack, "cgiCommRequestSource");
    Object localObject = (btv[])pUG.remove(parama);
    if (localObject != null)
    {
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(parama)));
      p.j(localObject, "preGetResp");
      if (e.g((Object[])localObject, 0) != null)
      {
        paramb.invoke(localObject);
        AppMethodBeat.o(256875);
        return;
      }
    }
    if (!parama.pVv)
    {
      localObject = com.tencent.mm.cx.a.YYA;
      p.j(localObject, "ConstantsWxaPackageProto…CGI_SUPPORT_PACKAGE_TYPES");
      if (e.contains((int[])localObject, parama.fyH)) {
        localObject = a.pUI;
      }
    }
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "goNewCgi: %b,appId: %s", new Object[] { Boolean.TRUE, parama.appId });
    localObject = new kc();
    ((kc)localObject).RPC.addAll((Collection)b(parama));
    ((kc)localObject).scene = paramInt;
    ((kc)localObject).RPD = paramack;
    new com.tencent.mm.plugin.appbrand.appcache.h((kc)localObject).bhW().j((com.tencent.mm.vending.c.a)new e(paramb, parama, paramq));
    AppMethodBeat.o(256875);
  }
  
  public final void a(List<x.a> paramList, final kotlin.g.a.b<? super kd, kotlin.x> paramb, final kotlin.g.a.q<? super Integer, ? super Integer, ? super String, kotlin.x> paramq, int paramInt, ack paramack)
  {
    AppMethodBeat.i(256877);
    p.k(paramList, "inRequestList");
    p.k(paramb, "onSuccess");
    p.k(paramq, "onError");
    p.k(paramack, "cgiCommRequestSource");
    if (paramList.size() == 1)
    {
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, use single routine instead, with " + (x.a)j.lo(paramList));
      a((x.a)paramList.get(0), (kotlin.g.a.b)new c(paramb), paramq, paramInt, paramack);
      AppMethodBeat.o(256877);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList((Collection)paramList);
    Object localObject2 = ((LinkedList)localObject1).iterator();
    p.j(localObject2, "realRequestList.iterator()");
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      p.j(localObject3, "iterator.next()");
      x.a locala = (x.a)localObject3;
      localObject3 = (btv[])pUG.remove(locala);
      if (localObject3 != null)
      {
        p.j(localObject3, "preGetResp");
        if (e.g((Object[])localObject3, 0) != null)
        {
          Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(locala)));
          ((Iterator)localObject2).remove();
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            locala = localObject3[i];
            if (locala != null) {
              localLinkedList.add(locala);
            }
            i += 1;
          }
        }
      }
    }
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, inRequestList.size=" + paramList.size() + ", realRequestList.size=" + ((LinkedList)localObject1).size() + ", preGetRespItemList.size=" + localLinkedList.size());
    if (((LinkedList)localObject1).size() <= 0)
    {
      paramList = new kd();
      paramList.RPE.addAll((Collection)localLinkedList);
      paramb.invoke(paramList);
      AppMethodBeat.o(256877);
      return;
    }
    paramList = new kc();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (x.a)((Iterator)localObject1).next();
      paramList.RPC.addAll((Collection)b((x.a)localObject2));
      paramList.scene = paramInt;
      paramList.RPD = paramack;
    }
    new com.tencent.mm.plugin.appbrand.appcache.h(paramList).bhW().j((com.tencent.mm.vending.c.a)new d(localLinkedList, paramb, paramq));
    AppMethodBeat.o(256877);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "", "useEncryptPkg", "", "isGame", "usedCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "Factory", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public static final a pUI = a.pUJ;
    
    public abstract boolean a(boolean paramBoolean, ICommLibReader paramICommLibReader);
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "resetTestSwitch", "", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "useEncryptPkg", "isGame", "usedCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "plugin-appbrand-integration_release"})
    public static final class a
      implements u.a
    {
      static
      {
        AppMethodBeat.i(180531);
        pUJ = new a();
        AppMethodBeat.o(180531);
      }
      
      private static boolean a(b.a parama)
      {
        AppMethodBeat.i(271235);
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
        {
          Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", INTERNAL BUILD, defBool:true");
          AppMethodBeat.o(271235);
          return true;
        }
        AppMethodBeat.o(271235);
        return false;
      }
      
      public final boolean a(boolean paramBoolean, ICommLibReader paramICommLibReader)
      {
        AppMethodBeat.i(271238);
        if (paramBoolean)
        {
          paramBoolean = a(b.a.vBt);
          bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBt, paramBoolean);
          Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg for game, retVal[" + bool1 + "] exptVal[" + bool1 + "] defVal[" + paramBoolean + ']');
          AppMethodBeat.o(271238);
          return bool1;
        }
        boolean bool2 = a(b.a.vBs);
        boolean bool3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBs, bool2);
        if (paramICommLibReader != null)
        {
          ab.a locala = ab.qso;
          if (!ab.a.e(paramICommLibReader)) {}
        }
        else
        {
          paramBoolean = true;
          if ((!bool3) || (!paramBoolean)) {
            break label209;
          }
        }
        label209:
        for (boolean bool1 = true;; bool1 = false)
        {
          Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg for app, retVal[" + bool1 + "] exptVal[" + bool3 + "] defVal[" + bool2 + "] supportLazyCodeLoading[" + paramBoolean + ']');
          AppMethodBeat.o(271238);
          return bool1;
          paramBoolean = false;
          break;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"buildBasicItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<btu>
  {
    b(x.a parama)
    {
      super();
    }
    
    public final btu bZR()
    {
      AppMethodBeat.i(180533);
      btu localbtu = new btu();
      Object localObject = u.pUH;
      localbtu.TdO = u.c(this.pUK);
      localbtu.TdQ = this.pUK.pVs;
      if (this.pUK.pVv) {
        localbtu.TdR = true;
      }
      localbtu.RYM = this.pUK.appVersion;
      localObject = (CharSequence)this.pUK.nGm;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          localbtu.ufy = this.pUK.nGm;
        }
        n.a(localbtu);
        Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "request.appId:%s,packageType:%d,version_desc:%s,uin:%d,versionType:%d", new Object[] { localbtu.TdO.appid, Integer.valueOf(localbtu.TdO.TnG), localbtu.ufy, Integer.valueOf(localbtu.TdT), Integer.valueOf(localbtu.TdO.RYL) });
        AppMethodBeat.o(180533);
        return localbtu;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<btv[], kotlin.x>
  {
    c(kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(LinkedList paramLinkedList, kotlin.g.a.b paramb, kotlin.g.a.q paramq) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(kotlin.g.a.b paramb, x.a parama, kotlin.g.a.q paramq) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<cgs, String>
  {
    public static final f pUN;
    
    static
    {
      AppMethodBeat.i(180541);
      pUN = new f();
      AppMethodBeat.o(180541);
    }
    
    f()
    {
      super();
    }
    
    public static String a(cgs paramcgs)
    {
      AppMethodBeat.i(180540);
      p.k(paramcgs, "$this$info");
      paramcgs = "GetWxaAppCDNDownloadUrlRequest(appId:" + paramcgs.appid + " version:" + paramcgs.RYM + " moduleName:" + paramcgs.TnI + " pacakgeType:" + paramcgs.TnG + " scene:" + paramcgs.scene + ')';
      AppMethodBeat.o(180540);
      return paramcgs;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"makeReqItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<btu>
  {
    g(i parami)
    {
      super();
    }
    
    public final btu bZR()
    {
      AppMethodBeat.i(280172);
      btu localbtu = new btu();
      localbtu.TdO = new dyi();
      localbtu.TdO.appid = this.pUO.bGm().appid;
      localbtu.RYM = this.pUO.bGm().RYM;
      localbtu.TdO.TnG = this.pUO.bGm().TnG;
      localbtu.TdO.TnI = this.pUO.bGm().TnI;
      localbtu.TdQ = 0;
      AppMethodBeat.o(280172);
      return localbtu;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(i parami) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.u
 * JD-Core Version:    0.7.0.1
 */