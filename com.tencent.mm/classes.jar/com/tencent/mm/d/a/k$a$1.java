package com.tencent.mm.d.a;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class k$a$1
  implements Runnable
{
  k$a$1(k.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(113828);
    ab.i("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release");
    if (this.cbB.cbA == null)
    {
      ab.i("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release mV8Buffer null");
      AppMethodBeat.o(113828);
      return;
    }
    this.cbB.cbA.manualRelease();
    AppMethodBeat.o(113828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.k.a.1
 * JD-Core Version:    0.7.0.1
 */