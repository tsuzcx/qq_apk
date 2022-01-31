package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

final class d$12
  extends c.a
{
  d$12(d paramd, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(19110);
    if (!u.bqA().lCQ.b(this.lDn, d.e(this.lDd))) {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
    AppMethodBeat.o(19110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.12
 * JD-Core Version:    0.7.0.1
 */