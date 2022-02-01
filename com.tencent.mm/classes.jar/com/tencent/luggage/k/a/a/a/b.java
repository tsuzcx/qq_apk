package com.tencent.luggage.k.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class b
{
  private static boolean cho;
  
  public static void EB()
  {
    AppMethodBeat.i(138810);
    if (cho)
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
          ac.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 0: 
          ac.v(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 1: 
          ac.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 2: 
          ac.i(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 3: 
          ac.w(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        case 4: 
          ac.e(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(138809);
          return;
        }
        ac.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(138809);
      }
    });
    cho = true;
    AppMethodBeat.o(138810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */