package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.e;
import com.tencent.mm.plugin.choosemsgfile.b.b.j;
import com.tencent.mm.vending.e.b;

public final class d
  extends c
{
  private int sL;
  private int zP;
  
  public d(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    super(parama, parama1, paramb);
    AppMethodBeat.i(123229);
    this.zP = 0;
    this.sL = parama.cMO();
    AppMethodBeat.o(123229);
  }
  
  private boolean cML()
  {
    if ((this.tMc instanceof j)) {
      throw null;
    }
    if ((this.tMc instanceof e)) {
      throw null;
    }
    return false;
  }
  
  protected final boolean cMI()
  {
    AppMethodBeat.i(123230);
    cML();
    boolean bool = cML();
    AppMethodBeat.o(123230);
    return bool;
  }
  
  protected final void ccd()
  {
    AppMethodBeat.i(123231);
    if ((this.tMc instanceof j))
    {
      AppMethodBeat.o(123231);
      throw null;
    }
    if ((this.tMc instanceof e))
    {
      AppMethodBeat.o(123231);
      throw null;
    }
    if ((this.tMc instanceof j))
    {
      AppMethodBeat.o(123231);
      throw null;
    }
    if ((this.tMc instanceof e))
    {
      AppMethodBeat.o(123231);
      throw null;
    }
    cMK();
    AppMethodBeat.o(123231);
  }
  
  protected final boolean checkValid()
  {
    if ((this.tMc instanceof j)) {
      throw null;
    }
    if ((this.tMc instanceof e)) {
      throw null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.d
 * JD-Core Version:    0.7.0.1
 */