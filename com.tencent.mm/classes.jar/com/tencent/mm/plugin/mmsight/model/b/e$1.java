package com.tencent.mm.plugin.mmsight.model.b;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(76704);
    if (this.oKk.eRD != null)
    {
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
      try
      {
        this.oKk.eRD.stop();
        this.oKk.eRD.release();
        this.oKk.eRD = null;
        AppMethodBeat.o(76704);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(76704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e.1
 * JD-Core Version:    0.7.0.1
 */