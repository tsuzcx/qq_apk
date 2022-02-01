package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
{
  private static volatile MMHandler hbN;
  private static final Object uqi;
  
  static
  {
    AppMethodBeat.i(120817);
    uqi = new Object();
    AppMethodBeat.o(120817);
  }
  
  public static MMHandler dqg()
  {
    AppMethodBeat.i(184035);
    if (hbN == null) {}
    synchronized (uqi)
    {
      if (hbN == null) {
        hbN = new MMHandler("CDNDownloader#WorkThread");
      }
      ??? = hbN;
      AppMethodBeat.o(184035);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */