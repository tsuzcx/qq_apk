package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class k
  implements o
{
  private String pfa = null;
  
  public k(String paramString)
  {
    this.pfa = paramString;
  }
  
  public final void a(cot paramcot, ca paramca)
  {
    AppMethodBeat.i(22365);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.pfa + "\"></strangerantispamticket>");
    localStringBuilder.append(Util.nullAsNil(br.aVV()));
    if ((Util.isNullOrNil(paramcot.KHq)) || (!paramcot.KHq.startsWith("<msgsource>"))) {}
    for (paramca = "<msgsource></msgsource>";; paramca = paramcot.KHq)
    {
      paramcot.KHq = paramca;
      paramcot.KHq = paramcot.KHq.replace("<msgsource>", localStringBuilder.toString());
      AppMethodBeat.o(22365);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.k
 * JD-Core Version:    0.7.0.1
 */