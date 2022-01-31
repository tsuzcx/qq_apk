package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class AdReportCgiHelper
{
  public static void a(int paramInt, String paramString, AdReportCgiHelper.a parama)
  {
    AppMethodBeat.i(132577);
    if (ah.brt())
    {
      ab(paramInt, paramString);
      if (parama != null)
      {
        parama.onDone();
        AppMethodBeat.o(132577);
      }
    }
    else
    {
      AdReportCgiHelper.AdReportCgiParams localAdReportCgiParams = new AdReportCgiHelper.AdReportCgiParams();
      AdReportCgiHelper.AdReportCgiParams.a(localAdReportCgiParams, paramInt);
      AdReportCgiHelper.AdReportCgiParams.a(localAdReportCgiParams, paramString);
      XIPCInvoker.a("com.tencent.mm", localAdReportCgiParams, AdReportCgiHelper.b.class, new AdReportCgiHelper.1(parama));
    }
    AppMethodBeat.o(132577);
  }
  
  static void ab(int paramInt, String paramString)
  {
    AppMethodBeat.i(132578);
    if (g.E(a.class) != null) {
      ((a)g.E(a.class)).j(paramInt, paramString, (int)bo.aox());
    }
    AppMethodBeat.o(132578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper
 * JD-Core Version:    0.7.0.1
 */