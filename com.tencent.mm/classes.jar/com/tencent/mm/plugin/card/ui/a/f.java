package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bLM()
  {
    return this.nDT;
  }
  
  public final boolean bLN()
  {
    AppMethodBeat.i(113648);
    if ((this.nqp.bHR()) && (super.bLN()) && ((this.nqp.bHP()) || (!bt.isNullOrNil(this.nqp.bHW().code))))
    {
      AppMethodBeat.o(113648);
      return true;
    }
    AppMethodBeat.o(113648);
    return false;
  }
  
  public final boolean bLO()
  {
    return true;
  }
  
  public final boolean bLR()
  {
    AppMethodBeat.i(113649);
    if ((this.nqp.bHR()) && (super.bLR()))
    {
      AppMethodBeat.o(113649);
      return true;
    }
    AppMethodBeat.o(113649);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.f
 * JD-Core Version:    0.7.0.1
 */