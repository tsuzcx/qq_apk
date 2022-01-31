package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.j;

public final class AppBrandIDKeyBatchReport
{
  private static volatile AppBrandIDKeyBatchReport.IDKeyBatchReportTask iFl;
  
  public static void a(czw paramczw)
  {
    AppMethodBeat.i(132535);
    if (ah.brt())
    {
      AppBrandIDKeyBatchReport.b.c(paramczw);
      AppMethodBeat.o(132535);
      return;
    }
    a.b(paramczw);
    AppMethodBeat.o(132535);
  }
  
  public static AppBrandIDKeyBatchReport.IDKeyBatchReportTask aKS()
  {
    AppMethodBeat.i(132533);
    if (iFl == null) {
      iFl = new AppBrandIDKeyBatchReport.IDKeyBatchReportTask();
    }
    AppBrandIDKeyBatchReport.IDKeyBatchReportTask localIDKeyBatchReportTask = iFl;
    AppMethodBeat.o(132533);
    return localIDKeyBatchReportTask;
  }
  
  static String aKT()
  {
    AppMethodBeat.i(132534);
    if (!g.RG())
    {
      localObject = new b();
      AppMethodBeat.o(132534);
      throw ((Throwable)localObject);
    }
    String str = g.RL().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/report/";
    j.akQ((String)localObject);
    AppMethodBeat.o(132534);
    return localObject;
  }
  
  static final class a
  {
    private static final byte[] iFm = new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */