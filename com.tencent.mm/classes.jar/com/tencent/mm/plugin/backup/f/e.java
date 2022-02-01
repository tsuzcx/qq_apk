package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;

public final class e
  implements l
{
  public final int a(ih paramih, boolean paramBoolean1, ca paramca, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21516);
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(21516);
      return 0;
    }
    int i = paramca.field_content.getBytes().length;
    AppMethodBeat.o(21516);
    return i;
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21517);
    paramString = paramih.RIF.Ufy;
    if (paramString != null) {
      paramca.setContent(paramString);
    }
    if (paramih.rWu == 50) {
      paramca.setStatus(6);
    }
    if (paramca.field_msgId == 0L) {
      c.z(paramca);
    }
    for (;;)
    {
      AppMethodBeat.o(21517);
      return 0;
      d.cua().cub().bbO().b(paramih.HlH, paramca);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.e
 * JD-Core Version:    0.7.0.1
 */