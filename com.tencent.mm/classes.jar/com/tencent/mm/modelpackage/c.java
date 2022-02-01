package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class c
  implements com.tencent.mm.am.h
{
  private static c oQl;
  private boolean mjj = false;
  private int oQk = 3;
  
  public static c bLz()
  {
    AppMethodBeat.i(150790);
    if (oQl == null) {
      oQl = new c();
    }
    c localc = oQl;
    AppMethodBeat.o(150790);
    return localc;
  }
  
  private void release()
  {
    AppMethodBeat.i(150792);
    this.mjj = false;
    com.tencent.mm.kernel.h.baD().mCm.b(159, this);
    AppMethodBeat.o(150792);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(150793);
    if (paramp.getType() == 159)
    {
      Log.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label76;
      }
      com.tencent.mm.kernel.h.baE().ban().B(81938, Long.valueOf(Util.nowSecond()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(150793);
      return;
      label76:
      paramInt1 = this.oQk - 1;
      this.oQk = paramInt1;
      if (paramInt1 < 0)
      {
        com.tencent.mm.kernel.h.baE().ban().B(81938, Long.valueOf((Util.nowMilliSecond() - 86400000L + 3600000L) / 1000L));
        this.oQk = 3;
      }
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(150791);
    Log.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.mjj);
    Log.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + com.tencent.mm.kernel.h.baE().isSDCardAvailable());
    if ((!this.mjj) && (com.tencent.mm.kernel.h.baE().isSDCardAvailable()))
    {
      release();
      this.mjj = true;
      com.tencent.mm.kernel.h.baD().mCm.a(159, this);
      p localp = new p(7);
      com.tencent.mm.kernel.h.baD().mCm.a(localp, 0);
    }
    AppMethodBeat.o(150791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelpackage.c
 * JD-Core Version:    0.7.0.1
 */