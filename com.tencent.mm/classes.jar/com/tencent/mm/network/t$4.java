package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bj;

final class t$4
  extends bj<Object>
{
  t$4(t paramt, String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    super(1000L, null, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(58554);
    MMLogic.setHostInfo(this.gdK, this.gdL, this.gdM);
    AppMethodBeat.o(58554);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.t.4
 * JD-Core Version:    0.7.0.1
 */