package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaCodec;
import com.tencent.mm.f.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class h$4
  implements Runnable
{
  h$4(h paramh) {}
  
  public final void run()
  {
    try
    {
      if (this.mje.eIF != null)
      {
        y.i("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder");
        this.mje.eIF.stop();
        this.mje.eIF.release();
        this.mje.eIF = null;
      }
      if ((this.mje.bCc != null) && (!this.mje.miS))
      {
        this.mje.bCc.uh();
        this.mje.bCc = null;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h.4
 * JD-Core Version:    0.7.0.1
 */