package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.protocal.c.cmf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;

public final class AppBrandIDKeyBatchReport
{
  private static volatile AppBrandIDKeyBatchReport.IDKeyBatchReportTask gXi;
  
  public static void a(cmf paramcmf)
  {
    if (ae.cqV())
    {
      AppBrandIDKeyBatchReport.b.c(paramcmf);
      return;
    }
    a.b(paramcmf);
  }
  
  public static AppBrandIDKeyBatchReport.IDKeyBatchReportTask anU()
  {
    if (gXi == null) {
      gXi = new AppBrandIDKeyBatchReport.IDKeyBatchReportTask();
    }
    return gXi;
  }
  
  static String anV()
  {
    if (!g.DK()) {
      throw new b();
    }
    String str2 = g.DP().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/report/";
    h.Vu(str1);
    return str1;
  }
  
  private static final class a
  {
    private static final byte[] gXj = new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */