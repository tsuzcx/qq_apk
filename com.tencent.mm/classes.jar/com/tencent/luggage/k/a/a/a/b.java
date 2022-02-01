package com.tencent.luggage.k.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class b
{
  private static boolean ckp;
  
  public static void EX()
  {
    AppMethodBeat.i(138810);
    if (ckp)
    {
      AppMethodBeat.o(138810);
      return;
    }
    TXLiveBase.setLogLevel(1);
    TXLiveBase.setConsoleEnabled(false);
    TXLiveBase.setListener(new ITXLiveBaseListener()
    {
      public final void OnLog(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(138809);
        switch (paramAnonymousInt)
        {
        default: 
          ad.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 0: 
          ad.v(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 1: 
          ad.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 2: 
          ad.i(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 3: 
          ad.w(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 4: 
          ad.e(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        }
        ad.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(138809);
      }
    });
    ckp = true;
    AppMethodBeat.o(138810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */