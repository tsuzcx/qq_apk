package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.f;
import com.tencent.mm.plugin.appbrand.jsapi.x.f.c;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class q
{
  public static final q mwK;
  
  static
  {
    AppMethodBeat.i(51027);
    mwK = new q();
    AppMethodBeat.o(51027);
  }
  
  public static final String dO(Context paramContext)
  {
    AppMethodBeat.i(51026);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ak.getContext();
    }
    paramContext = f.dx(localContext);
    switch (r.cqt[paramContext.ordinal()])
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.q
 * JD-Core Version:    0.7.0.1
 */