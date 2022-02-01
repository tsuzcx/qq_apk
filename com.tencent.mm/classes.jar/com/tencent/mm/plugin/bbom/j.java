package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class j
  implements n
{
  private String mLJ = null;
  
  public j(String paramString)
  {
    this.mLJ = paramString;
  }
  
  public final void a(bps parambps, bl parambl)
  {
    AppMethodBeat.i(22365);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.mLJ + "\"></strangerantispamticket>");
    localStringBuilder.append(bt.nullAsNil(bk.asm()));
    if ((bt.isNullOrNil(parambps.CxC)) || (!parambps.CxC.startsWith("<msgsource>"))) {}
    for (parambl = "<msgsource></msgsource>";; parambl = parambps.CxC)
    {
      parambps.CxC = parambl;
      parambps.CxC = parambps.CxC.replace("<msgsource>", localStringBuilder.toString());
      AppMethodBeat.o(22365);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */