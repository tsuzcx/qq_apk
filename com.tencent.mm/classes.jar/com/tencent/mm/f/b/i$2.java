package com.tencent.mm.f.b;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class i$2
  implements Runnable
{
  i$2(i parami) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - i.j(this.bEh);
    y.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(this.bEh) + " timeWait:" + l + " sending:" + i.g(this.bEh) + " recving:" + i.f(this.bEh));
    if (i.e(this.bEh))
    {
      if (l < 60000L) {
        return;
      }
      y.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.e(this.bEh) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.g(this.bEh) + " recving:" + i.f(this.bEh));
    }
    i.k(this.bEh);
    i.b(this.bEh);
    i.a(this.bEh, 3);
    i.a(this.bEh);
    this.bEh.bEc.dzS = SystemClock.elapsedRealtime();
    i.l(this.bEh).S(10L, 10L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.i.2
 * JD-Core Version:    0.7.0.1
 */