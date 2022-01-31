package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bj;

final class t$11
  extends bj<Object>
{
  t$11(t paramt, Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(58561);
    MMLogic.setDebugIP(this.gdW, this.gdX, this.gdY, this.gdZ);
    BaseEvent.onNetworkChange();
    AppMethodBeat.o(58561);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.t.11
 * JD-Core Version:    0.7.0.1
 */