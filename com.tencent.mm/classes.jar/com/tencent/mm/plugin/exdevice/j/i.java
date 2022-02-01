package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends ae
{
  private a rEH;
  private g rEJ;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(23807);
    this.rEJ = new g(paramInt);
    AppMethodBeat.o(23807);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23808);
    if (!u.cLx().Dc(this.rEJ.pkb))
    {
      Log.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.rEJ.pkb) });
      AppMethodBeat.o(23808);
      return true;
    }
    this.rEH = new a(this.rEJ, paramd);
    boolean bool = this.rEH.b(paramm);
    AppMethodBeat.o(23808);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.i
 * JD-Core Version:    0.7.0.1
 */