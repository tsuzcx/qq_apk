package com.tencent.luggage.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/SkylinePageScriptInjectionMode;", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer$IPageScriptInjectionMode;", "()V", "checkIsAppSharedPageFrameScript", "", "scriptName", "", "injectAppSharedPageFrameScript", "", "injectModuleSharedPageFrameScript", "pagePath", "injectPageScript", "url", "name", "Companion", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a.a
{
  public static final a ewk;
  
  static
  {
    AppMethodBeat.i(220047);
    ewk = new a((byte)0);
    AppMethodBeat.o(220047);
  }
  
  public final void atd()
  {
    AppMethodBeat.i(220057);
    Log.e("SkylinePageScriptInjectionMode", "injectAppSharedPageFrameScript");
    AppMethodBeat.o(220057);
  }
  
  public final void fE(String paramString)
  {
    AppMethodBeat.i(220052);
    Log.e("SkylinePageScriptInjectionMode", s.X("injectPageScript url:", paramString));
    AppMethodBeat.o(220052);
  }
  
  public final void fF(String paramString)
  {
    AppMethodBeat.i(220064);
    Log.e("SkylinePageScriptInjectionMode", "injectModuleSharedPageFrameScript");
    AppMethodBeat.o(220064);
  }
  
  public final boolean fG(String paramString)
  {
    AppMethodBeat.i(220066);
    Log.e("SkylinePageScriptInjectionMode", "checkIsAppSharedPageFrameScript");
    AppMethodBeat.o(220066);
    return false;
  }
  
  public final String name()
  {
    return "";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/SkylinePageScriptInjectionMode$Companion;", "", "()V", "TAG", "", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.h.a.c
 * JD-Core Version:    0.7.0.1
 */