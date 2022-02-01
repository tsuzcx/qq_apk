package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean cJY()
  {
    AppMethodBeat.i(113646);
    if ((super.cJY()) && (this.tmU.cGn()) && (!cJq()) && (!cJV()) && (!cJW()))
    {
      AppMethodBeat.o(113646);
      return true;
    }
    AppMethodBeat.o(113646);
    return false;
  }
  
  public final boolean cKh()
  {
    AppMethodBeat.i(113641);
    if ((this.tmU.cFY()) && (!l.Ik(this.tvQ.jaR)) && (this.tmU.cGn()) && (!cJq()))
    {
      AppMethodBeat.o(113641);
      return false;
    }
    AppMethodBeat.o(113641);
    return true;
  }
  
  public final boolean cKl()
  {
    AppMethodBeat.i(113642);
    if ((this.tmU.cFY()) && (!l.Ik(this.tvQ.jaR)) && (this.tmU.cGn()) && (!cJq()))
    {
      AppMethodBeat.o(113642);
      return true;
    }
    AppMethodBeat.o(113642);
    return false;
  }
  
  public final boolean cKm()
  {
    AppMethodBeat.i(250681);
    boolean bool = cJq();
    AppMethodBeat.o(250681);
    return bool;
  }
  
  public final boolean cKo()
  {
    AppMethodBeat.i(113647);
    if ((this.tmU.cGs() != null) && (this.tmU.cGs().Sgu))
    {
      AppMethodBeat.o(113647);
      return true;
    }
    AppMethodBeat.o(113647);
    return false;
  }
  
  public final boolean cKp()
  {
    AppMethodBeat.i(113643);
    if ((super.cKp()) || ((this.tmU.cGn()) && (!cJq()) && ((cJV()) || (cJW()))))
    {
      AppMethodBeat.o(113643);
      return true;
    }
    AppMethodBeat.o(113643);
    return false;
  }
  
  public final boolean cKu()
  {
    AppMethodBeat.i(113645);
    if ((this.tmU.cGn()) && (super.cKu()) && (!cKo()))
    {
      AppMethodBeat.o(113645);
      return true;
    }
    AppMethodBeat.o(113645);
    return false;
  }
  
  public final boolean cKy()
  {
    AppMethodBeat.i(113644);
    if ((this.tmU.cFY()) && (this.tmU.cGs().Sgg != null) && (this.tmU.cGn()) && (!cJq()) && (!cJV()) && (!cJW()))
    {
      AppMethodBeat.o(113644);
      return true;
    }
    AppMethodBeat.o(113644);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */