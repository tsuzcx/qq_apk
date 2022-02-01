package com.tencent.mm.plugin.game.commlib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vending.h.g;

public final class a
{
  private static final Object mTx;
  private static volatile aq udO;
  
  static
  {
    AppMethodBeat.i(89962);
    mTx = new Object();
    AppMethodBeat.o(89962);
  }
  
  public static void bCi()
  {
    AppMethodBeat.i(89960);
    if (udO == null)
    {
      AppMethodBeat.o(89960);
      return;
    }
    synchronized (mTx)
    {
      if (udO != null)
      {
        g.aZB("GameCommLib#WorkThread");
        udO.quit();
        udO = null;
      }
      AppMethodBeat.o(89960);
      return;
    }
  }
  
  public static aq cZF()
  {
    AppMethodBeat.i(184541);
    if (udO == null) {}
    synchronized (mTx)
    {
      if (udO == null)
      {
        udO = new aq("GameCommLib#WorkThread");
        g.a("GameCommLib#WorkThread", new com.tencent.mm.cd.a("GameCommLib#WorkThread"));
      }
      ??? = udO;
      AppMethodBeat.o(184541);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.util.a
 * JD-Core Version:    0.7.0.1
 */