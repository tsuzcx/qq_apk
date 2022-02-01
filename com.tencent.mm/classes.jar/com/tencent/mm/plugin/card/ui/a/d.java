package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends a
{
  public d(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bLP()
  {
    return false;
  }
  
  public final boolean bLR()
  {
    return false;
  }
  
  public final boolean bLS()
  {
    AppMethodBeat.i(113640);
    if ((this.nqp.bHW().CPE != null) && (this.nDT) && (bLt()) && (bLu()))
    {
      AppMethodBeat.o(113640);
      return true;
    }
    AppMethodBeat.o(113640);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.d
 * JD-Core Version:    0.7.0.1
 */