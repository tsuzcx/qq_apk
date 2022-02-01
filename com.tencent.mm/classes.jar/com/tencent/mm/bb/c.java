package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class c
  implements com.tencent.mm.ak.g
{
  private static c hPA;
  private boolean fRX = false;
  private int hPz = 3;
  
  public static c aGH()
  {
    AppMethodBeat.i(150790);
    if (hPA == null) {
      hPA = new c();
    }
    c localc = hPA;
    AppMethodBeat.o(150790);
    return localc;
  }
  
  private void release()
  {
    AppMethodBeat.i(150792);
    this.fRX = false;
    com.tencent.mm.kernel.g.agQ().ghe.b(159, this);
    AppMethodBeat.o(150792);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150793);
    if (paramn.getType() == 159)
    {
      ac.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label76;
      }
      com.tencent.mm.kernel.g.agR().agA().set(81938, Long.valueOf(bs.aNx()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(150793);
      return;
      label76:
      paramInt1 = this.hPz - 1;
      this.hPz = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.g.agR().agA().set(81938, Long.valueOf((bs.eWj() - 86400000L + 3600000L) / 1000L));
        this.hPz = 3;
      }
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(150791);
    ac.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.fRX);
    ac.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + com.tencent.mm.kernel.g.agR().isSDCardAvailable());
    if ((!this.fRX) && (com.tencent.mm.kernel.g.agR().isSDCardAvailable()))
    {
      release();
      this.fRX = true;
      com.tencent.mm.kernel.g.agQ().ghe.a(159, this);
      l locall = new l(7);
      com.tencent.mm.kernel.g.agQ().ghe.a(locall, 0);
    }
    AppMethodBeat.o(150791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.c
 * JD-Core Version:    0.7.0.1
 */