package com.tencent.luggage.xweb_ext.extendplugin.component.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.ITXLiveBaseListener;

final class b$1
  implements ITXLiveBaseListener
{
  public final void OnLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138809);
    switch (paramInt)
    {
    default: 
      ad.d(paramString1, paramString2);
      AppMethodBeat.o(138809);
      return;
    case 0: 
      ad.v(paramString1, paramString2);
      AppMethodBeat.o(138809);
      return;
    case 1: 
      ad.d(paramString1, paramString2);
      AppMethodBeat.o(138809);
      return;
    case 2: 
      ad.i(paramString1, paramString2);
      AppMethodBeat.o(138809);
      return;
    case 3: 
      ad.w(paramString1, paramString2);
      AppMethodBeat.o(138809);
      return;
    case 4: 
      ad.e(paramString1, paramString2);
      AppMethodBeat.o(138809);
      return;
    }
    ad.e(paramString1, paramString2);
    AppMethodBeat.o(138809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.1
 * JD-Core Version:    0.7.0.1
 */