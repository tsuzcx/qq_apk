package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean cwJ()
  {
    return this.qeD;
  }
  
  public final boolean cwK()
  {
    AppMethodBeat.i(113648);
    if ((this.pQV.csM()) && (super.cwK()) && ((this.pQV.csK()) || (!Util.isNullOrNil(this.pQV.csR().code))))
    {
      AppMethodBeat.o(113648);
      return true;
    }
    AppMethodBeat.o(113648);
    return false;
  }
  
  public final boolean cwL()
  {
    return true;
  }
  
  public final boolean cwO()
  {
    AppMethodBeat.i(113649);
    if ((this.pQV.csM()) && (super.cwO()))
    {
      AppMethodBeat.o(113649);
      return true;
    }
    AppMethodBeat.o(113649);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.f
 * JD-Core Version:    0.7.0.1
 */