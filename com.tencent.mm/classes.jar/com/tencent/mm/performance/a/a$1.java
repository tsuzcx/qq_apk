package com.tencent.mm.performance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class a$1
  implements Runnable
{
  a$1(a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(145557);
    ad.i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", new Object[] { this.hQB.l(true, this.hQA) });
    AppMethodBeat.o(145557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.performance.a.a.1
 * JD-Core Version:    0.7.0.1
 */