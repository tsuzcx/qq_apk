package com.tencent.mm.network;

import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bj;

public final class t$13
  extends bj<Object>
{
  public t$13(t paramt, String paramString1, String paramString2)
  {
    super(1000L, null, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(58563);
    StnLogic.setDebugIP(this.gec, this.gea);
    AppMethodBeat.o(58563);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.network.t.13
 * JD-Core Version:    0.7.0.1
 */