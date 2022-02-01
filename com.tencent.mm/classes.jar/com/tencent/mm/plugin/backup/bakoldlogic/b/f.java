package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.storage.cc;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(jd paramjd, cc paramcc, String paramString, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(300723);
    if (paramcc.field_content == null)
    {
      AppMethodBeat.o(300723);
      return 0;
    }
    int i = paramcc.field_content.getBytes().length;
    AppMethodBeat.o(300723);
    return i;
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21849);
    paramString = new String(paramjd.YFG.abwM);
    i locali = b.cXr().cXs().bzD();
    paramcc.setContent(paramString);
    switch (paramjd.vhJ)
    {
    default: 
      if (paramcc.field_msgId == 0L) {
        d.B(paramcc);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(21849);
      return 0;
      paramcc.setStatus(6);
      break;
      locali.b(paramjd.Njv, paramcc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */