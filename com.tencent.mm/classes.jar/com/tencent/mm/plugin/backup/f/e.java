package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.LinkedList;

public final class e
  implements l
{
  public final int a(jd paramjd, boolean paramBoolean1, cc paramcc, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21516);
    if (paramcc.field_content == null)
    {
      AppMethodBeat.o(21516);
      return 0;
    }
    int i = paramcc.field_content.getBytes().length;
    AppMethodBeat.o(21516);
    return i;
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21517);
    paramString = paramjd.YFG.abwM;
    if (paramString != null) {
      paramcc.setContent(paramString);
    }
    if (paramjd.vhJ == 50) {
      paramcc.setStatus(6);
    }
    if (paramcc.field_msgId == 0L) {
      c.B(paramcc);
    }
    for (;;)
    {
      AppMethodBeat.o(21517);
      return 0;
      d.cWK().cWL().bzD().b(paramjd.Njv, paramcc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.e
 * JD-Core Version:    0.7.0.1
 */