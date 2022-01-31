package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class n$6
  implements Runnable
{
  n$6(n paramn) {}
  
  public final void run()
  {
    boolean bool = this.mkk.bjF();
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      if (this.mkk.mki != null)
      {
        y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
        ai.d(this.mkk.mki);
      }
    }
    do
    {
      return;
      SightVideoJNI.releaseBigSightDataBufferLock(this.mkk.eIz);
    } while (this.mkk.mjJ == null);
    ai.d(new Runnable()
    {
      public final void run()
      {
        n.6.this.mkk.mjJ.Zf();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.6
 * JD-Core Version:    0.7.0.1
 */