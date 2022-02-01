package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "libFileProvider", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "wxaPkgFileProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;)V", "useLazyCodeLoadingMode", "", "getUseLazyCodeLoadingMode", "()Z", "useLazyCodeLoadingMode$delegate", "Lkotlin/Lazy;", "Constants", "luggage-wechat-full-sdk_release"})
public final class x
  implements j
{
  public static final a mge;
  private final f mgb;
  private final ICommLibReader mgc;
  private final com.tencent.mm.plugin.appbrand.appcache.q mgd;
  
  static
  {
    AppMethodBeat.i(147962);
    mge = new a((byte)0);
    AppMethodBeat.o(147962);
  }
  
  public x(ICommLibReader paramICommLibReader, com.tencent.mm.plugin.appbrand.appcache.q paramq)
  {
    AppMethodBeat.i(183061);
    this.mgc = paramICommLibReader;
    this.mgd = paramq;
    this.mgb = g.O((a)new b(this));
    AppMethodBeat.o(183061);
  }
  
  public final boolean bva()
  {
    AppMethodBeat.i(147963);
    boolean bool = ((Boolean)this.mgb.getValue()).booleanValue();
    AppMethodBeat.o(147963);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig$Constants;", "", "()V", "COMMON_JS_NAME", "", "TAG", "WEBVIEW_APP_JS_NAME", "supportLazyCodeLoading", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static boolean d(ICommLibReader paramICommLibReader)
    {
      AppMethodBeat.i(224458);
      p.h(paramICommLibReader, "$this$supportLazyCodeLoading");
      int i = 0;
      while (i < 2)
      {
        CharSequence localCharSequence = (CharSequence)paramICommLibReader.LE(new java.lang.String[] { "lazyCodeLoading", "lazyCodeLoading2" }[i]);
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int j = 1; j == 0; j = 0)
        {
          AppMethodBeat.o(224458);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(224458);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<Boolean>
  {
    b(x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.x
 * JD-Core Version:    0.7.0.1
 */