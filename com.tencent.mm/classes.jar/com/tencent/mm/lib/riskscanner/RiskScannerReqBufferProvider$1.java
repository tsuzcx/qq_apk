package com.tencent.mm.lib.riskscanner;

import android.os.Bundle;
import com.tencent.e.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RiskScannerReqBufferProvider$1
  implements c.a
{
  RiskScannerReqBufferProvider$1(RiskScannerReqBufferProvider paramRiskScannerReqBufferProvider, Bundle[] paramArrayOfBundle) {}
  
  public final void f(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114458);
    a.jU(paramInt);
    Bundle[] arrayOfBundle = this.eMB;
    Bundle localBundle = new Bundle();
    arrayOfBundle[0] = localBundle;
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localBundle.putInt("errCode", paramInt);
      localBundle.putByteArray("reqBufferBase64", paramArrayOfByte);
    }
    AppMethodBeat.o(114458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider.1
 * JD-Core Version:    0.7.0.1
 */