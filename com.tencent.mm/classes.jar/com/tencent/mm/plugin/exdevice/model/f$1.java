package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class f$1
  implements d.a
{
  f$1(f paramf) {}
  
  public final void dFt()
  {
    AppMethodBeat.i(23205);
    if (f.a(this.ypJ) == null)
    {
      f.a(this.ypJ, new c());
      f.a(this.ypJ).yvg = null;
    }
    f.a(this.ypJ).gd(MMApplicationContext.getContext());
    AppMethodBeat.o(23205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f.1
 * JD-Core Version:    0.7.0.1
 */