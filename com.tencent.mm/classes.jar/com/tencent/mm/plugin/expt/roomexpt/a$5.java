package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ar;

final class a$5
  implements z
{
  a$5(a parama) {}
  
  public final void aI(Object paramObject) {}
  
  public final void aJ(Object paramObject)
  {
    AppMethodBeat.i(122398);
    ar localar;
    String str;
    r localr;
    if ((paramObject instanceof k))
    {
      localar = g.ajU();
      str = ((k)paramObject).TAG;
      localr = ((k)paramObject).iif;
      paramObject = (k)paramObject;
      if ((paramObject.iin != null) && (paramObject.iin.FGW.GjT != null)) {
        break label82;
      }
    }
    label82:
    for (paramObject = null;; paramObject = paramObject.iin.FGW.GjT.nIE)
    {
      localar.aw(new a.a(str, localr, paramObject));
      AppMethodBeat.o(122398);
      return;
    }
  }
  
  public final void aK(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.5
 * JD-Core Version:    0.7.0.1
 */