package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$4
  implements Runnable
{
  h$4(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(76577);
    try
    {
      h.a(this.oJl);
      this.oJl.bRo();
      AppMethodBeat.o(76577);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(76577);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h.4
 * JD-Core Version:    0.7.0.1
 */