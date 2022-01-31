package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1$1
  implements f
{
  a$1$1(a.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(123395);
    ab.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.fBn.fBm.callback.onSceneEnd(paramInt1, paramInt2, "", this.fBn.fBm);
      AppMethodBeat.o(123395);
      return;
    }
    this.fBn.fBm.doScene(this.fBn.fBm.dispatcher(), this.fBn.fBm.callback);
    AppMethodBeat.o(123395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a.1.1
 * JD-Core Version:    0.7.0.1
 */