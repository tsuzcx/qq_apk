package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

final class a$2
  implements i
{
  a$2(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63758);
    g.aAi();
    g.aAg().hqi.b(304, this);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Log.i("MicroMsg.SubCoreCollect", "set sound fail!");
    }
    AppMethodBeat.o(63758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a.2
 * JD-Core Version:    0.7.0.1
 */