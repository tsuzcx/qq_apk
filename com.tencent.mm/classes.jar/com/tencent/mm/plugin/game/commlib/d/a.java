package com.tencent.mm.plugin.game.commlib.d;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.h.g;

public final class a
{
  private static volatile ai edy;
  private static final Object hkZ = new Object();
  
  public static void aqp()
  {
    if (edy == null) {
      return;
    }
    synchronized (hkZ)
    {
      if (edy != null)
      {
        g.aeK("GameCommLib#WorkThread");
        edy.mnU.quit();
        edy = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.d.a
 * JD-Core Version:    0.7.0.1
 */