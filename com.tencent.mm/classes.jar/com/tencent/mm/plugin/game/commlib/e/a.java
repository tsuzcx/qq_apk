package com.tencent.mm.plugin.game.commlib.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.vending.h.g;

public final class a
{
  private static final Object mnR;
  private static volatile ao sWp;
  
  static
  {
    AppMethodBeat.i(89962);
    mnR = new Object();
    AppMethodBeat.o(89962);
  }
  
  public static void bxi()
  {
    AppMethodBeat.i(89960);
    if (sWp == null)
    {
      AppMethodBeat.o(89960);
      return;
    }
    synchronized (mnR)
    {
      if (sWp != null)
      {
        g.aSa("GameCommLib#WorkThread");
        sWp.quit();
        sWp = null;
      }
      AppMethodBeat.o(89960);
      return;
    }
  }
  
  public static ao cOC()
  {
    AppMethodBeat.i(184541);
    if (sWp == null) {}
    synchronized (mnR)
    {
      if (sWp == null)
      {
        sWp = new ao("GameCommLib#WorkThread");
        g.a("GameCommLib#WorkThread", new com.tencent.mm.ce.a("GameCommLib#WorkThread"));
      }
      ??? = sWp;
      AppMethodBeat.o(184541);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e.a
 * JD-Core Version:    0.7.0.1
 */