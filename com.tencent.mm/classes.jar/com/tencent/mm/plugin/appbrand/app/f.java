package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandProcessSharedMMKV;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "SP_NAME", "", "TAG", "UIN", "", "getUIN", "()I", "UIN_BY_SP", "getUIN_BY_SP", "UIN_BY_SP$delegate", "Lkotlin/Lazy;", "name", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f qBv;
  private static final j qBw;
  
  static
  {
    AppMethodBeat.i(50163);
    qBv = new f();
    qBw = k.cm((a)a.qBx);
    AppMethodBeat.o(50163);
  }
  
  public static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(50164);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(s.X("AppBrandProcessSharedMMKV_", Integer.valueOf(getUIN())));
    AppMethodBeat.o(50164);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV getMMKV(String paramString)
  {
    AppMethodBeat.i(317799);
    s.u(paramString, "name");
    paramString = MultiProcessMMKV.getMMKV(paramString + '_' + getUIN());
    AppMethodBeat.o(317799);
    return paramString;
  }
  
  private static int getUIN()
  {
    AppMethodBeat.i(317794);
    if (h.baz())
    {
      h.baC();
      i = b.getUin();
      AppMethodBeat.o(317794);
      return i;
    }
    int i = ((Number)qBw.getValue()).intValue();
    AppMethodBeat.o(317794);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Integer>
  {
    public static final a qBx;
    
    static
    {
      AppMethodBeat.i(50162);
      qBx = new a();
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