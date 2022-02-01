package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ap;

final class a$5
  implements w
{
  a$5(a parama) {}
  
  public final void aG(Object paramObject) {}
  
  public final void aH(Object paramObject)
  {
    AppMethodBeat.i(122398);
    ap localap;
    String str;
    q localq;
    if ((paramObject instanceof k))
    {
      localap = g.agU();
      str = ((k)paramObject).TAG;
      localq = ((k)paramObject).hMs;
      paramObject = (k)paramObject;
      if ((paramObject.hMA != null) && (paramObject.hMA.DJr.Ekl != null)) {
        break label82;
      }
    }
    label82:
    for (paramObject = null;; paramObject = paramObject.hMA.DJr.Ekl.ncM)
    {
      localap.az(new a.a(str, localq, paramObject));
      AppMethodBeat.o(122398);
      return;
    }
  }
  
  public final void aI(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.5
 * JD-Core Version:    0.7.0.1
 */