package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.aa.b;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/AppBrandLaunchDataPrefetchExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService;", "()V", "TAG", "", "insertPrefetchedPkgInfos", "", "infos", "", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService$PrefetchPkgDownloadInfo;", "prefetchContactAndPkgDownloadInfo", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "username", "enterPath", "preloadEnvScene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "prefetchLaunchWxaAppResponse", "prefetchWxaAttrs", "callback", "Landroidx/arch/core/util/Function;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "Ljava/lang/Void;", "fileExists", "", "toInfo", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "toPreFetchDownloadInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPreFetchGetUrlItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.launching.b.a.a
{
  public static final a pYu;
  
  static
  {
    AppMethodBeat.i(50780);
    pYu = new a();
    AppMethodBeat.o(50780);
  }
  
  public final e<List<com.tencent.mm.plugin.appbrand.launching.b.a.a.a>> a(final String paramString1, final String paramString2, z paramz)
  {
    AppMethodBeat.i(274664);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo EMPTY USERNAME");
      paramString1 = g.c(null);
      p.j(paramString1, "pipelineExt(null)");
      paramString1 = (e)paramString1;
      AppMethodBeat.o(274664);
      return paramString1;
    }
    paramString1 = g.ijP().h((com.tencent.mm.vending.c.a)new b(paramString1)).h((com.tencent.mm.vending.c.a)new c(paramz, paramString2, paramString1));
    p.j(paramString1, "pipelineExt().`$logic`<W…n@`$logic` null\n        }");
    paramString1 = (e)paramString1;
    AppMethodBeat.o(274664);
    return paramString1;
  }
  
  public final void a(String paramString, final androidx.a.a.c.a<WxaAttributes, Void> parama)
  {
    AppMethodBeat.i(274663);
    aa.a(paramString, (aa.b)new d(paramString, parama));
    AppMethodBeat.o(274663);
  }
  
  public final void bN(List<? extends Pair<com.tencent.mm.plugin.appbrand.launching.b.a.a.a, String>> paramList)
  {
    AppMethodBeat.i(50779);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (Pair)paramList.next();
      Object localObject1 = com.tencent.mm.ae.a.kgZ;
      localObject1 = (com.tencent.mm.plugin.appbrand.launching.b.a.a.a)com.tencent.mm.ae.a.a((Pair)localObject2);
      Object localObject3 = com.tencent.mm.ae.a.kgZ;
      localObject2 = (String)com.tencent.mm.ae.a.b((Pair)localObject2);
      if (localObject1 != null)
      {
        localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId;
        label95:
        label126:
        String str1;
        label146:
        String str2;
        label257:
        int j;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label464;
          }
          localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).pYB;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label466;
          }
          i = 1;
          if (i != 0) {
            break label469;
          }
          if ((localObject2 == null) || (u.agG((String)localObject2) != true)) {
            break label471;
          }
          i = 1;
          if (i == 0) {
            break label474;
          }
          localObject3 = new ae(((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).TVc, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).fyH).toString();
          p.j(localObject3, "PkgQueryKey(pkg.appId, p…g.packageType).toString()");
          Object localObject4 = m.bFP().b((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).TVd, 0, new String[] { "versionMd5", "NewMd5" });
          if (localObject4 == null) {
            continue;
          }
          if (localObject2 == null) {
            p.iCn();
          }
          str1 = CdnLogic.calcFileMD5(u.n((String)localObject2, false));
          str2 = ((bh)localObject4).field_versionMd5;
          localObject4 = ((bh)localObject4).field_NewMd5;
          i = 0;
          if (i >= 2) {
            break label488;
          }
          String str3 = new String[] { str2, localObject4 }[i];
          CharSequence localCharSequence = (CharSequence)str3;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label476;
          }
          j = 1;
          label304:
          if ((j != 0) || (!p.h(str3, str1))) {
            break label481;
          }
        }
        label464:
        label466:
        label469:
        label471:
        label474:
        label476:
        label481:
        label488:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label493;
          }
          str2 = bd.bl((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).TVd);
          u.oo((String)localObject2, str2);
          m.bFP().f((String)localObject3, 0, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).TVd, str2);
          if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
            d.uiThread((kotlin.g.a.a)new a.a((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1));
          }
          Log.i("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk accepted appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).TVc + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).TVd + "] fileMD5[" + str1 + ']');
          break;
          i = 0;
          break label95;
          break;
          i = 0;
          break label126;
          break;
          i = 0;
          break label146;
          break;
          j = 0;
          break label304;
          i += 1;
          break label257;
        }
        label493:
        Log.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk rejected appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).TVc + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).TVd + "] fileMD5[" + str1 + ']');
      }
    }
    AppMethodBeat.o(50779);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50777);
    new b(paramString1, paramString2).bhW();
    AppMethodBeat.o(50777);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxaAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(z paramz, String paramString1, String paramString2) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$IGetContactCallback$RESULT;", "attrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onGetContact"})
  static final class d<T>
    implements aa.b<WxaAttributes>
  {
    d(String paramString, androidx.a.a.c.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a
 * JD-Core Version:    0.7.0.1
 */