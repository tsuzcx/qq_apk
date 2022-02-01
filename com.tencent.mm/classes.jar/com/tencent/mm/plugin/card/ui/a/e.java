package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bSM()
  {
    AppMethodBeat.i(113646);
    if ((super.bSM()) && (this.nTp.bPe()) && (!this.ogU) && (!bSJ()) && (!bSK()))
    {
      AppMethodBeat.o(113646);
      return true;
    }
    AppMethodBeat.o(113646);
    return false;
  }
  
  public final boolean bSU()
  {
    AppMethodBeat.i(113641);
    if ((this.nTp.bOP()) && (!l.Ag(this.ocl.fwc)) && (this.nTp.bPe()) && (!this.ogU))
    {
      AppMethodBeat.o(113641);
      return false;
    }
    AppMethodBeat.o(113641);
    return true;
  }
  
  public final boolean bSY()
  {
    AppMethodBeat.i(113642);
    if ((this.nTp.bOP()) && (!l.Ag(this.ocl.fwc)) && (this.nTp.bPe()) && (!this.ogU))
    {
      AppMethodBeat.o(113642);
      return true;
    }
    AppMethodBeat.o(113642);
    return false;
  }
  
  public final boolean bSZ()
  {
    return this.ogU;
  }
  
  public final boolean bTb()
  {
    AppMethodBeat.i(113647);
    if ((this.nTp.bPi() != null) && (this.nTp.bPi().EkV))
    {
      AppMethodBeat.o(113647);
      return true;
    }
    AppMethodBeat.o(113647);
    return false;
  }
  
  public final boolean bTc()
  {
    AppMethodBeat.i(113643);
    if ((super.bTc()) || ((this.nTp.bPe()) && (!this.ogU) && ((bSJ()) || (bSK()))))
    {
      AppMethodBeat.o(113643);
      return true;
    }
    AppMethodBeat.o(113643);
    return false;
  }
  
  public final boolean bTh()
  {
    AppMethodBeat.i(113645);
    if ((this.nTp.bPe()) && (super.bTh()) && (!bTb()))
    {
      AppMethodBeat.o(113645);
      return true;
    }
    AppMethodBeat.o(113645);
    return false;
  }
  
  public final boolean bTl()
  {
    AppMethodBeat.i(113644);
    if ((this.nTp.bOP()) && (this.nTp.bPi().EkH != null) && (this.nTp.bPe()) && (!this.ogU) && (!bSJ()) && (!bSK()))
    {
      AppMethodBeat.o(113644);
      return true;
    }
    AppMethodBeat.o(113644);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */