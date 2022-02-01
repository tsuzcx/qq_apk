package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class j
{
  private static boolean csj;
  
  public static void Gg()
  {
    AppMethodBeat.i(145902);
    if (csj)
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
          ae.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 0: 
          ae.v(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 1: 
          ae.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 2: 
          ae.i(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 3: 
          ae.w(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 4: 
          ae.e(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        }
        ae.f(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(145901);
      }
    });
    csj = true;
    AppMethodBeat.o(145902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.j
 * JD-Core Version:    0.7.0.1
 */