package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class f
  implements j
{
  public final int a(fo paramfo, bi parambi, LinkedList<u> paramLinkedList)
  {
    if (parambi.field_content == null) {
      return 0;
    }
    return parambi.field_content.getBytes().length;
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    paramString = new String(paramfo.svH.tFO);
    g localg = b.avO().avP().Fy();
    parambi.setContent(paramString);
    switch (paramfo.hQR)
    {
    default: 
      if (parambi.field_msgId == 0L) {
        d.h(parambi);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.f
 * JD-Core Version:    0.7.0.1
 */