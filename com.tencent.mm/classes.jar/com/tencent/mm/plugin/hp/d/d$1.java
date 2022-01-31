package com.tencent.mm.plugin.hp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(90686);
    ab.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
    e.cO(d.bIz());
    AppMethodBeat.o(90686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.d.1
 * JD-Core Version:    0.7.0.1
 */