package com.tencent.mm.plugin.appbrand.launching.b;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
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
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/AppBrandLaunchDataPrefetchExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService;", "()V", "TAG", "", "insertPrefetchedPkgInfos", "", "infos", "", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/export/IAppBrandLaunchDataPrefetchService$PrefetchPkgDownloadInfo;", "prefetchContactAndPkgDownloadInfo", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "username", "enterPath", "prefetchLaunchWxaAppResponse", "prefetchWxaAttrs", "fileExists", "", "toInfo", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.launching.b.a.a
{
  public static final a loP;
  
  static
  {
    AppMethodBeat.i(50780);
    loP = new a();
    AppMethodBeat.o(50780);
  }
  
  public final void Ox(String paramString)
  {
    AppMethodBeat.i(187334);
    w.a(paramString, true, (w.b)new d(paramString));
    AppMethodBeat.o(187334);
  }
  
  public final void bw(List<? extends Pair<com.tencent.mm.plugin.appbrand.launching.b.a.a.a, String>> paramList)
  {
    AppMethodBeat.i(50779);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (Pair)paramList.next();
      Object localObject1 = com.tencent.mm.ac.a.glZ;
      localObject1 = (com.tencent.mm.plugin.appbrand.launching.b.a.a.a)com.tencent.mm.ac.a.a((Pair)localObject2);
      Object localObject3 = com.tencent.mm.ac.a.glZ;
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
          localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).lpa;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label463;
          }
          i = 1;
          if (i != 0) {
            break label466;
          }
          if ((localObject2 == null) || (i.eA((String)localObject2) != true)) {
            break label468;
          }
          i = 1;
          if (i == 0) {
            break label471;
          }
          localObject3 = new ab(((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Fvc, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).dcj).toString();
          k.g(localObject3, "PkgQueryKey(pkg.appId, p…g.packageType).toString()");
          Object localObject4 = j.aVC().a((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Fvd, 0, new String[] { "versionMd5", "NewMd5" });
          if (localObject4 == null) {
            continue;
          }
          if (localObject2 == null) {
            k.fOy();
          }
          str1 = CdnLogic.calcFileMD5(i.k((String)localObject2, false));
          str2 = ((bb)localObject4).field_versionMd5;
          localObject4 = ((bb)localObject4).field_NewMd5;
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
          if ((j != 0) || (!k.g(str3, str1))) {
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
          str2 = ay.aJ((String)localObject3, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Fvd);
          i.ma((String)localObject2, str2);
          j.aVC().e((String)localObject3, 0, ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Fvd, str2);
          if ((bt.eWo()) || (h.IS_FLAVOR_RED)) {
            c.g((d.g.a.a)new a((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1));
          }
          ac.i("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk accepted appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Fvc + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Fvd + "] fileMD5[" + str1 + ']');
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
        ac.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "WxaPkg path from OpenSdk rejected appId[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).appId + "] key[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Fvc + "] version[" + ((com.tencent.mm.plugin.appbrand.launching.b.a.a.a)localObject1).Fvd + "] fileMD5[" + str1 + ']');
      }
    }
    AppMethodBeat.o(50779);
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50777);
    new b(paramString1, paramString2).aBB();
    AppMethodBeat.o(50777);
  }
  
  public final e<List<com.tencent.mm.plugin.appbrand.launching.b.a.a.a>> dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50778);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("MicroMsg.AppBrandLaunchDataPrefetchExportServiceImpl", "prefetchContactAndPkgDownloadInfo EMPTY USERNAME");
      paramString1 = g.c(null);
      k.g(paramString1, "pipelineExt(null)");
      paramString1 = (e)paramString1;
      AppMethodBeat.o(50778);
      return paramString1;
    }
    paramString1 = g.fBc().h((com.tencent.mm.vending.c.a)new b(paramString1)).h((com.tencent.mm.vending.c.a)new c(paramString2));
    k.g(paramString1, "pipelineExt().`$logic`<W…n@`$logic` null\n        }");
    paramString1 = (e)paramString1;
    AppMethodBeat.o(50778);
    return paramString1;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(com.tencent.mm.plugin.appbrand.launching.b.a.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "wxaAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrSyncHelper$IGetContactCallback$RESULT;", "attrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onGetContact"})
  static final class d<T>
    implements w.b<WxaAttributes>
  {
    d(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a
 * JD-Core Version:    0.7.0.1
 */