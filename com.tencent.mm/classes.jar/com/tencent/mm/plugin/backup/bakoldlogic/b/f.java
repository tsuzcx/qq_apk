package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(ih paramih, ca paramca, String paramString, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(287686);
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(287686);
      return 0;
    }
    int i = paramca.field_content.getBytes().length;
    AppMethodBeat.o(287686);
    return i;
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21849);
    paramString = new String(paramih.RIF.Ufy);
    i locali = b.cuH().cuI().bbO();
    paramca.setContent(paramString);
    switch (paramih.rWu)
    {
    default: 
      if (paramca.field_msgId == 0L) {
        d.z(paramca);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(21849);
      return 0;
      paramca.setStatus(6);
      break;
      locali.b(paramih.HlH, paramca);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */