package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bXD()
  {
    AppMethodBeat.i(113642);
    if ((this.owK.bTu()) && (!l.AP(this.oFE.fPp)) && (this.owK.bTJ()) && (!this.oKn))
    {
      AppMethodBeat.o(113642);
      return true;
    }
    AppMethodBeat.o(113642);
    return false;
  }
  
  public final boolean bXE()
  {
    return this.oKn;
  }
  
  public final boolean bXG()
  {
    AppMethodBeat.i(113647);
    if ((this.owK.bTN() != null) && (this.owK.bTN().FSe))
    {
      AppMethodBeat.o(113647);
      return true;
    }
    AppMethodBeat.o(113647);
    return false;
  }
  
  public final boolean bXH()
  {
    AppMethodBeat.i(113643);
    if ((super.bXH()) || ((this.owK.bTJ()) && (!this.oKn) && ((bXo()) || (bXp()))))
    {
      AppMethodBeat.o(113643);
      return true;
    }
    AppMethodBeat.o(113643);
    return false;
  }
  
  public final boolean bXM()
  {
    AppMethodBeat.i(113645);
    if ((this.owK.bTJ()) && (super.bXM()) && (!bXG()))
    {
      AppMethodBeat.o(113645);
      return true;
    }
    AppMethodBeat.o(113645);
    return false;
  }
  
  public final boolean bXQ()
  {
    AppMethodBeat.i(113644);
    if ((this.owK.bTu()) && (this.owK.bTN().FRQ != null) && (this.owK.bTJ()) && (!this.oKn) && (!bXo()) && (!bXp()))
    {
      AppMethodBeat.o(113644);
      return true;
    }
    AppMethodBeat.o(113644);
    return false;
  }
  
  public final boolean bXr()
  {
    AppMethodBeat.i(113646);
    if ((super.bXr()) && (this.owK.bTJ()) && (!this.oKn) && (!bXo()) && (!bXp()))
    {
      AppMethodBeat.o(113646);
      return true;
    }
    AppMethodBeat.o(113646);
    return false;
  }
  
  public final boolean bXz()
  {
    AppMethodBeat.i(113641);
    if ((this.owK.bTu()) && (!l.AP(this.oFE.fPp)) && (this.owK.bTJ()) && (!this.oKn))
    {
      AppMethodBeat.o(113641);
      return false;
    }
    AppMethodBeat.o(113641);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */