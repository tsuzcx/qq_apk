package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean dnC()
  {
    AppMethodBeat.i(293803);
    boolean bool = dmH();
    AppMethodBeat.o(293803);
    return bool;
  }
  
  public final boolean dnD()
  {
    AppMethodBeat.i(113648);
    if ((this.wru.djF()) && (super.dnD()) && ((this.wru.djD()) || (!Util.isNullOrNil(this.wru.djL().code))))
    {
      AppMethodBeat.o(113648);
      return true;
    }
    AppMethodBeat.o(113648);
    return false;
  }
  
  public final boolean dnE()
  {
    return true;
  }
  
  public final boolean dnH()
  {
    AppMethodBeat.i(113649);
    if ((this.wru.djF()) && (super.dnH()))
    {
      AppMethodBeat.o(113649);
      return true;
    }
    AppMethodBeat.o(113649);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.f
 * JD-Core Version:    0.7.0.1
 */