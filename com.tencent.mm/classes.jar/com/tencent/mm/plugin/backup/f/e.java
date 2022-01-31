package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class e
  implements l
{
  public final int a(gx paramgx, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(17457);
    if (parambi.field_content == null)
    {
      AppMethodBeat.o(17457);
      return 0;
    }
    int i = parambi.field_content.getBytes().length;
    AppMethodBeat.o(17457);
    return i;
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17458);
    paramString = new String(paramgx.woR.xJE);
    h localh = d.aUK().aUL().YC();
    parambi.setContent(paramString);
    switch (paramgx.jKs)
    {
    default: 
      if (parambi.field_msgId == 0L) {
        c.l(parambi);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(17458);
      return 0;
      parambi.setStatus(6);
      break;
      localh.b(paramgx.pIG, parambi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.e
 * JD-Core Version:    0.7.0.1
 */