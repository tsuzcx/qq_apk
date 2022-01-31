package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;

public final class m
  implements g, com.tencent.mm.plugin.messenger.foundation.a.m
{
  public final void a(awn paramawn, bi parambi)
  {
    if (f.eW(parambi.field_talker))
    {
      paramawn.svK = parambi.czr;
      if (bk.bl(paramawn.svK)) {
        paramawn.svK = e.lv(parambi.czr);
      }
      return;
    }
    paramawn.svK = parambi.czr;
  }
  
  public final String v(bi parambi)
  {
    if (f.eW(parambi.field_talker)) {
      return e.HR();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.m
 * JD-Core Version:    0.7.0.1
 */