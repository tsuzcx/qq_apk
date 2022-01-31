package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

final class u$1$1
  implements f
{
  u$1$1(u.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(123460);
    ab.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.fPU.fPT.callback.onSceneEnd(paramInt1, paramInt2, "", this.fPU.fPT);
      AppMethodBeat.o(123460);
      return;
    }
    this.fPU.fPT.doScene(this.fPU.fPT.dispatcher(), this.fPU.fPT.callback);
    AppMethodBeat.o(123460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.u.1.1
 * JD-Core Version:    0.7.0.1
 */