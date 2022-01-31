package com.tencent.mm.az;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class c
  implements f
{
  private static c eww;
  private boolean dZI = false;
  private int ewv = 3;
  
  public static c PE()
  {
    if (eww == null) {
      eww = new c();
    }
    return eww;
  }
  
  private void release()
  {
    this.dZI = false;
    g.DO().dJT.b(159, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 159)
    {
      y.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label66;
      }
      g.DP().Dz().o(81938, Long.valueOf(bk.UX()));
    }
    for (;;)
    {
      release();
      return;
      label66:
      paramInt1 = this.ewv - 1;
      this.ewv = paramInt1;
      if (paramInt1 < 0)
      {
        g.DP().Dz().o(81938, Long.valueOf((bk.UY() - 86400000L + 3600000L) / 1000L));
        this.ewv = 3;
      }
    }
  }
  
  public final void update()
  {
    y.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.dZI);
    y.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.DP().isSDCardAvailable());
    if ((!this.dZI) && (g.DP().isSDCardAvailable()))
    {
      release();
      this.dZI = true;
      g.DO().dJT.a(159, this);
      k localk = new k(7);
      g.DO().dJT.a(localk, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.az.c
 * JD-Core Version:    0.7.0.1
 */