package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends ae
{
  private a paf;
  private g pah;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(23807);
    this.pah = new g(paramInt);
    AppMethodBeat.o(23807);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23808);
    if (!u.cah().oX(this.pah.mQq))
    {
      ad.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.pah.mQq) });
      AppMethodBeat.o(23808);
      return true;
    }
    this.paf = new a(this.pah, paramd);
    boolean bool = this.paf.b(paramm);
    AppMethodBeat.o(23808);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.i
 * JD-Core Version:    0.7.0.1
 */