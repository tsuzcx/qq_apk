package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/report/AppBrandRuntimeReloadReasonEnum;", "", "stringValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "NeedLatestVersion", "LocalVersionFallback", "UpdateApp", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  public final String stringValue;
  
  static
  {
    AppMethodBeat.i(321199);
    teU = new a("NeedLatestVersion", 0, "NeedLatestVersion");
    teV = new a("LocalVersionFallback", 1, "LocalVersionFallback");
    teW = new a("UpdateApp", 2, "updateApp");
    teX = new a[] { teU, teV, teW };
    AppMethodBeat.o(321199);
  }
  
  private a(String paramString)
  {
    this.stringValue = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.a
 * JD-Core Version:    0.7.0.1
 */