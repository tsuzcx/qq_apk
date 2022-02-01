package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class c
  implements f
{
  private static c iiO;
  private boolean glB = false;
  private int iiN = 3;
  
  public static c aJS()
  {
    AppMethodBeat.i(150790);
    if (iiO == null) {
      iiO = new c();
    }
    c localc = iiO;
    AppMethodBeat.o(150790);
    return localc;
  }
  
  private void release()
  {
    AppMethodBeat.i(150792);
    this.glB = false;
    g.ajB().gAO.b(159, this);
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
      g.ajC().ajl().set(81938, Long.valueOf(bt.aQJ()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(150793);
      return;
      label76:
      paramInt1 = this.iiN - 1;
      this.iiN = paramInt1;
      if (paramInt1 < 0)
      {
        g.ajC().ajl().set(81938, Long.valueOf((bt.flT() - 86400000L + 3600000L) / 1000L));
        this.iiN = 3;
      }
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(150791);
    ad.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.glB);
    ad.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.ajC().isSDCardAvailable());
    if ((!this.glB) && (g.ajC().isSDCardAvailable()))
    {
      release();
      this.glB = true;
      g.ajB().gAO.a(159, this);
      l locall = new l(7);
      g.ajB().gAO.a(locall, 0);
    }
    AppMethodBeat.o(150791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bc.c
 * JD-Core Version:    0.7.0.1
 */