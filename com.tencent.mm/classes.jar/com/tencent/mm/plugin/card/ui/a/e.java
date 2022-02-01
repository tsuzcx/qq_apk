package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean cwE()
  {
    AppMethodBeat.i(113641);
    if ((this.pQV.csx()) && (!l.EJ(this.pZU.gwE)) && (this.pQV.csM()) && (!this.qeD))
    {
      AppMethodBeat.o(113641);
      return false;
    }
    AppMethodBeat.o(113641);
    return true;
  }
  
  public final boolean cwI()
  {
    AppMethodBeat.i(113642);
    if ((this.pQV.csx()) && (!l.EJ(this.pZU.gwE)) && (this.pQV.csM()) && (!this.qeD))
    {
      AppMethodBeat.o(113642);
      return true;
    }
    AppMethodBeat.o(113642);
    return false;
  }
  
  public final boolean cwJ()
  {
    return this.qeD;
  }
  
  public final boolean cwL()
  {
    AppMethodBeat.i(113647);
    if ((this.pQV.csQ() != null) && (this.pQV.csQ().Lfg))
    {
      AppMethodBeat.o(113647);
      return true;
    }
    AppMethodBeat.o(113647);
    return false;
  }
  
  public final boolean cwM()
  {
    AppMethodBeat.i(113643);
    if ((super.cwM()) || ((this.pQV.csM()) && (!this.qeD) && ((cwt()) || (cwu()))))
    {
      AppMethodBeat.o(113643);
      return true;
    }
    AppMethodBeat.o(113643);
    return false;
  }
  
  public final boolean cwR()
  {
    AppMethodBeat.i(113645);
    if ((this.pQV.csM()) && (super.cwR()) && (!cwL()))
    {
      AppMethodBeat.o(113645);
      return true;
    }
    AppMethodBeat.o(113645);
    return false;
  }
  
  public final boolean cwV()
  {
    AppMethodBeat.i(113644);
    if ((this.pQV.csx()) && (this.pQV.csQ().LeS != null) && (this.pQV.csM()) && (!this.qeD) && (!cwt()) && (!cwu()))
    {
      AppMethodBeat.o(113644);
      return true;
    }
    AppMethodBeat.o(113644);
    return false;
  }
  
  public final boolean cww()
  {
    AppMethodBeat.i(113646);
    if ((super.cww()) && (this.pQV.csM()) && (!this.qeD) && (!cwt()) && (!cwu()))
    {
      AppMethodBeat.o(113646);
      return true;
    }
    AppMethodBeat.o(113646);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */