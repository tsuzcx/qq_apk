package com.tencent.mm.booter;

import android.app.job.JobParameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class KeepAliveService$1
  implements Runnable
{
  KeepAliveService$1(KeepAliveService paramKeepAliveService, JobParameters paramJobParameters) {}
  
  public final void run()
  {
    AppMethodBeat.i(57760);
    ab.i("MicroMsg.KeepAliveService", "onStartJob() delay");
    KeepAliveService.Ij();
    try
    {
      this.dYT.jobFinished(this.dYS, false);
      AppMethodBeat.o(57760);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.KeepAliveService", "onStartJob() jobFinished() Exception=%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(57760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.KeepAliveService.1
 * JD-Core Version:    0.7.0.1
 */