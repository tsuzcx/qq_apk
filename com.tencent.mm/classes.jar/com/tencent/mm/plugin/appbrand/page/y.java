package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import d.f;
import d.g;
import d.g.a.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "libFileProvider", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "wxaPkgFileProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;)V", "useLazyCodeLoadingMode", "", "getUseLazyCodeLoadingMode", "()Z", "useLazyCodeLoadingMode$delegate", "Lkotlin/Lazy;", "Constants", "luggage-wechat-full-sdk_release"})
public final class y
  implements j
{
  public static final a mbL;
  private final f mbI;
  private final ICommLibReader mbJ;
  private final com.tencent.mm.plugin.appbrand.appcache.q mbK;
  
  static
  {
    AppMethodBeat.i(147962);
    mbL = new a((byte)0);
    AppMethodBeat.o(147962);
  }
  
  public y(ICommLibReader paramICommLibReader, com.tencent.mm.plugin.appbrand.appcache.q paramq)
  {
    AppMethodBeat.i(183061);
    this.mbJ = paramICommLibReader;
    this.mbK = paramq;
    this.mbI = g.O((a)new b(this));
    AppMethodBeat.o(183061);
  }
  
  public final boolean bup()
  {
    AppMethodBeat.i(147963);
    boolean bool = ((Boolean)this.mbI.getValue()).booleanValue();
    AppMethodBeat.o(147963);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig$Constants;", "", "()V", "COMMON_JS_NAME", "", "TAG", "WEBVIEW_APP_JS_NAME", "supportLazyCodeLoading", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<Boolean>
  {
    b(y paramy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */