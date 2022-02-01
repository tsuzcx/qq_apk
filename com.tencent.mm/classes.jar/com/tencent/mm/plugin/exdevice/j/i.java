package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.g;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;

public final class i
  extends com.tencent.mm.plugin.exdevice.model.ae
{
  private a qnA;
  private g qnC;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(23807);
    this.qnC = new g(paramInt);
    AppMethodBeat.o(23807);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23808);
    if (!u.cnk().uY(this.qnC.nZd))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.qnC.nZd) });
      AppMethodBeat.o(23808);
      return true;
    }
    this.qnA = new a(this.qnC, paramd);
    boolean bool = this.qnA.b(paramm);
    AppMethodBeat.o(23808);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.i
 * JD-Core Version:    0.7.0.1
 */