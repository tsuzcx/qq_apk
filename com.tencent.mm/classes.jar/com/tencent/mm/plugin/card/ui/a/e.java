package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bLH()
  {
    AppMethodBeat.i(113641);
    if ((this.nqp.bHC()) && (!l.zp(this.nzk.fsv)) && (this.nqp.bHR()) && (!this.nDT))
    {
      AppMethodBeat.o(113641);
      return false;
    }
    AppMethodBeat.o(113641);
    return true;
  }
  
  public final boolean bLL()
  {
    AppMethodBeat.i(113642);
    if ((this.nqp.bHC()) && (!l.zp(this.nzk.fsv)) && (this.nqp.bHR()) && (!this.nDT))
    {
      AppMethodBeat.o(113642);
      return true;
    }
    AppMethodBeat.o(113642);
    return false;
  }
  
  public final boolean bLM()
  {
    return this.nDT;
  }
  
  public final boolean bLO()
  {
    AppMethodBeat.i(113647);
    if ((this.nqp.bHV() != null) && (this.nqp.bHV().CSk))
    {
      AppMethodBeat.o(113647);
      return true;
    }
    AppMethodBeat.o(113647);
    return false;
  }
  
  public final boolean bLP()
  {
    AppMethodBeat.i(113643);
    if ((super.bLP()) || ((this.nqp.bHR()) && (!this.nDT) && ((bLw()) || (bLx()))))
    {
      AppMethodBeat.o(113643);
      return true;
    }
    AppMethodBeat.o(113643);
    return false;
  }
  
  public final boolean bLU()
  {
    AppMethodBeat.i(113645);
    if ((this.nqp.bHR()) && (super.bLU()) && (!bLO()))
    {
      AppMethodBeat.o(113645);
      return true;
    }
    AppMethodBeat.o(113645);
    return false;
  }
  
  public final boolean bLY()
  {
    AppMethodBeat.i(113644);
    if ((this.nqp.bHC()) && (this.nqp.bHV().CRW != null) && (this.nqp.bHR()) && (!this.nDT) && (!bLw()) && (!bLx()))
    {
      AppMethodBeat.o(113644);
      return true;
    }
    AppMethodBeat.o(113644);
    return false;
  }
  
  public final boolean bLz()
  {
    AppMethodBeat.i(113646);
    if ((super.bLz()) && (this.nqp.bHR()) && (!this.nDT) && (!bLw()) && (!bLx()))
    {
      AppMethodBeat.o(113646);
      return true;
    }
    AppMethodBeat.o(113646);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */