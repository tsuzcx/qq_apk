package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public final class c
  extends a
{
  public c(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bLM()
  {
    return this.nDT;
  }
  
  public final boolean bLP()
  {
    return false;
  }
  
  public final boolean bLQ()
  {
    AppMethodBeat.i(113639);
    if ((this.nDT) && (super.bLQ()))
    {
      AppMethodBeat.o(113639);
      return true;
    }
    AppMethodBeat.o(113639);
    return false;
  }
  
  public final boolean bLU()
  {
    return false;
  }
  
  public final boolean bLV()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.c
 * JD-Core Version:    0.7.0.1
 */