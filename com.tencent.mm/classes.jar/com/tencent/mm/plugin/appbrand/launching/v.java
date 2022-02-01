package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.g;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "mPreGetDownloadUrlResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "addPreGetDownloadUrlResult", "", "map", "", "removePreGetDownloadUrlResult", "request", "waitForBatchGetDownloadUrl", "inRequestList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "waitForDownloadUrl", "wormholeForLegacyReleaseCode", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "cgi", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "wormholeForLegacyTestCode", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetTestCodeDownloadInfo;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "RouterController", "plugin-appbrand-integration_release"})
public final class v
  implements y
{
  private static final ConcurrentHashMap<y.b, bmm[]> mTF;
  public static final v mTG;
  
  static
  {
    AppMethodBeat.i(180554);
    mTG = new v();
    mTF = new ConcurrentHashMap();
    AppMethodBeat.o(180554);
  }
  
  public static void W(Map<y.b, bmm[]> paramMap)
  {
    AppMethodBeat.i(180547);
    p.h(paramMap, "map");
    mTF.putAll(paramMap);
    AppMethodBeat.o(180547);
  }
  
  public static final f<c.a<bwc>> a(i parami)
  {
    AppMethodBeat.i(180549);
    p.h(parami, "cgi");
    Object localObject1 = v.a.mTH;
    localObject1 = i.mTP;
    localObject1 = new StringBuilder("wormholeForLegacyTestCode with ");
    Object localObject2 = parami.bvi();
    p.g(localObject2, "cgi.request");
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", i.a((bwb)localObject2) + " intercepted");
    localObject2 = new bml();
    ((bml)localObject2).LVf = new doo();
    ((bml)localObject2).LVf.dNI = parami.bvi().dNI;
    ((bml)localObject2).LVf.MbW = parami.bvi().MbW;
    ((bml)localObject2).LVf.MbZ = parami.bvi().MbZ;
    ((bml)localObject2).LVf.KXC = parami.bvi().Lcr;
    ((bml)localObject2).LVh = 0;
    ((bml)localObject2).LVk = parami.bvi().MbY;
    localObject1 = new km();
    ((km)localObject1).KOE.add(localObject2);
    localObject2 = new acc();
    ((acc)localObject2).LmG = 1;
    ((km)localObject1).KOF = ((acc)localObject2);
    parami = new g((km)localObject1).aYI().b((com.tencent.mm.vending.c.a)new j(parami));
    AppMethodBeat.o(180549);
    return parami;
  }
  
  public static void a(y.b paramb)
  {
    AppMethodBeat.i(180548);
    p.h(paramb, "request");
    mTF.remove(paramb);
    AppMethodBeat.o(180548);
  }
  
  public static final f<c.a<byz>> b(com.tencent.mm.plugin.appbrand.appcache.h paramh)
  {
    AppMethodBeat.i(180550);
    p.h(paramh, "cgi");
    Object localObject1 = v.a.mTH;
    localObject1 = f.mTN;
    localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
    Object localObject2 = paramh.bvg();
    p.g(localObject2, "cgi.request");
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", f.a((byy)localObject2) + " intercepted");
    Object localObject3 = new g(paramh);
    localObject2 = new km();
    ((km)localObject2).KOE.add(((g)localObject3).bNy());
    localObject1 = ((km)localObject2).KOE;
    Object localObject4 = ((g)localObject3).bNy();
    ((bml)localObject4).LVj = true;
    ((LinkedList)localObject1).add(localObject4);
    ((km)localObject2).scene = paramh.bvg().scene;
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "CgiBatchGetPkgDownloadInfo scene:%d", new Object[] { Integer.valueOf(((km)localObject2).scene) });
    int i;
    if (paramh.bvg().Meg > 0)
    {
      localObject1 = n.buL().a(new ad(paramh.bvg().dNI, paramh.bvg().MbW, paramh.bvg().MbZ).toString(), paramh.bvg().Meg, 0, new String[] { "pkgPath" });
      if (localObject1 == null) {
        break label397;
      }
      localObject1 = ((bd)localObject1).field_pkgPath;
      if (!s.YS((String)localObject1)) {
        break label402;
      }
      i = WxaPkg.Vg((String)localObject1);
      label239:
      localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
      localObject4 = f.mTN;
      localObject4 = paramh.bvg();
      p.g(localObject4, "cgi.request");
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", f.a((byy)localObject4) + ", intercepted, oldPkg.innerVersion=" + i);
      if (i != 0) {
        break label407;
      }
      localObject1 = ((km)localObject2).KOE;
      localObject3 = ((g)localObject3).bNy();
      ((bml)localObject3).LVg = new cju();
      ((bml)localObject3).LVg.KXD = paramh.bvg().Meg;
      ((LinkedList)localObject1).add(localObject3);
    }
    for (;;)
    {
      localObject1 = new acc();
      ((acc)localObject1).LmG = 1;
      ((km)localObject2).KOF = ((acc)localObject1);
      paramh = new g((km)localObject2).aYI().b((com.tencent.mm.vending.c.a)new h(paramh));
      AppMethodBeat.o(180550);
      return paramh;
      label397:
      localObject1 = null;
      break;
      label402:
      i = -1;
      break label239;
      label407:
      com.tencent.mm.plugin.report.service.h.CyF.dN(697, 20);
    }
  }
  
  private static List<bml> b(y.b paramb)
  {
    AppMethodBeat.i(180553);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new b(paramb);
    bml localbml = ((b)localObject).bNy();
    localbml.LVg = null;
    localbml.LVj = false;
    localLinkedList.add(localbml);
    localbml = ((b)localObject).bNy();
    localbml.LVg = null;
    localbml.LVj = true;
    localLinkedList.add(localbml);
    if (paramb.mUv > 0)
    {
      localObject = ((b)localObject).bNy();
      ((bml)localObject).LVg = new cju();
      ((bml)localObject).LVg.KXD = paramb.mUv;
      ((bml)localObject).LVg.Mel = paramb.mUw;
      ((bml)localObject).LVj = false;
      localLinkedList.add(localObject);
    }
    paramb = (List)localLinkedList;
    AppMethodBeat.o(180553);
    return paramb;
  }
  
  public final void a(final y.b paramb, b<? super bmm[], x> paramb1, final kotlin.g.a.q<? super Integer, ? super Integer, ? super String, x> paramq, int paramInt, acc paramacc)
  {
    AppMethodBeat.i(228656);
    p.h(paramb, "request");
    p.h(paramb1, "onSuccess");
    p.h(paramq, "onError");
    p.h(paramacc, "cgiCommRequestSource");
    Object localObject = (bmm[])mTF.remove(paramb);
    if (localObject != null)
    {
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(paramb)));
      p.g(localObject, "preGetResp");
      if (e.f((Object[])localObject, 0) != null)
      {
        paramb1.invoke(localObject);
        AppMethodBeat.o(228656);
        return;
      }
    }
    if (!paramb.mUx)
    {
      localObject = com.tencent.mm.cp.a.RwZ;
      p.g(localObject, "ConstantsWxaPackageProto…CGI_SUPPORT_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramb.packageType)) {
        localObject = v.a.mTH;
      }
    }
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "goNewCgi: %b,appId: %s", new Object[] { Boolean.TRUE, paramb.appId });
    localObject = new km();
    ((km)localObject).KOE.addAll((Collection)b(paramb));
    ((km)localObject).scene = paramInt;
    ((km)localObject).KOF = paramacc;
    new g((km)localObject).aYI().j((com.tencent.mm.vending.c.a)new e(paramb1, paramb, paramq));
    AppMethodBeat.o(228656);
  }
  
  public final void a(List<y.b> paramList, final b<? super kn, x> paramb, final kotlin.g.a.q<? super Integer, ? super Integer, ? super String, x> paramq, int paramInt, acc paramacc)
  {
    AppMethodBeat.i(228657);
    p.h(paramList, "inRequestList");
    p.h(paramb, "onSuccess");
    p.h(paramq, "onError");
    p.h(paramacc, "cgiCommRequestSource");
    if (paramList.size() == 1)
    {
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, use single routine instead, with " + (y.b)j.ks(paramList));
      a((y.b)paramList.get(0), (b)new c(paramb), paramq, paramInt, paramacc);
      AppMethodBeat.o(228657);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList((Collection)paramList);
    Object localObject2 = ((LinkedList)localObject1).iterator();
    p.g(localObject2, "realRequestList.iterator()");
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      p.g(localObject3, "iterator.next()");
      y.b localb = (y.b)localObject3;
      localObject3 = (bmm[])mTF.remove(localb);
      if (localObject3 != null)
      {
        p.g(localObject3, "preGetResp");
        if (e.f((Object[])localObject3, 0) != null)
        {
          Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(localb)));
          ((Iterator)localObject2).remove();
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            localb = localObject3[i];
            if (localb != null) {
              localLinkedList.add(localb);
            }
            i += 1;
          }
        }
      }
    }
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, inRequestList.size=" + paramList.size() + ", realRequestList.size=" + ((LinkedList)localObject1).size() + ", preGetRespItemList.size=" + localLinkedList.size());
    if (((LinkedList)localObject1).size() <= 0)
    {
      paramList = new kn();
      paramList.KOG.addAll((Collection)localLinkedList);
      paramb.invoke(paramList);
      AppMethodBeat.o(228657);
      return;
    }
    paramList = new km();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (y.b)((Iterator)localObject1).next();
      paramList.KOE.addAll((Collection)b((y.b)localObject2));
      paramList.scene = paramInt;
      paramList.KOF = paramacc;
    }
    new g(paramList).aYI().j((com.tencent.mm.vending.c.a)new d(localLinkedList, paramb, paramq));
    AppMethodBeat.o(228657);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"buildBasicItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<bml>
  {
    b(y.b paramb)
    {
      super();
    }
    
    public final bml bNy()
    {
      AppMethodBeat.i(180533);
      bml localbml = new bml();
      v localv = v.mTG;
      localbml.LVf = v.c(this.mTK);
      localbml.LVh = this.mTK.mUu;
      if (this.mTK.mUx) {
        localbml.LVi = true;
      }
      localbml.KXD = this.mTK.appVersion;
      o.a(localbml);
      AppMethodBeat.o(180533);
      return localbml;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class c
    extends kotlin.g.b.q
    implements b<bmm[], x>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(LinkedList paramLinkedList, b paramb, kotlin.g.a.q paramq) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(b paramb, y.b paramb1, kotlin.g.a.q paramq) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements b<byy, String>
  {
    public static final f mTN;
    
    static
    {
      AppMethodBeat.i(180541);
      mTN = new f();
      AppMethodBeat.o(180541);
    }
    
    f()
    {
      super();
    }
    
    public static String a(byy parambyy)
    {
      AppMethodBeat.i(180540);
      p.h(parambyy, "$this$info");
      parambyy = "GetWxaAppCDNDownloadUrlRequest(appId:" + parambyy.dNI + " version:" + parambyy.KXD + " moduleName:" + parambyy.MbW + " pacakgeType:" + parambyy.MbZ + " scene:" + parambyy.scene + ')';
      AppMethodBeat.o(180540);
      return parambyy;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"makeReqItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<bml>
  {
    g(com.tencent.mm.plugin.appbrand.appcache.h paramh)
    {
      super();
    }
    
    public final bml bNy()
    {
      AppMethodBeat.i(228654);
      bml localbml = new bml();
      localbml.LVf = new doo();
      localbml.LVf.dNI = this.mTO.bvg().dNI;
      localbml.KXD = this.mTO.bvg().KXD;
      localbml.LVf.MbZ = this.mTO.bvg().MbZ;
      localbml.LVf.MbW = this.mTO.bvg().MbW;
      localbml.LVh = 0;
      AppMethodBeat.o(228654);
      return localbml;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(com.tencent.mm.plugin.appbrand.appcache.h paramh) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoRequest;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements b<bwb, String>
  {
    public static final i mTP;
    
    static
    {
      AppMethodBeat.i(180545);
      mTP = new i();
      AppMethodBeat.o(180545);
    }
    
    i()
    {
      super();
    }
    
    public static String a(bwb parambwb)
    {
      AppMethodBeat.i(180544);
      p.h(parambwb, "$this$info");
      parambwb = "GetTestCodeDownloadInfoRequest(appId:" + parambwb.dNI + " versionType:" + parambwb.Lcr + " moduleName:" + parambwb.MbW + " packageType:" + parambwb.MbZ + ')';
      AppMethodBeat.o(180544);
      return parambwb;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class j<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    j(i parami) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.v
 * JD-Core Version:    0.7.0.1
 */