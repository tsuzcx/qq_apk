package com.tencent.mm.modelstat;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class q$3
  extends n.a
{
  q$3(q paramq) {}
  
  public final void et(int paramInt)
  {
    if ((paramInt != 4) && (paramInt != 6)) {
      return;
    }
    g.DS().k(new q.3.1(this), 3000L);
    y.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[] { Integer.valueOf(paramInt) });
    o.jl(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.q.3
 * JD-Core Version:    0.7.0.1
 */