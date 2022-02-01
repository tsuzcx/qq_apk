package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.ab.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.protocal.protobuf.djr;
import com.tencent.mm.protocal.protobuf.erm;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "mPreGetDownloadUrlResults", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "addPreGetDownloadUrlResult", "", "map", "", "removePreGetDownloadUrlResult", "request", "waitForBatchGetDownloadUrl", "inRequestList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "waitForDownloadUrl", "wormholeForLegacyReleaseCode", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlResponse;", "cgi", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "wormholeForLegacyTestCode", "Lcom/tencent/mm/protocal/protobuf/GetTestCodeDownloadInfoResponse;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetTestCodeDownloadInfo;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "CodeDownloadErrCode", "RouterController", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  implements z
{
  public static final w sZB;
  private static final ConcurrentHashMap<z.a, ciq[]> sZC;
  
  static
  {
    AppMethodBeat.i(180554);
    sZB = new w();
    sZC = new ConcurrentHashMap();
    AppMethodBeat.o(180554);
  }
  
  public static void W(Map<z.a, ciq[]> paramMap)
  {
    AppMethodBeat.i(180547);
    s.u(paramMap, "map");
    sZC.putAll(paramMap);
    AppMethodBeat.o(180547);
  }
  
  private static final b.a a(i parami, b.a parama)
  {
    int j = -1;
    AppMethodBeat.i(320855);
    s.u(parami, "$cgi");
    if (!com.tencent.mm.plugin.appbrand.s.a.d(parama))
    {
      int i;
      if (parama == null)
      {
        i = -1;
        if (parama != null) {
          break label67;
        }
        label30:
        if (parama != null) {
          break label75;
        }
        parami = null;
        label36:
        if (parama != null) {
          break label83;
        }
      }
      label67:
      label75:
      label83:
      for (parama = null;; parama = parama.otu)
      {
        parami = b.a.a(i, j, parami, null, null, parama);
        AppMethodBeat.o(320855);
        return parami;
        i = parama.errType;
        break;
        j = parama.errCode;
        break label30;
        parami = parama.errMsg;
        break label36;
      }
    }
    Object localObject1 = ((kz)parama.ott).YMS;
    s.s(localObject1, "it.resp.resp_list");
    if ((ciq)p.oL((List)localObject1) == null)
    {
      parama = new StringBuilder("wormholeForLegacyReleaseCode with ");
      localObject1 = parami.cfL();
      s.s(localObject1, "cgi.request");
      Log.e("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", a((cwt)localObject1) + " useNewCgi=TRUE, get NULL respItem");
      parami = b.a.a(-1, -1, null, null, null, (com.tencent.mm.am.b)parami);
      AppMethodBeat.o(320855);
      return parami;
    }
    localObject1 = new cwu();
    Object localObject2 = new StringBuilder("wormholeForLegacyReleaseCode with ");
    Object localObject3 = parami.cfL();
    s.s(localObject3, "cgi.request");
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", a((cwt)localObject3) + ", get resp_list.size:" + ((kz)parama.ott).YMS.size());
    localObject2 = ((kz)parama.ott).YMS;
    s.s(localObject2, "it.resp.resp_list");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ciq)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder("wormholeForLegacyReleaseCode with ");
      cwt localcwt = parami.cfL();
      s.s(localcwt, "cgi.request");
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", a(localcwt) + ", get item[ errcode:" + ((ciq)localObject3).hGE + ", md5:" + ((ciq)localObject3).md5 + ", is_patch:" + ((ciq)localObject3).aarj + ", is_zstd:" + ((ciq)localObject3).aark + ", url:" + ((ciq)localObject3).url + " ]");
      ((cwu)localObject1).aaqo = ((ciq)localObject3).aaqo;
      if (((ciq)localObject3).aark) {
        ((cwu)localObject1).aaBY = ((ciq)localObject3).url;
      } else if (((ciq)localObject3).aarj) {
        ((cwu)localObject1).hOQ = ((ciq)localObject3).url;
      } else {
        ((cwu)localObject1).url = ((ciq)localObject3).url;
      }
    }
    parami = b.a.a(parama.errType, parama.errCode, parama.errMsg, (esc)localObject1, null, (com.tencent.mm.am.b)parami);
    AppMethodBeat.o(320855);
    return parami;
  }
  
  private static final b.a a(j paramj, b.a parama)
  {
    int j = -1;
    AppMethodBeat.i(320842);
    s.u(paramj, "$cgi");
    if (!com.tencent.mm.plugin.appbrand.s.a.d(parama))
    {
      int i;
      if (parama == null)
      {
        i = -1;
        if (parama != null) {
          break label69;
        }
        label31:
        if (parama != null) {
          break label77;
        }
        paramj = null;
        label37:
        if (parama != null) {
          break label85;
        }
      }
      label69:
      label77:
      label85:
      for (parama = null;; parama = parama.otu)
      {
        paramj = b.a.a(i, j, paramj, null, null, parama);
        AppMethodBeat.o(320842);
        return paramj;
        i = parama.errType;
        break;
        j = parama.errCode;
        break label31;
        paramj = parama.errMsg;
        break label37;
      }
    }
    Object localObject = ((kz)parama.ott).YMS;
    s.s(localObject, "it.resp.resp_list");
    localObject = (ciq)p.oL((List)localObject);
    if (localObject == null)
    {
      parama = new StringBuilder("wormholeForLegacyTestCode with ");
      localObject = paramj.cfN();
      s.s(localObject, "cgi.request");
      Log.e("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", a((ctn)localObject) + " useNewCgi=TRUE, get NULL respItem");
      paramj = b.a.a(-1, -1, null, null, null, (com.tencent.mm.am.b)paramj);
      AppMethodBeat.o(320842);
      return paramj;
    }
    cto localcto = new cto();
    localcto.lwO = ((ciq)localObject).url;
    localcto.error_code = ((ciq)localObject).hGE;
    paramj = b.a.a(parama.errType, parama.errCode, null, (esc)localcto, null, (com.tencent.mm.am.b)paramj);
    AppMethodBeat.o(320842);
    return paramj;
  }
  
  public static final f<b.a<cto>> a(j paramj)
  {
    AppMethodBeat.i(180549);
    s.u(paramj, "cgi");
    Object localObject1 = a.sZD;
    if (!w.a.a.cAd())
    {
      AppMethodBeat.o(180549);
      return null;
    }
    localObject1 = new StringBuilder("wormholeForLegacyTestCode with ");
    Object localObject2 = paramj.cfN();
    s.s(localObject2, "cgi.request");
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", a((ctn)localObject2) + " intercepted");
    localObject2 = new cip();
    ((cip)localObject2).aard = new erm();
    ((cip)localObject2).aard.appid = paramj.cfN().appid;
    ((cip)localObject2).aard.aazm = paramj.cfN().aazm;
    ((cip)localObject2).aard.aazp = paramj.cfN().aazp;
    ((cip)localObject2).aard.Tqb = paramj.cfN().Zby;
    ((cip)localObject2).aarf = 0;
    ((cip)localObject2).aari = paramj.cfN().aazo;
    localObject1 = new ky();
    ((ky)localObject1).YMQ.add(localObject2);
    localObject2 = new aeo();
    ((aeo)localObject2).ZmB = 1;
    ah localah = ah.aiuX;
    ((ky)localObject1).YMR = ((aeo)localObject2);
    localObject2 = ah.aiuX;
    paramj = new com.tencent.mm.plugin.appbrand.appcache.h((ky)localObject1).bFJ().b(new w..ExternalSyntheticLambda1(paramj));
    AppMethodBeat.o(180549);
    return paramj;
  }
  
  private static final String a(ctn paramctn)
  {
    AppMethodBeat.i(320835);
    paramctn = "GetTestCodeDownloadInfoRequest(appId:" + paramctn.appid + " versionType:" + paramctn.Zby + " moduleName:" + paramctn.aazm + " packageType:" + paramctn.aazp + ')';
    AppMethodBeat.o(320835);
    return paramctn;
  }
  
  private static final String a(cwt paramcwt)
  {
    AppMethodBeat.i(320846);
    paramcwt = "GetWxaAppCDNDownloadUrlRequest(appId:" + paramcwt.appid + " version:" + paramcwt.YWM + " moduleName:" + paramcwt.aazm + " pacakgeType:" + paramcwt.aazp + " scene:" + paramcwt.scene + ')';
    AppMethodBeat.o(320846);
    return paramcwt;
  }
  
  private static final ah a(LinkedList paramLinkedList, kotlin.g.a.b paramb, q paramq, b.a parama)
  {
    int j = -1;
    AppMethodBeat.i(320874);
    s.u(paramLinkedList, "$preGetRespItemList");
    s.u(paramb, "$onSuccess");
    s.u(paramq, "$onError");
    if (com.tencent.mm.plugin.appbrand.s.a.d(parama))
    {
      ((kz)parama.ott).YMS.addAll((Collection)paramLinkedList);
      paramLinkedList = parama.ott;
      s.s(paramLinkedList, "it.resp");
      paramb.invoke(paramLinkedList);
      paramLinkedList = ah.aiuX;
      AppMethodBeat.o(320874);
      return paramLinkedList;
    }
    int i;
    if (parama == null)
    {
      i = -1;
      label94:
      if (parama != null) {
        break label134;
      }
      label98:
      if (parama != null) {
        break label143;
      }
    }
    label134:
    label143:
    for (paramLinkedList = null;; paramLinkedList = parama.errMsg)
    {
      paramq.invoke(Integer.valueOf(i), Integer.valueOf(j), paramLinkedList);
      break;
      i = parama.errType;
      break label94;
      j = parama.errCode;
      break label98;
    }
  }
  
  private static final ah a(kotlin.g.a.b paramb, z.a parama, q paramq, b.a parama1)
  {
    int j = -1;
    AppMethodBeat.i(320858);
    s.u(paramb, "$onSuccess");
    s.u(parama, "$request");
    s.u(paramq, "$onError");
    if (com.tencent.mm.plugin.appbrand.s.a.d(parama1))
    {
      parama = o.a((kz)parama1.ott, parama);
      s.checkNotNull(parama);
      paramb.invoke(parama);
      paramb = ah.aiuX;
      AppMethodBeat.o(320858);
      return paramb;
    }
    int i;
    if (parama1 == null)
    {
      i = -1;
      label80:
      if (parama1 != null) {
        break label120;
      }
      label84:
      if (parama1 != null) {
        break label129;
      }
    }
    label129:
    for (paramb = null;; paramb = parama1.errMsg)
    {
      paramq.invoke(Integer.valueOf(i), Integer.valueOf(j), paramb);
      break;
      i = parama1.errType;
      break label80;
      label120:
      j = parama1.errCode;
      break label84;
    }
  }
  
  private static final ah a(q paramq, z.a parama, kotlin.g.a.b paramb, String paramString, b.a parama1)
  {
    int j = -1;
    AppMethodBeat.i(320868);
    s.u(paramq, "$onError");
    s.u(parama, "$request");
    s.u(paramb, "$onSuccess");
    int i;
    if (!com.tencent.mm.plugin.appbrand.s.a.d(parama1)) {
      if (parama1 == null)
      {
        i = -1;
        if (parama1 != null) {
          break label98;
        }
        label51:
        if (parama1 != null) {
          break label108;
        }
        parama = null;
        label58:
        paramq.invoke(Integer.valueOf(i), Integer.valueOf(j), parama);
      }
    }
    for (;;)
    {
      paramq = ah.aiuX;
      AppMethodBeat.o(320868);
      return paramq;
      i = parama1.errType;
      break;
      label98:
      j = parama1.errCode;
      break label51;
      label108:
      parama = parama1.errMsg;
      break label58;
      parama1 = (cto)parama1.ott;
      if (parama1.error_code != 0)
      {
        Log.e("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForDownloadUrl, try getTestCode, resp.error_code=" + parama1.error_code + ", resp.error_msg=" + parama1.error_msg + " with request=" + parama);
        paramq.invoke(Integer.valueOf(0), Integer.valueOf(parama1.error_code), parama1.error_msg);
      }
      else
      {
        paramq = new ciq[3];
        ciq localciq = new ciq();
        localciq.url = parama1.lwO;
        localciq.md5 = paramString;
        localciq.aark = false;
        localciq.aard = b(parama);
        parama = ah.aiuX;
        paramq[0] = localciq;
        parama = ah.aiuX;
        paramb.invoke(paramq);
      }
    }
  }
  
  private static final ah a(q paramq, kotlin.g.a.b paramb, String paramString, z.a parama, b.a parama1)
  {
    int j = -1;
    AppMethodBeat.i(320864);
    s.u(paramq, "$onError");
    s.u(paramb, "$onSuccess");
    s.u(parama, "$request");
    if (!com.tencent.mm.plugin.appbrand.s.a.d(parama1))
    {
      if (parama1 == null)
      {
        i = -1;
        if (parama1 != null) {
          break label98;
        }
        label51:
        if (parama1 != null) {
          break label108;
        }
      }
      label98:
      label108:
      for (paramb = null;; paramb = parama1.errMsg)
      {
        paramq.invoke(Integer.valueOf(i), Integer.valueOf(j), paramb);
        paramq = ah.aiuX;
        AppMethodBeat.o(320864);
        return paramq;
        i = parama1.errType;
        break;
        j = parama1.errCode;
        break label51;
      }
    }
    parama1 = (cwu)parama1.ott;
    paramq = new ciq[3];
    Object localObject = new ciq();
    ((ciq)localObject).url = parama1.url;
    ((ciq)localObject).md5 = paramString;
    ((ciq)localObject).aaqo = parama1.aaqo;
    ((ciq)localObject).YWM = parama.appVersion;
    ((ciq)localObject).aarj = false;
    ((ciq)localObject).aark = false;
    ((ciq)localObject).aard = b(parama);
    ah localah = ah.aiuX;
    paramq[0] = localObject;
    localObject = (CharSequence)parama1.aaBY;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      label235:
      if (i == 0)
      {
        localObject = new ciq();
        ((ciq)localObject).url = parama1.aaBY;
        ((ciq)localObject).md5 = paramString;
        ((ciq)localObject).aaqo = parama1.aaqo;
        ((ciq)localObject).YWM = parama.appVersion;
        ((ciq)localObject).aarj = false;
        ((ciq)localObject).aark = true;
        ((ciq)localObject).aard = b(parama);
        localah = ah.aiuX;
        paramq[1] = localObject;
      }
      localObject = (CharSequence)parama1.hOQ;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label443;
      }
    }
    label443:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = new ciq();
        ((ciq)localObject).url = parama1.hOQ;
        ((ciq)localObject).md5 = paramString;
        ((ciq)localObject).aaqo = parama1.aaqo;
        ((ciq)localObject).YWM = parama.appVersion;
        ((ciq)localObject).aarj = true;
        ((ciq)localObject).aark = false;
        ((ciq)localObject).aard = b(parama);
        paramString = ah.aiuX;
        paramq[2] = localObject;
      }
      paramString = ah.aiuX;
      paramb.invoke(paramq);
      break;
      i = 0;
      break label235;
    }
  }
  
  public static void a(z.a parama)
  {
    AppMethodBeat.i(180548);
    s.u(parama, "request");
    sZC.remove(parama);
    AppMethodBeat.o(180548);
  }
  
  public static final f<b.a<cwu>> b(i parami)
  {
    Object localObject1 = null;
    AppMethodBeat.i(180550);
    s.u(parami, "cgi");
    Object localObject2 = a.sZD;
    if (!w.a.a.cAd())
    {
      AppMethodBeat.o(180550);
      return null;
    }
    localObject2 = new StringBuilder("wormholeForLegacyReleaseCode with ");
    Object localObject3 = parami.cfL();
    s.s(localObject3, "cgi.request");
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", a((cwt)localObject3) + " intercepted");
    localObject2 = new ky();
    ((ky)localObject2).YMQ.add(c(parami));
    localObject3 = ((ky)localObject2).YMQ;
    Object localObject4 = c(parami);
    ((cip)localObject4).aarh = true;
    ah localah = ah.aiuX;
    ((LinkedList)localObject3).add(localObject4);
    ((ky)localObject2).scene = parami.cfL().scene;
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "CgiBatchGetPkgDownloadInfo scene:%d", new Object[] { Integer.valueOf(((ky)localObject2).scene) });
    int i;
    if (parami.cfL().aaBP > 0)
    {
      localObject3 = n.cfm().b(new af(parami.cfL().appid, parami.cfL().aazm, parami.cfL().aazp).toString(), parami.cfL().aaBP, 0, new String[] { "pkgPath" });
      if (localObject3 != null) {
        break label409;
      }
      if (!y.ZC((String)localObject1)) {
        break label418;
      }
      i = WxaPkg.Vo((String)localObject1);
      label247:
      localObject1 = new StringBuilder("wormholeForLegacyReleaseCode with ");
      localObject3 = parami.cfL();
      s.s(localObject3, "cgi.request");
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", a((cwt)localObject3) + ", intercepted, oldPkg.innerVersion=" + i);
      if (i != 0) {
        break label423;
      }
      localObject1 = ((ky)localObject2).YMQ;
      localObject3 = c(parami);
      ((cip)localObject3).aare = new djr();
      ((cip)localObject3).aare.YWM = parami.cfL().aaBP;
      localObject4 = ah.aiuX;
      ((LinkedList)localObject1).add(localObject3);
    }
    for (;;)
    {
      localObject1 = new aeo();
      ((aeo)localObject1).ZmB = 1;
      localObject3 = ah.aiuX;
      ((ky)localObject2).YMR = ((aeo)localObject1);
      localObject1 = ah.aiuX;
      parami = new com.tencent.mm.plugin.appbrand.appcache.h((ky)localObject2).bFJ().b(new w..ExternalSyntheticLambda0(parami));
      AppMethodBeat.o(180550);
      return parami;
      label409:
      localObject1 = ((bh)localObject3).field_pkgPath;
      break;
      label418:
      i = -1;
      break label247;
      label423:
      com.tencent.mm.plugin.report.service.h.OAn.kJ(697, 20);
    }
  }
  
  private static erm b(z.a parama)
  {
    AppMethodBeat.i(320825);
    erm localerm = new erm();
    localerm.appid = parama.appId;
    int i = parama.hDq;
    int[] arrayOfInt = com.tencent.mm.cq.a.agWN;
    s.s(arrayOfInt, "WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES");
    if (k.contains(arrayOfInt, i)) {
      localerm.aazm = null;
    }
    for (;;)
    {
      localerm.aazp = parama.hDq;
      localerm.Tqb = parama.euz;
      AppMethodBeat.o(320825);
      return localerm;
      arrayOfInt = com.tencent.mm.cq.a.agWM;
      s.s(arrayOfInt, "PLUGINCODE_PACKAGE_TYPES");
      if (k.contains(arrayOfInt, i)) {
        localerm.aazm = null;
      } else {
        localerm.aazm = parama.esT;
      }
    }
  }
  
  private static final cip c(i parami)
  {
    AppMethodBeat.i(320852);
    cip localcip = new cip();
    localcip.aard = new erm();
    localcip.aard.appid = parami.cfL().appid;
    localcip.YWM = parami.cfL().YWM;
    localcip.aard.aazp = parami.cfL().aazp;
    localcip.aard.aazm = parami.cfL().aazm;
    localcip.aarf = 0;
    AppMethodBeat.o(320852);
    return localcip;
  }
  
  private static List<cip> c(z.a parama)
  {
    AppMethodBeat.i(180553);
    LinkedList localLinkedList = new LinkedList();
    cip localcip = d(parama);
    localcip.aare = null;
    localcip.aarh = false;
    ah localah = ah.aiuX;
    localLinkedList.add(localcip);
    if (k.a.vK(parama.euz))
    {
      parama = (List)localLinkedList;
      AppMethodBeat.o(180553);
      return parama;
    }
    localcip = d(parama);
    localcip.aare = null;
    localcip.aarh = true;
    localah = ah.aiuX;
    localLinkedList.add(localcip);
    if (parama.tai > 0)
    {
      localcip = d(parama);
      localcip.aare = new djr();
      localcip.aare.YWM = parama.tai;
      localcip.aare.aaBU = parama.taj;
      localcip.aarh = false;
      parama = ah.aiuX;
      localLinkedList.add(localcip);
    }
    parama = (List)localLinkedList;
    AppMethodBeat.o(180553);
    return parama;
  }
  
  private static final cip d(z.a parama)
  {
    AppMethodBeat.i(320878);
    cip localcip = new cip();
    localcip.aard = b(parama);
    localcip.aarf = parama.tah;
    if (parama.tak) {
      localcip.aarg = true;
    }
    localcip.YWM = parama.appVersion;
    CharSequence localCharSequence = (CharSequence)parama.qGf;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localcip.xlz = parama.qGf;
      }
      o.a(localcip);
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "request.appId:%s,packageType:%d,version_desc:%s,uin:%d,versionType:%d", new Object[] { localcip.aard.appid, Integer.valueOf(localcip.aard.aazp), localcip.xlz, Integer.valueOf(localcip.aari), Integer.valueOf(localcip.aard.Tqb) });
      AppMethodBeat.o(320878);
      return localcip;
    }
  }
  
  public final void a(z.a parama, kotlin.g.a.b<? super ciq[], ah> paramb, q<? super Integer, ? super Integer, ? super String, ah> paramq, int paramInt, aeo paramaeo)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(320919);
    s.u(parama, "request");
    s.u(paramb, "onSuccess");
    s.u(paramq, "onError");
    s.u(paramaeo, "cgiCommRequestSource");
    Object localObject3 = (ciq[])sZC.remove(parama);
    if (localObject3 != null)
    {
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", s.X("waitForDownloadUrl, intercepted by PreGet with ", parama));
      if (k.m((Object[])localObject3, 0) != null)
      {
        paramb.invoke(localObject3);
        AppMethodBeat.o(320919);
        return;
      }
    }
    if (!parama.tak)
    {
      localObject3 = com.tencent.mm.cq.a.agWL;
      s.s(localObject3, "LEGACY_CGI_SUPPORT_PACKAGE_TYPES");
      if (k.contains((int[])localObject3, parama.hDq))
      {
        localObject3 = a.sZD;
        if (!w.a.a.cAd()) {
          break label250;
        }
      }
    }
    label250:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "goNewCgi: %b,appId: %s", new Object[] { Boolean.valueOf(bool), parama.appId });
      if (!bool) {
        break;
      }
      localObject1 = new ky();
      ((ky)localObject1).YMQ.addAll((Collection)c(parama));
      ((ky)localObject1).scene = paramInt;
      ((ky)localObject1).YMR = paramaeo;
      paramaeo = ah.aiuX;
      new com.tencent.mm.plugin.appbrand.appcache.h((ky)localObject1).bFJ().j(new w..ExternalSyntheticLambda3(paramb, parama, paramq));
      AppMethodBeat.o(320919);
      return;
    }
    if (k.a.zn(parama.euz))
    {
      paramaeo = n.cfm();
      if (paramaeo == null) {
        paramaeo = null;
      }
      for (;;)
      {
        localObject1 = new cwt();
        ((cwt)localObject1).appid = parama.appId;
        ((cwt)localObject1).YWM = parama.appVersion;
        ((cwt)localObject1).aazp = parama.hDq;
        ((cwt)localObject1).aaBP = parama.tai;
        if (((cwt)localObject1).aazp != 0)
        {
          localObject2 = com.tencent.mm.cq.a.agWM;
          s.s(localObject2, "PLUGINCODE_PACKAGE_TYPES");
          if (!k.contains((int[])localObject2, ((cwt)localObject1).aazp)) {
            ((cwt)localObject1).aazm = parama.esT;
          }
        }
        ((cwt)localObject1).scene = paramInt;
        localObject2 = ah.aiuX;
        new i((cwt)localObject1).bFJ().j(new w..ExternalSyntheticLambda5(paramq, paramb, paramaeo, parama));
        AppMethodBeat.o(320919);
        return;
        paramaeo = paramaeo.b(new af(parama.appId, parama.esT, parama.hDq).toString(), parama.appVersion, parama.euz, new String[] { "versionMd5" });
        if (paramaeo == null) {
          paramaeo = null;
        } else {
          paramaeo = paramaeo.field_versionMd5;
        }
      }
    }
    if (parama.hDq == 0)
    {
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", s.X("waitForDownloadUrl, try getTestCode packageType=0, use record, request=", parama));
      paramaeo = n.cfm();
      if (paramaeo == null) {}
      for (paramaeo = (aeo)localObject2; paramaeo == null; paramaeo = paramaeo.b(new af(parama.appId, parama.esT, parama.hDq).toString(), 0, parama.euz, new String[] { "versionMd5", "downloadURL" }))
      {
        paramq.invoke(Integer.valueOf(-1), Integer.valueOf(-1), MMApplicationContext.getResources().getString(ba.i.app_brand_preparing_pkg_manifest_null, new Object[] { e.zm(parama.euz) }));
        AppMethodBeat.o(320919);
        return;
      }
      paramq = new ciq[3];
      localObject1 = new ciq();
      ((ciq)localObject1).url = paramaeo.field_downloadURL;
      ((ciq)localObject1).md5 = paramaeo.field_versionMd5;
      ((ciq)localObject1).aark = false;
      ((ciq)localObject1).aard = b(parama);
      parama = ah.aiuX;
      paramq[0] = localObject1;
      parama = ah.aiuX;
      paramb.invoke(paramq);
      AppMethodBeat.o(320919);
      return;
    }
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", s.X("waitForDownloadUrl, try getTestCode with request=", parama));
    paramaeo = n.cfm();
    if (paramaeo == null) {
      paramaeo = (aeo)localObject1;
    }
    for (;;)
    {
      new j(parama.appId, parama.esT, paramaeo, parama.euz, parama.hDq).bFJ().j(new w..ExternalSyntheticLambda4(paramq, parama, paramb, paramaeo));
      AppMethodBeat.o(320919);
      return;
      localObject2 = paramaeo.b(new af(parama.appId, parama.esT, parama.hDq).toString(), 0, parama.euz, new String[] { "versionMd5" });
      paramaeo = (aeo)localObject1;
      if (localObject2 != null) {
        paramaeo = ((bh)localObject2).field_versionMd5;
      }
    }
  }
  
  public final void a(List<z.a> paramList, kotlin.g.a.b<? super kz, ah> paramb, q<? super Integer, ? super Integer, ? super String, ah> paramq, int paramInt, aeo paramaeo)
  {
    AppMethodBeat.i(320927);
    s.u(paramList, "inRequestList");
    s.u(paramb, "onSuccess");
    s.u(paramq, "onError");
    s.u(paramaeo, "cgiCommRequestSource");
    if (paramList.size() == 1)
    {
      Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", s.X("waitForBatchGetDownloadUrl, use single routine instead, with ", p.oK(paramList)));
      a((z.a)paramList.get(0), (kotlin.g.a.b)new b(paramb), paramq, paramInt, paramaeo);
      AppMethodBeat.o(320927);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList((Collection)paramList);
    Object localObject2 = ((LinkedList)localObject1).iterator();
    s.s(localObject2, "realRequestList.iterator()");
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      s.s(localObject3, "iterator.next()");
      z.a locala = (z.a)localObject3;
      localObject3 = (ciq[])sZC.remove(locala);
      if ((localObject3 != null) && (k.m((Object[])localObject3, 0) != null))
      {
        Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", s.X("waitForBatchGetDownloadUrl, intercepted by PreGet with ", locala));
        ((Iterator)localObject2).remove();
        int k = localObject3.length;
        int i = 0;
        while (i < k)
        {
          locala = localObject3[i];
          int j = i + 1;
          i = j;
          if (locala != null)
          {
            localLinkedList.add(locala);
            i = j;
          }
        }
      }
    }
    Log.i("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", "waitForBatchGetDownloadUrl, inRequestList.size=" + paramList.size() + ", realRequestList.size=" + ((LinkedList)localObject1).size() + ", preGetRespItemList.size=" + localLinkedList.size());
    if (((LinkedList)localObject1).size() <= 0)
    {
      paramList = new kz();
      paramList.YMS.addAll((Collection)localLinkedList);
      paramq = ah.aiuX;
      paramb.invoke(paramList);
      AppMethodBeat.o(320927);
      return;
    }
    paramList = new ky();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (z.a)((Iterator)localObject1).next();
      paramList.YMQ.addAll((Collection)c((z.a)localObject2));
      paramList.scene = paramInt;
      paramList.YMR = paramaeo;
    }
    paramaeo = ah.aiuX;
    new com.tencent.mm.plugin.appbrand.appcache.h(paramList).bFJ().j(new w..ExternalSyntheticLambda2(localLinkedList, paramb, paramq));
    AppMethodBeat.o(320927);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "", "useEncryptPkg", "", "isGame", "usedCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "Factory", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public static final a sZD = a.sZE;
    
    public abstract boolean a(boolean paramBoolean, ICommLibReader paramICommLibReader);
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "resetTestSwitch", "", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "useEncryptPkg", "isGame", "usedCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "useNewCgi", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements w.a
    {
      static
      {
        AppMethodBeat.i(180531);
        sZE = new a();
        AppMethodBeat.o(180531);
      }
      
      private static boolean a(c.a parama)
      {
        AppMethodBeat.i(320859);
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
        {
          Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", INTERNAL BUILD, defBool:true");
          AppMethodBeat.o(320859);
          return true;
        }
        AppMethodBeat.o(320859);
        return false;
      }
      
      public static boolean cAd()
      {
        AppMethodBeat.i(180528);
        AppMethodBeat.o(180528);
        return true;
      }
      
      public final boolean a(boolean paramBoolean, ICommLibReader paramICommLibReader)
      {
        AppMethodBeat.i(320877);
        if (paramBoolean)
        {
          paramBoolean = a(c.a.yPt);
          bool1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yPt, paramBoolean);
          Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg for game, retVal[" + bool1 + "] exptVal[" + bool1 + "] defVal[" + paramBoolean + ']');
          AppMethodBeat.o(320877);
          return bool1;
        }
        boolean bool2 = a(c.a.yPs);
        boolean bool3 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yPs, bool2);
        int i;
        if (paramICommLibReader != null)
        {
          ab.a locala = ab.twQ;
          if (!ab.a.g(paramICommLibReader))
          {
            i = 1;
            if (i != 0) {
              break label222;
            }
            paramBoolean = true;
            label141:
            if ((!bool3) || (!paramBoolean)) {
              break label227;
            }
          }
        }
        label222:
        label227:
        for (boolean bool1 = true;; bool1 = false)
        {
          Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg for app, retVal[" + bool1 + "] exptVal[" + bool3 + "] defVal[" + bool2 + "] supportLazyCodeLoading[" + paramBoolean + ']');
          AppMethodBeat.o(320877);
          return bool1;
          i = 0;
          break;
          paramBoolean = false;
          break label141;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<ciq[], ah>
  {
    b(kotlin.g.a.b<? super kz, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w
 * JD-Core Version:    0.7.0.1
 */