package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public final class k
  implements q
{
  private String vsZ = null;
  
  public k(String paramString)
  {
    this.vsZ = paramString;
  }
  
  public final void a(don paramdon, cc paramcc)
  {
    AppMethodBeat.i(22365);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.vsZ + "\"></strangerantispamticket>");
    localStringBuilder.append(Util.nullAsNil(bt.bCP()));
    if ((Util.isNullOrNil(paramdon.YFJ)) || (!paramdon.YFJ.startsWith("<msgsource>"))) {}
    for (paramcc = "<msgsource></msgsource>";; paramcc = paramdon.YFJ)
    {
      paramdon.YFJ = paramcc;
      paramdon.YFJ = paramdon.YFJ.replace("<msgsource>", localStringBuilder.toString());
      AppMethodBeat.o(22365);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.k
 * JD-Core Version:    0.7.0.1
 */