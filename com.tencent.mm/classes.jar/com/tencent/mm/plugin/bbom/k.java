package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bn;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class k
  implements o
{
  private String nUm = null;
  
  public k(String paramString)
  {
    this.nUm = paramString;
  }
  
  public final void a(bzs parambzs, bv parambv)
  {
    AppMethodBeat.i(22365);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.nUm + "\"></strangerantispamticket>");
    localStringBuilder.append(bu.nullAsNil(bn.aCx()));
    if ((bu.isNullOrNil(parambzs.FNL)) || (!parambzs.FNL.startsWith("<msgsource>"))) {}
    for (parambv = "<msgsource></msgsource>";; parambv = parambzs.FNL)
    {
      parambzs.FNL = parambv;
      parambzs.FNL = parambzs.FNL.replace("<msgsource>", localStringBuilder.toString());
      AppMethodBeat.o(22365);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.k
 * JD-Core Version:    0.7.0.1
 */