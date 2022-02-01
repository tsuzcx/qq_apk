package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.v.e;
import com.tencent.mm.plugin.appbrand.jsapi.v.e.c;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class q
{
  public static final q lqb;
  
  static
  {
    AppMethodBeat.i(51027);
    lqb = new q();
    AppMethodBeat.o(51027);
  }
  
  public static final String dC(Context paramContext)
  {
    AppMethodBeat.i(51026);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    paramContext = e.dm(localContext);
    switch (r.ciE[paramContext.ordinal()])
    {
    default: 
      paramContext = paramContext.value;
      k.g(paramContext, "type.value");
      AppMethodBeat.o(51026);
      return paramContext;
    }
    AppMethodBeat.o(51026);
    return "offline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.q
 * JD-Core Version:    0.7.0.1
 */