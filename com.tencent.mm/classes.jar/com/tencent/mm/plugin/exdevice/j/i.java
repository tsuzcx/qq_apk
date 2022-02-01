package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.g;
import com.tencent.mm.plugin.exdevice.model.ai;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends ai
{
  private a ywp;
  private g ywr;
  
  public i(int paramInt)
  {
    AppMethodBeat.i(23807);
    this.ywr = new g(paramInt);
    AppMethodBeat.o(23807);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23808);
    if (!u.dGD().lG(this.ywr.vyj))
    {
      Log.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.ywr.vyj) });
      AppMethodBeat.o(23808);
      return true;
    }
    this.ywp = new a(this.ywr, paramd);
    boolean bool = this.ywp.b(paramm);
    AppMethodBeat.o(23808);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.i
 * JD-Core Version:    0.7.0.1
 */