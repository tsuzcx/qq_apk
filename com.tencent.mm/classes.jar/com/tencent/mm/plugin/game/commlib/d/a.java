package com.tencent.mm.plugin.game.commlib.d;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.h.g;

public final class a
{
  private static volatile al ftB;
  private static final Object iXt;
  
  static
  {
    AppMethodBeat.i(59425);
    iXt = new Object();
    AppMethodBeat.o(59425);
  }
  
  public static void aNR()
  {
    AppMethodBeat.i(59424);
    if (ftB == null)
    {
      AppMethodBeat.o(59424);
      return;
    }
    synchronized (iXt)
    {
      if (ftB != null)
      {
        g.avC("GameCommLib#WorkThread");
        ftB.oNc.quit();
        ftB = null;
      }
      AppMethodBeat.o(59424);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d.a
 * JD-Core Version:    0.7.0.1
 */