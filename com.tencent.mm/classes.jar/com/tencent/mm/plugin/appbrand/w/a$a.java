package com.tencent.mm.plugin.appbrand.w;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas$Companion;", "", "()V", "COMMAND_USE_XWEB_CANVAS", "", "TAG", "USE_SKIA_CANVAS", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "register", "", "useSkiaCanvas", "", "()Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class a$a
{
  static as aSs()
  {
    AppMethodBeat.i(154365);
    as localas = as.eu("MicroMsg.UseXWebCanvas", 2);
    j.p(localas, "MultiProcessMMKV.getMMKV… MMKV.MULTI_PROCESS_MODE)");
    AppMethodBeat.o(154365);
    return localas;
  }
  
  public static Boolean aSt()
  {
    AppMethodBeat.i(154366);
    if (aSs().containsKey("use_skia_canvas"))
    {
      boolean bool = aSs().getBoolean("use_skia_canvas", false);
      AppMethodBeat.o(154366);
      return Boolean.valueOf(bool);
    }
    AppMethodBeat.o(154366);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a.a
 * JD-Core Version:    0.7.0.1
 */