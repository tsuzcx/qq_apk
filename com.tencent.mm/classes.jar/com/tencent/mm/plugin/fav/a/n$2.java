package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class n$2
  implements Runnable
{
  n$2(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(102701);
    this.muc.lastShakeTime = bo.yB();
    AppMethodBeat.o(102701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n.2
 * JD-Core Version:    0.7.0.1
 */