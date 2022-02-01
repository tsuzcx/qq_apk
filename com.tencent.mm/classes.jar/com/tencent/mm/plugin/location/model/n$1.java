package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.protocal.protobuf.cyd;

final class n$1
  implements f
{
  n$1(n paramn) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(55725);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (x)paramn;
      paramn = paramString.aLy();
      if (paramn.nJA == 0) {
        n.s(paramString.msgId, x.GR(paramn.GXm));
      }
    }
    AppMethodBeat.o(55725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n.1
 * JD-Core Version:    0.7.0.1
 */