package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;

public class b
  implements i
{
  private static b Czd;
  private boolean Czc = false;
  private boolean jJQ = false;
  
  public static b ewm()
  {
    AppMethodBeat.i(89930);
    if (Czd == null) {}
    try
    {
      if (Czd == null) {
        Czd = new b();
      }
      b localb = Czd;
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
    this.jJQ = false;
    h.aGY().b(1311, this);
    AppMethodBeat.o(89932);
  }
  
  public final void T(boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(188509);
        if (paramBoolean)
        {
          i = 1;
          if (i == 0)
          {
            if (!u.agG(a.evZ()))
            {
              i = 1;
              break label185;
            }
          }
          else
          {
            if (!this.jJQ)
            {
              Log.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
              release();
              this.jJQ = true;
              this.Czc = paramBoolean;
              h.aHG().aHp().set(ar.a.Vrg, Long.valueOf(0L));
              h.aGY().a(1311, this);
              c localc = new c(paramInt);
              h.aGY().a(localc, 0);
            }
            AppMethodBeat.o(188509);
          }
        }
        else
        {
          long l = Math.abs(Util.secondsToNow(Util.nullAsNil((Long)h.aHG().aHp().get(ar.a.VgB, Long.valueOf(0L)))));
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(89933);
    if (paramq.getType() == 1311)
    {
      Log.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (h.aHE().aGM()) {
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
      Log.i("MicroMsg.GameConfigUpdater", "updateTime, isForceUpdate: %b", new Object[] { Boolean.valueOf(this.Czc) });
      if (!this.Czc) {
        h.aHG().aHp().set(ar.a.VgB, Long.valueOf(Util.nowSecond()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */