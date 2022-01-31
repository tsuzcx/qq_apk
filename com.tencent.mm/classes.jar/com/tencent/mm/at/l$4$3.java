package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class l$4$3
  implements m.a
{
  l$4$3(l.4 param4, d paramd, e parame) {}
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78324);
    new com.tencent.mm.g.b.a.f(a.s(new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(l.l(this.fFU.fFT)), Long.valueOf(bo.aoy()), Integer.valueOf(c.cb(ah.getContext())), Integer.valueOf(l.m(this.fFU.fFT)), Integer.valueOf(this.fyV.field_fileLength), this.fyV.field_transInfo, "", "", "", "", "", "", "", l.tk(this.fyV.edb) })).ake();
    ab.i(l.f(this.fFU.fFT), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(this.fFU.fFT), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      i.lz((int)l.b(this.fFU.fFT));
      i.ly((int)l.b(this.fFU.fFT));
      l.g(this.fFU.fFT).onSceneEnd(paramInt2, paramInt3, "", this.fFU.fFT);
      if (l.k(this.fFU.fFT) != null) {
        l.k(this.fFU.fFT).aho();
      }
      AppMethodBeat.o(78324);
      return;
    }
    l.a(this.fFU.fFT, this.fFD, this.fFD.fsd, paramLong, paramInt1, this.fyV);
    AppMethodBeat.o(78324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.at.l.4.3
 * JD-Core Version:    0.7.0.1
 */