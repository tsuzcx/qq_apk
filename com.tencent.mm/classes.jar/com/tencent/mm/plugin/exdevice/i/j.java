package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends ae
{
  private a lJx;
  private h lJy;
  
  public j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(19741);
    this.lJy = new h(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(19741);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(19742);
    if (!u.bqz().jp(this.lJy.jRn))
    {
      ab.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.lJy.jRn) });
      AppMethodBeat.o(19742);
      return true;
    }
    this.lJx = new b(this.lJy, paramd);
    boolean bool = this.lJx.b(paramm);
    AppMethodBeat.o(19742);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.j
 * JD-Core Version:    0.7.0.1
 */