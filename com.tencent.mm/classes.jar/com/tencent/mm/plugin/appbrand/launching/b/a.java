package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.aa.b;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/AppBrandLaunchDataPrefetchExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService;", "()V", "TAG", "", "insertPrefetchedPkgInfos", "", "infos", "", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService$PrefetchPkgDownloadInfo;", "prefetchContactAndPkgDownloadInfo", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "username", "enterPath", "preloadEnvScene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "prefetchLaunchWxaAppResponse", "prefetchWxaAttrs", "callback", "Landroid/arch/core/util/Function;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "Ljava/lang/Void;", "fileExists", "", "toInfo", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "toPreFetchDownloadInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPreFetchGetUrlItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.launching.b.a.a
{
  public static final a mXV;
  
  static
  {
    AppMethodBeat.i(50780);
    mXV = new a();
    AppMethodBeat.o(50780);
  }
  
  public final e<List<com.tencent.mm.plugin.appbrand.launching.b.a.a.a>> a(final String paramString1, final String paramString2, z paramz)
  {
    AppMethodBeat.i(228745);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo EMPTY USERNAME");
      paramString1 = g.c(null);
      p.g(paramString1, "pipelineExt(null)");
      paramString1 = (e)paramString1;
      AppMethodBeat.o(228745);
      return paramString1;
    }
    paramString1 = g.hio().h((com.tencent.mm.vending.c.a)new b(paramString1)).h((com.tencent.mm.vending.c.a)new c(paramz, paramString2, paramString1));
    p.g(paramString1, "pipelineExt().`$logic`<W…n@`$logic` null\n        }");
    paramString1 = (e)paramString1;
    AppMethodBeat.o(228745);
    return paramString1;
  }
  
  public final void a(String paramString, final android.arch.a.c.a<WxaAttributes, Void> parama)
  {
    AppMethodBeat.i(228744);
    aa.a(paramString, (aa.b)new d(paramString, parama));
    AppMethodBeat.o(228744);
  }
  
  public final void bO(List<? extends Pair<com.tencent.mm.plugin.appbrand.launching.b.a.a.a, String>> paramList)
  {
    AppMethodBeat.i(50779);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (Pair)paramList.next();
      Object localObject1 = com.tencent.mm.ac.a.hvd;
      localObject1 = (com.tencent.mm.plugin.appbrand.launching.b.a.a.a)com.tencent.mm.ac.a.a((Pair)localObject2);
      Object localObject3 = com.tencent.mm.ac.a.hvd;
      localObject2 = (String)com.tencent.mm.ac.a.b((Pair)localObject2);
      if (localObject1 != null)
      {
        localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId;
        label94:
        label125:
        String str1;
        label145:
        String str2;
        label256:
        int j;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label463;
          }
          localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).mYc;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label465;
          }
          i = 1;
          if (i != 0) {
            break label468;
          }
          if ((localObject2 == null) || (s.YS((String)localObject2) != true)) {
            break label470;
          }
          i = 1;
          if (i == 0) {
            break label473;
          }
          localObject3 = new ad(((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).MJn, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).packageType).toString();
          p.g(localObject3, "PkgQueryKey(pkg.appId, p…g.packageType).toString()");
          Object localObject4 = n.buL().a((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).MJo, 0, new String[] { "versionMd5", "NewMd5" });
          if (localObject4 == null) {
            continue;
          }
          if (localObject2 == null) {
            p.hyc();
          }
          str1 = CdnLogic.calcFileMD5(s.k((String)localObject2, false));
          str2 = ((bd)localObject4).field_versionMd5;
          localObject4 = ((bd)localObject4).field_NewMd5;
          i = 0;
          if (i >= 2) {
            break label487;
          }
          String str3 = new String[] { str2, localObject4 }[i];
          CharSequence localCharSequence = (CharSequence)str3;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label475;
          }
          j = 1;
          label303:
          if ((j != 0) || (!p.j(str3, str1))) {
            break label480;
          }
        }
        label463:
        label465:
        label468:
        label470:
        label473:
        label475:
        label480:
        label487:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label492;
          }
          str2 = ba.aT((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).MJo);
          s.nx((String)localObject2, str2);
          n.buL().e((String)localObject3, 0, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).MJo, str2);
          if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
            d.h((kotlin.g.a.a)new a((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1));
          }
          Log.i("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk accepted appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).MJn + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).MJo + "] fileMD5[" + str1 + ']');
          break;
          i = 0;
          break label94;
          break;
          i = 0;
          break label125;
          break;
          i = 0;
          break label145;
          break;
          j = 0;
          break label303;
          i += 1;
          break label256;
        }
        label492:
        Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk rejected appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).MJn + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).MJo + "] fileMD5[" + str1 + ']');
      }
    }
    AppMethodBeat.o(50779);
  }
  
  public final void ek(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50777);
    new b(paramString1, paramString2).aYI();
    AppMethodBeat.o(50777);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(com.tencent.mm.plugin.appbrand.launching.b.a.a.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxaAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(z paramz, String paramString1, String paramString2) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$IGetContactCallback$RESULT;", "attrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onGetContact"})
  static final class d<T>
    implements aa.b<WxaAttributes>
  {
    d(String paramString, android.arch.a.c.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a
 * JD-Core Version:    0.7.0.1
 */