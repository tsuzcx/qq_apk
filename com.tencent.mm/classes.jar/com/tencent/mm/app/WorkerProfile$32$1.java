package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class WorkerProfile$32$1
  implements Runnable
{
  WorkerProfile$32$1(WorkerProfile.32 param32, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(15538);
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.WorkerProfile", "ImageSelectedOperationEvent: account not init.");
      AppMethodBeat.o(15538);
      return;
    }
    n.ahs().a(0, this.bZX, this.bZY, this.bZZ, this.caa);
    AppMethodBeat.o(15538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.32.1
 * JD-Core Version:    0.7.0.1
 */