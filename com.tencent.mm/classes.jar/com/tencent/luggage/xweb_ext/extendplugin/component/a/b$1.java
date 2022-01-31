package com.tencent.luggage.xweb_ext.extendplugin.component.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLiveBaseListener;

final class b$1
  implements ITXLiveBaseListener
{
  public final void OnLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(139749);
    switch (paramInt)
    {
    default: 
      ab.d(paramString1, paramString2);
      AppMethodBeat.o(139749);
      return;
    case 0: 
      ab.v(paramString1, paramString2);
      AppMethodBeat.o(139749);
      return;
    case 1: 
      ab.d(paramString1, paramString2);
      AppMethodBeat.o(139749);
      return;
    case 2: 
      ab.i(paramString1, paramString2);
      AppMethodBeat.o(139749);
      return;
    case 3: 
      ab.w(paramString1, paramString2);
      AppMethodBeat.o(139749);
      return;
    case 4: 
      ab.e(paramString1, paramString2);
      AppMethodBeat.o(139749);
      return;
    }
    ab.e(paramString1, paramString2);
    AppMethodBeat.o(139749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.1
 * JD-Core Version:    0.7.0.1
 */