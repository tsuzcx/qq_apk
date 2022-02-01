package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "libFileProvider", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "wxaPkgFileProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;)V", "useLazyCodeLoadingMode", "", "getUseLazyCodeLoadingMode", "()Z", "useLazyCodeLoadingMode$delegate", "Lkotlin/Lazy;", "Constants", "luggage-wechat-full-sdk_release"})
public final class aa
  implements m
{
  public static final a nqC;
  private final ICommLibReader nqA;
  private final com.tencent.mm.plugin.appbrand.appcache.q nqB;
  private final f nqz;
  
  static
  {
    AppMethodBeat.i(147962);
    nqC = new a((byte)0);
    AppMethodBeat.o(147962);
  }
  
  public aa(ICommLibReader paramICommLibReader, com.tencent.mm.plugin.appbrand.appcache.q paramq)
  {
    AppMethodBeat.i(183061);
    this.nqA = paramICommLibReader;
    this.nqB = paramq;
    this.nqz = g.ah((a)new b(this));
    AppMethodBeat.o(183061);
  }
  
  public final boolean bRa()
  {
    AppMethodBeat.i(147963);
    boolean bool = ((Boolean)this.nqz.getValue()).booleanValue();
    AppMethodBeat.o(147963);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig$Constants;", "", "()V", "COMMON_JS_NAME", "", "TAG", "WEBVIEW_APP_JS_NAME", "supportLazyCodeLoading", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static boolean d(ICommLibReader paramICommLibReader)
    {
      AppMethodBeat.i(230119);
      p.h(paramICommLibReader, "$this$supportLazyCodeLoading");
      int i = 0;
      while (i < 2)
      {
        CharSequence localCharSequence = (CharSequence)paramICommLibReader.UN(new java.lang.String[] { "lazyCodeLoading", "lazyCodeLoading2" }[i]);
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int j = 1; j == 0; j = 0)
        {
          AppMethodBeat.o(230119);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(230119);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<Boolean>
  {
    b(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa
 * JD-Core Version:    0.7.0.1
 */