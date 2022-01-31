package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class g$1$1
  implements h.a
{
  g$1$1(g.1 param1, d paramd) {}
  
  public final void cG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50694);
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      com.tencent.mm.kernel.g.RO().ac(new g.1.1.1(this));
      AppMethodBeat.o(50694);
      return;
    }
    new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(g.d(this.fWh.fWg)), Long.valueOf(bo.aoy()), Integer.valueOf(c.cb(ah.getContext())), Integer.valueOf(g.e(this.fWh.fWg)), Integer.valueOf(this.fyV.field_fileLength), this.fyV.field_transInfo, "", "", "", "", "", "", "", this.fyV.edb })).ake();
    a.a(g.g(this.fWh.fWg), 0);
    g.a(this.fWh.fWg, this.fyV);
    g.f(this.fWh.fWg).onSceneEnd(paramInt1, paramInt2, "", this.fWh.fWg);
    AppMethodBeat.o(50694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g.1.1
 * JD-Core Version:    0.7.0.1
 */