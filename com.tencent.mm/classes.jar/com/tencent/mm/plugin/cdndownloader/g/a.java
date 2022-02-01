package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
{
  private static volatile ap cPB;
  private static final Object mOt;
  
  static
  {
    AppMethodBeat.i(120817);
    mOt = new Object();
    AppMethodBeat.o(120817);
  }
  
  public static ap bZb()
  {
    AppMethodBeat.i(184035);
    if (cPB == null) {}
    synchronized (mOt)
    {
      if (cPB == null) {
        cPB = new ap("CDNDownloader#WorkThread");
      }
      ??? = cPB;
      AppMethodBeat.o(184035);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */