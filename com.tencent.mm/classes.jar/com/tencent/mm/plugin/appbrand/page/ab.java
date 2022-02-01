package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "libFileProvider", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "wxaPkgFileProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;)V", "useLazyCodeLoadingMode", "", "getUseLazyCodeLoadingMode", "()Z", "useLazyCodeLoadingMode$delegate", "Lkotlin/Lazy;", "Constants", "luggage-wechat-full-sdk_release"})
public final class ab
  implements com.tencent.mm.plugin.appbrand.jsapi.l
{
  public static final ab.a qso;
  private final f qsl;
  private final ICommLibReader qsm;
  private final com.tencent.mm.plugin.appbrand.appcache.q qsn;
  
  static
  {
    AppMethodBeat.i(147962);
    qso = new ab.a((byte)0);
    AppMethodBeat.o(147962);
  }
  
  public ab(ICommLibReader paramICommLibReader, com.tencent.mm.plugin.appbrand.appcache.q paramq)
  {
    AppMethodBeat.i(183061);
    this.qsm = paramICommLibReader;
    this.qsn = paramq;
    this.qsl = g.ar((a)new b(this));
    AppMethodBeat.o(183061);
  }
  
  public final boolean cdQ()
  {
    AppMethodBeat.i(147963);
    boolean bool = ((Boolean)this.qsl.getValue()).booleanValue();
    AppMethodBeat.o(147963);
    return bool;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<Boolean>
  {
    b(ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ab
 * JD-Core Version:    0.7.0.1
 */