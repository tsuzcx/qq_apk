package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;

public class b
  implements com.tencent.mm.al.g
{
  private static b rOn;
  private boolean fOm = false;
  
  public static b cBq()
  {
    AppMethodBeat.i(89930);
    if (rOn == null) {}
    try
    {
      if (rOn == null) {
        rOn = new b();
      }
      b localb = rOn;
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
    this.fOm = false;
    com.tencent.mm.kernel.g.aeS().b(1311, this);
    AppMethodBeat.o(89932);
  }
  
  public final void lL(boolean paramBoolean)
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
            if (!i.eK(a.cBj()))
            {
              i = 1;
              break label174;
            }
          }
          else
          {
            if (!this.fOm)
            {
              ad.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
              release();
              this.fOm = true;
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqf, Long.valueOf(0L));
              com.tencent.mm.kernel.g.aeS().a(1311, this);
              c localc = new c();
              com.tencent.mm.kernel.g.aeS().a(localc, 0);
            }
            AppMethodBeat.o(89931);
          }
        }
        else
        {
          long l = bt.lZ(bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fge, Long.valueOf(0L))));
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
      label174:
      if (i == 0) {}
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(89933);
    if (paramn.getType() == 1311)
    {
      ad.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (com.tencent.mm.kernel.g.afz().aeI()) {
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
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fge, Long.valueOf(bt.aGK()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */