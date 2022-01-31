package com.tencent.mm.modelvideo;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class m$3
  implements Runnable
{
  m$3(m paramm) {}
  
  public final void run()
  {
    y.d("MicroMsg.SightMassSendService", "Try Run service runningFlag:" + m.f(this.eGO) + " sending:" + m.g(this.eGO));
    if (!m.f(this.eGO))
    {
      m.l(this.eGO);
      m.m(this.eGO).dzS = SystemClock.elapsedRealtime();
      m.c(this.eGO);
    }
    m.n(this.eGO);
    m.o(this.eGO).S(10L, 10L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.3
 * JD-Core Version:    0.7.0.1
 */