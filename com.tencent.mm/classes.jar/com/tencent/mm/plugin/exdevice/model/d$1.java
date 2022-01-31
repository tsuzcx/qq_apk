package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.sdk.platformtools.ah;

final class d$1
  implements c.a
{
  d$1(d paramd) {}
  
  public final void bpG()
  {
    AppMethodBeat.i(19097);
    if (d.a(this.lDd) == null)
    {
      d.a(this.lDd, new c());
      d.a(this.lDd).lIv = null;
    }
    d.a(this.lDd).dM(ah.getContext());
    AppMethodBeat.o(19097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.1
 * JD-Core Version:    0.7.0.1
 */