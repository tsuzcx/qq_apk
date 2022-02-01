package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.f;
import com.tencent.mm.plugin.appbrand.jsapi.x.f.c;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class q
{
  public static final q mrM;
  
  static
  {
    AppMethodBeat.i(51027);
    mrM = new q();
    AppMethodBeat.o(51027);
  }
  
  public static final String dK(Context paramContext)
  {
    AppMethodBeat.i(51026);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    paramContext = f.dt(localContext);
    switch (r.cpQ[paramContext.ordinal()])
    {
    default: 
      paramContext = paramContext.value;
      p.g(paramContext, "type.value");
      AppMethodBeat.o(51026);
      return paramContext;
    }
    AppMethodBeat.o(51026);
    return "offline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.q
 * JD-Core Version:    0.7.0.1
 */