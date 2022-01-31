package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;

final class i$3
  extends AppBrandMainProcessService.a
{
  private boolean gQa = false;
  
  i$3(i parami) {}
  
  public final void atD()
  {
    AppMethodBeat.i(141622);
    if (this.gQa) {
      i.e(this.gPY);
    }
    this.gQa = false;
    AppMethodBeat.o(141622);
  }
  
  public final void atE()
  {
    this.gQa = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.3
 * JD-Core Version:    0.7.0.1
 */