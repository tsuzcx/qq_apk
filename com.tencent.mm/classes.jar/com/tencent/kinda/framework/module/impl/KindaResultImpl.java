package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IKindaResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.sdk.b.a;

public class KindaResultImpl
  implements IKindaResult
{
  public void apppayEnd(int paramInt, String paramString)
  {
    AppMethodBeat.i(18646);
    yv localyv = new yv();
    if (paramInt == 0) {}
    for (localyv.dON.result = -1;; localyv.dON.result = 0)
    {
      localyv.dON.dmw = paramString;
      a.IvT.l(localyv);
      AppMethodBeat.o(18646);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaResultImpl
 * JD-Core Version:    0.7.0.1
 */