package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.y;

final class n$3
  implements c.a
{
  n$3(n paramn) {}
  
  public final void bjj()
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
    if (this.mkk.mjn.mkz != d.c.miH)
    {
      y.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
      return;
    }
    this.mkk.mkb.start();
    this.mkk.mjn.a(d.c.miA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.3
 * JD-Core Version:    0.7.0.1
 */