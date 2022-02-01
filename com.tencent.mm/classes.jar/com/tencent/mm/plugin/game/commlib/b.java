package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;

public class b
  implements com.tencent.mm.ak.g
{
  private static b sWe;
  private boolean fRX = false;
  
  public static b cOz()
  {
    AppMethodBeat.i(89930);
    if (sWe == null) {}
    try
    {
      if (sWe == null) {
        sWe = new b();
      }
      b localb = sWe;
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
    this.fRX = false;
    com.tencent.mm.kernel.g.agi().b(1311, this);
    AppMethodBeat.o(89932);
  }
  
  public final void mE(boolean paramBoolean)
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
            if (!i.eA(a.cOs()))
            {
              i = 1;
              break label177;
            }
          }
          else
          {
            if (!this.fRX)
            {
              ac.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
              release();
              this.fRX = true;
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNV, Long.valueOf(0L));
              com.tencent.mm.kernel.g.agi().a(1311, this);
              c localc = new c();
              com.tencent.mm.kernel.g.agi().a(localc, 0);
            }
            AppMethodBeat.o(89931);
          }
        }
        else
        {
          long l = Math.abs(bs.pN(bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GDS, Long.valueOf(0L)))));
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
      label177:
      if (i == 0) {}
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(89933);
    if (paramn.getType() == 1311)
    {
      ac.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (com.tencent.mm.kernel.g.agP().afY()) {
        break label67;
      }
      ac.w("MicroMsg.GameConfigUpdater", "account not init.");
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(89933);
      return;
      label67:
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDS, Long.valueOf(bs.aNx()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */