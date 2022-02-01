package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends a
{
  public d(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean cKp()
  {
    return false;
  }
  
  public final boolean cKr()
  {
    return false;
  }
  
  public final boolean cKs()
  {
    AppMethodBeat.i(113640);
    if ((this.tmU.cGt().SdO != null) && (cJq()) && (cJS()) && (cJT()))
    {
      AppMethodBeat.o(113640);
      return true;
    }
    AppMethodBeat.o(113640);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.d
 * JD-Core Version:    0.7.0.1
 */