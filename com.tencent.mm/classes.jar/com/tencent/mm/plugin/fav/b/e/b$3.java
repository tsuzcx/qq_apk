package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - b.d(this.kaK);
    if (b.e(this.kaK))
    {
      if (l < 60000L) {
        return;
      }
      y.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.e(this.kaK) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + b.e(this.kaK));
    }
    b.a(this.kaK);
    b.f(this.kaK);
    b.g(this.kaK).S(10L, 10L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b.3
 * JD-Core Version:    0.7.0.1
 */