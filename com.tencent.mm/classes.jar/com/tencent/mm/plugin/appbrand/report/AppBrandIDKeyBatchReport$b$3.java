package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.cmb;
import com.tencent.mm.protocal.c.cmf;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandIDKeyBatchReport$b$3
  implements w.a
{
  AppBrandIDKeyBatchReport$b$3(LinkedList paramLinkedList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppBrandIDKeyBatchReport.b.en(((cmb)paramb.ecF.ecN).tYZ);
      AppBrandIDKeyBatchReport.b.hZ(AppBrandIDKeyBatchReport.b.su());
    }
    for (;;)
    {
      return 0;
      paramString = this.gXt.iterator();
      while (paramString.hasNext()) {
        AppBrandIDKeyBatchReport.b.d((cmf)paramString.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b.3
 * JD-Core Version:    0.7.0.1
 */