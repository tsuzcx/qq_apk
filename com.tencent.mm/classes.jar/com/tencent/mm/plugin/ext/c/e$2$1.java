package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2$1
  implements f
{
  e$2$1(e.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20420);
    if (((a)paramm).mfr == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.ExtQrCodeHandler", "hy: check url done. errType: %d, errCode: %d, errMsg %s, scene: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(bool) });
      g.RK().eHt.b(782, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      this.mfo.cv(Boolean.valueOf(bool));
      AppMethodBeat.o(20420);
      return;
    }
    this.mfo.cv(Boolean.FALSE);
    AppMethodBeat.o(20420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.2.1
 * JD-Core Version:    0.7.0.1
 */