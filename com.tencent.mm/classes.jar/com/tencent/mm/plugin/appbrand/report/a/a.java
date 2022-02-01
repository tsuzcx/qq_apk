package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.f;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/keystep/AppBrandKeyStepUtils;", "", "()V", "OPEN", "", "()Z", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a mxb;
  
  static
  {
    AppMethodBeat.i(223856);
    mxb = new a();
    AppMethodBeat.o(223856);
  }
  
  public static final boolean byk()
  {
    AppMethodBeat.i(223855);
    if ((f.Sn("WeAppLaunch")) || (j.DEBUG) || (j.IS_FLAVOR_RED) || (bv.fpT()) || (DebuggerShell.bfe()))
    {
      AppMethodBeat.o(223855);
      return true;
    }
    AppMethodBeat.o(223855);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a.a
 * JD-Core Version:    0.7.0.1
 */