package com.tencent.mm.lib.riskscanner.a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider;

public final class a
{
  public static Bundle cr(Context paramContext)
  {
    AppMethodBeat.i(138304);
    paramContext = paramContext.getContentResolver();
    try
    {
      paramContext = paramContext.call(RiskScannerReqBufferProvider.CONTENT_URI, "prepareReqBuffer", null, null);
      AppMethodBeat.o(138304);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(138304);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.a.a
 * JD-Core Version:    0.7.0.1
 */