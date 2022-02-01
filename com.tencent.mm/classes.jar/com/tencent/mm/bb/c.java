package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class c
  implements f
{
  private static c ilH;
  private boolean gnW = false;
  private int ilG = 3;
  
  public static c aKl()
  {
    AppMethodBeat.i(150790);
    if (ilH == null) {
      ilH = new c();
    }
    c localc = ilH;
    AppMethodBeat.o(150790);
    return localc;
  }
  
  private void release()
  {
    AppMethodBeat.i(150792);
    this.gnW = false;
    g.ajQ().gDv.b(159, this);
    AppMethodBeat.o(150792);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150793);
    if (paramn.getType() == 159)
    {
      ae.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label76;
      }
      g.ajR().ajA().set(81938, Long.valueOf(bu.aRi()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(150793);
      return;
      label76:
      paramInt1 = this.ilG - 1;
      this.ilG = paramInt1;
      if (paramInt1 < 0)
      {
        g.ajR().ajA().set(81938, Long.valueOf((bu.fpO() - 86400000L + 3600000L) / 1000L));
        this.ilG = 3;
      }
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(150791);
    ae.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.gnW);
    ae.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.ajR().isSDCardAvailable());
    if ((!this.gnW) && (g.ajR().isSDCardAvailable()))
    {
      release();
      this.gnW = true;
      g.ajQ().gDv.a(159, this);
      l locall = new l(7);
      g.ajQ().gDv.a(locall, 0);
    }
    AppMethodBeat.o(150791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.c
 * JD-Core Version:    0.7.0.1
 */