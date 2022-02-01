package com.tencent.mm.network;

import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class t$14
  extends bo<Object>
{
  public t$14(t paramt, String paramString1, String paramString2)
  {
    super(1000L, null, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(132786);
    StnLogic.setDebugIP(this.iFr, this.val$ip);
    AppMethodBeat.o(132786);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.t.14
 * JD-Core Version:    0.7.0.1
 */