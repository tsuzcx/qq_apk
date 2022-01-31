package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean beD()
  {
    AppMethodBeat.i(88719);
    if ((super.beD()) && (this.klk.isNormal()) && (!this.kyA) && (!beA()) && (!beB()))
    {
      AppMethodBeat.o(88719);
      return true;
    }
    AppMethodBeat.o(88719);
    return false;
  }
  
  public final boolean beL()
  {
    AppMethodBeat.i(88714);
    if ((this.klk.baL()) && (!l.tv(this.ktU.ejF)) && (this.klk.isNormal()) && (!this.kyA))
    {
      AppMethodBeat.o(88714);
      return false;
    }
    AppMethodBeat.o(88714);
    return true;
  }
  
  public final boolean beP()
  {
    AppMethodBeat.i(88715);
    if ((this.klk.baL()) && (!l.tv(this.ktU.ejF)) && (this.klk.isNormal()) && (!this.kyA))
    {
      AppMethodBeat.o(88715);
      return true;
    }
    AppMethodBeat.o(88715);
    return false;
  }
  
  public final boolean beQ()
  {
    return this.kyA;
  }
  
  public final boolean beS()
  {
    AppMethodBeat.i(88720);
    if ((this.klk.bbd() != null) && (this.klk.bbd().wGF))
    {
      AppMethodBeat.o(88720);
      return true;
    }
    AppMethodBeat.o(88720);
    return false;
  }
  
  public final boolean beT()
  {
    AppMethodBeat.i(88716);
    if ((super.beT()) || ((this.klk.isNormal()) && (!this.kyA) && ((beA()) || (beB()))))
    {
      AppMethodBeat.o(88716);
      return true;
    }
    AppMethodBeat.o(88716);
    return false;
  }
  
  public final boolean beY()
  {
    AppMethodBeat.i(88718);
    if ((this.klk.isNormal()) && (super.beY()) && (!beS()))
    {
      AppMethodBeat.o(88718);
      return true;
    }
    AppMethodBeat.o(88718);
    return false;
  }
  
  public final boolean bfc()
  {
    AppMethodBeat.i(88717);
    if ((this.klk.baL()) && (this.klk.bbd().wGr != null) && (this.klk.isNormal()) && (!this.kyA) && (!beA()) && (!beB()))
    {
      AppMethodBeat.o(88717);
      return true;
    }
    AppMethodBeat.o(88717);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */