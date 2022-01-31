package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bj;

final class t$9
  extends bj<Object>
{
  t$9(t paramt, Object paramObject, boolean paramBoolean)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(58559);
    BaseEvent.onForeground(this.gdR);
    a.cW(this.gdR);
    b.cP(this.gdR);
    AppMethodBeat.o(58559);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.t.9
 * JD-Core Version:    0.7.0.1
 */