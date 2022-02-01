package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class j
  implements n
{
  private String nnS = null;
  
  public j(String paramString)
  {
    this.nnS = paramString;
  }
  
  public final void a(buj parambuj, bo parambo)
  {
    AppMethodBeat.i(22365);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.nnS + "\"></strangerantispamticket>");
    localStringBuilder.append(bs.nullAsNil(bk.azd()));
    if ((bs.isNullOrNil(parambuj.DPY)) || (!parambuj.DPY.startsWith("<msgsource>"))) {}
    for (parambo = "<msgsource></msgsource>";; parambo = parambuj.DPY)
    {
      parambuj.DPY = parambo;
      parambuj.DPY = parambuj.DPY.replace("<msgsource>", localStringBuilder.toString());
      AppMethodBeat.o(22365);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */