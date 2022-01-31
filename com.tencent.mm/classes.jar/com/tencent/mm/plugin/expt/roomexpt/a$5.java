package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.al;

final class a$5
  implements t
{
  a$5(a parama) {}
  
  public final void W(Object paramObject) {}
  
  public final void X(Object paramObject)
  {
    AppMethodBeat.i(152435);
    al localal;
    String str;
    p localp;
    if ((paramObject instanceof j))
    {
      localal = g.RO();
      str = ((j)paramObject).TAG;
      localp = ((j)paramObject).fIM;
      paramObject = (j)paramObject;
      if ((paramObject.fIU != null) && (paramObject.fIU.wiN.wFU != null)) {
        break label82;
      }
    }
    label82:
    for (paramObject = null;; paramObject = paramObject.fIU.wiN.wFU.jJv)
    {
      localal.ac(new a.a(str, localp, paramObject));
      AppMethodBeat.o(152435);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.5
 * JD-Core Version:    0.7.0.1
 */