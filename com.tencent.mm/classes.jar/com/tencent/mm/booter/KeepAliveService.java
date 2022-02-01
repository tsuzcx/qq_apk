package com.tencent.mm.booter;

import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.sdk.platformtools.aj;

public class KeepAliveService
  extends JobService
{
  public static long fiE;
  
  static
  {
    AppMethodBeat.i(131881);
    if (d.lf(23))
    {
      fiE = 590000L;
      AppMethodBeat.o(131881);
      return;
    }
    fiE = 50000L;
    AppMethodBeat.o(131881);
  }
  
  public static boolean Tu()
  {
    AppMethodBeat.i(131880);
    if (com.tencent.mm.kernel.a.Yf().getBoolean("keepaliveserviceswitch", false))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.KeepAliveService", "scheduleCoreScheduleJob(), time = %d", new Object[] { Long.valueOf(fiE) });
      try
      {
        JobInfo.Builder localBuilder = new JobInfo.Builder(1, new ComponentName(aj.getContext(), KeepAliveService.class));
        localBuilder.setMinimumLatency(0L);
        localBuilder.setOverrideDeadline(10L);
        localBuilder.setRequiredNetworkType(1);
        localBuilder.setRequiresDeviceIdle(false);
        localBuilder.setRequiresCharging(false);
        ((JobScheduler)aj.getContext().getSystemService("jobscheduler")).schedule(localBuilder.build());
        AppMethodBeat.o(131880);
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.KeepAliveService", "scheduleKeepAliveJob() Exception:%s" + localException.getMessage());
        }
      }
    }
    AppMethodBeat.o(131880);
    return false;
  }
  
  public boolean onStartJob(final JobParameters paramJobParameters)
  {
    AppMethodBeat.i(131878);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.KeepAliveService", "onStartJob()");
    if (com.tencent.mm.network.ad.aFo() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.KeepAliveService", "onStarJob() MMPushCore.getAutoAuth() == null");
      b.c(aj.getContext(), "jobservice", true);
    }
    new Handler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131876);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.KeepAliveService", "onStartJob() delay");
        KeepAliveService.Tu();
        try
        {
          KeepAliveService.this.jobFinished(paramJobParameters, false);
          AppMethodBeat.o(131876);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.KeepAliveService", "onStartJob() jobFinished() Exception=%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(131876);
        }
      }
    }, fiE);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.KeepAliveService", "onReceive() delay publish PushKeepAliveEvent");
    h.Iye.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131877);
        oq localoq = new oq();
        com.tencent.mm.sdk.b.a.ESL.a(localoq, Looper.getMainLooper());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.KeepAliveService", "onReceive() publish PushKeepAliveEvent");
        AppMethodBeat.o(131877);
      }
    }, 60000L);
    AppMethodBeat.o(131878);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    AppMethodBeat.i(131879);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.KeepAliveService", "onStopJob()");
    AppMethodBeat.o(131879);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.KeepAliveService
 * JD-Core Version:    0.7.0.1
 */