package com.tencent.mm.lib.riskscanner.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lib.riskscanner.RiskScannerReqBufferService;

public final class a
{
  public static Bundle dy(Context paramContext)
  {
    AppMethodBeat.i(138304);
    try
    {
      paramContext = RiskScannerReqBufferService.dx(paramContext);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(138304);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.a.a
 * JD-Core Version:    0.7.0.1
 */