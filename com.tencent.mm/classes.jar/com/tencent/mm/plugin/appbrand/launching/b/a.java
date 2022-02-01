package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.x.b;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/AppBrandLaunchDataPrefetchExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService;", "()V", "TAG", "", "insertPrefetchedPkgInfos", "", "infos", "", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService$PrefetchPkgDownloadInfo;", "prefetchContactAndPkgDownloadInfo", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "username", "enterPath", "prefetchLaunchWxaAppResponse", "prefetchWxaAttrs", "fileExists", "", "toInfo", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.launching.b.a.a
{
  public static final a lMh;
  
  static
  {
    AppMethodBeat.i(50780);
    lMh = new a();
    AppMethodBeat.o(50780);
  }
  
  public final void RX(String paramString)
  {
    AppMethodBeat.i(189326);
    x.a(paramString, true, (x.b)new d(paramString));
    AppMethodBeat.o(189326);
  }
  
  public final void by(List<? extends Pair<com.tencent.mm.plugin.appbrand.launching.b.a.a.a, String>> paramList)
  {
    AppMethodBeat.i(50779);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (Pair)paramList.next();
      Object localObject1 = com.tencent.mm.ad.a.gFJ;
      localObject1 = (com.tencent.mm.plugin.appbrand.launching.b.a.a.a)com.tencent.mm.ad.a.a((Pair)localObject2);
      Object localObject3 = com.tencent.mm.ad.a.gFJ;
      localObject2 = (String)com.tencent.mm.ad.a.b((Pair)localObject2);
      if (localObject1 != null)
      {
        localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId;
        label94:
        label125:
        String str1;
        label145:
        String str2;
        label253:
        int j;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label461;
          }
          localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).lMs;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label463;
          }
          i = 1;
          if (i != 0) {
            break label466;
          }
          if ((localObject2 == null) || (com.tencent.mm.vfs.i.fv((String)localObject2) != true)) {
            break label468;
          }
          i = 1;
          if (i == 0) {
            break label471;
          }
          localObject3 = new ac(((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Hfh, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).dnF).toString();
          p.g(localObject3, "PkgQueryKey(pkg.appId, p…g.packageType).toString()");
          Object localObject4 = j.aYX().a((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Hfi, 0, new String[] { "versionMd5", "NewMd5" });
          if (localObject4 == null) {
            continue;
          }
          if (localObject2 == null) {
            p.gfZ();
          }
          str1 = CdnLogic.calcFileMD5(com.tencent.mm.vfs.i.k((String)localObject2, false));
          str2 = ((bc)localObject4).field_versionMd5;
          localObject4 = ((bc)localObject4).field_NewMd5;
          i = 0;
          if (i >= 2) {
            break label485;
          }
          String str3 = new String[] { str2, localObject4 }[i];
          CharSequence localCharSequence = (CharSequence)str3;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label473;
          }
          j = 1;
          label300:
          if ((j != 0) || (!p.i(str3, str1))) {
            break label478;
          }
        }
        label461:
        label463:
        label466:
        label468:
        label471:
        label473:
        label478:
        label485:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label490;
          }
          str2 = az.aL((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Hfi);
          com.tencent.mm.vfs.i.mA((String)localObject2, str2);
          j.aYX().e((String)localObject3, 0, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Hfi, str2);
          if ((bu.flY()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
            c.g((d.g.a.a)new a((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1));
          }
          ad.i("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk accepted appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Hfh + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Hfi + "] fileMD5[" + str1 + ']');
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
          break label300;
          i += 1;
          break label253;
        }
        label490:
        ad.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk rejected appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Hfh + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Hfi + "] fileMD5[" + str1 + ']');
      }
    }
    AppMethodBeat.o(50779);
  }
  
  public final void dQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50777);
    new b(paramString1, paramString2).aED();
    AppMethodBeat.o(50777);
  }
  
  public final e<List<com.tencent.mm.plugin.appbrand.launching.b.a.a.a>> dR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50778);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo EMPTY USERNAME");
      paramString1 = g.c(null);
      p.g(paramString1, "pipelineExt(null)");
      paramString1 = (e)paramString1;
      AppMethodBeat.o(50778);
      return paramString1;
    }
    paramString1 = g.fSm().h((com.tencent.mm.vending.c.a)new b(paramString1)).h((com.tencent.mm.vending.c.a)new c(paramString2));
    p.g(paramString1, "pipelineExt().`$logic`<W…n@`$logic` null\n        }");
    paramString1 = (e)paramString1;
    AppMethodBeat.o(50778);
    return paramString1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(com.tencent.mm.plugin.appbrand.launching.b.a.a.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxaAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(String paramString) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$IGetContactCallback$RESULT;", "attrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onGetContact"})
  static final class d<T>
    implements x.b<WxaAttributes>
  {
    d(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a
 * JD-Core Version:    0.7.0.1
 */