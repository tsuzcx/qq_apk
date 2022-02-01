package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IKindaResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.sdk.b.a;

public class KindaResultImpl
  implements IKindaResult
{
  public void apppayEnd(int paramInt, String paramString)
  {
    AppMethodBeat.i(18646);
    xv localxv = new xv();
    if (paramInt == 0) {}
    for (localxv.dBk.result = -1;; localxv.dBk.result = 0)
    {
      localxv.dBk.dac = paramString;
      a.GpY.l(localxv);
      AppMethodBeat.o(18646);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaResultImpl
 * JD-Core Version:    0.7.0.1
 */