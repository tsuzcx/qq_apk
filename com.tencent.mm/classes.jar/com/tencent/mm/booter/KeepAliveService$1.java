package com.tencent.mm.booter;

import android.app.job.JobParameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class KeepAliveService$1
  implements Runnable
{
  KeepAliveService$1(KeepAliveService paramKeepAliveService, JobParameters paramJobParameters) {}
  
  public final void run()
  {
    AppMethodBeat.i(131876);
    ad.i("MicroMsg.KeepAliveService", "onStartJob() delay");
    KeepAliveService.WF();
    try
    {
      this.fEh.jobFinished(this.fEg, false);
      AppMethodBeat.o(131876);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.KeepAliveService", "onStartJob() jobFinished() Exception=%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(131876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.KeepAliveService.1
 * JD-Core Version:    0.7.0.1
 */