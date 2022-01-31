package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class r$1
  implements a.a
{
  r$1(r paramr) {}
  
  public final void output(byte[] paramArrayOfByte)
  {
    long l = bk.UZ();
    boolean bool2 = this.mky.mkv.bjg();
    r localr = this.mky;
    if ((bool2) && (this.mky.bCf)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localr.d(paramArrayOfByte, bool1);
      j.mji.z(paramArrayOfByte);
      y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(this.mky.bCf), Boolean.valueOf(bool2), Long.valueOf(bk.cp(l)) });
      if ((bool2) && (this.mky.bCf)) {
        this.mky.bjI();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r.1
 * JD-Core Version:    0.7.0.1
 */