package com.tencent.mm.plugin.bbom;

import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;

public final class i
  implements m
{
  private String hST = null;
  
  public i(String paramString)
  {
    this.hST = paramString;
  }
  
  public final void a(awn paramawn, bi parambi)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.hST + "\"></strangerantispamticket>");
    localStringBuilder.append(bk.pm(bf.HQ()));
    if ((bk.bl(paramawn.svK)) || (!paramawn.svK.startsWith("<msgsource>"))) {}
    for (parambi = "<msgsource></msgsource>";; parambi = paramawn.svK)
    {
      paramawn.svK = parambi;
      paramawn.svK = paramawn.svK.replace("<msgsource>", localStringBuilder.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.i
 * JD-Core Version:    0.7.0.1
 */