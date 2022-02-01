package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.storage.bl;
import java.util.HashMap;
import java.util.LinkedList;

public final class e
  implements l
{
  public final int a(hu paramhu, boolean paramBoolean1, bl parambl, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21516);
    if (parambl.field_content == null)
    {
      AppMethodBeat.o(21516);
      return 0;
    }
    int i = parambl.field_content.getBytes().length;
    AppMethodBeat.o(21516);
    return i;
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21517);
    paramString = paramhu.Cxz.Ehn;
    if (paramString != null) {
      parambl.setContent(paramString);
    }
    if (paramhu.mBH == 50) {
      parambl.setStatus(6);
    }
    if (parambl.field_msgId == 0L) {
      c.u(parambl);
    }
    for (;;)
    {
      AppMethodBeat.o(21517);
      return 0;
      d.bxT().bxU().apO().b(paramhu.uKZ, parambl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.e
 * JD-Core Version:    0.7.0.1
 */