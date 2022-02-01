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
  
  public final boolean bSZ()
  {
    return this.ogU;
  }
  
  public final boolean bTc()
  {
    return false;
  }
  
  public final boolean bTd()
  {
    AppMethodBeat.i(113639);
    if ((this.ogU) && (super.bTd()))
    {
      AppMethodBeat.o(113639);
      return true;
    }
    AppMethodBeat.o(113639);
    return false;
  }
  
  public final boolean bTh()
  {
    return false;
  }
  
  public final boolean bTi()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.c
 * JD-Core Version:    0.7.0.1
 */