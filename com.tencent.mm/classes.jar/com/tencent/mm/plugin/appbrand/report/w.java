package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w tOF;
  
  static
  {
    AppMethodBeat.i(51027);
    tOF = new w();
    AppMethodBeat.o(51027);
  }
  
  public static final String fg(Context paramContext)
  {
    AppMethodBeat.i(51026);
    if (paramContext == null) {
      MMApplicationContext.getContext();
    }
    paramContext = k.cuM();
    if (a.$EnumSwitchMapping$0[paramContext.ordinal()] == 1) {}
    for (paramContext = "offline";; paramContext = paramContext.value)
    {
      s.s(paramContext, "getNetworkType(context?:…e\n            }\n        }");
      AppMethodBeat.o(51026);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.w
 * JD-Core Version:    0.7.0.1
 */