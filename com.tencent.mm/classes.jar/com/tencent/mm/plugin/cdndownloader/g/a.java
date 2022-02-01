package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
{
  private static volatile ap cHo;
  private static final Object lLU;
  
  static
  {
    AppMethodBeat.i(120817);
    lLU = new Object();
    AppMethodBeat.o(120817);
  }
  
  public static ap bNl()
  {
    AppMethodBeat.i(184035);
    if (cHo == null) {}
    synchronized (lLU)
    {
      if (cHo == null) {
        cHo = new ap("CDNDownloader#WorkThread");
      }
      ??? = cHo;
      AppMethodBeat.o(184035);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */