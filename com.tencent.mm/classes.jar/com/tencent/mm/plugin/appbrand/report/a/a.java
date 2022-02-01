package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.f;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/keystep/AppBrandKeyStepUtils;", "", "()V", "OPEN", "", "()Z", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a msd;
  
  static
  {
    AppMethodBeat.i(189587);
    msd = new a();
    AppMethodBeat.o(189587);
  }
  
  public static final boolean bxr()
  {
    AppMethodBeat.i(189586);
    if ((f.RE("WeAppLaunch")) || (i.DEBUG) || (i.IS_FLAVOR_RED) || (bu.flY()))
    {
      AppMethodBeat.o(189586);
      return true;
    }
    AppMethodBeat.o(189586);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a.a
 * JD-Core Version:    0.7.0.1
 */