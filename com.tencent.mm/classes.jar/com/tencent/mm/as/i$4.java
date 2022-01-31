package com.tencent.mm.as;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class i$4
  implements Runnable
{
  i$4(i parami) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - i.g(this.eoG);
    if (i.h(this.eoG))
    {
      if (l < 60000L) {
        return;
      }
      y.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + i.h(this.eoG) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.h(this.eoG));
    }
    i.i(this.eoG);
    i.j(this.eoG);
    this.eoG.bEc.dzS = SystemClock.elapsedRealtime();
    i.k(this.eoG).S(10L, 10L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.i.4
 * JD-Core Version:    0.7.0.1
 */