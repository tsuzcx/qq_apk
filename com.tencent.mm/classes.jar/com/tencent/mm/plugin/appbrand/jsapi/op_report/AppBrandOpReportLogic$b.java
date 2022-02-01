package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class AppBrandOpReportLogic$b
{
  private static final SparseIntArray leo;
  
  static
  {
    AppMethodBeat.i(147206);
    leo = new SparseIntArray();
    AppMethodBeat.o(147206);
  }
  
  static void bH(String paramString, int paramInt)
  {
    AppMethodBeat.i(147205);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147205);
      return;
    }
    synchronized (leo)
    {
      leo.put(paramString.hashCode(), paramInt);
      AppMethodBeat.o(147205);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.b
 * JD-Core Version:    0.7.0.1
 */