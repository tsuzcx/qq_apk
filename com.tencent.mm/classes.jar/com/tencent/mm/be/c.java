package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class c
  implements i
{
  private static c lXj;
  private boolean jJQ = false;
  private int lXi = 3;
  
  public static c bnM()
  {
    AppMethodBeat.i(150790);
    if (lXj == null) {
      lXj = new c();
    }
    c localc = lXj;
    AppMethodBeat.o(150790);
    return localc;
  }
  
  private void release()
  {
    AppMethodBeat.i(150792);
    this.jJQ = false;
    h.aHF().kcd.b(159, this);
    AppMethodBeat.o(150792);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150793);
    if (paramq.getType() == 159)
    {
      Log.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label76;
      }
      h.aHG().aHp().i(81938, Long.valueOf(Util.nowSecond()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(150793);
      return;
      label76:
      paramInt1 = this.lXi - 1;
      this.lXi = paramInt1;
      if (paramInt1 < 0)
      {
        h.aHG().aHp().i(81938, Long.valueOf((Util.nowMilliSecond() - 86400000L + 3600000L) / 1000L));
        this.lXi = 3;
      }
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(150791);
    Log.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.jJQ);
    Log.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + h.aHG().isSDCardAvailable());
    if ((!this.jJQ) && (h.aHG().isSDCardAvailable()))
    {
      release();
      this.jJQ = true;
      h.aHF().kcd.a(159, this);
      o localo = new o(7);
      h.aHF().kcd.a(localo, 0);
    }
    AppMethodBeat.o(150791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.be.c
 * JD-Core Version:    0.7.0.1
 */