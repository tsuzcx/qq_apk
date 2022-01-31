package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

final class d$3
  extends c.a
{
  d$3(d paramd, long paramLong, k paramk)
  {
    super(0);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(19099);
    if (!u.bqA().lCQ.a(this.jOE, this.lDf)) {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
    }
    AppMethodBeat.o(19099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.3
 * JD-Core Version:    0.7.0.1
 */