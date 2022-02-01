package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bYG()
  {
    AppMethodBeat.i(113646);
    if ((super.bYG()) && (this.oDm.bUY()) && (!this.oQP) && (!bYD()) && (!bYE()))
    {
      AppMethodBeat.o(113646);
      return true;
    }
    AppMethodBeat.o(113646);
    return false;
  }
  
  public final boolean bYO()
  {
    AppMethodBeat.i(113641);
    if ((this.oDm.bUJ()) && (!l.Bb(this.oMg.fRv)) && (this.oDm.bUY()) && (!this.oQP))
    {
      AppMethodBeat.o(113641);
      return false;
    }
    AppMethodBeat.o(113641);
    return true;
  }
  
  public final boolean bYS()
  {
    AppMethodBeat.i(113642);
    if ((this.oDm.bUJ()) && (!l.Bb(this.oMg.fRv)) && (this.oDm.bUY()) && (!this.oQP))
    {
      AppMethodBeat.o(113642);
      return true;
    }
    AppMethodBeat.o(113642);
    return false;
  }
  
  public final boolean bYT()
  {
    return this.oQP;
  }
  
  public final boolean bYV()
  {
    AppMethodBeat.i(113647);
    if ((this.oDm.bVc() != null) && (this.oDm.bVc().GkD))
    {
      AppMethodBeat.o(113647);
      return true;
    }
    AppMethodBeat.o(113647);
    return false;
  }
  
  public final boolean bYW()
  {
    AppMethodBeat.i(113643);
    if ((super.bYW()) || ((this.oDm.bUY()) && (!this.oQP) && ((bYD()) || (bYE()))))
    {
      AppMethodBeat.o(113643);
      return true;
    }
    AppMethodBeat.o(113643);
    return false;
  }
  
  public final boolean bZb()
  {
    AppMethodBeat.i(113645);
    if ((this.oDm.bUY()) && (super.bZb()) && (!bYV()))
    {
      AppMethodBeat.o(113645);
      return true;
    }
    AppMethodBeat.o(113645);
    return false;
  }
  
  public final boolean bZf()
  {
    AppMethodBeat.i(113644);
    if ((this.oDm.bUJ()) && (this.oDm.bVc().Gkp != null) && (this.oDm.bUY()) && (!this.oQP) && (!bYD()) && (!bYE()))
    {
      AppMethodBeat.o(113644);
      return true;
    }
    AppMethodBeat.o(113644);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */