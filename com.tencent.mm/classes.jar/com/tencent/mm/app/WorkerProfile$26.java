package com.tencent.mm.app;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.b.e;
import com.tencent.mm.sdk.platformtools.y;

final class WorkerProfile$26
  implements Runnable
{
  WorkerProfile$26(WorkerProfile paramWorkerProfile, int paramInt, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    if (au.Hp()) {
      return;
    }
    y.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + this.bxT);
    e locale = new e(this.bxU, this.bxT);
    au.Dk().a(locale, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.26
 * JD-Core Version:    0.7.0.1
 */