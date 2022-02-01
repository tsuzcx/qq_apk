package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class k
  implements o
{
  private String nOG = null;
  
  public k(String paramString)
  {
    this.nOG = paramString;
  }
  
  public final void a(byy parambyy, bu parambu)
  {
    AppMethodBeat.i(22365);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.nOG + "\"></strangerantispamticket>");
    localStringBuilder.append(bt.nullAsNil(bl.aCh()));
    if ((bt.isNullOrNil(parambyy.Fvn)) || (!parambyy.Fvn.startsWith("<msgsource>"))) {}
    for (parambu = "<msgsource></msgsource>";; parambu = parambyy.Fvn)
    {
      parambyy.Fvn = parambu;
      parambyy.Fvn = parambyy.Fvn.replace("<msgsource>", localStringBuilder.toString());
      AppMethodBeat.o(22365);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.k
 * JD-Core Version:    0.7.0.1
 */