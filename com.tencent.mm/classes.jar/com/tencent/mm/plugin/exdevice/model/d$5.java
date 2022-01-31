package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.e;
import com.tencent.mm.sdk.platformtools.ah;

final class d$5
  implements Runnable
{
  d$5(d paramd, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(19102);
    if (d.a(this.lDd) == null)
    {
      d.a(this.lDd, new c());
      d.a(this.lDd).lIv = new d.5.1(this);
      d.a(this.lDd).dM(ah.getContext());
      AppMethodBeat.o(19102);
      return;
    }
    e.bqq().aG(this.lDg, this.lDh);
    AppMethodBeat.o(19102);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(19103);
    String str = super.toString() + "|ranging";
    AppMethodBeat.o(19103);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.5
 * JD-Core Version:    0.7.0.1
 */