package com.tencent.mm.plugin.game.commlib.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.h.g;

public final class a
{
  private static final Object lLU;
  private static volatile ap rOz;
  
  static
  {
    AppMethodBeat.i(89962);
    lLU = new Object();
    AppMethodBeat.o(89962);
  }
  
  public static void bql()
  {
    AppMethodBeat.i(89960);
    if (rOz == null)
    {
      AppMethodBeat.o(89960);
      return;
    }
    synchronized (lLU)
    {
      if (rOz != null)
      {
        g.aMy("GameCommLib#WorkThread");
        rOz.quit();
        rOz = null;
      }
      AppMethodBeat.o(89960);
      return;
    }
  }
  
  public static ap cBt()
  {
    AppMethodBeat.i(184541);
    if (rOz == null) {}
    synchronized (lLU)
    {
      if (rOz == null)
      {
        rOz = new ap("GameCommLib#WorkThread");
        g.a("GameCommLib#WorkThread", new com.tencent.mm.cf.a("GameCommLib#WorkThread"));
      }
      ??? = rOz;
      AppMethodBeat.o(184541);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e.a
 * JD-Core Version:    0.7.0.1
 */