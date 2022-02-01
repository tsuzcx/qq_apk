package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;

final class f$12
  implements Runnable
{
  f$12(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(219550);
    Log.i(this.nDA.cDW, "transferTo, hideTask run");
    if (this.nDA.kAR == null)
    {
      AppMethodBeat.o(219550);
      return;
    }
    this.nDA.kAR.setVisibility(4);
    AppMethodBeat.o(219550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.12
 * JD-Core Version:    0.7.0.1
 */