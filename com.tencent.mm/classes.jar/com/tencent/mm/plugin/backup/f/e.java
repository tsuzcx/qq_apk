package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.storage.bo;
import java.util.HashMap;
import java.util.LinkedList;

public final class e
  implements l
{
  public final int a(hy paramhy, boolean paramBoolean1, bo parambo, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21516);
    if (parambo.field_content == null)
    {
      AppMethodBeat.o(21516);
      return 0;
    }
    int i = parambo.field_content.getBytes().length;
    AppMethodBeat.o(21516);
    return i;
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21517);
    paramString = paramhy.DPV.FEm;
    if (paramString != null) {
      parambo.setContent(paramString);
    }
    if (paramhy.ndI == 50) {
      parambo.setStatus(6);
    }
    if (parambo.field_msgId == 0L) {
      c.u(parambo);
    }
    for (;;)
    {
      AppMethodBeat.o(21517);
      return 0;
      d.bEP().bEQ().awD().b(paramhy.vTQ, parambo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.e
 * JD-Core Version:    0.7.0.1
 */