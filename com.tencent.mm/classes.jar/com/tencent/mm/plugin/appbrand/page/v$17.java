package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;

final class v$17
  implements f.d
{
  v$17(v paramv) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(141689);
    if (this.ixv.getActionBar().aOF())
    {
      b.c(this.ixv);
      this.ixv.getActionBar().getCapsuleBar().resume();
    }
    AppMethodBeat.o(141689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v.17
 * JD-Core Version:    0.7.0.1
 */