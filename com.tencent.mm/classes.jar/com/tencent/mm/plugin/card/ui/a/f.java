package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bYT()
  {
    return this.oQP;
  }
  
  public final boolean bYU()
  {
    AppMethodBeat.i(113648);
    if ((this.oDm.bUY()) && (super.bYU()) && ((this.oDm.bUW()) || (!bu.isNullOrNil(this.oDm.bVd().code))))
    {
      AppMethodBeat.o(113648);
      return true;
    }
    AppMethodBeat.o(113648);
    return false;
  }
  
  public final boolean bYV()
  {
    return true;
  }
  
  public final boolean bYY()
  {
    AppMethodBeat.i(113649);
    if ((this.oDm.bUY()) && (super.bYY()))
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