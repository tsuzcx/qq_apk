package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class k
  implements q
{
  private String she = null;
  
  public k(String paramString)
  {
    this.she = paramString;
  }
  
  public final void a(cxi paramcxi, ca paramca)
  {
    AppMethodBeat.i(22365);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.she + "\"></strangerantispamticket>");
    localStringBuilder.append(Util.nullAsNil(bs.beY()));
    if ((Util.isNullOrNil(paramcxi.RII)) || (!paramcxi.RII.startsWith("<msgsource>"))) {}
    for (paramca = "<msgsource></msgsource>";; paramca = paramcxi.RII)
    {
      paramcxi.RII = paramca;
      paramcxi.RII = paramcxi.RII.replace("<msgsource>", localStringBuilder.toString());
      AppMethodBeat.o(22365);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.k
 * JD-Core Version:    0.7.0.1
 */