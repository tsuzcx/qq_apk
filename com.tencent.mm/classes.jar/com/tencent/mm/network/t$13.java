package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class t$13
  extends bo<Object>
{
  t$13(t paramt, String paramString1, String paramString2)
  {
    super(1000L, null, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(132785);
    MMLogic.setNewDnsDebugHost(this.val$ip, this.hLD);
    AppMethodBeat.o(132785);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.t.13
 * JD-Core Version:    0.7.0.1
 */