package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class m$1
  implements Runnable
{
  m$1(m paramm, long paramLong) {}
  
  public final void run()
  {
    long l2 = 0L;
    AppMethodBeat.i(50733);
    m.alA();
    m.c(this.fWE);
    m.a(this.fWE, "");
    long l1 = l2;
    if (this.fWD > 0L)
    {
      l1 = l2;
      if (m.d(this.fWE).get(Long.valueOf(this.fWD)) != null) {
        l1 = ((g.a)m.d(this.fWE).get(Long.valueOf(this.fWD))).Mm();
      }
    }
    ab.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.fWD + " time:" + l1 + " inCnt:" + m.access$300() + " stop:" + m.e(this.fWE) + " running:" + m.f(this.fWE) + " sending:" + m.g(this.fWE));
    if (m.e(this.fWE) > 0) {
      m.h(this.fWE);
    }
    for (;;)
    {
      m.alB();
      AppMethodBeat.o(50733);
      return;
      if (!m.g(this.fWE)) {
        m.i(this.fWE);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50734);
    String str = super.toString() + "|onSceneEnd";
    AppMethodBeat.o(50734);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.1
 * JD-Core Version:    0.7.0.1
 */