package com.tencent.mm.modelvideo;

import com.tencent.mm.ak.c;
import com.tencent.mm.j.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

final class g$1$1
  implements h.a
{
  g$1$1(g.1 param1, d paramd) {}
  
  public final void bw(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      com.tencent.mm.kernel.g.DS().O(new g.1.1.1(this));
      return;
    }
    new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(g.d(this.eGr.eGq)), Long.valueOf(bk.UY()), Integer.valueOf(c.bx(ae.getContext())), Integer.valueOf(g.e(this.eGr.eGq)), Integer.valueOf(this.eiR.field_fileLength), this.eiR.field_transInfo, "", "", "", "", "", "", "", this.eiR.dlG })).QX();
    a.a(g.g(this.eGr.eGq), 0);
    g.a(this.eGr.eGq, this.eiR);
    g.f(this.eGr.eGq).onSceneEnd(paramInt1, paramInt2, "", this.eGr.eGq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g.1.1
 * JD-Core Version:    0.7.0.1
 */