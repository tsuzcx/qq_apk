package com.tencent.mm.plugin.location.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VolumeMeter$2
  implements Runnable
{
  VolumeMeter$2(VolumeMeter paramVolumeMeter) {}
  
  public final void run()
  {
    AppMethodBeat.i(113578);
    VolumeMeter.a(this.oeZ, new ak());
    this.oeZ.bLZ();
    AppMethodBeat.o(113578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter.2
 * JD-Core Version:    0.7.0.1
 */