package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.u.f;
import com.tencent.mm.plugin.appbrand.jsapi.u.f.c;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class p
{
  public static final p lRW;
  
  static
  {
    AppMethodBeat.i(51027);
    lRW = new p();
    AppMethodBeat.o(51027);
  }
  
  public static final String dL(Context paramContext)
  {
    AppMethodBeat.i(51026);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ai.getContext();
    }
    paramContext = f.dv(localContext);
    switch (q.cfA[paramContext.ordinal()])
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.p
 * JD-Core Version:    0.7.0.1
 */