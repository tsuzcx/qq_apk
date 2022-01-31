package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class AppBrandOpReportLogic$b
{
  private static final SparseIntArray hVo;
  
  static
  {
    AppMethodBeat.i(102002);
    hVo = new SparseIntArray();
    AppMethodBeat.o(102002);
  }
  
  static void bh(String paramString, int paramInt)
  {
    AppMethodBeat.i(102001);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102001);
      return;
    }
    synchronized (hVo)
    {
      hVo.put(paramString.hashCode(), paramInt);
      AppMethodBeat.o(102001);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.b
 * JD-Core Version:    0.7.0.1
 */