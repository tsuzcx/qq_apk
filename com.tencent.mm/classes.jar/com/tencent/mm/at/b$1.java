package com.tencent.mm.at;

import android.net.TrafficStats;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$1
  implements ap.a
{
  b$1(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78151);
    long l1 = TrafficStats.getUidRxBytes(this.fDw.fDr);
    long l2 = TrafficStats.getUidTxBytes(this.fDw.fDr);
    long l3 = l1 - this.fDw.fDp + (l2 - this.fDw.fDq);
    ab.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
    if (l3 <= 20480L)
    {
      this.fDw.fDo = false;
      this.fDw.start();
    }
    for (;;)
    {
      AppMethodBeat.o(78151);
      return true;
      this.fDw.fDp = l1;
      this.fDw.fDq = l2;
      this.fDw.fDt.ag(1000L, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.b.1
 * JD-Core Version:    0.7.0.1
 */