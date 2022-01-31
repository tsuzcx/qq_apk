package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class i
  implements m
{
  private String jMG = null;
  
  public i(String paramString)
  {
    this.jMG = paramString;
  }
  
  public final void a(bdc parambdc, bi parambi)
  {
    AppMethodBeat.i(18259);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.jMG + "\"></strangerantispamticket>");
    localStringBuilder.append(bo.nullAsNil(bh.aaP()));
    if ((bo.isNullOrNil(parambdc.woU)) || (!parambdc.woU.startsWith("<msgsource>"))) {}
    for (parambi = "<msgsource></msgsource>";; parambi = parambdc.woU)
    {
      parambdc.woU = parambi;
      parambdc.woU = parambdc.woU.replace("<msgsource>", localStringBuilder.toString());
      AppMethodBeat.o(18259);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.i
 * JD-Core Version:    0.7.0.1
 */