package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(if paramif, bv parambv, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21848);
    if (parambv.field_content == null)
    {
      AppMethodBeat.o(21848);
      return 0;
    }
    int i = parambv.field_content.getBytes().length;
    AppMethodBeat.o(21848);
    return i;
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21849);
    paramString = new String(paramif.FNI.HId);
    i locali = b.bKD().bKE().azI();
    parambv.setContent(paramString);
    switch (paramif.nJA)
    {
    default: 
      if (parambv.field_msgId == 0L) {
        d.v(parambv);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(21849);
      return 0;
      parambv.setStatus(6);
      break;
      locali.b(paramif.xrk, parambv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */