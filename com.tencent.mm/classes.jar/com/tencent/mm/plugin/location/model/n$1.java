package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.protocal.protobuf.dqy;

final class n$1
  implements i
{
  n$1(n paramn) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(55725);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (x)paramq;
      paramq = paramString.bfB();
      if (paramq.oUv == 0) {
        n.w(paramString.msgId, x.PE(paramq.MbV));
      }
    }
    AppMethodBeat.o(55725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n.1
 * JD-Core Version:    0.7.0.1
 */