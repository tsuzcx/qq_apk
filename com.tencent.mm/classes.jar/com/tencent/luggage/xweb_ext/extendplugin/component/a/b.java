package com.tencent.luggage.xweb_ext.extendplugin.component.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class b
{
  private static boolean csj;
  
  public static void Gg()
  {
    AppMethodBeat.i(138810);
    if (csj)
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
          ae.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 0: 
          ae.v(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 1: 
          ae.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 2: 
          ae.i(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 3: 
          ae.w(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 4: 
          ae.e(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        }
        ae.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(138809);
      }
    });
    csj = true;
    AppMethodBeat.o(138810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b
 * JD-Core Version:    0.7.0.1
 */