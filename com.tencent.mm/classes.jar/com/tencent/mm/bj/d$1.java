package com.tencent.mm.bj;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(50907);
    if (this.fYy.eRD != null)
    {
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
      try
      {
        this.fYy.eRD.stop();
        this.fYy.eRD.release();
        this.fYy.eRD = null;
        AppMethodBeat.o(50907);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(50907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.d.1
 * JD-Core Version:    0.7.0.1
 */