package com.tencent.luggage.xweb_ext.extendplugin.component.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveBase;

public final class b
{
  private static boolean crG;
  
  public static void Ga()
  {
    AppMethodBeat.i(138810);
    if (crG)
    {
      AppMethodBeat.o(138810);
      return;
    }
    TXLiveBase.setLogLevel(1);
    TXLiveBase.setConsoleEnabled(false);
    TXLiveBase.setListener(new b.1());
    crG = true;
    AppMethodBeat.o(138810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b
 * JD-Core Version:    0.7.0.1
 */