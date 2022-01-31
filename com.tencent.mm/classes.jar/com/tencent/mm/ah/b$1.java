package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements e.c
{
  b$1(e parame) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77831);
    this.fro.acU();
    ab.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(77831);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.b.1
 * JD-Core Version:    0.7.0.1
 */