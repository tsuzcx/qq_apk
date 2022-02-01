package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ad;

final class a$2
  implements com.tencent.mm.al.g
{
  a$2(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63758);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(304, this);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      ad.i("MicroMsg.SubCoreCollect", "set sound fail!");
    }
    AppMethodBeat.o(63758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a.2
 * JD-Core Version:    0.7.0.1
 */