package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ac;

final class a$2
  implements com.tencent.mm.ak.g
{
  a$2(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63758);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(304, this);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      ac.i("MicroMsg.SubCoreCollect", "set sound fail!");
    }
    AppMethodBeat.o(63758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a.2
 * JD-Core Version:    0.7.0.1
 */