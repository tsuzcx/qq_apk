package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.aq;

final class a$5
  implements w
{
  a$5(a parama) {}
  
  public final void aJ(Object paramObject) {}
  
  public final void aK(Object paramObject)
  {
    AppMethodBeat.i(122398);
    aq localaq;
    String str;
    q localq;
    if ((paramObject instanceof k))
    {
      localaq = g.afE();
      str = ((k)paramObject).TAG;
      localq = ((k)paramObject).hlP;
      paramObject = (k)paramObject;
      if ((paramObject.hlX != null) && (paramObject.hlX.CqZ.CRA != null)) {
        break label82;
      }
    }
    label82:
    for (paramObject = null;; paramObject = paramObject.hlX.CqZ.CRA.mAL)
    {
      localaq.ax(new a.a(str, localq, paramObject));
      AppMethodBeat.o(122398);
      return;
    }
  }
  
  public final void aL(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.5
 * JD-Core Version:    0.7.0.1
 */