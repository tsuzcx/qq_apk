package com.tencent.mm.plugin.mmsight.model.b;

import android.media.MediaCodec;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    if (this.mld.eIT != null) {
      y.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
    }
    try
    {
      this.mld.eIT.stop();
      this.mld.eIT.release();
      this.mld.eIT = null;
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e.1
 * JD-Core Version:    0.7.0.1
 */