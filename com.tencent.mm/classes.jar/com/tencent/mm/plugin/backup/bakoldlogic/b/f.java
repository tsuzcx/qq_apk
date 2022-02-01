package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(is paramis, ca paramca, String paramString, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(231601);
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(231601);
      return 0;
    }
    int i = paramca.field_content.getBytes().length;
    AppMethodBeat.o(231601);
    return i;
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21849);
    paramString = new String(paramis.KHn.MTo);
    i locali = b.chw().chx().aSQ();
    paramca.setContent(paramString);
    switch (paramis.oUv)
    {
    default: 
      if (paramca.field_msgId == 0L) {
        d.x(paramca);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(21849);
      return 0;
      paramca.setStatus(6);
      break;
      locali.b(paramis.Brn, paramca);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */