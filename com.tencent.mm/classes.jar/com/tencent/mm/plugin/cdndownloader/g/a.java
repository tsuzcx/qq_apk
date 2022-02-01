package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
{
  private static volatile MMHandler eYn;
  private static final Object rim;
  
  static
  {
    AppMethodBeat.i(120817);
    rim = new Object();
    AppMethodBeat.o(120817);
  }
  
  public static MMHandler cMC()
  {
    AppMethodBeat.i(184035);
    if (eYn == null) {}
    synchronized (rim)
    {
      if (eYn == null) {
        eYn = new MMHandler("CDNDownloader#WorkThread");
      }
      ??? = eYn;
      AppMethodBeat.o(184035);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */