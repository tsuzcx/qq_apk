package com.tencent.mm.modelvideo;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class y$a$3
  implements Runnable
{
  y$a$3(y.a parama) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - y.a.l(this.eIu);
    y.d("MicroMsg.VideoService", "Try Run service runningFlag:" + y.a.h(this.eIu) + " timeWait:" + l + " sending:" + y.a.j(this.eIu) + " recving:" + y.a.i(this.eIu));
    if (y.a.h(this.eIu))
    {
      if (l < 60000L) {
        return;
      }
      y.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + y.a.h(this.eIu) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + y.a.j(this.eIu) + " recving:" + y.a.i(this.eIu));
    }
    y.a.a(this.eIu, 3);
    y.a.m(this.eIu);
    y.a.d(this.eIu);
    y.a.b(this.eIu);
    y.a.e(this.eIu);
    y.a.c(this.eIu);
    this.eIu.bEc.dzS = SystemClock.elapsedRealtime();
    y.a.n(this.eIu).S(10L, 10L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y.a.3
 * JD-Core Version:    0.7.0.1
 */