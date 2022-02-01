package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends ae
{
  private a qgY;
  private h qgZ;
  
  public j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(23809);
    this.qgZ = new h(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(23809);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23810);
    if (!u.clU().uH(this.qgZ.nTx))
    {
      ad.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.qgZ.nTx) });
      AppMethodBeat.o(23810);
      return true;
    }
    this.qgY = new b(this.qgZ, paramd);
    boolean bool = this.qgY.b(paramm);
    AppMethodBeat.o(23810);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.j
 * JD-Core Version:    0.7.0.1
 */