package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.storage.bl;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(hu paramhu, bl parambl, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21848);
    if (parambl.field_content == null)
    {
      AppMethodBeat.o(21848);
      return 0;
    }
    int i = parambl.field_content.getBytes().length;
    AppMethodBeat.o(21848);
    return i;
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21849);
    paramString = new String(paramhu.Cxz.Ehn);
    h localh = b.byA().byB().apO();
    parambl.setContent(paramString);
    switch (paramhu.mBH)
    {
    default: 
      if (parambl.field_msgId == 0L) {
        d.u(parambl);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(21849);
      return 0;
      parambl.setStatus(6);
      break;
      localh.b(paramhu.uKZ, parambl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */