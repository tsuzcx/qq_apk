package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean cKm()
  {
    AppMethodBeat.i(252229);
    boolean bool = cJq();
    AppMethodBeat.o(252229);
    return bool;
  }
  
  public final boolean cKn()
  {
    AppMethodBeat.i(113648);
    if ((this.tmU.cGn()) && (super.cKn()) && ((this.tmU.cGl()) || (!Util.isNullOrNil(this.tmU.cGt().code))))
    {
      AppMethodBeat.o(113648);
      return true;
    }
    AppMethodBeat.o(113648);
    return false;
  }
  
  public final boolean cKo()
  {
    return true;
  }
  
  public final boolean cKr()
  {
    AppMethodBeat.i(113649);
    if ((this.tmU.cGn()) && (super.cKr()))
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