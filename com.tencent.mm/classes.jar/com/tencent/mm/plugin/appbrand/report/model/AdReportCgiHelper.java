package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class AdReportCgiHelper
{
  static void O(int paramInt, String paramString)
  {
    if (g.r(a.class) != null) {
      ((a)g.r(a.class)).g(paramInt, paramString, (int)bk.UX());
    }
  }
  
  public static void a(int paramInt, String paramString, AdReportCgiHelper.a parama)
  {
    if (ae.cqV())
    {
      O(paramInt, paramString);
      if (parama != null) {
        parama.onDone();
      }
      return;
    }
    AdReportCgiHelper.AdReportCgiParams localAdReportCgiParams = new AdReportCgiHelper.AdReportCgiParams();
    AdReportCgiHelper.AdReportCgiParams.a(localAdReportCgiParams, paramInt);
    AdReportCgiHelper.AdReportCgiParams.a(localAdReportCgiParams, paramString);
    XIPCInvoker.a("com.tencent.mm", localAdReportCgiParams, AdReportCgiHelper.b.class, new AdReportCgiHelper.1(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper
 * JD-Core Version:    0.7.0.1
 */