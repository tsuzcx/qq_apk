package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

final class l$1
  implements Runnable
{
  l$1(l paraml, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(103409);
    String str = Util.encodeHexString(this.AcX);
    h.baE().ban().B(225283, str);
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