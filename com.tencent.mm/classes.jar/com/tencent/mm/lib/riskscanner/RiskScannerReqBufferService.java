package com.tencent.mm.lib.riskscanner;

import android.content.Context;
import android.os.Bundle;
import com.tencent.d.a.c;
import com.tencent.d.a.c.a;
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
  public static Bundle cI(Context paramContext)
  {
    AppMethodBeat.i(233275);
    try
    {
      paramContext = HotpotService.a(paramContext, RiskScannerReqBufferService.class, 1, null);
      AppMethodBeat.o(233275);
      return paramContext;
    }
    catch (HotpotService.c paramContext)
    {
      Log.printErrStackTrace("MicroMsg.RiskScannerReqBufferService", paramContext.YyT, "Fail to prepare req buffer.", new Object[0]);
      AppMethodBeat.o(233275);
      return null;
    }
    catch (HotpotService.b paramContext)
    {
      Log.printErrStackTrace("MicroMsg.RiskScannerReqBufferService", paramContext, "Fail to prepare req buffer.", new Object[0]);
      AppMethodBeat.o(233275);
    }
    return null;
  }
  
  public final void a(int paramInt, Bundle paramBundle1, final Bundle paramBundle2)
  {
    AppMethodBeat.i(233278);
    if (paramInt == 1)
    {
      Log.i("MicroMsg.RiskScannerReqBufferService", "invoke with op: %s, with arg: %s", new Object[] { Integer.valueOf(paramInt), paramBundle1 });
      paramBundle1 = getApplicationContext();
      try
      {
        a.aJd();
        c.a(paramBundle1, new c.a()
        {
          public final void g(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
          {
            AppMethodBeat.i(233429);
            a.sN(paramAnonymousInt);
            if ((paramAnonymousInt == 0) && (paramAnonymousArrayOfByte != null))
            {
              paramBundle2.putInt("errCode", paramAnonymousInt);
              paramBundle2.putByteArray("reqBufferBase64", paramAnonymousArrayOfByte);
            }
            AppMethodBeat.o(233429);
          }
        });
        AppMethodBeat.o(233278);
        return;
      }
      catch (Throwable paramBundle1)
      {
        a.f(paramBundle1);
      }
    }
    AppMethodBeat.o(233278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.RiskScannerReqBufferService
 * JD-Core Version:    0.7.0.1
 */