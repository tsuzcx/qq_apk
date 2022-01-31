package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.czs;
import com.tencent.mm.protocal.protobuf.czw;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandIDKeyBatchReport$b$3
  implements w.a
{
  AppBrandIDKeyBatchReport$b$3(LinkedList paramLinkedList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(132522);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppBrandIDKeyBatchReport.b.ga(((czs)paramb.fsW.fta).ygv);
      AppBrandIDKeyBatchReport.b.kM(AppBrandIDKeyBatchReport.b.AL());
    }
    for (;;)
    {
      AppMethodBeat.o(132522);
      return 0;
      paramString = this.iFw.iterator();
      while (paramString.hasNext()) {
        AppBrandIDKeyBatchReport.b.d((czw)paramString.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b.3
 * JD-Core Version:    0.7.0.1
 */