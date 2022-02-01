package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class c
  implements com.tencent.mm.al.g
{
  private static c hoY;
  private boolean fOm = false;
  private int hoX = 3;
  
  public static c azR()
  {
    AppMethodBeat.i(150790);
    if (hoY == null) {
      hoY = new c();
    }
    c localc = hoY;
    AppMethodBeat.o(150790);
    return localc;
  }
  
  private void release()
  {
    AppMethodBeat.i(150792);
    this.fOm = false;
    com.tencent.mm.kernel.g.afA().gcy.b(159, this);
    AppMethodBeat.o(150792);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150793);
    if (paramn.getType() == 159)
    {
      ad.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label76;
      }
      com.tencent.mm.kernel.g.afB().afk().set(81938, Long.valueOf(bt.aGK()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(150793);
      return;
      label76:
      paramInt1 = this.hoX - 1;
      this.hoX = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.g.afB().afk().set(81938, Long.valueOf((bt.eGO() - 86400000L + 3600000L) / 1000L));
        this.hoX = 3;
      }
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(150791);
    ad.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.fOm);
    ad.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + com.tencent.mm.kernel.g.afB().isSDCardAvailable());
    if ((!this.fOm) && (com.tencent.mm.kernel.g.afB().isSDCardAvailable()))
    {
      release();
      this.fOm = true;
      com.tencent.mm.kernel.g.afA().gcy.a(159, this);
      l locall = new l(7);
      com.tencent.mm.kernel.g.afA().gcy.a(locall, 0);
    }
    AppMethodBeat.o(150791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bc.c
 * JD-Core Version:    0.7.0.1
 */