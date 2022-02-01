package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;

public class b
  implements f
{
  private static b udB;
  private boolean gnW = false;
  private boolean udA = false;
  
  public static b cZC()
  {
    AppMethodBeat.i(89930);
    if (udB == null) {}
    try
    {
      if (udB == null) {
        udB = new b();
      }
      b localb = udB;
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
    this.gnW = false;
    g.ajj().b(1311, this);
    AppMethodBeat.o(89932);
  }
  
  public final void na(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(89931);
        if (paramBoolean)
        {
          i = 1;
          if (i == 0)
          {
            if (!o.fB(a.cZr()))
            {
              i = 1;
              break label182;
            }
          }
          else
          {
            if (!this.gnW)
            {
              ae.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
              release();
              this.gnW = true;
              this.udA = paramBoolean;
              g.ajR().ajA().set(am.a.IUL, Long.valueOf(0L));
              g.ajj().a(1311, this);
              c localc = new c();
              g.ajj().a(localc, 0);
            }
            AppMethodBeat.o(89931);
          }
        }
        else
        {
          long l = Math.abs(bu.rZ(bu.i((Long)g.ajR().ajA().get(am.a.IKF, Long.valueOf(0L)))));
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
      label182:
      if (i == 0) {}
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(89933);
    if (paramn.getType() == 1311)
    {
      ae.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (g.ajP().aiZ()) {
        break label67;
      }
      ae.w("MicroMsg.GameConfigUpdater", "account not init.");
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(89933);
      return;
      label67:
      ae.i("MicroMsg.GameConfigUpdater", "updateTime, isForceUpdate: %b", new Object[] { Boolean.valueOf(this.udA) });
      if (!this.udA) {
        g.ajR().ajA().set(am.a.IKF, Long.valueOf(bu.aRi()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */