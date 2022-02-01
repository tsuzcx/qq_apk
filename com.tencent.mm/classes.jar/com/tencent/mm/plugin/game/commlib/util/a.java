package com.tencent.mm.plugin.game.commlib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.g;

public final class a
{
  private static final Object ogA;
  private static volatile MMHandler xvA;
  
  static
  {
    AppMethodBeat.i(89962);
    ogA = new Object();
    AppMethodBeat.o(89962);
  }
  
  public static void bZm()
  {
    AppMethodBeat.i(89960);
    if (xvA == null)
    {
      AppMethodBeat.o(89960);
      return;
    }
    synchronized (ogA)
    {
      if (xvA != null)
      {
        g.boG("GameCommLib#WorkThread");
        xvA.quit();
        xvA = null;
      }
      AppMethodBeat.o(89960);
      return;
    }
  }
  
  public static MMHandler getWorkerHandler()
  {
    AppMethodBeat.i(184541);
    if (xvA == null) {}
    synchronized (ogA)
    {
      if (xvA == null)
      {
        xvA = new MMHandler("GameCommLib#WorkThread");
        g.a("GameCommLib#WorkThread", new com.tencent.mm.cd.a("GameCommLib#WorkThread"));
      }
      ??? = xvA;
      AppMethodBeat.o(184541);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.util.a
 * JD-Core Version:    0.7.0.1
 */