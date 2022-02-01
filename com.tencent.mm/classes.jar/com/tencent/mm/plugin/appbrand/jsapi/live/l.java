package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class l
{
  private static boolean jxV = false;
  private static boolean oVO;
  
  public static void bSv()
  {
    AppMethodBeat.i(145902);
    if (oVO)
    {
      AppMethodBeat.o(145902);
      return;
    }
    TXLiveBase.setLogLevel(1);
    TXLiveBase.setConsoleEnabled(jxV);
    TXLiveBase.setListener(new ITXLiveBaseListener()
    {
      public final void OnLog(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(145901);
        switch (paramAnonymousInt)
        {
        default: 
          Log.d("MicroMsg.AppBrand.Live", paramAnonymousString1 + ": " + paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 0: 
          Log.v("MicroMsg.AppBrand.Live", paramAnonymousString1 + ": " + paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 1: 
          Log.d("MicroMsg.AppBrand.Live", paramAnonymousString1 + ": " + paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 2: 
          Log.i("MicroMsg.AppBrand.Live", paramAnonymousString1 + ": " + paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 3: 
          Log.w("MicroMsg.AppBrand.Live", paramAnonymousString1 + ": " + paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        case 4: 
          Log.e("MicroMsg.AppBrand.Live", paramAnonymousString1 + ": " + paramAnonymousString2);
          AppMethodBeat.o(145901);
          return;
        }
        Log.f("MicroMsg.AppBrand.Live", paramAnonymousString1 + ": " + paramAnonymousString2);
        AppMethodBeat.o(145901);
      }
    });
    oVO = true;
    AppMethodBeat.o(145902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.l
 * JD-Core Version:    0.7.0.1
 */