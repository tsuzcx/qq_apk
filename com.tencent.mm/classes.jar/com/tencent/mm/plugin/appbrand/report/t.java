package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.appbrand.jsapi.z.f.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class t
{
  public static final t nHN;
  
  static
  {
    AppMethodBeat.i(51027);
    nHN = new t();
    AppMethodBeat.o(51027);
  }
  
  public static final String el(Context paramContext)
  {
    AppMethodBeat.i(51026);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = f.dS(localContext);
    switch (u.$EnumSwitchMapping$0[paramContext.ordinal()])
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.t
 * JD-Core Version:    0.7.0.1
 */