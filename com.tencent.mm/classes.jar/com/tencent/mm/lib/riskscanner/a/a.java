package com.tencent.mm.lib.riskscanner.a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider;

public final class a
{
  public static Bundle bo(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    try
    {
      paramContext = paramContext.call(RiskScannerReqBufferProvider.CONTENT_URI, "prepareReqBuffer", null, null);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.a.a
 * JD-Core Version:    0.7.0.1
 */