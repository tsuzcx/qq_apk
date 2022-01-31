package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class r$1
  implements a.a
{
  r$1(r paramr) {}
  
  public final void output(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76670);
    long l = bo.yB();
    boolean bool2 = this.oJO.oJL.bRj();
    r localr = this.oJO;
    if ((bool2) && (this.oJO.ciU)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localr.e(paramArrayOfByte, bool1);
      b.fYm.O(paramArrayOfByte);
      ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(this.oJO.ciU), Boolean.valueOf(bool2), Long.valueOf(bo.av(l)) });
      if ((bool2) && (this.oJO.ciU)) {
        this.oJO.bRv();
      }
      AppMethodBeat.o(76670);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r.1
 * JD-Core Version:    0.7.0.1
 */