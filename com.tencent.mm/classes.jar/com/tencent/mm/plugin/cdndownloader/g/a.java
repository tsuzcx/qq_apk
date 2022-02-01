package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
{
  private static volatile MMHandler dgG;
  private static final Object ogA;
  
  static
  {
    AppMethodBeat.i(120817);
    ogA = new Object();
    AppMethodBeat.o(120817);
  }
  
  public static MMHandler cyh()
  {
    AppMethodBeat.i(184035);
    if (dgG == null) {}
    synchronized (ogA)
    {
      if (dgG == null) {
        dgG = new MMHandler("CDNDownloader#WorkThread");
      }
      ??? = dgG;
      AppMethodBeat.o(184035);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */