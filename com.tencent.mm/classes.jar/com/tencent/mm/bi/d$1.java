package com.tencent.mm.bi;

import android.media.MediaCodec;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    if (this.eIX.eIT != null) {
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
    }
    try
    {
      this.eIX.eIT.stop();
      this.eIX.eIT.release();
      this.eIX.eIT = null;
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bi.d.1
 * JD-Core Version:    0.7.0.1
 */