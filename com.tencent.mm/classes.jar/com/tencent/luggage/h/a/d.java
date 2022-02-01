package com.tencent.luggage.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/SkylinePageSeparatedPluginsInjectHelper;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "()V", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "Companion", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements bj
{
  public static final a ewl;
  
  static
  {
    AppMethodBeat.i(220049);
    ewl = new a((byte)0);
    AppMethodBeat.o(220049);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(220060);
    Log.e("SkylinePageSeparatedPluginsInjectHelper", "onReloadURL");
    AppMethodBeat.o(220060);
  }
  
  public final void l(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(220055);
    s.u(paramString, "moduleName");
    Log.e("SkylinePageSeparatedPluginsInjectHelper", "injectPlugins moduleName:" + paramString + " useLazyCodeLoading:" + paramBoolean);
    AppMethodBeat.o(220055);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/SkylinePageSeparatedPluginsInjectHelper$Companion;", "", "()V", "TAG", "", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.h.a.d
 * JD-Core Version:    0.7.0.1
 */