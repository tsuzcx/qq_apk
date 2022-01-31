package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VolumeMeter$1
  implements Runnable
{
  VolumeMeter$1(VolumeMeter paramVolumeMeter) {}
  
  public final void run()
  {
    AppMethodBeat.i(113577);
    Looper.prepare();
    VolumeMeter.a(this.oeZ, new ak());
    Looper.loop();
    AppMethodBeat.o(113577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter.1
 * JD-Core Version:    0.7.0.1
 */