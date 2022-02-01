package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.report.b.d;
import com.tencent.mm.sdk.platformtools.Log;

final class WorkerProfile$28
  implements Runnable
{
  WorkerProfile$28(WorkerProfile paramWorkerProfile, int paramInt, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(19584);
    if (bh.beB())
    {
      AppMethodBeat.o(19584);
      return;
    }
    Log.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + this.ffT);
    d locald = new d(this.ffU, this.ffT);
    bh.aGY().a(locald, 0);
    AppMethodBeat.o(19584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.28
 * JD-Core Version:    0.7.0.1
 */