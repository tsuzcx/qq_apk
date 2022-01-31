package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class b
  implements f
{
  private static b niU;
  private boolean fpN = false;
  
  public static b bFj()
  {
    AppMethodBeat.i(59399);
    if (niU == null) {}
    try
    {
      if (niU == null) {
        niU = new b();
      }
      b localb = niU;
      AppMethodBeat.o(59399);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(59399);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(59401);
    this.fpN = false;
    g.Rc().b(1311, this);
    AppMethodBeat.o(59401);
  }
  
  public final void hZ(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(59400);
        if (paramBoolean)
        {
          i = 1;
          if (i == 0)
          {
            if (!com.tencent.mm.vfs.e.cN(a.niS))
            {
              i = 1;
              break label158;
            }
          }
          else
          {
            if (!this.fpN)
            {
              ab.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
              release();
              this.fpN = true;
              g.Rc().a(1311, this);
              c localc = new c();
              g.Rc().a(localc, 0);
            }
            AppMethodBeat.o(59400);
          }
        }
        else
        {
          long l = bo.gz(bo.c((Long)g.RL().Ru().get(ac.a.yxK, Long.valueOf(0L))));
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
      label158:
      if (i == 0) {}
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(59402);
    if (paramm.getType() == 1311)
    {
      ab.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (g.RJ().QU()) {
        break label67;
      }
      ab.w("MicroMsg.GameConfigUpdater", "account not init.");
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(59402);
      return;
      label67:
      g.RL().Ru().set(ac.a.yxK, Long.valueOf(bo.aox()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */