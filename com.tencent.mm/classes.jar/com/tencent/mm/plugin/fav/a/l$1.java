package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

final class l$1
  implements Runnable
{
  l$1(l paraml, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(103409);
    String str = bu.cH(this.rBe);
    g.ajR().ajA().set(225283, str);
    AppMethodBeat.o(103409);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103410);
    String str = super.toString() + "|save";
    AppMethodBeat.o(103410);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l.1
 * JD-Core Version:    0.7.0.1
 */