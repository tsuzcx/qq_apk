package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/keystep/AppBrandKeyStepUtils;", "", "()V", "OPEN", "", "()Z", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a nIf;
  
  static
  {
    AppMethodBeat.i(229308);
    nIf = new a();
    AppMethodBeat.o(229308);
  }
  
  public static final boolean bUC()
  {
    AppMethodBeat.i(229307);
    if ((f.abT("WeAppLaunch")) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (DebuggerShell.bAx()))
    {
      AppMethodBeat.o(229307);
      return true;
    }
    AppMethodBeat.o(229307);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a.a
 * JD-Core Version:    0.7.0.1
 */