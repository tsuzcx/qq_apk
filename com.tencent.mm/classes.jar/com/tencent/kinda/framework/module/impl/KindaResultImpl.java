package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IKindaResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.sdk.b.a;

public class KindaResultImpl
  implements IKindaResult
{
  public void apppayEnd(int paramInt, String paramString)
  {
    AppMethodBeat.i(18646);
    xk localxk = new xk();
    if (paramInt == 0) {}
    for (localxk.dDy.result = -1;; localxk.dDy.result = 0)
    {
      localxk.dDy.dcE = paramString;
      a.ESL.l(localxk);
      AppMethodBeat.o(18646);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaResultImpl
 * JD-Core Version:    0.7.0.1
 */