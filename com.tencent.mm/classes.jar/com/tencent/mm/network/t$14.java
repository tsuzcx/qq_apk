package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bj;

final class t$14
  extends bj<Object>
{
  t$14(t paramt, Object paramObject)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(58564);
    BaseEvent.onNetworkChange();
    AppMethodBeat.o(58564);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.network.t.14
 * JD-Core Version:    0.7.0.1
 */