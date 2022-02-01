package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.launching.x.a;
import com.tencent.mm.plugin.appbrand.launching.x.d;
import com.tencent.mm.plugin.appbrand.launching.x.e;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.appbrand.service.u.a;
import com.tencent.mm.plugin.appbrand.service.u.b;
import com.tencent.mm.vending.g.d.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService;", "()V", "registerPkgSpecs", "", "appUsername", "", "appId", "visitScene", "", "startDownloadPkg", "versionType", "onSuccess", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadSuccessListener;", "onError", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadErrorListener;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  implements u
{
  public static final a kQg;
  
  static
  {
    AppMethodBeat.i(228083);
    kQg = new a((byte)0);
    AppMethodBeat.o(228083);
  }
  
  public final void a(final String paramString, final int paramInt, final u.b paramb, final u.a parama)
  {
    AppMethodBeat.i(228081);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.onError(-1, "invalid appId");
      AppMethodBeat.o(228081);
      return;
    }
    com.tencent.mm.co.g.hio().h((com.tencent.mm.vending.c.a)new b(paramInt, paramString, parama)).h((com.tencent.mm.vending.c.a)new c(paramString, paramInt, paramb, parama)).a((d.b)d.kQm);
    AppMethodBeat.o(228081);
  }
  
  public final void r(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(228082);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label75;
        }
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label81;
      }
      AppMethodBeat.o(228082);
      return;
      i = 0;
      break;
    }
    label81:
    localObject = com.tencent.mm.plugin.appbrand.config.t.lfL;
    com.tencent.mm.plugin.appbrand.config.t.x(paramString1, paramString2, paramInt);
    AppMethodBeat.o(228082);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl$Companion;", "", "()V", "TAG", "", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static b bwT()
    {
      AppMethodBeat.i(228074);
      Object localObject = (u)com.tencent.mm.kernel.g.af(u.class);
      if (localObject == null)
      {
        localObject = com.tencent.mm.kernel.g.aAf();
        p.g(localObject, "MMKernel.account()");
        if (!((com.tencent.mm.kernel.a)localObject).azq())
        {
          localObject = (Throwable)new com.tencent.mm.model.b();
          AppMethodBeat.o(228074);
          throw ((Throwable)localObject);
        }
        localObject = (Throwable)new NullPointerException();
        AppMethodBeat.o(228074);
        throw ((Throwable)localObject);
      }
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceImpl");
        AppMethodBeat.o(228074);
        throw ((Throwable)localObject);
      }
      localObject = (b)localObject;
      AppMethodBeat.o(228074);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Ljava/lang/Boolean;"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(int paramInt, String paramString, u.a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)V"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(String paramString, int paramInt, u.b paramb, u.a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "onTerminate", "(Lkotlin/Unit;)V"})
  static final class d<T>
    implements d.b<x>
  {
    public static final d kQm;
    
    static
    {
      AppMethodBeat.i(228080);
      kQm = new d();
      AppMethodBeat.o(228080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.b
 * JD-Core Version:    0.7.0.1
 */