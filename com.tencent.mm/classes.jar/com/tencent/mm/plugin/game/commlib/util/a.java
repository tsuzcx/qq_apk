package com.tencent.mm.plugin.game.commlib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.h.g;

public final class a
{
  private static final Object mOt;
  private static volatile ap tSX;
  
  static
  {
    AppMethodBeat.i(89962);
    mOt = new Object();
    AppMethodBeat.o(89962);
  }
  
  public static void bBo()
  {
    AppMethodBeat.i(89960);
    if (tSX == null)
    {
      AppMethodBeat.o(89960);
      return;
    }
    synchronized (mOt)
    {
      if (tSX != null)
      {
        g.aXZ("GameCommLib#WorkThread");
        tSX.quit();
        tSX = null;
      }
      AppMethodBeat.o(89960);
      return;
    }
  }
  
  public static ap cWY()
  {
    AppMethodBeat.i(184541);
    if (tSX == null) {}
    synchronized (mOt)
    {
      if (tSX == null)
      {
        tSX = new ap("GameCommLib#WorkThread");
        g.a("GameCommLib#WorkThread", new com.tencent.mm.ce.a("GameCommLib#WorkThread"));
      }
      ??? = tSX;
      AppMethodBeat.o(184541);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.util.a
 * JD-Core Version:    0.7.0.1
 */