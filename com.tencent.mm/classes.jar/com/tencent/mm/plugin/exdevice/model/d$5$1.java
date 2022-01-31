package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.e;

final class d$5$1
  extends c.a
{
  d$5$1(d.5 param5)
  {
    super(0);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(19101);
    d.a(this.lDi.lDd).lIv = null;
    e.bqq().aG(this.lDi.lDg, this.lDi.lDh);
    AppMethodBeat.o(19101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.5.1
 * JD-Core Version:    0.7.0.1
 */