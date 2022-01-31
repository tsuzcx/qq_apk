package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.b.e;
import com.tencent.mm.sdk.platformtools.ab;

final class WorkerProfile$29
  implements Runnable
{
  WorkerProfile$29(WorkerProfile paramWorkerProfile, int paramInt, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(138602);
    if (aw.aas())
    {
      AppMethodBeat.o(138602);
      return;
    }
    ab.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + this.bZV);
    e locale = new e(this.bZW, this.bZV);
    aw.Rc().a(locale, 0);
    AppMethodBeat.o(138602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.29
 * JD-Core Version:    0.7.0.1
 */