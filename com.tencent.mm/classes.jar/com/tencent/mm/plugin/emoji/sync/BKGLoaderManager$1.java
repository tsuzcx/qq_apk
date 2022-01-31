package com.tencent.mm.plugin.emoji.sync;

import android.net.TrafficStats;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class BKGLoaderManager$1
  implements ap.a
{
  BKGLoaderManager$1(BKGLoaderManager paramBKGLoaderManager) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(53180);
    long l1;
    long l2;
    if ((this.ljC.ljk) || (this.ljC.ljl) || (this.ljC.ljm))
    {
      l1 = TrafficStats.getUidTxBytes(this.ljC.fDr);
      l2 = TrafficStats.getUidRxBytes(this.ljC.fDr);
      long l3 = l1 - this.ljC.ljx + (l2 - this.ljC.ljy);
      ab.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + l3 / 1024L);
      if (l3 > 20480L) {
        break label127;
      }
      this.ljC.blM();
    }
    for (;;)
    {
      AppMethodBeat.o(53180);
      return false;
      label127:
      this.ljC.ljx = l1;
      this.ljC.ljy = l2;
      this.ljC.ljz.ag(1000L, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */