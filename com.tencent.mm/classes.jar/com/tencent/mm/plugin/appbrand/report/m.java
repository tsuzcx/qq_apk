package com.tencent.mm.plugin.appbrand.report;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r.d;
import com.tencent.mm.plugin.appbrand.jsapi.r.d.a;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class m
{
  public static final m iGe;
  
  static
  {
    AppMethodBeat.i(134943);
    iGe = new m();
    AppMethodBeat.o(134943);
  }
  
  public static final String da(Context paramContext)
  {
    AppMethodBeat.i(134942);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    paramContext = d.cM(localContext);
    switch (n.bLo[paramContext.ordinal()])
    {
    default: 
      paramContext = paramContext.value;
      j.p(paramContext, "type.value");
      AppMethodBeat.o(134942);
      return paramContext;
    }
    AppMethodBeat.o(134942);
    return "offline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.m
 * JD-Core Version:    0.7.0.1
 */