package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "libFileProvider", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "wxaPkgFileProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;)V", "useLazyCodeLoadingMode", "", "getUseLazyCodeLoadingMode", "()Z", "useLazyCodeLoadingMode$delegate", "Lkotlin/Lazy;", "Constants", "luggage-wechat-full-sdk_release"})
public final class y
  implements j
{
  public static final a laL;
  private final f laI;
  private final ICommLibReader laJ;
  private final q laK;
  
  static
  {
    AppMethodBeat.i(147962);
    $$delegatedProperties = new k[] { (k)w.a(new u(w.bk(y.class), "useLazyCodeLoadingMode", "getUseLazyCodeLoadingMode()Z")) };
    laL = new a((byte)0);
    AppMethodBeat.o(147962);
  }
  
  public y(ICommLibReader paramICommLibReader, q paramq)
  {
    AppMethodBeat.i(183061);
    this.laJ = paramICommLibReader;
    this.laK = paramq;
    this.laI = g.E((a)new b(this));
    AppMethodBeat.o(183061);
  }
  
  public final boolean bjy()
  {
    AppMethodBeat.i(147963);
    boolean bool = ((Boolean)this.laI.getValue()).booleanValue();
    AppMethodBeat.o(147963);
    return bool;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig$Constants;", "", "()V", "COMMON_JS_NAME", "", "TAG", "WEBVIEW_APP_JS_NAME", "supportLazyCodeLoading", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Boolean>
  {
    b(y paramy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */