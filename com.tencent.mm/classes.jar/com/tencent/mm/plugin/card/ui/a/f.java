package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bSZ()
  {
    return this.ogU;
  }
  
  public final boolean bTa()
  {
    AppMethodBeat.i(113648);
    if ((this.nTp.bPe()) && (super.bTa()) && ((this.nTp.bPc()) || (!bs.isNullOrNil(this.nTp.bPj().code))))
    {
      AppMethodBeat.o(113648);
      return true;
    }
    AppMethodBeat.o(113648);
    return false;
  }
  
  public final boolean bTb()
  {
    return true;
  }
  
  public final boolean bTe()
  {
    AppMethodBeat.i(113649);
    if ((this.nTp.bPe()) && (super.bTe()))
    {
      AppMethodBeat.o(113649);
      return true;
    }
    AppMethodBeat.o(113649);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.f
 * JD-Core Version:    0.7.0.1
 */