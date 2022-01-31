package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - this.kaG.bDZ;
    if (this.kaG.bDX)
    {
      if (l < 300000L) {
        return;
      }
      y.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + this.kaG.bDX + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + this.kaG.bDX);
    }
    y.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", new Object[] { Long.valueOf(l) });
    this.kaG.bDW = false;
    this.kaG.bDX = true;
    this.kaG.kaD = 0;
    this.kaG.bDY = 3;
    this.kaG.bEd.S(100L, 100L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.4
 * JD-Core Version:    0.7.0.1
 */