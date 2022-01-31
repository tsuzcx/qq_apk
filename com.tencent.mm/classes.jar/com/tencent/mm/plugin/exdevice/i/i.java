package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends ae
{
  private a lJu;
  private g lJw;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(19739);
    this.lJw = new g(paramInt);
    AppMethodBeat.o(19739);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(19740);
    if (!u.bqz().jp(this.lJw.jRn))
    {
      ab.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.lJw.jRn) });
      AppMethodBeat.o(19740);
      return true;
    }
    this.lJu = new a(this.lJw, paramd);
    boolean bool = this.lJu.b(paramm);
    AppMethodBeat.o(19740);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.i
 * JD-Core Version:    0.7.0.1
 */