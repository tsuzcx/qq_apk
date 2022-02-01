package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bXE()
  {
    return this.oKn;
  }
  
  public final boolean bXF()
  {
    AppMethodBeat.i(113648);
    if ((this.owK.bTJ()) && (super.bXF()) && ((this.owK.bTH()) || (!bt.isNullOrNil(this.owK.bTO().code))))
    {
      AppMethodBeat.o(113648);
      return true;
    }
    AppMethodBeat.o(113648);
    return false;
  }
  
  public final boolean bXG()
  {
    return true;
  }
  
  public final boolean bXJ()
  {
    AppMethodBeat.i(113649);
    if ((this.owK.bTJ()) && (super.bXJ()))
    {
      AppMethodBeat.o(113649);
      return true;
    }
    AppMethodBeat.o(113649);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.f
 * JD-Core Version:    0.7.0.1
 */