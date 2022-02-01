package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.storage.bv;
import java.util.HashMap;
import java.util.LinkedList;

public final class e
  implements l
{
  public final int a(if paramif, boolean paramBoolean1, bv parambv, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21516);
    if (parambv.field_content == null)
    {
      AppMethodBeat.o(21516);
      return 0;
    }
    int i = parambv.field_content.getBytes().length;
    AppMethodBeat.o(21516);
    return i;
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21517);
    paramString = paramif.FNI.HId;
    if (paramString != null) {
      parambv.setContent(paramString);
    }
    if (paramif.nJA == 50) {
      parambv.setStatus(6);
    }
    if (parambv.field_msgId == 0L) {
      c.v(parambv);
    }
    for (;;)
    {
      AppMethodBeat.o(21517);
      return 0;
      d.bJW().bJX().azI().b(paramif.xrk, parambv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.e
 * JD-Core Version:    0.7.0.1
 */