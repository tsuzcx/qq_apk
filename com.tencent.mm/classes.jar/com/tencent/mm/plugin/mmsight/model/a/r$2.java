package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaCodec;
import com.tencent.mm.sdk.platformtools.y;

final class r$2
  implements Runnable
{
  r$2(r paramr) {}
  
  public final void run()
  {
    try
    {
      if (this.mky.eIF != null)
      {
        y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "delay to stop encoder");
        this.mky.mkv.stop();
        this.mky.eIF.stop();
        this.mky.eIF.release();
        this.mky.eIF = null;
        this.mky.bSr = false;
        if (this.mky.mkw != null) {
          this.mky.mkw.bjy();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "delay to stop encoder error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r.2
 * JD-Core Version:    0.7.0.1
 */