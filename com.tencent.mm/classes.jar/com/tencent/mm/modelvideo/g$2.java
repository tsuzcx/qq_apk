package com.tencent.mm.modelvideo;

import com.tencent.mm.ah.f;
import com.tencent.mm.sdk.platformtools.am.a;

final class g$2
  implements am.a
{
  g$2(g paramg) {}
  
  public final boolean tC()
  {
    if (this.eGq.a(g.o(this.eGq), g.f(this.eGq)) == -1)
    {
      g.a(this.eGq, 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      g.f(this.eGq).onSceneEnd(3, -1, "doScene failed", this.eGq);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g.2
 * JD-Core Version:    0.7.0.1
 */