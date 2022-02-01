package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.f;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/keystep/AppBrandKeyStepUtils;", "", "()V", "OPEN", "", "()Z", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a lSn;
  
  static
  {
    AppMethodBeat.i(187376);
    lSn = new a();
    AppMethodBeat.o(187376);
  }
  
  public static final boolean btm()
  {
    AppMethodBeat.i(187375);
    if ((f.Og("WeAppLaunch")) || (h.DEBUG) || (h.IS_FLAVOR_RED) || (bt.eWo()))
    {
      AppMethodBeat.o(187375);
      return true;
    }
    AppMethodBeat.o(187375);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a.a
 * JD-Core Version:    0.7.0.1
 */