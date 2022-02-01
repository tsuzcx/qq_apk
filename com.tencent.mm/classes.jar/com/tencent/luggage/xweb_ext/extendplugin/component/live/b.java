package com.tencent.luggage.xweb_ext.extendplugin.component.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class b
{
  private static boolean cEy;
  
  public static void PP()
  {
    AppMethodBeat.i(138810);
    if (cEy)
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
          Log.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 0: 
          Log.v(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 1: 
          Log.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 2: 
          Log.i(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 3: 
          Log.w(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 4: 
          Log.e(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        }
        Log.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(138809);
      }
    });
    cEy = true;
    AppMethodBeat.o(138810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.b
 * JD-Core Version:    0.7.0.1
 */