package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLiveBaseListener;

final class j$1
  implements ITXLiveBaseListener
{
  public final void OnLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96128);
    switch (paramInt)
    {
    default: 
      ab.d(paramString1, paramString2);
      AppMethodBeat.o(96128);
      return;
    case 0: 
      ab.v(paramString1, paramString2);
      AppMethodBeat.o(96128);
      return;
    case 1: 
      ab.d(paramString1, paramString2);
      AppMethodBeat.o(96128);
      return;
    case 2: 
      ab.i(paramString1, paramString2);
      AppMethodBeat.o(96128);
      return;
    case 3: 
      ab.w(paramString1, paramString2);
      AppMethodBeat.o(96128);
      return;
    case 4: 
      ab.e(paramString1, paramString2);
      AppMethodBeat.o(96128);
      return;
    }
    ab.f(paramString1, paramString2);
    AppMethodBeat.o(96128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.j.1
 * JD-Core Version:    0.7.0.1
 */