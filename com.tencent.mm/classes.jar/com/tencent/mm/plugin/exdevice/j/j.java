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
  private a pai;
  private h paj;
  
  public j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(23809);
    this.paj = new h(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(23809);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23810);
    if (!u.cah().oX(this.paj.mQq))
    {
      ad.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.paj.mQq) });
      AppMethodBeat.o(23810);
      return true;
    }
    this.pai = new b(this.paj, paramd);
    boolean bool = this.pai.b(paramm);
    AppMethodBeat.o(23810);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.j
 * JD-Core Version:    0.7.0.1
 */