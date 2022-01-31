package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean beQ()
  {
    return this.kyA;
  }
  
  public final boolean beR()
  {
    AppMethodBeat.i(88721);
    if ((this.klk.isNormal()) && (super.beR()) && ((this.klk.baY()) || (!bo.isNullOrNil(this.klk.bbe().code))))
    {
      AppMethodBeat.o(88721);
      return true;
    }
    AppMethodBeat.o(88721);
    return false;
  }
  
  public final boolean beS()
  {
    return true;
  }
  
  public final boolean beV()
  {
    AppMethodBeat.i(88722);
    if ((this.klk.isNormal()) && (super.beV()))
    {
      AppMethodBeat.o(88722);
      return true;
    }
    AppMethodBeat.o(88722);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.f
 * JD-Core Version:    0.7.0.1
 */