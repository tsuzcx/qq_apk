package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IKindaResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.sdk.event.EventCenter;

public class KindaResultImpl
  implements IKindaResult
{
  public void apppayEnd(int paramInt, String paramString)
  {
    AppMethodBeat.i(18646);
    aaa localaaa = new aaa();
    if (paramInt == 0) {}
    for (localaaa.egJ.result = -1;; localaaa.egJ.result = 0)
    {
      localaaa.egJ.dDL = paramString;
      EventCenter.instance.publish(localaaa);
      AppMethodBeat.o(18646);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaResultImpl
 * JD-Core Version:    0.7.0.1
 */