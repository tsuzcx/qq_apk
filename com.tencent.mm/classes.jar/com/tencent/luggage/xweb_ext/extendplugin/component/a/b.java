package com.tencent.luggage.xweb_ext.extendplugin.component.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveBase;

public final class b
{
  private static boolean bFU;
  
  public static void xn()
  {
    AppMethodBeat.i(139750);
    if (bFU)
    {
      AppMethodBeat.o(139750);
      return;
    }
    TXLiveBase.setLogLevel(1);
    TXLiveBase.setConsoleEnabled(false);
    TXLiveBase.setListener(new b.1());
    bFU = true;
    AppMethodBeat.o(139750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b
 * JD-Core Version:    0.7.0.1
 */