package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class e
  implements l
{
  public final int a(fo paramfo, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    if (parambi.field_content == null) {
      return 0;
    }
    return parambi.field_content.getBytes().length;
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    paramString = new String(paramfo.svH.tFO);
    g localg = d.avi().avj().Fy();
    parambi.setContent(paramString);
    switch (paramfo.hQR)
    {
    default: 
      if (parambi.field_msgId == 0L) {
        c.h(parambi);
      }
      break;
    }
    for (;;)
    {
      return 0;
      parambi.setStatus(6);
      break;
      localg.b(paramfo.ndp, parambi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.e
 * JD-Core Version:    0.7.0.1
 */