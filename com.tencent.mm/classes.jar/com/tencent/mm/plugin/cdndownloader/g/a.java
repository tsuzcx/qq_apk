package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;

public final class a
{
  private static volatile aq cQl;
  private static final Object mTx;
  
  static
  {
    AppMethodBeat.i(120817);
    mTx = new Object();
    AppMethodBeat.o(120817);
  }
  
  public static aq caq()
  {
    AppMethodBeat.i(184035);
    if (cQl == null) {}
    synchronized (mTx)
    {
      if (cQl == null) {
        cQl = new aq("CDNDownloader#WorkThread");
      }
      ??? = cQl;
      AppMethodBeat.o(184035);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */