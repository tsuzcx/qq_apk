package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;

public final class a
{
  private static volatile ao cEw;
  private static final Object mnR;
  
  static
  {
    AppMethodBeat.i(120817);
    mnR = new Object();
    AppMethodBeat.o(120817);
  }
  
  public static ao bUw()
  {
    AppMethodBeat.i(184035);
    if (cEw == null) {}
    synchronized (mnR)
    {
      if (cEw == null) {
        cEw = new ao("CDNDownloader#WorkThread");
      }
      ??? = cEw;
      AppMethodBeat.o(184035);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */