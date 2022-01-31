package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveBase;

public final class j
{
  private static boolean bFU;
  
  public static void xn()
  {
    AppMethodBeat.i(96129);
    if (bFU)
    {
      AppMethodBeat.o(96129);
      return;
    }
    TXLiveBase.setLogLevel(1);
    TXLiveBase.setConsoleEnabled(false);
    TXLiveBase.setListener(new j.1());
    bFU = true;
    AppMethodBeat.o(96129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.j
 * JD-Core Version:    0.7.0.1
 */