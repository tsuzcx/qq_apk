package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.f;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/keystep/AppBrandKeyStepUtils;", "", "()V", "OPEN", "", "()Z", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a lqs;
  
  static
  {
    AppMethodBeat.i(196415);
    lqs = new a();
    AppMethodBeat.o(196415);
  }
  
  public static final boolean bmq()
  {
    AppMethodBeat.i(196414);
    if ((f.JZ("WeAppLaunch")) || (h.DEBUG) || (h.IS_FLAVOR_RED) || (bu.eGT()))
    {
      AppMethodBeat.o(196414);
      return true;
    }
    AppMethodBeat.o(196414);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a.a
 * JD-Core Version:    0.7.0.1
 */