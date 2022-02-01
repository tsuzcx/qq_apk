package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.g;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.protocal.protobuf.jj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.a.b;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "mPreGetDownloadUrlResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "addPreGetDownloadUrlResult", "", "map", "", "removePreGetDownloadUrlResult", "request", "waitForBatchGetDownloadUrl", "inRequestList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "waitForDownloadUrl", "wormholeForLegacyReleaseCode", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "cgi", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "wormholeForLegacyTestCode", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetTestCodeDownloadInfo;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "RouterController", "plugin-appbrand-integration_release"})
public final class w
  implements z
{
  private static final ConcurrentHashMap<z.b, atf[]> kIQ;
  public static final w kIR;
  
  static
  {
    AppMethodBeat.i(180554);
    kIR = new w();
    kIQ = new ConcurrentHashMap();
    AppMethodBeat.o(180554);
  }
  
  public static void M(Map<z.b, atf[]> paramMap)
  {
    AppMethodBeat.i(180547);
    k.h(paramMap, "map");
    kIQ.putAll(paramMap);
    AppMethodBeat.o(180547);
  }
  
  public static final f<c.a<bbf>> a(i parami)
  {
    AppMethodBeat.i(180549);
    k.h(parami, "cgi");
    Object localObject1 = w.a.kIS;
    if (!w.a.a.bgy())
    {
      AppMethodBeat.o(180549);
      return null;
    }
    localObject1 = k.kJc;
    localObject1 = new StringBuilder("wormholeForLegacyTestCode with ");
    Object localObject2 = parami.aPh();
    k.g(localObject2, "cgi.request");
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", k.a((bbe)localObject2) + " intercepted");
    localObject1 = new ate();
    ((ate)localObject1).Dth = new ckp();
    ((ate)localObject1).Dth.dlB = parami.aPh().dlB;
    ((ate)localObject1).Dth.DyR = parami.aPh().DyR;
    ((ate)localObject1).Dth.DyU = parami.aPh().DyU;
    ((ate)localObject1).Dth.CLK = parami.aPh().CPu;
    ((ate)localObject1).Dtj = 0;
    ((ate)localObject1).Dtm = parami.aPh().DyT;
    localObject2 = new ji();
    ((ji)localObject2).CEF.add(localObject1);
    parami = new g((ji)localObject2).auK().b((com.tencent.mm.vending.c.a)new l(parami));
    AppMethodBeat.o(180549);
    return parami;
  }
  
  public static void a(z.b paramb)
  {
    AppMethodBeat.i(180548);
    k.h(paramb, "request");
    kIQ.remove(paramb);
    AppMethodBeat.o(180548);
  }
  
  public static final f<c.a<bdq>> b(h paramh)
  {
    AppMethodBeat.i(180550);
    k.h(paramh, "cgi");
    Object localObject1 = w.a.kIS;
    if (!w.a.a.bgy())
    {
      AppMethodBeat.o(180550);
      return null;
    }
    localObject1 = h.kJa;
    localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
    Object localObject2 = paramh.aPf();
    k.g(localObject2, "cgi.request");
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", h.a((bdp)localObject2) + " intercepted");
    localObject2 = new i(paramh);
    localObject1 = new ji();
    ((ji)localObject1).CEF.add(((i)localObject2).bgz());
    LinkedList localLinkedList = ((ji)localObject1).CEF;
    ate localate = ((i)localObject2).bgz();
    localate.Dtl = true;
    localLinkedList.add(localate);
    ((ji)localObject1).scene = paramh.aPf().scene;
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "CgiBatchGetPkgDownloadInfo scene:%d", new Object[] { Integer.valueOf(((ji)localObject1).scene) });
    if (paramh.aPf().DAL > 0)
    {
      localLinkedList = ((ji)localObject1).CEF;
      localObject2 = ((i)localObject2).bgz();
      ((ate)localObject2).Dti = new bmj();
      ((ate)localObject2).Dti.CLL = paramh.aPf().DAL;
      localLinkedList.add(localObject2);
    }
    paramh = new g((ji)localObject1).auK().b((com.tencent.mm.vending.c.a)new j(paramh));
    AppMethodBeat.o(180550);
    return paramh;
  }
  
  private static ckp b(z.b paramb)
  {
    AppMethodBeat.i(196362);
    ckp localckp = new ckp();
    localckp.dlB = paramb.appId;
    int i = paramb.deP;
    int[] arrayOfInt = com.tencent.mm.cp.a.Igv;
    k.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (d.a.e.contains(arrayOfInt, i)) {
      localckp.DyR = null;
    }
    for (;;)
    {
      localckp.DyU = paramb.deP;
      localckp.CLK = paramb.gXn;
      AppMethodBeat.o(196362);
      return localckp;
      arrayOfInt = com.tencent.mm.cp.a.Igu;
      k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (d.a.e.contains(arrayOfInt, i)) {
        localckp.DyR = null;
      } else {
        localckp.DyR = paramb.chK;
      }
    }
  }
  
  private static List<ate> c(z.b paramb)
  {
    AppMethodBeat.i(180553);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new b(paramb);
    ate localate = ((b)localObject).bgz();
    localate.Dti = null;
    localate.Dtl = false;
    localLinkedList.add(localate);
    localate = ((b)localObject).bgz();
    localate.Dti = null;
    localate.Dtl = true;
    localLinkedList.add(localate);
    if (paramb.kIJ > 0)
    {
      localObject = ((b)localObject).bgz();
      ((ate)localObject).Dti = new bmj();
      ((ate)localObject).Dti.CLL = paramb.kIJ;
      ((ate)localObject).Dti.DAQ = paramb.kJH;
      ((ate)localObject).Dtl = false;
      localLinkedList.add(localObject);
    }
    paramb = (List)localLinkedList;
    AppMethodBeat.o(180553);
    return paramb;
  }
  
  public final void a(final z.b paramb, final b<? super atf[], y> paramb1, final q<? super Integer, ? super Integer, ? super String, y> paramq, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(180551);
    k.h(paramb, "request");
    k.h(paramb1, "onSuccess");
    k.h(paramq, "onError");
    Object localObject3 = (atf[])kIQ.remove(paramb);
    if (localObject3 != null)
    {
      ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, intercepted by PreGet with ".concat(String.valueOf(paramb)));
      k.g(localObject3, "preGetResp");
      if (d.a.e.f((Object[])localObject3, 0) != null)
      {
        paramb1.aA(localObject3);
        AppMethodBeat.o(180551);
        return;
      }
    }
    if (!paramb.kJI)
    {
      localObject3 = com.tencent.mm.cp.a.Igt;
      k.g(localObject3, "ConstantsWxaPackageProto…CGI_SUPPORT_PACKAGE_TYPES");
      if (d.a.e.contains((int[])localObject3, paramb.deP))
      {
        localObject3 = w.a.kIS;
        if (!w.a.a.bgy()) {
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
      localObject1 = new ji();
      ((ji)localObject1).CEF.addAll((Collection)c(paramb));
      new g((ji)localObject1).auK().j((com.tencent.mm.vending.c.a)new e(paramb1, paramb, paramq));
      AppMethodBeat.o(180551);
      return;
    }
    if (j.a.qD(paramb.gXn))
    {
      localObject1 = com.tencent.mm.plugin.appbrand.app.j.aOK();
      if (localObject1 != null)
      {
        localObject1 = ((bf)localObject1).a(new ab(paramb.appId, paramb.chK, paramb.deP).toString(), paramb.aAS, paramb.gXn, new String[] { "versionMd5" });
        if (localObject1 == null) {}
      }
      for (localObject1 = ((bb)localObject1).field_versionMd5;; localObject1 = null)
      {
        localObject2 = new bdp();
        ((bdp)localObject2).dlB = paramb.appId;
        ((bdp)localObject2).CLL = paramb.aAS;
        ((bdp)localObject2).DyU = paramb.deP;
        ((bdp)localObject2).DAL = paramb.kIJ;
        if (((bdp)localObject2).DyU != 0)
        {
          localObject3 = com.tencent.mm.cp.a.Igu;
          k.g(localObject3, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
          if (!d.a.e.contains((int[])localObject3, ((bdp)localObject2).DyU)) {
            ((bdp)localObject2).DyR = paramb.chK;
          }
        }
        ((bdp)localObject2).scene = paramInt;
        new h((bdp)localObject2).auK().j((com.tencent.mm.vending.c.a)new f(paramq, paramb1, (String)localObject1, paramb));
        AppMethodBeat.o(180551);
        return;
      }
    }
    if (paramb.deP == 0)
    {
      ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode packageType=0, use record, request=".concat(String.valueOf(paramb)));
      localObject2 = com.tencent.mm.plugin.appbrand.app.j.aOK();
      if (localObject2 != null) {
        localObject1 = ((bf)localObject2).a(new ab(paramb.appId, paramb.chK, paramb.deP).toString(), 0, paramb.gXn, new String[] { "versionMd5", "downloadURL" });
      }
      if (localObject1 == null)
      {
        paramq.d(Integer.valueOf(-1), Integer.valueOf(-1), aj.getResources().getString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.qC(paramb.gXn) }));
        AppMethodBeat.o(180551);
        return;
      }
      paramq = new atf[3];
      localObject2 = new atf();
      ((atf)localObject2).url = ((bb)localObject1).field_downloadURL;
      ((atf)localObject2).md5 = ((bb)localObject1).field_versionMd5;
      ((atf)localObject2).Dto = false;
      ((atf)localObject2).Dth = b(paramb);
      paramq[0] = localObject2;
      paramb1.aA(paramq);
      AppMethodBeat.o(180551);
      return;
    }
    ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode with request=".concat(String.valueOf(paramb)));
    localObject3 = com.tencent.mm.plugin.appbrand.app.j.aOK();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((bf)localObject3).a(new ab(paramb.appId, paramb.chK, paramb.deP).toString(), 0, paramb.gXn, new String[] { "versionMd5" });
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((bb)localObject3).field_versionMd5;
      }
    }
    new i(paramb.appId, paramb.chK, (String)localObject1, paramb.gXn, paramb.deP).auK().j((com.tencent.mm.vending.c.a)new g(paramq, paramb, paramb1, (String)localObject1));
    AppMethodBeat.o(180551);
  }
  
  public final void a(List<z.b> paramList, final b<? super jj, y> paramb, final q<? super Integer, ? super Integer, ? super String, y> paramq, int paramInt)
  {
    AppMethodBeat.i(180552);
    k.h(paramList, "inRequestList");
    k.h(paramb, "onSuccess");
    k.h(paramq, "onError");
    if (paramList.size() == 1)
    {
      ad.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, use single routine instead, with " + (z.b)d.a.j.iy(paramList));
      a((z.b)paramList.get(0), (b)new c(paramb), paramq, paramInt);
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
      localObject3 = (atf[])kIQ.remove(localb);
      if (localObject3 != null)
      {
        k.g(localObject3, "preGetResp");
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
    paramList = new ji();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (z.b)((Iterator)localObject1).next();
      paramList.CEF.addAll((Collection)c((z.b)localObject2));
    }
    new g(paramList).auK().j((com.tencent.mm.vending.c.a)new d(localLinkedList, paramb, paramq));
    AppMethodBeat.o(180552);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"buildBasicItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<ate>
  {
    b(z.b paramb)
    {
      super();
    }
    
    public final ate bgz()
    {
      AppMethodBeat.i(180533);
      ate localate = new ate();
      w localw = w.kIR;
      localate.Dth = w.d(this.kIV);
      localate.Dtj = this.kIV.kJG;
      if (this.kIV.kJI) {
        localate.Dtk = true;
      }
      for (;;)
      {
        o.a(localate);
        AppMethodBeat.o(180533);
        return localate;
        localate.CLL = this.kIV.aAS;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class c
    extends d.g.b.l
    implements b<atf[], y>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(LinkedList paramLinkedList, b paramb, q paramq) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(b paramb, z.b paramb1, q paramq) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(q paramq, b paramb, String paramString, z.b paramb1) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(q paramq, z.b paramb, b paramb1, String paramString) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "invoke"})
  static final class h
    extends d.g.b.l
    implements b<bdp, String>
  {
    public static final h kJa;
    
    static
    {
      AppMethodBeat.i(180541);
      kJa = new h();
      AppMethodBeat.o(180541);
    }
    
    h()
    {
      super();
    }
    
    public static String a(bdp parambdp)
    {
      AppMethodBeat.i(180540);
      k.h(parambdp, "$this$info");
      parambdp = "GetWxaAppCDNDownloadUrlRequest(appId:" + parambdp.dlB + " version:" + parambdp.CLL + " moduleName:" + parambdp.DyR + " pacakgeType:" + parambdp.DyU + " scene:" + parambdp.scene + ')';
      AppMethodBeat.o(180540);
      return parambdp;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"makeReqItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<ate>
  {
    i(h paramh)
    {
      super();
    }
    
    public final ate bgz()
    {
      AppMethodBeat.i(196360);
      ate localate = new ate();
      localate.Dth = new ckp();
      localate.Dth.dlB = this.kJb.aPf().dlB;
      localate.CLL = this.kJb.aPf().CLL;
      localate.Dth.DyU = this.kJb.aPf().DyU;
      localate.Dth.DyR = this.kJb.aPf().DyR;
      localate.Dtj = 0;
      AppMethodBeat.o(196360);
      return localate;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class j<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    j(h paramh) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"info", "", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoRequest;", "invoke"})
  static final class k
    extends d.g.b.l
    implements b<bbe, String>
  {
    public static final k kJc;
    
    static
    {
      AppMethodBeat.i(180545);
      kJc = new k();
      AppMethodBeat.o(180545);
    }
    
    k()
    {
      super();
    }
    
    public static String a(bbe parambbe)
    {
      AppMethodBeat.i(180544);
      k.h(parambbe, "$this$info");
      parambbe = "GetTestCodeDownloadInfoRequest(appId:" + parambbe.dlB + " versionType:" + parambbe.CPu + " moduleName:" + parambbe.DyR + " packageType:" + parambbe.DyU + ')';
      AppMethodBeat.o(180544);
      return parambbe;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
  static final class l<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    l(i parami) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w
 * JD-Core Version:    0.7.0.1
 */