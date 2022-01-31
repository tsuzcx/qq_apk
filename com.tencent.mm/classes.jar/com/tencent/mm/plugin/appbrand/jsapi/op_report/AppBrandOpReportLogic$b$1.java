package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.blk;

final class AppBrandOpReportLogic$b$1
  implements w.a
{
  AppBrandOpReportLogic$b$1(String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (blk)paramb.ecF.ecN;
      if (paramString != null) {
        AppBrandOpReportLogic.b.aR(this.val$appId, paramString.tEW);
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.b.1
 * JD-Core Version:    0.7.0.1
 */