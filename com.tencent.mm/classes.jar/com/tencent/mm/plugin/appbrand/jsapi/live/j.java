package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class j
{
  private static boolean ckp;
  
  public static void EX()
  {
    AppMethodBeat.i(145902);
    if (ckp)
    {
      AppMethodBeat.o(145902);
      return;
    }
    TXLiveBase.setLogLevel(1);
    TXLiveBase.setConsoleEnabled(false);
    TXLiveBase.setListener(new ITXLiveBaseListener()
    {
      public final void OnLog(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(145901);
        switch (paramAnonymousInt)
        {
        default: 
          ad.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 0: 
          ad.v(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 1: 
          ad.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 2: 
          ad.i(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 3: 
          ad.w(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 4: 
          ad.e(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        }
        ad.f(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(145901);
      }
    });
    ckp = true;
    AppMethodBeat.o(145902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.j
 * JD-Core Version:    0.7.0.1
 */