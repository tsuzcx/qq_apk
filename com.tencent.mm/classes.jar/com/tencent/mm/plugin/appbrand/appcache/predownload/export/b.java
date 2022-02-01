package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.appbrand.service.u.a;
import com.tencent.mm.plugin.appbrand.service.u.b;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService;", "()V", "registerPkgSpecs", "", "appUsername", "", "appId", "visitScene", "", "startDownloadPkg", "versionType", "onSuccess", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadSuccessListener;", "onError", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadErrorListener;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  implements u
{
  public static final a nKl;
  
  static
  {
    AppMethodBeat.i(265341);
    nKl = new a((byte)0);
    AppMethodBeat.o(265341);
  }
  
  public final void a(final String paramString, int paramInt, u.b paramb, final u.a parama)
  {
    AppMethodBeat.i(265338);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.onError(-1, "invalid appId");
      AppMethodBeat.o(265338);
      return;
    }
    g.ijP().h((a)new b(paramInt, paramString, parama)).h((a)new b.c(paramString, paramInt, paramb, parama)).a((d.b)d.nKr);
    AppMethodBeat.o(265338);
  }
  
  public final void u(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(265340);
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
      AppMethodBeat.o(265340);
      return;
      i = 0;
      break;
    }
    label81:
    localObject = com.tencent.mm.plugin.appbrand.config.t.oak;
    com.tencent.mm.plugin.appbrand.config.t.A(paramString1, paramString2, paramInt);
    AppMethodBeat.o(265340);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl$Companion;", "", "()V", "TAG", "", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static b bIa()
    {
      AppMethodBeat.i(274113);
      Object localObject = (u)h.ae(u.class);
      if (localObject == null)
      {
        localObject = h.aHE();
        p.j(localObject, "MMKernel.account()");
        if (!((com.tencent.mm.kernel.b)localObject).aGN())
        {
          localObject = (Throwable)new com.tencent.mm.model.b();
          AppMethodBeat.o(274113);
          throw ((Throwable)localObject);
        }
        localObject = (Throwable)new NullPointerException();
        AppMethodBeat.o(274113);
        throw ((Throwable)localObject);
      }
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceImpl");
        AppMethodBeat.o(274113);
        throw ((Throwable)localObject);
      }
      localObject = (b)localObject;
      AppMethodBeat.o(274113);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Ljava/lang/Boolean;"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(int paramInt, String paramString, u.a parama) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "onTerminate", "(Lkotlin/Unit;)V"})
  static final class d<T>
    implements d.b<x>
  {
    public static final d nKr;
    
    static
    {
      AppMethodBeat.i(279972);
      nKr = new d();
      AppMethodBeat.o(279972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.b
 * JD-Core Version:    0.7.0.1
 */