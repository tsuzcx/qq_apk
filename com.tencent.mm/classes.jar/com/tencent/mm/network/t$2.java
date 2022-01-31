package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;

final class t$2
  extends bj<Object>
{
  t$2(t paramt, String paramString)
  {
    super(1000L, null, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(58552);
    ab.dsI();
    IPxxLogic.onIPxx(this.gdJ, 0);
    AppMethodBeat.o(58552);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.t.2
 * JD-Core Version:    0.7.0.1
 */