package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.y;

final class n$1
  implements f
{
  n$1(n paramn) {}
  
  public final boolean M(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
      return false;
    }
    if ((this.mkk.mjn.mkz == d.c.miA) || (this.mkk.mjn.mkz == d.c.miB))
    {
      if (this.mkk.mjn.mkz == d.c.miB)
      {
        this.mkk.mjn.mkz = d.c.miC;
        y.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
      }
      this.mkk.mkh.fj(1L);
      if (this.mkk.mka != null) {
        this.mkk.mka.bjh();
      }
      this.mkk.aC(paramArrayOfByte);
      return true;
    }
    y.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onFrameData, mediaStatus error: %s", new Object[] { this.mkk.mjn.mkz });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.1
 * JD-Core Version:    0.7.0.1
 */