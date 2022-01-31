package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

final class s$1$1
  implements f
{
  s$1$1(s.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(123436);
    ab.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.fPD.fPC.callback.onSceneEnd(paramInt1, paramInt2, "", this.fPD.fPC);
      AppMethodBeat.o(123436);
      return;
    }
    this.fPD.fPC.doScene(this.fPD.fPC.dispatcher(), this.fPD.fPC.callback);
    AppMethodBeat.o(123436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s.1.1
 * JD-Core Version:    0.7.0.1
 */