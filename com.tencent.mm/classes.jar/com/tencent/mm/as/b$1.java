package com.tencent.mm.as;

import android.net.TrafficStats;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements am.a
{
  b$1(b paramb) {}
  
  public final boolean tC()
  {
    long l1 = TrafficStats.getUidRxBytes(this.emZ.emU);
    long l2 = TrafficStats.getUidTxBytes(this.emZ.emU);
    long l3 = l1 - this.emZ.emS + (l2 - this.emZ.emT);
    y.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
    if (l3 <= 20480L)
    {
      this.emZ.emR = false;
      this.emZ.start();
    }
    for (;;)
    {
      return true;
      this.emZ.emS = l1;
      this.emZ.emT = l2;
      this.emZ.emW.S(1000L, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.b.1
 * JD-Core Version:    0.7.0.1
 */