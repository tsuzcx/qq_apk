package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class n$1
  implements Runnable
{
  n$1(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(102700);
    this.muc.lastShakeTime = bo.yB();
    AppMethodBeat.o(102700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n.1
 * JD-Core Version:    0.7.0.1
 */