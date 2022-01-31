package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(gx paramgx, bi parambi, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(17791);
    if (parambi.field_content == null)
    {
      AppMethodBeat.o(17791);
      return 0;
    }
    int i = parambi.field_content.getBytes().length;
    AppMethodBeat.o(17791);
    return i;
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17792);
    paramString = new String(paramgx.woR.xJE);
    h localh = b.aVr().aVs().YC();
    parambi.setContent(paramString);
    switch (paramgx.jKs)
    {
    default: 
      if (parambi.field_msgId == 0L) {
        d.l(parambi);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(17792);
      return 0;
      parambi.setStatus(6);
      break;
      localh.b(paramgx.pIG, parambi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */