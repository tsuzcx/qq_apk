package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class c
  implements f
{
  private static c fMm;
  private int fMl = 3;
  private boolean fpN = false;
  
  public static c aiI()
  {
    AppMethodBeat.i(78436);
    if (fMm == null) {
      fMm = new c();
    }
    c localc = fMm;
    AppMethodBeat.o(78436);
    return localc;
  }
  
  private void release()
  {
    AppMethodBeat.i(78438);
    this.fpN = false;
    g.RK().eHt.b(159, this);
    AppMethodBeat.o(78438);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(78439);
    if (paramm.getType() == 159)
    {
      ab.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label76;
      }
      g.RL().Ru().set(81938, Long.valueOf(bo.aox()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(78439);
      return;
      label76:
      paramInt1 = this.fMl - 1;
      this.fMl = paramInt1;
      if (paramInt1 < 0)
      {
        g.RL().Ru().set(81938, Long.valueOf((bo.aoy() - 86400000L + 3600000L) / 1000L));
        this.fMl = 3;
      }
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(78437);
    ab.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.fpN);
    ab.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.RL().isSDCardAvailable());
    if ((!this.fpN) && (g.RL().isSDCardAvailable()))
    {
      release();
      this.fpN = true;
      g.RK().eHt.a(159, this);
      k localk = new k(7);
      g.RK().eHt.a(localk, 0);
    }
    AppMethodBeat.o(78437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ba.c
 * JD-Core Version:    0.7.0.1
 */