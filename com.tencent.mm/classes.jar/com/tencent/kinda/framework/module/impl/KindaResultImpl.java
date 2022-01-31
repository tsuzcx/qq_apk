package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IKindaResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.sdk.b.a;

public class KindaResultImpl
  implements IKindaResult
{
  public void apppayEnd(int paramInt, String paramString)
  {
    AppMethodBeat.i(144531);
    vk localvk = new vk();
    if (paramInt == 0) {}
    for (localvk.cMA.result = -1;; localvk.cMA.result = 0)
    {
      localvk.cMA.cnI = paramString;
      a.ymk.l(localvk);
      AppMethodBeat.o(144531);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaResultImpl
 * JD-Core Version:    0.7.0.1
 */