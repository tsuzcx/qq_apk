package com.tencent.mm.as;

import com.tencent.mm.ak.c;
import com.tencent.mm.j.d;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class l$4$3
  implements m.a
{
  l$4$3(l.4 param4, d paramd, e parame) {}
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    new com.tencent.mm.h.b.a.f(a.n(new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(l.l(this.epu.ept)), Long.valueOf(bk.UY()), Integer.valueOf(c.bx(ae.getContext())), Integer.valueOf(l.m(this.epu.ept)), Integer.valueOf(this.eiR.field_fileLength), this.eiR.field_transInfo, "", "", "", "", "", "", "", l.mf(this.eiR.dlG) })).QX();
    y.i(l.f(this.epu.ept), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(this.epu.ept), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      i.iL((int)l.b(this.epu.ept));
      i.iK((int)l.b(this.epu.ept));
      l.g(this.epu.ept).onSceneEnd(paramInt2, paramInt3, "", this.epu.ept);
      if (l.k(this.epu.ept) != null) {
        l.k(this.epu.ept).Ow();
      }
      return;
    }
    l.a(this.epu.ept, this.epf, this.epf.ebK, paramLong, paramInt1, this.eiR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.as.l.4.3
 * JD-Core Version:    0.7.0.1
 */