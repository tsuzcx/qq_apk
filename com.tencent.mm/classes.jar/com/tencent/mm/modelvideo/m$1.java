package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class m$1
  implements Runnable
{
  m$1(m paramm, long paramLong) {}
  
  public final void run()
  {
    long l2 = 0L;
    m.Sn();
    m.c(this.eGO);
    m.a(this.eGO, "");
    long l1 = l2;
    if (this.eGN > 0L)
    {
      l1 = l2;
      if (m.d(this.eGO).get(Long.valueOf(this.eGN)) != null) {
        l1 = ((g.a)m.d(this.eGO).get(Long.valueOf(this.eGN))).zJ();
      }
    }
    y.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.eGN + " time:" + l1 + " inCnt:" + m.access$300() + " stop:" + m.e(this.eGO) + " running:" + m.f(this.eGO) + " sending:" + m.g(this.eGO));
    if (m.e(this.eGO) > 0) {
      m.h(this.eGO);
    }
    for (;;)
    {
      m.So();
      return;
      if (!m.g(this.eGO)) {
        m.i(this.eGO);
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.1
 * JD-Core Version:    0.7.0.1
 */