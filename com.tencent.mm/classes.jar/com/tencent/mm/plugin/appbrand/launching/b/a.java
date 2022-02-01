package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.x.b;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/AppBrandLaunchDataPrefetchExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService;", "()V", "TAG", "", "insertPrefetchedPkgInfos", "", "infos", "", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService$PrefetchPkgDownloadInfo;", "prefetchContactAndPkgDownloadInfo", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "username", "enterPath", "prefetchLaunchWxaAppResponse", "prefetchWxaAttrs", "fileExists", "", "toInfo", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.launching.b.a.a
{
  public static final a lQH;
  
  static
  {
    AppMethodBeat.i(50780);
    lQH = new a();
    AppMethodBeat.o(50780);
  }
  
  public final void SG(String paramString)
  {
    AppMethodBeat.i(223585);
    x.a(paramString, true, (x.b)new d(paramString));
    AppMethodBeat.o(223585);
  }
  
  public final void bA(List<? extends Pair<com.tencent.mm.plugin.appbrand.launching.b.a.a.a, String>> paramList)
  {
    AppMethodBeat.i(50779);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (Pair)paramList.next();
      Object localObject1 = com.tencent.mm.ac.a.gIq;
      localObject1 = (com.tencent.mm.plugin.appbrand.launching.b.a.a.a)com.tencent.mm.ac.a.a((Pair)localObject2);
      Object localObject3 = com.tencent.mm.ac.a.gIq;
      localObject2 = (String)com.tencent.mm.ac.a.b((Pair)localObject2);
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
          localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).lQS;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label463;
          }
          i = 1;
          if (i != 0) {
            break label466;
          }
          if ((localObject2 == null) || (o.fB((String)localObject2) != true)) {
            break label468;
          }
          i = 1;
          if (i == 0) {
            break label471;
          }
          localObject3 = new ad(((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).HyH, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).doK).toString();
          p.g(localObject3, "PkgQueryKey(pkg.appId, p…g.packageType).toString()");
          Object localObject4 = com.tencent.mm.plugin.appbrand.app.j.aZu().a((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).HyI, 0, new String[] { "versionMd5", "NewMd5" });
          if (localObject4 == null) {
            continue;
          }
          if (localObject2 == null) {
            p.gkB();
          }
          str1 = CdnLogic.calcFileMD5(o.k((String)localObject2, false));
          str2 = ((bd)localObject4).field_versionMd5;
          localObject4 = ((bd)localObject4).field_NewMd5;
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
          str2 = ba.aO((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).HyI);
          o.mG((String)localObject2, str2);
          com.tencent.mm.plugin.appbrand.app.j.aZu().e((String)localObject3, 0, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).HyI, str2);
          if ((bv.fpT()) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)) {
            c.h((d.g.a.a)new a((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1));
          }
          ae.i("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk accepted appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).HyH + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).HyI + "] fileMD5[" + str1 + ']');
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
        ae.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk rejected appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).HyH + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).HyI + "] fileMD5[" + str1 + ']');
      }
    }
    AppMethodBeat.o(50779);
  }
  
  public final void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50777);
    new b(paramString1, paramString2).aET();
    AppMethodBeat.o(50777);
  }
  
  public final e<List<com.tencent.mm.plugin.appbrand.launching.b.a.a.a>> dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50778);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo EMPTY USERNAME");
      paramString1 = g.c(null);
      p.g(paramString1, "pipelineExt(null)");
      paramString1 = (e)paramString1;
      AppMethodBeat.o(50778);
      return paramString1;
    }
    paramString1 = g.fWL().h((com.tencent.mm.vending.c.a)new b(paramString1)).h((com.tencent.mm.vending.c.a)new c(paramString2));
    p.g(paramString1, "pipelineExt().`$logic`<W…n@`$logic` null\n        }");
    paramString1 = (e)paramString1;
    AppMethodBeat.o(50778);
    return paramString1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(com.tencent.mm.plugin.appbrand.launching.b.a.a.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxaAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(String paramString) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$IGetContactCallback$RESULT;", "attrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onGetContact"})
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