package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.TimerTask;

final class g$8
  extends TimerTask
{
  g$8(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(131784);
    ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transfer task cost more than 5000");
    if (this.ikV.ikG != null)
    {
      this.ikV.ikG.ng(3);
      ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD ");
    }
    AppMethodBeat.o(131784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g.8
 * JD-Core Version:    0.7.0.1
 */