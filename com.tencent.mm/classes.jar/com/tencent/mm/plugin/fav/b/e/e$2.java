package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements Runnable
{
  e$2(e parame) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - e.f(this.kaR);
    if (e.g(this.kaR))
    {
      if (l < 60000L) {
        return;
      }
      y.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + e.g(this.kaR) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + e.g(this.kaR));
    }
    e.a(this.kaR);
    e.h(this.kaR);
    e.i(this.kaR);
    e.j(this.kaR).S(10L, 10L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e.2
 * JD-Core Version:    0.7.0.1
 */