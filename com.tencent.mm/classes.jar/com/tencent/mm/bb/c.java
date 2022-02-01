package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class c
  implements i
{
  private static c jgG;
  private boolean gYQ = false;
  private int jgF = 3;
  
  public static c beo()
  {
    AppMethodBeat.i(150790);
    if (jgG == null) {
      jgG = new c();
    }
    c localc = jgG;
    AppMethodBeat.o(150790);
    return localc;
  }
  
  private void release()
  {
    AppMethodBeat.i(150792);
    this.gYQ = false;
    g.aAg().hqi.b(159, this);
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
      g.aAh().azQ().set(81938, Long.valueOf(Util.nowSecond()));
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(150793);
      return;
      label76:
      paramInt1 = this.jgF - 1;
      this.jgF = paramInt1;
      if (paramInt1 < 0)
      {
        g.aAh().azQ().set(81938, Long.valueOf((Util.nowMilliSecond() - 86400000L + 3600000L) / 1000L));
        this.jgF = 3;
      }
    }
  }
  
  public final void update()
  {
    AppMethodBeat.i(150791);
    Log.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.gYQ);
    Log.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.aAh().isSDCardAvailable());
    if ((!this.gYQ) && (g.aAh().isSDCardAvailable()))
    {
      release();
      this.gYQ = true;
      g.aAg().hqi.a(159, this);
      n localn = new n(7);
      g.aAg().hqi.a(localn, 0);
    }
    AppMethodBeat.o(150791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.c
 * JD-Core Version:    0.7.0.1
 */