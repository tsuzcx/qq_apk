package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;

public class b
  implements i
{
  private static b xvn;
  private boolean gYQ = false;
  private boolean xvm = false;
  
  public static b dTd()
  {
    AppMethodBeat.i(89930);
    if (xvn == null) {}
    try
    {
      if (xvn == null) {
        xvn = new b();
      }
      b localb = xvn;
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
    this.gYQ = false;
    g.azz().b(1311, this);
    AppMethodBeat.o(89932);
  }
  
  public final void I(boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(201263);
        if (paramBoolean)
        {
          i = 1;
          if (i == 0)
          {
            if (!s.YS(a.dSR()))
            {
              i = 1;
              break label185;
            }
          }
          else
          {
            if (!this.gYQ)
            {
              Log.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
              release();
              this.gYQ = true;
              this.xvm = paramBoolean;
              g.aAh().azQ().set(ar.a.OcZ, Long.valueOf(0L));
              g.azz().a(1311, this);
              c localc = new c(paramInt);
              g.azz().a(localc, 0);
            }
            AppMethodBeat.o(201263);
          }
        }
        else
        {
          long l = Math.abs(Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(ar.a.NSD, Long.valueOf(0L)))));
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
      if (g.aAf().azp()) {
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
      Log.i("MicroMsg.GameConfigUpdater", "updateTime, isForceUpdate: %b", new Object[] { Boolean.valueOf(this.xvm) });
      if (!this.xvm) {
        g.aAh().azQ().set(ar.a.NSD, Long.valueOf(Util.nowSecond()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */