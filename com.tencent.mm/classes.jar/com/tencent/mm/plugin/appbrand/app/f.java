package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandProcessSharedMMKV;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "SP_NAME", "", "TAG", "UIN", "", "getUIN", "()I", "UIN_BY_SP", "getUIN_BY_SP", "UIN_BY_SP$delegate", "Lkotlin/Lazy;", "name", "plugin-appbrand-integration_release"})
public final class f
{
  private static final kotlin.f nCh;
  public static final f nCi;
  
  static
  {
    AppMethodBeat.i(50163);
    nCi = new f();
    nCh = g.ar((a)a.nCj);
    AppMethodBeat.o(50163);
  }
  
  private static int getUIN()
  {
    AppMethodBeat.i(277974);
    if (h.aHB())
    {
      p.j(h.aHE(), "MMKernel.account()");
      i = b.getUin();
      AppMethodBeat.o(277974);
      return i;
    }
    int i = ((Number)nCh.getValue()).intValue();
    AppMethodBeat.o(277974);
    return i;
  }
  
  public final MultiProcessMMKV aal()
  {
    AppMethodBeat.i(50164);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("AppBrandProcessSharedMMKV_" + getUIN());
    AppMethodBeat.o(50164);
    return localMultiProcessMMKV;
  }
  
  public final MultiProcessMMKV getMMKV(String paramString)
  {
    AppMethodBeat.i(277975);
    p.k(paramString, "name");
    paramString = MultiProcessMMKV.getMMKV(paramString + '_' + getUIN());
    AppMethodBeat.o(277975);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Integer>
  {
    public static final a nCj;
    
    static
    {
      AppMethodBeat.i(50162);
      nCj = new a();
      AppMethodBeat.o(50162);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.f
 * JD-Core Version:    0.7.0.1
 */