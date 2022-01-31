package com.tencent.mm.lib.riskscanner.a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider;

public final class a
{
  public static Bundle bS(Context paramContext)
  {
    AppMethodBeat.i(114463);
    paramContext = paramContext.getContentResolver();
    try
    {
      paramContext = paramContext.call(RiskScannerReqBufferProvider.CONTENT_URI, "prepareReqBuffer", null, null);
      AppMethodBeat.o(114463);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(114463);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.a.a
 * JD-Core Version:    0.7.0.1
 */