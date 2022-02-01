package com.tencent.mm.plugin.collect.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;

final class a$2
  implements com.tencent.mm.am.h
{
  a$2(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(63758);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(304, this);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Log.i("MicroMsg.SubCoreCollect", "set sound fail!");
    }
    AppMethodBeat.o(63758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.app.a.2
 * JD-Core Version:    0.7.0.1
 */