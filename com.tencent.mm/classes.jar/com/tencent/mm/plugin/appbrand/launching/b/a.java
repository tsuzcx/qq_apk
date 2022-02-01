package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.config.w.b;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/AppBrandLaunchDataPrefetchExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService;", "()V", "TAG", "", "insertPrefetchedPkgInfos", "", "infos", "", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService$PrefetchPkgDownloadInfo;", "prefetchContactAndPkgDownloadInfo", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "username", "enterPath", "prefetchLaunchWxaAppResponse", "prefetchWxaAttrs", "fileExists", "", "toInfo", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.launching.b.a.a
{
  public static final a kNq;
  
  static
  {
    AppMethodBeat.i(50780);
    kNq = new a();
    AppMethodBeat.o(50780);
  }
  
  public final void Kq(String paramString)
  {
    AppMethodBeat.i(196396);
    w.a(paramString, true, (w.b)new a.d(paramString));
    AppMethodBeat.o(196396);
  }
  
  public final void bw(List<? extends Pair<com.tencent.mm.plugin.appbrand.launching.b.a.a.a, String>> paramList)
  {
    AppMethodBeat.i(50779);
    paramList = paramList.iterator();
    label384:
    while (paramList.hasNext())
    {
      Object localObject2 = (Pair)paramList.next();
      Object localObject1 = com.tencent.mm.ad.a.ght;
      localObject1 = (com.tencent.mm.plugin.appbrand.launching.b.a.a.a)com.tencent.mm.ad.a.a((Pair)localObject2);
      Object localObject3 = com.tencent.mm.ad.a.ght;
      localObject2 = (String)com.tencent.mm.ad.a.b((Pair)localObject2);
      if (localObject1 != null)
      {
        localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
        {
          i = 1;
          label90:
          if (i != 0) {
            break label374;
          }
          localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).kNB;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label376;
          }
          i = 1;
          label120:
          if (i != 0) {
            break label379;
          }
          if ((localObject2 == null) || (i.eK((String)localObject2) != true)) {
            break label381;
          }
        }
        label374:
        label376:
        label379:
        label381:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label384;
          }
          localObject3 = new ab(((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).DYi, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).deP).toString();
          k.g(localObject3, "PkgQueryKey(pkg.appId, p…g.packageType).toString()");
          Object localObject4 = j.aOK().a((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).DYj, 0, new String[] { "versionMd5" });
          if ((localObject4 == null) || (!((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).kNB.equals(((bb)localObject4).field_versionMd5))) {
            break;
          }
          localObject4 = ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).kNB;
          if (localObject2 == null) {
            k.fvU();
          }
          if (!((String)localObject4).equals(CdnLogic.calcFileMD5(i.k((String)localObject2, false)))) {
            break;
          }
          localObject4 = ay.aF((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).DYj);
          i.lD((String)localObject2, (String)localObject4);
          j.aOK().d((String)localObject3, 0, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).DYj, (String)localObject4);
          if ((!bu.eGT()) && (!h.IS_FLAVOR_RED)) {
            break;
          }
          c.g((d.g.a.a)new a.a((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1));
          ad.i("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk accepted appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).DYi + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).DYj + ']');
          break;
          i = 0;
          break label90;
          break;
          i = 0;
          break label120;
          break;
        }
      }
    }
    AppMethodBeat.o(50779);
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50777);
    new b(paramString1, paramString2).auK();
    AppMethodBeat.o(50777);
  }
  
  public final e<List<com.tencent.mm.plugin.appbrand.launching.b.a.a.a>> dy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50778);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo EMPTY USERNAME");
      paramString1 = g.c(null);
      k.g(paramString1, "pipelineExt(null)");
      paramString1 = (e)paramString1;
      AppMethodBeat.o(50778);
      return paramString1;
    }
    paramString1 = g.fkM().h((com.tencent.mm.vending.c.a)new a.b(paramString1)).h((com.tencent.mm.vending.c.a)new c(paramString2));
    k.g(paramString1, "pipelineExt().`$logic`<W…n@`$logic` null\n        }");
    paramString1 = (e)paramString1;
    AppMethodBeat.o(50778);
    return paramString1;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "wxaAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a
 * JD-Core Version:    0.7.0.1
 */