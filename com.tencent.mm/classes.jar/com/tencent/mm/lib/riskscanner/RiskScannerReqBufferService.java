package com.tencent.mm.lib.riskscanner;

import android.content.Context;
import android.os.Bundle;
import com.tencent.e.a.c;
import com.tencent.e.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.HotpotService;
import com.tencent.mm.util.HotpotService.b;
import com.tencent.mm.util.HotpotService.c;

@m
public class RiskScannerReqBufferService
  extends HotpotService
{
  public static Bundle dx(Context paramContext)
  {
    AppMethodBeat.i(231744);
    try
    {
      paramContext = HotpotService.a(paramContext, RiskScannerReqBufferService.class, 1, null);
      AppMethodBeat.o(231744);
      return paramContext;
    }
    catch (HotpotService.c paramContext)
    {
      Log.printErrStackTrace("MicroMsg.RiskScannerReqBufferService", paramContext.agtr, "Fail to prepare req buffer.", new Object[0]);
      AppMethodBeat.o(231744);
      return null;
    }
    catch (HotpotService.b paramContext)
    {
      Log.printErrStackTrace("MicroMsg.RiskScannerReqBufferService", paramContext, "Fail to prepare req buffer.", new Object[0]);
      AppMethodBeat.o(231744);
    }
    return null;
  }
  
  public final void a(int paramInt, Bundle paramBundle1, final Bundle paramBundle2)
  {
    AppMethodBeat.i(231746);
    if (paramInt == 1)
    {
      Log.i("MicroMsg.RiskScannerReqBufferService", "invoke with op: %s, with arg: %s", new Object[] { Integer.valueOf(paramInt), paramBundle1 });
      paramBundle1 = getApplicationContext();
      try
      {
        a.bca();
        c.a(paramBundle1, new c.a()
        {
          public final void g(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
          {
            AppMethodBeat.i(231745);
            a.sK(paramAnonymousInt);
            if ((paramAnonymousInt == 0) && (paramAnonymousArrayOfByte != null))
            {
              paramBundle2.putInt("errCode", paramAnonymousInt);
              paramBundle2.putByteArray("reqBufferBase64", paramAnonymousArrayOfByte);
            }
            AppMethodBeat.o(231745);
          }
        });
        AppMethodBeat.o(231746);
        return;
      }
      finally
      {
        a.p(paramBundle1);
      }
    }
    AppMethodBeat.o(231746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.RiskScannerReqBufferService
 * JD-Core Version:    0.7.0.1
 */