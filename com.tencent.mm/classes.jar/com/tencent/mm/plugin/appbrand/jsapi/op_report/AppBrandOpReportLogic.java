package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class AppBrandOpReportLogic
{
  public static final class b
  {
    private static final SparseIntArray kdI;
    
    static
    {
      AppMethodBeat.i(147206);
      kdI = new SparseIntArray();
      AppMethodBeat.o(147206);
    }
    
    static void bx(String paramString, int paramInt)
    {
      AppMethodBeat.i(147205);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(147205);
        return;
      }
      synchronized (kdI)
      {
        kdI.put(paramString.hashCode(), paramInt);
        AppMethodBeat.o(147205);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic
 * JD-Core Version:    0.7.0.1
 */