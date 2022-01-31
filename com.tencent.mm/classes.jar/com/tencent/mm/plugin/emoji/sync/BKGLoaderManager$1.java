package com.tencent.mm.plugin.emoji.sync;

import android.net.TrafficStats;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class BKGLoaderManager$1
  implements am.a
{
  BKGLoaderManager$1(BKGLoaderManager paramBKGLoaderManager) {}
  
  public final boolean tC()
  {
    long l1;
    long l2;
    if ((this.jaT.jaB) || (this.jaT.jaC) || (this.jaT.jaD))
    {
      l1 = TrafficStats.getUidTxBytes(this.jaT.emU);
      l2 = TrafficStats.getUidRxBytes(this.jaT.emU);
      long l3 = l1 - this.jaT.jaO + (l2 - this.jaT.jaP);
      y.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + l3 / 1024L);
      if (l3 > 20480L) {
        break label117;
      }
      this.jaT.aIn();
    }
    for (;;)
    {
      return false;
      label117:
      this.jaT.jaO = l1;
      this.jaT.jaP = l2;
      this.jaT.jaQ.S(1000L, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */