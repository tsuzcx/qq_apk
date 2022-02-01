package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(if paramif, bu parambu, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21848);
    if (parambu.field_content == null)
    {
      AppMethodBeat.o(21848);
      return 0;
    }
    int i = parambu.field_content.getBytes().length;
    AppMethodBeat.o(21848);
    return i;
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21849);
    paramString = new String(paramif.Fvk.HoB);
    i locali = b.bJF().bJG().azs();
    parambu.setContent(paramString);
    switch (paramif.nEf)
    {
    default: 
      if (parambu.field_msgId == 0L) {
        d.v(parambu);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(21849);
      return 0;
      parambu.setStatus(6);
      break;
      locali.b(paramif.xbt, parambu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */