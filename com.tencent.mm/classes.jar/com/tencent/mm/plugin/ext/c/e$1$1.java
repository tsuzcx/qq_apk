package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$1$1
  implements r
{
  e$1$1(e.1 param1) {}
  
  public final void ac(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20417);
    ab.i("MicroMsg.ExtQrCodeHandler", "hy: result: %s, code type: %d, code version: %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved result!");
      this.mfn.cv(null);
      AppMethodBeat.o(20417);
      return;
    }
    this.mfn.cv(new e.a(paramInt1, paramString, paramInt2));
    AppMethodBeat.o(20417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.1.1
 * JD-Core Version:    0.7.0.1
 */