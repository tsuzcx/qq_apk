package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements Runnable
{
  d$2(d paramd) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - d.f(this.kaP);
    if (d.g(this.kaP))
    {
      if (l < 60000L) {
        return;
      }
      y.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + d.g(this.kaP) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + d.g(this.kaP));
    }
    d.a(this.kaP);
    d.h(this.kaP);
    d.i(this.kaP);
    d.j(this.kaP).S(10L, 10L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d.2
 * JD-Core Version:    0.7.0.1
 */