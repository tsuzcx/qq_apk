package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;

public class b
  implements f
{
  private static b tSK;
  private boolean glB = false;
  private boolean tSJ = false;
  
  public static b cWV()
  {
    AppMethodBeat.i(89930);
    if (tSK == null) {}
    try
    {
      if (tSK == null) {
        tSK = new b();
      }
      b localb = tSK;
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
    this.glB = false;
    g.aiU().b(1311, this);
    AppMethodBeat.o(89932);
  }
  
  public final void mW(boolean paramBoolean)
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
            if (!i.fv(a.cWN()))
            {
              i = 1;
              break label182;
            }
          }
          else
          {
            if (!this.glB)
            {
              ad.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
              release();
              this.glB = true;
              this.tSJ = paramBoolean;
              g.ajC().ajl().set(al.a.IAm, Long.valueOf(0L));
              g.aiU().a(1311, this);
              c localc = new c();
              g.aiU().a(localc, 0);
            }
            AppMethodBeat.o(89931);
          }
        }
        else
        {
          long l = Math.abs(bt.rM(bt.g((Long)g.ajC().ajl().get(al.a.Iql, Long.valueOf(0L)))));
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
      ad.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (g.ajA().aiK()) {
        break label67;
      }
      ad.w("MicroMsg.GameConfigUpdater", "account not init.");
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(89933);
      return;
      label67:
      ad.i("MicroMsg.GameConfigUpdater", "updateTime, isForceUpdate: %b", new Object[] { Boolean.valueOf(this.tSJ) });
      if (!this.tSJ) {
        g.ajC().ajl().set(al.a.Iql, Long.valueOf(bt.aQJ()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */