package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;

public class b
  implements com.tencent.mm.am.h
{
  private static b IsP;
  private boolean IsO = false;
  private boolean mjj = false;
  
  public static b fEb()
  {
    AppMethodBeat.i(89930);
    if (IsP == null) {}
    try
    {
      if (IsP == null) {
        IsP = new b();
      }
      b localb = IsP;
      AppMethodBeat.o(89930);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(89930);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(89932);
    this.mjj = false;
    com.tencent.mm.kernel.h.aZW().b(1311, this);
    AppMethodBeat.o(89932);
  }
  
  public final void V(boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(275343);
        if (paramBoolean)
        {
          i = 1;
          if (i == 0)
          {
            if (!y.ZC(a.fDP()))
            {
              i = 1;
              break label185;
            }
          }
          else
          {
            if (!this.mjj)
            {
              Log.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
              release();
              this.mjj = true;
              this.IsO = paramBoolean;
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acSI, Long.valueOf(0L));
              com.tencent.mm.kernel.h.aZW().a(1311, this);
              c localc = new c(paramInt);
              com.tencent.mm.kernel.h.aZW().a(localc, 0);
            }
            AppMethodBeat.o(275343);
          }
        }
        else
        {
          long l = Math.abs(Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acHQ, Long.valueOf(0L)))));
          if (l > 86400L)
          {
            i = 1;
            continue;
          }
          i = 0;
          continue;
        }
        i = 0;
      }
      finally {}
      label185:
      if (i == 0) {}
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(89933);
    if (paramp.getType() == 1311)
    {
      Log.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (com.tencent.mm.kernel.h.baC().aZN()) {
        break label67;
      }
      Log.w("MicroMsg.GameConfigUpdater", "account not init.");
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(89933);
      return;
      label67:
      Log.i("MicroMsg.GameConfigUpdater", "updateTime, isForceUpdate: %b", new Object[] { Boolean.valueOf(this.IsO) });
      if (!this.IsO) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acHQ, Long.valueOf(Util.nowSecond()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */