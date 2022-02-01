package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.storage.bo;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(hy paramhy, bo parambo, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21848);
    if (parambo.field_content == null)
    {
      AppMethodBeat.o(21848);
      return 0;
    }
    int i = parambo.field_content.getBytes().length;
    AppMethodBeat.o(21848);
    return i;
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21849);
    paramString = new String(paramhy.DPV.FEm);
    h localh = b.bFw().bFx().awD();
    parambo.setContent(paramString);
    switch (paramhy.ndI)
    {
    default: 
      if (parambo.field_msgId == 0L) {
        d.u(parambo);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(21849);
      return 0;
      parambo.setStatus(6);
      break;
      localh.b(paramhy.vTQ, parambo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */