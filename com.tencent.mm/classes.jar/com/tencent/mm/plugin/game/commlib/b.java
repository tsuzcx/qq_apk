package com.tencent.mm.plugin.game.commlib;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class b
  implements f
{
  private static b kMa;
  private boolean dZI = false;
  
  public static b aYr()
  {
    if (kMa == null) {}
    try
    {
      if (kMa == null) {
        kMa = new b();
      }
      return kMa;
    }
    finally {}
  }
  
  private void release()
  {
    this.dZI = false;
    g.Dk().b(1311, this);
  }
  
  public final void gu(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        if (!this.dZI)
        {
          y.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[] { Boolean.valueOf(paramBoolean) });
          release();
          this.dZI = true;
          g.Dk().a(1311, this);
          c localc = new c();
          g.Dk().a(localc, 0);
        }
        return;
      }
      finally {}
      long l = bk.cn(Long.valueOf(bk.c((Long)g.DP().Dz().get(ac.a.unT, Long.valueOf(0L)))).longValue());
      if (l > 86400L) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 1311)
    {
      y.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (g.DN().Dc()) {
        break label57;
      }
      y.w("MicroMsg.GameConfigUpdater", "account not init.");
    }
    for (;;)
    {
      release();
      return;
      label57:
      g.DP().Dz().c(ac.a.unT, Long.valueOf(bk.UX()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b
 * JD-Core Version:    0.7.0.1
 */